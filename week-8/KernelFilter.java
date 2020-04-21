/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    private static Picture applyKernel(Picture picture, int[][] kernel, int num, int denum) {

        int h = picture.height(), w = picture.width(), offset = kernel.length / 2;

        Picture new_picture = new Picture(w, h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {

                int offset_i = i - offset;
                int offset_j = j - offset;
                double new_value_r = 0, new_value_g = 0, new_value_b = 0;

                for (int k = 0; k < kernel.length; k++) {
                    int row_index = (offset_i + h + k) % h;

                    for (int l = 0; l < kernel[k].length; l++) {

                        int col_index = (offset_j + w + l) % w;

                        Color color = picture.get(col_index, row_index);

                        new_value_r += (color.getRed() * kernel[k][l]);
                        new_value_g += (color.getGreen() * kernel[k][l]);
                        new_value_b += (color.getBlue() * kernel[k][l]);

                    }
                }

                new_value_r = Math.min(Math.max((new_value_r / denum * num), 0.0), 255.0);
                new_value_g = Math.min(Math.max((new_value_g / denum * num), 0.0), 255.0);
                new_value_b = Math.min(Math.max((new_value_b / denum * num), 0.0), 255.0);


                int r = (int) Math.round(new_value_r);
                int g = (int) Math.round(new_value_g);
                int b = (int) Math.round(new_value_b);

                Color new_color = new Color(r, g, b);

                new_picture.set(j, i, new_color);
            }
        }

        return new_picture;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] kernel = new int[][] { { 1, 2, 1 }, { 2, 4, 2 }, { 1, 2, 1 } };
        int num = 1;
        int denum = 16;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] kernel = new int[][] { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        int num = 1;
        int denum = 1;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] kernel = new int[][] {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        int num = 1;
        int denum = 1;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] kernel = new int[][] {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        int num = 1;
        int denum = 1;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] kernel = new int[][] {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1 }
        };
        int num = 1;
        int denum = 9;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    private static Picture identity(Picture picture) {
        int[][] kernel = new int[][] {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        int num = 1;
        int denum = 1;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    private static Picture horGradient(Picture picture) {
        int[][] kernel = new int[][] {
                { 0, 0, 0 },
                { -1, 0, 1 },
                { 0, 0, 0 }
        };
        int num = 1;
        int denum = 2;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    private static Picture verGradient(Picture picture) {
        int[][] kernel = new int[][] {
                { 0, -1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 }
        };
        int num = 1;
        int denum = 2;
        picture = applyKernel(picture, kernel, num, denum);
        return picture;
    }

    // Test client.
    public static void main(String[] args) {

        Picture picture = new Picture(args[0]);
        // picture.show();

        Picture pic = gaussian(picture);
        pic.show();
        Picture pic1 = sharpen(picture);
        pic1.show();
        Picture pic2 = laplacian(picture);
        pic2.show();
        Picture pic3 = emboss(picture);
        pic3.show();
        Picture pic4 = motionBlur(picture);
        pic4.show();
        // Picture pic5 = verGradient(picture);
        // pic5.show();
        // Picture pic6 = horGradient(picture);
        // pic6.show();
        // Picture pic7 = identity(picture);
        // pic7.show();
    }
}
