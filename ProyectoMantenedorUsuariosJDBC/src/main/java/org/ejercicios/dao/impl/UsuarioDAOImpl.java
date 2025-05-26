package org.ejercicios.dao.impl;

import org.ejercicios.conexion.Conexion;
import org.ejercicios.dao.UsuarioDAO;
import org.ejercicios.modelo.Usuario;


import java.sql.*;
import  java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void save(Usuario usuario) {
        Connection  conexion=Conexion.obtenerConexion();
        String consulta="INSERT INTO usuarios (nombreusuario, password, email) VALUES (?,?,?)";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {

            statement.setString(1, usuario.getNombreusuario());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getEmail());

            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar el usuario", e);
        } finally {
            Conexion.cerrarConexion( conexion);

        }
        System.out.println("Se inserto el usuario correctamente\n\t");
        System.out.println( usuario.toString());
    }

    @Override
    public void update(Usuario usuario) {
        //
        if ((usuario.getNombreusuario() == null || usuario.getNombreusuario().isEmpty()) &&
                (usuario.getPassword() == null || usuario.getPassword().isEmpty())) {
            throw new IllegalArgumentException("No se proporcionaron datos para actualizar.");
        }

        StringBuilder sql = new StringBuilder("UPDATE usuarios SET ");
        List<Object> params = new ArrayList<>();

        //boolean comma = false;

        if (usuario.getNombreusuario() != null && !usuario.getNombreusuario().isEmpty()) {
            sql.append("nombreusuario = ?");
            params.add(usuario.getNombreusuario());
        }

        if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
            if (!params.isEmpty()) sql.append(", ");
            sql.append("password = ?");
            params.add(usuario.getPassword());
        }
        sql.append(" WHERE email = ?");
        params.add(usuario.getEmail());

        Connection  conexion=Conexion.obtenerConexion();

        try (PreparedStatement stmt = conexion.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }

            int filas = stmt.executeUpdate();
            if (filas == 0) {
                System.out.println("No se encontró ningún usuario con el email: " + usuario.getEmail());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el usuario", e);
        } finally {
            Conexion.cerrarConexion( conexion);
        }
    }

    @Override
    public void delete(String email) {
        Connection  conexion=Conexion.obtenerConexion();
        String consulta="DELETE FROM usuarios WHERE email = ?";

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {

            statement.setString(1, email);

            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario", e);
        }finally {
            Conexion.cerrarConexion( conexion);
        }
    }

    @Override
    public List<Usuario> listar() {
        Connection  conexion=Conexion.obtenerConexion();
        List<Usuario> usuarios=new ArrayList<>();
        String consulta="SELECT * FROM usuarios";

        try (Statement statement = conexion.createStatement()) {
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
        } finally {
            Conexion.cerrarConexion( conexion);
        }
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
        Connection  conexion=Conexion.obtenerConexion();
        String consulta="Select count(*) from usuarios where email = ?";
        boolean existe = false;

        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                existe=resultSet.getInt(1)>0;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error usuario no encontrado", e);
        }finally {
            Conexion.cerrarConexion( conexion);
        }
        return existe;
    }



}
