/**
 * 
 */
package com.solvia.model.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "log_movimientos")
/**
 * 
 */
public class LogMovimiento {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accion; // CREAR_FACTURA, CARGAR_ARCHIVO, EDITAR_ESTUDIANTE

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    public LogMovimiento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param accion
	 * @param descripcion
	 * @param usuario
	 */
	public LogMovimiento(Long id, String accion, String descripcion, Usuario usuario) {
		super();
		this.id = id;
		this.accion = accion;
		this.descripcion = descripcion;
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
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
