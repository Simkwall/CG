import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    JButton buttonX;
    GraphicsPanel gp;

    MyFrame(){

        JButton button = new JButton("Change");


        this.setSize(800,850);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsPanel gp = new GraphicsPanel();
        button.addActionListener(e -> {
            //gp.removeAll();

            Matrix.mult();
            this.repaint();
            Matrix.Copy();

        });
        gp.add(button);
        this.add(gp, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));


        this.setVisible(true);
    }



}
