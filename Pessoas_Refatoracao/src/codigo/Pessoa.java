//Enviar código refatorado (código e testes)
//e um documento contendo lista dos Mal Cheiros
//e quais as soluções adotadas.



package codigo;

public class Pessoa {

	String cadPessFis;// cadastro único de pessoas físicas no brasil internacional
	String n; // nome do cidadão. Exemplo "nome com 3 letras!"
	String s; // chamado de last name nos EUA
	public boolean existe() { //Será que essa pessoa existe? 
		boolean existe;
		boolean cpfEx = this.verCPF() ? true :  false; // operação ternária procurando erros e falhas
		if(!cpfEx) {
			existe = false; // cpf inexistente encontrado para verificar que não há um cpf
		}
		else {
			if(cpfEx && !(this.cadPessFis.length() == 11)) {
				existe = false;//não sei ao certo mas tem relação com cpf
			}
			else {
				if(!(this.n.length() > 3)) {//ver nom está preenchido com mai de tri letras
					existe = false;
				}
				else {
					if(!(this.s.length() > 3)) { // ver sobrenom existe e tá com todas as letras
						existe = false;//sobrenome não existe no banco de dados da receita federEl
					}
					else {
						existe = true; // nome e cpf existentes, sobrenome! Pessoa existente 
					}
				}
			}
		}
		try {
			System.out.println("Algo pode dar errado no código acima, não mexer");
			return existe; // evita problemas
		} catch (Exception e) {
			System.err.println("Algo deu errado no código acima, cuidado ao mexer");
			return existe; // aconteceu um erro grande
		}
	}

	private boolean verCPF() { // será que tem um cpf válido na mesma formato de não conter pontos, virgulas ou traços?
		boolean ehNaovalCpfInvNull;
		if(!(this.cadPessFis == null)) { // verifica se cpf é nulo
			if ((!(!(!(this.cadPessFis.length() == 11))))) {//verifica tamanho do cpf com pontos e traços
				ehNaovalCpfInvNull = false;//retorna cpf válido
			}
			else {
				ehNaovalCpfInvNull = true;//retorna cpf inválido
			}
		}
		else {
			ehNaovalCpfInvNull = false;//retorna cpf nulo
		}
		return ehNaovalCpfInvNull;
	}

	public String getCadPessFis() {
		return cadPessFis;
	}

	public void setCadPessFis(String cadPessFis) { // método que inclui e verifica formato do cpf
		if(!(cadPessFis.contains("."))) {
			if(!(cadPessFis.contains("-"))) {
				this.cadPessFis = cadPessFis;
			}else {
				//				retirar pontos e traços conforme abaixo
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {//verificar traços e retirar
					for(int i = 0; i <cadPessFis.length(); i++) {//Retira traços
						String s = cadPessFis.substring(i, cadPessFis.indexOf("-"));
						cadPessFis = cadPessFis.substring(0,i) + s;
					}
				}
			}

		}
		else {
			for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
				if(!(cadPessFis.contains("."))) {
					break;
				}
				else{
					String s = cadPessFis.substring(0, cadPessFis.indexOf("."));
					cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
				}

			}
			if(cadPessFis.contains("-")) {//verificar traços e retirar
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					if(!(cadPessFis.contains("-"))) {
						break;
					}
					else{
						String s = cadPessFis.substring(0, cadPessFis.indexOf("-"));
						cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
					}

				}
			}
			this.cadPessFis = cadPessFis;
		}

	}

	public String getN() {//retorna valor de N
		return n;
	}

	public void setN(String n) { //Seta um n, TODO validar? 
		this.n = n;
	}

	public String getS() {// get valor de S cpf sem validar
		return s;
	}

	public void setS(String s) { // Set S de String
		this.s = s;
	}

	public String getFmCadPessFis() { // pega cadastro formatado
		if(!(cadPessFis.contains("."))) {
			if(!(cadPessFis.contains("-"))) {
				this.cadPessFis = cadPessFis;
			}else {
				//				retirar pontos e traços conforme abaixo
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {//verificar traços e retirar
					for(int i = 0; i <cadPessFis.length(); i++) {//Retira traços
						String s = cadPessFis.substring(i, cadPessFis.indexOf("-"));
						cadPessFis = cadPessFis.substring(0,i) + s;
					}
				}
			}

		}
		else {
			for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
				if(!(cadPessFis.contains("."))) {
					break;
				}
				else{
					String s = cadPessFis.substring(0, cadPessFis.indexOf("."));
					cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
				}

			}
			if(cadPessFis.contains("-")) {//verificar traços e retirar
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					if(!(cadPessFis.contains("-"))) {
						break;
					}
					else{
						String s = cadPessFis.substring(0, cadPessFis.indexOf("-"));
						cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
					}

				}
			}
		}
		return this.cadPessFis; // retorna pesFis formato correto sem erros.
	}

	public int getSizeCPF() {
		int SizeCPF = 0;
		if(!(this.getFmCadPessFis().length() == 11)) {
			SizeCPF =  this.getFmCadPessFis().length();
		}
		else {
			SizeCPF = this.getFmCadPessFis().length();
		}
		return SizeCPF;
	}
}
