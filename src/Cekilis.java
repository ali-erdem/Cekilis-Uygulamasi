
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Cekilis extends javax.swing.JFrame {
    private String dosyaYolu = "";
    private ArrayList<String> katilanlar = new ArrayList<String>();
    private Set<String> kazananlar = new TreeSet<String>();
    private DefaultListModel model = new DefaultListModel();
    
   
    public Cekilis() {
        initComponents();
        kazananlarListesi.setModel(model);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aramaCubugu = new javax.swing.JTextField();
        gozAt_buton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        kazananlarListesi = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cekilisYap_buton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Çekiliş Uygulaması");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        aramaCubugu.setEditable(false);

        gozAt_buton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        gozAt_buton.setText("Gözat");
        gozAt_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gozAt_butonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(kazananlarListesi);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Kazananlar:");

        cekilisYap_buton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cekilisYap_buton.setText("Çekiliş Yap");
        cekilisYap_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekilisYap_butonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aramaCubugu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gozAt_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cekilisYap_buton))
                        .addGap(63, 63, 63))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gozAt_buton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekilisYap_buton))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gozAt_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gozAt_butonActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        
        int i = fileChooser.showOpenDialog(this);
        
        if(i == JFileChooser.APPROVE_OPTION){
             this.dosyaYolu = fileChooser.getSelectedFile().getPath();
             aramaCubugu.setText(dosyaYolu);
        }
    }//GEN-LAST:event_gozAt_butonActionPerformed
   
    public void cekilisYap(){
        
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaYolu), "ISO-8859-9"))){ 
                
         String kisi;
         
         while((kisi = reader.readLine()) != null){
             
           
             katilanlar.add(kisi);
             
         }
    
        }catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(kazananlar.size() != 10){
            
            Random random = new Random();
            int kazananIndex = random.nextInt(katilanlar.size());
            kazananlar.add(katilanlar.get(kazananIndex));
        }
        
    }
    
    public void alkisEkle(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("alkis-sesi.wav"));
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioInputStream);
            clip.start();
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Cekilis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void cekilisYap_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekilisYap_butonActionPerformed
        
        if(this.dosyaYolu.equals("")){
            JOptionPane.showMessageDialog(this, "Lütfen bir çekiliş dosyası seçin");
            
        }
        else{
            cekilisYap();
            
            for(String kazanan: kazananlar){
                
                model.addElement(kazanan);
                
            }
            alkisEkle();
        }

    }//GEN-LAST:event_cekilisYap_butonActionPerformed

    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Cekilis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cekilis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cekilis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cekilis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cekilis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JButton cekilisYap_buton;
    private javax.swing.JButton gozAt_buton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> kazananlarListesi;
    // End of variables declaration//GEN-END:variables
}
