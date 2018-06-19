import javax.jws.WebService;

@WebService(serviceName="CalculadoraService")
public class CalculadoraService {
	
	public String hello(String msg) {
		return "Hello " + msg;
	}

}
