// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eub extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private etz f;
    private int g;

    public eub()
    {
        b = 0;
        d = 0;
        f = null;
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
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
                int k = eud1.f();
                c = true;
                d = k;
                break;

            case 215553050: 
                etz etz1 = new etz();
                eud1.a(etz1);
                e = true;
                f = etz1;
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
        if (c)
        {
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.b(0x19b2283, f);
        }
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.d(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.d(2, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.d(0x19b2283, f);
        }
        g = j;
        return j;
    }
}
