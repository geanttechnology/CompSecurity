// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqx extends eug
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
    private String n;
    private boolean o;
    private String p;
    private int q;

    public eqx()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        n = "";
        p = "";
        q = -1;
    }

    public final int a()
    {
        if (q < 0)
        {
            b();
        }
        return q;
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 34: // '"'
                String s3 = eud1.i();
                k = true;
                l = s3;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                e = true;
                f = s4;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                g = true;
                h = s5;
                break;

            case 58: // ':'
                String s6 = eud1.i();
                m = true;
                n = s6;
                break;

            case 66: // 'B'
                String s7 = eud1.i();
                o = true;
                p = s7;
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
        if (e)
        {
            eue1.a(5, f);
        }
        if (g)
        {
            eue1.a(6, h);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
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
        if (e)
        {
            j1 = i1 + eue.b(5, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(6, h);
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
        q = i1;
        return i1;
    }
}
