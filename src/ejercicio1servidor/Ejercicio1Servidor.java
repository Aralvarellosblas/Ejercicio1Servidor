package ejercicio1servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author Arturo
 */
public class Ejercicio1Servidor{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try{
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket=new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket=serverSocket.accept();

            System.out.println("Conexion recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();
            for(int i=0; i<3; i++){

                byte[] mensaje=new byte[25];
                is.read(mensaje);

                System.out.println("Mensaje "+i+" recibido: "+new String(mensaje));

                System.out.println("Enviando mensaje "+i);
                String mensaje2="Mensaje servidor "+i;
                os.write(mensaje2.getBytes());
                System.out.println("Mensaje enviado");
            }
            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        }catch(IOException e){
        }
    }

}
