// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.immersion.hapticmediasdk.b.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            e

public final class b extends Thread
{

    public static int b = 39;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    volatile boolean a;
    private String f;
    private Handler g;
    private boolean h;
    private Thread i;
    private a j;
    private volatile boolean k;
    private volatile boolean l;

    public b(String s, Handler handler, boolean flag, a a1)
    {
        super("HapticDownloadThread");
        k = false;
        l = false;
        a = false;
        f = s;
        g = handler;
        h = flag;
        j = a1;
        s = g.getLooper();
        if (((b + d) * b) % e != c)
        {
            b = 70;
            c = 19;
        }
        i = s.getThread();
    }

    private boolean a(InputStream inputstream, int i1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        int j1 = 0;
        Object obj2;
        Exception exception;
        Bundle bundle;
        FileNotFoundException filenotfoundexception;
        boolean flag;
        try
        {
            obj2 = new byte[4096];
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        if (inputstream == null || i1 <= 0) goto _L2; else goto _L1
_L1:
        obj = new BufferedInputStream(inputstream);
        if (!h) goto _L4; else goto _L3
_L3:
        inputstream = j.a(f);
_L9:
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        if (k)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        obj1 = g.obtainMessage(8);
        obj2 = new Bundle();
        ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
        try
        {
            ((Message) (obj1)).setData(((Bundle) (obj2)));
            if (i.isAlive() && !a)
            {
                g.sendMessage(((Message) (obj1)));
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", "downloaded an empty file");
        com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj)));
        com.immersion.hapticmediasdk.b.a.a(inputstream);
        l = true;
        return false;
        if (h) goto _L6; else goto _L5
_L5:
        k = true;
        flag = a;
        if (!flag) goto _L8; else goto _L7
_L7:
        if (!k)
        {
            obj1 = g.obtainMessage(8);
            obj2 = new Bundle();
            ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
            ((Message) (obj1)).setData(((Bundle) (obj2)));
            if (i.isAlive() && !a)
            {
                g.sendMessage(((Message) (obj1)));
            }
            com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", "downloaded an empty file");
        }
        com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj)));
        com.immersion.hapticmediasdk.b.a.a(inputstream);
        l = true;
        return true;
_L2:
        if (!k)
        {
            inputstream = g.obtainMessage(8);
            obj = new Bundle();
            ((Bundle) (obj)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
            inputstream.setData(((Bundle) (obj)));
            if (i.isAlive() && !a)
            {
                g.sendMessage(inputstream);
            }
            com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", "downloaded an empty file");
        }
        com.immersion.hapticmediasdk.b.a.a(null);
        com.immersion.hapticmediasdk.b.a.a(null);
        l = true;
        return false;
_L14:
        if (k)
        {
            break MISSING_BLOCK_LABEL_455;
        }
        obj2 = g.obtainMessage(8);
        bundle = new Bundle();
        filenotfoundexception = new FileNotFoundException("downloaded an empty file");
        bundle.putSerializable("haptic_download_exception", filenotfoundexception);
        ((Message) (obj2)).setData(bundle);
        if (i.isAlive() && !a)
        {
            g.sendMessage(((Message) (obj2)));
        }
        com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", "downloaded an empty file");
        com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj1)));
        com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj)));
        l = true;
        throw inputstream;
_L4:
        inputstream = j.b(f);
          goto _L9
_L8:
        g.sendMessage(g.obtainMessage(3, i1, 0));
_L11:
        com.immersion.hapticmediasdk.b.b.a();
        if (k)
        {
            break MISSING_BLOCK_LABEL_624;
        }
        obj1 = g.obtainMessage(8);
        obj2 = new Bundle();
        if (((b + d) * b) % e != c)
        {
            b = 2;
            c = 54;
        }
        ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
        ((Message) (obj1)).setData(((Bundle) (obj2)));
        if (i.isAlive() && !a)
        {
            g.sendMessage(((Message) (obj1)));
        }
        com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", "downloaded an empty file");
        com.immersion.hapticmediasdk.b.a.a(((java.io.Closeable) (obj)));
        if (((b + 1) * b) % e != c)
        {
            b = 47;
            c = 86;
        }
        com.immersion.hapticmediasdk.b.a.a(inputstream);
        l = true;
        return true;
