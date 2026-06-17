public class Blob {

    //  sum of x coordinates
    private int xSum;

    //  sum of y coordinates
    private int ySum;

    //  total pixels in this blob
    private int mass;

    //  creates an empty blob
    public Blob() {
        this.mass = 0;
        this.xSum = 0;
        this.ySum = 0;
    }

    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        mass++;
        xSum += x;
        ySum += y;
    }

    //  number of pixels added to this blob
    public int mass() {
        return mass;
    }

    //  Euclidean distance between the center of masses of the two blobs
    public double distanceTo(Blob that) {
        double xDelta = ((double) this.xSum / this.mass) -
                ((double) that.xSum / that.mass);
        double yDelta = ((double) this.ySum / this.mass) -
                ((double) that.ySum / that.mass);
        double d = Math.sqrt(xDelta * xDelta + yDelta * yDelta);
        return d;
    }

    //  string representation of this blob (see below)
    public String toString() {
        String result = String.format("%d (%.4f, %.4f)", mass, (double) xSum / mass,
                                      (double) ySum / mass);
        return result;
    }

    //  tests this class by directly calling all instance methods
    public static void main(String[] args) {

        //  creates a test blob
        Blob test = new Blob();
        test.add(270, 72);
        test.add(321, 123);
        test.add(498, 402);
        StdOut.println("What is the mass of the test blob? " + test.mass());
        StdOut.println(test.toString());

        //  creates another blob whose distance from the original test blob is given
        Blob compare = new Blob();
        compare.add(112, 93);
        compare.add(67, 451);
        StdOut.println(compare.toString());
        StdOut.print("How far are the two blobs from each other on average? ");
        StdOut.println(test.distanceTo(compare));
    }
}
