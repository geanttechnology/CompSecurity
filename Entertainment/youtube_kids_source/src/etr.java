// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class etr extends eug
{

    private boolean a;
    private enh b;
    private boolean c;
    private eni d;
    private boolean e;
    private eng f;
    private boolean g;
    private enf h;
    private boolean i;
    private ene j;
    private boolean k;
    private enj l;
    private int m;

    public etr()
    {
        b = null;
        d = null;
        f = null;
        h = null;
        j = null;
        l = null;
        m = -1;
    }

    public final int a()
    {
        if (m < 0)
        {
            b();
        }
        return m;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                enh enh1 = new enh();
                eud1.a(enh1);
                a = true;
                b = enh1;
                break;

            case 18: // '\022'
                eni eni1 = new eni();
                eud1.a(eni1);
                c = true;
                d = eni1;
                break;

            case 26: // '\032'
                eng eng1 = new eng();
                eud1.a(eng1);
                e = true;
                f = eng1;
                break;

            case 34: // '"'
                enf enf1 = new enf();
                eud1.a(enf1);
                g = true;
                h = enf1;
                break;

            case 42: // '*'
                ene ene1 = new ene();
                eud1.a(ene1);
                i = true;
                j = ene1;
                break;

            case 50: // '2'
                enj enj1 = new enj();
                eud1.a(enj1);
                k = true;
                l = enj1;
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
        if (i)
        {
            eue1.b(5, j);
        }
        if (k)
        {
            eue1.b(6, l);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        m = i1;
        return i1;
    }
}
