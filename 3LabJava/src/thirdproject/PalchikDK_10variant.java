package thirdproject;

import java.util.Scanner;

class PalchikDK_10variant {

    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        while ( in.hasNextLine() ) {
            String inputString = in.nextLine();
            String temp = "";
            String outString = "";
            String out = "";
            int maxcount = -1;
            for ( int i = 0; i < inputString.length(); i++ ) {
                if(Character.UnicodeBlock.of(inputString.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) && temp.indexOf(inputString.toLowerCase().charAt(i)) == -1 && " ,-:;.\r\n".indexOf(inputString.charAt(i)) == -1) {
                	temp += inputString.toLowerCase().charAt(i);
                	outString += inputString.charAt(i);
                }
                else {
                	if(outString.length() == maxcount) {
                		out = out + outString + " ";
                	}
                	if(outString.length() > maxcount) {
                		maxcount = outString.length();
                		out = outString + " ";
                	}
                	outString = "";
            		temp = "";
                }
            }
            System.out.println(out + " ");
        }
        in.close();
    }
}

