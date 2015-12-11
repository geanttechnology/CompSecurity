// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.a.a.a:
//            u, c

public final class i
    implements Closeable
{

    public final String a;
    public final long b;
    public final InputStream c[];
    public final c d;
    private final long e[];

    private i(c c1, String s, long l, InputStream ainputstream[], long al[])
    {
        d = c1;
        super();
        a = s;
        b = l;
        c = ainputstream;
        e = al;
    }

    i(c c1, String s, long l, InputStream ainputstream[], long al[], byte byte0)
    {
        this(c1, s, l, ainputstream, al);
    }

    public final void close()
    {
        InputStream ainputstream[] = c;
        int k = ainputstream.length;
        for (int j = 0; j < k; j++)
        {
            u.a(ainputstream[j]);
        }

    }
}
