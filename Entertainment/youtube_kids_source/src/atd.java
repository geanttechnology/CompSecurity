// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class atd
    implements art
{

    private final art a;
    private final byte b[];
    private ate c;

    public atd(byte abyte0[], art art1)
    {
        a = art1;
        b = abyte0;
    }

    public final int a(byte abyte0[], int i, int j)
    {
        j = a.a(abyte0, i, j);
        if (j < 0)
        {
            return -1;
        } else
        {
            c.a(abyte0, i, j);
            return j;
        }
    }

    public final long a(arx arx1)
    {
        long l = a.a(arx1);
        long l1 = a.b(arx1.f);
        c = new ate(2, b, l1, arx1.c);
        return l;
    }

    public final void a()
    {
        c = null;
        a.a();
    }
}
