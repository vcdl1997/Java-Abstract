package entities;

public class PessoaFisica extends Pessoa{
	private Double gastosSaude;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public Double calcularImposto() {
		if(super.getRendaAnual() <= 20000) {
			return ((super.getRendaAnual() * 15) / 100) - ((this.gastosSaude * 50) / 100);
		}
		
		return ((super.getRendaAnual() * 25) / 100) - ((this.gastosSaude * 50) / 100);
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
