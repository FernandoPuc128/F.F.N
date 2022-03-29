package NATIVIDAD.Practica1;

public class OperacionesCalculadora {

	public String opResultado(String operador, int pNum, int sNum){

		switch(operador){
		case"+":
			int suma= pNum +sNum;
			return suma+"";
			
		case "-":
		int resta=pNum-sNum;
		return resta+"";
		
		case "/":
			if (pNum>0 && sNum>0){
				int divicion=pNum/sNum;
				return divicion +"";
			}else {
				return "No se puede dividir entre 0";
			}
			
		case "*":
			int multiplicacion=pNum*sNum;
			return multiplicacion+"";
			
		case "^":
			if(sNum !=0){
				double elevar = Math.pow(pNum, sNum);
				return elevar + "";
			}
			break;
			default:
			return"";
				
		}
		return null;
		
	}
	
	
}
