package funcoes;

public class Funcoes {

	public static boolean primo(int numero)
	{
		boolean primo = true;
		
		if(numero<=1)
		{
			primo = false;
		}
		else
		{
			for(int divisor = 2; divisor<numero; divisor ++)
			{
				if(numero%divisor == 0)
				{
					primo = false;
					break;
				}
			}
		}
		return primo;
	}
	
	
	public static long fibonacci(int numero, long []fibonacciCache)
	{
		long fibonacci = 0;
		
		if(numero>92 || numero==0)
			return fibonacci;
		if(numero == 1)
			return fibonacci+1;
		
		if(fibonacciCache[numero] != 0)
			return fibonacciCache[numero];
		
		fibonacci = (fibonacci(numero-1, fibonacciCache) + fibonacci(numero-2, fibonacciCache));
		fibonacciCache[numero] = fibonacci;
		
		return fibonacci;
	}
	
	
	public static double raiz(int numero, double raiz)
	{
		double provaReal = raiz*raiz;
		
		if(provaReal == numero || Math.abs(provaReal-numero)<0.00001)
			return raiz;
			
		else if(provaReal>numero)
			raiz = decimalRaiz(numero, raiz-1, raiz);
		
		else
			raiz = raiz(numero, raiz+1);
			
		return raiz;
	}
	private static double decimalRaiz(int numero, double comecoIntervalo, double finalIntervalo)
	{
		double raiz = (comecoIntervalo + finalIntervalo)/2;
		double provaReal = raiz*raiz;
		
		if(provaReal == numero || Math.abs(provaReal-numero)<0.00001)
			return raiz;
		
		if(provaReal<numero)
			raiz = decimalRaiz(numero, raiz, finalIntervalo);
		
		if(provaReal>numero)
			raiz = decimalRaiz(numero, comecoIntervalo, raiz);
			
		return raiz;
	}	
	
	
	public static long fatorial(int numero, long[]fatorialCache)
	{
		long fatorial = 0;
		
		if(numero>20)
			return fatorial;
		if(numero<=1)
			return fatorial+1;
		
		if(fatorialCache[numero] != 0)
			return fatorialCache[numero];
		
		fatorial = numero*fatorial(numero-1,fatorialCache);
		fatorialCache[numero] = fatorial;
		
		return fatorial;
	}
	
	public static long binario (int numero)
	{
		int bit;
		long binario = 0;
		long organizador=1;
	 
		while(numero!=0){
			bit = numero%2;
			binario = binario + organizador*bit;
			organizador=organizador*10;
			numero = numero/2;
		}
		
		return binario;
	}
	
	
	public static String hexadecimal(int numero)
	{
		String hexadecimal = "";
		String possiveisDigitos = "0123456789ABCDEF";
		
		if(numero == 0)
			hexadecimal = "0";
		while(numero!=0){
			int digitoCorreto = numero%16;
			hexadecimal = possiveisDigitos.charAt(digitoCorreto) + hexadecimal;
			numero = numero/16;
		}
		
		return hexadecimal;
	}
	
}
