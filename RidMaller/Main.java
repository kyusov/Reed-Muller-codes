package RidMaller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kyusov
 * github.com/kyusov
 */

public class Main {

    private static Map<String, String> codeMap = new HashMap<>();

    public static int[] one = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public static int[][] bool = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1},
        {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
    };


    public static void main(String[] args) throws IOException {

        String[] alphabet = new Data().alphabet;
        String[] alphabetCodes = new Data().alphabetCodes;
        
        for (int i = 0; i < alphabet.length; i++) {
            codeMap.put(alphabet[i], alphabetCodes[i]);
        }

        BufferedReader reader = new BufferedReader(new FileReader("C:\\message.txt"));

        String line;

        List<String> msg = new ArrayList<>();

        List<String> ans = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            msg.add(line);
        }

        int alpha0, alpha1, alpha2, alpha3, alpha4, alpha5, alpha6;
        int[] gamma;

        for (int i = 0; i < msg.size(); i++) {

            //System.out.println("******************************  " + i + "  ******************************");
            alpha1 = calcAlpha1(msg.get(i));
            alpha2 = calcAlpha2(msg.get(i));
            alpha3 = calcAlpha3(msg.get(i));
            alpha4 = calcAlpha4(msg.get(i));
            alpha5 = calcAlpha5(msg.get(i));
            alpha6 = calcAlpha6(msg.get(i));
            gamma = calcGamma(alpha1, alpha2, alpha3, alpha4, alpha5, alpha6);
            alpha0 = calcAlpha0(gamma, msg.get(i));

//            System.out.println(
//                    "Альфа 0 = " + (alpha0 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha0) + "\n"
//                    + "Альфа 1 = " + (alpha1 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha1) + "\n"
//                    + "Альфа 2 = " + (alpha2 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha2) + "\n"
//                    + "Альфа 3 = " + (alpha3 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha3) + "\n"
//                    + "Альфа 4 = " + (alpha4 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha4) + "\n"
//                    + "Альфа 5 = " + (alpha5 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha5) + "\n"
//                    + "Альфа 6 = " + (alpha6 == -1 ? "Равное число 1 и 0. Исход неизвестен!" : alpha6) + "\n"
//            );
//
//            System.out.println("msg == " + msg.get(i));
//            System.out.println("str == " + getAnsString(gamma, alpha0, one));
            ans.add(getAnsString(gamma, alpha0, one));
        }

//        System.out.println("*****************************************************************");
//        System.out.println("\n");
        System.out.println("*****************************************************************");
        System.out.println("Сообщение декодировано!");
        System.out.println("Текст сообщения: " + decode(ans));
        System.out.println("*****************************************************************");

    }

    public static String decode(List<String> msg) {
        String answer = "";
        for (int i = 0; i < msg.size(); i++) {
            for (Map.Entry<String, String> entry : codeMap.entrySet()) {
                if (msg.get(i).equals(entry.getValue())) {
                    //System.out.println(msg.get(i) + "  ----  " + i + " : " + entry.getKey());
                    answer += entry.getKey();
                }
            }
        }
        return answer;
    }

    public static String getAnsString(int[] gamma, int alpha0, int[] one) {
        String str = "";
        for (int j = 0; j < 64; j++) {
            str += gamma[j] ^ (alpha0 * one[j]);
        }
        return str;
    }

    public static int[] calcGamma(int a1, int a2, int a3, int a4, int a5, int a6) {
        int[] gamma = new int[64];
        for (int j = 0; j < 64; j++) {
            gamma[j] = (a1 * bool[0][j]) ^ (a2 * bool[1][j]) ^ (a3 * bool[2][j]) ^ (a4 * bool[3][j]) ^ (a5 * bool[4][j]) ^ (a6 * bool[5][j]);
        }
        return gamma;
    }

    public static int calcAlpha0(int[] gamma, String msg) {
        int a0 = 0;
        for (int j = 0; j < 64; j++) {
            if ((gamma[j] ^ Integer.parseInt(String.valueOf(msg.charAt(j)))) == 1) {
                a0 += 1;
            } else {
                a0 -= 1;
            }
        }
        if (a0 > 0) {
            return 1;
        }
        if (a0 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha1(String msg) {
        int a1 = 0;

        for (int j = 0; j < 32; j++) {
            if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 32)))) == 1) {
                a1 += 1;
            } else {
                a1 -= 1;
            }
        }

        if (a1 > 0) {
            return 1;
        }
        if (a1 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha2(String msg) {
        int a2 = 0;
        for (int j = 0; j < 48; j++) {
            if (j < 16) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 16)))) == 1) {
                    a2 += 1;
                } else {
                    a2 -= 1;
                }
            }
            if (j > 31) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 16)))) == 1) {
                    a2 += 1;
                } else {
                    a2 -= 1;
                }
            }
        }
        if (a2 > 0) {
            return 1;
        }
        if (a2 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha3(String msg) {
        int g = 0;
        int a3 = 0;
        for (int j = 0; j < 56; j++) {
            if (g < 8) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 8)))) == 1) {
                    a3 += 1;
                } else {
                    a3 -= 1;
                }
                g++;
            } else if (g < 15) {
                g++;
            } else {
                g = 0;
            }
        }
        if (a3 > 0) {
            return 1;
        }
        if (a3 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha4(String msg) {
        int a4 = 0;
        int k = 0;
        for (int j = 0; j < 60; j++) {
            if (k < 4) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 4)))) == 1) {
                    a4 += 1;
                } else {
                    a4 -= 1;
                }
                k++;
            } else if (k < 7) {
                k++;
            } else {
                k = 0;
            }
        }
        if (a4 > 0) {
            return 1;
        }
        if (a4 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha5(String msg) {
        int k = 0;
        int a5 = 0;
        for (int j = 0; j < 62; j++) {
            if (k < 2) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 2)))) == 1) {
                    a5 += 1;
                } else {
                    a5 -= 1;
                }
                k++;
            } else if (k % 2 == 1) {
                k -= 3;
            } else {
                k++;
            }
        }
        if (a5 > 0) {
            return 1;
        }
        if (a5 < 0) {
            return 0;
        }
        return -1;
    }

    public static int calcAlpha6(String msg) {
        int k = 0;
        int a6 = 0;
        for (int j = 0; j < 63; j++) {
            if (k < 1) {
                if ((Integer.parseInt(String.valueOf(msg.charAt(j))) ^ Integer.parseInt(String.valueOf(msg.charAt(j + 1)))) == 1) {
                    a6 += 1;
                } else {
                    a6 -= 1;
                }
                k++;
            } else {
                k--;
            }
        }
        if (a6 > 0) {
            return 1;
        }
        if (a6 < 0) {
            return 0;
        }
        return -1;
    }

}
