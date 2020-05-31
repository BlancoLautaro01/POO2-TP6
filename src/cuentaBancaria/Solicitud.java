package cuentaBancaria;

public abstract class Solicitud {

	protected Cliente cliente;
	protected double monto;
	protected int plazo;
	
	public Solicitud(Cliente cliente, double monto, int plazo) {
		super();
		this.cliente = cliente;
		this.monto = monto;
		this.plazo = plazo;
	}
	
	public double getMonto() {
		return this.monto;
	}
	
	public double cuotaMensual() {
		return this.monto / this.plazo;
	}
	
	public abstract boolean esAceptable();
}
