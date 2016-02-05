/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midas.classify.gui;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author tkd
 */
public class DistanceChooser extends javax.swing.JDialog {

  public static final int D_EUCLIDEAN = 0;
  public static final int D_COSINE = 1;
  public static final int D_HAMMING = 2;
  
  public static final String[] DISTANCE_NAME = {"Euclidean",
                                                "Cosine",
                                               "Hamming"};
  
  /**
   * Creates new form DistanceSelecter
   */
  public DistanceChooser() {
    
    setModalityType(ModalityType.APPLICATION_MODAL);
    setResizable(false);
    setUndecorated(true);
    
    initComponents();
    
    listDistances.setModel(new javax.swing.AbstractListModel() {
      public int getSize() { return DISTANCE_NAME.length; }
      public Object getElementAt(int i) { return DISTANCE_NAME[i]; }
    });
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    listDistances = new javax.swing.JList();
    bCancel = new javax.swing.JButton();
    bOk = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    listDistances.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jScrollPane1.setViewportView(listDistances);

    bCancel.setText("Cancel");
    bCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCancelActionPerformed(evt);
      }
    });

    bOk.setText("Ok");
    bOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bOkActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addGroup(layout.createSequentialGroup()
        .addComponent(bOk)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bCancel)
        .addGap(6, 6, 6))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bCancel)
          .addComponent(bOk)))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
    
    int i = listDistances.getSelectedIndex();
    if (i == -1) {
      JOptionPane.showMessageDialog(this, "Select a distance", "Warning", JOptionPane.WARNING_MESSAGE);
    } else {
      selected = i;
      dispose();
    }
  }//GEN-LAST:event_bOkActionPerformed

  private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
    
    selected = -1;
    dispose();
  }//GEN-LAST:event_bCancelActionPerformed

  public int showDialog(Component parent) {
    
    setLocationRelativeTo(parent);
    setVisible(true);
    return selected;
  }
  
  public int getSelectedIndex() {
    return selected;
  }
  
  public String getSelectedName() {
    
    if (selected != -1) {
      return DISTANCE_NAME[selected];
    }
    return null;
  }
  
  int selected = -1;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bCancel;
  private javax.swing.JButton bOk;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList listDistances;
  // End of variables declaration//GEN-END:variables
}