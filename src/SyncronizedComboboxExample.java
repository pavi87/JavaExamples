import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class SyncronizedComboboxExample extends JPanel
{
  String[] provinces= {"A","B","C"};
  String[] districtsForA = {"l","m","n"};
  String[] districtsForB = {"x","y","z"};
  String[] districtsForC = {"p","q","r"};

  public SyncronizedComboboxExample() {

    JComboBox provincesComboBox = new JComboBox(provinces);

    final DefaultComboBoxModel model = new DefaultComboBoxModel();
    for(String i:districtsForA){
      model.addElement(i);
    }
    JComboBox districtsComboBox = new JComboBox(model);

    provincesComboBox.addItemListener(e -> {
      if(e.getStateChange() == ItemEvent.SELECTED){
          districtsComboBox.removeAllItems();

          if(provincesComboBox.getSelectedItem().equals("A")){
            for(String i:districtsForA){
              model.addElement(i);
            }
          }
          if(provincesComboBox.getSelectedItem().equals("B")){
            for(String i:districtsForB){
              model.addElement(i);
            }
          }
          if(provincesComboBox.getSelectedItem().equals("C")){
            for(String i:districtsForC){
              model.addElement(i);
            }
          }

      }
    });

    add(provincesComboBox, BorderLayout.PAGE_START);
    add(districtsComboBox, BorderLayout.AFTER_LAST_LINE);
    setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  }

  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("CustomComboBoxDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new SyncronizedComboboxExample();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
  }

}
