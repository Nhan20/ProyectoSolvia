/**
 * 
 */
package com.solvia.model.entity;

/**
 * 
 */
import jakarta.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "facturas")
/**
 * 
 */
public class Factura extends BaseEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;

    private Double valor;

    private String estado;

    private String fechaGeneracion;

    @ManyToOne
    @JoinColumn(name = "acudiente_id")
    private Acudiente acudiente;

    public Factura() {
		// TODO Auto-generated constructor stub
	}
    
	/**
	 * @param id
	 * @param numeroFactura
	 * @param valor
	 * @param estado
	 * @param fechaGeneracion
	 * @param acudiente
	 */
	public Factura(Long id, String numeroFactura, Double valor, String estado, String fechaGeneracion,
			Acudiente acudiente) {
		super();
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.valor = valor;
		this.estado = estado;
		this.fechaGeneracion = fechaGeneracion;
		this.acudiente = acudiente;
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
	 * @return the numeroFactura
	 */
	public String getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
	 * @return the fechaGeneracion
	 */
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	/**
	 * @return the acudiente
	 */
	public Acudiente getAcudiente() {
		return acudiente;
	}

	/**
	 * @param acudiente the acudiente to set
	 */
	public void setAcudiente(Acudiente acudiente) {
		this.acudiente = acudiente;
	}   
}