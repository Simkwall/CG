public class Matrix {

/*    static double[][] mat1 = {//3 2
            {100,400},
            {100,200},
            {200,200}
    };
*/
   static double[][] mat2 = {//2 2
            {1,0},
            {0,-1}

    };

    static double[][] mat4 = {//2 2
            {(-1),0},
            {0,-1}

    };
    static double[][] mat6= {//2 2
            {-1,0},
            {0,1}

    };

    static double[][] mat8= {//2 2
            {(0.5),0},
            {0,1}

    };

    public static double[][] mult(double[][] mat1){

        double[][]mat9 = new double [mat1.length][mat2[0].length];
        for (int i=0; i<mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat9[i][j] = mat9[i][j] + mat1[i][k] * mat8[k][j];

                }
            }
        }
        GraphicsPanel.Paint(mat9);
        return mat9;
    }

    public static void Copy(double[][]mat1){
        double[][]mat3 = new double [mat1.length][mat2[0].length];
        double[][]mat5 = new double [mat1.length][mat2[0].length];
        double[][]mat7 = new double [mat1.length][mat2[0].length];
        for (int i=0; i<mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat3[i][j] = mat3[i][j] + mat1[i][k] * mat2[k][j];
                    mat5[i][j] = mat5[i][j] + mat1[i][k] * mat4[k][j];
                    mat7[i][j] = mat7[i][j] + mat1[i][k] * mat6[k][j];
                }
            }
        }
        GraphicsPanel.Paint(mat1);
        GraphicsPanel.Paint(mat3);
        GraphicsPanel.Paint(mat5);
        GraphicsPanel.Paint(mat7);
    }
}
