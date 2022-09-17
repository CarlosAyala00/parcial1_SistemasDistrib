import java.util.ArrayList;
import java.util.List;

public class cotizacion {
    String empresa;
	String dolar;
	String euro;
	String libra;
	String arg;
	String chi;
	String real;
	public cotizacion(){
		
	}

	public cotizacion(String dolar, String euro, String libra, String real, String arg, String chi,String empresa){
		this.dolar = dolar;
		this.euro = euro;
		this.libra = libra;
		this.real=real;
		this.arg=arg;
		this.chi=chi;
		this.empresa=empresa;
	}
	
	public String getDolar() {
		return dolar;
	}
	public String getEmpresa() {
		return empresa;
	}
	public String getEuro() {
		return euro;
	}
	public String getLibra() {
		return libra;
	}
	public String getReal() {
		return real;
	}
	public String getArg() {
		return arg;
	}

	public String getChi() {
		return chi;
	}
	public void setDolar(String dolar) {
		this.dolar = dolar;
	}
	public void setEuro(String euro) {
		this.euro = euro;
	}
	public void setLibra(String libra) {
		this.libra = libra;
	}
	public void setReal(String real) {
		this.real = real;
	}
	public void setArg(String arg) {
		this.arg= arg;
	}
	public void setChi(String chi) {
		this.chi = chi;
	}
	public void setEmpresa(String empresa) {
		this.empresa= empresa;
	}
	
}