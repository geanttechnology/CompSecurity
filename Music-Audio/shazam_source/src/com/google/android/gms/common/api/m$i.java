// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            m, o

private abstract class <init>
    implements Runnable
{

    final m b;

    protected abstract void a();

    public void run()
    {
        b.b.lock();
        boolean flag = Thread.interrupted();
        if (flag)
        {
            b.b.unlock();
            return;
        }
        a();
        b.b.unlock();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        o o1 = b.a;
        android.os.Message message = o1.j.obtainMessage(4, runtimeexception);
        o1.j.sendMessage(message);
        b.b.unlock();
        return;
        Exception exception;
        exception;
        b.b.unlock();
        throw exception;
    }

    private (m m1)
    {
        b = m1;
        super();
    }

    b(m m1, byte byte0)
    {
        this(m1);
    }
}
