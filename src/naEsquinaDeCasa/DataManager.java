package naEsquinaDeCasa;

import java.util.ArrayList;

public class DataManager {
	private ArrayList<Cliente> listaClientes;
	private ArrayList<ClienteAdicionadoListener> clienteAdicionadoListeners;
	
	public DataManager() {
		listaClientes = new ArrayList<>();
		clienteAdicionadoListeners = new ArrayList<>();
	}
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void addCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public void addClienteAdicionadoListener(ClienteAdicionadoListener listener) {
		clienteAdicionadoListeners.add(listener);
	}
	
	public void removeClienteAdicionadoListener(ClienteAdicionadoListener listener) {
		clienteAdicionadoListeners.remove(listener);
	}
	
	public void notificarClienteAdicionadoListeners() {
		ClienteAdicionadoEvent event = new ClienteAdicionadoEvent(this);
		
		for (ClienteAdicionadoListener listener : clienteAdicionadoListeners) {
			listener.clienteAdicionado(event);
		}
	}
}
