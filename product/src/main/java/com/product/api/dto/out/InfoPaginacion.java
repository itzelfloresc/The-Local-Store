package com.product.api.dto.out;

public class InfoPaginacion {

    private static final long serialVersionUID = 1502769119951843826L;
	
	private Integer paginaActual;
	private Boolean paginaSiguiente;
	private Boolean paginaAnterior;
	private Integer paginasTotales;
	private Integer registrosDevueltos;
	private Long registrosTotales;

    
    public InfoPaginacion() {
    }

    public InfoPaginacion(Integer paginaActual, Boolean paginaSiguiente, Boolean paginaAnterior, Integer paginasTotales,
            Integer registrosDevueltos, Long registrosTotales) {
        this.paginaActual = paginaActual;
        this.paginaSiguiente = paginaSiguiente;
        this.paginaAnterior = paginaAnterior;
        this.paginasTotales = paginasTotales;
        this.registrosDevueltos = registrosDevueltos;
        this.registrosTotales = registrosTotales;
    }

    public Integer getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(Integer paginaActual) {
        this.paginaActual = paginaActual;
    }

    public Boolean getPaginaSiguiente() {
        return paginaSiguiente;
    }

    public void setPaginaSiguiente(Boolean paginaSiguiente) {
        this.paginaSiguiente = paginaSiguiente;
    }

    public Boolean getPaginaAnterior() {
        return paginaAnterior;
    }

    public void setPaginaAnterior(Boolean paginaAnterior) {
        this.paginaAnterior = paginaAnterior;
    }

    public Integer getPaginasTotales() {
        return paginasTotales;
    }

    public void setPaginasTotales(Integer paginasTotales) {
        this.paginasTotales = paginasTotales;
    }

    public Integer getRegistrosDevueltos() {
        return registrosDevueltos;
    }

    public void setRegistrosDevueltos(Integer registrosDevueltos) {
        this.registrosDevueltos = registrosDevueltos;
    }

    public Long getRegistrosTotales() {
        return registrosTotales;
    }

    public void setRegistrosTotales(Long registrosTotales) {
        this.registrosTotales = registrosTotales;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
}
