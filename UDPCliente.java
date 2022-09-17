import java.io.*;
import java.net.*;

class UDPCliente {

    public static void main(String a[]) throws Exception {

        // Datos necesario
        String direccionServidor = "127.0.0.1";
        if (a.length > 0) {
            direccionServidor = a[0];
        }
        int puertoServidor = 9876;
        
        try {

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(direccionServidor);
            System.out.println("Intentando conectar a = " + IPAddress + ":" + puertoServidor +  " via UDP...");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            System.out.print("Favor Ingresar nombre de la empresa: ");
            String empresa = inFromUser.readLine();
            System.out.print("Ingrese Dolar: ");
            String dolar = inFromUser.readLine();
            System.out.print("Ingrese Euro: ");
            String euro = inFromUser.readLine();
            System.out.print("Ingrese Libra: ");
            String libra = inFromUser.readLine();
            System.out.print("Ingrese Real:");
            String real= inFromUser.readLine();
            System.out.print("Ingrese Pesos Argentinos:");
            String arg = inFromUser.readLine();
            System.out.print("Ingrese Pesos Chilenos: ");
            String chi = inFromUser.readLine();
            cotizacion p = new cotizacion(dolar,euro,libra,real,arg,chi,empresa);
            
            String datoPaquete = cotizacionJSON.objetoString(p); 
            sendData = datoPaquete.getBytes();

            System.out.println("Enviar " + datoPaquete + " al servidor. ("+ sendData.length + " bytes)");
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, puertoServidor);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperamos si viene la respuesta.");

            //Vamos a hacer una llamada BLOQUEANTE entonces establecemos un timeout maximo de espera
            clientSocket.setSoTimeout(10000);

            try {
                // ESPERAMOS LA RESPUESTA, BLOQUENTE
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData());
                cotizacion presp = cotizacionJSON.stringObjeto(respuesta.trim());
                
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                System.out.println("Respuesta desde =  " + returnIPAddress + ":" + port);
                

            } catch (SocketTimeoutException ste) {

                System.out.println("TimeOut: El paquete udp se asume perdido.");
            }
            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 