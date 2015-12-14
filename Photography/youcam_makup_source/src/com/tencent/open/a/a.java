// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Referenced classes of package com.tencent.open.a:
//            n, l, b, c, 
//            m

public class a extends n
    implements android.os.Handler.Callback
{

    private b a;
    private FileWriter b;
    private File c;
    private char d[];
    private volatile l e;
    private volatile l f;
    private volatile l g;
    private volatile l h;
    private volatile boolean i;
    private HandlerThread j;
    private Handler k;

    public a(int i1, boolean flag, m m1, b b1)
    {
        super(i1, flag, m1);
        i = false;
        a(b1);
        e = new l();
        f = new l();
        g = e;
        h = f;
        d = new char[b1.f()];
        b1.b();
        g();
        j = new HandlerThread(b1.c(), b1.h());
        if (j != null)
        {
            j.start();
        }
        if (j.isAlive() && j.getLooper() != null)
        {
            k = new Handler(j.getLooper(), this);
        }
    }

    public a(b b1)
    {
        this(c.b, true, m.a, b1);
    }

    private void f()
    {
        while (Thread.currentThread() != j || i) 
        {
            return;
        }
        i = true;
        i();
        h.a(g(), d);
        h.b();
_L2:
        i = false;
        return;
        Object obj;
        obj;
        h.b();
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        h.b();
        throw obj;
    }

    private Writer g()
    {
        File file = c().a();
        if (file != null && !file.equals(c))
        {
            c = file;
            h();
            try
            {
                b = new FileWriter(c, true);
            }
            catch (IOException ioexception)
            {
                return null;
            }
        }
        return b;
    }

    private void h()
    {
        try
        {
            if (b != null)
            {
                b.flush();
                b.close();
            }
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (g != e)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        g = f;
        h = e;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        g = e;
        h = f;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a()
    {
        if (k.hasMessages(1024))
        {
            k.removeMessages(1024);
        }
        k.sendEmptyMessage(1024);
    }

    protected void a(int i1, Thread thread, long l1, String s, String s1, Throwable throwable)
    {
        a(e().a(i1, thread, l1, s, s1, throwable));
    }

    public void a(b b1)
    {
        a = b1;
    }

    protected void a(String s)
    {
        g.a(s);
        if (g.a() >= c().f())
        {
            a();
        }
    }

    public void b()
    {
        h();
        j.quit();
    }

    public b c()
    {
        return a;
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1024 1024: default 24
    //                   1024 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        f();
        if (true) goto _L1; else goto _L3
_L3:
    }
}
