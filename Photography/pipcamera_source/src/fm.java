// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Closeable;
import java.io.InputStream;

public final class fm
    implements Closeable
{

    final fi a;
    private final String b;
    private final long c;
    private final InputStream d[];

    private fm(fi fi1, String s, long l, InputStream ainputstream[])
    {
        a = fi1;
        super();
        b = s;
        c = l;
        d = ainputstream;
    }

    fm(fi fi1, String s, long l, InputStream ainputstream[], fi._cls1 _pcls1)
    {
        this(fi1, s, l, ainputstream);
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
            fi.a(ainputstream[i]);
        }

    }
}
