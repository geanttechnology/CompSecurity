// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epd extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    private double j;
    private int k;

    public epd()
    {
        b = "";
        d = "";
        f = false;
        h = 0;
        j = 0.0D;
        k = -1;
    }

    public final int a()
    {
        if (k < 0)
        {
            b();
        }
        return k;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int l = eud1.a();
            switch (l)
            {
            default:
                if (a(eud1, l))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 24: // '\030'
                boolean flag = eud1.h();
                e = true;
                f = flag;
                break;

            case 32: // ' '
                int i1 = eud1.f();
                g = true;
                h = i1;
                break;

            case 41: // ')'
                double d1 = eud1.b();
                i = true;
                j = d1;
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
        if (i)
        {
            eue1.a(5, j);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        }
        int l = i1;
        if (c)
        {
            l = i1 + eue.b(2, d);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.b(3, f);
        }
        l = i1;
        if (g)
        {
            l = i1 + eue.d(4, h);
        }
        i1 = l;
        if (i)
        {
            i1 = l + eue.b(5, j);
        }
        k = i1;
        return i1;
    }
}
