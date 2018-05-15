package br.edu.ifpb.pd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatWSEndpoint {
	
	private List<Session> usuarios = new ArrayList<>();
	
	@OnOpen
	public void conectar(Session s){
		usuarios.add(s);
	}
	
	@OnMessage
	public void onMessage(String mensagem){
		for( Session s : usuarios){
			try {
				s.getBasicRemote().sendText(mensagem);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void desconecta(Session s){
		usuarios.remove(s);
	}

}
