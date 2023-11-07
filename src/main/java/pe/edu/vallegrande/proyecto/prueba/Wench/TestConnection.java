package pe.edu.vallegrande.proyecto.prueba.Wench;

import java.sql.Connection;

import pe.edu.vallegrande.proyecto.db.AccesoDB;

public class TestConnection {
	
	public static void main(String[] args) {
		try {
			Connection cn =  AccesoDB.getConnection();
			System.out.println("Conexión Ok");
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
