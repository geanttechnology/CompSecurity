// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ah;

import com.bumptech.glide.load.DataSource;

// Referenced classes of package myobfuscated.ah:
//            g, h, j, c, 
//            b, e

public final class a
    implements g
{

    private final h a;
    private final int b;
    private b c;
    private b d;

    public a()
    {
        this((byte)0);
    }

    private a(byte byte0)
    {
        this(new h(new j(300)), 300);
    }

    private a(h h1, int i)
    {
        a = h1;
        b = 300;
    }

    public final e a(DataSource datasource, boolean flag)
    {
        if (datasource == DataSource.MEMORY_CACHE)
        {
            return myobfuscated.ah.c.b();
        }
        if (flag)
        {
            if (c == null)
            {
                c = new b(a.a(datasource, true), b);
            }
            return c;
        }
        if (d == null)
        {
            d = new b(a.a(datasource, false), b);
        }
        return d;
    }
}
