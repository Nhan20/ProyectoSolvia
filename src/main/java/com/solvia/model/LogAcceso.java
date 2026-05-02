package com.solvia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_accesos")
public class LogAcceso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	@Column(nullable = false)
	private LocalDateTime fechaLogin;

	private LocalDateTime fechaLogout;

	private String ip;


	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(LocalDateTime fechaLogin) {
		this.fechaLogin = fechaLogin;
	}

	public LocalDateTime getFechaLogout() {
		return fechaLogout;
	}

	public void setFechaLogout(LocalDateTime fechaLogout) {
		this.fechaLogout = fechaLogout;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}