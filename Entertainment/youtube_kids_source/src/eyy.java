// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyy extends eug
{

    public eyi a;
    public int b;
    private boolean c;
    private boolean d;
    private int e;
    private boolean f;
    private int g;

    public eyy()
    {
        a = null;
        e = 0;
        b = 0;
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

            case 10: // '\n'
                eyi eyi1 = new eyi();
                eud1.a(eyi1);
                c = true;
                a = eyi1;
                break;

            case 16: // '\020'
                int j = eud1.f();
                d = true;
                e = j;
                break;

            case 24: // '\030'
                int k = eud1.f();
                f = true;
                b = k;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.b(1, a);
        }
        if (d)
        {
            eue1.a(2, e);
        }
        if (f)
        {
            eue1.a(3, b);
        }
    }

    public final int b()
    {
        int j = 0;
        if (c)
        {
            j = eue.d(1, a) + 0;
        }
        int i = j;
        if (d)
        {
            i = j + eue.d(2, e);
        }
        j = i;
        if (f)
        {
            j = i + eue.d(3, b);
        }
        g = j;
        return j;
    }
}
