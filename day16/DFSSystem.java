package day16;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSSystem
{
    Scanner sc = new Scanner(System.in);
    private List<File> files;
    private List<Server>serverList;

    DFSSystem()
    {
        files=new ArrayList<>();
        serverList=new ArrayList<>();
    }
    public List<Server> getServerList() {
        return serverList;
    }
    //Add file
    public void addFile()
    {
        System.out.println("Enter the file Name");
        String fileName=sc.next();
        System.out.println("Enter the file Size");
        String fileSize= sc.next();
        File newfile= new File(fileName,fileSize);
        files.add(newfile);
        System.out.println("File has been added");
    }
    //add Server
    public void addServer()
    {
        System.out.println("Enter the server id");
        int id=sc.nextInt();
        Server server=new Server(id);
        serverList.add(server);
        System.out.println("Server has been added");
    }
    //Upload File to Server
    public void uploadtoServer() throws DFSException
    {
        System.out.println("Enter the id of the server where you want to upload the file");
        int id=sc.nextInt();
        System.out.println("Enter the file name");
        String fileName = sc.next();
        Server serverwhereUpload=null;
        for(Server server : serverList)
        {
            if(server.getServerId()==id)
            {
                serverwhereUpload=server;
                break;
            }
            else
            {
                System.out.println("Server does not exists");
            }
        }
        if(serverwhereUpload!=null)
        {
            throw new DFSException.NonExistentServer();
        }
        else
        {
            File filetoUpload=null;
            for(File file: files)
            {
                if(file.getFileName().equals(fileName))
                {
                    filetoUpload=file;
                    break;
                }
                else
                {
                    System.out.println("file does not exists of this name");
                }
            }
            if(filetoUpload==null)
            {
                throw new DFSException.NonExistingFile();

            }
            else
            {
                serverwhereUpload.getFileList().add(filetoUpload);
                System.out.println("File has been uploaded");
                System.out.println(serverwhereUpload.getFileList());
            }
        }
    }

   //Download file
    public void downloadfromServer() throws DFSException
    {
        System.out.println("Enter the id of the server from where you want to download the file");
        int id=sc.nextInt();
        System.out.println("Enter the file name");
        String fileName = sc.next();
        Server serverwhereDownload=null;
        for(Server server : serverList)
        {
            if(server.getServerId()==id)
            {
                serverwhereDownload=server;
                break;
            }
        }
        if(serverwhereDownload==null)
        {
            throw new DFSException.NonExistentServer();
        }
        else
        {
            File filetoDownload=null;
            for(File file: files)
            {
                if(file.getFileName().equals(fileName))
                {
                    filetoDownload=file;
                    break;
                }
                else
                {
                    System.out.println("file does not exists of this name");
                }
            }
            if(filetoDownload==null)
            {
                throw new DFSException.NonExistingFile();
            }
            else
            {
                System.out.println("File has been downloaded");
                System.out.println(filetoDownload);
            }
        }
    }

    //Replicate the file
    public void replicateFile() throws DFSException
    {
        System.out.println("Enter the file name that you want to replicate");
        String fileName=sc.next();
        System.out.println("Enter the server id where you want to replicate the selected file");
        int id=sc.nextInt();
        Server serverwheretoReplicate=null;
        for(Server server: serverList)
        {
            if(server.getServerId()==id)
            {
                serverwheretoReplicate=server;
                break;
            }
        }
        if(serverwheretoReplicate==null)
        {
            throw new DFSException.NonExistentServer();
        }
        else
        {
            File filetoReplicate=null;
            for(File file: files)
            {
                if(file.getFileName().equals(fileName))
                {
                    filetoReplicate=file;
                    break;
                }

            }
            if(filetoReplicate==null)
            {
                throw new DFSException.NonExistingFile();
            }
            else
            {
                filetoReplicate.setReplicated(true);
                serverwheretoReplicate.getFileList().add(filetoReplicate);
                System.out.println("File has been replicated");
            }
        }
    }

    //Calculate free Space
    public void calculatefreeSpace()
    {
        int total=0;
        int TotalAvailabeSpace=1000000;
        for(Server server: serverList)
        {
            List<File>newList = server.getFileList();
            for(File file: newList)
            {
                int value=Integer.parseInt(file.getFileSize());
                total+=value;
            }
        }
        System.out.print("Available Space in Server is :");
        System.out.println(TotalAvailabeSpace-total+"mbps");              //Exception can be made here
    }
    //display files
    public void showFile()
    {
        for(File file: files)
        {
            System.out.println(file);
        }
    }
    //display servers
    public void showServer()
    {
        for(Server server:serverList)
        {
            System.out.println(server);
        }
    }

}
