// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class esu extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private ese h;
    private boolean i;
    private esm j;
    private boolean k;
    private esj l;
    private boolean m;
    private esg n;
    private boolean o;
    private esf p;
    private boolean q;
    private esf r;
    private boolean s;
    private esf t;
    private int u;

    public esu()
    {
        b = "";
        d = "";
        f = "";
        h = null;
        j = null;
        l = null;
        n = null;
        p = null;
        r = null;
        t = null;
        u = -1;
    }

    public final int a()
    {
        if (u < 0)
        {
            b();
        }
        return u;
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
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 18: // '\022'
                esm esm1 = new esm();
                eud1.a(esm1);
                i = true;
                j = esm1;
                break;

            case 26: // '\032'
                esj esj1 = new esj();
                eud1.a(esj1);
                k = true;
                l = esj1;
                break;

            case 34: // '"'
                esg esg1 = new esg();
                eud1.a(esg1);
                m = true;
                n = esg1;
                break;

            case 42: // '*'
                esf esf1 = new esf();
                eud1.a(esf1);
                o = true;
                p = esf1;
                break;

            case 50: // '2'
                esf esf2 = new esf();
                eud1.a(esf2);
                q = true;
                r = esf2;
                break;

            case 58: // ':'
                esf esf3 = new esf();
                eud1.a(esf3);
                s = true;
                t = esf3;
                break;

            case 66: // 'B'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 74: // 'J'
                ese ese1 = new ese();
                eud1.a(ese1);
                g = true;
                h = ese1;
                break;

            case 82: // 'R'
                String s3 = eud1.i();
                c = true;
                d = s3;
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
        if (i)
        {
            eue1.b(2, j);
        }
        if (k)
        {
            eue1.b(3, l);
        }
        if (m)
        {
            eue1.b(4, n);
        }
        if (o)
        {
            eue1.b(5, p);
        }
        if (q)
        {
            eue1.b(6, r);
        }
        if (s)
        {
            eue1.b(7, t);
        }
        if (e)
        {
            eue1.a(8, f);
        }
        if (g)
        {
            eue1.b(9, h);
        }
        if (c)
        {
            eue1.a(10, d);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (i)
        {
            i1 = j1 + eue.d(2, j);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(3, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(4, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(5, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(6, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(7, t);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(8, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(9, h);
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(10, d);
        }
        u = i1;
        return i1;
    }
}
