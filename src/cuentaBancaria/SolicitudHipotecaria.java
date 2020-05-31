package cuentaBancaria;

public class SolicitudHipotecaria extends Solicitud {

	private Propiedad propiedad;
	
	public SolicitudHipotecaria(Cliente cliente, double monto, int plazo, Propiedad propiedad) {
		super(cliente, monto, plazo);
		this.propiedad = propiedad;
	}
	
	@Override
	public boolean esAceptable() {
		return this.cuotaMenorAMitadDelSueldo() && this.montoMenorAValorFiscal() && !this.esViejo() ;
	}
	
	private boolean cuotaMenorAMitadDelSueldo() {
		return (this.cuotaMensual() < (this.cliente.getSueldoMensual() * 0.50));
	}
	
	private boolean montoMenorAValorFiscal() {
		return (this.monto < this.propiedad.getValorFiscal());
	}
	
	private boolean esViejo() {
		//El plazo esta en meses, la edad en años, 780 son 65 años.
		return (this.plazo + this.cliente.getEdad() * 12) < 780;
	}
}
