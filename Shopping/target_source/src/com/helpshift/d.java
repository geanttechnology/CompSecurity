// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Process;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class d
    implements Runnable
{
    static interface a
    {

        public abstract int a();

        public abstract void a(double d1);

        public abstract void a(int i);

        public abstract void a(String s);

        public abstract void a(Thread thread);

        public abstract URL b();

        public abstract void b(int i);

        public abstract int c();

        public abstract File d();

        public abstract File e();
    }


    final a a;
    String b;
    byte c[];
    private long d;
    private long e;

    public d(a a1)
    {
        b = (new StringBuilder()).append("Helpshift-Android/3.9.1/").append(android.os.Build.VERSION.RELEASE).toString();
        a = a1;
    }

    private void a(File file, File file1)
    {
        byte abyte0[];
        file = new FileInputStream(file);
        file1 = new FileOutputStream(file1);
        abyte0 = new byte[1024];
_L1:
        int i = file.read(abyte0);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        file1.write(abyte0, 0, i);
          goto _L1
        try
        {
            file.close();
            file1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.d("HelpShiftDebug", "Exception File Not Found", file);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.d("HelpShiftDebug", "Exception IO", file);
        }
        return;
    }

    public void run()
    {
        Object obj3;
        Object obj4;
        obj4 = null;
        obj3 = null;
        a.a(Thread.currentThread());
        Process.setThreadPriority(10);
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
          goto _L1
        Object obj;
        obj;
        a.b(-1);
        Log.d("HelpShiftDebug", "Exception Interrupted", ((Throwable) (obj)));
        if (a.a() == -1)
        {
            a.a(-1);
        }
_L3:
        return;
_L1:
        File file;
        HttpURLConnection httpurlconnection;
        int i;
        httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection(a.b().openConnection());
        httpurlconnection.setRequestProperty("User-Agent", b);
        file = a.d();
        d = file.length();
        httpurlconnection.setRequestProperty("Range", (new StringBuilder()).append("bytes=").append(d).append("-").toString());
        a.a(a.a());
        if (a.a() == 0)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        i = a.a();
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        Object obj1;
        Object obj2;
        obj2 = obj3;
        obj1 = obj4;
        if (!Thread.interrupted())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj3;
        obj1 = obj4;
        try
        {
            throw new InterruptedException();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3)
        {
            obj1 = obj2;
        }
        finally
        {
            if (obj1 == null) goto _L0; else goto _L0
        }
        a.b(-1);
        obj1 = obj2;
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj3)));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        ((InputStream) (obj2)).close();
_L12:
        if (a.a() == -1)
        {
            a.a(-1);
            return;
        }
        if (true) goto _L3; else goto _L2
_L2:
        obj2 = obj3;
        obj1 = obj4;
        obj3 = httpurlconnection.getInputStream();
        obj2 = obj3;
        obj1 = obj3;
        if (!Thread.interrupted()) goto _L5; else goto _L4
_L4:
        obj2 = obj3;
        obj1 = obj3;
        throw new InterruptedException();
        ((InputStream) (obj1)).close();
_L13:
        try
        {
            throw obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        a.b(-1);
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj1)));
        if (a.a() == -1)
        {
            a.a(-1);
            return;
        }
          goto _L3
_L5:
        obj2 = obj3;
        obj1 = obj3;
        httpurlconnection.getContentLength();
        obj2 = obj3;
        obj1 = obj3;
        e = a.c();
        obj2 = obj3;
        obj1 = obj3;
        obj4 = new FileOutputStream(file, true);
        obj2 = obj3;
        obj1 = obj3;
        c = new byte[1024];
_L7:
        obj2 = obj3;
        obj1 = obj3;
        i = ((InputStream) (obj3)).read(c, 0, 1024);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_639;
        }
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        obj2 = obj3;
        obj1 = obj3;
        throw new EOFException();
        obj2 = obj3;
        obj1 = obj3;
        ((FileOutputStream) (obj4)).write(c, 0, i);
        obj2 = obj3;
        obj1 = obj3;
        d = file.length();
        obj2 = obj3;
        obj1 = obj3;
        double d1 = (double)d / (double)e;
        obj2 = obj3;
        obj1 = obj3;
        a.a(d1 * 10000D);
        obj2 = obj3;
        obj1 = obj3;
        a.a(4);
        obj2 = obj3;
        obj1 = obj3;
        if (!Thread.interrupted()) goto _L7; else goto _L6
_L6:
        obj2 = obj3;
        obj1 = obj3;
        throw new InterruptedException();
        obj2 = obj3;
        obj1 = obj3;
        if (a.a() == 0) goto _L9; else goto _L8
_L8:
        obj2 = obj3;
        obj1 = obj3;
        if (a.a() != 2) goto _L10; else goto _L9
_L9:
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_695;
        }
        obj2 = obj3;
        obj1 = obj3;
        ((FileOutputStream) (obj4)).close();
        obj2 = obj3;
        obj1 = obj3;
        a(a.d(), a.e());
        obj2 = obj3;
        obj1 = obj3;
        a.d().delete();
        obj2 = obj3;
        obj1 = obj3;
        obj4 = a.e().getAbsolutePath();
        obj2 = obj3;
        obj1 = obj3;
        a.a(((String) (obj4)));
        obj2 = obj3;
        obj1 = obj3;
        c = null;
        obj2 = obj3;
        obj1 = obj3;
        a.a(null);
        obj2 = obj3;
        obj1 = obj3;
        Thread.interrupted();
        obj2 = obj3;
        obj1 = obj3;
        a.b(3);
        obj2 = obj3;
        obj1 = obj3;
        a.a(3);
_L10:
        if (obj3 == null) goto _L12; else goto _L11
_L11:
        ((InputStream) (obj3)).close();
          goto _L12
        obj1;
        a.b(-1);
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj1)));
          goto _L12
        obj1;
        if (a.a() == -1)
        {
            a.a(-1);
        }
        throw obj1;
        obj1;
        a.b(-1);
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj1)));
          goto _L12
        obj1;
        a.b(-1);
        Log.d("HelpShiftDebug", "Exception IO", ((Throwable) (obj1)));
          goto _L13
    }
}
