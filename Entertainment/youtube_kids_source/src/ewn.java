// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewn extends eug
{

    private boolean a;
    private boolean b;
    private boolean c;
    private String d;
    private boolean e;
    private float f;
    private int g;

    public ewn()
    {
        b = false;
        d = "";
        f = 0.0F;
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
                boolean flag = eud1.h();
                a = true;
                b = flag;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 29: // '\035'
                float f1 = eud1.c();
                e = true;
                f = f1;
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
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.b(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.b(2, d);
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
