package day16;

public class DFSException extends Exception {
    public static class NonExistingFile extends DFSException {
        public NonExistingFile() {
            System.out.println("The file does not exists");;
        }
    }

    public static class NonExistentServer extends DFSException {
        public NonExistentServer() {
            System.out.println("The server does not exists");
        }
    }
}
