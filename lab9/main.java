import java.io.*;
import java.math.BigInteger;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == '.') && (Character.isDigit(format_string.charAt(i + 2)))){
				int formatStringPosition = i + 3;
				int valueofZ = format_string.charAt(i + 2) - '0';

				while(Character.isDigit(format_string.charAt(formatStringPosition))){
					valueofZ *= 10;
					valueofZ += format_string.charAt(formatStringPosition) - '0';
					formatStringPosition++;
				}
				if(format_string.charAt(formatStringPosition) == 'h')

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
