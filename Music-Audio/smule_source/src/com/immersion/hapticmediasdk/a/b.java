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

public class b extends Thread
{

    public static int a = 39;
    public static int b = 0;
    public static int c = 1;
    public static int d = 2;
    private String e;
    private Handler f;
    private boolean g;
    private Thread h;
    private a i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;

    public b(String s, Handler handler, boolean flag, a a1)
    {
        super("HapticDownloadThread");
        j = false;
        k = false;
        l = false;
        e = s;
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        f = handler;
        g = flag;
        i = a1;
        s = f.getLooper();
        if (((a + c) * a) % d != b)
        {
            a = 70;
            b = a();
        }
        h = s.getThread();
    }

    public static int a()
    {
        return 19;
    }

    public static int c()
    {
        return 0;
    }

    public static int d()
    {
        return 1;
    }

    public boolean a(InputStream inputstream, int i1)
    {
        Object obj;
        Object obj1;
        int j1 = 0;
        Object obj2;
        Exception exception;
        Bundle bundle;
        FileNotFoundException filenotfoundexception;
        boolean flag;
        try
        {
            obj1 = new byte[4096];
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        if (inputstream == null || i1 <= 0) goto _L2; else goto _L1
_L1:
        obj = new BufferedInputStream(inputstream);
        if (!g) goto _L4; else goto _L3
_L3:
        inputstream = i.a(e);
_L9:
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        if (j)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj1 = f.obtainMessage(8);
        obj2 = new Bundle();
        ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
        try
        {
            ((Message) (obj1)).setData(((Bundle) (obj2)));
            if (h.isAlive() && !l)
            {
                f.sendMessage(((Message) (obj1)));
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", "downloaded an empty file");
        i.a(((java.io.Closeable) (obj)));
        i.a(inputstream);
        k = true;
        return false;
        if (g) goto _L6; else goto _L5
_L5:
        j = true;
        flag = l;
        if (!flag) goto _L8; else goto _L7
_L7:
        if (!j)
        {
            obj1 = f.obtainMessage(8);
            obj2 = new Bundle();
            ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
            ((Message) (obj1)).setData(((Bundle) (obj2)));
            if (h.isAlive() && !l)
            {
                f.sendMessage(((Message) (obj1)));
            }
            com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", "downloaded an empty file");
        }
        obj1 = i;
        ((a) (obj1)).a(((java.io.Closeable) (obj)));
        i.a(inputstream);
        k = true;
        return true;
_L2:
        if (!j)
        {
            inputstream = f.obtainMessage(8);
            obj = new Bundle();
            ((Bundle) (obj)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
            inputstream.setData(((Bundle) (obj)));
            if (h.isAlive() && !l)
            {
                f.sendMessage(inputstream);
            }
            com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", "downloaded an empty file");
        }
        i.a(null);
        i.a(null);
        k = true;
        return false;
_L14:
        if (j)
        {
            break MISSING_BLOCK_LABEL_480;
        }
        obj2 = f.obtainMessage(8);
        bundle = new Bundle();
        filenotfoundexception = new FileNotFoundException("downloaded an empty file");
        bundle.putSerializable("haptic_download_exception", filenotfoundexception);
        ((Message) (obj2)).setData(bundle);
        if (h.isAlive() && !l)
        {
            f.sendMessage(((Message) (obj2)));
        }
        com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", "downloaded an empty file");
        i.a(((java.io.Closeable) (obj1)));
        i.a(((java.io.Closeable) (obj)));
        k = true;
        throw inputstream;
_L4:
        inputstream = i.b(e);
          goto _L9
_L8:
        f.sendMessage(f.obtainMessage(3, i1, 0));
_L11:
        com.immersion.hapticmediasdk.b.b.b("HapticDownloadThread", "file download completed");
        if (j)
        {
            break MISSING_BLOCK_LABEL_661;
        }
        obj1 = f.obtainMessage(8);
        obj2 = new Bundle();
        if (((a + c) * a) % d != b)
        {
            a = 2;
            b = 54;
        }
        ((Bundle) (obj2)).putSerializable("haptic_download_exception", new FileNotFoundException("downloaded an empty file"));
        ((Message) (obj1)).setData(((Bundle) (obj2)));
        if (h.isAlive() && !l)
        {
            f.sendMessage(((Message) (obj1)));
        }
        com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", "downloaded an empty file");
        i.a(((java.io.Closeable) (obj)));
        if (((a + d()) * a) % d != b)
        {
            a = 47;
            b = 86;
        }
        i.a(inputstream);
        k = true;
        return true;
_L6:
        if (isInterrupted() || l) goto _L11; else goto _L10
_L10:
        i1 = ((BufferedInputStream) (obj)).read(((byte []) (obj1)), 0, 4096);
        if (i1 < 0) goto _L11; else goto _L12
_L12:
        inputstream.write(((byte []) (obj1)), 0, i1);
        i1 = j1 + i1;
        j1 = i1;
        if (!h.isAlive()) goto _L6; else goto _L13
_L13:
        if (!j)
        {
            j = true;
        }
        inputstream.flush();
        obj2 = f.obtainMessage(3, i1, 0);
        f.sendMessage(((Message) (obj2)));
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
        obj1 = null;
          goto _L14
    }

    public void b()
    {
        if (((a + c) * a) % d != c())
        {
            a = 53;
            b = a();
        }
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        l = true;
    }

    public void run()
    {
        if (!g) goto _L2; else goto _L1
_L1:
        Object obj;
        int i1;
        Process.setThreadPriority(10);
        obj = com.immersion.hapticmediasdk.a.e.a();
        try
        {
            obj = ((e) (obj)).a(e, null, 60000);
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
            Message message = f.obtainMessage(8);
            Bundle bundle = new Bundle();
            bundle.putSerializable("haptic_download_exception", ((java.io.Serializable) (obj)));
            message.setData(bundle);
            if (h.isAlive() && !l)
            {
                Handler handler = f;
                if (((a + c) * a) % d != b)
                {
                    a = a();
                    b = a();
                }
                handler.sendMessage(message);
            }
            com.immersion.hapticmediasdk.b.b.d("HapticDownloadThread", ((Exception) (obj)).getMessage());
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
            obj = new FileInputStream(e);
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
        throw new com.immersion.hapticmediasdk.models.b(i1, ((StringBuilder) (obj)).toString());
_L12:
        ((StringBuilder) (obj)).append(" Bad Gateway");
          goto _L7
_L4:
        obj = new StringBuilder("HTTP STATUS CODE: ");
        ((StringBuilder) (obj)).append(i1);
        i1;
        JVM INSTR lookupswitch 6: default 394
    //                   400: 340
    //                   403: 351
    //                   404: 362
    //                   500: 119
    //                   502: 148
    //                   503: 373;
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
