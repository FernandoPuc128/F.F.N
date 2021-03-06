
import java.awt.Color;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Cliente extends Thread {
    /**
     * Socket 
     */
    private Socket socket;
    /**
     * Envio de objetos al servidor.
     */    
    private ObjectOutputStream objectOutputStream;
    /**
     * Envio de objetos al servidor.
     */    
    private ObjectInputStream objectInputStream;
    /**
     * Ventana 
     */        
    private final VentanaC ventana;    
    /**
     * Identificador del cliente en el chat
     */
    private String identificador;
    /**
     * Variable que determina si el cliente escucha o no al servidor
     */
    private boolean escuchando;
    /**
     * Variable que almacena la IP del host en el que se ejecuta el servidor.
     */
    private final String host;
    /**
     * Varable que almacena el puerto por el cual el servidor escucha las conexiones
     * de los  clientes.
     */
    private final int puerto;
    /**
     * Constructor de la clase cliente.
     * @param ventana
     * @param host
     * @param puerto
     * @param nombre 
     */
    Cliente(VentanaC ventana, String host, Integer puerto, String nombre) {
        this.ventana=ventana;        
        this.host=host;
        this.puerto=puerto;
        this.identificador=nombre;
        escuchando=true;
        this.start();
    }
    /**
     * Metodo run del hilo de comunicacion del lado del cliente.
     */
    public void run(){
        try {
            socket=new Socket(host, puerto);
            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectInputStream=new ObjectInputStream(socket.getInputStream());
            System.out.println("Conexion realizada exitosamente!");
            this.enviarSolicitudConexion(identificador);
            this.escuchar();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(ventana, "Conexion interrumpida, servidor desconocido,\n"
                                                 + "puede que haya ingresado una ip incorrecta\n"
                                                 + "o que el servidor no este corriendo.\n"
                                                 + "Esta aplicacion se va a cerrar.");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(ventana, "Conexion interrumpida, error de Entrada/Salida,\n"
                                                 + "puede que haya ingresado una ip o un puerto\n"
                                                 + "incorrecto, o que el servidor no este corriendo.\n"
                                                 + "Esta aplicacion se va a cerrar.");
            System.exit(0);
        }

    }
    
    /**
     * Metodo que cierra el socket y los streams de comunicacion.
     */
    public void desconectar(){
        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();  
            escuchando=false;
        } catch (Exception e) {
            System.err.println("Error al cerrar los elementos de comunicacion del cliente.");
        }
    }
    /**
     * Metodo que envia un determinado mensaje hacia el servidor.
     * @param cliente_receptor
     * @param mensaje 
     */
    public void enviarMensaje(String cliente_receptor, String mensaje){
        LinkedList<String> lista=new LinkedList<>();
        //tipo
        lista.add("MENSAJE");
        //cliente emisor
        lista.add(identificador);
        //cliente receptor
        lista.add(cliente_receptor);
        //mensaje que se desea transmitir
        lista.add(mensaje);
        try {
            objectOutputStream.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura al enviar mensaje al servidor.");
        }
    }
    
    /*
     * Metodo que escucha constantemente lo que el servidor dice.
     */    
    public void escuchar() {
        try {
            while (escuchando) {
                Object aux = objectInputStream.readObject();
                if (aux != null) {
                    if (aux instanceof LinkedList) {
                        //Si se recibe una LinkedList entonces se procesa
                        ejecutar((LinkedList<String>)aux);
                    } else {
                        System.err.println("Se ha recibido un Objeto desconocido a traves del socket");
                    }
                } else {
                    System.err.println("Se recibio un null a traves del socket");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, "La comunicacion con el servidor se ha\n"
                                                 + "perdido, este chat tendra que finalizar.\n"
                                                 + "Esta aplicacion se cerrara a continuacion.");
            System.exit(0);
        }
    }
    /**
     * Metodo que ejecuta una serie de instruccines dependiendo del mensaje que el cliente reciba del servidor.
     * @param lista
     */
    public void ejecutar(LinkedList<String> lista){
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
                ventana.addMensaje(lista.get(1), lista.get(3));
                break;
            default:
                break;
        }
    }
    /**
     * Al conectarse el cliente debe solicitar al servidor que lo agregue a la 
     * lista de clientes, para ello se ejecuta este m???todo.
     * @param identificador 
     */
    private void enviarSolicitudConexion(String identificador) {
        LinkedList<String> lista=new LinkedList<>();
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
    /**
     * Cuando se cierra una ventana cliente, se debe notificar al servidor que el 
     * cliente se ha desconectado para que lo elimine de la lista de clientes y 
     * todos los clientes lo eliminen de su lista de contactos.
     */
    void confirmarDesconexion() {
        LinkedList<String> lista=new LinkedList<>();
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
     * Metodo que retorna el identificador del cliente que es ???nico dentro del chat.
     * @return 
     */
    String getIdentificador() {
        return identificador;
    }
}
