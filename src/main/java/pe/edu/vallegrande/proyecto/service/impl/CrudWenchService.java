package pe.edu.vallegrande.proyecto.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.proyecto.db.AccesoDB;
import pe.edu.vallegrande.proyecto.model.Wench; // Change to Wench
import pe.edu.vallegrande.proyecto.service.spec.CrudServiceSpecClient; // Change to CrudServiceSpecWench
import pe.edu.vallegrande.proyecto.service.spec.RowMapper;

public class CrudWenchService implements CrudServiceSpecClient<Wench>, RowMapper<Wench> { // Change to CrudWenchService

    private final String SQL_SELECT_BASE = "SELECT * FROM wench"; // Change to wench
    private final String SQL_INSERT = "INSERT INTO wench (type_document, number_document, names, last_name, birthdate, cell_phone, email, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Change to wench
    private final String SQL_UPDATE = "UPDATE wench SET type_document = ?, number_document = ?, names = ?, last_name = ?, birthdate = ?, cell_phone = ?, email = ?, state = ? WHERE id = ?"; // Change to wench
    private final String SQL_RESTAURE = "UPDATE wench SET state = 'A' WHERE id = ?"; // Change to wench
    private final String SQL_ELIMINATE = "UPDATE wench SET state = 'I' WHERE id = ?"; // Change to wench
    private final String SQL_DELETE = "DELETE FROM wench WHERE id = ?"; // Change to wench

    public List<Wench> getAll() {
        Connection cn = null;
        List<Wench> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Wench bean;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = SQL_SELECT_BASE + " WHERE state='A'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                bean = mapRow(rs);
                lista.add(bean);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    public List<Wench> getInactivos() {
        Connection cn = null;
        List<Wench> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Wench bean;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = SQL_SELECT_BASE + " WHERE state='I' ORDER BY names, last_name";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                bean = mapRow(rs);
                lista.add(bean);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                // Handle the exception or log it
            }
        }
        return lista;
    }

    public Wench getForId(String id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Wench bean = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = SQL_SELECT_BASE + " WHERE id=?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = mapRow(rs);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return bean;
    }

    public void insert(Wench bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_INSERT);
            pstm.setString(1, bean.getTypeDocument());
            pstm.setString(2, bean.getNumberDocument());
            pstm.setString(3, bean.getNames());
            pstm.setString(4, bean.getLastName());
            pstm.setString(5, bean.getBirthdate());
            pstm.setString(6, bean.getCellPhone());
            pstm.setString(7, bean.getEmail());
            pstm.setString(8, bean.getState());
            filas = pstm.executeUpdate();
            pstm.close();

            if (filas != 1) {
                throw new SQLException("Error, verify your data and try again.");
            }
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
                cn.close();
            } catch (Exception e2) {
            }
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public void update(Wench bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, bean.getTypeDocument());
            pstm.setString(2, bean.getNumberDocument());
            pstm.setString(3, bean.getNames());
            pstm.setString(4, bean.getLastName());
            pstm.setString(5, bean.getBirthdate());
            pstm.setString(6, bean.getCellPhone());
            pstm.setString(7, bean.getEmail());
            pstm.setString(8, bean.getState());
            pstm.setInt(9, bean.getId());
            filas = pstm.executeUpdate();
            pstm.close();

            if (filas != 1) {
                throw new SQLException("Error in CrudWenchService, verify your data and try again.");
            }
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
                cn.close();
            } catch (Exception e2) {
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public void delete(String id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas = 0;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_DELETE);
            pstm.setInt(1, Integer.parseInt(id));
            filas = pstm.executeUpdate();
            pstm.close();

            if (filas != 1) {
                throw new SQLException("Failed to delete the record. Please try again.");
            }
            cn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    public void EliminadoLogico(String id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas = 0;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_ELIMINATE);
            pstm.setInt(1, Integer.parseInt(id));
            filas = pstm.executeUpdate();
            pstm.close();

            if (filas != 1) {
                throw new SQLException("Record has been logically deleted.");
            }
            cn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    public void Restaurar(String id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas = 0;

        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_RESTAURE);
            pstm.setInt(1, Integer.parseInt(id));
            filas = pstm.executeUpdate();
            pstm.close();

            if (filas != 1) {
                throw new SQLException("Record has been restored.");
            }
            cn.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    @Override
    public List<Wench> get(Wench bean) {
        Connection cn = null;
        List<Wench> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Wench item;
        String sql;
        String typeDocument;
        String names;
        String lastName;

        typeDocument = "%" + UtilService.setStringVacio(bean.getTypeDocument()) + "%";
        names = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
        lastName = "%" + UtilService.setStringVacio(bean.getLastName()) + "%";

        try {
            cn = AccesoDB.getConnection();
            sql = SQL_SELECT_BASE + " WHERE type_document LIKE ? AND names LIKE ? AND last_name LIKE ?  AND state ='A' ORDER BY names, last_name";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, typeDocument);
            pstm.setString(2, names);
            pstm.setString(3, lastName);

            rs = pstm.executeQuery();
            while (rs.next()) {
                item = mapRow(rs);
                lista.add(item);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    @Override
    public Wench mapRow(ResultSet rs) throws SQLException {
        Wench bean = new Wench();
        bean.setId(rs.getInt("id"));
        bean.setTypeDocument(rs.getString("type_document"));
        bean.setNumberDocument(rs.getString("number_document"));
        bean.setNames(rs.getString("names"));
        bean.setLastName(rs.getString("last_name"));
        bean.setBirthdate("birthdate");
        bean.setCellPhone(rs.getString("cell_phone"));
        bean.setEmail(rs.getString("email"));
        bean.setState(rs.getString("state"));
        return bean;
    }

    @Override
    public Wench getById(String id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }
}
