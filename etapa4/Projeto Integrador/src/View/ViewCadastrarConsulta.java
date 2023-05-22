/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ConsultaDAO;
import DAO.EspecialidadeDAO;
import DAO.MedicoDAO;
import DAO.PacienteDao;
import Model.Consulta;
import Model.Especialidade;
import Model.Funcionario;
import Model.Medico;
import Model.Paciente;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
    


/**
 *
 * @author Nicolas
 */
public class ViewCadastrarConsulta extends javax.swing.JFrame {
    
    private final Funcionario atendente;
    /**
     * Creates new form v
     */
    public ViewCadastrarConsulta(Funcionario atendente) {
        this.atendente = atendente;
        initComponents();
        this.popularComboBoxEspecialidades();
        setLocationRelativeTo(null);
        txtAtendente.setText(atendente.getId() + "");
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCpfPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEspecialidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtAtendente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMedico = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(187, 187, 187));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informe o CPF do pacinete:");

        txtCpfPaciente.setBackground(new java.awt.Color(255, 255, 255));
        txtCpfPaciente.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Informe especialidade:");

        jComboBoxEspecialidade.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEspecialidade.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEspecialidadeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Codigo atendente:");

        txtAtendente.setBackground(new java.awt.Color(255, 255, 255));
        txtAtendente.setForeground(new java.awt.Color(0, 0, 0));
        txtAtendente.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data e Hora:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Obeservações:");

        txtObs.setBackground(new java.awt.Color(255, 255, 255));
        txtObs.setColumns(20);
        txtObs.setForeground(new java.awt.Color(0, 0, 0));
        txtObs.setRows(5);
        jScrollPane1.setViewportView(txtObs);

        jButton1.setText("cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtData.setBackground(new java.awt.Color(255, 255, 255));
        txtData.setForeground(new java.awt.Color(0, 0, 0));
        txtData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Medico:");

        jComboBoxMedico.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMedico.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMedico.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(140, 140, 140)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(txtData)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(73, 73, 73)
                                    .addComponent(jComboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(45, 45, 45)
                                    .addComponent(txtCpfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCpfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEspecialidadeActionPerformed
        // TODO add your handling code here:
        // Obtém a especialidade selecionada
        String especialidadeSelecionada = jComboBoxEspecialidade.getSelectedItem().toString();

        // Busca a especialidade pelo nome
        EspecialidadeDAO daoEspecialidade = new EspecialidadeDAO();
        Especialidade especialidade = null;
        try {
            especialidade = daoEspecialidade.buscarEspecialidadePorNome(especialidadeSelecionada);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        // Popula o JComboBox de médicos com os médicos da especialidade selecionada
        MedicoDAO daoMedico = new MedicoDAO();
        try {
            List<Medico> listaMedicos = daoMedico.listarMedicosPorEspecialidade(especialidade.getId());
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Medico medico : listaMedicos) {
                model.addElement(medico.getNome());
            }
            jComboBoxMedico.setModel(model);
            jComboBoxMedico.setEnabled(true); // Habilita o JComboBox de médicos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxEspecialidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.cadastrarConsulta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataMouseClicked

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
            java.util.logging.Logger.getLogger(ViewCadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastrarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCadastrarConsulta(null).setVisible(true);
            }
        });
    }
    
    public boolean cadastrarConsulta() {

        try {
            // Busca o paciente pelo CPF digitado
            PacienteDao daoPaciente = new PacienteDao();
            Paciente paciente = daoPaciente.buscarPacientePorCPF(txtCpfPaciente.getText());

            // Busca o médico pelo nome
            String medicoSelecionado = (String) jComboBoxMedico.getSelectedItem();
            MedicoDAO daoMedico = new MedicoDAO();
            Medico medicoEncontrado = daoMedico.buscarMedicoPorNome(medicoSelecionado);
            if (medicoEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Médico não encontrado.");
                return false;
            }
            int medicoId = medicoEncontrado.getId();
            System.out.println(medicoId);

            // Verifica se há um funcionário logado
            Funcionario funcionario = this.atendente;
            if (funcionario == null) {
                JOptionPane.showMessageDialog(null, "Nenhum funcionário logado.");
                return false;
            }

            // Cria a consulta com os dados informados
            Consulta consulta = new Consulta();
            consulta.setPacienteId(paciente.getId());
            consulta.setMedicoId(medicoId);
            consulta.setAtendenteId(funcionario.getId());
            
            String dataConsultaBrasileira = txtData.getText(); // "dd/MM/yyyy HH:mm"
            SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dataConsulta = formatoBrasileiro.parse(dataConsultaBrasileira);

            SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataConsultaBanco = formatoBanco.format(dataConsulta);

            consulta.setDataConsulta(dataConsultaBanco);
            
            consulta.setObservacoes(txtObs.getText());

            // Salva a consulta no banco de dados
            ConsultaDAO daoConsulta = new ConsultaDAO();
            daoConsulta.cadastrarConsulta(consulta);

            JOptionPane.showMessageDialog(this, "Consulta salva com sucesso");
            this.limpaCampos();
            dispose();
            new ViewPrincipal(funcionario).setVisible(true);

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "erro ao salvar " + e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void popularComboBoxEspecialidades() {
        EspecialidadeDAO daoEspecialidade = new EspecialidadeDAO();
        try {
            List<Especialidade> especialidades = daoEspecialidade.listarEspecialidades();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (Especialidade especialidade : especialidades) {
                model.addElement(especialidade.toString());
            }
            jComboBoxEspecialidade.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void limpaCampos(){
        txtObs.setText("");
        txtData.setText("");
        txtCpfPaciente.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxEspecialidade;
    private javax.swing.JComboBox<String> jComboBoxMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAtendente;
    private javax.swing.JTextField txtCpfPaciente;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextArea txtObs;
    // End of variables declaration//GEN-END:variables
}
