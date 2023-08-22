/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit 
this template
 */
package finalproyect.dataestructure;

import COLAS.*;
import LISTAS_CIRCULARES.*;
import PILAS.*;
import COLA_ORDENES.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arman
 */
public class GameInterface extends javax.swing.JFrame {

    public GameInterface() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        TimerLbl.setText("05:00");

        //inserta los 5 ingredientes
        lis.inserta(new Ingredientes(1, ing.IngredienteAleatorio()));
        lis.inserta(new Ingredientes(2, ing.IngredienteAleatorio()));
        lis.inserta(new Ingredientes(3, ing.IngredienteAleatorio()));
        lis.inserta(new Ingredientes(4, ing.IngredienteAleatorio()));
        lis.inserta(new Ingredientes(5, ing.IngredienteAleatorio()));

        //inserta las primeras 3 ordenes      
        UpdateJLabelExample();

        //asigna las primeras ordenes
        //asigna los labels de ingredientes
        actualizaringredientes();
        downTimer();
        timer.start();

    }

    //variables
    String[][] tiposIngredientes;
    String[] ingPreparacion;
    Timer timer;
    int second = 0;
    int contOrdenes = 0;
    int minute = 5;
    String ddSecond, ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");
    int puntaje = 0;

    Lista lis = new Lista();
    Ingredientes ing = new Ingredientes();
    Pila pilaPreparar = new Pila();
    ColaO CO1 = new ColaO();
    OrdenO OR1 = new OrdenO();
    Random random = new Random();
    MainCode MC1 = new MainCode();
    

    Ingredientes ingAux = new Ingredientes();

    //funciones
    public void downTimer() {

        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                second--;
                contOrdenes++;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                TimerLbl.setText(ddMinute + ":" + ddSecond);

                
                if (second == -1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    TimerLbl.setText(ddMinute + ":" + ddSecond);
                }//if
                if (minute == 00 && second == 00) {
                   
                    timer.stop();
                    
                    
                    
                    
                    
                    try {
                        Thread.sleep(5000);
                        System.exit(0);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
            }

        });

    }//downTimer       

    public void UpdateJLabelExample() {
        // Create a timer to update the label text every 5 seconds
        CO1.encola(new NodoO(new OrdenO(random.nextInt(),
                OR1.randomListOrdenes())));
        Orden1.setText("Orden 1: " + CO1.ObtenerFrente());
        Timer timer = new Timer(20000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CO1.getLargo() == 1) {
                    CO1.encola(new NodoO(new OrdenO(random.nextInt(),
                            OR1.randomListOrdenes())));
                    Orden2.setText("Orden 2: " + CO1.ObtenerSegundo());
                } else if (CO1.getLargo() == 2) {
                    CO1.encola(new NodoO(new OrdenO(random.nextInt(),
                            OR1.randomListOrdenes())));
                    Orden3.setText("Orden 3: " + CO1.ObtenerTercero());
                }
            }
        });
        timer.start();
    }

    public void ActualizarOrdenes(){
        Orden1.setText("Orden 1: " + CO1.ObtenerFrente());
        Orden2.setText("Orden 2: " + CO1.ObtenerSegundo());
        Orden3.setText("Orden 3: " + CO1.ObtenerTercero());
    }
    
    public void AcceptedOrder() {
        CO1.mueve();
        ActualizarOrdenes();
    }

    public void AcceptedHamburger() {
        System.out.println(Orden1.getText());
        if (Orden1.getText().equals("Orden 1: Hamburguesa de carne")) {
            if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("carne"))
                    && (labelpreparar3.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 5;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");
            } else {
                System.out.println("La hamburgesa contiene los ingredientes"
                        + "incorrectos");
                LimpiarHamburgesa();
            }//Hamburgesa de Carne
        } else if (Orden1.getText().equals("Orden 1: Hamburguesa"
                + " con queso")) {
            if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("carne"))
                    && (labelpreparar3.getText().equals("queso"))
                    && (labelpreparar4.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 10;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");

            } else if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("queso"))
                    && (labelpreparar3.getText().equals("carne"))
                    && (labelpreparar4.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 10;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");

            } else {
                System.out.println("La hamburgesa contiene los ingredientes"
                        + "incorrectos");
                LimpiarHamburgesa();
            }//Hamburguesa con queso
        } else if (Orden1.getText().equals("Orden 1: Hamburguesa"
                + " clasica")) {
            if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("lechuga"))
                    && (labelpreparar3.getText().equals("carne"))
                    && (labelpreparar4.getText().equals("queso"))
                    && (labelpreparar5.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 15;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");

            } else if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("lechuga"))
                    && (labelpreparar2.getText().equals("queso"))
                    && (labelpreparar3.getText().equals("carne"))
                    && (labelpreparar4.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 15;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");

            } else if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("queso"))
                    && (labelpreparar3.getText().equals("carne"))
                    && (labelpreparar4.getText().equals("lechuga"))
                    && (labelpreparar5.getText().equals("pan"))) {
                AcceptedOrder();
                LimpiarHamburgesa();
                puntaje = puntaje + 15;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");
            } else if (labelpreparar1.getText().equals("pan")
                    && (labelpreparar2.getText().equals("carne"))
                    && (labelpreparar3.getText().equals("queso"))
                    && (labelpreparar4.getText().equals("lechuga"))
                    && (labelpreparar5.getText().equals("pan"))) {
                AcceptedOrder();
                puntaje = puntaje + 15;
                puntajeLbl.setText(Integer.toString(puntaje)
                        + " puntos acomulados");
            } else {
                System.out.println("La hamburgesa contiene los ingredientes"
                        + "incorrectos");
                LimpiarHamburgesa();
            }
        }
    }

    public void puntaje() {
        puntajeLbl.setText(Integer.toString(puntaje));
    }

    public void LimpiarHamburgesa() {
        labelpreparar1.setText("");
        labelpreparar2.setText("");
        labelpreparar3.setText("");
        labelpreparar4.setText("");
        labelpreparar5.setText("");
        pilaPreparar = new Pila();
        actualizarpreparacion();
    }

    public void actualizaringredientes() {
        tiposIngredientes = lis.obtenerTiposIngredientes();

        ingrediente1Label.setText(tiposIngredientes[0][1]);
        ingrediente2Label.setText(tiposIngredientes[1][1]);
        ingrediente3Label.setText(tiposIngredientes[2][1]);
        ingrediente4Label.setText(tiposIngredientes[3][1]);
        ingrediente5Label.setText(tiposIngredientes[4][1]);
    }//actualizar ingredientes

    public void actualizarpreparacion() {
        //pilaPreparar.listar(); //Para pruebas
        ingPreparacion = pilaPreparar.obtenerIngredientespreparacion();
        switch (ingPreparacion.length) {
            case 1:
                labelpreparar1.setText(ingPreparacion[0]);
                break;
            case 2:
                labelpreparar1.setText(ingPreparacion[0]);
                labelpreparar2.setText(ingPreparacion[1]);
                break;
            case 3:
                labelpreparar1.setText(ingPreparacion[0]);
                labelpreparar2.setText(ingPreparacion[1]);
                labelpreparar3.setText(ingPreparacion[2]);
                break;
            case 4:
                labelpreparar1.setText(ingPreparacion[0]);
                labelpreparar2.setText(ingPreparacion[1]);
                labelpreparar3.setText(ingPreparacion[2]);
                labelpreparar4.setText(ingPreparacion[3]);
                break;
            case 5:
                labelpreparar1.setText(ingPreparacion[0]);
                labelpreparar2.setText(ingPreparacion[1]);
                labelpreparar3.setText(ingPreparacion[2]);
                labelpreparar4.setText(ingPreparacion[3]);
                labelpreparar5.setText(ingPreparacion[4]);
                break;
            default:
                labelpreparar1.setText("");
                labelpreparar2.setText("");
                labelpreparar3.setText("");
                labelpreparar4.setText("");
                labelpreparar5.setText("");
                break;
        }

        //Inicio - Seccion de Ordenes 
        //Final - Seccion de Ordenes 
    }//actualizar preparación

    /*-----------------------NO TOCAR------------------*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TimerLbl = new javax.swing.JLabel();
        ingrediente5Label = new javax.swing.JLabel();
        labelPlato = new javax.swing.JLabel();
        ingrediente2Label = new javax.swing.JLabel();
        ingrediente3Label = new javax.swing.JLabel();
        ingrediente4Label = new javax.swing.JLabel();
        ingrediente1Label = new javax.swing.JLabel();
        labelpreparar4 = new javax.swing.JLabel();
        labelpreparar3 = new javax.swing.JLabel();
        labelpreparar5 = new javax.swing.JLabel();
        labelpreparar2 = new javax.swing.JLabel();
        labelpreparar1 = new javax.swing.JLabel();
        OkBtn = new javax.swing.JButton();
        Orden3 = new javax.swing.JLabel();
        Orden2 = new javax.swing.JLabel();
        Orden1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        LimpiarBtn = new javax.swing.JButton();
        LblBasurero = new javax.swing.JButton();
        puntajeLbl = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));
        jPanel1.setLayout(null);

        TimerLbl.setBackground(new java.awt.Color(255, 255, 255));
        TimerLbl.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        TimerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLbl.setText("Timer");
        jPanel1.add(TimerLbl);
        TimerLbl.setBounds(710, 10, 80, 40);

        ingrediente5Label.setForeground(new java.awt.Color(255, 255, 255));
        ingrediente5Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingrediente5Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(12, 104, 12), 2, true));
        ingrediente5Label.setPreferredSize(new java.awt.Dimension(80, 30));
        ingrediente5Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingrediente5LabelMouseClicked(evt);
            }
        });
        jPanel1.add(ingrediente5Label);
        ingrediente5Label.setBounds(500, 340, 80, 30);

        labelPlato.setBackground(new java.awt.Color(255, 255, 255));
        labelPlato.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelPlato.setForeground(new java.awt.Color(255, 255, 153));
        labelPlato.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPlato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPlatoMouseClicked(evt);
            }
        });
        jPanel1.add(labelPlato);
        labelPlato.setBounds(340, 260, 80, 20);

        ingrediente2Label.setForeground(new java.awt.Color(255, 255, 255));
        ingrediente2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingrediente2Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(12, 104, 12), 2, true));
        ingrediente2Label.setPreferredSize(new java.awt.Dimension(80, 30));
        ingrediente2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingrediente2LabelMouseClicked(evt);
            }
        });
        jPanel1.add(ingrediente2Label);
        ingrediente2Label.setBounds(230, 340, 80, 30);

        ingrediente3Label.setForeground(new java.awt.Color(255, 255, 255));
        ingrediente3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingrediente3Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(12, 104, 12), 2, true));
        ingrediente3Label.setPreferredSize(new java.awt.Dimension(80, 30));
        ingrediente3Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingrediente3LabelMouseClicked(evt);
            }
        });
        jPanel1.add(ingrediente3Label);
        ingrediente3Label.setBounds(320, 340, 80, 30);

        ingrediente4Label.setForeground(new java.awt.Color(255, 255, 255));
        ingrediente4Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingrediente4Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(12, 104, 12), 2, true));
        ingrediente4Label.setPreferredSize(new java.awt.Dimension(80, 30));
        ingrediente4Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingrediente4LabelMouseClicked(evt);
            }
        });
        jPanel1.add(ingrediente4Label);
        ingrediente4Label.setBounds(410, 340, 80, 30);

        ingrediente1Label.setForeground(new java.awt.Color(255, 255, 255));
        ingrediente1Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingrediente1Label.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(12, 104, 12), 2, true));
        ingrediente1Label.setPreferredSize(new java.awt.Dimension(80, 30));
        ingrediente1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingrediente1LabelMouseClicked(evt);
            }
        });
        jPanel1.add(ingrediente1Label);
        ingrediente1Label.setBounds(140, 340, 80, 30);

        labelpreparar4.setBackground(new java.awt.Color(255, 255, 255));
        labelpreparar4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelpreparar4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelpreparar4);
        labelpreparar4.setBounds(350, 140, 50, 20);

        labelpreparar3.setBackground(new java.awt.Color(255, 255, 255));
        labelpreparar3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelpreparar3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelpreparar3);
        labelpreparar3.setBounds(350, 170, 50, 20);

        labelpreparar5.setBackground(new java.awt.Color(255, 255, 51));
        labelpreparar5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelpreparar5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelpreparar5);
        labelpreparar5.setBounds(350, 110, 50, 20);

        labelpreparar2.setBackground(new java.awt.Color(255, 255, 255));
        labelpreparar2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelpreparar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelpreparar2);
        labelpreparar2.setBounds(350, 200, 50, 20);

        labelpreparar1.setBackground(new java.awt.Color(255, 255, 255));
        labelpreparar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelpreparar1.setForeground(new java.awt.Color(255, 255, 153));
        labelpreparar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(labelpreparar1);
        labelpreparar1.setBounds(350, 230, 50, 20);

        OkBtn.setBackground(new java.awt.Color(255, 51, 51));
        OkBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OkBtn.setForeground(new java.awt.Color(255, 255, 255));
        OkBtn.setText("Entregar");
        OkBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtnActionPerformed(evt);
            }
        });
        jPanel1.add(OkBtn);
        OkBtn.setBounds(710, 170, 74, 23);

        Orden3.setBackground(new java.awt.Color(255, 51, 51));
        Orden3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Orden3.setForeground(new java.awt.Color(255, 255, 255));
        Orden3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Orden3.setText("Orden 3");
        Orden3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Orden3.setOpaque(true);
        Orden3.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel1.add(Orden3);
        Orden3.setBounds(20, 10, 220, 20);

        Orden2.setBackground(new java.awt.Color(255, 51, 51));
        Orden2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Orden2.setForeground(new java.awt.Color(255, 255, 255));
        Orden2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Orden2.setText("Orden 2");
        Orden2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Orden2.setOpaque(true);
        Orden2.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel1.add(Orden2);
        Orden2.setBounds(20, 40, 220, 20);

        Orden1.setBackground(new java.awt.Color(255, 51, 51));
        Orden1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Orden1.setForeground(new java.awt.Color(255, 255, 255));
        Orden1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Orden1.setText("Orden 1");
        Orden1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Orden1.setOpaque(true);
        Orden1.setPreferredSize(new java.awt.Dimension(170, 20));
        jPanel1.add(Orden1);
        Orden1.setBounds(20, 70, 220, 20);

        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setText("Volver");
        backBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(10, 420, 70, 23);

        LimpiarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LimpiarBtn.setText("Limpiar Plato");
        LimpiarBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LimpiarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(LimpiarBtn);
        LimpiarBtn.setBounds(10, 280, 100, 23);

        LblBasurero.setBackground(new java.awt.Color(255, 51, 51));
        LblBasurero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LblBasurero.setForeground(new java.awt.Color(255, 255, 255));
        LblBasurero.setText("Basurero");
        LblBasurero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LblBasurero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblBasureroActionPerformed(evt);
            }
        });
        jPanel1.add(LblBasurero);
        LblBasurero.setBounds(700, 380, 74, 23);

        puntajeLbl.setBackground(java.awt.Color.orange);
        puntajeLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        puntajeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntajeLbl.setText("0 puntos");
        puntajeLbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        puntajeLbl.setOpaque(true);
        jPanel1.add(puntajeLbl);
        puntajeLbl.setBounds(520, 20, 180, 24);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/GameBackground.PNG"))); // NOI18N
        jPanel1.add(Background);
        Background.setBounds(0, 0, 800, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingrediente1LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingrediente1LabelMouseClicked
        // TODO add your handling code here:
        ingAux.setId(Integer.parseInt(tiposIngredientes[0][0]));
        ingAux.setTipo(tiposIngredientes[0][1]);
        //JOptionPane.showMessageDialog(null, ingAux);
    }//GEN-LAST:event_ingrediente1LabelMouseClicked

    private void ingrediente2LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingrediente2LabelMouseClicked
        // TODO add your handling code here:
        ingAux.setId(Integer.parseInt(tiposIngredientes[1][0]));
        ingAux.setTipo(tiposIngredientes[1][1]);
        //JOptionPane.showMessageDialog(null, ingAux);
    }//GEN-LAST:event_ingrediente2LabelMouseClicked

    private void ingrediente3LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingrediente3LabelMouseClicked
        // TODO add your handling code here:
        ingAux.setId(Integer.parseInt(tiposIngredientes[2][0]));
        ingAux.setTipo(tiposIngredientes[2][1]);
        //JOptionPane.showMessageDialog(null, ingAux);
    }//GEN-LAST:event_ingrediente3LabelMouseClicked

    private void ingrediente4LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingrediente4LabelMouseClicked
        // TODO add your handling code here:
        ingAux.setId(Integer.parseInt(tiposIngredientes[3][0]));
        ingAux.setTipo(tiposIngredientes[3][1]);
        //JOptionPane.showMessageDialog(null, ingAux);
    }//GEN-LAST:event_ingrediente4LabelMouseClicked

    private void ingrediente5LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingrediente5LabelMouseClicked
        // TODO add your handling code here:
        ingAux.setId(Integer.parseInt(tiposIngredientes[4][0]));
        ingAux.setTipo(tiposIngredientes[4][1]);
        //JOptionPane.showMessageDialog(null, ingAux);
    }//GEN-LAST:event_ingrediente5LabelMouseClicked

    private void labelPlatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPlatoMouseClicked
        // TODO add your handling code here:
        //Aqui se va a elaborar el pedido
        if (ingAux.getTipo() != null && ingAux.getTipo() != "vacio") {
            lis.botar(ingAux);
            lis.mueveIzq();
            lis.contarIngredientesNoVacios();
            actualizaringredientes();

            if (pilaPreparar.tamanio() < 5) {
                pilaPreparar.push(ingAux);
            }

            ingAux = new Ingredientes();
            actualizarpreparacion();

        }
    }//GEN-LAST:event_labelPlatoMouseClicked

    private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtnActionPerformed
        // TODO add your handling code here:
        AcceptedHamburger();

    }//GEN-LAST:event_OkBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        LoginInterface LI1 = new LoginInterface();
        LI1.setVisible(true);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void LimpiarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarBtnActionPerformed
        // TODO add your handling code here:
        LimpiarHamburgesa();
        while (!pilaPreparar.Vacia()) {
            pilaPreparar.pop();
        }

    }//GEN-LAST:event_LimpiarBtnActionPerformed

    private void LblBasureroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblBasureroActionPerformed
        // TODO add your handling code here:
        if (ingAux.getTipo() != null) {
            lis.botar(ingAux);
            lis.mueveIzq();
            lis.contarIngredientesNoVacios();
            actualizaringredientes();
            ingAux = new Ingredientes();
        }
    }//GEN-LAST:event_LblBasureroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton LblBasurero;
    private javax.swing.JButton LimpiarBtn;
    private javax.swing.JButton OkBtn;
    private javax.swing.JLabel Orden1;
    private javax.swing.JLabel Orden2;
    private javax.swing.JLabel Orden3;
    private javax.swing.JLabel TimerLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel ingrediente1Label;
    private javax.swing.JLabel ingrediente2Label;
    private javax.swing.JLabel ingrediente3Label;
    private javax.swing.JLabel ingrediente4Label;
    private javax.swing.JLabel ingrediente5Label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPlato;
    private javax.swing.JLabel labelpreparar1;
    private javax.swing.JLabel labelpreparar2;
    private javax.swing.JLabel labelpreparar3;
    private javax.swing.JLabel labelpreparar4;
    private javax.swing.JLabel labelpreparar5;
    private javax.swing.JLabel puntajeLbl;
    // End of variables declaration//GEN-END:variables
}
