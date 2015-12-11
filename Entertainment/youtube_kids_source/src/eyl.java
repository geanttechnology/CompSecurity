// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eyl extends eug
{

    public eyi a;
    private boolean b;
    private int c;
    private boolean d;
    private int e;

    public eyl()
    {
        c = 5;
        a = null;
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
                int j = eud1.f();
                b = true;
                c = j;
                break;

            case 18: // '\022'
                eyi eyi1 = new eyi();
                eud1.a(eyi1);
                d = true;
                a = eyi1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.a(1, c);
        }
        if (d)
        {
            eue1.b(2, a);
        }
    }

    public final int b()
    {
        int i = 0;
        if (b)
        {
            i = eue.d(1, c) + 0;
        }
        int j = i;
        if (d)
        {
            j = i + eue.d(2, a);
        }
        e = j;
        return j;
    }
}
