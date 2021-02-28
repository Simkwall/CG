import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    GraphicsPanel gp;

    static double[][] mat1 = {//3 2
            {100,400},
            {100,200},
            {200,200}
    };

    MyFrame(){


        this.setSize(1100,850);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridBagLayout());
        panel.setSize(200,800);

        JButton buttonRS = new JButton("Change");
        JButton buttonLT = new JButton("Shift Left");
        JButton buttonRT = new JButton("Shift Right");
        JButton buttonUp = new JButton("Shift Up");
        JButton buttonDn = new JButton("Shift Dn");
        GraphicsPanel gp = new GraphicsPanel();

        gp.setSize(800,800);
        gp.Paint(mat1);

        buttonRS.addActionListener(e -> {
            Matrix.Copy(mat1);
            repaint();
        });

        buttonLT.addActionListener(e -> {

            for(int i=0;i< mat1.length;i++){
                mat1[i][0] = mat1[i][0] - 10;
            }
            repaint();
        });

        buttonRT.addActionListener(e -> {

            for(int i=0;i< mat1.length;i++){
                mat1[i][0] = mat1[i][0] + 10;
            }
        });

        buttonUp.addActionListener(e -> {
            for(int i=0;i< mat1.length;i++){
                mat1[i][1] = mat1[i][1] + 10;
            }
        });

        buttonDn.addActionListener(e -> {
            for(int i=0;i< mat1.length;i++){
                mat1[i][1] = mat1[i][1] - 10;
            }
        });

        panel.add(buttonRS, new GridBagConstraints(1,2,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));
        panel.add(buttonLT, new GridBagConstraints(0,2,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));
        panel.add(buttonRT,new GridBagConstraints(2,2,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));
        panel.add(buttonUp,new GridBagConstraints(1,0,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));
        panel.add(buttonDn,new GridBagConstraints(1,4,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));

      //  this.getContentPane().add(panel);

        this.add(gp, new GridBagConstraints(0,0,8,2,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        this.add(panel, new GridBagConstraints(8,0,1,1,0,0.5,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));


        this.setVisible(true);
    }



}
