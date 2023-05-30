import java.io.*;
import java.math.BigInteger;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == 'a')) {

				BigInteger bigInteger = new BigInteger(param);

				param = bigInteger.toString();

				BigInteger valueF = bigInteger.multiply(BigInteger.valueOf(2));
				if(param.charAt(0) == '-') {
					valueF = valueF.divide(BigInteger.valueOf(param.length() - 1));
				} else {
					valueF = valueF.divide(BigInteger.valueOf(param.length()));
				}

				if(valueF.mod(new BigInteger("2")).equals(BigInteger.ZERO)){
					System.out.print(valueF);
				} else {
					System.out.print(valueF.toString(16));
				}

				i++;
			}else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
		//System.out.println("Hello, World!"); 
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		String format_string, param;
		while(bufferReader.ready()) {
			format_string=bufferReader.readLine();
			param=bufferReader.readLine();
			my_printf(format_string,param);
		}
	}
}
