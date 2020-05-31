package cuentaBancaria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BancoTest {

	Cliente cliente;
	Cliente cliente2;
	SolicitudPersonal solicitudPersonal;
	SolicitudHipotecaria solicitudHipotecaria;
	Propiedad propiedad;
	Banco banco = new Banco();
	
	@Before
	public void setUp() throws Exception {
		
		cliente = mock(Cliente.class);
		cliente2 = new Cliente(65, 80000);
		propiedad = new Propiedad(5000);
		solicitudPersonal = new SolicitudPersonal(cliente2, 50000, 12);
		solicitudHipotecaria = new SolicitudHipotecaria(cliente2, 50000, 12, propiedad);
	}
	
	@Test
	public void testGetters () {
		
		assertTrue(banco.getClientes().isEmpty());
		assertTrue(banco.getSolicitudes().isEmpty());
		
		banco.agregarCliente(cliente);
		banco.agregarSolicitud(solicitudPersonal);
		assertFalse(banco.getClientes().isEmpty());
		assertFalse(banco.getSolicitudes().isEmpty());
	}
	
	@Test
	public void testTotalADesembolsar () {
		
		assertEquals(banco.totalADesembolsar(), 0, 0.01);
		
		banco.agregarSolicitud(solicitudPersonal);
		banco.agregarSolicitud(solicitudHipotecaria);
		assertEquals(banco.totalADesembolsar(), 50000, 0.01);
	}
}
