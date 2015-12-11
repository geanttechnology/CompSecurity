// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eod extends eug
{

    private boolean a;
    private eoq b;
    private boolean c;
    private eoq d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private int i;

    public eod()
    {
        b = null;
        d = null;
        f = 0;
        h = "";
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

            case 10: // '\n'
                eoq eoq1 = new eoq();
                eud1.a(eoq1);
                a = true;
                b = eoq1;
                break;

            case 18: // '\022'
                eoq eoq2 = new eoq();
                eud1.a(eoq2);
                c = true;
                d = eoq2;
                break;

            case 24: // '\030'
                int k = eud1.f();
                e = true;
                f = k;
                break;

            case 34: // '"'
                String s = eud1.i();
                g = true;
                h = s;
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
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
    }

    public final int b()
    {
        int k = 0;
        if (a)
        {
            k = eue.d(1, b) + 0;
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
            j = k + eue.b(4, h);
        }
        i = j;
        return j;
    }
}
