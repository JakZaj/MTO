import java.io.*;
import java.math.BigInteger;

class lab0 {
    public static void my_printf(String format_string, String param) {
        for (int i = 0; i < format_string.length(); i++) {
            if ((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == 'b')) {
                BigInteger bigInteger = new BigInteger(param);
                param = bigInteger.toString(2);

                String output = "";
                for (int k = param.length() - 1; k >= 0; k--) {

                    if (param.charAt(k) == '0') {
                        output = '0' + output;
                    } else {
                        output = returnLetter((param.length() - 1 - k) % 10) + output;
                    }
                }

                System.out.print(output);

                i++;
            } else {
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println("");
    }

    public static char returnLetter(int i) {
        switch (i) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            case 8:
                return 'i';
            case 9:
                return 'j';
        }
        return '0';
    }

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello, World!");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc=new Scanner(System.in);
        String format_string, param;
        while (bufferReader.ready()) {
            format_string = bufferReader.readLine();
            param = bufferReader.readLine();
            my_printf(format_string, param);
        }
    }
}
