package gov.iti.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import gov.iti.business.Calculator;
import gov.iti.business.CalculatorImp;

/**
 * Hello world!
 *
 */
public class App {

    BufferedReader buffer;
    public static void main( String[] args )
    {
        App app = new App();
        while (true) { 
            try {
                String text = app.buffer.readLine().trim();
                if (text.equals("-1")) break;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //System.out.println( "Hello World!" );
    }
    public App(){ 
        try{
            buffer= new BufferedReader(new InputStreamReader(System.in));
            CalculatorImp obj = new CalculatorImp();
            //HelloInterface stub = (HelloInterface) UnicastRemoteObject.exportObject(obj, 0);
            //System.setProperty("java.rmi.server.hostname","192.168.1.2");
            Registry reg = LocateRegistry.createRegistry(1099);
            //.createRegistry(1099);
            reg.rebind("CalculateService", obj);
            System.out.println("start server");
        } catch(RemoteException ex) { 
            ex.printStackTrace();
        }
    }
}
