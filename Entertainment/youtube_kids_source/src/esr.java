// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class esr extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private String d;
    private boolean e;
    private esu f;
    private boolean g;
    private esv h;
    private boolean i;
    private erk j;
    private int k;

    public esr()
    {
        b = 0;
        d = "";
        f = null;
        h = null;
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

            case 8: // '\b'
                int i1 = eud1.f();
                a = true;
                b = i1;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 26: // '\032'
                esu esu1 = new esu();
                eud1.a(esu1);
                e = true;
                f = esu1;
                break;

            case 34: // '"'
                esv esv1 = new esv();
                eud1.a(esv1);
                g = true;
                h = esv1;
                break;

            case 42: // '*'
                erk erk1 = new erk();
                eud1.a(erk1);
                i = true;
                j = erk1;
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
            l = i1 + eue.b(2, d);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.d(3, f);
        }
        l = i1;
        if (g)
        {
            l = i1 + eue.d(4, h);
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
