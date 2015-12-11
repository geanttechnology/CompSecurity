// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epv extends eug
{

    private boolean a;
    private eoq b;
    private int c;

    public epv()
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
                eoq eoq1 = new eoq();
                eud1.a(eoq1);
                a = true;
                b = eoq1;
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
