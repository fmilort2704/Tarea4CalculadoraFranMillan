/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author adam
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    // Atributos de la clase (privados)
    private PanelBotones botonera;
    private JTextArea areaTexto;

    // Constructor
    public PanelPrincipal() {
        initComponents();
    }

    // Se inicializan los componentes gráficos y se colocan en el panel
    private void initComponents() {
        // Creamos el panel de botones
        botonera = new PanelBotones();
        // Creamos el área de texto
        areaTexto = new JTextArea(10, 50);
        areaTexto.setEditable(true);
        areaTexto.setBackground(Color.white);
        //Establecemos layout del panel principal
        this.setLayout(new BorderLayout());
        // Colocamos la botonera y el área texto
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(botonera, BorderLayout.SOUTH);

        for (JButton boton : this.botonera.getgrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se obtiene el objeto que desencadena el evento
        Object o = ae.getSource();
        // Si es un botón
        if (o instanceof JButton) {
            System.out.println(((JButton) o).getText());
            //Con append añado al text area no lo resteo 
            areaTexto.append(((JButton) o).getText());  
        }

        // RESTO DEL CÓDIGO DE LA LÓGICA DE LA CALCULADORA
        
        //Limpiar
        if (o == botonera.grupoBotones[15]) {
            areaTexto.setText("");
        }

        //Igual
        if (o == botonera.grupoBotones[14]) {
            areaTexto.append(operacionesCalculadora());
        }
    }

    public String operacionesCalculadora() {
        
        //Regex de 3 grupos para poder asignarlos a variables
        String regex = "(\\d+)s*([+*/-])s*(\\d+)";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        //Coge el string del text area
        Matcher matcher = pattern.matcher(areaTexto.getText()); 
        
        
        while (matcher.find()) {
            //Guardo los valores de los grupos a las variable
            int dig1 = Integer.parseInt(matcher.group(1));
            String simbolo = matcher.group(2);
            int dig2 = Integer.parseInt(matcher.group(3));
            int resultEntero;
            double resultDouble;
            String fallo = "";
            
            //Hago los operacionesCalculadora dependiendo de que es el simbolo y lo devuelvo como String
            //para poder usar el .append en el boton =
            switch (simbolo) {

                case "+" -> {
                    resultEntero = dig1 + dig2;
                    fallo = Integer.toString(resultEntero);
                }
        }
        return "";
    }
}
