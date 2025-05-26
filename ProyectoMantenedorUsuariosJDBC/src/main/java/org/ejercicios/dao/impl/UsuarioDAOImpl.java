package org.ejercicios.dao.impl;

import org.ejercicios.conexion.Conexion;
import org.ejercicios.dao.UsuarioDAO;
import org.ejercicios.modelo.Usuario;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void save(Usuario usuario) {
        Conexion conexion=new Conexion();
        String consulta="INSERT INTO usuarios (nombreusuario, password, email) VALUES (?,?,?)";

        try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(consulta)) {

            statement.setString(1, usuario.getNombreusuario());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getEmail());

            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar el usuario", e);
        }
        conexion.cerrarConexion( conexion.obtenerConexion());
        System.out.println("Se inserto el usuario correctamente\n\t");
        System.out.println( usuario.toString());
    }

    @Override
    public void update(Usuario usuario) {
        Conexion conexion=new Conexion();

        StringBuilder consulta = new StringBuilder("UPDATE usuarios SET ");
        boolean comma = false;

        if (usuario.getNombreusuario() != null && !usuario.getNombreusuario().isEmpty()) {
            consulta.append("nombreusuario = ?");
            comma = true;
        }
        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            if (comma) consulta.append(", ");
            consulta.append("password = ?");
            comma = true;
        }

        consulta.append(" WHERE email = ?");

        try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(consulta.toString())) {
            int index = 1;
            if (usuario.getNombreusuario() != null && !usuario.getNombreusuario().isEmpty()) {
                statement.setString(index++, usuario.getNombreusuario());
            }
            if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
                statement.setString(index++, usuario.getPassword());
            }
            statement.setString(index, usuario.getEmail());

            int filas = statement.executeUpdate();
            if (filas == 0) {
                throw new RuntimeException("No se encontró usuario con email: " + usuario.getEmail());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario", e);
        } finally {
            conexion.cerrarConexion(conexion.obtenerConexion());
        }
    }

    @Override
    public void delete(String email) {
        Conexion conexion=new Conexion();
        String consulta="DELETE FROM usuarios WHERE email = ?";

        try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(consulta)) {

            statement.setString(1, email);

            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario", e);
        }
    }

    @Override
    public List<Usuario> listar() {
        Conexion conexion=new Conexion();
        List<Usuario> usuarios=new ArrayList<>();
        String consulta="SELECT * FROM usuarios";

        try (Statement statement = conexion.obtenerConexion().createStatement()) {
            ResultSet resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {  
                usuarios.add(new Usuario(
                    resultSet.getInt("id"),
                    resultSet.getString("nombreusuario"),
                    resultSet.getString("password"),
                    resultSet.getString("email")
                    ));
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los usuarios", e);
        }
        conexion.cerrarConexion( conexion.obtenerConexion());
        System.out.println("Se obtuvieron "+usuarios.size()+" usuarios\n\t");
        System.out.println( usuarios.toString());
        return usuarios;
    }

    @Override
    public Usuario findById(int id) {
        return null;
    }

    @Override
    public Usuario findByEmail(String email) {
        return null;
    }

    @Override
    public boolean existe(String email) {
        Conexion conexion=new Conexion();
        String consulta="Select count(*) from usuarios where email = ?";
        boolean existe = false;

        try (PreparedStatement statement = conexion.obtenerConexion().prepareStatement(consulta)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                existe=resultSet.getInt(1)>0;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error usuario no encontrado", e);
        }finally {
            conexion.cerrarConexion( conexion.obtenerConexion());
        }
        return existe;
    }



}
