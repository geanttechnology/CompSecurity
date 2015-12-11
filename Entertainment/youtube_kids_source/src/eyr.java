// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyr extends eug
{

    public eyk a;
    public eyk b;
    private boolean c;
    private boolean d;
    private int e;

    public eyr()
    {
        a = null;
        b = null;
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
                eyk eyk1 = new eyk();
                eud1.a(eyk1);
                c = true;
                a = eyk1;
                break;

            case 18: // '\022'
                eyk eyk2 = new eyk();
                eud1.a(eyk2);
                d = true;
                b = eyk2;
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
            eue1.b(2, b);
        }
    }

    public final int b()
    {
        int i = 0;
        if (c)
        {
            i = eue.d(1, a) + 0;
        }
        int j = i;
        if (d)
        {
            j = i + eue.d(2, b);
        }
        e = j;
        return j;
    }
}
