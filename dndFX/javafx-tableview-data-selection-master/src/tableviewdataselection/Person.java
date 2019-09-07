/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewdataselection;

import javafx.beans.property.*;

/**
 *
 * @author Narayan G. Maharjan <me@ngopal.com.np>
 */
public class Person {
    private final StringProperty sn = new SimpleStringProperty();

    private final StringProperty address = new SimpleStringProperty();

    private final StringProperty name = new SimpleStringProperty();

    private final StringProperty phone = new SimpleStringProperty();

    //private final ObjectProperty<Gender> gender = new SimpleObjectProperty<Gender>(Gender.OTHER);

    public String getSn() {
        return sn.get();
    }

    public void setSn(String value) {
        sn.set(value);
    }

    public StringProperty snProperty() {
        return sn;
    }

//    public Gender getGender() {
//        return gender.get();
//    }

//    public void setGender(Gender value) {
//        gender.set(value);
//    }

//    public ObjectProperty genderProperty() {
//        return gender;
//    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String value) {
        phone.set(value);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }
}
