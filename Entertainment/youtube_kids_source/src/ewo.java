// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewo extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private String D;
    private boolean E;
    private String F;
    private int G;
    public float a;
    private boolean b;
    private int c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private eur j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private float r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private String x;
    private boolean y;
    private boolean z;

    public ewo()
    {
        c = 0;
        a = 8000F;
        f = true;
        h = false;
        j = null;
        l = 0;
        n = true;
        p = 0;
        r = 0.0F;
        t = 1;
        v = false;
        x = "";
        z = false;
        B = false;
        D = "";
        F = "";
        G = -1;
    }

    public final int a()
    {
        if (G < 0)
        {
            b();
        }
        return G;
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
                a(eud1.f());
                break;

            case 21: // '\025'
                a(eud1.c());
                break;

            case 24: // '\030'
                a(eud1.h());
                break;

            case 32: // ' '
                b(eud1.h());
                break;

            case 42: // '*'
                eur eur1 = new eur();
                eud1.a(eur1);
                a(eur1);
                break;

            case 48: // '0'
                int j1 = eud1.f();
                k = true;
                l = j1;
                break;

            case 56: // '8'
                c(eud1.h());
                break;

            case 64: // '@'
                int k1 = eud1.f();
                o = true;
                p = k1;
                break;

            case 77: // 'M'
                float f1 = eud1.c();
                q = true;
                r = f1;
                break;

            case 80: // 'P'
                int l1 = eud1.f();
                s = true;
                t = l1;
                break;

            case 88: // 'X'
                boolean flag = eud1.h();
                u = true;
                v = flag;
                break;

            case 98: // 'b'
                String s1 = eud1.i();
                w = true;
                x = s1;
                break;

            case 104: // 'h'
                boolean flag1 = eud1.h();
                y = true;
                z = flag1;
                break;

            case 112: // 'p'
                boolean flag2 = eud1.h();
                A = true;
                B = flag2;
                break;

            case 122: // 'z'
                String s2 = eud1.i();
                C = true;
                D = s2;
                break;

            case 130: 
                String s3 = eud1.i();
                E = true;
                F = s3;
                break;
            }
        } while (true);
    }

    public final ewo a(float f1)
    {
        d = true;
        a = f1;
        return this;
    }

    public final ewo a(int i1)
    {
        b = true;
        c = i1;
        return this;
    }

    public final ewo a(eur eur1)
    {
        if (eur1 == null)
        {
            throw new NullPointerException();
        } else
        {
            i = true;
            j = eur1;
            return this;
        }
    }

    public final ewo a(boolean flag)
    {
        e = true;
        f = flag;
        return this;
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.a(1, c);
        }
        if (d)
        {
            eue1.a(2, a);
        }
        if (e)
        {
            eue1.a(3, f);
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
            eue1.a(7, n);
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
        if (u)
        {
            eue1.a(11, v);
        }
        if (w)
        {
            eue1.a(12, x);
        }
        if (y)
        {
            eue1.a(13, z);
        }
        if (A)
        {
            eue1.a(14, B);
        }
        if (C)
        {
            eue1.a(15, D);
        }
        if (E)
        {
            eue1.a(16, F);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (b)
        {
            j1 = eue.d(1, c) + 0;
        }
        int i1 = j1;
        if (d)
        {
            i1 = j1 + eue.b(2, a);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
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
            i1 = j1 + eue.d(6, l);
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
            j1 = i1 + eue.b(9, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.d(10, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(11, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(12, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.b(13, z);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.b(14, B);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.b(15, D);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.b(16, F);
        }
        G = i1;
        return i1;
    }

    public final ewo b(boolean flag)
    {
        g = true;
        h = flag;
        return this;
    }

    public final ewo c(boolean flag)
    {
        m = true;
        n = flag;
        return this;
    }
}
