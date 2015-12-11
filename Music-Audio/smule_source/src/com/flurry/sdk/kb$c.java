// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.Closeable;
import java.io.InputStream;

// Referenced classes of package com.flurry.sdk:
//            kd, kb

public final class <init>
    implements Closeable
{

    final kb a;
    private final String b;
    private final long c;
    private final InputStream d[];
    private final long e[];

    public InputStream a(int i)
    {
        return d[i];
    }

    public void close()
    {
        InputStream ainputstream[] = d;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            kd.a(ainputstream[i]);
        }

    }

    private (kb kb, String s, long l, InputStream ainputstream[], long al[])
    {
        a = kb;
        super();
        b = s;
        c = l;
        d = ainputstream;
        e = al;
    }

    e(kb kb, String s, long l, InputStream ainputstream[], long al[], e e1)
    {
        this(kb, s, l, ainputstream, al);
    }
}
