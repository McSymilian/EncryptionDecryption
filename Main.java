package encryptdecrypt;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        String pathIn = "";
        String pathOut = "";
        String alg = "shift";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                mode = args[++i];
            }

            if ("-key".equals(args[i])) {
                key = Integer.parseInt(args[++i]);
            }

            if ("-out".equals(args[i])) {
                pathOut = args[++i];
            }

            if ("-data".equals(args[i])) {
                data = args[++i];
            } else if ("-in".equals(args[i])) {
                pathIn = args[++i];
            }

            if ("-alg".equals(args[i])) {
                alg = args[++i];
            }
        }
        String result;
        String text = "";
        try {
            if (!data.equals("")) {
                text = data;
            } else if (!pathIn.equals("")) {
                File file = new File(pathIn);
                Scanner in = new Scanner(file);
                text = in.nextLine();
                in.close();
            }
            Algorithm engine = null;
            if ("enc".equals(mode)) {
                if ("shift".equals(alg)) {
                    engine = new EncryptShift();
                } else if ("unicode".equals(alg)) {
                    engine = new EncryptUnicode();
                }
            } else {
                if ("shift".equals(alg)) {
                    engine = new DecryptShift();
                } else if ("unicode".equals(alg)) {
                    engine = new DecryptUnicode();
                }
            }
            assert engine != null;
            result = engine.action(text, key);
            if ("".equals(pathOut)) {
                System.out.println(result);
            } else {
                PrintWriter output = new PrintWriter(new File(pathOut));
                output.println(result);
                output.close();
            }

        }catch (Exception e) {
            System.out.println("Error");
        }
    }
}
