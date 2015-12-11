// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exu extends eug
{

    public euc a;
    public boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private exr f;
    private int g;

    public exu()
    {
        a = euc.b;
        b = false;
        f = null;
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
                euc euc1 = eud1.j();
                c = true;
                a = euc1;
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                d = true;
                b = flag;
                break;

            case 26: // '\032'
                exr exr1 = new exr();
                eud1.a(exr1);
                e = true;
                f = exr1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, a);
        }
        if (d)
        {
            eue1.a(2, b);
        }
        if (e)
        {
            eue1.b(3, f);
        }
    }

    public final int b()
    {
        int j = 0;
        if (c)
        {
            j = eue.b(1, a) + 0;
        }
        int i = j;
        if (d)
        {
            i = j + eue.b(2, b);
        }
        j = i;
        if (e)
        {
            j = i + eue.d(3, f);
        }
        g = j;
        return j;
    }
}
