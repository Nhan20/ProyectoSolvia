/**
 * 
 */
package com.solvia.model.entity;

/**
 * 
 */
import jakarta.persistence.*;
import java.util.List;
/**
 * 
 */
@Entity
@Table(name = "colegios")
/**
 * 
 */
public class Colegio extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false, unique = true)
	private String nit;

	private String direccion;
    
	private String telefono;

	@OneToMany(mappedBy = "colegio")
	private List<Estudiante> estudiantes;

	public Colegio() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 * @param nit
	 * @param direccion
	 * @param telefono
	 * @param estudiantes
	 */
	public Colegio(Long id, String nombre, String nit, String direccion, String telefono,
			List<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nit = nit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estudiantes = estudiantes;
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
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * @param nit the nit to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the estudiantes
	 */
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * @param estudiantes the estudiantes to set
	 */
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	
}
	
