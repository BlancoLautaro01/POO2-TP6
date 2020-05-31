package cuentaBancaria;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ClienteTest {

	Banco banco;
	Propiedad propiedad;
	Cliente cliente = new Cliente(23, 40000);
	
	@Before
	public void setUp() throws Exception {
		
		banco = mock(Banco.class);
		propiedad = mock(Propiedad.class);
	}
	
	@Test
	public void testConstructor () {
		
		assertEquals(cliente.getEdad(), 23);
		assertEquals(cliente.getSueldoMensual(), 40000, 0.001);
		assertEquals(cliente.getSueldoAnual(), 480000, 0.001);
	}
	
	@Test
	public void testCobrar () {
		
		assertEquals(cliente.getSaldo(), 0, 0.001);
		cliente.cobrar(40000);
		assertEquals(cliente.getSaldo(), 40000, 0.001);
	}
	
	@Test
	public void testPedirPrestamos () {
		
		cliente.pedirPrestamoHipotecarioA(banco, 40000, propiedad);
		verify(banco, times(1)).recibirPedidoDePrestamoHipotecario(cliente, 40000, propiedad);
		cliente.pedirPrestamoPersonalA(banco, 40000);
		verify(banco, times(1)).recibirPedidoDePrestamoPersonal(cliente, 40000);
	}
}
