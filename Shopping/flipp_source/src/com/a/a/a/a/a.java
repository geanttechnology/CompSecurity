// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

// Referenced classes of package com.a.a.a.a:
//            h

abstract class a extends InputStream
{

    protected final InputStream a;
    protected final h b;
    protected boolean c;
    private final CacheRequest d;
    private final OutputStream e;

    a(InputStream inputstream, h h1, CacheRequest cacherequest)
    {
        a = inputstream;
        b = h1;
        if (cacherequest != null)
        {
            inputstream = cacherequest.getBody();
        } else
        {
            inputstream = null;
        }
        if (inputstream == null)
        {
            cacherequest = null;
        }
        e = inputstream;
        d = cacherequest;
    }

    protected final void a()
    {
        if (c)
        {
            throw new IOException("stream closed");
        } else
        {
            return;
        }
    }

    protected final void a(byte abyte0[], int i, int j)
    {
        if (e != null)
        {
            e.write(abyte0, i, j);
        }
    }

    protected final void b()
    {
        if (d != null)
        {
            e.close();
        }
        b.a(false);
    }

    protected final void c()
    {
        if (d != null)
        {
            d.abort();
        }
        b.a(true);
    }

    public final int read()
    {
        return u.a(this);
    }
}
