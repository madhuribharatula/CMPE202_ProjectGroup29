
package api ;

import java.net.*;
import java.io.*;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import game.*;


public class GraphGameServer extends Application {

    public static void main(String[] args) throws Exception {
    //     Component server = new Component() ;
    //     server.getServers().add(Protocol.HTTP, 8080) ;
    //     server.getDefaultHost().attach(new GraphGameServer()) ;
    //     server.start();
    // }

    // @Override
        // public Restlet createInboundRoot() {
    //     Router router = new Router(getContext()) ;
    //     router.attach("/graphgame", GraphResource.class);        
    //     return router;
    // }

        System.out.println("Starting main server ");

        int portNumber = 8080;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {

            while (listening) {
                new GraphGameServerThread(serverSocket.accept()).start();
            }

        } catch (IOException e) {
            System.err.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.err.println(e.getMessage());
        }
    }


}

