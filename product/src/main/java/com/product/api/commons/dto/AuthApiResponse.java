package com.product.api.commons.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.api.dto.out.DtoUsuarioOut;
import com.product.api.dto.out.InfoPaginacion;

import java.util.logging.Logger;

@JsonInclude(Include.NON_EMPTY) 
public class AuthApiResponse {

    private static final Logger log = Logger.getLogger(AuthApiResponse.class.getName());

    private String token;
	private String fechaHora;
	private List<String> detalles;
	private List<DtoUsuarioOut> usuarios;
	
	private InfoPaginacion infoPaginacion;


    public AuthApiResponse() {
    }

    public AuthApiResponse(String token, String fechaHora, List<String> detalles, List<DtoUsuarioOut> usuarios,
            InfoPaginacion infoPaginacion) {
        this.token = token;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
        this.usuarios = usuarios;
        this.infoPaginacion = infoPaginacion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

    public List<DtoUsuarioOut> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<DtoUsuarioOut> usuarios) {
        this.usuarios = usuarios;
    }

    public InfoPaginacion getInfoPaginacion() {
        return infoPaginacion;
    }

    public void setInfoPaginacion(InfoPaginacion infoPaginacion) {
        this.infoPaginacion = infoPaginacion;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
        	log.severe("Excepción atrapada al serializar objeto: " + e.getMessage());
        	return super.toString(); 
        }
    }

	public void agregaUsuario(DtoUsuarioOut usuario) {
		if(this.usuarios == null)
			this.usuarios = new ArrayList<>();
		
		this.usuarios.add(usuario);
		
	}

}
