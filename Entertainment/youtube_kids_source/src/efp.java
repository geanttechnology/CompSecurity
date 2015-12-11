// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class efp extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private eft f;
    private boolean g;
    private efs h;
    private boolean i;
    private efq j;
    private boolean k;
    private efu l;
    private boolean m;
    private efr n;
    private boolean o;
    private efv p;
    private int q;

    public efp()
    {
        b = 0;
        d = 1;
        f = null;
        h = null;
        j = null;
        l = null;
        n = null;
        p = null;
        q = -1;
    }

    public final int a()
    {
        if (q < 0)
        {
            b();
        }
        return q;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 16: // '\020'
                int k1 = eud1.f();
                c = true;
                d = k1;
                break;

            case 26: // '\032'
                eft eft1 = new eft();
                eud1.a(eft1);
                e = true;
                f = eft1;
                break;

            case 34: // '"'
                efs efs1 = new efs();
                eud1.a(efs1);
                g = true;
                h = efs1;
                break;

            case 42: // '*'
                efq efq1 = new efq();
                eud1.a(efq1);
                i = true;
                j = efq1;
                break;

            case 50: // '2'
                efu efu1 = new efu();
                eud1.a(efu1);
                k = true;
                l = efu1;
                break;

            case 58: // ':'
                efr efr1 = new efr();
                eud1.a(efr1);
                m = true;
                n = efr1;
                break;

            case 66: // 'B'
                efv efv1 = new efv();
                eud1.a(efv1);
                o = true;
                p = efv1;
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
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        if (i)
        {
            eue1.b(5, j);
        }
        if (k)
        {
            eue1.b(6, l);
        }
        if (m)
        {
            eue1.b(7, n);
        }
        if (o)
        {
            eue1.b(8, p);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        q = i1;
        return i1;
    }
}
