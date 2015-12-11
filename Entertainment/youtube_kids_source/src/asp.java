// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class asp
    implements art
{

    private final art a;
    private final ars b;

    public asp(art art1, ars ars1)
    {
        a = (art)a.b(art1);
        b = (ars)a.b(ars1);
    }

    public final int a(byte abyte0[], int i, int j)
    {
        j = a.a(abyte0, i, j);
        if (j > 0)
        {
            b.a(abyte0, i, j);
        }
        return j;
    }

    public final long a(arx arx1)
    {
        long l = a.a(arx1);
        arx arx2 = arx1;
        if (arx1.e == -1L)
        {
            arx2 = arx1;
            if (l != -1L)
            {
                arx2 = new arx(arx1.a, arx1.c, l, arx1.f, arx1.d, arx1.b);
            }
        }
        b.a(arx2);
        return l;
    }

    public final void a()
    {
        a.a();
        b.a();
    }
}
