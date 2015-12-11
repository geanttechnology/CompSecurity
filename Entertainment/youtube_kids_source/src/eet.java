// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eet extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private efa d;
    private boolean e;
    private eev f;
    private boolean g;
    private eex h;
    private boolean i;
    private String j;
    private boolean k;
    private boolean l;
    private int m;

    public eet()
    {
        b = 0;
        d = null;
        f = null;
        h = null;
        j = "";
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
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 18: // '\022'
                efa efa1 = new efa();
                eud1.a(efa1);
                c = true;
                d = efa1;
                break;

            case 26: // '\032'
                eev eev1 = new eev();
                eud1.a(eev1);
                e = true;
                f = eev1;
                break;

            case 34: // '"'
                eex eex1 = new eex();
                eud1.a(eex1);
                g = true;
                h = eex1;
                break;

            case 130: 
                String s = eud1.i();
                i = true;
                j = s;
                break;

            case 136: 
                boolean flag = eud1.h();
                k = true;
                l = flag;
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
        if (i)
        {
            eue1.a(16, j);
        }
        if (k)
        {
            eue1.a(17, l);
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
            j1 = i1 + eue.b(16, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(17, l);
        }
        m = i1;
        return i1;
    }
}
