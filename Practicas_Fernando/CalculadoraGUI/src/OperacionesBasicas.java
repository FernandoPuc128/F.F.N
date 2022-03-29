public class OperacionesBasicas {

	public String opResultado(String operador, int pNum, int sNum) {
		// Operaciones
		switch (operador) {
			// Suma
			case "+":
				int suma = pNum + sNum;
				return suma + "";

			// Resta
			case "-":
				int resta = pNum - sNum;
				return resta + "";

			// Division
			case "/":
				if (pNum > 0 && sNum > 0) {
					int division = pNum / sNum;
					return division + "";
				} else {
					return "No se puede dividir ya que se divide entre 0";
				}

				// Multiplicacion
			case "*":
				int multiplicacion = pNum * sNum;
				return multiplicacion + "";

			// Elevacion
			case "^":
				if (sNum != 0) {
					double elevar = Math.pow(pNum, sNum);
					return elevar + "";
				}
				break;
			default:
				return "";

		}
		return null;
	}
}
