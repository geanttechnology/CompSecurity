// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class era extends eug
{

    private boolean a;
    private ert b;
    private boolean c;
    private ere d;
    private boolean e;
    private erf f;
    private int g;

    public era()
    {
        b = null;
        d = null;
        f = null;
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i = eud1.a();
            switch (i)
            {
            default:
                if (a(eud1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                ert ert1 = new ert();
                eud1.a(ert1);
                a = true;
                b = ert1;
                break;

            case 18: // '\022'
                ere ere1 = new ere();
                eud1.a(ere1);
                c = true;
                d = ere1;
                break;

            case 26: // '\032'
                erf erf1 = new erf();
                eud1.a(erf1);
                e = true;
                f = erf1;
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
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.d(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.d(2, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.d(3, f);
        }
        g = j;
        return j;
    }
}
