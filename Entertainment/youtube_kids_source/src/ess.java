// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ess extends eug
{

    private boolean A;
    private String B;
    private boolean C;
    private String D;
    private boolean E;
    private String F;
    private boolean G;
    private String H;
    private boolean I;
    private String J;
    private boolean K;
    private String L;
    private int M;
    private boolean a;
    private float b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private boolean g;
    private String h;
    private boolean i;
    private float j;
    private boolean k;
    private String l;
    private boolean m;
    private float n;
    private boolean o;
    private String p;
    private boolean q;
    private float r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private String x;
    private boolean y;
    private String z;

    public ess()
    {
        b = 0.0F;
        d = 0.0F;
        f = 0.0F;
        h = "";
        j = 0.0F;
        l = "";
        n = 0.0F;
        p = "";
        r = 0.0F;
        t = "";
        v = "";
        x = "";
        z = "";
        B = "";
        D = "";
        F = "";
        H = "";
        J = "";
        L = "";
        M = -1;
    }

    public final int a()
    {
        if (M < 0)
        {
            b();
        }
        return M;
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

            case 13: // '\r'
                float f1 = eud1.c();
                a = true;
                b = f1;
                break;

            case 21: // '\025'
                float f2 = eud1.c();
                c = true;
                d = f2;
                break;

            case 29: // '\035'
                float f3 = eud1.c();
                e = true;
                f = f3;
                break;

            case 34: // '"'
                String s1 = eud1.i();
                g = true;
                h = s1;
                break;

            case 45: // '-'
                float f4 = eud1.c();
                i = true;
                j = f4;
                break;

            case 50: // '2'
                String s2 = eud1.i();
                k = true;
                l = s2;
                break;

            case 61: // '='
                float f5 = eud1.c();
                m = true;
                n = f5;
                break;

            case 66: // 'B'
                String s3 = eud1.i();
                o = true;
                p = s3;
                break;

            case 77: // 'M'
                float f6 = eud1.c();
                q = true;
                r = f6;
                break;

            case 82: // 'R'
                String s4 = eud1.i();
                s = true;
                t = s4;
                break;

            case 90: // 'Z'
                String s5 = eud1.i();
                u = true;
                v = s5;
                break;

            case 98: // 'b'
                String s6 = eud1.i();
                w = true;
                x = s6;
                break;

            case 106: // 'j'
                String s7 = eud1.i();
                y = true;
                z = s7;
                break;

            case 114: // 'r'
                String s8 = eud1.i();
                A = true;
                B = s8;
                break;

            case 122: // 'z'
                String s9 = eud1.i();
                C = true;
                D = s9;
                break;

            case 130: 
                String s10 = eud1.i();
                E = true;
                F = s10;
                break;

            case 138: 
                String s11 = eud1.i();
                G = true;
                H = s11;
                break;

            case 146: 
                String s12 = eud1.i();
                I = true;
                J = s12;
                break;

            case 154: 
                String s13 = eud1.i();
                K = true;
                L = s13;
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
            j1 = i1 + eue.b(5, j);
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
            i1 = j1 + eue.b(8, p);
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
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.b(17, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.b(18, J);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.b(19, L);
        }
        M = j1;
        return j1;
    }
}
