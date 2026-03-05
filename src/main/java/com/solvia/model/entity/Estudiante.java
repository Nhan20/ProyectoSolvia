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
@Table(name = "estudiantes")
/**
 * 
 */
public class Estudiante extends BaseEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String identificacion;

    private String curso;

    @ManyToOne
    @JoinColumn(name = "colegio_id", nullable = false)
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "acudiente_id", nullable = false)
    private Acudiente acudiente;
    
    public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 * @param identificacion
	 * @param curso
	 * @param colegio
	 * @param acudiente
	 */
	public Estudiante(Long id, String nombre, String identificacion, String curso, Colegio colegio,
			Acudiente acudiente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.curso = curso;
		this.colegio = colegio;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
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
