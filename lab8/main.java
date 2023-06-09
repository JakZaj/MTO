import java.io.*;
import java.math.BigInteger;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == 'j')) {
				BigInteger bigInteger = new BigInteger(param);
				String paramToPrint = bigInteger.toString(16).replace('0', 'o').replace('a', 'g').replace('b', 'h').replace('c', 'i').replace('d', 'j').replace('e', 'k').replace('f', 'l');
				System.out.print(paramToPrint);
				i++;
			} else if((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == '.') && (Character.isDigit(format_string.charAt(i + 2))) && (format_string.charAt(i + 3) == 'j')){
				BigInteger bigInteger = new BigInteger(param);
				String paramToPrint = bigInteger.toString(16).replace('0','o').replace('a', 'g').replace('b', 'h').replace('c', 'i').replace('d', 'j').replace('e', 'k').replace('f', 'l');

				int z=format_string.charAt(i + 2) - '0';
				
				if(z > paramToPrint.length())
					for(int k = 0; k < z - paramToPrint.length(); k++) {
						if (paramToPrint.charAt(0) == '-') {
							paramToPrint = "-o" + paramToPrint.substring(1);
							k--;
						} else {
							paramToPrint = "o" + paramToPrint;
						}
					}

				System.out.print(paramToPrint);

				i+=3;
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
