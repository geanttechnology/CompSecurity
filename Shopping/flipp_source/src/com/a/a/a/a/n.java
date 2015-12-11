// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.a;
import com.a.a.a.u;
import java.io.OutputStream;
import java.net.ProtocolException;

final class n extends a
{

    private final OutputStream b;
    private long c;

    private n(OutputStream outputstream, long l)
    {
        b = outputstream;
        c = l;
    }

    n(OutputStream outputstream, long l, byte byte0)
    {
        this(outputstream, l);
    }

    public final void close()
    {
        if (!a)
        {
            a = true;
            if (c > 0L)
            {
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    public final void flush()
    {
        if (a)
        {
            return;
        } else
        {
            b.flush();
            return;
        }
    }

    public final void write(byte abyte0[], int i, int j)
    {
        a();
        u.a(abyte0.length, i, j);
        if ((long)j > c)
        {
            throw new ProtocolException((new StringBuilder("expected ")).append(c).append(" bytes but received ").append(j).toString());
        } else
        {
            b.write(abyte0, i, j);
            c = c - (long)j;
            return;
        }
    }
}
