package com.pratechgroup.demo.negocio.casosuso;

import com.pratechgroup.demo.negocio.entidades.Usuario;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperacionesUsuario {

	public Mono<Usuario> guardar(Usuario usuario);

	public Flux<Usuario> consultarTodosLosUsuarios();
	
	public Mono<Void> borrarUsuario(Usuario usuario);
	
	public Mono<Long> contarUsuarios();

}
