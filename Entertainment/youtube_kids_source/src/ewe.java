// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewe extends eug
{

    public int a;
    public evg b;
    private boolean c;
    private boolean d;
    private int e;

    public ewe()
    {
        a = 0;
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

            case 8: // '\b'
                a(eud1.f());
                break;

            case 18: // '\022'
                evg evg1 = new evg();
                eud1.a(evg1);
                d = true;
                b = evg1;
                break;
            }
        } while (true);
    }

    public final ewe a(int i)
    {
        c = true;
        a = i;
        return this;
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, a);
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
