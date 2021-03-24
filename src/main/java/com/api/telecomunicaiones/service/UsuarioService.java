package com.api.telecomunicaiones.service;

import java.util.ArrayList;
import java.util.List;

import com.api.telecomunicaiones.modelo.Usuario;
import com.api.telecomunicaiones.repository.IUsuarioDao;
import com.api.telecomunicaiones.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService{
  
    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
	private BCryptPasswordEncoder encoder;

    public ResponseEntity<Object> agregarUsuario (Usuario usuarioNuevo){
        ResponseEntity<Object> respuesta;

        try {
            usuarioNuevo.setClave(encoder.encode(usuarioNuevo.getClave()));
            usuarioDao.save(usuarioNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Usuario generado correctamente", HttpStatus.OK);
            respuesta= ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            
        } catch (Exception e) {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error al generar el usuario ", HttpStatus.BAD_REQUEST);
            respuesta= ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByNombre(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails user = new User(usuario.getNombre(), usuario.getClave(), authorities);
		return user;
	}

    public Usuario obtenerUsuario(String nombre) {
		return usuarioDao.findByNombre(nombre);
	}
}
