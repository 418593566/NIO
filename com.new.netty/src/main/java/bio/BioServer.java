package bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {

    public static void main(String[] args) throws Exception {

        final ServerHandler sh = new ServerHandler();

        //1.创建一个线程池

        //2.如果有客户端连接，就创建一个线程，与之通讯(单独写个方法)

        ExecutorService xianchengchi = Executors.newCachedThreadPool();

        //创建ServerSocket
       ServerSocket serverSocket =  new ServerSocket(6666);    //监听端口

        System.err.println("服务器启动了");

        while(true){
            System.out.println("等待连接...........");
            //监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到了一个客户端");

            //创建一个线程，与之通讯(单独写个方法)
            xianchengchi.execute(new Runnable() {
                public void run() {     //重写run方法
                    //可以和客户端通讯
                    sh.handler(socket);
                }
            });
        }
    }
}
