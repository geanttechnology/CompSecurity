// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exv extends eug
{

    private int A;
    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private exw f;
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
    private double r;
    private boolean s;
    private double t;
    private boolean u;
    private double v;
    private boolean w;
    private int x;
    private boolean y;
    private int z;

    public exv()
    {
        b = "";
        d = "";
        f = null;
        h = false;
        j = "";
        l = "";
        n = 0;
        p = "";
        r = 0.0D;
        t = 0.0D;
        v = 0.0D;
        x = 4;
        z = 1024;
        A = -1;
    }

    public final int a()
    {
        if (A < 0)
        {
            b();
        }
        return A;
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
                String s3 = eud1.i();
                i = true;
                j = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 40: // '('
                int j1 = eud1.f();
                m = true;
                n = j1;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                o = true;
                p = s5;
                break;

            case 57: // '9'
                double d1 = eud1.b();
                q = true;
                r = d1;
                break;

            case 65: // 'A'
                double d2 = eud1.b();
                s = true;
                t = d2;
                break;

            case 73: // 'I'
                double d3 = eud1.b();
                u = true;
                v = d3;
                break;

            case 80: // 'P'
                int k1 = eud1.f();
                w = true;
                x = k1;
                break;

            case 88: // 'X'
                int l1 = eud1.f();
                y = true;
                z = l1;
                break;

            case 96: // '`'
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 106: // 'j'
                exw exw1 = new exw();
                eud1.a(exw1);
                e = true;
                f = exw1;
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
        if (i)
        {
            eue1.a(3, j);
        }
        if (k)
        {
            eue1.a(4, l);
        }
        if (m)
        {
            eue1.a(5, n);
        }
        if (o)
        {
            eue1.a(6, p);
        }
        if (q)
        {
            eue1.a(7, r);
        }
        if (s)
        {
            eue1.a(8, t);
        }
        if (u)
        {
            eue1.a(9, v);
        }
        if (w)
        {
            eue1.a(10, x);
        }
        if (y)
        {
            eue1.a(11, z);
        }
        if (g)
        {
            eue1.a(12, h);
        }
        if (e)
        {
            eue1.b(13, f);
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
        if (i)
        {
            j1 = i1 + eue.b(3, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(4, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(5, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(6, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(7, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(8, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(9, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(10, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.d(11, z);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(12, h);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(13, f);
        }
        A = j1;
        return j1;
    }
}
