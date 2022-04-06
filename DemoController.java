package javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DemoController {
    public Text result;
    public Text errMsg;
    public TextField fullName;
    public TextField number;
    public Number product;
    public void setData(Number product){
        this.product = product;
        fullName.setText(product.getFullname());
        number.setText(product.getNumber());
    }
    public void submit(){
        try{
            Number p = new Number(fullName.getText(),
                    number.getText());
            if(this.product==null){
                Main.numberList.add(p);
            }else{
                int i = Main.numberList.indexOf(this.product);
                Main.numberList.set(i,p);
            }
            Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
            Main.rootStage.setScene(new Scene(root,800,600));
            errMsg.setVisible(false);
        }catch (Exception e){
            errMsg.setText(e.getMessage());
            errMsg.setVisible(true);
        }
    }
    private void renderList(){
        String txt = "Infomation\n";
        for (Number p: Main.numberList){
            txt+= p.toString();
        }
        result.setText(txt);
        fullName.setText("");
        number.setText("");
    }
}