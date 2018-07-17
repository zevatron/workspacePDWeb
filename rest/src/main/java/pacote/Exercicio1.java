package pacote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("service")
public class Exercicio1 {
	
	@GET
	@Path("{nome}/{sobrenome}/{formato}")
	public Response retorno(
			@PathParam("nome")String nome,
			@PathParam("sobrenome")String sobrenome,
			@PathParam("formato")String formato) {
		
		String json = "{\"nome\":\"" + nome+"\",\"sobrenome\":\""+sobrenome+"\"}";
		
		String xml = "<pessoa> <nome>"+nome+"</nome>"+"<sobrenome>"+sobrenome+"</sobrenome></pessoa>";
		
		String html = "<html><head><title>Response HTML</title><head><body><p>Nome: "+nome+"</p><p>Sobrenome: "+sobrenome + "</p></body>";
		
		String response = "";
		
		if(formato.equals("json"))
			response = json;
		else if(formato.equals("xml"))
			response = xml;
		else if (formato.equals("html"))
			response = html;
		else
			return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).build();
		
		if(formato.equals("html"))
			formato = "text/"+formato;
		else
			formato = "application/"+formato;
		
		return Response.ok(response, MediaType.valueOf(formato)).build();
	}

}
