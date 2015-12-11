// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eob extends eug
{

    private boolean a;
    private efl b;
    private boolean c;
    private erd d;
    private int e;

    public eob()
    {
        b = null;
        d = null;
        e = -1;
    }

    public final int a()
    {
        if (e < 0)
        {
            b();
        }
        return e;
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
                efl efl1 = new efl();
                eud1.a(efl1);
                a = true;
                b = efl1;
                break;

            case 18: // '\022'
                erd erd1 = new erd();
                eud1.a(erd1);
                c = true;
                d = erd1;
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
        if (c)
        {
            eue1.b(2, d);
        }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.d(2, d);
        }
        e = j;
        return j;
    }
}
