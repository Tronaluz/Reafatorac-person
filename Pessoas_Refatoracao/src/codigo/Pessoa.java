package codigo;

public class Pessoa {
	String CPF;
	
	public Pessoa(String cpf) {
		this.validadeCPF(cpf);
	}

   protected boolean validadeCPF(String cpf) {
       cpf = removerFormatacao(cpf);
       if (!temTamanhoValido(cpf)) {
           throw new IllegalArgumentException("CPF must have min 11 caracteres");
       }
       if (temDigitosRepetidos(cpf)) {
           throw new IllegalArgumentException("CPF has all same digits");
       }
       if (!temDigitosVerificadoresValidos(cpf)) {
           throw new IllegalArgumentException("CPF has caracters validators invalid");
       }
       return true;
   }

   private String removerFormatacao(String cpf) {
       return cpf.replace(".", "").replace("-", "");
   }

   private boolean temTamanhoValido(String cpf) {
       return cpf.length() == 11;
   }

   private boolean temDigitosRepetidos(String cpf) {
       for (int i = 0; i < 11; i++) {
           if (i != 0 && cpf.startsWith(String.valueOf(i), i)) {
               return true;
           }
       }
       return false;
   }

   private boolean temDigitosVerificadoresValidos(String cpf) {
       int[] digitos = new int[11];
       for (int i = 0; i < 10; i++) {
           digitos[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
       }

       int soma = calcularSoma(digitos, 9);
       int resultado = soma % 11;
       if (!isResultadoValido(resultado, digitos[9])) {
           return false;
       }

       soma = calcularSoma(digitos, 10);
       resultado = soma % 11;
       return isResultadoValido(resultado, digitos[10]);
   }

   private int calcularSoma(int[] digitos, int fator) {
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
