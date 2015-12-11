// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewg extends eug
{

    public boolean a;
    public int b;
    public long c;
    private boolean d;
    private int e;

    public ewg()
    {
        b = 0;
        c = 0L;
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
                a = true;
                b = j;
                break;

            case 16: // '\020'
                long l = eud1.e();
                d = true;
                c = l;
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
        if (d)
        {
            eue1.b(2, c);
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
        if (d)
        {
            j = i + eue.e(2, c);
        }
        e = j;
        return j;
    }
}
