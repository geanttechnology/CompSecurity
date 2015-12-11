// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eey extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private een n;
    private boolean o;
    private int p;
    private boolean q;
    private ett r;
    private int s;

    public eey()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        n = null;
        p = 0;
        r = null;
        s = -1;
    }

    public final int a()
    {
        if (s < 0)
        {
            b();
        }
        return s;
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
                e = true;
                f = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                g = true;
                h = s4;
                break;

            case 42: // '*'
                String s5 = eud1.i();
                i = true;
                j = s5;
                break;

            case 50: // '2'
                een een1 = new een();
                eud1.a(een1);
                m = true;
                n = een1;
                break;

            case 56: // '8'
                int j1 = eud1.f();
                o = true;
                p = j1;
                break;

            case 82: // 'R'
                ett ett1 = new ett();
                eud1.a(ett1);
                q = true;
                r = ett1;
                break;

            case 90: // 'Z'
                String s6 = eud1.i();
                k = true;
                l = s6;
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
        if (m)
        {
            eue1.b(6, n);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (q)
        {
            eue1.b(10, r);
        }
        if (k)
        {
            eue1.a(11, l);
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
        if (q)
        {
            i1 = j1 + eue.d(10, r);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(11, l);
        }
        s = j1;
        return j1;
    }
}
