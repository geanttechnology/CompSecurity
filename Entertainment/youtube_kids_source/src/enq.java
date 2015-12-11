// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class enq extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private eub d;
    private boolean e;
    private String f;
    private boolean g;
    private enk h;
    private boolean i;
    private eor j;
    private boolean k;
    private enn l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private efp r;
    private boolean s;
    private efw t;
    private boolean u;
    private eob v;
    private boolean w;
    private int x;
    private int y;

    public enq()
    {
        b = "";
        d = null;
        f = "";
        h = null;
        j = null;
        l = null;
        n = "";
        p = "";
        r = null;
        t = null;
        v = null;
        x = 0;
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

            case 10: // '\n'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 18: // '\022'
                eub eub1 = new eub();
                eud1.a(eub1);
                c = true;
                d = eub1;
                break;

            case 26: // '\032'
                enk enk1 = new enk();
                eud1.a(enk1);
                g = true;
                h = enk1;
                break;

            case 34: // '"'
                eor eor1 = new eor();
                eud1.a(eor1);
                i = true;
                j = eor1;
                break;

            case 42: // '*'
                String s2 = eud1.i();
                m = true;
                n = s2;
                break;

            case 50: // '2'
                enn enn1 = new enn();
                eud1.a(enn1);
                k = true;
                l = enn1;
                break;

            case 58: // ':'
                String s3 = eud1.i();
                o = true;
                p = s3;
                break;

            case 66: // 'B'
                efp efp1 = new efp();
                eud1.a(efp1);
                q = true;
                r = efp1;
                break;

            case 74: // 'J'
                String s4 = eud1.i();
                e = true;
                f = s4;
                break;

            case 80: // 'P'
                int j1 = eud1.f();
                w = true;
                x = j1;
                break;

            case 90: // 'Z'
                efw efw1 = new efw();
                eud1.a(efw1);
                s = true;
                t = efw1;
                break;

            case 98: // 'b'
                eob eob1 = new eob();
                eud1.a(eob1);
                u = true;
                v = eob1;
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
            eue1.b(2, d);
        }
        if (g)
        {
            eue1.b(3, h);
        }
        if (i)
        {
            eue1.b(4, j);
        }
        if (m)
        {
            eue1.a(5, n);
        }
        if (k)
        {
            eue1.b(6, l);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (q)
        {
            eue1.b(8, r);
        }
        if (e)
        {
            eue1.a(9, f);
        }
        if (w)
        {
            eue1.a(10, x);
        }
        if (s)
        {
            eue1.b(11, t);
        }
        if (u)
        {
            eue1.b(12, v);
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
        if (g)
        {
            j1 = i1 + eue.d(3, h);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.d(4, j);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(5, n);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(7, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(8, r);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(9, f);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(10, x);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(11, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.d(12, v);
        }
        y = i1;
        return i1;
    }
}
