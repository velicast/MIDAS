/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.midas.classify.gui;

import com.midas.classify.algorithms.SupervisedClassifier;
import com.midas.classify.algorithms.dtrees.C45;
import com.midas.classify.algorithms.dtrees.ID3;
import com.midas.classify.data.ARFFDataSource;
import com.midas.classify.data.Attribute;
import com.midas.classify.data.Instance;
import com.midas.classify.data.Instances;
import com.midas.classify.factory.ClassifierFactory;
import com.midas.classify.metrics.ConfusionMatrix;
import com.midas.classify.metrics.Validator;
import edu.uci.ics.jung.graph.DelegateTree;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Position;

/**
 *
 * @author Eduar Castrillo (eduarc)
 */
public class ClassificationPanel extends javax.swing.JPanel {

  /**
   * Creates new form Test
   */
  public ClassificationPanel() {
    
    initComponents();
    
    factoryManager = new FactoryManager(this);
    factoryManager.setBChoose(bModelChoose);
    factoryManager.setBConfig(bModelConfigure);
    
    validatorManager = new ValidatorManager(this);
    validatorManager.setBChoose(bValidatorChoose);
    validatorManager.setBConfig(bValidatorConfigure);
    
    fileChooser = new JFileChooser();
    fileChooser.setMultiSelectionEnabled(false);
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setAcceptAllFileFilterUsed(true);
    fileChooser.addChoosableFileFilter(new FileFilter() {
      @Override
      public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".arff");
      }
      @Override
      public String getDescription() {
        return "ARFF Transactional File";
      }
    });
    
    cbClassAttribute.setModel(new DefaultComboBoxModel(new String[] {}));
    cbIteration.setModel(new DefaultComboBoxModel(new String[] {}));
    cbPositiveClass.setModel(new DefaultComboBoxModel(new String[] {}));
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    splitPane = new javax.swing.JSplitPane();
    pLeft = new javax.swing.JPanel();
    pModel = new javax.swing.JPanel();
    bModelChoose = new javax.swing.JButton();
    bModelConfigure = new javax.swing.JButton();
    bModelBuild = new javax.swing.JButton();
    lClassAttribute = new javax.swing.JLabel();
    cbClassAttribute = new javax.swing.JComboBox();
    bClassFromFile = new javax.swing.JButton();
    bClassInteractive = new javax.swing.JButton();
    bModelGDiagram = new javax.swing.JButton();
    pTest = new javax.swing.JPanel();
    bValidatorChoose = new javax.swing.JButton();
    bValidatorConfigure = new javax.swing.JButton();
    bROCSpace = new javax.swing.JButton();
    bValidate = new javax.swing.JButton();
    lIteration = new javax.swing.JLabel();
    cbIteration = new javax.swing.JComboBox();
    lPositiveClass = new javax.swing.JLabel();
    cbPositiveClass = new javax.swing.JComboBox();
    pRight = new javax.swing.JPanel();
    scrollOutput = new javax.swing.JScrollPane();
    aOutput = new javax.swing.JTextPane();
    pConfigOutput = new javax.swing.JPanel();
    bOutputSave = new javax.swing.JButton();

    splitPane.setDividerLocation(300);

    pModel.setBorder(javax.swing.BorderFactory.createTitledBorder("Model"));

    bModelChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/edit-find.png"))); // NOI18N
    bModelChoose.setToolTipText("Choose the model");

    bModelConfigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/edit.png"))); // NOI18N
    bModelConfigure.setText("Configure");
    bModelConfigure.setToolTipText("Configure the model");
    bModelConfigure.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    bModelBuild.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    bModelBuild.setForeground(new java.awt.Color(255, 0, 0));
    bModelBuild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/build.png"))); // NOI18N
    bModelBuild.setText("BUILD");
    bModelBuild.setToolTipText("Build the specified model");
    bModelBuild.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bModelBuildActionPerformed(evt);
      }
    });

    lClassAttribute.setText("Class:");

    cbClassAttribute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cbClassAttribute.setToolTipText("Choose the target class attribute");

    bClassFromFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/open.png"))); // NOI18N
    bClassFromFile.setText("Classification");
    bClassFromFile.setToolTipText("Classify samples from file");
    bClassFromFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bClassFromFileActionPerformed(evt);
      }
    });

    bClassInteractive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/interactive1.png"))); // NOI18N
    bClassInteractive.setText("Interactive Classification");
    bClassInteractive.setToolTipText("Classify samples on-line");
    bClassInteractive.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bClassInteractiveActionPerformed(evt);
      }
    });

    bModelGDiagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/diagram.png"))); // NOI18N
    bModelGDiagram.setText("Diagram");
    bModelGDiagram.setToolTipText("Show a graphical representation of the model");
    bModelGDiagram.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bModelGDiagramActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pModelLayout = new javax.swing.GroupLayout(pModel);
    pModel.setLayout(pModelLayout);
    pModelLayout.setHorizontalGroup(
      pModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(bModelBuild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(pModelLayout.createSequentialGroup()
        .addComponent(bModelChoose)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bModelConfigure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(pModelLayout.createSequentialGroup()
        .addComponent(lClassAttribute)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cbClassAttribute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(bClassFromFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(bClassInteractive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(bModelGDiagram, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    pModelLayout.setVerticalGroup(
      pModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pModelLayout.createSequentialGroup()
        .addGroup(pModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(bModelChoose)
          .addComponent(bModelConfigure))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lClassAttribute)
          .addComponent(cbClassAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bModelBuild)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bClassFromFile)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bClassInteractive)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bModelGDiagram)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pTest.setBorder(javax.swing.BorderFactory.createTitledBorder("Validation"));

    bValidatorChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/edit-find.png"))); // NOI18N
    bValidatorChoose.setToolTipText("Choose the validator");

    bValidatorConfigure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/edit.png"))); // NOI18N
    bValidatorConfigure.setText("Configure");
    bValidatorConfigure.setToolTipText("Configure the validator");
    bValidatorConfigure.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    bROCSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/roc.png"))); // NOI18N
    bROCSpace.setText("ROC Space");
    bROCSpace.setToolTipText("Show the ROC space from validation");
    bROCSpace.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bROCSpaceActionPerformed(evt);
      }
    });

    bValidate.setForeground(new java.awt.Color(255, 0, 0));
    bValidate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/build.png"))); // NOI18N
    bValidate.setText("Validate");
    bValidate.setToolTipText("Validate the specified model");
    bValidate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bValidateActionPerformed(evt);
      }
    });

    lIteration.setText("Confusion Matrix:");

    cbIteration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cbIteration.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbIterationActionPerformed(evt);
      }
    });

    lPositiveClass.setText("Positive Class: ");

    cbPositiveClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    cbPositiveClass.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbPositiveClassActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pTestLayout = new javax.swing.GroupLayout(pTest);
    pTest.setLayout(pTestLayout);
    pTestLayout.setHorizontalGroup(
      pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(bROCSpace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(pTestLayout.createSequentialGroup()
        .addComponent(bValidatorChoose)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bValidatorConfigure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addComponent(bValidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pTestLayout.createSequentialGroup()
          .addComponent(lPositiveClass)
          .addGap(18, 18, 18)
          .addComponent(cbPositiveClass, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(pTestLayout.createSequentialGroup()
          .addComponent(lIteration)
          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          .addComponent(cbIteration, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
    );
    pTestLayout.setVerticalGroup(
      pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pTestLayout.createSequentialGroup()
        .addGroup(pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(bValidatorChoose)
          .addComponent(bValidatorConfigure))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bValidate)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cbPositiveClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lPositiveClass))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lIteration)
          .addComponent(cbIteration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(bROCSpace)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pLeftLayout = new javax.swing.GroupLayout(pLeft);
    pLeft.setLayout(pLeftLayout);
    pLeftLayout.setHorizontalGroup(
      pLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pLeftLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(pModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(pTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    pLeftLayout.setVerticalGroup(
      pLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pLeftLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(pModel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(pTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(68, Short.MAX_VALUE))
    );

    splitPane.setLeftComponent(pLeft);

    pRight.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

    aOutput.setFont(new java.awt.Font("Ubuntu Mono", 0, 16)); // NOI18N
    aOutput.setToolTipText("");
    scrollOutput.setViewportView(aOutput);

    bOutputSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/midas/classify/gui/icons/save.png"))); // NOI18N
    bOutputSave.setText("Save Output");
    bOutputSave.setToolTipText("Save output text to file");
    bOutputSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bOutputSaveActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout pConfigOutputLayout = new javax.swing.GroupLayout(pConfigOutput);
    pConfigOutput.setLayout(pConfigOutputLayout);
    pConfigOutputLayout.setHorizontalGroup(
      pConfigOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pConfigOutputLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(bOutputSave)
        .addContainerGap(381, Short.MAX_VALUE))
    );
    pConfigOutputLayout.setVerticalGroup(
      pConfigOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(bOutputSave)
    );

    javax.swing.GroupLayout pRightLayout = new javax.swing.GroupLayout(pRight);
    pRight.setLayout(pRightLayout);
    pRightLayout.setHorizontalGroup(
      pRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(pConfigOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRightLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(scrollOutput)
        .addContainerGap())
    );
    pRightLayout.setVerticalGroup(
      pRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pRightLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(pConfigOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(scrollOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        .addContainerGap())
    );

    splitPane.setRightComponent(pRight);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(splitPane)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void bModelBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModelBuildActionPerformed
    
    factory = factoryManager.getFactory();
    
    if (factory == null) {
      JOptionPane.showMessageDialog(this, "Configure the Model", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
  
    classAttribute = cbClassAttribute.getSelectedIndex();
    if (classAttribute == -1) {
      JOptionPane.showMessageDialog(this, "Select a Class attribute", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    dataset.setClassIndex(classAttribute);
    
    if (!dataset.classAttribute().isNominal()) {
      JOptionPane.showMessageDialog(this, "Class attribute must be nominal", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    try {
      classifier = factory.create(dataset);
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(this, e.getMessage(), "Icompatible dataset", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
      // show Build process Summary
    aOutput.setText(dataset.summary()+"\n"+classifier.toString());
    
    modelChanged = false;
  }//GEN-LAST:event_bModelBuildActionPerformed

  private void bClassInteractiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClassInteractiveActionPerformed

    if (classifier == null) {
      JOptionPane.showMessageDialog(this, "Build a model first", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    aOutput.setText(dataset.summary()+"\n*** Interactive Classification ***\n\n"+classifier.briefSummary()+"\n\n");
    List<Attribute> attrs = dataset.getAttributes();

    String title = "- Classified Samples\n";
    outputAppend(title);
    
    PredictionPanel panel = new PredictionPanel(classifier, this);
        
    JDialog f = new JDialog();
    f.add(panel, BorderLayout.CENTER);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    f.pack();
    f.setLocationRelativeTo(this);
    f.setVisible(true);
  }//GEN-LAST:event_bClassInteractiveActionPerformed

  private void bModelGDiagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModelGDiagramActionPerformed
    
    if (classifier == null) {
      JOptionPane.showMessageDialog(this, "Build a model first", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    if (classifier instanceof ID3 || classifier instanceof C45) {
      JDialog graphicalViewer = new JDialog();
      
      String[] classes = new String[dataset.numClasses()];
      for (int i = 0; i < dataset.numClasses(); i++) {
        classes[i] = dataset.classAttribute().value(i);
      }
      DelegateTree tree;
      if (classifier instanceof ID3) {
        tree = ((ID3)classifier).getDecisionTree();
      } else {
        tree = ((C45)classifier).getDecisionTree();
      }
      graphicalViewer.setTitle("Tree Graph viewer");
      graphicalViewer.add(new DecisionTreeViewer(tree, classes));
      graphicalViewer.pack();
      graphicalViewer.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      graphicalViewer.setLocationRelativeTo(this);
      graphicalViewer.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
      graphicalViewer.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(this, "The current model has no diagram", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
  }//GEN-LAST:event_bModelGDiagramActionPerformed

  private void bClassFromFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClassFromFileActionPerformed
    
    if (classifier == null) {
      JOptionPane.showMessageDialog(this, "Build a model first", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    FromFilePanel panel = new FromFilePanel(this);
    int r = panel.showDialog(this);
    
    if (r == PopupDialog.OK) {
      File out = panel.output;
      File in  = panel.input;
      
      List<Attribute> tmp_attrs = new ArrayList(), attrs = dataset.getAttributes();
      int n = attrs.size();
      int classIndex = dataset.classIndex();
      
      for (int i = 0; i < n; i++) {
        if (classIndex != i) {
          tmp_attrs.add(attrs.get(i));
        }
      }
      Instances tmp_ins = new Instances(dataset.relationName()+" samples", tmp_attrs);
      ARFFDataSource source = new ARFFDataSource(tmp_ins);
      
      try {
        InputStream iStream = new FileInputStream(in);
        source.readData(new BufferedReader(new InputStreamReader(iStream)), "@DATA");
        tmp_ins = source.getDataset();
      } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(this, "Input file not found", "Error", JOptionPane.ERROR_MESSAGE);
        return;
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
      }
      
      Instances ins = new Instances(dataset, false);
      
      for (int i = 0; i < tmp_ins.size(); i++) {
        Instance src = tmp_ins.get(i);
        Instance dst = new Instance(n);
        int k = 0;
        for (int j = 0; j < n-1; ++j) {
          if (classIndex == k) {
            ++k;
          }
          dst.setValue(k++, src.value(j));
        }
        dst.setDataset(dataset);
        ins.add(dst);
      }
      
      int[] classy = classifier.classify(ins);
      for (int i = 0; i < classy.length; i++) {
        ins.get(i).setClassValue(classy[i]);
      }
      
      if (out != null) {
        try {
          out.createNewFile();
          try (FileWriter writer = new FileWriter(out)) {
            writer.write(ins.toString());
            writer.close();
          }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(this, "Error when writing to output file", "Error", JOptionPane.ERROR_MESSAGE);
          return;
        }
      }
      
      aOutput.setText(dataset.summary()+"\n*** From File Classification ***\n\n"+classifier.briefSummary()+"\n");
      String str = "Input file: "+in.getAbsolutePath()+"\n";
      if (out != null) {
        str += "Output file: "+out.getAbsolutePath()+"\n";
      }
      str += "\n*** Results (max 100 samples): To see the complete results, choose an output file ***\n\n";
      str += "- Classified Samples\n";
      outputAppend(str);
      for (int i = 0; i < Math.min(100, ins.size()); i++) {
        outputAppend(ins.get(i).toStringNoWeight()+"\n");
      }
    }
  }//GEN-LAST:event_bClassFromFileActionPerformed

  private void outputAppend(String s) {
    
    Document doc = aOutput.getDocument();
    Position p = doc.getEndPosition();
    try {
      doc.insertString(p.getOffset(), s, null);
    } catch (BadLocationException ex) {
      System.err.println("BAD LOCATION");
    }
  }
  
  private void bOutputSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOutputSaveActionPerformed
    
    int r = fileChooser.showSaveDialog(this);
    
    if (r == JFileChooser.APPROVE_OPTION) {
      File out = fileChooser.getSelectedFile();
      try {
        out.createNewFile();
        try (FileWriter writer = new FileWriter(out)) {
          writer.write(aOutput.getText());
          writer.close();
        }
      } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error when writing to output file", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }//GEN-LAST:event_bOutputSaveActionPerformed

  private void bROCSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bROCSpaceActionPerformed
    
    int pos = cbPositiveClass.getSelectedIndex();
    int numClasses = dataset.numClasses();
    int iters = validator.getTests();
    ConfusionMatrix mat;
    
    if (pos == numClasses) {
      JOptionPane.showMessageDialog(this, "Select a specifics positive class", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    double[] tpr = new double[iters];
    double[] fpr = new double[iters];
    double[] avgTpr = new double[1];
    double[] avgFpr = new double[1];
        
    for (int i = 0; i < iters; i++) {
      ConfusionMatrix m = validator.getConfusionMatrix(i).getBinaryMatrix(pos);
      tpr[i] = m.getTruePositiveRate();
      fpr[i] = m.getFalsePositiveRate();
    }
    mat = validator.getAvgConfusionMatrix().getBinaryMatrix(pos);
    avgTpr[0] = mat.getTrueNegativeRate();
    avgFpr[0] = mat.getFalsePositiveRate();
    
    ROCSpaceViewer gr = new ROCSpaceViewer(tpr, fpr, avgTpr, avgFpr);
    
    JDialog graphicalViewer = new JDialog();
    graphicalViewer.setTitle("ROC Space");
    graphicalViewer.add(gr);
    graphicalViewer.pack();
    graphicalViewer.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    graphicalViewer.setLocationRelativeTo(this);
    graphicalViewer.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
    graphicalViewer.setVisible(true);
  }//GEN-LAST:event_bROCSpaceActionPerformed

  private void bValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bValidateActionPerformed
    
    factory = factoryManager.getFactory();
    if (factory == null) {
      JOptionPane.showMessageDialog(this, "Configure the Model", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    classAttribute = cbClassAttribute.getSelectedIndex();
    if (classAttribute == -1) {
      JOptionPane.showMessageDialog(this, "Select a Class attribute", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    dataset.setClassIndex(classAttribute);
    
    if (!dataset.classAttribute().isNominal()) {
      JOptionPane.showMessageDialog(this, "Class attribute must be nominal", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    validator = validatorManager.getValidator();
    if (validator == null) {
      JOptionPane.showMessageDialog(this, "Configure the Validator", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    validator.setFactory(factory);
    
    try {
      validator.validate();
    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage(), "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    List<String> lpc = dataset.classAttribute().values();
    String[] pc = new String[lpc.size()+1];
    for (int i = 0; i < pc.length-1; i++) {
      pc[i] = lpc.get(i);
    }
    pc[lpc.size()] = "Any";
    cbPositiveClass.setModel(new DefaultComboBoxModel(pc));
    cbPositiveClass.setSelectedIndex(pc.length-1);
    
    String[] viter = new String[validator.getTests()+1];
    for (int i = 0; i < viter.length-1; i++) {
      viter[i] = "Matrix "+i;
    }
    viter[validator.getTests()] = "Average";
    cbIteration.setModel(new DefaultComboBoxModel(viter));
    cbIteration.setSelectedIndex(viter.length-1);
    
    updateConfusionMatrix();  
  }//GEN-LAST:event_bValidateActionPerformed

  public void updateConfusionMatrix() {
    
    if (validator == null) {
      JOptionPane.showMessageDialog(this, "Validate a model first", "Info", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    
    int index = cbIteration.getSelectedIndex();
    int pos = cbPositiveClass.getSelectedIndex();
    
    if (index == -1 || pos == -1) {
      return;
    }
    
    int numClasses = dataset.numClasses();
    int iters = validator.getTests();
    ConfusionMatrix mat;
    
    if (index == iters) {
      mat = validator.getAvgConfusionMatrix();
    } else {
      mat = validator.getConfusionMatrix(index);
    }
    if (pos < numClasses) {
      mat = mat.getBinaryMatrix(pos);
    }
    
    Attribute att = mat.getAttribute();
    
    DecimalFormat df = new DecimalFormat();
    df.setMinimumFractionDigits(2);
    df.setMaximumFractionDigits(2);
    
    aOutput.setText(dataset.summary()+"\n"+validator.summary()+"\n");
    
    String out = "Class Error:\n";
    for (int i = 0; i < att.numValues(); i++) {
      out += " - "+att.value(i)+" = "+df.format(mat.getClassError(i))+"\n";
    }
    out += "\nConfusion Matrix\n\n";
    out += mat.toString()+"\n";
    
    if (pos < numClasses) {
      double[] mes = mat.getMeasures();
      String[] mesName = ConfusionMatrix.measureName;
      for (int i = 0; i < ConfusionMatrix.NUM_MEASURES; i++) {
        out += mesName[i]+" = "+df.format(mes[i])+"\n";
      }
    }
    outputAppend(out);
  }
  
  private void cbIterationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIterationActionPerformed
    updateConfusionMatrix();  
  }//GEN-LAST:event_cbIterationActionPerformed

  private void cbPositiveClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPositiveClassActionPerformed
    updateConfusionMatrix();  
  }//GEN-LAST:event_cbPositiveClassActionPerformed

  public void updateDataset(Instances ds) {
    
    dataset = ds;
    int n = dataset.numAttributes();
    classAttribute = -1;

    String[] attrs = new String[n];
    for (int i = 0; i < n; i++) {
      attrs[i] = dataset.attribute(i).name();
      if (classAttribute == -1 && attrs[i].toLowerCase().equals("class")) {
        classAttribute = i;
      }
    }
    cbClassAttribute.setModel(new DefaultComboBoxModel(attrs));
    if (classAttribute == -1) {
      classAttribute = 0;
    }
    cbClassAttribute.setSelectedIndex(classAttribute);
    
    datasetUpdated = true;
  }
  
  public static void main(String[] args) {
    ClassificationPanel c = new ClassificationPanel();
    
    Instances dataSet;
    ARFFDataSource stream;
    File f;
    
    try {
      f = new File("./archivos/iris.arff");
      
      if (!f.exists()) {
        System.out.println("N'existe pas");
        System.exit(0);
      }
      stream = new ARFFDataSource();
      dataSet = stream.read(new FileInputStream(f));
    } catch (IOException ex) {
      System.out.println("ERROR!!!!");
      System.out.println(ex.getMessage());
      return;
    }
    
    dataSet.setClassIndex(4);
    
    c.updateDataset(dataSet);
    
    JFrame fr = new JFrame("Classification Panel");
    fr.add(c, BorderLayout.CENTER);
    fr.pack();
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setVisible(true);
  }
  
    // Global Worked variables
  int classAttribute;
  public Instances dataset;
  public ClassifierFactory factory;
  public Validator validator;
  public SupervisedClassifier classifier;
  
  boolean datasetUpdated;
  boolean testChanged;
  boolean modelChanged;
  boolean configuredModel;
  
  public FactoryManager factoryManager;
  public ValidatorManager validatorManager;
  
  JFileChooser fileChooser;
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  javax.swing.JTextPane aOutput;
  private javax.swing.JButton bClassFromFile;
  private javax.swing.JButton bClassInteractive;
  private javax.swing.JButton bModelBuild;
  private javax.swing.JButton bModelChoose;
  private javax.swing.JButton bModelConfigure;
  private javax.swing.JButton bModelGDiagram;
  private javax.swing.JButton bOutputSave;
  private javax.swing.JButton bROCSpace;
  private javax.swing.JButton bValidate;
  private javax.swing.JButton bValidatorChoose;
  private javax.swing.JButton bValidatorConfigure;
  private javax.swing.JComboBox cbClassAttribute;
  private javax.swing.JComboBox cbIteration;
  private javax.swing.JComboBox cbPositiveClass;
  private javax.swing.JLabel lClassAttribute;
  private javax.swing.JLabel lIteration;
  private javax.swing.JLabel lPositiveClass;
  private javax.swing.JPanel pConfigOutput;
  private javax.swing.JPanel pLeft;
  private javax.swing.JPanel pModel;
  private javax.swing.JPanel pRight;
  private javax.swing.JPanel pTest;
  private javax.swing.JScrollPane scrollOutput;
  private javax.swing.JSplitPane splitPane;
  // End of variables declaration//GEN-END:variables
}

