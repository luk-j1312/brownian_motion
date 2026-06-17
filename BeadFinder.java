import java.awt.Color;

public class BeadFinder {

    //  stack of blobs found
    private Stack<Blob> blobs;

    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {
        int width = picture.width();
        int height = picture.height();
        boolean[][] checked = new boolean[width][height];
        this.blobs = new Stack<Blob>();
        boolean[][] white = new boolean[width][height];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color color = picture.get(col, row);
                double intens = Luminance.intensity(color);
                white[col][row] = (intens >= tau);
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (white[col][row] && !checked[col][row]) {
                    checked[col][row] = true;
                    Blob blobHere = new Blob();
                    Stack<int[]> adjacent = new Stack<int[]>();
                    int[] local = { col, row };
                    adjacent.push(local);

                    while (!adjacent.isEmpty()) {
                        int[] pixCurrent = adjacent.pop();
                        int colHere = pixCurrent[0];
                        int rowHere = pixCurrent[1];
                        blobHere.add(colHere, rowHere);

                        if (rowHere > 0 && !checked[colHere][rowHere - 1]
                                && white[colHere][rowHere - 1]) {
                            //  local variable that stores surrounding location
                            int[] prox = { colHere, rowHere - 1 };
                            adjacent.push(prox);
                            checked[colHere][rowHere - 1] = true;
                        }

                        if (rowHere < height - 1 && !checked[colHere][rowHere + 1]
                                && white[colHere][rowHere + 1]) {
                            int[] prox = { colHere, rowHere + 1 };
                            adjacent.push(prox);
                            checked[colHere][rowHere + 1] = true;
                        }

                        if (colHere < width - 1 && !checked[colHere + 1][rowHere]
                                && white[colHere + 1][rowHere]) {
                            int[] prox = { colHere + 1, rowHere };
                            adjacent.push(prox);
                            checked[colHere + 1][rowHere] = true;
                        }

                        if (colHere > 0 && !checked[colHere - 1][rowHere]
                                && white[colHere - 1][rowHere]) {
                            int[] prox = { colHere - 1, rowHere };
                            adjacent.push(prox);
                            checked[colHere - 1][rowHere] = true;
                        }
                    }

                    blobs.push(blobHere);
                }
            }
        }
    }

    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        int count = 0;
        for (Blob b : blobs) {
            if (b.mass() >= min) count++;
        }
        Blob[] beads = new Blob[count];
        int i = 0;
        for (Blob b : blobs) {
            if (b.mass() >= min) {
                beads[i] = b;
                i++;
            }
        }
        return beads;
    }

    //  test client, as described below
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        String file = args[2];
        Picture pic = new Picture(file);
        BeadFinder test = new BeadFinder(pic, tau);
        Blob[] testBeads = test.getBeads(min);
        for (Blob b : testBeads) {
            StdOut.println(b.toString());
        }
    }
}
