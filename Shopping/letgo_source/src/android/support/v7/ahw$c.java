// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ahw, ahz

public final class <init>
    implements Closeable
{

    final ahw a;
    private final String b;
    private final long c;
    private File d[];
    private final InputStream e[];
    private final long f[];

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
            ahz.a(ainputstream[i]);
        }

    }

    private (ahw ahw1, String s, long l, File afile[], InputStream ainputstream[], long al[])
    {
        a = ahw1;
        super();
        b = s;
        c = l;
        d = afile;
        e = ainputstream;
        f = al;
    }

    f(ahw ahw1, String s, long l, File afile[], InputStream ainputstream[], long al[], 
            f f1)
    {
        this(ahw1, s, l, afile, ainputstream, al);
    }
}
