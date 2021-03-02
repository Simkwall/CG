import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class GraphicsPanel extends JPanel implements Runnable {


    private Line x;
    private Line y;

    int[][] mat1 = {//3 2
            {100, 400},
            {100, 200},
            {200, 200}
    };

    GraphicsPanel() {
        x = new Line(-400, 0, 400, 0);
        y = new Line(0, -400, 0, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int[][]mat3 = new int[mat1.length][Matrix.mat2[0].length];
        int[][]mat5 = new int [mat1.length][Matrix.mat2[0].length];
        int[][]mat7 = new int [mat1.length][Matrix.mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < Matrix.mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat3[i][j] = mat3[i][j] + mat1[i][k] * Matrix.mat2[k][j];
                    mat5[i][j] = mat5[i][j] + mat1[i][k] * Matrix.mat4[k][j];
                    mat7[i][j] = mat7[i][j] + mat1[i][k] * Matrix.mat6[k][j];
                }
            }
        }

        g2.drawPolygon(arraptationx(mat1), arraptationy(mat1), 3);
        g2.drawPolygon(arraptationx(mat3), arraptationy(mat3), 3);
        g2.drawPolygon(arraptationx(mat5), arraptationy(mat5), 3);
        g2.drawPolygon(arraptationx(mat7), arraptationy(mat7), 3);
        g2.draw(x);
        g2.draw(y);
        repaint();
        g2.dispose();
    }


    public void ShiftLeft() {

        for (int i = 0; i < mat1.length; i++) {
            mat1[i][0] = mat1[i][0] - 10;
        }




    }

    public void ShiftRight() {
        for (int i = 0; i < mat1.length; i++) {
            mat1[i][0] = mat1[i][0] + 10;
        }


    }

    public void ShiftUp() {

        for (int i = 0; i < mat1.length; i++) {
            mat1[i][1] = mat1[i][1] + 10;
        }


    }

    public void ShiftDown() {
        for (int i = 0; i < mat1.length; i++) {
            mat1[i][1] = mat1[i][1] - 10;
        }


    }

    public void Change1() {
        int[][] mat9 = new int[mat1.length][Matrix.mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < Matrix.mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat9[i][j] = mat9[i][j] + mat1[i][k] * Matrix.mat8[k][j];
                }
            }
        }
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < Matrix.mat2[0].length; j++) {
                mat1[i][j] = mat9[i][j];
            }
        }
    }

    public void Change2() {
        double[][] mat9 = new double[mat1.length][Matrix.mat2[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < Matrix.mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat9[i][j] = mat9[i][j] + mat1[i][k] * Matrix.mat10[k][j];
                }
            }
        }
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < Matrix.mat2[0].length; j++) {
                mat1[i][j] = (int) mat9[i][j];
            }
        }
    }

    public int[] arraptationx(int[][] mat) {
        int[] arr1 = new int[3];

        for (int i = 0; i < 3; i++) {
            arr1[i] = mat[i][0] + 400;
        }
        return arr1;
    }

    public int[] arraptationy(int[][] mat) {
        int[] arr2 = new int[3];
        for (int i = 0; i < 3; i++) {
            arr2[i] = -(mat[i][1]) + 400;
        }
        return arr2;
    }

    @Override
    public void run() {
        repaint();

    }

}
