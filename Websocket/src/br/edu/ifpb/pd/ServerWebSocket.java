package br.edu.ifpb.pd;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/inverter")
public class ServerWebSocket {
	
	@OnMessage
	public String receberMensagem(String mensagem) {
		String result = new String();
		for (int i=mensagem.length()-1 ; i>= 0 ; i--) {
			result += mensagem.charAt(i);
		}
			
		return result;
	}

}
