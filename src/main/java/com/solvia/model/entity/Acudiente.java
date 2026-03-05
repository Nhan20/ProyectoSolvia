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
@Table(name = "acudientes")

/**
 * 
 */
public class Acudiente extends BaseEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String identificacion;

    private String correo;

    private String telefono;

    @OneToMany(mappedBy = "acudiente")
    private List<Estudiante> estudiantes;
    
    /**
     * 
     */
    public Acudiente() {
		// TODO Auto-generated constructor stub
	}

    

	/**
	 * @param id
	 * @param nombre
	 * @param identificacion
	 * @param correo
	 * @param telefono
	 * @param estudiantes
	 */
	public Acudiente(Long id, String nombre, String identificacion, String correo, String telefono,
			List<Estudiante> estudiantes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.correo = correo;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}


	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
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
