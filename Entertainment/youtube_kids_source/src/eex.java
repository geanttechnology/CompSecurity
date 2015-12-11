// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eex extends eug
{

    private boolean a;
    private double b;
    private boolean c;
    private double d;
    private boolean e;
    private float f;
    private boolean g;
    private float h;
    private int i;

    public eex()
    {
        b = 0.0D;
        d = 0.0D;
        f = 0.0F;
        h = 0.0F;
        i = -1;
    }

    public final int a()
    {
        if (i < 0)
        {
            b();
        }
        return i;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int j = eud1.a();
            switch (j)
            {
            default:
                if (a(eud1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 9: // '\t'
                double d1 = eud1.b();
                a = true;
                b = d1;
                break;

            case 17: // '\021'
                double d2 = eud1.b();
                c = true;
                d = d2;
                break;

            case 29: // '\035'
                float f1 = eud1.c();
                e = true;
                f = f1;
                break;

            case 37: // '%'
                float f2 = eud1.c();
                g = true;
                h = f2;
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
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
    }

    public final int b()
    {
        int k = 0;
        if (a)
        {
            k = eue.b(1, b) + 0;
        }
        int j = k;
        if (c)
        {
            j = k + eue.b(2, d);
        }
        k = j;
        if (e)
        {
            k = j + eue.b(3, f);
        }
        j = k;
        if (g)
        {
            j = k + eue.b(4, h);
        }
        i = j;
        return j;
    }
}
