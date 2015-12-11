// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.flurry.sdk:
//            hp, al, gd

public class <init>
    implements Closeable
{

    final al a;
    private final close b;
    private final OutputStream c;
    private final GZIPOutputStream d;
    private final tputStream e;
    private boolean f;

    public OutputStream a()
    {
        return e;
    }

    public void close()
    {
        boolean flag = true;
        if (!f) goto _L2; else goto _L1
_L1:
        return;
_L2:
        f = true;
        hp.a(e);
        hp.a(d);
        hp.a(c);
        if (b == null) goto _L1; else goto _L3
_L3:
        if (e != null)
        {
            flag = a(e);
        }
        if (flag)
        {
            try
            {
                b.b();
                return;
            }
            catch (IOException ioexception)
            {
                gd.a(3, al.e(), (new StringBuilder()).append("Exception closing editor for cache: ").append(al.a(a)).toString(), ioexception);
            }
            return;
        }
        b.a();
        return;
    }

    protected void finalize()
    {
        super.finalize();
        close();
    }

    private (al al1,  , boolean flag)
    {
        a = al1;
        super();
        if ( == null)
        {
            throw new IllegalArgumentException("Editor cannot be null");
        }
        b = ;
        c = b.a(0);
        if (c == null)
        {
            throw new IOException("Editor outputstream is null");
        }
        if (flag)
        {
            d = new GZIPOutputStream(c);
            if (d == null)
            {
                throw new IOException("Gzip outputstream is null");
            } else
            {
                e = new <init>(d, null);
                return;
            }
        } else
        {
            d = null;
            e = new <init>(c, null);
            return;
        }
    }

    (al al1,  , boolean flag,  1)
    {
        this(al1, , flag);
    }
}
