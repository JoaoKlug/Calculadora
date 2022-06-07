package tela;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import funcoes.Funcoes;
import numero.Numero;
import numeroBD.NumeroBD;

public class TelaPrincipal {

	private Scanner lerTeclado;
	private NumeroBD numeroBD;
	private ArrayList<Long> fibonacciCache;
	private	ArrayList<Long> fatorialCache;
	
	public TelaPrincipal(){
		numeroBD = new NumeroBD();
		lerTeclado = new Scanner(System.in);
		fibonacciCache = new ArrayList<Long>();
		fatorialCache = new ArrayList<Long>();
	}
	
	public static void main(String[] args) {
		new TelaPrincipal().executar();
	}
	
	private final int _CADASTRAR_ = 1;
	private final int _LISTAR_ = 2;
	private final int _BUSCAR_ = 3;
	private final int _REMOVER_ = 4;
	private final int _SAIR_ = 0;
	
	public void executar()
	{
		this.cadastroAutomatico();
		
		for(;;)
		{
			printOpcoes();
			System.out.print("ESCOLHA UMA DAS OPCOES A CIMA: ");
				int opcaoEscolhida = lerTeclado.nextInt();
			
			if(opcaoEscolhida == _CADASTRAR_)
				this.cadastrar();
			else if(opcaoEscolhida == _LISTAR_)
				this.listar();
			else if(opcaoEscolhida == _BUSCAR_)
				this.buscar();
			else if(opcaoEscolhida == _REMOVER_)
				this.remover();
			else if(opcaoEscolhida == _SAIR_)
			{
				System.out.println("*** PROGRAMA ENCERRADO ***");
				break;
			}
			else
				System.out.println("* OPCAO INEXISTESTE *");	
		}
	}
	
	public void cadastroAutomatico()
	{
		for(int novoNumero = 0; novoNumero<=20; novoNumero++)
		{
			setNumero(novoNumero);
		}
		
	}
	
	public void cadastrar()
	{
		System.out.println();
		System.out.println("---- CADASTRAR NUMERO ----");
		System.out.println("** O intervalo de 0 a 20 foi cadastrado automaticamente **");
		
		System.out.print("Digite-o: ");
			int novoNumero = lerTeclado.nextInt();
			
			boolean encontrado = encontrarRegistro(novoNumero);	
			
		    if(encontrado == false)
		    {
				setNumero(novoNumero);
				System.out.println("*"+novoNumero+ " " +"CADASTRADO*");
		    }
		    else
		    	System.out.println("*"+novoNumero+ " " +"JA ESTA CADASTRADO*" );
		
	}
	
	public void listar()
	{
		System.out.println();
		System.out.println("---- TODOS OS REGISTROS ----");
		
		Collection<Numero> registros = numeroBD.listar();
		
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
        
		boolean encontrado = encontrarRegistro(numeroEntrada);
		
	    if(encontrado == true)	 
	    	printNumero(numeroBD.buscar(numeroEntrada+1));
	    else
	    	System.out.println("*NUMERO"+ " " +numeroEntrada + " " + "NAO ENCONTRADO*");

	}
	
	public void remover()
	{
		System.out.println();
		System.out.println("---- REMOVER NUMERO ----");
		System.out.print("Digite-o: ");
			int numeroEntrada = lerTeclado.nextInt();
		
		boolean encontrado = encontrarRegistro(numeroEntrada);	
		
		if(encontrado == true)
		{
			numeroBD.remover(numeroEntrada+1);
			System.out.println("*NUMERO"+ " " +numeroEntrada + " " + "REMOVIDO*");
		}
		else
	    	System.out.println("*NUMERO"+ " " +numeroEntrada + " " + "NAO ENCONTRADO*");
			
	}
	
	
	private void setNumero(int novoNumero)
	{
		Numero numero = new Numero();
		
		numero.setNumero(novoNumero);
		numero.setPrimo(Funcoes.primo(novoNumero));
		numero.setFibonacci(Funcoes.fibonacci(novoNumero,fibonacciCache));
		numero.setRaiz(Funcoes.raiz(novoNumero, 0));
		numero.setFatorial(Funcoes.fatorial(novoNumero, fatorialCache));
		numero.setBinario(Funcoes.binario(novoNumero));
		numero.setHexadecimal(Funcoes.hexadecimal(novoNumero));
			
		numeroBD.cadastrar(numero);
	}
	
	private boolean encontrarRegistro(int numeroEntrada)
	{
		Collection<Numero> registros = numeroBD.listar();
		
		boolean encontrado = false;	
		for(Numero numero : registros)
		{	
			if(numero.getNumero() == numeroEntrada)
			{
				encontrado = true;
				break;
			}
		}
		return encontrado;
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
		System.out.println("1-CADASTRAR");
		System.out.println("2-LISTAR");
		System.out.println("3-BUSCAR");
		System.out.println("4-REMOVER");
		System.out.println("0-SAIR");
		System.out.println();
	}
}
