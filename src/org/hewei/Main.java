package org.hewei;


import java.io.FileInputStream;
import java.nio.*;
import java.nio.channels.FileChannel;

public class Main
{
    static public void main( String args[] ) throws Exception {
        FileInputStream fin = new FileInputStream( "readandshow.txt" );
        FileChannel fc = fin.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate( 1024 );

        fc.read( buffer );
    }
}