package numeroBD;

import java.util.Collection;
import java.util.HashMap;

import numero.Numero;

public class NumeroBD {

	private HashMap<Integer,Numero> numeroBD;
	
	public NumeroBD()
	{
		numeroBD = new HashMap<>();
	}
	
	public void cadastrar(Numero numero)
	{
		numeroBD.put(numero.getNumero(), numero);
	}
	
	public Collection<Numero> registros()
	{
		return numeroBD.values();
	}
	
	public void remover(int numero)
	{
		numeroBD.remove(numero);
	}
	
}
