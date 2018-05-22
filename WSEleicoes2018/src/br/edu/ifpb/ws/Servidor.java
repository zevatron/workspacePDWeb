package br.edu.ifpb.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import br.edu.ifpb.model.Candidato;

@ServerEndpoint("/tre/{tipo}")
public class Servidor {
	
	public Servidor() {
		super();
		
		HashMap<Integer,Candidato> eleicoes = new HashMap<Integer,Candidato>();
		Candidato c1 = new Candidato(10, "João da Cunha Coutinho");
		Candidato c2 = new Candidato(20, "Ricardo Roussef");
		eleicoes.put(c1.getNumero(), c1);
		eleicoes.put(c2.getNumero(), c2);
		
	}

	private static List<Session> eleitores = Collections.synchronizedList(new ArrayList<Session>());
	private static List<Session> urnas = Collections.synchronizedList(new ArrayList<Session>());

	@OnOpen
	public void conectar(@PathParam("tipo")String tipo ,Session s){
		if(tipo.equals("eleitor")) {
			eleitores.add(s);
			System.out.println("eleitor conectado");
		}else if(tipo.equals("urna")) {
			urnas.add(s);
			System.out.println("urna conectada");
			try {
				s.getBasicRemote().sendText("Informe o número do candidato: ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				s.getBasicRemote().sendText("Parâmetro incorreto. Tente Novamente.");
				desconecta(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	@OnMessage
	public void onMessage(String mensagem){
		
		
//		
//		
//		for( Session s : usuarios){
//			try {
//				s.getBasicRemote().sendText(mensagem);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
	@OnClose
	public void desconecta(Session s){
		if(eleitores.contains(s)) {
			eleitores.remove(s);
		}else if(urnas.contains(s)) {
			urnas.remove(s);
		}
	}

}