_L6:
        if (isInterrupted() || a) goto _L11; else goto _L10
_L10:
        i1 = ((BufferedInputStream) (obj)).read(((byte []) (obj2)), 0, 4096);
        if (i1 < 0) goto _L11; else goto _L12
_L12:
        inputstream.write(((byte []) (obj2)), 0, i1);
        i1 = j1 + i1;
        j1 = i1;
        if (!i.isAlive()) goto _L6; else goto _L13
_L13:
        if (!k)
        {
            k = true;
        }
        inputstream.flush();
        obj1 = g.obtainMessage(3, i1, 0);
        g.sendMessage(((Message) (obj1)));
        j1 = i1;
          goto _L6
        exception;
        obj1 = obj;
        obj = exception;
        exception = inputstream;
        inputstream = ((InputStream) (obj));
        obj = exception;
          goto _L14
        inputstream;
        Object obj3 = null;
        obj1 = obj;
        obj = obj3;
          goto _L14
        inputstream;
        obj = null;
          goto _L14
    }

    public final void run()
    {
        if (!h) goto _L2; else goto _L1
_L1:
        Object obj;
        int i1;
        Process.setThreadPriority(10);
        obj = com.immersion.hapticmediasdk.a.e.a();
        try
        {
            obj = ((e) (obj)).a(f);
            i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Thread.currentThread().interrupt();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Message message = g.obtainMessage(8);
            Bundle bundle = new Bundle();
            bundle.putSerializable("haptic_download_exception", ((java.io.Serializable) (obj)));
            message.setData(bundle);
            if (i.isAlive() && !a)
            {
                Handler handler = g;
                if (((b + d) * b) % e != c)
                {
                    b = 19;
                    c = 19;
                }
                handler.sendMessage(message);
            }
            com.immersion.hapticmediasdk.b.b.a("HapticDownloadThread", ((Exception) (obj)).getMessage());
            return;
        }
        if (i1 != 200) goto _L4; else goto _L3
_L3:
        i1 = Integer.parseInt(((HttpResponse) (obj)).getFirstHeader("Content-Length").getValue());
        a(((HttpResponse) (obj)).getEntity().getContent(), i1);
_L6:
        return;
_L2:
        try
        {
            obj = new FileInputStream(f);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            filenotfoundexception = null;
        }
        if (obj == null) goto _L6; else goto _L5
_L5:
        try
        {
            a(((InputStream) (obj)), ((InputStream) (obj)).available());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        return;
_L11:
        ((StringBuilder) (obj)).append(" Internal Server Error");
_L7:
        throw new com.immersion.hapticmediasdk.models.a(i1, ((StringBuilder) (obj)).toString());
_L12:
        ((StringBuilder) (obj)).append(" Bad Gateway");
          goto _L7
_L4:
        obj = new StringBuilder("HTTP STATUS CODE: ");
        ((StringBuilder) (obj)).append(i1);
        i1;
        JVM INSTR lookupswitch 6: default 385
    //                   400: 332
    //                   403: 342
    //                   404: 353
    //                   500: 116
    //                   502: 145
    //                   503: 364;
           goto _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        ((StringBuilder) (obj)).append(" Bad Request");
          goto _L7
_L9:
        ((StringBuilder) (obj)).append(" Forbidden");
          goto _L7
_L10:
        ((StringBuilder) (obj)).append(" Not Found");
          goto _L7
_L13:
        ((StringBuilder) (obj)).append(" Service Unavailable");
          goto _L7
    }
}
