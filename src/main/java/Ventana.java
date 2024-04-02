import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

    private static final Logger logger = LogManager.getLogger();

    public Ventana() {


        super("Ordenar");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenu desplegarMenu = new JMenu("Archivo");


        JButton botonOrdenar = new JButton("Ordenar");
        botonOrdenar.setBounds(450, 30, 100, 50);
        botonOrdenar.setBackground(Color.green);


        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                logger.debug("App cerrada");
            }
        });


        JLabel letraA = new JLabel("A");
        JLabel letraE = new JLabel("E");
        JLabel letraI = new JLabel("I");
        JLabel letraO = new JLabel("O");
        JLabel letraU = new JLabel("U");


        letraA.setBounds(135, 100, 80, 60);
        letraA.setFont(new Font("Fuente", Font.PLAIN, (int) (letraA.getFont().getSize() * 2.5)));
        letraE.setBounds(315, 100, 80, 60);
        letraE.setFont(new Font("Fuente", Font.PLAIN, (int) (letraE.getFont().getSize() * 2.5)));
        letraI.setBounds(495, 100, 80, 60);
        letraI.setFont(new Font("Fuente", Font.PLAIN, (int) (letraI.getFont().getSize() * 2.5)));
        letraO.setBounds(675, 100, 80, 60);
        letraO.setFont(new Font("Fuente", Font.PLAIN, (int) (letraO.getFont().getSize() * 2.5)));
        letraU.setBounds(855, 100, 80, 60);
        letraU.setFont(new Font("Fuente", Font.PLAIN, (int) (letraU.getFont().getSize() * 2.5)));


        JTextArea textareaA = new JTextArea();
        textareaA.setLineWrap(true);
        textareaA.setWrapStyleWord(true);
        textareaA.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JTextArea textareaE = new JTextArea();
        textareaE.setLineWrap(true);
        textareaE.setWrapStyleWord(true);
        textareaE.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JTextArea textareaI = new JTextArea();
        textareaI.setLineWrap(true);
        textareaI.setWrapStyleWord(true);
        textareaI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JTextArea textareaO = new JTextArea();
        textareaO.setLineWrap(true);
        textareaO.setWrapStyleWord(true);
        textareaO.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        JTextArea textareaU = new JTextArea();
        textareaU.setLineWrap(true);
        textareaU.setWrapStyleWord(true);
        textareaU.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));


        textareaA.setBounds(60, 150, 150, 400);
        textareaE.setBounds(240, 150, 150, 400);
        textareaI.setBounds(420, 150, 150, 400);
        textareaO.setBounds(600, 150, 150, 400);
        textareaU.setBounds(790, 150, 150, 400);


        setLayout(null);
        add(botonOrdenar);
        add(letraA);
        add(letraE);
        add(letraI);
        add(letraO);
        add(letraU);
        add(textareaA);
        add(textareaE);
        add(textareaI);
        add(textareaO);
        add(textareaU);


        JMenuItem buscarArchivo = new JMenuItem("Leer");
        buscarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ordenamiento.seleccionarArchivo(textareaA,textareaE,textareaI,textareaO,textareaU);
                logger.debug("Buscando el archivo");

            }
        });

        botonOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ordenamiento.ordenarTextAreas(textareaA,textareaE,textareaI,textareaO,textareaU, Ventana.this);
                logger.error("Un error en la seleccion de archivos");

            }
        });


        desplegarMenu.add(buscarArchivo);
        desplegarMenu.add(salir);

        JMenuBar menu = new JMenuBar();

        menu.add(desplegarMenu);
        setJMenuBar(menu);


    }
}