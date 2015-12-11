// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class ox extends Thread
{

    CountDownLatch a;
    boolean b;
    private WeakReference c;
    private long d;

    public ox(ov ov1, long l)
    {
        c = new WeakReference(ov1);
        d = l;
        a = new CountDownLatch(1);
        b = false;
        start();
    }

    private void c()
    {
        ov ov1 = (ov)c.get();
        if (ov1 != null)
        {
            ov1.c();
            b = true;
        }
    }

    public void a()
    {
        a.countDown();
    }

    public boolean b()
    {
        return b;
    }

    public void run()
    {
        try
        {
            if (!a.await(d, TimeUnit.MILLISECONDS))
            {
                c();
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            c();
        }
    }
}
