// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class etj extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private String d;
    private boolean e;
    private etp f;
    private boolean g;
    private etm h;
    private int i;

    public etj()
    {
        b = 0;
        d = "";
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
                int k = eud1.f();
                a = true;
                b = k;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 8002: 
                etp etp1 = new etp();
                eud1.a(etp1);
                e = true;
                f = etp1;
                break;

            case 8010: 
                etm etm1 = new etm();
                eud1.a(etm1);
                g = true;
                h = etm1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (c)
        {
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.b(1000, f);
        }
        if (g)
        {
            eue1.b(1001, h);
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
            j = k + eue.b(2, d);
        }
        k = j;
        if (e)
        {
            k = j + eue.d(1000, f);
        }
        j = k;
        if (g)
        {
            j = k + eue.d(1001, h);
        }
        i = j;
        return j;
    }
}
