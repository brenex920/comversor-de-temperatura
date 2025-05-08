package br.dev.breno.temperatura.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

public class ConversaoFrame extends JFrame {
    private Double celsius;
    private Double k;
    private Double f;
    
    private JButton btnF;
    private JButton btnK;
    private JFormattedTextField vlrC;
    private JLabel valor;
    private JLabel txt;


    
    public void conversaoT(String temp) {
        double celsius = Double.parseDouble(this.vlrC.getText());
        if (temp == "F") {

            celsius = celsius * 1.8 + 32;
        } else if (temp == "K") {
            celsius = celsius + 273;
        } else {
            this.valor.setText("Formula de inválida");
        }

        this.valor.setText(""+celsius);
    }

    public ConversaoFrame() throws ParseException {
        // criaçao da tela
        setTitle("conversor de temperatura");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //parte de dentro da tela
        setLayout(new FlowLayout());
        
        // add(new JLabel("Temperatura em C"));
        // add(new JTextField(10));

        this.txt = new JLabel("valor de celcius");
        add(this.txt);

        var maskFormat = new MaskFormatter("###");
        this.vlrC = new JFormattedTextField(maskFormat);
        this.vlrC.setPreferredSize(new Dimension(150, 20));
        this.vlrC.setFocusLostBehavior(JFormattedTextField.PERSIST);
        add(this.vlrC);
        
        // metodo facil
        this.btnF = new JButton("F");
        this.btnF.addActionListener(event -> this.conversaoT("F"));
        add(this.btnF);
    
        // metodo dificil
        this.btnK = new JButton("K");
        this.btnK.addActionListener(evet -> this.conversaoT("K"));
        
        add(this.btnK);
        
        this.valor = new JLabel("Valor em C: " + this.vlrC.getText());
        this.valor.setBounds(100, 111, 75, 35);
        add(this.valor);
    }
}
