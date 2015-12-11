// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqg extends eug
{

    private boolean A;
    private eqq B;
    private boolean C;
    private ety D;
    private boolean E;
    private eqp F;
    private int G;
    private boolean a;
    private String b;
    private boolean c;
    private eqi d;
    private boolean e;
    private eqi f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private eqh n;
    private boolean o;
    private int p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private eqn v;
    private boolean w;
    private eqo x;
    private boolean y;
    private eta z;

    public eqg()
    {
        b = "";
        d = null;
        f = null;
        h = false;
        j = 0;
        l = 0;
        n = null;
        p = 0;
        r = "";
        t = "";
        v = null;
        x = null;
        z = null;
        B = null;
        D = null;
        F = null;
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

            case 10: // '\n'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 18: // '\022'
                eqi eqi1 = new eqi();
                eud1.a(eqi1);
                c = true;
                d = eqi1;
                break;

            case 26: // '\032'
                eqi eqi2 = new eqi();
                eud1.a(eqi2);
                e = true;
                f = eqi2;
                break;

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 40: // '('
                int j1 = eud1.f();
                k = true;
                l = j1;
                break;

            case 50: // '2'
                eqh eqh1 = new eqh();
                eud1.a(eqh1);
                m = true;
                n = eqh1;
                break;

            case 56: // '8'
                int k1 = eud1.f();
                o = true;
                p = k1;
                break;

            case 66: // 'B'
                eqn eqn1 = new eqn();
                eud1.a(eqn1);
                u = true;
                v = eqn1;
                break;

            case 82: // 'R'
                eqo eqo1 = new eqo();
                eud1.a(eqo1);
                w = true;
                x = eqo1;
                break;

            case 90: // 'Z'
                eta eta1 = new eta();
                eud1.a(eta1);
                y = true;
                z = eta1;
                break;

            case 98: // 'b'
                eqq eqq1 = new eqq();
                eud1.a(eqq1);
                A = true;
                B = eqq1;
                break;

            case 106: // 'j'
                ety ety1 = new ety();
                eud1.a(ety1);
                C = true;
                D = ety1;
                break;

            case 112: // 'p'
                int l1 = eud1.f();
                i = true;
                j = l1;
                break;

            case 122: // 'z'
                String s2 = eud1.i();
                q = true;
                r = s2;
                break;

            case 130: 
                String s3 = eud1.i();
                s = true;
                t = s3;
                break;

            case 138: 
                eqp eqp1 = new eqp();
                eud1.a(eqp1);
                E = true;
                F = eqp1;
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
        if (e)
        {
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (k)
        {
            eue1.a(5, l);
        }
        if (m)
        {
            eue1.b(6, n);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (u)
        {
            eue1.b(8, v);
        }
        if (w)
        {
            eue1.b(10, x);
        }
        if (y)
        {
            eue1.b(11, z);
        }
        if (A)
        {
            eue1.b(12, B);
        }
        if (C)
        {
            eue1.b(13, D);
        }
        if (i)
        {
            eue1.a(14, j);
        }
        if (q)
        {
            eue1.a(15, r);
        }
        if (s)
        {
            eue1.a(16, t);
        }
        if (E)
        {
            eue1.b(17, F);
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
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(5, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(6, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(7, p);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.d(8, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(10, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.d(11, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.d(12, B);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.d(13, D);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(14, j);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(15, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(16, t);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(17, F);
        }
        G = i1;
        return i1;
    }
}
