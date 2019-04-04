package ejercicio2_inferencia;

import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.jena.atlas.logging.LogCtl;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        LogCtl.setCmdLogging();
        initComponents();
        reasoner = ReasonerRegistry.getRDFSReasoner();
        reasoner.setDerivationLogging(true);
        reasoner.setParameter(ReasonerVocabulary.PROPsetRDFSLevel, ReasonerVocabulary.RDFS_SIMPLE);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        schemaJLabel = new javax.swing.JLabel();
        dataJLabel = new javax.swing.JLabel();
        dataJTextField = new javax.swing.JTextField();
        schemaJTextField = new javax.swing.JTextField();
        dataJButton = new javax.swing.JButton();
        schemaJButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        violationConstraintsRadioButton = new javax.swing.JRadioButton();
        inferedClassRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        schemaJLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        schemaJLabel.setText("Esquema:");

        dataJLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        dataJLabel.setText("Datos:");

        dataJTextField.setText("C:\\Users\\samu_\\Desktop\\SI2\\Pratises\\Ejercicio2_InferenciaConRDFS\\Ejercicio2_Inferencia\\data.ttl");
        dataJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataJTextFieldActionPerformed(evt);
            }
        });

        schemaJTextField.setText("C:\\Users\\samu_\\Desktop\\SI2\\Pratises\\Ejercicio2_InferenciaConRDFS\\Ejercicio2_Inferencia\\schema.ttl");

        dataJButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dataJButton.setText("Buscar");
        dataJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataJButtonActionPerformed(evt);
            }
        });

        schemaJButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        schemaJButton.setText("Buscar");
        schemaJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemaJButtonActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonGroup.add(violationConstraintsRadioButton);
        violationConstraintsRadioButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        violationConstraintsRadioButton.setText("Violaciones de restricciones");
        violationConstraintsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                violationConstraintsRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(inferedClassRadioButton1);
        inferedClassRadioButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        inferedClassRadioButton1.setText("Clases Inferidas");
        inferedClassRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inferedClassRadioButton1ActionPerformed(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(schemaJLabel)
                            .addComponent(dataJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(schemaJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(schemaJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(violationConstraintsRadioButton)
                                .addComponent(inferedClassRadioButton1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(schemaJButton)
                    .addComponent(schemaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schemaJLabel))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataJButton)
                    .addComponent(dataJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataJLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(inferedClassRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(violationConstraintsRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void schemaJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemaJButtonActionPerformed
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (fc.getSelectedFile().exists() && fc.getSelectedFile().isFile() && fc.getSelectedFile().canRead()) {
                String absolutePath = fc.getSelectedFile().getAbsolutePath();
                if (absolutePath.endsWith(".ttl")) {
                    String schemePath = fc.getSelectedFile().getAbsolutePath();
                    schemaJTextField.setText(schemePath);
                    jTextArea.setText("");
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "El formato del fichero debe ser Turtle (.ttl)",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);    
            } else
                JOptionPane.showMessageDialog(
                        null,
                        "Su elección no es válida",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_schemaJButtonActionPerformed

    private void dataJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataJButtonActionPerformed
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            if (fc.getSelectedFile().exists() && fc.getSelectedFile().isFile() && fc.getSelectedFile().canRead()) {
                String absolutePath = fc.getSelectedFile().getAbsolutePath();
                if (absolutePath.endsWith(".ttl")) {
                    String dataPath = fc.getSelectedFile().getAbsolutePath();
                    dataJTextField.setText(dataPath);
                    jTextArea.setText("");
                }
                else
                    JOptionPane.showMessageDialog(
                            null,
                            "El formato del fichero debe ser Turtle (.ttl)",
                            "Aviso",
                            JOptionPane.WARNING_MESSAGE);    
            } else
                JOptionPane.showMessageDialog(
                        null,
                        "Su elección no es válida",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_dataJButtonActionPerformed

    private void inferedClassRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inferedClassRadioButton1ActionPerformed
        if (dataJTextField.getText().isEmpty() || schemaJTextField.getText().isEmpty())
            JOptionPane.showMessageDialog(
                        null,
                        "Debe seleccionar un fichero de datos y otro de esquema.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
        else {
            inferIfFilesChange();
            jTextArea.setText(getInferredClasses());
        }
    }//GEN-LAST:event_inferedClassRadioButton1ActionPerformed

    private void violationConstraintsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_violationConstraintsRadioButtonActionPerformed
        if (dataJTextField.getText().isEmpty() || schemaJTextField.getText().isEmpty())
            JOptionPane.showMessageDialog(
                        null,
                        "Debe seleccionar un fichero de datos y otro de esquema.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
        else {
            inferIfFilesChange();
            jTextArea.setText(getViolationConstraints());
        }
    }//GEN-LAST:event_violationConstraintsRadioButtonActionPerformed

    private void dataJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataJTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton dataJButton;
    private javax.swing.JLabel dataJLabel;
    private javax.swing.JTextField dataJTextField;
    private javax.swing.JRadioButton inferedClassRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JButton schemaJButton;
    private javax.swing.JLabel schemaJLabel;
    private javax.swing.JTextField schemaJTextField;
    private javax.swing.JRadioButton violationConstraintsRadioButton;
    // End of variables declaration//GEN-END:variables

    private String getInferredClasses() {
        String result = "";
        StmtIterator iterador = inferredGraph.listStatements((Resource) null, RDF.type, (RDFNode) null);
        while (iterador.hasNext()) {
            Statement declaracion = iterador.next();
            result += declaracion.toString() + "\n";
        }    
        return result;
    }
    
    private String getViolationConstraints() {
        String result = "";
        ValidityReport validation = inferredGraph.validate();
        if (validation.isValid()) {
            result += "GRAFO CORRECTO";
        } else {
            result += "GRAFO INCORRECTO\n";
            Iterator iterador = validation.getReports();
            while (iterador.hasNext()) {
                Object inform = iterador.next();
                result += "Inconsistencia: " + inform.toString() + "\n";
            }
        }
        return result;
    }
    
    private void inferIfFilesChange() {
        String currentDataPath = dataJTextField.getText();
        String currentSchemaPath = schemaJTextField.getText();
        if (!lastDataPath.equals(currentDataPath) || !lastSchemaPath.equals(currentSchemaPath)) {
            data = RDFDataMgr.loadModel(currentDataPath);
            schema = RDFDataMgr.loadModel(currentSchemaPath);
            reasoner = reasoner.bindSchema(schema);
            inferredGraph = ModelFactory.createInfModel(reasoner, data);
            lastDataPath = currentDataPath;
            lastSchemaPath = currentSchemaPath;
        }
    }
    
    private final JFileChooser fc = new JFileChooser();
    private Model data;
    private Model schema;
    private String lastDataPath = "", lastSchemaPath = "";
    private Reasoner reasoner;
    private InfModel inferredGraph;
}
