// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ers extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private boolean g;
    private float h;
    private boolean i;
    private String j;
    private int k;

    public ers()
    {
        b = "";
        d = 0.0F;
        f = 0.0F;
        h = 0.0F;
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

            case 21: // '\025'
                float f1 = eud1.c();
                c = true;
                d = f1;
                break;

            case 29: // '\035'
                float f2 = eud1.c();
                e = true;
                f = f2;
                break;

            case 37: // '%'
                float f3 = eud1.c();
                g = true;
                h = f3;
                break;

            case 42: // '*'
                String s1 = eud1.i();
                i = true;
                j = s1;
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
