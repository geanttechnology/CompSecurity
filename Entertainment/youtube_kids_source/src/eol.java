// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eol extends eug
{

    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;

    public eol()
    {
        b = false;
        d = 0;
        f = false;
        h = false;
        j = false;
        l = 0;
        m = -1;
    }

    public final int a()
    {
        if (m < 0)
        {
            b();
        }
        return m;
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
                boolean flag = eud1.h();
                a = true;
                b = flag;
                break;

            case 16: // '\020'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 24: // '\030'
                boolean flag1 = eud1.h();
                e = true;
                f = flag1;
                break;

            case 32: // ' '
                boolean flag2 = eud1.h();
                g = true;
                h = flag2;
                break;

            case 40: // '('
                boolean flag3 = eud1.h();
                i = true;
                j = flag3;
                break;

            case 48: // '0'
                int k1 = eud1.f();
                k = true;
                l = k1;
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
            i1 = j1 + eue.d(6, l);
        }
        m = i1;
        return i1;
    }
}
