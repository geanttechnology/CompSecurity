// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class erp extends eug
{

    private boolean a;
    private esw b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private int i;

    public erp()
    {
        b = null;
        d = 0;
        f = 0;
        h = 0;
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
                esw esw1 = new esw();
                eud1.a(esw1);
                a = true;
                b = esw1;
                break;

            case 16: // '\020'
                int k = eud1.f();
                c = true;
                d = k;
                break;

            case 24: // '\030'
                int l = eud1.f();
                e = true;
                f = l;
                break;

            case 32: // ' '
                int i1 = eud1.f();
                g = true;
                h = i1;
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
            eue1.a(2, d);
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
            j = k + eue.d(4, h);
        }
        i = j;
        return j;
    }
}
