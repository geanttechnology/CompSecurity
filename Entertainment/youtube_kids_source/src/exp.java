// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exp extends eug
{

    private boolean a;
    private eeb b;
    private boolean c;
    private eef d;
    private boolean e;
    private boolean f;
    private int g;

    public exp()
    {
        b = null;
        d = null;
        f = false;
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

            case 10: // '\n'
                eeb eeb1 = new eeb();
                eud1.a(eeb1);
                a = true;
                b = eeb1;
                break;

            case 18: // '\022'
                eef eef1 = new eef();
                eud1.a(eef1);
                c = true;
                d = eef1;
                break;

            case 24: // '\030'
                boolean flag = eud1.h();
                e = true;
                f = flag;
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
        if (e)
        {
            eue1.a(3, f);
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
            j = i + eue.b(3, f);
        }
        g = j;
        return j;
    }
}
