// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exb extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private String d;
    private boolean e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private int n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private int u;

    public exb()
    {
        b = 1;
        d = "";
        f = 0;
        h = false;
        j = "ZZ";
        l = "";
        n = 0;
        p = "";
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

            case 8: // '\b'
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 24: // '\030'
                int k1 = eud1.f();
                e = true;
                f = k1;
                break;

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 42: // '*'
                String s2 = eud1.i();
                q = true;
                r = s2;
                break;

            case 50: // '2'
                String s3 = eud1.i();
                s = true;
                t = s3;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 64: // '@'
                int l1 = eud1.f();
                m = true;
                n = l1;
                break;

            case 74: // 'J'
                String s5 = eud1.i();
                o = true;
                p = s5;
                break;

            case 82: // 'R'
                String s6 = eud1.i();
                i = true;
                j = s6;
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
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (q)
        {
            eue1.a(5, r);
        }
        if (s)
        {
            eue1.a(6, t);
        }
        if (k)
        {
            eue1.a(7, l);
        }
        if (m)
        {
            eue1.a(8, n);
        }
        if (o)
        {
            eue1.a(9, p);
        }
        if (i)
        {
            eue1.a(10, j);
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
        if (q)
        {
            j1 = i1 + eue.b(5, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(6, t);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(7, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(8, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(9, p);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(10, j);
        }
        u = i1;
        return i1;
    }
}
