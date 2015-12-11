// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eng extends eug
{

    private boolean a;
    private etf b;
    private int c;

    public eng()
    {
        b = null;
        c = -1;
    }

    public final int a()
    {
        if (c < 0)
        {
            b();
        }
        return c;
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
                etf etf1 = new etf();
                eud1.a(etf1);
                a = true;
                b = etf1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(1, b);
        }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
        }
        c = i;
        return i;
    }
}
