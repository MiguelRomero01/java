package RoadTo_SpringBot.advancedConcepts;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP_REST {

    public static void main(String[] args) {
        try {
            // URL de la API pública (API de GitHub en este caso)
            URL url = new URL("https://api.github.com/users/octocat");
            
            // Crear la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Establecer el método de la petición como GET
            connection.setRequestMethod("GET");
            
            // Configurar encabezados (opcional)
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            // Obtener el código de respuesta
            int responseCode = connection.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);
            
            // Leer la respuesta solo si la conexión es exitosa (código 200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Leer línea por línea la respuesta
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Imprimir la respuesta de la API (generalmente en formato JSON)
                System.out.println("Respuesta de la API:");
                System.out.println(response.toString());
            } else {
                System.out.println("Error en la conexión a la API.");
            }
            
            // Cerrar la conexión
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

