package cn.zlq.test.main;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangliangqi
 * @Title: NIOMainTest
 * @Package cn.zlq.test.main
 * @Description
 * @date 2016-06-17
 */
public class NIOMainTest {

    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("E:\\home\\platform\\csm\\batch\\logs\\batch-csm.log","rw");
            FileChannel channel = accessFile.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(48);
            int bytes = channel.read(bf);
            while (bytes != -1){
                System.out.println("read"+bytes);
                bf.flip();
                while (bf.hasRemaining()){
                    System.out.println(bf.get() );
                }
                bf.clear();
                bytes = channel.read(bf);
            }
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
