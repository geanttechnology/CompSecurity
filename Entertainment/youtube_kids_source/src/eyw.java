// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyw extends eug
{

    public eyi a;
    private boolean b;
    private int c;

    public eyw()
    {
        a = null;
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
                eyi eyi1 = new eyi();
                eud1.a(eyi1);
                b = true;
                a = eyi1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.b(1, a);
        }
    }

    public final int b()
    {
        int i = 0;
        if (b)
        {
            i = eue.d(1, a) + 0;
        }
        c = i;
        return i;
    }
}
