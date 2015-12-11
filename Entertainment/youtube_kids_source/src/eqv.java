// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqv extends eug
{

    private boolean a;
    private float b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private float h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private float n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private int u;

    public eqv()
    {
        b = 0.0F;
        d = "";
        f = "";
        h = 0.0F;
        j = "";
        l = "";
        n = 0.0F;
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

            case 13: // '\r'
                float f1 = eud1.c();
                a = true;
                b = f1;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 29: // '\035'
                float f2 = eud1.c();
                g = true;
                h = f2;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 45: // '-'
                float f3 = eud1.c();
                m = true;
                n = f3;
                break;

            case 50: // '2'
                String s3 = eud1.i();
                e = true;
                f = s3;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 66: // 'B'
                String s5 = eud1.i();
                s = true;
                t = s5;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                o = true;
                p = s6;
                break;

            case 82: // 'R'
                String s7 = eud1.i();
                q = true;
                r = s7;
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
        if (g)
        {
            eue1.a(3, h);
        }
        if (i)
        {
            eue1.a(4, j);
        }
        if (m)
        {
            eue1.a(5, n);
        }
        if (e)
        {
            eue1.a(6, f);
        }
        if (k)
        {
            eue1.a(7, l);
        }
        if (s)
        {
            eue1.a(8, t);
        }
        if (o)
        {
            eue1.a(9, p);
        }
        if (q)
        {
            eue1.a(10, r);
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
        if (g)
        {
            j1 = i1 + eue.b(3, h);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(4, j);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(5, n);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(6, f);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(7, l);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(8, t);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(9, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(10, r);
        }
        u = i1;
        return i1;
    }
}
