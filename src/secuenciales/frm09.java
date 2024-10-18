package secuenciales;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm09 extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField txtNumero, txtSuma;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm09 frame = new frm09();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm09() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 270);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblNumero = new JLabel("Número (4 cifras)");
        lblNumero.setBounds(50, 30, 120, 30);
        getContentPane().add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 30, 80, 30);
        txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
        getContentPane().add(txtNumero);

        JLabel lblSuma = new JLabel("Suma de cifras");
        lblSuma.setBounds(50, 80, 120, 30);
        getContentPane().add(lblSuma);

        txtSuma = new JTextField();
        txtSuma.setBounds(180, 80, 80, 30);
        txtSuma.setHorizontalAlignment(SwingConstants.RIGHT);
        txtSuma.setFocusable(false); // Campo no editable
        getContentPane().add(txtSuma);

        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(100, 150, 100, 30);
        getContentPane().add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCalcular_actionPerformed();
            }
        });
    }

    protected void btnCalcular_actionPerformed() {
        String input = txtNumero.getText();
        
        if (input.length() != 4 || !input.matches("\\d+")) {
            txtSuma.setText("Error: debe ser 4 cifras");
            return;
        }
        
        int numero = Integer.parseInt(input);
        
        int suma = 0;
        while (numero > 0) {
            suma += numero % 10;
            numero /= 10;       
        }

        txtSuma.setText(String.valueOf(suma));
    }
}
