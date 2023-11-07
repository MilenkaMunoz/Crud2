package pe.edu.vallegrande.proyecto.model;

public class Wench {

    private Integer id;
    private String typeDocument; // Change to camelCase
    private String numberDocument; // Change to camelCase
    private String names;
    private String lastName; // Change to camelCase
    private String birthdate; // Change to camelCase
    private String cellPhone; // Change to camelCase
    private String email;
    private String state;

    public Wench() {
        super();
    }

    public Wench(Integer id, String typeDocument, String numberDocument, String names, String lastName, String birthdate,
            String cellPhone, String email, String state) {
        super();
        this.id = id; // Use this.id instead of this.setId(id)
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
        this.names = names;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.cellPhone = cellPhone;
        this.email = email;
        this.state = state;
    }

    public Wench(String typeDocument, String numberDocument, String names, String lastName, String birthdate,
            String cellPhone, String email) {
        super();
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
        this.names = names;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.cellPhone = cellPhone;
        this.email = email;
    }

    // Getters and setters with camelCase field names

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String data = "[id: " + id;
        data += ", typeDocument: " + typeDocument;
        data += ", numberDocument: " + numberDocument;
        data += ", names: " + names;
        data += ", lastName: " + lastName;
        data += ", birthdate: " + birthdate;
        data += ", cellPhone: " + cellPhone;
        data += ", email: " + email;
        data += ", state: " + state + "]";
        return data;
    }
}
