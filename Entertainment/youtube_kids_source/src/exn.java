// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exn extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private boolean a;
    private euu b;
    private boolean c;
    private int d;
    private boolean e;
    private eur f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private boolean o;
    private float p;
    private boolean q;
    private exo r;
    private boolean s;
    private String t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public exn()
    {
        b = null;
        d = 1;
        f = null;
        h = false;
        j = false;
        l = false;
        n = 2;
        p = 0.0F;
        r = null;
        t = "";
        v = false;
        x = false;
        z = false;
        B = false;
        D = false;
        F = false;
        H = false;
        J = false;
        L = 0;
        N = false;
        O = -1;
    }

    public final int a()
    {
        if (O < 0)
        {
            b();
        }
        return O;
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
                euu euu1 = new euu();
                eud1.a(euu1);
                a(euu1);
                break;

            case 24: // '\030'
                a(eud1.f());
                break;

            case 34: // '"'
                eur eur1 = new eur();
                eud1.a(eur1);
                a(eur1);
                break;

            case 40: // '('
                a(eud1.h());
                break;

            case 48: // '0'
                boolean flag = eud1.h();
                k = true;
                l = flag;
                break;

            case 56: // '8'
                b(eud1.f());
                break;

            case 69: // 'E'
                float f1 = eud1.c();
                o = true;
                p = f1;
                break;

            case 74: // 'J'
                exo exo1 = new exo();
                eud1.a(exo1);
                q = true;
                r = exo1;
                break;

            case 82: // 'R'
                a(eud1.i());
                break;

            case 88: // 'X'
                boolean flag1 = eud1.h();
                u = true;
                v = flag1;
                break;

            case 96: // '`'
                boolean flag2 = eud1.h();
                w = true;
                x = flag2;
                break;

            case 104: // 'h'
                b(eud1.h());
                break;

            case 112: // 'p'
                c(eud1.h());
                break;

            case 120: // 'x'
                boolean flag3 = eud1.h();
                C = true;
                D = flag3;
                break;

            case 128: 
                d(eud1.h());
                break;

            case 136: 
                boolean flag4 = eud1.h();
                G = true;
                H = flag4;
                break;

            case 144: 
                boolean flag5 = eud1.h();
                I = true;
                J = flag5;
                break;

            case 152: 
                int j1 = eud1.f();
                K = true;
                L = j1;
                break;

            case 160: 
                e(eud1.h());
                break;

            case 168: 
                boolean flag6 = eud1.h();
                i = true;
                j = flag6;
                break;
            }
        } while (true);
    }

    public final exn a(int i1)
    {
        c = true;
        d = i1;
        return this;
    }

    public final exn a(eur eur1)
    {
        if (eur1 == null)
        {
            throw new NullPointerException();
        } else
        {
            e = true;
            f = eur1;
            return this;
        }
    }

    public final exn a(euu euu1)
    {
        if (euu1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = true;
            b = euu1;
            return this;
        }
    }

    public final exn a(String s1)
    {
        s = true;
        t = s1;
        return this;
    }

    public final exn a(boolean flag)
    {
        g = true;
        h = flag;
        return this;
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(1, b);
        }
        if (c)
        {
            eue1.a(3, d);
        }
        if (e)
        {
            eue1.b(4, f);
        }
        if (g)
        {
            eue1.a(5, h);
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
            eue1.b(9, r);
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
        if (G)
        {
            eue1.a(17, H);
        }
        if (I)
        {
            eue1.a(18, J);
        }
        if (K)
        {
            eue1.a(19, L);
        }
        if (M)
        {
            eue1.a(20, N);
        }
        if (i)
        {
            eue1.a(21, j);
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
            i1 = j1 + eue.d(3, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(4, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(5, h);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(6, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(7, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(8, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(9, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(10, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(11, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.b(12, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(13, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(14, B);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.b(15, D);
        }
        j1 = i1;
        if (E)
        {
            j1 = i1 + eue.b(16, F);
        }
        i1 = j1;
        if (G)
        {
            i1 = j1 + eue.b(17, H);
        }
        j1 = i1;
        if (I)
        {
            j1 = i1 + eue.b(18, J);
        }
        i1 = j1;
        if (K)
        {
            i1 = j1 + eue.d(19, L);
        }
        j1 = i1;
        if (M)
        {
            j1 = i1 + eue.b(20, N);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(21, j);
        }
        O = i1;
        return i1;
    }

    public final exn b(int i1)
    {
        m = true;
        n = i1;
        return this;
    }

    public final exn b(boolean flag)
    {
        y = true;
        z = flag;
        return this;
    }

    public final exn c(boolean flag)
    {
        A = true;
        B = flag;
        return this;
    }

    public final exn d(boolean flag)
    {
        E = true;
        F = flag;
        return this;
    }

    public final exn e(boolean flag)
    {
        M = true;
        N = flag;
        return this;
    }
}
