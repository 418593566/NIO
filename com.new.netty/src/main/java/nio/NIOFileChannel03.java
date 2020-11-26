package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws  Exception{

        FileInputStream fis = new FileInputStream("1.txt");

        FileChannel fc1 = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("2.txt");

        FileChannel fc2 = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(512);

        while(true){
            buffer.clear();
            int read = fc1.read(buffer);
            if(read == -1){
                break;
            }
            buffer.flip();
            fc2.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
