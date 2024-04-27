package App;

import java.io.IOException;
import model.Endereco;
import service.ViaCepService;

public class Main {

	

	public static void main(String[] args) {
		//SpringApplication.run(Main.class, args);

	ViaCepService vcs = new ViaCepService();
		
		try {
			
			Endereco endereco = vcs.getEndereco("51021360");
			System.out.println(endereco.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		
	}
}
}