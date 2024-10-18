package secuenciales;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm12 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtA, txtB, txtC, txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm12 frame = new frm12();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm12() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblA = new JLabel("Coeficiente a");
        lblA.setBounds(50, 50, 100, 30);
        getContentPane().add(lblA);

        JLabel lblB = new JLabel("Coeficiente b");
        lblB.setBounds(50, 90, 100, 30);
        getContentPane().add(lblB);

        JLabel lblC = new JLabel("Coeficiente c");
        lblC.setBounds(50, 130, 100, 30);
        getContentPane().add(lblC);

        JLabel lblResultado = new JLabel("Resultados");
        lblResultado.setBounds(50, 210, 100, 30);
        getContentPane().add(lblResultado);

        txtA = new JTextField();
        txtA.setBounds(150, 50, 100, 30);
        txtA.setHorizontalAlignment(SwingConstants.RIGHT);
        txtA.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtA);

        txtB = new JTextField();
        txtB.setBounds(150, 90, 100, 30);
        txtB.setHorizontalAlignment(SwingConstants.RIGHT);
        txtB.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtB);

        txtC = new JTextField();
        txtC.setBounds(150, 130, 100, 30);
        txtC.setHorizontalAlignment(SwingConstants.RIGHT);
        txtC.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtC);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 210, 100, 30);
        txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
        txtResultado.setFocusable(false);
        txtResultado.setMargin(new Insets(5, 5, 5, 5));
        getContentPane().add(txtResultado);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 280, 100, 30);
        btnCalcular.setMnemonic('a');
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        double a = Double.parseDouble(txtA.getText());
        double b = Double.parseDouble(txtB.getText());
        double c = Double.parseDouble(txtC.getText());

        double discriminante = Math.pow(b, 2) - 4 * a * c;
        double resultado;

        if (discriminante < 0) {
            txtResultado.setText("Sin raíces reales");
        } else if (discriminante == 0) {
            resultado = -b / (2 * a);
            txtResultado.setText("Raíz: " + resultado);
        } else {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            txtResultado.setText("Raíces: " + raiz1 + ", " + raiz2);
        }
    }
}
