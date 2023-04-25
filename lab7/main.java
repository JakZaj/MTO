
import java.io.*;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'j')){
				int intParam = Integer.parseInt(param);
				String paramToPrint = Integer.toHexString(intParam).replace('a', 'g').replace('b', 'h').replace('c', 'i').replace('d', 'j').replace('f', 'l');
				System.out.print(paramToPrint);
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
