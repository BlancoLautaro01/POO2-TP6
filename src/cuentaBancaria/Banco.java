package cuentaBancaria;

import java.util.ArrayList;

public class Banco {

	//Variables
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();

	//Getters
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	
	//Interfaz (SistemaInformatico)
	public void agregarCliente(Cliente cliente) {	
		this.clientes.add(cliente);
	}
	
	public void agregarSolicitud(Solicitud solicitud) {	
		this.solicitudes.add(solicitud);
	}
	
	public double totalADesembolsar() {
		double totalADesembolsar = 0;
		for(Solicitud solicitud: this.mapSolicitudesAceptables()) {
			totalADesembolsar += solicitud.getMonto();
		}
		return totalADesembolsar;
	}
	
	//Implementacion
	protected void recibirPedidoDePrestamoPersonal(Cliente cliente, double monto) {	
		Solicitud solicitud = new SolicitudPersonal(cliente, monto, 12);
		this.solicitudes.add(solicitud);
		if(solicitud.esAceptable()) {
			cliente.cobrar(monto);
		}
	}
	
	protected void recibirPedidoDePrestamoHipotecario(Cliente cliente, double monto, Propiedad propiedad) {
		Solicitud solicitud = new SolicitudHipotecaria(cliente, monto, 12, propiedad);
		this.solicitudes.add(solicitud);
		if(solicitud.esAceptable()) {
			cliente.setSaldo( cliente.getSaldo() + monto);
		}
	}
	
	private ArrayList<Solicitud> mapSolicitudesAceptables() {
		ArrayList<Solicitud> solicitudesAceptables = new ArrayList<Solicitud>();
		for(Solicitud solicitud: this.getSolicitudes()) {
			if(solicitud.esAceptable()) {
				solicitudesAceptables.add(solicitud);
			}
		}
		return solicitudesAceptables;
	}
	
}