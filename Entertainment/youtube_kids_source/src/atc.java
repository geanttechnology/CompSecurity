// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class atc
    implements ars
{

    private final ars a;
    private final byte b[];
    private final byte c[];
    private ate d;

    public atc(byte abyte0[], byte abyte1[], ars ars1)
    {
        a = ars1;
        b = abyte0;
        c = abyte1;
    }

    public final ars a(arx arx1)
    {
        a.a(arx1);
        long l = a.b(arx1.f);
        d = new ate(1, b, l, arx1.c);
        return this;
    }

    public final void a()
    {
        d = null;
        a.a();
    }

    public final void a(byte abyte0[], int i, int j)
    {
        if (c == null)
        {
            d.a(abyte0, i, j);
            a.a(abyte0, i, j);
        } else
        {
            int k = 0;
            while (k < j) 
            {
                int l = Math.min(j - k, c.length);
                d.a(abyte0, i + k, l, c, 0);
                a.a(c, 0, l);
                k += l;
            }
        }
    }
}
