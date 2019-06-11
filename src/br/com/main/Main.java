package br.com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.entity.Pessoa;

public class Main {
	static List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public static void main(String args[]) {

		boolean fim = false;
		Scanner entrada = new Scanner(System.in);
		while (fim == false) {
			Pessoa pessoa = new Pessoa();
			System.out.println("Informe o nome: ");
			pessoa.setNome(entrada.next());
			System.out.print("Informe o sexo: ");
			pessoa.setSexo(entrada.next());
			System.out.println("Informe o peso: ");
			pessoa.setPeso(entrada.nextDouble());
			System.out.println("Informe a idade: ");
			pessoa.setIdade(entrada.nextInt());
			System.out.println("Informe a altura: ");
			pessoa.setAltura(entrada.nextDouble());
			pessoas.add(pessoa);
			
			System.out.print("Digite qualquer tecla para incluir umma nova pessoa ou fim para encerrar");
			if (entrada.next().equals("fim")) {
				fim = true;
			}
		}
		System.out.println("Quantidade de pessoas: " + pessoas.size());
		System.out.println("Media de idade dos homens : = "+ calcularMediaIdadeHomens());
		System.out.println("Quantidade de mulheres entre 1,60 e 1,70 e peso acima de 70 KG: "
		+ calcularAlturaEpesoMulheres());
		System.out.println("Quantidade de pessoas com idade entre 18 e 25: "
		+ calcularEntredezoitoEvinteECinco());
		System.out.println("Paciente mais velho: " + calcularMaiorIdade());
		System.out.println("Nome da mulher mais baixa :"
		+ calcularMulherMaisBaixa());

	}

	private static String calcularMulherMaisBaixa() {
		String nome = "";
		int altura = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAltura() < altura) {
				nome = pessoa.getNome();
				altura = pessoa.getIdade();
			}
		}
		return nome;
	}
	private static String calcularMaiorIdade() {
		String nome = "";
		int idade = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() > idade) {
				nome = pessoa.getNome();
				idade = pessoa.getIdade();
			}
		}
		return nome;
	}
	private static int calcularEntredezoitoEvinteECinco() {
		int qtd = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() >= 18 && pessoa.getIdade() <= 25) {
				qtd++;
			}
		}
		return qtd;
	}
	private static int calcularAlturaEpesoMulheres() {
		int qtd = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getSexo().equalsIgnoreCase("F")
					&& pessoa.getAltura() >= 1.60 && pessoa.getAltura() <= 1.70
					&& pessoa.getPeso() > 70) {
				qtd++;
			}
		}
		return qtd;
	}
	private static double calcularMediaIdadeHomens() {
		double mediaIdade = 0;
		double homens = 0;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getSexo().equalsIgnoreCase("M")) {
				mediaIdade += pessoa.getIdade();
				homens = homens + 1;
			}
		}
		return mediaIdade / homens;
	}
}
