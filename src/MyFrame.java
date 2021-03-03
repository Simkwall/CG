import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;

public class MyFrame extends JFrame implements Runnable{

    GraphicsPanel gp;


    MyFrame(){

        // настройка фрейма
        this.setSize(1100,850);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();//создание панели для размещения кнопок

        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridBagLayout());
        panel.setSize(200,800);

        JButton buttonRS = new JButton("Change*1.25");//иницилизация кнопок
        JButton buttonRC = new JButton("Change*0.8");
        JButton buttonLT = new JButton("Shift Left");
        JButton buttonRT = new JButton("Shift Right");
        JButton buttonUp = new JButton("Shift Up");
        JButton buttonDn = new JButton("Shift Dn");

        GraphicsPanel gp = new GraphicsPanel();//иницилизация панели для отображения рисунка

        gp.setSize(800,800);

        //реакции на нажатия кнопок
        buttonRS.addActionListener(e -> {
            gp.Change1();
        });

        buttonRC.addActionListener(e -> {
            gp.Change2();
        });


        buttonLT.addActionListener(e -> {
            gp.ShiftLeft();
        });

        buttonRT.addActionListener(e -> {
            gp.ShiftRight();
        });

        buttonUp.addActionListener(e -> {
            gp.ShiftUp();
        });

        buttonDn.addActionListener(e -> {
            gp.ShiftDown();
        });

        //добавление на панель кнопок
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
        panel.add(buttonRC, new GridBagConstraints(1,5,1,1,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(2, 2, 2, 2), 0, 0));

        //отображение на фрейме панели с рисункои
        this.add(gp, new GridBagConstraints(0,0,8,2,1,1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        //отображение на фрейме панели с кнопками
        this.add(panel, new GridBagConstraints(8,0,1,1,0,0.5,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));


        this.setVisible(true);
    }


    @Override
    public void run() {
        repaint();
    }
}
