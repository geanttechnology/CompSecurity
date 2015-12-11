// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewp extends eug
{

    private boolean a;
    private euc b;
    private int c;

    public ewp()
    {
        b = euc.b;
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
                a(eud1.j());
                break;
            }
        } while (true);
    }

    public final ewp a(euc euc1)
    {
        a = true;
        b = euc1;
        return this;
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.b(1, b) + 0;
        }
        c = i;
        return i;
    }
}
