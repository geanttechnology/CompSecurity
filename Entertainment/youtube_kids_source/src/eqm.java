// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqm extends eug
{

    private boolean a;
    private long b;
    private boolean c;
    private long d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;

    public eqm()
    {
        b = 0L;
        d = 0L;
        f = 0;
        h = "";
        j = false;
        l = 0;
        m = -1;
    }

    public final int a()
    {
        if (m < 0)
        {
            b();
        }
        return m;
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
                long l1 = eud1.e();
                a = true;
                b = l1;
                break;

            case 16: // '\020'
                long l2 = eud1.e();
                c = true;
                d = l2;
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                e = true;
                f = j1;
                break;

            case 34: // '"'
                String s = eud1.i();
                g = true;
                h = s;
                break;

            case 40: // '('
                boolean flag = eud1.h();
                i = true;
                j = flag;
                break;

            case 48: // '0'
                int k1 = eud1.f();
                k = true;
                l = k1;
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
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.e(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.e(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        m = i1;
        return i1;
    }
}
