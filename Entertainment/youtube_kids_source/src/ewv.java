// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewv extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private euc f;
    private boolean g;
    private boolean h;
    private int i;

    public ewv()
    {
        b = "";
        d = false;
        f = euc.b;
        h = false;
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

            case 16: // '\020'
                boolean flag = eud1.h();
                c = true;
                d = flag;
                break;

            case 26: // '\032'
                euc euc1 = eud1.j();
                e = true;
                f = euc1;
                break;

            case 32: // ' '
                boolean flag1 = eud1.h();
                g = true;
                h = flag1;
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
