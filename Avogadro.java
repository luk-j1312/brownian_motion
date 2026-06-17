//  class whose main calculates Boltzmann constant and
//  Avogadro's number
public class Avogadro {

    //  calculates Boltzmann constant and Avogadro's number using
    //  Einstein–Smoluchowski equation and Stokes-Einstein relation
    public static void main(String[] args) {
        int count = 0;
        double ssq = 0;
        while (!StdIn.isEmpty()) {
            count++;
            double in = StdIn.readDouble() * 0.175e-6;
            ssq += in * in;
        }
        double d = ssq / (2 * count);
        final double TEMP = 297;
        final double GAS_CONSTANT = 8.31446;
        final double VISC = 9.135e-4;
        final double RAD = 0.5e-6;
        double k = (6 * d * Math.PI * VISC * RAD) / TEMP;
        double avo = GAS_CONSTANT / k;
        final double TEN = 10;
        final double ROUND = 10000;


        double kCompare = Math.abs(k);
        int kPow = 0;
        if (kCompare >= TEN) {
            while (kCompare >= TEN) {
                kPow++;
                kCompare /= TEN;
            }
        }
        else if (kCompare > 0.0 && kCompare < 1.0) {
            while (kCompare < 1.0) {
                kPow--;
                kCompare *= TEN;
            }
        }
        kCompare = Math.round(kCompare * ROUND) / ROUND;
        if (kCompare >= TEN) {
            kPow++;
            kCompare /= TEN;
        }
        String kPowPrint;
        if (kPow >= 0) kPowPrint = "+" + kPow;
        else kPowPrint = "" + kPow;
        String kF = String.format("%.4fe%s", kCompare, kPowPrint);
        StdOut.println("Boltzmann = " + kF);


        double avoCompare = Math.abs(avo);
        int avoPow = 0;
        if (avoCompare >= TEN) {
            while (avoCompare >= TEN) {
                avoPow++;
                avoCompare /= TEN;
            }
        }
        else if (avoCompare > 0.0 && avoCompare < 1.0) {
            while (avoCompare < 1.0) {
                avoPow--;
                avoCompare *= TEN;
            }
        }
        avoCompare = Math.round(avoCompare * ROUND) / ROUND;
        if (avoCompare >= TEN) {
            avoPow++;
            avoCompare /= TEN;
        }
        String avoPowPrint;
        if (avoPow >= 0) avoPowPrint = "+" + avoPow;
        else avoPowPrint = "" + avoPow;
        String avoF = String.format("%.4fe%s", avoCompare, avoPowPrint);
        StdOut.println("Avogadro  = " + avoF);
    }
}
