package cuentaBancaria;

public class Cliente {

	//private String nombre, apellido, direccion;
	private int edad;
	private double sueldoMensual;
	private double saldo = 0;
	
	//public Cliente(String nombre, String apellido, String dir, int edad, double sueldoMensual) {
	public Cliente(int edad, double sueldoMensual) {
//		this.nombre = nombre;
//		this.apellido = apellido;
//		this.direccion = dir;
		this.edad = edad;
		this.sueldoMensual = sueldoMensual;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public double getSueldoMensual() {
		return sueldoMensual;
	}
	
	public double getSueldoAnual() {
		return sueldoMensual * 12;
	}
	
	public void cobrar(double monto) {
		this.setSaldo( this.getSaldo() + monto );
	}
	
	public void pedirPrestamoPersonalA(Banco banco, double monto) {
		banco.recibirPedidoDePrestamoPersonal(this, monto);
	}
	
	public void pedirPrestamoHipotecarioA(Banco banco, double monto, Propiedad propiedad) {
		banco.recibirPedidoDePrestamoHipotecario(this, monto, propiedad);
	}


}