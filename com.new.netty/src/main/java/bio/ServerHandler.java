package bio;

import java.io.InputStream;
import java.net.Socket;

public class ServerHandler {
    public void handler(Socket socket){

        try {
            System.out.println("线程信息 id="+Thread.currentThread().getId()+
                    "名字 ="+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket，获取输入流   read/write
            InputStream inputStream = socket.getInputStream();

            //循环读取客户端发送的数据
            while (true){
                System.out.println("线程信息 id="+Thread.currentThread().getId()+
                        "名字 ="+Thread.currentThread().getName());

                System.out.println("read.......");
                int read = inputStream.read(bytes);
                if (read != -1){   //还可以继续读
                    System.out.println(new String(bytes,0,read));   //输出客户端发送的数据
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("关闭和client连接");
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
