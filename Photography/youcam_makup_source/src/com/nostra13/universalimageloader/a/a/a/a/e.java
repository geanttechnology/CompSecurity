// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            h, a

public final class e
    implements Closeable
{

    final a a;
    private final String b;
    private final long c;
    private File d[];
    private final InputStream e[];
    private final long f[];

    private e(a a1, String s, long l, File afile[], InputStream ainputstream[], long al[])
    {
        a = a1;
        super();
        b = s;
        c = l;
        d = afile;
        e = ainputstream;
        f = al;
    }

    e(a a1, String s, long l, File afile[], InputStream ainputstream[], long al[], 
            a._cls1 _pcls1)
    {
        this(a1, s, l, afile, ainputstream, al);
    }

    public File a(int i)
    {
        return d[i];
    }

    public void close()
    {
        InputStream ainputstream[] = e;
        int j = ainputstream.length;
        for (int i = 0; i < j; i++)
        {
            h.a(ainputstream[i]);
        }

    }
}
