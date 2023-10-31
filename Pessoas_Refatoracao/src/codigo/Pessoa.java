package codigo;

public class Pessoa {
	String CPF;
	
	public Pessoa(String cpf) {
		this.validadeCPF(cpf);
	}

   protected boolean validadeCPF(String cpf) {
       cpf = removeFormats(cpf);
       if (!this.hasMinLenght(cpf)) {
           throw new IllegalArgumentException("CPF must have min 11 caracteres");
       }
       if (hasDigitRepeats(cpf)) {
           throw new IllegalArgumentException("CPF has all same digits");
       }
       if (!hasValidDigitVerifiers(cpf)) {
           throw new IllegalArgumentException("CPF has caracters validators invalid");
       }
       return true;
   }

   private String removeFormats(String cpf) {
       return cpf.replace(".", "").replace("-", "");
   }

   private boolean hasMinLenght(String cpf) {
       return cpf.length() == 11;
   }

   private boolean hasDigitRepeats(String cpf) {
       for (int i = 0; i < 11; i++) {
           if (i != 0 && cpf.startsWith(String.valueOf(i), i)) {
               return true;
           }
       }
       return false;
   }

   private boolean hasValidDigitVerifiers(String cpf) {
       int[] digitos = new int[11];
       for (int i = 0; i < 10; i++) {
           digitos[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
       }
       int soma = calculateSum(digitos, 9);
       int resultado = soma % 11;
       if (!isResultadoValido(resultado, digitos[9])) {
           return false;
       }
       soma = calculateSum(digitos, 10);
       resultado = soma % 11;
       return isResultadoValido(resultado, digitos[10]);
   }

   private boolean isResultadoValido(int resultado, int digito) {
		if (resultado == 10 || resultado == 11) {
			return digito == 0;
		} else {
			return digito == 11 - resultado;
		}
	}

   private int calculateSum(int[] digitos, int fator) {
       int soma = 0;
       for (int i = 0; i < fator; i++) {
           soma += (fator - i) * digitos[i];
       }
       return soma;
	}

	public String getCPF() {	
		return this.CPF;
	}

	public int getSizeCPF() {
		int sizeCPF = this.CPF.length();
		return sizeCPF; 
	}
}
