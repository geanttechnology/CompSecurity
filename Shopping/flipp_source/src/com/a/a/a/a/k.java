// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;

// Referenced classes of package com.a.a.a.a:
//            a, j, h, z, 
//            v

final class k extends a
{

    private final j d;
    private int e;
    private boolean f;

    k(InputStream inputstream, CacheRequest cacherequest, j j1)
    {
        super(inputstream, j1.a, cacherequest);
        e = -1;
        f = true;
        d = j1;
    }

    public final int available()
    {
        a();
        if (!f || e == -1)
        {
            return 0;
        } else
        {
            return Math.min(a.available(), e);
        }
    }

    public final void close()
    {
        if (c)
        {
            return;
        }
        if (f && !j.a(b, this))
        {
            c();
        }
        c = true;
    }

    public final int read(byte abyte0[], int i, int l)
    {
        u.a(abyte0.length, i, l);
        a();
        if (f) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (e != 0 && e != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (e != -1)
        {
            u.c(a);
        }
        String s = u.c(a);
        int i1 = s.indexOf(";");
        Object obj = s;
        if (i1 != -1)
        {
            obj = s.substring(0, i1);
        }
        try
        {
            e = Integer.parseInt(((String) (obj)).trim(), 16);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new ProtocolException((new StringBuilder("Expected a hex chunk size but was ")).append(((String) (obj))).toString());
        }
        if (e == 0)
        {
            f = false;
            obj = b.j.f;
            v.a(d.b, ((v) (obj)));
            b.a(((v) (obj)));
            b();
        }
        if (!f) goto _L1; else goto _L3
_L3:
        l = a.read(abyte0, i, Math.min(l, e));
        if (l == -1)
        {
            c();
            throw new IOException("unexpected end of stream");
        } else
        {
            e = e - l;
            a(abyte0, i, l);
            return l;
        }
    }
}
