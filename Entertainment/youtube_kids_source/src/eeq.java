// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eeq extends eug
{

    private boolean a;
    private long b;
    private boolean c;
    private efb d;
    private boolean e;
    private eeo f;
    private boolean g;
    private eew h;
    private int i;

    public eeq()
    {
        b = 0L;
        d = null;
        f = null;
        h = null;
        i = -1;
    }

    public final int a()
    {
        if (i < 0)
        {
            b();
        }
        return i;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int j = eud1.a();
            switch (j)
            {
            default:
                if (a(eud1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                long l = eud1.e();
                a = true;
                b = l;
                break;

            case 18: // '\022'
                efb efb1 = new efb();
                eud1.a(efb1);
                c = true;
                d = efb1;
                break;

            case 26: // '\032'
                eeo eeo1 = new eeo();
                eud1.a(eeo1);
                e = true;
                f = eeo1;
                break;

            case 34: // '"'
                eew eew1 = new eew();
                eud1.a(eew1);
                g = true;
                h = eew1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(1, b);
        }
        if (c)
        {
            eue1.b(2, d);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
    }

    public final int b()
    {
        int k = 0;
        if (a)
        {
            k = eue.e(1, b) + 0;
        }
        int j = k;
        if (c)
        {
            j = k + eue.d(2, d);
        }
        k = j;
        if (e)
        {
            k = j + eue.d(3, f);
        }
        j = k;
        if (g)
        {
            j = k + eue.d(4, h);
        }
        i = j;
        return j;
    }
}
