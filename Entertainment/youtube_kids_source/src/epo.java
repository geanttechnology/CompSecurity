// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epo extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private long f;
    private boolean g;
    private String h;
    private boolean i;
    private int j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private enz p;
    private boolean q;
    private eny r;
    private boolean s;
    private String t;
    private int u;

    public epo()
    {
        b = "";
        d = 0;
        f = 0L;
        h = "";
        j = 0;
        l = "";
        n = "";
        p = null;
        r = null;
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

            case 16: // '\020'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 24: // '\030'
                long l1 = eud1.e();
                e = true;
                f = l1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                g = true;
                h = s2;
                break;

            case 40: // '('
                int k1 = eud1.f();
                i = true;
                j = k1;
                break;

            case 50: // '2'
                String s3 = eud1.i();
                k = true;
                l = s3;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                m = true;
                n = s4;
                break;

            case 66: // 'B'
                enz enz1 = new enz();
                eud1.a(enz1);
                o = true;
                p = enz1;
                break;

            case 74: // 'J'
                eny eny1 = new eny();
                eud1.a(eny1);
                q = true;
                r = eny1;
                break;

            case 82: // 'R'
                String s5 = eud1.i();
                s = true;
                t = s5;
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
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.b(8, p);
        }
        if (q)
        {
            eue1.b(9, r);
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
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.e(3, f);
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
            j1 = i1 + eue.b(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(9, r);
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
