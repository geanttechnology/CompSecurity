// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class esv extends eug
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
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private ese p;
    private boolean q;
    private esg r;
    private int s;

    public esv()
    {
        b = "";
        d = "";
        f = "";
        h = null;
        j = "";
        l = "";
        n = "";
        p = null;
        r = null;
        s = -1;
    }

    public final int a()
    {
        if (s < 0)
        {
            b();
        }
        return s;
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
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 26: // '\032'
                esg esg1 = new esg();
                eud1.a(esg1);
                q = true;
                r = esg1;
                break;

            case 34: // '"'
                String s3 = eud1.i();
                e = true;
                f = s3;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                m = true;
                n = s4;
                break;

            case 50: // '2'
                ese ese1 = new ese();
                eud1.a(ese1);
                g = true;
                h = ese1;
                break;

            case 58: // ':'
                ese ese2 = new ese();
                eud1.a(ese2);
                o = true;
                p = ese2;
                break;

            case 66: // 'B'
                String s5 = eud1.i();
                c = true;
                d = s5;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                k = true;
                l = s6;
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
            eue1.a(2, j);
        }
        if (q)
        {
            eue1.b(3, r);
        }
        if (e)
        {
            eue1.a(4, f);
        }
        if (m)
        {
            eue1.a(5, n);
        }
        if (g)
        {
            eue1.b(6, h);
        }
        if (o)
        {
            eue1.b(7, p);
        }
        if (c)
        {
            eue1.a(8, d);
        }
        if (k)
        {
            eue1.a(9, l);
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
            i1 = j1 + eue.b(2, j);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(3, r);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(4, f);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(5, n);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(6, h);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(7, p);
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(8, d);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(9, l);
        }
        s = j1;
        return j1;
    }
}
