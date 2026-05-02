package com.solvia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_carga_archivos")
public class LogCargaArchivo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArchivo;

    private String estado; // PROCESADO, ERROR, PENDIENTE

    private int registrosProcesados;

    private int registrosConError;

    @ManyToOne
    @JoinColumn(name = "colegio_id")
    private Colegio colegio;

    private String usuario;
    
    /**
     * 
     */
    public LogCargaArchivo() {
		// TODO Auto-generated constructor stub
	}
    

	/**
	 * @param id
	 * @param nombreArchivo
	 * @param estado
	 * @param registrosProcesados
	 * @param registrosConError
	 * @param colegio
	 * @param usuario
	 */
	public LogCargaArchivo(Long id, String nombreArchivo, String estado, int registrosProcesados, int registrosConError,
			Colegio colegio, String usuario) {
		super();
		this.id = id;
		this.nombreArchivo = nombreArchivo;
		this.estado = estado;
		this.registrosProcesados = registrosProcesados;
		this.registrosConError = registrosConError;
		this.colegio = colegio;
		this.usuario = usuario;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the registrosProcesados
	 */
	public int getRegistrosProcesados() {
		return registrosProcesados;
	}

	/**
	 * @param registrosProcesados the registrosProcesados to set
	 */
	public void setRegistrosProcesados(int registrosProcesados) {
		this.registrosProcesados = registrosProcesados;
	}

	/**
	 * @return the registrosConError
	 */
	public int getRegistrosConError() {
		return registrosConError;
	}

	/**
	 * @param registrosConError the registrosConError to set
	 */
	public void setRegistrosConError(int registrosConError) {
		this.registrosConError = registrosConError;
	}

	/**
	 * @return the colegio
	 */
	public Colegio getColegio() {
		return colegio;
	}

	/**
	 * @param colegio the colegio to set
	 */
	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
    
    

}
