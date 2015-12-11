// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class AndroidRunable
    implements Runnable
{

    Socket socket;

    public AndroidRunable(Socket socket1)
    {
        socket = null;
        socket = socket1;
    }

    public void run()
    {
        OutputStream outputstream;
        InputStream inputstream;
        BufferedReader bufferedreader;
        outputstream = socket.getOutputStream();
        inputstream = socket.getInputStream();
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        outputstream.write("aio".getBytes("gbk"));
        outputstream.flush();
        socket.shutdownOutput();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            try
            {
                outputstream.close();
                bufferedreader.close();
                inputstream.close();
                socket.close();
                return;
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_124;
        }
        System.out.print(s);
        Log.e("gak", (new StringBuilder("socket=")).append(s).toString());
          goto _L1
    }
}
