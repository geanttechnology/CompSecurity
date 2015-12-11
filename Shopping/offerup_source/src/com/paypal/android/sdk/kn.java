// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            lj, kl, kq, lk

final class kn
    implements lj
{

    private lj a;
    private kl b;

    kn(kl kl1, lj lj1)
    {
        b = kl1;
        a = lj1;
        super();
    }

    public final long a(kq kq, long l)
    {
        b.c();
        l = a.a(kq, l);
        b.a(true);
        return l;
        kq;
        throw b.b(kq);
        kq;
        b.a(false);
        throw kq;
    }

    public final lk a()
    {
        return b;
    }

    public final void close()
    {
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

    public final String toString()
    {
        return (new StringBuilder("AsyncTimeout.source(")).append(a).append(")").toString();
    }
}
