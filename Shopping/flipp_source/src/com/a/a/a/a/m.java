// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;

// Referenced classes of package com.a.a.a.a:
//            a, j, h

final class m extends a
{

    private int d;

    public m(InputStream inputstream, CacheRequest cacherequest, h h, int i)
    {
        super(inputstream, h, cacherequest);
        d = i;
        if (d == 0)
        {
            b();
        }
    }

    public final int available()
    {
        a();
        if (d == 0)
        {
            return 0;
        } else
        {
            return Math.min(a.available(), d);
        }
    }

    public final void close()
    {
        if (c)
        {
            return;
        }
        if (d != 0 && !j.a(b, this))
        {
            c();
        }
        c = true;
    }

    public final int read(byte abyte0[], int i, int k)
    {
        u.a(abyte0.length, i, k);
        a();
        if (d == 0)
        {
            return -1;
        }
        k = a.read(abyte0, i, Math.min(k, d));
        if (k == -1)
        {
            c();
            throw new ProtocolException("unexpected end of stream");
        }
        d = d - k;
        a(abyte0, i, k);
        if (d == 0)
        {
            b();
        }
        return k;
    }
}
