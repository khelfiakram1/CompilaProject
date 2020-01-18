
package analyseurcompila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author khelfi
 */
public class Analyseur extends javax.swing.JFrame {

   ArrayList lineList=new ArrayList();
    ArrayList tokensList=new ArrayList();
    ArrayList stlineList=new ArrayList();
    String code;
    File file;
    IdChecker id = new IdChecker();
    public Analyseur() {
        initComponents();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_semantique = new java.awt.Label();
        btn_ajouter = new java.awt.Label();
        btn_lexicale = new java.awt.Label();
        btn_syntaxique = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_semantique.setAlignment(java.awt.Label.CENTER);
        btn_semantique.setBackground(new java.awt.Color(89, 89, 89));
        btn_semantique.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btn_semantique.setForeground(new java.awt.Color(254, 254, 254));
        btn_semantique.setText("Analyse semantique");
        btn_semantique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_semantiqueMouseClicked(evt);
            }
        });
        jPanel1.add(btn_semantique, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 170, 50));

        btn_ajouter.setAlignment(java.awt.Label.CENTER);
        btn_ajouter.setBackground(new java.awt.Color(89, 89, 89));
        btn_ajouter.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btn_ajouter.setForeground(new java.awt.Color(254, 254, 254));
        btn_ajouter.setText("Ajouter un fichier");
        btn_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ajouterMouseClicked(evt);
            }
        });
        jPanel1.add(btn_ajouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 170, 50));

        btn_lexicale.setAlignment(java.awt.Label.CENTER);
        btn_lexicale.setBackground(new java.awt.Color(89, 89, 89));
        btn_lexicale.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btn_lexicale.setForeground(new java.awt.Color(254, 254, 254));
        btn_lexicale.setText("Analyse Lexicale ");
        btn_lexicale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_lexicaleMouseClicked(evt);
            }
        });
        jPanel1.add(btn_lexicale, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 170, 50));

        btn_syntaxique.setAlignment(java.awt.Label.CENTER);
        btn_syntaxique.setBackground(new java.awt.Color(89, 89, 89));
        btn_syntaxique.setFont(new java.awt.Font("Liberation Sans", 1, 16)); // NOI18N
        btn_syntaxique.setForeground(new java.awt.Color(254, 254, 254));
        btn_syntaxique.setText("Analyse syntaxique ");
        btn_syntaxique.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_syntaxiqueMouseClicked(evt);
            }
        });
        jPanel1.add(btn_syntaxique, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 170, 50));

        jScrollPane2.setBackground(new java.awt.Color(94, 94, 94));

        display.setBackground(new java.awt.Color(119, 119, 119));
        display.setColumns(20);
        display.setForeground(new java.awt.Color(254, 254, 254));
        display.setRows(5);
        jScrollPane2.setViewportView(display);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 360, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ajouterMouseClicked
        final JFileChooser fileChooser = new JFileChooser();
        final FileNameExtensionFilter filter = new FileNameExtensionFilter("COMPILA file", "compila");
        fileChooser.setDialogTitle("Choose a file");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // get the file
             file = fileChooser.getSelectedFile();
            FileReader fileReader = null;
             try {
            fileReader = new FileReader(file);
        } catch (final FileNotFoundException ex) {
            Logger.getLogger(Analyseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        final BufferedReader bufferedReader = new BufferedReader(fileReader);
        final StringBuffer stringBuffer = new StringBuffer();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                lineList.add(line);// list of lines
            }
        } catch (final IOException ex) {
            Logger.getLogger(Analyseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileReader.close();
        } catch (final IOException ex) {
            Logger.getLogger(Analyseur.class.getName()).log(Level.SEVERE, null, ex);
        }
        code = stringBuffer.toString();// the code
        display.setText(code);
        }
    }//GEN-LAST:event_btn_ajouterMouseClicked

    private void btn_lexicaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lexicaleMouseClicked
        String tokensprinter = "";
        final StringTokenizer st = new StringTokenizer(code);

        while (st.hasMoreTokens())
            tokensList.add(st.nextToken());
        for (int i = 0; i < tokensList.size(); i++) {

            if (tokensList.get(i).equals("Start_Program") || tokensList.get(i).equals("start_Program"))
                tokensprinter = tokensList.get(i) + " : Mot résevé pour debut de program\n";
            else if (tokensList.get(i).equals("End_Program"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot réservé pour fin de program\n";
            else if (tokensList.get(i).equals("Int_Number"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour declaration d'un entier\n";
            else if (tokensList.get(i).equals(","))
                tokensprinter = tokensprinter + tokensList.get(i) + " : une virgule\n";
            else if (tokensList.get(i).equals("Real_Number"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour declaration d'un real\n";
            else if (tokensList.get(i).equals(";;"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour fin de ligne\n";
            else if (tokensList.get(i).equals("Give"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour initialisation\n";
            else if (tokensList.get(i).equals("If"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour une condition\n";
            else if (tokensList.get(i).equals("Else"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour une 2eme codition\n";
            else if (tokensList.get(i).equals("<"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Operatuer de comparaison\n";
            else if (tokensList.get(i).equals(">"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Operatuer de comparaison\n";
            else if (tokensList.get(i).equals("--"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : debut ou fin de codition\n";
            else if (tokensList.get(i).equals("Start"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot réservé pour un debut de block\n";
            else if (tokensList.get(i).equals("Finish"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour un fin de block\n";
            else if (tokensList.get(i).equals("ShowMes"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot réservé pour affichage\n";
            else if (tokensList.get(i).equals("//."))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour commentaire\n";
            else if (tokensList.get(i).equals("Affect"))
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour affectation\n";
            else if (isNumeric((String) tokensList.get(i)) == true)
                tokensprinter = tokensprinter + tokensList.get(i) + " : Mot resevé pour un nombre\n";
            else if (tokensList.get(i).equals("\""))
                tokensprinter = tokensprinter + tokensList.get(i) + " : debut ou fin d'un message\n";
            else if (id.checkID((String) tokensList.get(i)) == 1)
                tokensprinter = tokensprinter + tokensList.get(i) + " : identificateur\n";
        }
       display.setText(tokensprinter);
    }//GEN-LAST:event_btn_lexicaleMouseClicked

    private void btn_syntaxiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_syntaxiqueMouseClicked
        String syntaxprinter = "";
        StringTokenizer stemp;
        int bool = 0;
        boolean enter = false;
         if (lineList.get(0).equals("Start_Program") || lineList.get(0).equals("Start_Program")) {
            syntaxprinter = syntaxprinter + lineList.get(0) + " : valid starting\n";
            enter = true;
        }else
            syntaxprinter = syntaxprinter + "starting non valide\n";
        
         for (int i = 1; i < lineList.size() && enter == true; i++) {
        
           stemp = new StringTokenizer((String) lineList.get(i));  
            while (stemp.hasMoreTokens())
                stlineList.add(stemp.nextToken());
            if (stlineList.get(0).equals("Int_Number") || stlineList.get(0).equals("Real_Number")) {
                for (int j = 1; j < stlineList.size(); j++) {
                    if (stlineList.get(j).equals(";;")) {
                        // bool=1;
                        break;
                    } else if (id.checkID((String) stlineList.get(j)) == 1) {
                        bool = 1;
                    } else if (stlineList.get(j).equals(","))
                        ;
                    else {
                        bool = 0;
                        break;
                    }
if (!stlineList.get(stlineList.size() - 1).equals(";;"))
                        bool = 0;
                }
                 if (stlineList.get(1).equals(","))
                    bool = 0;
                if (stlineList.get(1).equals(":"))
                    bool = 1;

                if (bool == 1)
                    syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                else if (bool == 0)
                    syntaxprinter = syntaxprinter
                            + "non valide verifiez votre syntaxe ou Id non valide ou il manque des espaces";
            }
            
            if (stlineList.get(0).equals("Affect")) {
                if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(2).equals("to")) {
                        if (id.checkID((String) stlineList.get(3)) == 1) {
                            if (stlineList.get(4).equals(";;")) {
                                syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                            } else
                                syntaxprinter = syntaxprinter + " : il manque une ;;";
                        } else
                            syntaxprinter = syntaxprinter + " : 2eme id non valide";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque \":\" ";
                } else
                    syntaxprinter = syntaxprinter + " : 1er id non valide";
            }
            // -----------------------------------------------------
            if (stlineList.get(0).equals("ShowMes")) {

                if (stlineList.get(1).equals(":")) {
                    if (stlineList.get(stlineList.size() - 2).equals("\"")) {

                        if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                            syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                        } else
                            syntaxprinter = syntaxprinter + " : il manque une ;;";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque  une \"";
                }

                else if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                        syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une ;;";
                } else
                    syntaxprinter = syntaxprinter + "non valide verifiez votre syntaxe";
            }

            if (stlineList.get(0).equals("ShowVal")) {
                if (stlineList.get(1).equals(":")) {
                    if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                        syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une ;;";
                }
            }
            // -----------------------------------------------------------
            if (stlineList.get(0).equals("//.")) {
                bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
            }
            // ---------------------------------------------------------if
            if (stlineList.get(0).equals("If") || stlineList.get(0).equals("if")) {
                if (stlineList.get(1).equals("--")) {
                    if (id.checkID((String) stlineList.get(2)) == 1) {
                        // if(stlineList.get(3).equals(">") || stlineList.get(3).equals("<")){
                        if (id.checkID((String) stlineList.get(4)) == 1) {
                            if (stlineList.get(5).equals("--")) {
                            } else
                                syntaxprinter = syntaxprinter + "il manque le 2eme --\n";
                        } else
                            syntaxprinter = syntaxprinter + "il manque le 2eme id ou il est non valide\n";
                        // }
                        // else syntaxprinter=syntaxprinter+"no <>\n";
                    } else
                        syntaxprinter = syntaxprinter + "il manque le 1er id ou il est non valide\n";
                } else
                    syntaxprinter = syntaxprinter + "il manque le 1er --\n";

                if (bool == 1)
                    syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                else if (bool == 0)
                    syntaxprinter = syntaxprinter + "non valide verifiez votre syntaxe";
            }
            // -------------------------------------------------------Set
            if (stlineList.get(0).equals("Give")) {
                if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(2).equals(":")) {
                        if (isNumeric((String) stlineList.get(3)) == true) {
                            if (stlineList.get(4).equals(";;")) {
                                syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                            } else
                                bool = 0;
                        } else
                            syntaxprinter = syntaxprinter + " : il manque une ;;";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une le : ";
                } else
                    syntaxprinter = syntaxprinter + " : id non valide";
            }
            // ------------------------------------------------------- Else Start Finish
            if (stlineList.get(0).equals("Else") || stlineList.get(0).equals("Start")
                    || stlineList.get(0).equals("Finish")) {
                bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
            }
            // -------------------------------------------------------------videz la list
            // des linetokens
            syntaxprinter = syntaxprinter + "\n";
            stlineList.clear();
            
         }
        if (VerifBlock(code) == false)
            syntaxprinter = syntaxprinter + " il manque une 'Start' ou 'Finish'";
        // --------------------------------------------------closing
        if (lineList.get(lineList.size() - 1).equals("End_Program")) {
            syntaxprinter = syntaxprinter + lineList.get(lineList.size() - 1) + " : valid closnging\n";
            enter = true;
        } else
            syntaxprinter = syntaxprinter + "closing non valide\n";
        stlineList.clear();
        display.setText(syntaxprinter);   
    }//GEN-LAST:event_btn_syntaxiqueMouseClicked

    private void btn_semantiqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_semantiqueMouseClicked
        
       String syntaxprinter = "";
        StringTokenizer stemp;
        int bool = 0;
        boolean enter = false;
         if (lineList.get(0).equals("Start_Program") || lineList.get(0).equals("Start_Program")) {
            syntaxprinter = syntaxprinter + lineList.get(0) + " : Debut du programme \n";
            enter = true;
        }else
            syntaxprinter = syntaxprinter + "starting non valide\n";
        
         for (int i = 1; i < lineList.size() && enter == true; i++) {
        
           stemp = new StringTokenizer((String) lineList.get(i));  
            while (stemp.hasMoreTokens())
                stlineList.add(stemp.nextToken());
            if (stlineList.get(0).equals("Int_Number") || stlineList.get(0).equals("Real_Number")) {
                for (int j = 1; j < stlineList.size(); j++) {
                    if (stlineList.get(j).equals(";;")) {
                        // bool=1;
                        break;
                    } else if (id.checkID((String) stlineList.get(j)) == 1) {
                        bool = 1;
                    } else if (stlineList.get(j).equals(","))
                        ;
                    else {
                        bool = 0;
                        break;
                    }
if (!stlineList.get(stlineList.size() - 1).equals(";;"))
                        bool = 0;
                }
                 if (stlineList.get(1).equals(","))
                    bool = 0;
                if (stlineList.get(1).equals(":"))
                    bool = 1;

                if (bool == 1)
                    syntaxprinter = syntaxprinter + lineList.get(i) + " : declaration d'entiers ou reels ";
                else if (bool == 0)
                    syntaxprinter = syntaxprinter
                            + "non valide verifiez votre syntaxe ou Id non valide ou il manque des espaces";
            }
            
            if (stlineList.get(0).equals("Affect")) {
                if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(2).equals("to")) {
                        if (id.checkID((String) stlineList.get(3)) == 1) {
                            if (stlineList.get(4).equals(";;")) {
                                syntaxprinter = syntaxprinter + lineList.get(i) + " : affectation d'un nombre a une variable";
                            } else
                                syntaxprinter = syntaxprinter + " : il manque une ;;";
                        } else
                            syntaxprinter = syntaxprinter + " : 2eme id non valide";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque \":\" ";
                } else
                    syntaxprinter = syntaxprinter + " : 1er id non valide";
            }
            // -----------------------------------------------------
            if (stlineList.get(0).equals("ShowMes")) {

                if (stlineList.get(1).equals(":")) {
                    if (stlineList.get(stlineList.size() - 2).equals("\"")) {

                        if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                            syntaxprinter = syntaxprinter + lineList.get(i) + " : affichage sur ecran";
                        } else
                            syntaxprinter = syntaxprinter + " : il manque une ;;";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque  une \"";
                }

                else if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                        syntaxprinter = syntaxprinter + lineList.get(i) + " : valide";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une ;;";
                } else
                    syntaxprinter = syntaxprinter + "non valide verifiez votre syntaxe";
            }

            if (stlineList.get(0).equals("ShowVal")) {
                if (stlineList.get(1).equals(":")) {
                    if (stlineList.get(stlineList.size() - 1).equals(";;")) {
                        syntaxprinter = syntaxprinter + lineList.get(i) + " : affichage de la valeur d'une variable ";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une ;;";
                }
            }
            // -----------------------------------------------------------
            if (stlineList.get(0).equals("//.")) {
                bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : un commentaire ";
            }
            // ---------------------------------------------------------if
            if (stlineList.get(0).equals("If") || stlineList.get(0).equals("if")) {
                if (stlineList.get(1).equals("--")) {
                    if (id.checkID((String) stlineList.get(2)) == 1) {
                        // if(stlineList.get(3).equals(">") || stlineList.get(3).equals("<")){
                        if (id.checkID((String) stlineList.get(4)) == 1) {
                            if (stlineList.get(5).equals("--")) {
                            } else
                                syntaxprinter = syntaxprinter + "il manque le 2eme --\n";
                        } else
                            syntaxprinter = syntaxprinter + "il manque le 2eme id ou il est non valide\n";
                        // }
                        // else syntaxprinter=syntaxprinter+"no <>\n";
                    } else
                        syntaxprinter = syntaxprinter + "il manque le 1er id ou il est non valide\n";
                } else
                    syntaxprinter = syntaxprinter + "il manque le 1er --\n";

                if (bool == 1)
                    syntaxprinter = syntaxprinter + lineList.get(i) + " : une condition";
                else if (bool == 0)
                    syntaxprinter = syntaxprinter + "non valide verifiez votre syntaxe";
            }
            // -------------------------------------------------------Set
            if (stlineList.get(0).equals("Give")) {
                if (id.checkID((String) stlineList.get(1)) == 1) {
                    if (stlineList.get(2).equals(":")) {
                        if (isNumeric((String) stlineList.get(3)) == true) {
                            if (stlineList.get(4).equals(";;")) {
                                syntaxprinter = syntaxprinter + lineList.get(i) + " : affecter une valeur a une variable ";
                            } else
                                bool = 0;
                        } else
                            syntaxprinter = syntaxprinter + " : il manque une ;;";
                    } else
                        syntaxprinter = syntaxprinter + " : il manque une le : ";
                } else
                    syntaxprinter = syntaxprinter + " : id non valide";
            }
            // ------------------------------------------------------- Else Start Finish
            if (stlineList.get(0).equals("Else") ){
             bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : sinon d'une condition ";
            }
                    
                    if( stlineList.get(0).equals("Start")){ bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : debut d'une condition ";}
                   if( stlineList.get(0).equals("Finish")) {
                bool = 1;
                syntaxprinter = syntaxprinter + lineList.get(i) + " : fin d'une condition ";
            }
            // -------------------------------------------------------------videz la list
            // des linetokens
            syntaxprinter = syntaxprinter + "\n";
            stlineList.clear();
            
         }
        if (VerifBlock(code) == false)
            syntaxprinter = syntaxprinter + " il manque une 'Start' ou 'Finish'";
        // --------------------------------------------------closing
        if (lineList.get(lineList.size() - 1).equals("End_Program")) {
            syntaxprinter = syntaxprinter + lineList.get(lineList.size() - 1) + " : fin d'un programme \n";
            enter = true;
        } else
            syntaxprinter = syntaxprinter + "closing non valide\n";
        stlineList.clear();
        display.setText(syntaxprinter); 
        
    }//GEN-LAST:event_btn_semantiqueMouseClicked
public static boolean isNumeric(final String str) {
        try {
            final double d = Double.parseDouble(str);
        } catch (final NumberFormatException nfe) {
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(Analyseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analyseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analyseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analyseur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analyseur().setVisible(true);
            }
        });
    }
    public boolean VerifBlock(final String codeTokens) {
        final ArrayList blockList = new ArrayList();
        final StringTokenizer st = new StringTokenizer(codeTokens);
        int start = 0, finish = 0;
        while (st.hasMoreTokens())
            blockList.add(st.nextToken());
        for (int i = 0; i < blockList.size(); i++) {
            if (blockList.get(i).equals("Start"))
                start++;
            if (blockList.get(i).equals("Finish"))
                finish++;
        }
        if (start == finish)
            return true;
        else
            return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label btn_ajouter;
    private java.awt.Label btn_lexicale;
    private java.awt.Label btn_semantique;
    private java.awt.Label btn_syntaxique;
    private javax.swing.JTextArea display;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
