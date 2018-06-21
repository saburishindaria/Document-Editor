/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package document.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollBar;
import javax.swing.BorderFactory.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
//import org.apache.poi.xwpf.extractor.XWPFWordExtractor; 



//COMMAND
interface Button1{
    public void create();
}

//DECORATOR
interface Decorator{
    public void apply();
}

//COMPOSITE DP
interface common{
JPanel addcomposite(int n);
void addleaf(JFrame frame, JTextPane tabby);
}

class DP1 implements common,Decorator{
    // JScrollPane scrollpane;
    
    JFrame frame;
    Border bou;
    Border blackline;
    JPanel pan2;   
    JTextPane ta1;
    JLabel l1;
    
    DP1(){
    blackline=BorderFactory.createLineBorder(Color.black);
    frame = new JFrame("Document Editor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLayout(new BorderLayout());
    frame.setSize(600, 600);
    }    
   
    public JFrame getframe(){
        return frame;
    }
    
    @Override
    public JPanel addcomposite(int n) {
       int n1=n;
       
    
       if(n1==1){
           JTabbedPane pp;
       }
       
       if(n1==2){       
       pan2=new JPanel();             
       frame.add(pan2,BorderLayout.EAST);
        pan2.setMinimumSize(new Dimension(1360,400));
        pan2.setMaximumSize(new Dimension(1360,400));
        pan2.setBackground(Color.RED);
        pan2.getBaselineResizeBehavior();
        pan2.setVisible(true);
        ta1=new JTextPane();
        JScrollPane s=new JScrollPane(ta1);
        s.setVisible(true);
        //ta1.add(s);
        frame.getContentPane().add(s);
        pan2.setLayout(new BorderLayout());
        ta1.setPreferredSize(new Dimension(1910,800));
        ta1.setAutoscrolls(true);
        pan2.add(ta1,BorderLayout.NORTH);
        return pan2;
        }
       return(new JPanel());
          }

    @Override
    public void addleaf(JFrame frame, JTextPane tabby) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public JTextPane getTextPane(){
        return ta1;
    }

    @Override
    public void apply() {
      
        ta1.setBorder(blackline);           
    }

}


class DP2 implements common{
    JFrame frame;
    JTabbedPane tb1;
    JPanel pan2,pan3;
    DP2(JFrame frame){
        this.frame=frame;
    }
    @Override
    public JPanel addcomposite(int n) {
        int n1=n;
        tb1=new JTabbedPane();
        frame.getContentPane().add(tb1);
        tb1.setPreferredSize(new Dimension(600,150));
        tb1.setBackground(Color.YELLOW);
        frame.add(tb1,BorderLayout.NORTH);
        tb1.setVisible(true);
        pan2=new JPanel();
        tb1.addTab("HOME",null, pan2,"HOME");
            pan3=new JPanel();
            tb1.addTab("INSERT",null, pan3,"INSERT");
            if(n1==1){
                return pan2;
            }
            if(n1==2){
            return pan3;
            }
            else return pan3;
    }
    @Override
    public void addleaf(JFrame frame,JTextPane tabby) {
        JTextPane ta1=tabby;
        Button2 b=new Button2(pan2,ta1); 
        Button3 b1=new Button3(pan2,ta1);
        Button4 b2=new Button4(pan2,ta1);
        Button5 b3=new Button5(pan2,ta1);
        Button7 b5=new Button7(pan2,ta1);   
        Button8 b6=new Button8(pan2,ta1);   
        Button6 b4=new Button6(pan3,ta1); 
        Button9 b7=new Button9(pan3,ta1,frame);
        Button10 b8=new Button10(pan3,ta1,frame);
        Button11 b9=new Button11(pan3,ta1,frame);
        
    }

class Button2 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
     Border blackline, raisedbevel;
    Button2(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
         b=new JButton("Border");
         ta1.setBorder(blackline);
         create();
        
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(50,100,90,40);
         blackline= BorderFactory.createLineBorder(Color.black,5);
        ta1.setBorder(blackline);
         b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         Color color = JColorChooser.showDialog(pan2, "Choose a color", Color.WHITE);
          raisedbevel=BorderFactory.createLineBorder(color,5);
            ta1.setBorder(raisedbevel);
            
            }
  });
    }
    }

class Button3 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JComboBox b;
    Button3(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
        String fontStyle[]={"Times New Roman","Calibri","Arial"};        
        b=new JComboBox(fontStyle);
        create();
                  
}    

    @Override
    public void create() {
        
        pan3.add(b);
        b.setBounds(150,100,90,40);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Font tnr=new Font("Times New Roman", Font.PLAIN, ta1.getFont().getSize());
                Font c=new Font("Calibri", Font.PLAIN, ta1.getFont().getSize());
                Font a=new Font("Arial", Font.PLAIN, ta1.getFont().getSize());
                
                String selectedBook = (String) b.getSelectedItem();
 
        if (selectedBook.equals("Times New Roman")) {
            ta1.setFont(tnr);
        } else if (selectedBook.equals("Calibri")) {
            ta1.setFont(c);
        }
         else if (selectedBook.equals("Arial")) {
            ta1.setFont(a);        }       
            }
            
        });
    }
    
}
    
    






