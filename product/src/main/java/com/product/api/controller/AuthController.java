package com.product.api.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.commons.Globales;
import com.product.api.commons.dto.AuthApiResponse;
import com.product.api.dto.in.AuthRequest;
import com.product.api.dto.in.validationAuth.UsernameOrCorreoAuthenticationToken;
import com.product.api.entity.Usuario;
import com.product.config.jwt.JwtUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name= "Autenticación de usuarios registrados", description = "Operaciones para autenticar usuarios que existen en el sistema")
public class AuthController {

    @Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthApiResponse> autenticaUsuario(@Valid @RequestBody AuthRequest request) {

        AuthApiResponse response = new AuthApiResponse();

        HashMap<String, String> elementosAutenticacion = new HashMap<String, String>();

        if(StringUtils.hasLength(request.getNombreUsuario()))
			elementosAutenticacion.put("username", request.getNombreUsuario());
		if(StringUtils.hasLength(request.getCorreo()))
			elementosAutenticacion.put("correo", request.getCorreo());

        Authentication authenticate = authenticationManager.authenticate(new UsernameOrCorreoAuthenticationToken(elementosAutenticacion, request.getContrasena()));

        response.setDetalles(Arrays.asList("Autenticación exitosa"));
		
		String jwt = jwtUtil.generateToken((Usuario) authenticate.getPrincipal());
		
		response.setToken(jwt);
		response.setFechaHora(Globales.formatDate(new Date()));

        return new ResponseEntity<>(response, HttpStatus.OK);    
    }

}
