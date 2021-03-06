import java.io.*;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
//import java.util.LinkedList;
import javax.swing.JOptionPane;

//Clase en la que se maneja la comunicación del lado del cliente.
public class Cliente extends Thread {
    
    // Socket utilizado para comunicarse con el servidor.
    private Socket socket;
    
    // Stream utilizado para el envío de objetos al servidor.    
    private ObjectOutputStream objectOutputStream;
    
    //Stream utilizado para el envío de objetos al servidor.
    private ObjectInputStream objectInputStream;
    
    // Ventana utilizada para la interfaz gráfica del cliente.        
    private final VentanaC ventana;    
    
    // Identificador único del cliente dentro del chat.
    private String identificador;
    
    
    /* Variable que determina si el cliente escucha o no al servidor, una vez 
     * que se arranca el hilo de comunicación del cliente.*/
    private boolean escuchando;
    
    // Variable que almacena la IP del host en el que se ejecuta el servidor.
    private final String host;
    
    //Variable que almacena el puerto por el cual el servidor escucha las conexiones.
    private final int puerto;
    
    Cliente(VentanaC ventana, String host, Integer puerto, String nombre) {
        this.ventana=ventana;        
        this.host=host;
        this.puerto=puerto;
        this.identificador=nombre;
        escuchando=true;
        this.start();
    }
    
    // Método run del hilo de comunicación del lado del cliente.
    public void run(){
        try {
            socket=new Socket(host, puerto);
            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectInputStream=new ObjectInputStream(socket.getInputStream());
            System.out.println("La conexion se ha completado exitosamente");
            this.enviarSolicitudConexion(identificador);
            this.escuchar();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(ventana, "La conexión ha sido interrumpida, servidor desconocido,\n"
                                                 + "puede que haya ingresado la IP incorrectamente\n"
                                                 + "o que el servidor no esta activado por lo que.\n"
                                                 + "esta aplicación se cerrará a continuacion.");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ventana, "Conexión rehusada, error de Entrada/Salida,\n"
                                                 + "puede que haya ingresado la ip o un puerto\n"
                                                 + "incorrectamente, o que el servidor no esta activado.\n"
                                                 + "por lo que esta aplicación se cerrará a continuacion.");
            System.exit(0);
        }

    }
    
    // Método que cierra el socket y los streams de comunicación.
    public void desconectar(){
        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();  
            escuchando=false;
        } catch (Exception e) {
            System.err.println("Se ha detectado un error al cerrar los elementos de comunicación del cliente.");
        }
    }
    
    //Método que envia un determinado mensaje hacia el servidor.
    public void enviarMensaje(String mensaje){
        ArrayList<String> lista=new ArrayList<>();
        //tipo
        lista.add("MENSAJE");
        //cliente emisor
        lista.add(identificador);
        //mensaje que se desea transmitir
        lista.add(mensaje);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }

    public void enviarFactorial(String mensaje){
        ArrayList<String> lista=new ArrayList<>();
        lista.add("FACTORIAL");
        lista.add(identificador);
        lista.add(mensaje);
        try{
            objectOutputStream.writeObject(lista);
        }catch(IOException ex){
            System.out.println("Error de lectura y escritura del mensaje al servidor");
        }
    }
    
    /*
     * Método que escucha constantemente lo que el servidor dice.
     */    
    public void escuchar() {
        try {
            while (escuchando) {
                Object aux = objectInputStream.readObject();
                if (aux != null) {
                    if (aux instanceof ArrayList) {
                        //Si se recibe una LinkedList entonces se procesa
                        ejecutar((ArrayList<String>)aux);
                    } else {
                        System.err.println("Se recibió un Objeto desconocido a través del socket");
                    }
                } else {
                    System.err.println("Se recibió un null a través del socket");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, "La comunicación con el servidor se ha\n"
                                                 + "perdido, este chat tendrá que finalizar.\n"
                                                 + "La aplicación estará a punto de cerrarse a continuacion.");
            System.exit(0);
        }
    }
    
    /*
     * Método que ejecuta una serie de instruccines dependiendo del mensaje que el cliente reciba del servidor.
     * @param lista
     */
    public void ejecutar(ArrayList<String> lista){
        // 0 - El primer elemento de la lista es siempre el tipo
        String tipo=lista.get(0);
        switch (tipo) {
            case "CONEXION_ACEPTADA":
                // 1      - Identificador propio del nuevo usuario
                // 2 .. n - Identificadores de los clientes conectados actualmente
                identificador=lista.get(1);
                ventana.sesionIniciada(identificador);
                for(int i=2;i<lista.size();i++){
                    ventana.addContacto(lista.get(i));
      
                }
                break;
                
            case "NUEVO_USUARIO_CONECTADO":
                // 1      - Identificador propio del cliente que se acaba de conectar
                ventana.addContacto(lista.get(1));
                break;
                
            case "USUARIO_DESCONECTADO":
                // 1      - Identificador propio del cliente que se acaba de conectar
                ventana.eliminarContacto(lista.get(1));
                break;   
                
            case "MENSAJE":
                // 1      - Cliente emisor
                // 2      - Cliente receptor
                // 3      - Mensaje
                ventana.addMensaje(lista.get(1), lista.get(2));
                break;

            case "OPERACION":
                multiplicar(lista);
                break;

            case "RESULTADO":
            ventana.addMensaje("el factorial es: ", ""+ lista.get(1));

            default:
                break;
        }
    }
    
    private void multiplicar(ArrayList<String>numeros){
        BigInteger multiplicacion=BigInteger.ONE;
        for(int i=1;i<numeros.size();i++){
            multiplicacion = multiplicacion.multiply(new BigInteger(numeros.get(i)));
        }
        ventana.addMensaje("Mi operacion", multiplicacion.toString());
        regresarOperacion(multiplicacion);
    }

    private void regresarOperacion(BigInteger m){
        ArrayList<String>lista = new ArrayList<>();
        lista.add("Operacion devuelta");
        lista.add(String.valueOf(m));

        try{
            objectOutputStream.writeObject(lista);
        }catch(IOException ex){
            System.out.println("Error de lectura y escritura");
        }
    }


    private void enviarSolicitudConexion(String identificador) {
        ArrayList<String> lista=new ArrayList<>();
        //tipo
        lista.add("SOLICITUD_CONEXION");
        //cliente solicitante
        lista.add(identificador);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }
    
    /*
     * Cuando se cierra una ventana cliente, se debe notificar al servidor que el 
     * cliente se ha desconectado para que lo elimine de la lista de clientes y 
     * todos los clientes lo eliminen de su lista de contactos.
     */
    void confirmarDesconexion() {
        ArrayList<String> lista=new ArrayList<>();
        //tipo
        lista.add("SOLICITUD_DESCONEXION");
        //cliente solicitante
        lista.add(identificador);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }
    /**
     * Método que retorna el identificador del cliente que es único dentro del chat.
     * @return 
     */
    String getIdentificador() {
        return identificador;
    }
}