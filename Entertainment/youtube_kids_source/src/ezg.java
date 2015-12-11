// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ezg extends eug
{

    public int a;
    public int b;
    private boolean c;
    private boolean d;
    private int e;

    public ezg()
    {
        a = 0;
        b = 0;
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

            case 13: // '\r'
                a(eud1.l());
                break;

            case 21: // '\025'
                b(eud1.l());
                break;
            }
        } while (true);
    }

    public final ezg a(int i)
    {
        c = true;
        a = i;
        return this;
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.c(1, a);
        }
        if (d)
        {
            eue1.c(2, b);
        }
    }

    public final int b()
    {
        int i = 0;
        if (c)
        {
            i = eue.f(1, a) + 0;
        }
        int j = i;
        if (d)
        {
            j = i + eue.f(2, b);
        }
        e = j;
        return j;
    }

    public final ezg b(int i)
    {
        d = true;
        b = i;
        return this;
    }
}
