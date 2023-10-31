package codigo;

public class Pessoa {

	String cadPessFis;	
	String n; 
	String s; 
	public boolean existe() {  
		boolean existe;
		boolean cpfEx = this.verCPF() ? true :  false; 
		if(!cpfEx) {
			existe = false;
		}
		else {
			if(cpfEx && !(this.cadPessFis.length() == 11)) {
				existe = false;			
			}
			else {
				if(!(this.n.length() > 3)) {
					existe = false;
				}
				else {
					if(!(this.s.length() > 3)) { 
						existe = false;
					}
					else {
						existe = true; 
					}
				}
			}
		}
		try {
			System.out.println("Algo pode dar errado no c�digo acima, n�o mexer");
			return existe; 
		} catch (Exception e) {
			System.err.println("Algo deu errado no c�digo acima, cuidado ao mexer");
			return existe; 
		}
	}

	private boolean verCPF() { 
		boolean ehNaovalCpfInvNull;
		if(!(this.cadPessFis == null)) { 
			if ((!(!(!(this.cadPessFis.length() == 11))))) {
				ehNaovalCpfInvNull = false;
			}
			else {
				ehNaovalCpfInvNull = true;
			}
		}
		else {
			ehNaovalCpfInvNull = false;
		}
		return ehNaovalCpfInvNull;
	}

	public String getCadPessFis() {
		return cadPessFis;
	}

	public void setCadPessFis(String cadPessFis) { 
		if(!(cadPessFis.contains("."))) {
			if(!(cadPessFis.contains("-"))) {
				this.cadPessFis = cadPessFis;
			}else {
				for(int i = 0; i <cadPessFis.length(); i++) { 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {
					for(int i = 0; i <cadPessFis.length(); i++) {
						String s = cadPessFis.substring(i, cadPessFis.indexOf("-"));
						cadPessFis = cadPessFis.substring(0,i) + s;
					}
				}
			}

		}
		else {
			for(int i = 0; i <cadPessFis.length(); i++) {
				if(!(cadPessFis.contains("."))) {
					break;
				}
				else{
					String s = cadPessFis.substring(0, cadPessFis.indexOf("."));
					cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
				}

			}
			if(cadPessFis.contains("-")) {
				for(int i = 0; i <cadPessFis.length(); i++) {
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

	public String getN() {
		return n;
	}

	public void setN(String n) { 
		this.n = n;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) { 
		this.s = s;
	}

	public String getFmCadPessFis() { 
		if(!(cadPessFis.contains("."))) {
			if(!(cadPessFis.contains("-"))) {
				this.cadPessFis = cadPessFis;
			}else {
				for(int i = 0; i <cadPessFis.length(); i++) { 
					String s = cadPessFis.substring(i, cadPessFis.indexOf("."));
					cadPessFis = cadPessFis.substring(0,i) + s;
				}
				if(cadPessFis.contains("-")) {
					for(int i = 0; i <cadPessFis.length(); i++) {
						String s = cadPessFis.substring(i, cadPessFis.indexOf("-"));
						cadPessFis = cadPessFis.substring(0,i) + s;
					}
				}
			}

		}
		else {
			for(int i = 0; i <cadPessFis.length(); i++) {
				if(!(cadPessFis.contains("."))) {
					break;
				}
				else{
					String s = cadPessFis.substring(0, cadPessFis.indexOf("."));
					cadPessFis = s + cadPessFis.substring(s.length()+1,cadPessFis.length());
				}

			}
			if(cadPessFis.contains("-")) {
				for(int i = 0; i <cadPessFis.length(); i++) {
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
		return this.cadPessFis; 
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
