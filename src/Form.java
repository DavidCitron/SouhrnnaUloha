import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Form extends JFrame{
    private JPanel panel;
    private JTextField nazev;
    private JRadioButton zakoupenaAno;
    private JRadioButton zakoupenaNe;
    private JButton tlacitkoZpet;
    private JButton tlacitkoDalsi;
    private JSlider slider;
    private JLabel nazevLabel;
    private JLabel zakoupenoLabel;
    private JLabel oblibenostLabel;
    private JLabel titulekLabel;
    private ButtonGroup skupina;

    public Form() {
        skupina = new ButtonGroup();
        skupina.add(zakoupenaAno);
        skupina.add(zakoupenaNe);

        tlacitkoDalsi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nactiData(0);
            }
        });
    }

    public void nactiData(int index){
        PraceSeSoubory praceSeSoubory = new PraceSeSoubory();
        List<Deskovka> seznam = praceSeSoubory.ziskejSeznamDeskovekZeSouboru();
        Deskovka aktualniDeskovka = seznam.get(index);
        nazev.setText(aktualniDeskovka.getNazev());
        if(aktualniDeskovka.isZakoupeno()){
            zakoupenaAno.setSelected(true);
        }else{
            zakoupenaNe.setSelected(true);
        }
        slider.setValue(aktualniDeskovka.getOblibenost());
    }

    public static void main(String[] args) {
        Form form = new Form();
        form.setContentPane(form.panel);
        form.pack();
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setVisible(true);
    }
}
