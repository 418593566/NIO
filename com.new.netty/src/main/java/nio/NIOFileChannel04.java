package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {
    public static void main(String[] args) throws  Exception{

        FileInputStream fis = new FileInputStream("d:\\BIO.png");
        FileOutputStream fos = new FileOutputStream("d:\\BIO2.png");

        FileChannel fh1 = fis.getChannel();
        FileChannel fh2 = fos.getChannel();

        fh2.transferFrom(fh1,0,fh1.size());

        fh1.close();
        fh2.close();
        fis.close();
        fos.close();
    }
}
