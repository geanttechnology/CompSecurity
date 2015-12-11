// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.start:
//            MainActivity

class this._cls0 extends Thread
{

    final MainActivity this$0;

    public void run()
    {
        ServerSocket serversocket;
        super.run();
        serversocket = null;
        if (false)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        serversocket = new ServerSocket(12121);
_L3:
        Socket socket = serversocket.accept();
        Object obj = "";
        OutputStream outputstream;
        InputStream inputstream;
        BufferedReader bufferedreader;
        outputstream = socket.getOutputStream();
        inputstream = socket.getInputStream();
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L5:
        String s2 = bufferedreader.readLine();
        if (s2 != null) goto _L2; else goto _L1
_L1:
        try
        {
            Log.e("write", "write11111");
            obj = ((String) (obj)).split(" ")[1].trim();
            String as[] = ((String) (obj)).split("/?jsonpCallback=");
            String s = as[as.length - 1].split("&")[0];
            Log.e("gak", (new StringBuilder(String.valueOf(obj))).append("====buffer====").append(s).toString());
            new JSONObject();
            new JSONArray();
            obj = (new StringBuilder(String.valueOf(s))).append("({name:'aio'})").toString();
            Log.e("gak", (new StringBuilder("str===")).append(((String) (obj))).toString());
            Log.e("write", "write22222");
            outputstream.write(((String) (obj)).getBytes("gbk"));
            outputstream.flush();
            socket.shutdownOutput();
            outputstream.close();
            bufferedreader.close();
            inputstream.close();
            socket.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("gak", (new StringBuilder("catch1")).append(((IOException) (obj)).getMessage()).toString());
            ((IOException) (obj)).printStackTrace();
            return;
        }
          goto _L3
_L2:
        String s1;
        boolean flag;
        s1 = (new StringBuilder(String.valueOf(obj))).append(s2).toString();
        Log.e("gak", (new StringBuilder("line=")).append(s2).toString());
        flag = s2.equals("");
        obj = s1;
        if (!flag) goto _L5; else goto _L4
_L4:
        obj = s1;
          goto _L1
    }

    ()
    {
        this$0 = MainActivity.this;
        super();
    }
}
