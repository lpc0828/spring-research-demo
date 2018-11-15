public class APP {

    public static void main(String[] args) {
        printDanteng();
    }


    public static void printDanteng() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(i + (i < 3 ? repeat("+", i + 1) : repeat("=", i + 1)));
        }
    }

    private static String repeat(String chr, int repeatTimes) {
        StringBuffer sb = new StringBuffer(repeatTimes);
        for (int i = 0; i < repeatTimes; i++) {
            sb.append(chr);
        }
        return sb.toString();
    }
}
