// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqi extends eug
{

    private boolean a;
    private long b;
    private boolean c;
    private int d;
    private boolean e;
    private enb f;
    private boolean g;
    private boolean h;
    private boolean i;
    private enc j;
    private boolean k;
    private boolean l;
    private int m;

    public eqi()
    {
        b = 0L;
        d = 0;
        f = null;
        h = false;
        j = null;
        l = false;
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
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 26: // '\032'
                enb enb1 = new enb();
                eud1.a(enb1);
                e = true;
                f = enb1;
                break;

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 42: // '*'
                enc enc1 = new enc();
                eud1.a(enc1);
                i = true;
                j = enc1;
                break;

            case 48: // '0'
                boolean flag1 = eud1.h();
                k = true;
                l = flag1;
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
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.b(5, j);
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
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(6, l);
        }
        m = i1;
        return i1;
    }
}
