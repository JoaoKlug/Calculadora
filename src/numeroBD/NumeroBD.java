package numeroBD;

import java.util.Collection;
import java.util.HashMap;

import numero.Numero;

public class NumeroBD {

	private int ultimoID;
	private HashMap<Integer,Numero> numeroBD;
	
	public NumeroBD()
	{
		numeroBD = new HashMap<>();
	}
	
	public void cadastrar(Numero numero)
	{
		ultimoID += 1;
		numero.setId(ultimoID);
		numeroBD.put(ultimoID, numero);
	}
	
	public Collection<Numero> listar()
	{
		return numeroBD.values();
	}
	
	public Numero buscar(int numero)
	{
		return numeroBD.get(numero);
	}
	
	public void remover(int numero)
	{
		numeroBD.remove(numero);
	}
	
}
