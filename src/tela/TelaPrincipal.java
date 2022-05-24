package tela;

import java.util.Collection;
import java.util.Scanner;

import funcoes.Funcoes;
import numero.Numero;
import numeroBD.NumeroBD;

public class TelaPrincipal {

	private Scanner lerTeclado;
	private NumeroBD numeroBD;
	
	public TelaPrincipal(){
		numeroBD = new NumeroBD();
		lerTeclado = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal().executar();
	}
	
	private final int _LISTAR_ = 1;
	private final int _REMOVER_ = 2;
	private final int _BUSCAR_ = 3;
	private final int _SAIR_ = 0;
	
	public void executar()
	{
		this.cadastrar();
		
		int opcaoEscolhida = 1;
		do
		{
			printOpcoes();
			System.out.print("ESCOLHA UMA DAS OPCOES A CIMA: ");
				opcaoEscolhida = lerTeclado.nextInt();
			
			if(opcaoEscolhida == _LISTAR_)
				this.listar();
			else if(opcaoEscolhida == _REMOVER_)
				this.remover();
			else if(opcaoEscolhida == _BUSCAR_)
				this.buscar();
			else if(opcaoEscolhida == _SAIR_)
			{
				System.out.println("*** PROGRAMA ENCERRADO ***");
				break;
			}
			else
				System.out.println("* OPCAO INEXISTESTE *");
			
		}while(opcaoEscolhida!=0);
	}
	
	public void cadastrar()
	{
		for(int novoNumero = 0; novoNumero<=5; novoNumero++)
		{
			Numero numero = new Numero();
			long[] fibonacciCache  = new long[novoNumero+1];
			long[] fatorialCache = new long[novoNumero+1];
			
			numero.setNumero(novoNumero);
			numero.setPrimo(Funcoes.primo(novoNumero));
			numero.setFibonacci(Funcoes.fibonacci(novoNumero,fibonacciCache));
			numero.setRaiz(Funcoes.raiz(novoNumero, 0));
			numero.setFatorial(Funcoes.fatorial(novoNumero, fatorialCache));
			numero.setBinario(Funcoes.binario(novoNumero));
			numero.setHexadecimal(Funcoes.hexadecimal(novoNumero));
			
			numeroBD.cadastrar(numero);
		}
	}
	
	public void listar()
	{
		System.out.println();
		System.out.println("---- TODOS OS REGISTROS ----");
		
		Collection<Numero> registros = numeroBD.registros();
		
		for(Numero numero : registros)
		{
			printNumero(numero);		
		}
	}
	
	public void buscar()
	{
		System.out.println();
        System.out.println("---- BUSCAR NUMERO ----");
        System.out.print("Digite-o: ");
			int numeroEntrada = lerTeclado.nextInt();
        
		Collection<Numero> registros = numeroBD.registros();
		
			
		boolean encontrado = false;	
		for(Numero numero : registros)
		{	
			if(numero.getNumero() == numeroEntrada)
			{
				printNumero(numero);
				encontrado = true;
				break;
			}
		}
	    if(encontrado == false)	 
	    	System.out.println("NUMERO"+ " " +numeroEntrada + " " + "NAO ENCONTRADO");

	}
	
	public void remover()
	{
		System.out.println();
		System.out.println("---- REMOVER NUMERO ----");
		System.out.print("Digite-o: ");
			int numeroEntrada = lerTeclado.nextInt();
		 
		Collection<Numero> registros = numeroBD.registros();
		
		boolean encontrado = false;	
		for(Numero numero : registros)
		{	
			if(numero.getNumero() == numeroEntrada)
			{
				numeroBD.remover(numeroEntrada);
				System.out.println("NUMERO"+ " " +numeroEntrada + " " + "REMOVIDO");
				encontrado = true;
				break;
			}
		}
	    if(encontrado == false)	 
	    	System.out.println("NUMERO"+ " " +numeroEntrada + " " + "NAO ENCONTRADO");
			
	}
	
	private void printNumero(Numero numero)
	{
		System.out.print(numero.getNumero() + "|");
		System.out.print("primo:"  +numero.isPrimo()+ "|");
		System.out.print("fibonacci:" +numero.getFibonacci()+ "|");
		System.out.print("raiz:");System.out.printf("%.5f", numero.getRaiz());System.out.print("|");
		System.out.print("fatorial:" +numero.getFatorial()+ "|");
		System.out.print("binario:" +numero.getBinario()+ "|");
		System.out.print("hexadeciaml:" +numero.getHexadecimal()+ "|");
		System.out.println();
	}
	private void printOpcoes()
	{
		System.out.println();
		System.out.println("---- OPCOES ----");
		System.out.println("1-LISTAR");
		System.out.println("2-REMOVER");
		System.out.println("3-BUSCAR");
		System.out.println("0-SAIR");
		System.out.println();
	}
}
