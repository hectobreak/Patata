package Presentacio;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @autor Víctor
 * @dataCreación 30/11/2014
 * @dataÚltimaModificación 10/12/2014
 */
public class VistaGuardarMapa extends javax.swing.JPanel {

    private CtrlPresentacio cPres;
    private String dir = null;

    /**
     * Creates new form VistaMapaNuevo
     */
    public VistaGuardarMapa() {
        initComponents();
    }

    /**
     * Creates new form VistaMapaNuevo
     */
    public VistaGuardarMapa(CtrlPresentacio cpres) {
        this.cPres = cpres;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        subtitulo = new javax.swing.JLabel();
        elegirDir = new javax.swing.JButton();
        directorio = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        titulo.setText("Guardar mapa en un fichero");

        subtitulo.setText("Elige un directorio para guardar el mapa");

        elegirDir.setText("Elegir Directorio");
        elegirDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegirDirActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(elegirDir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(directorio))
                            .addComponent(subtitulo))))
                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titulo)
                .addGap(76, 76, 76)
                .addComponent(subtitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(elegirDir)
                    .addComponent(directorio))
                .addGap(18, 18, 18)
                .addComponent(guardar)
                .addContainerGap(308, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void elegirDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegirDirActionPerformed
        JFileChooser chooser;
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.dir = chooser.getSelectedFile().getAbsolutePath();
            directorio.setText(this.dir);
        }
    }//GEN-LAST:event_elegirDirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if (this.dir != null) {
            boolean hayMapa = this.cPres.hayMapaCargado();
            if (hayMapa) {
                String nomMapa = this.cPres.getNombreMapa();
                System.out.println("Exportaremos en " + dir + nomMapa);
                this.cPres.exportarMapaConPesos(dir + "/" + nomMapa);
                this.dir = null;
                directorio.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Para guardar un mapa primiero debes crearlo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antes de guardar debes escoger un directorio");
        }
    }//GEN-LAST:event_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel directorio;
    private javax.swing.JButton elegirDir;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel subtitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
