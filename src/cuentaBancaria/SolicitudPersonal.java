package cuentaBancaria;

public class SolicitudPersonal extends Solicitud {

	public SolicitudPersonal(Cliente cliente, double monto, int plazo) {
		super(cliente, monto, plazo);
	}
	
	@Override
	public boolean esAceptable() {
		return this.sueldoAnualMayorA15000() && this.cuotaMenorASueldo();
	}
	
	private boolean sueldoAnualMayorA15000() {
		return (this.cliente.getSueldoAnual() >= 15000);
	}
	
	private boolean cuotaMenorASueldo() {
		return this.cuotaMensual() < (this.cliente.getSueldoMensual() * 0.70);
	}
}
