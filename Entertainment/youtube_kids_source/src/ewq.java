// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewq extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private float d;
    private boolean e;
    private int f;
    private int g;

    public ewq()
    {
        b = 0;
        d = 0.0F;
        f = 1;
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

            case 21: // '\025'
                a(eud1.c());
                break;

            case 24: // '\030'
                a(eud1.f());
                break;

            case 32: // ' '
                int j = eud1.f();
                e = true;
                f = j;
                break;
            }
        } while (true);
    }

    public final ewq a(float f1)
    {
        c = true;
        d = f1;
        return this;
    }

    public final ewq a(int i)
    {
        a = true;
        b = i;
        return this;
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(2, d);
        }
        if (a)
        {
            eue1.a(3, b);
        }
        if (e)
        {
            eue1.a(4, f);
        }
    }

    public final int b()
    {
        int j = 0;
        if (c)
        {
            j = eue.b(2, d) + 0;
        }
        int i = j;
        if (a)
        {
            i = j + eue.d(3, b);
        }
        j = i;
        if (e)
        {
            j = i + eue.d(4, f);
        }
        g = j;
        return j;
    }
}
