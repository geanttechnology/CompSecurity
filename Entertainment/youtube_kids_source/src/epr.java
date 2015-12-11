// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epr extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private eub d;
    private boolean e;
    private String f;
    private boolean g;
    private eub h;
    private int i;

    public epr()
    {
        b = "";
        d = null;
        f = "";
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
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 26: // '\032'
                eub eub1 = new eub();
                eud1.a(eub1);
                c = true;
                d = eub1;
                break;

            case 34: // '"'
                eub eub2 = new eub();
                eud1.a(eub2);
                g = true;
                h = eub2;
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
        if (e)
        {
            eue1.a(2, f);
        }
        if (c)
        {
            eue1.b(3, d);
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
        if (e)
        {
            j = k + eue.b(2, f);
        }
        k = j;
        if (c)
        {
            k = j + eue.d(3, d);
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
