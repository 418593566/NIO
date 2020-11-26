package nio;

import java.nio.IntBuffer;

public class BaseBuffer {
    public static void main(String[] args) {
        //创建一个buffer，大小为5，即可以存放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity();i++) {
            intBuffer.put(i*2);
        }

        //读取buffer数据
        //将buffer读写转换
        /*
               public final Buffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }
         */
        intBuffer.flip();
        intBuffer.position(1);    //从下标1开始读
        intBuffer.limit(3);       //不能超过三个元素

        while(intBuffer.hasRemaining()){    //有剩余的就读
            System.out.println(intBuffer.get());
        }
    }
}
