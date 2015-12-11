// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class elp extends elx
{

    private final ByteBuffer a;
    private final int b;
    private final int c;

    protected elp(int i)
    {
        this(i, i);
    }

    private elp(int i, int j)
    {
        boolean flag;
        if (j % i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag);
        a = ByteBuffer.allocate(j + 7).order(ByteOrder.LITTLE_ENDIAN);
        b = j;
        c = i;
    }

    private void c()
    {
        a.flip();
        for (; a.remaining() >= c; a(a)) { }
        a.compact();
    }

    public final els a()
    {
        c();
        a.flip();
        if (a.remaining() > 0)
        {
            b(a);
        }
        return b();
    }

    protected abstract void a(ByteBuffer bytebuffer);

    abstract els b();

    public final elx b(byte abyte0[], int i, int j)
    {
        i = 0;
        abyte0 = ByteBuffer.wrap(abyte0, 0, j).order(ByteOrder.LITTLE_ENDIAN);
        if (abyte0.remaining() <= a.remaining())
        {
            a.put(abyte0);
            if (a.remaining() < 8)
            {
                c();
            }
            return this;
        }
        j = b;
        for (int k = a.position(); i < j - k; i++)
        {
            a.put(abyte0.get());
        }

        c();
        for (; abyte0.remaining() >= c; a(abyte0)) { }
        a.put(abyte0);
        return this;
    }

    protected void b(ByteBuffer bytebuffer)
    {
        bytebuffer.position(bytebuffer.limit());
        bytebuffer.limit(c + 7);
        for (; bytebuffer.position() < c; bytebuffer.putLong(0L)) { }
        bytebuffer.limit(c);
        bytebuffer.flip();
        a(bytebuffer);
    }
}
