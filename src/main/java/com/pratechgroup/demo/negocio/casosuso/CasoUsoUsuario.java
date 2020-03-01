package com.pratechgroup.demo.negocio.casosuso;

import com.pratechgroup.demo.negocio.entidades.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CasoUsoUsuario {

	private OperacionesUsuario operacionesUsuario;

	public CasoUsoUsuario(OperacionesUsuario operacionesUsuario) {
		this.operacionesUsuario = operacionesUsuario;
	}

	public Mono<Usuario> guardar(Usuario usuario) {
		return operacionesUsuario.guardar(usuario);
	}

	public Flux<Usuario> consultarTodosLosUsuarios() {
		return operacionesUsuario.consultarTodosLosUsuarios();
	}

	public Mono<Void> borrarUsuario(Usuario usuario) {
		return operacionesUsuario.borrarUsuario(usuario);
	}

	public Mono<Long> contarUsuarios() {
		return operacionesUsuario.contarUsuarios();
	}

}
