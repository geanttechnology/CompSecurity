// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exy extends eug
{

    private boolean a;
    private double b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;

    public exy()
    {
        b = 0.0D;
        d = false;
        f = false;
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i = eud1.a();
            switch (i)
            {
            default:
                if (a(eud1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 9: // '\t'
                a(eud1.b());
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                c = true;
                d = flag;
                break;

            case 24: // '\030'
                boolean flag1 = eud1.h();
                e = true;
                f = flag1;
                break;
            }
        } while (true);
    }

    public final exy a(double d1)
    {
        a = true;
        b = d1;
        return this;
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
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.b(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.b(2, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.b(3, f);
        }
        g = j;
        return j;
    }
}
