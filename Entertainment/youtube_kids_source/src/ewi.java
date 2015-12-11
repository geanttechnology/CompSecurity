// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewi extends eug
{

    public boolean a;
    public String b;
    public boolean c;
    public double d;
    private boolean e;
    private ewm f;
    private int g;

    public ewi()
    {
        b = "";
        d = 0.0D;
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 17: // '\021'
                double d1 = eud1.b();
                c = true;
                d = d1;
                break;

            case 26: // '\032'
                ewm ewm1 = new ewm();
                eud1.a(ewm1);
                e = true;
                f = ewm1;
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
            eue1.b(3, f);
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
            j = i + eue.d(3, f);
        }
        g = j;
        return j;
    }
}
