// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyi extends eug
{

    public int a;
    public int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private int k;

    public eyi()
    {
        d = 0;
        f = 0;
        h = 0;
        a = 0;
        b = 0;
        k = -1;
    }

    public final int a()
    {
        if (k < 0)
        {
            b();
        }
        return k;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int l = eud1.a();
            switch (l)
            {
            default:
                if (a(eud1, l))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int i1 = eud1.f();
                c = true;
                d = i1;
                break;

            case 16: // '\020'
                int j1 = eud1.f();
                e = true;
                f = j1;
                break;

            case 24: // '\030'
                int k1 = eud1.f();
                g = true;
                h = k1;
                break;

            case 32: // ' '
                a(eud1.f());
                break;

            case 40: // '('
                int l1 = eud1.f();
                j = true;
                b = l1;
                break;
            }
        } while (true);
    }

    public final eyi a(int l)
    {
        i = true;
        a = l;
        return this;
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, d);
        }
        if (e)
        {
            eue1.a(2, f);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        if (i)
        {
            eue1.a(4, a);
        }
        if (j)
        {
            eue1.a(5, b);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (c)
        {
            i1 = eue.d(1, d) + 0;
        }
        int l = i1;
        if (e)
        {
            l = i1 + eue.d(2, f);
        }
        i1 = l;
        if (g)
        {
            i1 = l + eue.d(3, h);
        }
        l = i1;
        if (i)
        {
            l = i1 + eue.d(4, a);
        }
        i1 = l;
        if (j)
        {
            i1 = l + eue.d(5, b);
        }
        k = i1;
        return i1;
    }
}
