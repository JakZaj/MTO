
import java.io.*;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'g')){
				String strToPrint = "";
				Boolean nega = false;
				if(param.charAt(0) == '-'){
					nega = true;
					param = param.substring(1);
				}
				for(int k = 0; k < param.length(); k++){
					strToPrint = param.charAt(k) + strToPrint;
				}
				if(nega){
					System.out.print(Integer.parseInt('-' + strToPrint));
				}
				else{
					System.out.print(Integer.parseInt(strToPrint));
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
