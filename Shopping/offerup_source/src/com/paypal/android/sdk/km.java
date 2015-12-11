// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            lh, kl, lk, kq

final class km
    implements lh
{

    private lh a;
    private kl b;

    km(kl kl1, lh lh1)
    {
        b = kl1;
        a = lh1;
        super();
    }

    public final lk a()
    {
        return b;
    }

    public final void a_(kq kq, long l)
    {
        b.c();
        a.a_(kq, l);
        b.a(true);
        return;
        kq;
        throw b.b(kq);
        kq;
        b.a(false);
        throw kq;
    }

    public final void close()
    {
        b.c();
        a.close();
        b.a(true);
        return;
        Object obj;
        obj;
        throw b.b(((IOException) (obj)));
        obj;
        b.a(false);
        throw obj;
    }

    public final void flush()
    {
        b.c();
        a.flush();
        b.a(true);
        return;
        Object obj;
        obj;
        throw b.b(((IOException) (obj)));
        obj;
        b.a(false);
        throw obj;
    }

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.sink(")).append(a).append(")").toString();
    }
}
