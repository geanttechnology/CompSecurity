// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.flurry.sdk:
//            hp, al

public class <init>
    implements Closeable
{

    final al a;
    private final close b;
    private final InputStream c;
    private final GZIPInputStream d;
    private final BufferedInputStream e;
    private boolean f;

    public InputStream a()
    {
        return e;
    }

    public void close()
    {
        if (f)
        {
            return;
        } else
        {
            f = true;
            hp.a(e);
            hp.a(d);
            hp.a(c);
            hp.a(b);
            return;
        }
    }

    protected void finalize()
    {
        super.finalize();
        close();
    }

    private tStream(al al, tStream tstream, boolean flag)
    {
        a = al;
        super();
        if (tstream == null)
        {
            throw new IllegalArgumentException("Snapshot cannot be null");
        }
        b = tstream;
        c = b.a(0);
        if (c == null)
        {
            throw new IOException("Snapshot inputstream is null");
        }
        if (flag)
        {
            d = new GZIPInputStream(c);
            if (d == null)
            {
                throw new IOException("Gzip inputstream is null");
            } else
            {
                e = new BufferedInputStream(d);
                return;
            }
        } else
        {
            d = null;
            e = new BufferedInputStream(c);
            return;
        }
    }

    c(al al, c c1, boolean flag, c c2)
    {
        this(al, c1, flag);
    }
}
