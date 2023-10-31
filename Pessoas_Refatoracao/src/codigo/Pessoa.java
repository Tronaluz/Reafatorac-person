//Enviar c�digo refatorado (c�digo e testes)
//e um documento contendo lista dos Mal Cheiros
//e quais as solu��es adotadas.



package codigo;

public class Pessoa {

	String cadPessFis;// cadastro �nico de pessoas f�sicas no brasil internacional
	String n; // nome do cidad�o. Exemplo "nome com 3 letras!"
	String s; // chamado de last name nos EUA
	public boolean existe() { //Ser� que essa pessoa existe? 
		boolean existe;
		boolean cpfEx = this.verCPF() ? true :  false; // opera��o tern�ria procurando erros e falhas
		if(!cpfEx) {
			existe = false; // cpf inexistente encontrado para verificar que n�o h� um cpf
		}
		else {
			if(cpfEx && !(this.cadPessFis.length() == 11)) {
				existe = false;//n�o sei ao certo mas tem rela��o com cpf
			}
			else {
				if(!(this.n.length() > 3)) {//ver nom est� preenchido com mai de tri letras
					existe = false;
				}
				else {
					if(!(this.s.length() > 3)) { // ver sobrenom existe e t� com todas as letras
						existe = false;//sobrenome n�o existe no banco de dados da receita federEl
					}
					else {
						existe = true; // nome e cpf existentes, sobrenome! Pessoa existente 
					}
				}
			}
		}
		try {
			System.out.println("Algo pode dar errado no c�digo acima, n�o mexer");
			return existe; // evita problemas
		} catch (Exception e) {
			System.err.println("Algo deu errado no c�digo acima, cuidado ao mexer");
			return existe; // aconteceu um erro grande
		}
	}

	private boolean verCPF() { // ser� que tem um cpf v�lido na mesma formato de n�o conter pontos, virgulas ou tra�os?
		boolean ehNaovalCpfInvNull;
		if(!(this.cadPessFis == null)) { // verifica se cpf � nulo
			if ((!(!(!(this.cadPessFis.length() == 11))))) {//verifica tamanho do cpf com pontos e tra�os
				ehNaovalCpfInvNull = false;//retorna cpf v�lido
			}
			else {
				ehNaovalCpfInvNull = true;//retorna cpf inv�lido
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

	public void setCadPessFis(String cadPessFis) { // m�todo que inclui e verifica formato do cpf
		if(!(cadPessFis.contains("."))) {
			if(!(cadPessFis.contains("-"))) {
				this.cadPessFis = cadPessFis;
			}else {
				//				retirar pontos e tra�os conforme abaixo
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {//verificar tra�os e retirar
					for(int i = 0; i <cadPessFis.length(); i++) {//Retira tra�os
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
			if(cadPessFis.contains("-")) {//verificar tra�os e retirar
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
				//				retirar pontos e tra�os conforme abaixo
				for(int i = 0; i <cadPessFis.length(); i++) {//Retira pontos 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {//verificar tra�os e retirar
					for(int i = 0; i <cadPessFis.length(); i++) {//Retira tra�os
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
			if(cadPessFis.contains("-")) {//verificar tra�os e retirar
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
