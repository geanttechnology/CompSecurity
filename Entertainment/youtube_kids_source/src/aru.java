// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;

public final class aru extends InputStream
{

    private final art a;
    private final arx b;
    private final byte c[] = new byte[1];
    private boolean d;
    private boolean e;

    public aru(art art1, arx arx)
    {
        d = false;
        e = false;
        a = art1;
        b = arx;
    }

    private void a()
    {
        if (!d)
        {
            a.a(b);
            d = true;
        }
    }

    public final void close()
    {
        if (!e)
        {
            a.a();
            e = true;
        }
    }

    public final int read()
    {
        read(c);
        return c[0] & 0xff;
    }

    public final int read(byte abyte0[])
    {
        return read(abyte0, 0, abyte0.length);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        boolean flag;
        if (!e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        a();
        return a.a(abyte0, i, j);
    }

    public final long skip(long l)
    {
        boolean flag;
        if (!e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        a();
        return super.skip(l);
    }
}
