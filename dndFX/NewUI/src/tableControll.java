import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class tableControll {
	@FXML
	private TextField userNameTxt;
	
	public void login(ActionEvent e)
	{
		if(userNameTxt.getText().equals("hello"))
		{
			System.out.println("Okkkkk");
		}
	}

}
