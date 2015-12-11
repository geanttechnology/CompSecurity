// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

class val.uri
    implements Runnable
{

    final FunImagePagerActivity this$0;
    private final String val$uri;

    public void run()
    {
        Object obj = null;
        URL url = new URL(val$uri);
        obj = url;
_L3:
        Object obj2;
        byte abyte0[];
        int i;
        Object obj1;
        MalformedURLException malformedurlexception;
        InputStream inputstream;
        boolean flag;
        try
        {
            obj1 = (HttpURLConnection)((URL) (obj)).openConnection();
            ((HttpURLConnection) (obj1)).connect();
            inputstream = ((HttpURLConnection) (obj1)).getInputStream();
            obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").append("/").append(FunImagePagerActivity.access$0(FunImagePagerActivity.this)).append(".jpg").toString());
            if (!((File) (obj)).getParentFile().exists())
            {
                ((File) (obj)).getParentFile().mkdirs();
            }
            flag = ((File) (obj)).exists();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            FunImagePagerActivity.access$21(FunImagePagerActivity.this).sendEmptyMessage(3);
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        ((File) (obj)).createNewFile();
_L4:
        obj2 = new FileOutputStream(((File) (obj)));
        abyte0 = new byte[1024];
_L5:
        i = inputstream.read(abyte0);
        if (i > 0) goto _L2; else goto _L1
_L1:
        ((FileOutputStream) (obj2)).flush();
        ((FileOutputStream) (obj2)).close();
        inputstream.close();
        ((HttpURLConnection) (obj1)).disconnect();
        obj1 = new FileInputStream(((File) (obj)));
        new android.graphics.it>();
        FunImagePagerActivity.access$20(FunImagePagerActivity.this, BitmapFactory.decodeStream(((InputStream) (obj1))));
        ((FileInputStream) (obj1)).close();
        obj1 = new Message();
        obj1.what = 1;
        FunImagePagerActivity.access$21(FunImagePagerActivity.this).sendMessage(((Message) (obj1)));
_L7:
        return;
        malformedurlexception;
        malformedurlexception.printStackTrace();
          goto _L3
        obj2;
        ((IOException) (obj2)).printStackTrace();
          goto _L4
_L2:
        System.out.println((new StringBuilder("ffd ")).append(i).toString());
        ((FileOutputStream) (obj2)).write(abyte0, 0, i);
          goto _L5
        obj;
        ((FileNotFoundException) (obj)).printStackTrace();
        FunImagePagerActivity.access$21(FunImagePagerActivity.this).sendEmptyMessage(2);
        return;
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        if (!((File) (obj)).exists()) goto _L7; else goto _L6
_L6:
        ((File) (obj)).delete();
        return;
          goto _L3
    }

    ()
    {
        this$0 = final_funimagepageractivity;
        val$uri = String.this;
        super();
    }
}
