package javafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListController implements Initializable {
    public TableView<Number> tbView;
    public TableColumn<Number,String> cName;
    public TableColumn<Number,String> cNumber;
    public TableColumn<Number, Button> cEdit;
    public TableColumn<Number, Button> cDelete;

    public TextField txtSearch;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<Number,String>("fullname"));
        cNumber.setCellValueFactory(new PropertyValueFactory<Number,String>("Number"));
        cEdit.setCellValueFactory(new PropertyValueFactory<Number,Button>("edit"));
        cDelete.setCellValueFactory(new PropertyValueFactory<Number,Button>("Delete"));
        tbView.setItems(Main.numberList);

    }
    public void formScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
       Main.rootStage.setScene(new Scene(root,800,600));
    }

    public void search(){
        String s = txtSearch.getText();
        List<Number> kq = Main.numberList.stream()
                .filter(p->p.getFullname().startsWith(s) || p.getNumber().startsWith(s))
                .collect(Collectors.toList());
        ObservableList result = FXCollections.observableArrayList();
        result.addAll(kq);
        tbView.setItems(result);
    }
}