class Button4 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    Button4(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
         b=new JButton("Font Size Increase");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(250,100,90,40);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              Font font=ta1.getFont();                
                float size=font.getSize() + 2.0f;
                ta1.setFont(font.deriveFont(size));
                                
            }
            
        });
    }
    
}
class Button5 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    Button5(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
         b=new JButton("Font Size Drcrease");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(350,100,90,40);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Font font=ta1.getFont();                
                float size=font.getSize() - 2.0f;
                ta1.setFont(font.deriveFont(size));
                
            }
            
        });
    }
    
}

}

class Button6 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    
    Button6(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
        
         b=new JButton("Open image");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(350,100,90,40);
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //StyledDocument doc = (StyledDocument) ta1.getDocument();
                //Style style = doc.addStyle("StyleName", null);
               // StyleConstants.setIcon(style, new ImageIcon("back.png"));
                ta1.insertIcon ( new ImageIcon ( "E:\\Wally\\GOT\\bg.png" ) );
            }
        });
    }              
           
}


class Button7 implements Button1{
    JPanel pan2;
    JTextPane ta1;
    JButton b;
    
    Button7(JPanel pan2, JTextPane ta1){
        this.pan2=pan2;
        this.ta1=ta1;
         b=new JButton("BackgroundColor");
        create();
    }
    @Override
    public void create() {
        pan2.add(b);
        b.setBounds(450,100,90,40);
        b.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Color color = JColorChooser.showDialog(pan2, "Choose a color", Color.WHITE);
                 ta1.setBackground(color);
            }

        });
    }
}
class Button8 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    Button8(JPanel pan3, JTextPane ta1){
        this.pan3=pan3;
        this.ta1=ta1;
         b=new JButton("Font color");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(450,100,90,40);
        b.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Color color = JColorChooser.showDialog(pan3, "Choose a color", Color.BLACK);
                ta1.setForeground(color);
            }

        });
    }
    }

class Button9 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    JFrame frame;
    Button9(JPanel pan3, JTextPane ta1, JFrame frame){
        this.pan3=pan3;
        this.ta1=ta1;
        this.frame=frame;
         b=new JButton("Open");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(450,100,90,40);
        b.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

//                 XWPFWordExtractor extractor;
                 JFileChooser fileChooser = new JFileChooser();
                 int returnVal = fileChooser.showOpenDialog(frame);
                 if (returnVal == JFileChooser.APPROVE_OPTION) {
                 File file = fileChooser.getSelectedFile();
                 try {
                 FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                 BufferedReader input = new BufferedReader(new InputStreamReader(new
                FileInputStream(file)));
                 ta1.read(input, "READING FILE :-)");
                 fis.close();
                 } catch (Exception ex) {
                 System.out.println("problem accessing file" + file.getAbsolutePath());
                 }
                 } else {
                 System.out.println("File access cancelled by user.");
                 }
                 }
 });
    }
}



class Button10 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    JFrame frame;
    Button10(JPanel pan3, JTextPane ta1, JFrame frame){
        this.pan3=pan3;
        this.ta1=ta1;
        this.frame=frame;
         b=new JButton("New");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(450,100,90,40);
        b.addActionListener(new ActionListener() {                
        @Override
        public void actionPerformed(ActionEvent ae) {
        if (ta1.getText().isEmpty()) {
        ta1.setText("");
        } else {
        save();
        ta1.setText("");
        Example.flagSave = 0;
        Example.fileSave = null;
   }
 }
 });
 }
     public void save() {
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
        final JFileChooser saveAsFileChooser = new JFileChooser();
        saveAsFileChooser.setApproveButtonText("Save");
        saveAsFileChooser.setFileFilter(extensionFilter);
        int actionDialog = saveAsFileChooser.showOpenDialog(frame);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
        return;
        }
}
}

class Button11 implements Button1{
    JPanel pan3;
    JTextPane ta1;
    JButton b;
    JFrame frame;
    Button11(JPanel pan3, JTextPane ta1, JFrame frame){
        this.pan3=pan3;
        this.ta1=ta1;
        this.frame=frame;
         b=new JButton("Save");
        create();
    }
    @Override
    public void create() {
        pan3.add(b);
        b.setBounds(450,100,90,40);
        b.addActionListener(new ActionListener() {                
        
        @Override
        public void actionPerformed(ActionEvent ae) {
        if (Example.flagSave == 1) {
        BufferedWriter outFile = null;
        try {
        outFile = new BufferedWriter(new FileWriter(Example.fileSave));
        } catch (IOException ex) {
        Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        ta1.write(outFile);
        } catch (IOException ex) {
        Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        if (outFile != null) {
        try {
        outFile.close();
        } catch (IOException e) {
        }
        }
        }
        } else {
        save();
        }
        }
        }); 
    }
    
    public void save() {
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
        final JFileChooser saveAsFileChooser = new JFileChooser();
        saveAsFileChooser.setApproveButtonText("Save");
        saveAsFileChooser.setFileFilter(extensionFilter);
        int actionDialog = saveAsFileChooser.showOpenDialog(frame);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
        return;
        }
    }
}


class Example {
    public static int flagSave;
    public static File fileSave;
}

public class DocumentEditor{
  public static void main(String[] args) {
  
      DP1 panel=new DP1();
       JFrame frame=panel.getframe();
       panel.addcomposite(1);
     
       
JPanel p2=panel.addcomposite(2);
       JTextPane ta1=panel.getTextPane();
        DP2 tpane=new DP2(frame);
       JPanel pan=tpane.addcomposite(2);
       
       tpane.addleaf(frame, ta1);  
       
   
       }
}
 
      
    
    




