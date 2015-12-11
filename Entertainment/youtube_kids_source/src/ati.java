// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ati
{

    public final byte a[];
    public int b;

    public ati(int i)
    {
        a = new byte[i];
    }

    public static int b(byte abyte0[], int i, int j)
    {
        int l = abyte0[i] & 0xff;
        for (int k = i + 1; k < i + j; k++)
        {
            l = l << 8 | abyte0[k] & 0xff;
        }

        return l;
    }

    private static long c(byte abyte0[], int i, int j)
    {
        long l = abyte0[i] & 0xff;
        for (int k = i + 1; k < i + j; k++)
        {
            l = l << 8 | (long)(abyte0[k] & 0xff);
        }

        return l;
    }

    public final int a()
    {
        int i = b(a, b, 1);
        b = b + 1;
        return i;
    }

    public final void a(int i)
    {
        boolean flag;
        if (i >= 0 && i <= a.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag);
        b = i;
    }

    public final void a(byte abyte0[], int i, int j)
    {
        System.arraycopy(a, b, abyte0, 0, j);
        b = b + j;
    }

    public final int b()
    {
        int i = b(a, b, 2);
        b = b + 2;
        return i;
    }

    public final void b(int i)
    {
        a(b + i);
    }

    public final long c()
    {
        long l = c(a, b, 4);
        b = b + 4;
        return l;
    }

    public final int d()
    {
        int i = b(a, b, 4);
        b = b + 4;
        return i;
    }

    public final long e()
    {
        long l = c(a, b, 8);
        b = b + 8;
        return l;
    }

    public final int f()
    {
        int i = b(a, b, 4);
        b = b + 4;
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder(29)).append("Top bit not zero: ").append(i).toString());
        } else
        {
            return i;
        }
    }

    public final long g()
    {
        long l = c(a, b, 8);
        b = b + 8;
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder(38)).append("Top bit not zero: ").append(l).toString());
        } else
        {
            return l;
        }
    }
}
