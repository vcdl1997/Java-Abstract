package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		List<Pessoa> contribuintes = new ArrayList<>();
		
		System.out.println("Insira o número de contribuintes: ");
		Integer quantidadeContribuites = scan.nextInt();
		
		for(int i = 0; i < quantidadeContribuites; i++) {
			System.out.printf("Dados do Contribuinte #%d\n", i+1);
			System.out.println("Pessoa física ou jurídica (f/j) ?");
			Character tipoPessoa = scan.next().charAt(0);
			
			System.out.println("Nome: ");
			String nome = scan.next();
			scan.nextLine();
			
			System.out.println("Renda anual: ");
			Double rendaAnual = scan.nextDouble();
			
			switch(tipoPessoa) {
				case 'f': case 'F':
					System.out.println("Despesas de Saúde: ");
					Double despesasSaude = scan.nextDouble();
					contribuintes.add(new PessoaFisica(nome, rendaAnual, despesasSaude));
				break;
				
				case 'j': case 'J':
					System.out.println("Número de Funcionários: ");
					Integer numeroFuncionarios = scan.nextInt();
					contribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
				break;
			}	
		}
		
		if(contribuintes.size() > 0) {
			Double totalImposto = 0.0;
			
			System.out.println("Impostos Pagos");
			
			for(Pessoa contribuinte : contribuintes) {
				totalImposto += contribuinte.calcularImposto();
				System.out.println(contribuinte.toString());
			}
			
			System.out.printf("Total de Impostos: $ %.2f", totalImposto);
		}
		
		scan.close();
	}
}
