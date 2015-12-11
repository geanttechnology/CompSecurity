// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eoq extends eug
{

    private boolean a;
    private double b;
    private boolean c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private double h;
    private boolean i;
    private double j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private eqe x;
    private int y;

    public eoq()
    {
        b = 0.0D;
        d = 0.0D;
        f = 0.0D;
        h = 0.0D;
        j = 0.0D;
        l = "";
        n = "";
        p = "";
        r = "";
        t = "";
        v = "";
        x = null;
        y = -1;
    }

    public final int a()
    {
        if (y < 0)
        {
            b();
        }
        return y;
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

            case 9: // '\t'
                double d1 = eud1.b();
                a = true;
                b = d1;
                break;

            case 17: // '\021'
                double d2 = eud1.b();
                c = true;
                d = d2;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                k = true;
                l = s1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                o = true;
                p = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                q = true;
                r = s3;
                break;

            case 50: // '2'
                String s4 = eud1.i();
                m = true;
                n = s4;
                break;

            case 58: // ':'
                String s5 = eud1.i();
                u = true;
                v = s5;
                break;

            case 65: // 'A'
                double d3 = eud1.b();
                e = true;
                f = d3;
                break;

            case 73: // 'I'
                double d4 = eud1.b();
                g = true;
                h = d4;
                break;

            case 82: // 'R'
                eqe eqe1 = new eqe();
                eud1.a(eqe1);
                w = true;
                x = eqe1;
                break;

            case 90: // 'Z'
                String s6 = eud1.i();
                s = true;
                t = s6;
                break;

            case 97: // 'a'
                double d5 = eud1.b();
                i = true;
                j = d5;
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
        if (k)
        {
            eue1.a(3, l);
        }
        if (o)
        {
            eue1.a(4, p);
        }
        if (q)
        {
            eue1.a(5, r);
        }
        if (m)
        {
            eue1.a(6, n);
        }
        if (u)
        {
            eue1.a(7, v);
        }
        if (e)
        {
            eue1.a(8, f);
        }
        if (g)
        {
            eue1.a(9, h);
        }
        if (w)
        {
            eue1.b(10, x);
        }
        if (s)
        {
            eue1.a(11, t);
        }
        if (i)
        {
            eue1.a(12, j);
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
        if (k)
        {
            j1 = i1 + eue.b(3, l);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(4, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(5, r);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(6, n);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(7, v);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(8, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(9, h);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(10, x);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(11, t);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(12, j);
        }
        y = i1;
        return i1;
    }
}
