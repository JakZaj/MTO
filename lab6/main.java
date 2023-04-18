
import java.io.*;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'g')){
				System.out.print(doNewNumber(param));
				i++;
			}else if((format_string.charAt(i) == '#') && (Character.isDigit(format_string.charAt(i+1))) && (format_string.charAt(i+2) == 'g')){
				if((int)(format_string.charAt(i+1) - '0') < param.length())
					System.out.print(doNewNumber(param).substring(0, (int)(format_string.charAt(i+1) - '0')));
				else{
					System.out.print(doNewNumber(param));
				}
				i+=2;
			}
			else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}

	public static String doNewNumber(String strNumber){

		String retStr = "";
		int number = 0;
		for(int i=0;i < strNumber.length();i++){
			number = (int)strNumber.charAt(i);
			number = (number * 9 + 1) % 10;
			if(number == 0)
				continue;

			retStr += (char)(number);

		}
		return retStr;
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
