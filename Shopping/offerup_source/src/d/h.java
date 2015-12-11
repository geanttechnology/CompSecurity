// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.io.InputStream;

// Referenced classes of package d:
//            f

final class h extends InputStream
{

    private f a;

    h(f f1)
    {
        a = f1;
        super();
    }

    public final int available()
    {
        return (int)Math.min(a.b, 0x7fffffffL);
    }

    public final void close()
    {
    }

    public final int read()
    {
        if (a.b > 0L)
        {
            return a.g() & 0xff;
        } else
        {
            return -1;
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        return a.a(abyte0, i, j);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a).append(".inputStream()").toString();
    }
}
