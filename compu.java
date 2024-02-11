import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String usuario = "tu_usuario";
        String contrasena = "tu_contrasena";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena)) {
            // Deshabilitar el modo de autocommit para habilitar transacciones
            conexion.setAutoCommit(false);

            try {
                // Realizar operaciones de la transacción

                // Insertar un nuevo producto en la tabla de inventario
                insertarProducto(conexion, 14, "Laptop", "Samsung", 10, 800000);

                // Confirmar la transacción
                conexion.commit();
            } catch (SQLException e) {
                // En caso de error, realizar un rollback para deshacer la transacción
                conexion.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertarProducto(Connection conexion, String nombre, double precio, int cantidad)
            throws SQLException {
        String sql = "INSERT INTO Inventario (nombre, precio, cantidad) VALUES (?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setDouble(2, precio);
            statement.setInt(3, cantidad);
            statement.executeUpdate();
        }
    }

    private static void actualizarCantidadProducto(Connection conexion, String nombre, int nuevaCantidad)
            throws SQLException {
        String sql = "UPDATE Inventario SET cantidad = ? WHERE nombre = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, nuevaCantidad);
            statement.setString(2, nombre);
            statement.executeUpdate();
        }
    }
}