// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.os.AsyncTask;
import android.util.Log;
import com.cyberlink.you.widgetpool.common.GifImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

final class eView extends AsyncTask
{

    private String a;
    private GifImageView b;
    private String c;

    public transient ByteArrayOutputStream a(Object aobj[])
    {
        Thread.currentThread().setName("loadGif AsyncTask");
        a = (String)aobj[0];
        b = (GifImageView)aobj[1];
        c = (String)aobj[2];
        aobj = null;
        Object obj = (new URL(a)).openConnection().getInputStream();
        aobj = ((Object []) (obj));
_L3:
        byte abyte0[];
        abyte0 = new byte[1024];
        obj = new ByteArrayOutputStream();
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
_L1:
        int i = ((InputStream) (aobj)).read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        ((ByteArrayOutputStream) (obj)).write(abyte0, 0, i);
          goto _L1
        aobj;
        Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (aobj))));
        return ((ByteArrayOutputStream) (obj));
        Object obj1;
        obj1;
        Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (obj1))));
        continue; /* Loop/switch isn't completed */
        obj1;
        Log.d("LoadImageUtils", Log.getStackTraceString(((Throwable) (obj1))));
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected void a(ByteArrayOutputStream bytearrayoutputstream)
    {
        b.setGifImage(bytearrayoutputstream);
        if (c.isEmpty() || (new File(c)).exists()) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream = new FileOutputStream(c);
        bytearrayoutputstream.writeTo(fileoutputstream);
        bytearrayoutputstream = fileoutputstream;
_L5:
        if (bytearrayoutputstream == null) goto _L2; else goto _L3
_L3:
        bytearrayoutputstream.close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        bytearrayoutputstream = null;
_L6:
        Log.d("LoadImageUtils", Log.getStackTraceString(ioexception));
        if (true) goto _L5; else goto _L4
_L4:
        bytearrayoutputstream;
        Log.d("LoadImageUtils", Log.getStackTraceString(bytearrayoutputstream));
        return;
        ioexception;
        bytearrayoutputstream = fileoutputstream;
          goto _L6
    }

    public Object doInBackground(Object aobj[])
    {
        return a(aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((ByteArrayOutputStream)obj);
    }

    eView()
    {
    }
}
