package day16;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        DFSSystem sys=new DFSSystem();
        System.out.println("Welcome");
        while(true)
        {
            System.out.println("Select one option");
            System.out.println("0. Exi t");
            System.out.println("1. Create File");
            System.out.println("2. Add Server");
            System.out.println("3. Upload File to Server");
            System.out.println("4. Download File from Server");
            System.out.println("5. Replicate Server to another Server");
            System.out.println("6. Calculate total Free Space in Server");
            System.out.println("7. Display All Files");
            System.out.println("8. Display All servers");
            int n=sc.nextInt();
            if(n==0)
            {
                System.out.println("Exiting");
                break;
            }
            switch (n)
            {
                case 1:
                {
                    sys.addFile();
                    break;
                }
                case 2:
                {
                    sys.addServer();
                    break;
                }
                case 3:
                {
                    try
                    {
                        sys.uploadtoServer();
                    }
                    catch (DFSException.NonExistentServer| DFSException.NonExistingFile e)
                    {
                        System.out.println(e);
                    }
                    catch (DFSException e)
                    {
                        System.out.println(e);
                    }
                }
                case 4:
                {
                    try
                    {
                        sys.downloadfromServer();
                    }
                    catch (DFSException.NonExistentServer| DFSException.NonExistingFile e)
                    {
                        System.out.println(e);
                    }
                    catch (DFSException e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 5:
                {
                    try
                    {
                        sys.replicateFile();
                    }
                    catch (DFSException.NonExistentServer| DFSException.NonExistingFile e)
                    {
                        System.out.println(e);
                    }
                    catch (DFSException e)
                    {
                        System.out.println(e);
                    }

                    break;
                }
                case 6:
                {
                    sys.calculatefreeSpace();
                    break;
                }
                case 7:
                {
                    sys.showFile();
                    break;
                }
                case 8:
                {
                    sys.showServer();
                    break;
                }
                default:
                {
                    System.out.println("Invalid Option");
                }
            }
        }
    }
}
