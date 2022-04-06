package javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public final class Number {
    public String fullname;
    public String number;

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button delete;

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button edit;


    public Number() {
    }

    public Number(String fullname, String number) {
        this.fullname = fullname;
        this.number = number;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event->{
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));
                Parent root = loader.load();
                DemoController d = loader.getController();
                d.setData(this);
                Main.rootStage.setScene(new Scene(root,800,600));
            }catch(Exception e){

            }
        });
        this.delete = new Button("Delete");
        this.delete.setOnAction(event->{
            Main.numberList.remove(this);
        });
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public String toString(){
        String s = "\n-------------";
        s+= "\n"+getFullname();
        s+= "\n"+getNumber();
        return s;
    }
}