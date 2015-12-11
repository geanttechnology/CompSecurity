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
        m.c(b).lock();
        boolean flag = Thread.interrupted();
        if (flag)
        {
            m.c(b).unlock();
            return;
        }
        a();
        m.c(b).unlock();
        return;
        Object obj;
        obj;
        m.d(b).a(((RuntimeException) (obj)));
        m.c(b).unlock();
        return;
        obj;
        m.c(b).unlock();
        throw obj;
    }

    private (m m1)
    {
        b = m1;
        super();
    }

    b(m m1, b b1)
    {
        this(m1);
    }
}
