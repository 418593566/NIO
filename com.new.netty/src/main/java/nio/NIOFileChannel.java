package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {
    public static void main(String[] args) throws Exception {

        String str = "hello word";
        //创建一个输出流->Channel
        FileOutputStream fos = new FileOutputStream("d:\\file.txt");
        //通过 fos 输出流 获取对应的FileChannel
        FileChannel fileChannel = fos.getChannel();

        //创建一个缓冲区ByteBuffer
        ByteBuffer bty = ByteBuffer.allocate(1024);

        //将str 放入bytebuffer
        bty.put(str.getBytes());

        //对bytebuffer 反转
        bty.flip();

        //将bytebuffer 数据写入到filechannel
        fileChannel.write(bty);

        fos.close();
    }
}
