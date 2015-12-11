// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            aqg, apv, aqk, aqm

class > extends InputStream
{

    final aqg a;

    public int available()
        throws IOException
    {
        if (aqg.a(a))
        {
            throw new IOException("closed");
        } else
        {
            return (int)Math.min(a.a.b, 0x7fffffffL);
        }
    }

    public void close()
        throws IOException
    {
        a.close();
    }

    public int read()
        throws IOException
    {
        if (aqg.a(a))
        {
            throw new IOException("closed");
        }
        if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return a.a.i() & 0xff;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (aqg.a(a))
        {
            throw new IOException("closed");
        }
        aqm.a(abyte0.length, i, j);
        if (a.a.b == 0L && a.b.read(a.a, 2048L) == -1L)
        {
            return -1;
        } else
        {
            return a.a.a(abyte0, i, j);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(".inputStream()").toString();
    }

    (aqg aqg1)
    {
        a = aqg1;
        super();
    }
}
