// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epk extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private String f;
    private boolean g;
    private enb h;
    private boolean i;
    private String j;
    private int k;

    public epk()
    {
        b = "";
        d = 0;
        f = "";
        h = null;
        j = "";
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

            case 16: // '\020'
                int i1 = eud1.f();
                c = true;
                d = i1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 34: // '"'
                enb enb1 = new enb();
                eud1.a(enb1);
                g = true;
                h = enb1;
                break;

            case 50: // '2'
                String s2 = eud1.i();
                i = true;
                j = s2;
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
            eue1.b(4, h);
        }
        if (i)
        {
            eue1.a(6, j);
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
            l = i1 + eue.d(2, d);
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
            i1 = l + eue.b(6, j);
        }
        k = i1;
        return i1;
    }
}
