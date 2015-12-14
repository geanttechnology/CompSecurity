// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.InputStream;

public final class zo
    implements Closeable
{

    final zj a;
    private final String b;
    private final long c;
    private final InputStream d[];

    private zo(zj zj1, String s, long l, InputStream ainputstream[])
    {
        a = zj1;
        super();
        b = s;
        c = l;
        d = ainputstream;
    }

    zo(zj zj1, String s, long l, InputStream ainputstream[], zk zk)
    {
        this(zj1, s, l, ainputstream);
    }

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
            zj.a(ainputstream[i]);
        }

    }
}
