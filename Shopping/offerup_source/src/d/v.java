// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package d:
//            u, f

final class v extends OutputStream
{

    private u a;

    v(u u1)
    {
        a = u1;
        super();
    }

    public final void close()
    {
        a.close();
    }

    public final void flush()
    {
        if (!u.a(a))
        {
            a.flush();
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(".outputStream()").toString();
    }

    public final void write(int i)
    {
        if (u.a(a))
        {
            throw new IOException("closed");
        } else
        {
            a.a.a((byte)i);
            a.r();
            return;
        }
    }

    public final void write(byte abyte0[], int i, int j)
    {
        if (u.a(a))
        {
            throw new IOException("closed");
        } else
        {
            a.a.b(abyte0, i, j);
            a.r();
            return;
        }
    }
}
