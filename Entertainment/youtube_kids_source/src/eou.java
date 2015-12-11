// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eou extends eug
{

    private boolean a;
    private euc b;
    private boolean c;
    private String d;
    private boolean e;
    private eoy f;
    private boolean g;
    private eox h;
    private boolean i;
    private eow j;
    private boolean k;
    private eov l;
    private boolean m;
    private eoz n;
    private int o;

    public eou()
    {
        b = euc.b;
        d = "";
        f = null;
        h = null;
        j = null;
        l = null;
        n = null;
        o = -1;
    }

    public final int a()
    {
        if (o < 0)
        {
            b();
        }
        return o;
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

            case 10: // '\n'
                euc euc1 = eud1.j();
                a = true;
                b = euc1;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 26: // '\032'
                eoy eoy1 = new eoy();
                eud1.a(eoy1);
                e = true;
                f = eoy1;
                break;

            case 34: // '"'
                eox eox1 = new eox();
                eud1.a(eox1);
                g = true;
                h = eox1;
                break;

            case 42: // '*'
                eow eow1 = new eow();
                eud1.a(eow1);
                i = true;
                j = eow1;
                break;

            case 50: // '2'
                eov eov1 = new eov();
                eud1.a(eov1);
                k = true;
                l = eov1;
                break;

            case 58: // ':'
                eoz eoz1 = new eoz();
                eud1.a(eoz1);
                m = true;
                n = eoz1;
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
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
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
        o = j1;
        return j1;
    }
}
