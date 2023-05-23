import java.io.*;
import java.math.BigInteger;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == '.') && (Character.isDigit(format_string.charAt(i + 2)))){
				int formatStringPosition = i + 3;
				int valueofZ = format_string.charAt(i + 2) - '0';
				System.out.print("beforewhile\n");
				while(Character.isDigit(format_string.charAt(formatStringPosition))){
					System.out.print("while\n");
					valueofZ *= 10;
					valueofZ += format_string.charAt(formatStringPosition) - '0';
					formatStringPosition++;
				}
				System.out.print("after\n");
				if(format_string.charAt(formatStringPosition) == 'h')
				{
					int pointIndex = param.indexOf('.');

					if(pointIndex == -1)
						pointIndex = param.length();

					int k = 0;
					String paramBeforePoint = "";
					for( ; k<pointIndex; k++){
						paramBeforePoint = paramBeforePoint + param.charAt(k);
					}

					//skip pointer
					k++;
					String paramAfterPoint = "";

					if(pointIndex == param.length()){
						if(valueofZ != 0){
							for(int c = 0; c < valueofZ; c++)
								paramAfterPoint = paramAfterPoint + changeCharAfterPointer('0');

							for(int c = 0; c < paramBeforePoint.length(); c++)
								System.out.print(changeCharBeforePointer(paramBeforePoint.charAt(c)));
							System.out.print('.' + paramAfterPoint);
							i += formatStringPosition - i;
							continue;
						}
						else
						{
							for(int c = 0; c < paramBeforePoint.length(); c++)
								System.out.print(changeCharBeforePointer(paramBeforePoint.charAt(c)));
							i += formatStringPosition - i;
							continue;
						}
					}


//					if(param.length() - pointIndex < valueofZ) {
//						for (; k < param.length(); k++) {
//							if (k + 1 == param.length()) {
//								if (param.charAt(k + 1) - '0' > 5) {
//									paramAfterPoint = paramAfterPoint + (param.charAt(k)+1);
//								} else {
//									paramAfterPoint = paramAfterPoint + param.charAt(k);
//								}
//							} else {
//								paramAfterPoint = paramAfterPoint + param.charAt(k);
//							}
//						}
//						for(; k-pointIndex + 1 < valueofZ; k++)
//							paramAfterPoint = paramAfterPoint + changeCharAfterPointer('0');
//					}
//					else {
//						for (; k < param.length(); k++) {
//							paramAfterPoint = paramAfterPoint + param.charAt(k);
//
//						}
//					}
//
//
//					for(int c = 0; c < paramBeforePoint.length(); c++)
//						System.out.print(changeCharBeforePointer(paramBeforePoint.charAt(c)));
//					System.out.print('.');
//					for(int c = 0; c < paramAfterPoint.length(); c++)
//						System.out.print(changeCharAfterPointer(paramAfterPoint.charAt(c)));
//					i += formatStringPosition - i;
				}
				else
				{
					System.out.print(format_string.charAt(i));
				}

			}else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}

	public static char changeCharBeforePointer(char c){

		switch (c) {
			case '0' : return 'a';
			case '1' : return 'b';
			case '2' : return 'c';
			case '3' : return 'd';
			case '4' : return 'e';
			case '5' : return 'f';
			case '6' : return 'g';
			case '7' : return 'h';
			case '8' : return 'i';
			case '9' : return 'j';
		};
		 return c;
	}

	public static char changeCharAfterPointer(char c){
		return (char)((((c - '0')+5)%10)+'0');
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
