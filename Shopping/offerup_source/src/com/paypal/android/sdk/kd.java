// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;

// Referenced classes of package com.paypal.android.sdk:
//            lh, kq, lk, hl

public final class kd
    implements lh
{

    private boolean a;
    private final int b;
    private final kq c;

    public kd()
    {
        this(-1);
    }

    public kd(int i)
    {
        c = new kq();
        b = i;
    }

    public final lk a()
    {
        return lk.a;
    }

    public final void a(lh lh1)
    {
        kq kq1 = new kq();
        c.a(kq1, 0L, c.b);
        lh1.a_(kq1, kq1.b);
    }

    public final void a_(kq kq1, long l)
    {
        if (a)
        {
            throw new IllegalStateException("closed");
        }
        hl.a(kq1.b, 0L, l);
        if (b != -1 && c.b > (long)b - l)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(b).append(" bytes").toString());
        } else
        {
            c.a_(kq1, l);
            return;
        }
    }

    public final long b()
    {
        return c.b;
    }

    public final void close()
    {
        if (!a)
        {
            a = true;
            if (c.b < (long)b)
            {
                throw new ProtocolException((new StringBuilder("content-length promised ")).append(b).append(" bytes, but received ").append(c.b).toString());
            }
        }
    }

    public final void flush()
    {
    }
}
