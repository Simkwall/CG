import java.awt.*;
import java.awt.Point;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import javax.swing.*;

@SuppressWarnings("serial")

public class GraphicsPanel extends JPanel implements ActionListener {

    private Line x;
    private Line y;


    static Path2D myPath1 = new Path2D.Double();

    GraphicsPanel(){
        x = new Line(-400,0,400,0);
        y= new Line(0,-400,0,400);


    }

    public void reDraw(Graphics g){

        Graphics2D g2 = (Graphics2D) g;
        super.paint(g);
        g2.draw(myPath1);
      //  g.clearRect (0, 0, 800, 800);

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
        repaint();
        g2.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }




}
