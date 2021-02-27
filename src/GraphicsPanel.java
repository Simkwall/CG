import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.*;

@SuppressWarnings("serial")

public class GraphicsPanel extends JPanel{

    private Line x;
    private Line y;



    private static Path2D myPath1 = new Path2D.Double();
    private  Path2D myPath2 = new Path2D.Double();
    private  Path2D myPath3 = new Path2D.Double();
    private  Path2D myPath4 = new Path2D.Double();



    public GraphicsPanel(){
        x = new Line(-400,0,400,0);
        y= new Line(0,-400,0,400);


        double[][] mat1 = Matrix.mat1;
        myPath1.moveTo(mat1[0][0] + 400, -mat1[0][1] + 400);
        myPath1.lineTo(mat1[1][0] + 400, -mat1[1][1] + 400);
        myPath1.lineTo(mat1[2][0] + 400, -mat1[2][1] + 400);
        myPath1.closePath();

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
/*
        for (int i=0; i<mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    mat3[i][j] = mat3[i][j] + mat1[i][k] * mat2[k][j];
                    mat5[i][j] = mat5[i][j] + mat1[i][k] * mat4[k][j];
                }
            }
        }

        myPath2.moveTo(mat3[0][0]+400, -mat3[0][1]+ 400);
        myPath2.lineTo(mat3[1][0]+400, -mat3[1][1]+ 400);
        myPath2.lineTo(mat3[2][0]+400, -mat3[2][1]+ 400);
        myPath2.closePath();
*/

     /*   line1 = new Line(mat1[1][0],mat1[1][1],mat1[0][0],mat1[0][1]);
        line2 = new Line(mat1[1][0],mat1[1][1],mat1[2][0],mat1[2][1]);
        line3 = new Line(mat1[0][0],mat1[0][1],mat1[2][0],mat1[2][1]);
*/

    }

    public static void Paint(double[][] mat1) {
        myPath1.moveTo(mat1[0][0] + 400, -mat1[0][1] + 400);
        myPath1.lineTo(mat1[1][0] + 400, -mat1[1][1] + 400);
        myPath1.lineTo(mat1[2][0] + 400, -mat1[2][1] + 400);
        myPath1.closePath();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(myPath1);
        g2.draw(x);
        g2.draw(y);
        g2.dispose();

    }




    class MyMouseAdapter extends MouseAdapter {
        private Point pPressed = null;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            if (myPath1.contains(e.getPoint()) || myPath2.contains(e.getPoint())) {
                pPressed = e.getPoint();
            }
        }

        public void mouseDragged(MouseEvent e) {
            drag(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drag(e);
            pPressed = null;
        }

        private void drag(MouseEvent e) {
            if (pPressed == null) {
                return;
            }
            Point p = e.getPoint();
            int tx = p.x - pPressed.x;
            int ty = p.y - pPressed.y;
            AffineTransform at = AffineTransform.getTranslateInstance(tx, ty);
            repaint();
            myPath1.transform(at);


            myPath1.closePath();

            myPath2.transform(at);
            pPressed = p;
            repaint();
        };

    }

/*
    private void draw2(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);

        g2.setPaint(Color.blue);
        g2.draw(line4);
        g2.draw(line5);
        g2.draw(line6);

        g2.setPaint(Color.red);
        g2.draw(line7);
        g2.draw(line8);
        g2.draw(line9);
    }



    @Override
    public void run() {
        while(true){
            try {
                line1.movie();
                super.repaint();

                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
*/
}
