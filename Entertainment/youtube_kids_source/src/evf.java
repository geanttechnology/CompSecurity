// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class evf extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private float l;
    private boolean m;
    private float n;
    private boolean o;
    private evd p;
    private int q;

    public evf()
    {
        b = "";
        d = "";
        f = false;
        h = 0.0F;
        j = 0.0F;
        l = 0.0F;
        n = 0.0F;
        p = null;
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

            case 29: // '\035'
                float f1 = eud1.c();
                g = true;
                h = f1;
                break;

            case 37: // '%'
                float f2 = eud1.c();
                i = true;
                j = f2;
                break;

            case 45: // '-'
                float f3 = eud1.c();
                k = true;
                l = f3;
                break;

            case 53: // '5'
                float f4 = eud1.c();
                m = true;
                n = f4;
                break;

            case 56: // '8'
                boolean flag = eud1.h();
                e = true;
                f = flag;
                break;

            case 66: // 'B'
                evd evd1 = new evd();
                eud1.a(evd1);
                o = true;
                p = evd1;
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
        if (k)
        {
            eue1.a(5, l);
        }
        if (m)
        {
            eue1.a(6, n);
        }
        if (e)
        {
            eue1.a(7, f);
        }
        if (o)
        {
            eue1.b(8, p);
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
        if (k)
        {
            j1 = i1 + eue.b(5, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(6, n);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(7, f);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        q = i1;
        return i1;
    }
}
