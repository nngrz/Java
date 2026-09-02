interface FileSystemItem {
    void print();
}

class FileItem implements FileSystemItem {
    private String name;

    public FileItem(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(name);
    }
}

public class CompositePractice {
    public static void main(String[] args) {
        FileItem pdf = new FileItem("Resume.pdf");
        pdf.print();
    }
}
