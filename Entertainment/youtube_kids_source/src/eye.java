// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eye extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private eyv d;
    private boolean e;
    private eyk f;
    private boolean g;
    private eyr h;
    private int i;

    public eye()
    {
        b = "";
        d = null;
        f = null;
        h = null;
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

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                eyv eyv1 = new eyv();
                eud1.a(eyv1);
                c = true;
                d = eyv1;
                break;

            case 26: // '\032'
                eyk eyk1 = new eyk();
                eud1.a(eyk1);
                e = true;
                f = eyk1;
                break;

            case 34: // '"'
                eyr eyr1 = new eyr();
                eud1.a(eyr1);
                g = true;
                h = eyr1;
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
            eue1.b(2, d);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
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
            j = k + eue.d(2, d);
        }
        k = j;
        if (e)
        {
            k = j + eue.d(3, f);
        }
        j = k;
        if (g)
        {
            j = k + eue.d(4, h);
        }
        i = j;
        return j;
    }
}
