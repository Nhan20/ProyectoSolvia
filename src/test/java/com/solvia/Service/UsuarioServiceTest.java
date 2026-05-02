/**
 * 
 */
package com.solvia.Service;

/**
 * 
 */
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.solvia.model.LogMovimiento;
import com.solvia.model.Usuario;
import com.solvia.repository.LogMovimientoRepository;
import com.solvia.repository.UsuarioRepository;
import com.solvia.service.UsuarioService;

/**
 * 
 */
public class UsuarioServiceTest {

	@Mock
	private UsuarioRepository useRepo;

	@Mock
	private LogMovimientoRepository logRepo;

	@InjectMocks
	private UsuarioService usuarioService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Inicializa los mocks
	}

    @Test
    void guardarUsuario_creaUsuarioYLog_correctamente() {
      
        Usuario aux = new Usuario();
        aux.setId(1L);
        aux.setName("prueba1");
        aux.setEmail("prueba1@prueba.com");
        aux.setPassword("123456780");;        
        aux.setRole("ADMIN");

        when(useRepo.save(aux)).thenReturn(aux);

        Usuario resultado = usuarioService.guardar(aux);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("ADMIN", resultado.getRole());

        verify(useRepo, times(1)).save(aux);

        ArgumentCaptor<LogMovimiento> logCaptor = ArgumentCaptor.forClass(LogMovimiento.class);
        verify(logRepo, times(1)).save(logCaptor.capture()); 

        LogMovimiento logGuardado = logCaptor.getValue();
        assertEquals("CREAR_USUARIO", logGuardado.getAccion());
        assertEquals("Se creó el usuario: 1 , con rol: ADMIN", logGuardado.getDescripcion());
    }
}
