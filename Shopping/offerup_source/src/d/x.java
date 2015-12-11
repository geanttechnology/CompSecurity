// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package d:
//            w, f, ab, ae

final class x extends InputStream
{

    private w a;

    x(w w1)
    {
        a = w1;
        super();
    }

    public final int available()
    {
        if (w.a(a))
        {
            throw new IOException("closed");
        } else
        {
            return (int)Math.min(a.a.b, 0x7fffffffL);
        }
    }

    public final void close()
    {
        a.close();
    }

    public final int read()
    {
        if (w.a(a))
        {
            throw new IOException("closed");
        }
        if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return a.a.g() & 0xff;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (w.a(a))
        {
            throw new IOException("closed");
        }
        ae.a(abyte0.length, i, j);
        if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return a.a.a(abyte0, i, j);
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(".inputStream()").toString();
    }
}
