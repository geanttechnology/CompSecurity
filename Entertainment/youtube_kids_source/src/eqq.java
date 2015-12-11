// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqq extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private eqc f;
    private boolean g;
    private String h;
    private boolean i;
    private eqc j;
    private boolean k;
    private String l;
    private boolean m;
    private eqd n;
    private boolean o;
    private int p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private int u;

    public eqq()
    {
        b = "";
        d = "";
        f = null;
        h = "";
        j = null;
        l = "";
        n = null;
        p = 1;
        r = "";
        t = "";
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
                String s2 = eud1.i();
                c = true;
                d = s2;
                break;

            case 26: // '\032'
                eqc eqc1 = new eqc();
                eud1.a(eqc1);
                e = true;
                f = eqc1;
                break;

            case 34: // '"'
                String s3 = eud1.i();
                g = true;
                h = s3;
                break;

            case 42: // '*'
                eqc eqc2 = new eqc();
                eud1.a(eqc2);
                i = true;
                j = eqc2;
                break;

            case 50: // '2'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 58: // ':'
                eqd eqd1 = new eqd();
                eud1.a(eqd1);
                m = true;
                n = eqd1;
                break;

            case 64: // '@'
                int j1 = eud1.f();
                o = true;
                p = j1;
                break;

            case 74: // 'J'
                String s5 = eud1.i();
                q = true;
                r = s5;
                break;

            case 82: // 'R'
                String s6 = eud1.i();
                s = true;
                t = s6;
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
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.b(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.b(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (s)
        {
            eue1.a(10, t);
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
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(9, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(10, t);
        }
        u = i1;
        return i1;
    }
}
