/* **************************************************************************
 * Description: This program tracks bead movements between consecutive images.
 * For each bead in the second image, it finds the closest bead in the first one.
 * It prints the distances between beads, assuming no collision.
 **************************************************************************** */
public class BeadTracker {

    //  prints the distances travelled by blobs from image to image
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        String[] files = new String[args.length - 3];
        for (int i = 3; i < args.length; i++) {
            files[i - 3] = args[i];
        }

        //  process each pair of images
        for (int i = 0; i < files.length - 1; i++) {
            String first = files[i];
            String second = files[i + 1];
            Picture firstPic = new Picture(first);
            Picture secondPic = new Picture(second);
            BeadFinder firstFin = new BeadFinder(firstPic, tau);
            BeadFinder secondFin = new BeadFinder(secondPic, tau);
            Blob[] firstBea = firstFin.getBeads(min);
            Blob[] secondBea = secondFin.getBeads(min);

            //  find beads closest to each other in both
            for (Blob outer : secondBea) {
                Blob closest = null;
                double dMin = Double.POSITIVE_INFINITY;
                for (Blob inner : firstBea) {
                    double d = outer.distanceTo(inner);
                    if (d < dMin) {
                        closest = inner;
                        dMin = d;
                    }
                }
                if (closest != null && dMin <= delta) {
                    System.out.printf("%.4f%n", dMin);
                }
            }
        }
    }
}
