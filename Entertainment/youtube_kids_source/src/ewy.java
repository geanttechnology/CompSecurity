// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewy extends eug
{

    public String a;
    private boolean b;
    private String c;
    private boolean d;
    private boolean e;
    private long f;
    private boolean g;
    private String h;
    private boolean i;
    private int j;
    private int k;

    public ewy()
    {
        c = "";
        a = "";
        f = 0L;
        h = "";
        j = 0;
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
                a(eud1.i());
                break;

            case 18: // '\022'
                b(eud1.i());
                break;

            case 24: // '\030'
                long l1 = eud1.e();
                e = true;
                f = l1;
                break;

            case 32: // ' '
                int i1 = eud1.f();
                i = true;
                j = i1;
                break;

            case 42: // '*'
                String s = eud1.i();
                g = true;
                h = s;
                break;
            }
        } while (true);
    }

    public final ewy a(String s)
    {
        b = true;
        c = s;
        return this;
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.a(1, c);
        }
        if (d)
        {
            eue1.a(2, a);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        if (i)
        {
            eue1.a(4, j);
        }
        if (g)
        {
            eue1.a(5, h);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (b)
        {
            i1 = eue.b(1, c) + 0;
        }
        int l = i1;
        if (d)
        {
            l = i1 + eue.b(2, a);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.e(3, f);
        }
        l = i1;
        if (i)
        {
            l = i1 + eue.d(4, j);
        }
        i1 = l;
        if (g)
        {
            i1 = l + eue.b(5, h);
        }
        k = i1;
        return i1;
    }

    public final ewy b(String s)
    {
        d = true;
        a = s;
        return this;
    }
}
