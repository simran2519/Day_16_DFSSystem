package day16;

public class File
{
    private String fileName;
    private String fileSize;
    private boolean isReplicated;
    File(String fileName,String fileSize)
    {
        this.fileName=fileName;
        this.fileSize=fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }
    public String getFileName() {
        return fileName;
    }
    public void setReplicated(boolean replicated) {
        isReplicated = replicated;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", isReplicated=" + isReplicated +
                '}';
    }
}
