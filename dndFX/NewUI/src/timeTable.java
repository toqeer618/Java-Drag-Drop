import javafx.beans.property.SimpleStringProperty;

public class timeTable {
	
	private final SimpleStringProperty slot1;
	private final SimpleStringProperty slot2;
	private final SimpleStringProperty slot3;
	private final SimpleStringProperty slot4;
	private final SimpleStringProperty slot5;
	public String getSlot1() {
		return slot1.get();
	}
	public String getSlot2() {
		return slot2.get();
	}
	public String getSlot3() {
		return slot3.get();
	}
	public String getSlot4() {
		return slot4.get();
	}
	public String getSlot5() {
		return slot5.get();
	}
	
	public timeTable(String slot1, String slot2, String slot3, String slot4, String slot5) {
		super();
		this.slot1 =new SimpleStringProperty(slot1) ;
		this.slot2 = new SimpleStringProperty(slot2);
		this.slot3 = new SimpleStringProperty(slot3);
		this.slot4 = new SimpleStringProperty(slot4);
		this.slot5 = new SimpleStringProperty(slot5);
	}
	

}
