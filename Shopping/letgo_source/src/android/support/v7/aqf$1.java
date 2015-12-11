// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            aqf, apv

class t> extends OutputStream
{

    final aqf a;

    public void close()
        throws IOException
    {
        a.close();
    }

    public void flush()
        throws IOException
    {
        if (!aqf.a(a))
        {
            a.flush();
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(".outputStream()").toString();
    }

    public void write(int i)
        throws IOException
    {
        if (aqf.a(a))
        {
            throw new IOException("closed");
        } else
        {
            a.a.a((byte)i);
            a.v();
            return;
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (aqf.a(a))
        {
            throw new IOException("closed");
        } else
        {
            a.a.b(abyte0, i, j);
            a.v();
            return;
        }
    }

    (aqf aqf1)
    {
        a = aqf1;
        super();
    }
}
