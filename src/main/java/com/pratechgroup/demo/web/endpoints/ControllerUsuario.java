package com.pratechgroup.demo.web.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratechgroup.demo.negocio.casosuso.CasoUsoUsuario;
import com.pratechgroup.demo.negocio.casosuso.OperacionesUsuario;
import com.pratechgroup.demo.negocio.entidades.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ControllerUsuario {

	private CasoUsoUsuario casoUsoUsuario;

	@Autowired
	public ControllerUsuario(OperacionesUsuario operaciones) {
		this.casoUsoUsuario = new CasoUsoUsuario(operaciones);
	}

	@GetMapping(value = "/consultarUsuarios", produces = "application/json")
	public Flux<Usuario> consultarUsuarios() {
		return casoUsoUsuario.consultarTodosLosUsuarios();
	}

	@GetMapping(value = "/contarUsuarios", produces = "application/json")
	public Mono<Long> contarUsuarios() {
		return casoUsoUsuario.contarUsuarios();
	}

	@PostMapping(value = "/guardarUsuario", consumes = "application/json", produces = "application/json")
	public Mono<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		return casoUsoUsuario.guardar(usuario);
	}

	@DeleteMapping(value = "borrarUsuario", consumes = "application/json")
	public Mono<Void> borrarUsuario(@RequestBody Usuario usuario) {
		return casoUsoUsuario.borrarUsuario(usuario);
	}
}
