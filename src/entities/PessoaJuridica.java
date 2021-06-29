package entities;

public class PessoaJuridica extends Pessoa{
	private Integer numeroFuncionarios;
	
	public PessoaJuridica(String name, Double rendaAnual, Integer numeroFuncionarios) {
		super(name, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public  Double calcularImposto() {
		if(this.numeroFuncionarios <= 10) {
			return (super.getRendaAnual() * 16) / 100;
		}
		
		return (super.getRendaAnual() * 14) / 100;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		return str
			.append(super.getNome())
			.append(": $ ")
			.append(String.format("%.2f", this.calcularImposto()))
			.toString();
	}
}
