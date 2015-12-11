// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bbr
{

    private final byte a[];
    private final int b;
    private int c;

    private bbr(byte abyte0[], int i, int j)
    {
        a = abyte0;
        c = i;
        b = i + j;
    }

    public static bbr a(byte abyte0[])
    {
        return new bbr(abyte0, 0, abyte0.length);
    }

    private void a(int i)
    {
        byte byte0 = (byte)i;
        if (c == b)
        {
            throw new asc(c, b);
        } else
        {
            byte abyte0[] = a;
            i = c;
            c = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    private void a(int i, int j)
    {
        b(bbv.a(i, j));
    }

    private void b(int i)
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                a(i);
                return;
            }
            a(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public final int a()
    {
        return b - c;
    }

    public final void a(int i, long l)
    {
        a(i, 0);
        do
        {
            if ((-128L & l) == 0L)
            {
                a((int)l);
                return;
            }
            a((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public final void a(int i, String s)
    {
        a(i, 2);
        s = s.getBytes("UTF-8");
        b(s.length);
        i = s.length;
        if (b - c >= i)
        {
            System.arraycopy(s, 0, a, c, i);
            c = c + i;
            return;
        } else
        {
            throw new asc(c, b);
        }
    }
}
