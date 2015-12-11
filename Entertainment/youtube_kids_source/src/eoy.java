// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eoy extends eug
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
    private int k;

    public eoy()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = false;
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
            l = i1 + eue.b(2, d);
        }
        i1 = l;
        if (e)
        {
            i1 = l + eue.b(3, f);
        }
        l = i1;
        if (g)
        {
            l = i1 + eue.b(4, h);
        }
        i1 = l;
        if (i)
        {
            i1 = l + eue.b(5, j);
        }
        k = i1;
        return i1;
    }
}
