// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqs extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private int k;

    public eqs()
    {
        b = 400;
        d = 400;
        f = 0;
        h = 640;
        j = 320;
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
                a = true;
                b = i1;
                break;

            case 16: // '\020'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 24: // '\030'
                int k1 = eud1.f();
                e = true;
                f = k1;
                break;

            case 32: // ' '
                int l1 = eud1.f();
                g = true;
                h = l1;
                break;

            case 40: // '('
                int i2 = eud1.f();
                i = true;
                j = i2;
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
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.d(1, b) + 0;
        }
        int l = i1;
        if (c)
        {
            l = i1 + eue.d(2, d);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.d(3, f);
        }
        l = i1;
        if (g)
        {
            l = i1 + eue.d(4, h);
        }
        i1 = l;
        if (i)
        {
            i1 = l + eue.d(5, j);
        }
        k = i1;
        return i1;
    }
}
