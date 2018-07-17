package pacote;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("pessoas")
public class Exercicio2 {
	
	@GET
	@Path("{nome}/{sobrenome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retorno(
			@PathParam("nome")String nome,
			@PathParam("sobrenome")String sobrenome) {
		
		return Response.ok( (new Pessoa(nome, sobrenome)).toString() , MediaType.APPLICATION_JSON).build();
		
	}

}
