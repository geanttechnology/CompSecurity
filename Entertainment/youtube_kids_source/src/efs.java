// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class efs extends eug
{

    private boolean a;
    private efn b;
    private boolean c;
    private long d;
    private boolean e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private efn j;
    private int k;

    public efs()
    {
        b = null;
        d = 0L;
        f = 0;
        h = false;
        j = null;
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
                efn efn1 = new efn();
                eud1.a(efn1);
                a = true;
                b = efn1;
                break;

            case 16: // '\020'
                long l1 = eud1.e();
                c = true;
                d = l1;
                break;

            case 24: // '\030'
                int i1 = eud1.f();
                e = true;
                f = i1;
                break;

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 42: // '*'
                efn efn2 = new efn();
                eud1.a(efn2);
                i = true;
                j = efn2;
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
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.b(5, j);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.d(1, b) + 0;
        }
        int l = i1;
        if (c)
        {
            l = i1 + eue.e(2, d);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.d(3, f);
        }
        l = i1;
        if (g)
        {
            l = i1 + eue.b(4, h);
        }
        i1 = l;
        if (i)
        {
            i1 = l + eue.d(5, j);
        }
        k = i1;
        return i1;
    }
}
