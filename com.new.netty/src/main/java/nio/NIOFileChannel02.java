package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        //创建文件的输入流
        File file = new File("d:\\file.txt");

        FileInputStream fis = new FileInputStream(file);

        //通过fis 获取 FileChannel
        FileChannel channel = fis.getChannel();

        //创建缓冲区
        ByteBuffer allocate = ByteBuffer.allocate((int)file.length());

        //将 通道的数据读入到Buffer
        channel.read(allocate);

        System.out.println(new String(allocate.array()));

        fis.close();
    }
}
