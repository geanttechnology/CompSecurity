// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class epl extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;

    public epl()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = false;
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

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 34: // '"'
                String s3 = eud1.i();
                g = true;
                h = s3;
                break;

            case 40: // '('
                boolean flag = eud1.h();
                i = true;
                j = flag;
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
            j1 = i1 + eue.b(3, f);
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
            i1 = j1 + eue.b(6, l);
        }
        m = i1;
        return i1;
    }
}
