package pe.edu.vallegrande.proyecto.model;

public class Client {

		private Integer id;
		private String type_document;
		private String number_document;
		private String names;
		private String last_name;
		private String birthdate;
		private String cell_phone;
		private String email;
		private String state;
	
		public Client() {
				super();
		}
	
		public Client(Integer id, String type_document, String number_document, String names, String last_name, String birthdate, 
				String cell_phone, String email, String state) {
			super();
			this.setId(id);
			this.setType_document(type_document);
			this.setNumber_document(number_document);
			this.setNames(names);
			this.setLast_name(last_name);
			this.setBirthdate(birthdate);
			this.setCell_phone(cell_phone);
			this.setEmail(email);
			this.setState(state);
		}

		public Client(String type_document, String number_document, String names, String last_name, String birthdate, 
				String cell_phone, String email) {
			super();
			this.setType_document(type_document);
			this.setNumber_document(number_document);
			this.setNames(names);
			this.setLast_name(last_name);
			this.setBirthdate(birthdate);
			this.setCell_phone(cell_phone);
			this.setEmail(email);
		}
		
		/**   @return the id  */
		public Integer getId() {
			return id;
		}

		/**   @param id the id to set  */
		public void setId(Integer id) {
			this.id = id;
		}

		
		/**   @return the type_document  */
		public String getType_document() {
			return type_document;
		}

		/**  @param type_document the type_document to set  */
		public void setType_document(String type_document) {
			this.type_document = type_document;
		}

		
		/**   @return the number_document  */
		public String getNumber_document() {
			return number_document;
		}

		/**  @param number_document the number_document to set  */
		public void setNumber_document(String number_document) {
			this.number_document = number_document;
		}

		
		/**  @return the names  */
		public String getNames() {
			return names;
		}

		/**   @param names the names to set  */
		public void setNames(String names) {
			this.names = names;
		}
		
		
		/**  @return the last_name  */
		public String getLast_name() {
			return last_name;
		}
		
		/**  @param last_name the last_name to set  */
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		
		
		/**   @return the birthdate  */
		public String getBirthdate() {
			return birthdate;
		}

		/**  @param birthdate the birthdate to set  */
		public void setBirthdate(String birthdate) {
			this.birthdate = birthdate;
		}

		
		/**  @return the cell_phone  */
		public String getCell_phone() {
			return cell_phone;
		}

		/**  @param cell_phone the cell_phone to set  */
		public void setCell_phone(String cell_phone) {
			this.cell_phone = cell_phone;
		}

		
		/**   @return the email  */
		public String getEmail() {
			return email;
		}

		/**   @param email the email to set  */
		public void setEmail(String email) {
			this.email = email;
		}

		
		/**  @return the state  */
		public String getState() {
			return state;
		}

		/**  @param state the state to set  */
		public void setState(String state) {
			this.state = state;
		}
		
		
		@Override
	    public String toString() {
			String data = "[id: " + this.id;
			data += ", type_document: " + this.type_document;
			data += ", number_document: " + this.number_document;
			data += ", names: " + this.names;
			data += ", last_name: " + this.last_name;
			data += ", birthdate: " + this.birthdate;
			data += ", cell_phone: " + this.cell_phone;
			data += ", email: " + this.email;
			data += ", state: " + this.state + "]";
	        return data;
	        
	    }
}
