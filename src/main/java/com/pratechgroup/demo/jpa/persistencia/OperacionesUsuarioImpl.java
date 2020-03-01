package com.pratechgroup.demo.jpa.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.pratechgroup.demo.jpa.entidades.Customer;
import com.pratechgroup.demo.negocio.casosuso.OperacionesUsuario;
import com.pratechgroup.demo.negocio.entidades.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OperacionesUsuarioImpl implements OperacionesUsuario {

	private CustomerRepository customerRepository;

	public OperacionesUsuarioImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Mono<Usuario> guardar(Usuario usuario) {
		Customer cust = convertiraEntidadJpa(usuario);
		Mono<Customer> mono = Mono.just(customerRepository.save(cust));
		return mono.map(value -> {
			usuario.setId(value.getId());
			return usuario;
		});
	}

	@Override
	public Flux<Usuario> consultarTodosLosUsuarios() {
		List<Usuario> users = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> users.add(convertirEntidadNegocio(customer)));
		return Flux.fromArray(users.toArray(new Usuario[users.size()]));
	}

	@Override
	public Mono<Void> borrarUsuario(Usuario usuario) {
		customerRepository.deleteById(usuario.getId());
		return Mono.empty();
	}

	@Override
	public Mono<Long> contarUsuarios() {
		return Mono.just(customerRepository.count());
	}

	Usuario convertirEntidadNegocio(Customer customer) {
		Usuario u = new Usuario();
		u.setApellidos(customer.getLastName());
		u.setDireccion(customer.getAddres());
		u.setFechaNacimiento(customer.getDateOfBirth());
		u.setGenero(customer.getGender());
		u.setId(customer.getId());
		u.setIdentificacion(customer.getNroId());
		u.setNombres(customer.getFirstName());
		u.setTelefono(customer.getPhone());
		u.setTipoIdentificacion(customer.getIdType());
		return u;
	}

	Customer convertiraEntidadJpa(Usuario user) {
		Customer c = new Customer();
		c.setAddres(user.getDireccion());
		c.setDateOfBirth(user.getFechaNacimiento());
		c.setFirstName(user.getNombres());
		c.setLastName(user.getApellidos());
		c.setGender(user.getGenero());
		c.setIdType(user.getTipoIdentificacion());
		c.setNroId(user.getIdentificacion());
		c.setPhone(user.getTelefono());
		return c;
	}

}
