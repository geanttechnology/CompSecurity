// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eed extends eug
{

    private boolean a;
    private long b;
    private boolean c;
    private long d;
    private int e;

    public eed()
    {
        b = 0L;
        d = 0L;
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
                long l = eud1.e();
                a = true;
                b = l;
                break;

            case 16: // '\020'
                long l1 = eud1.e();
                c = true;
                d = l1;
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
            i = eue.e(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.e(2, d);
        }
        e = j;
        return j;
    }
}
