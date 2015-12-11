// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exl extends eug
{

    public boolean a;
    public ewk b;
    public boolean c;
    public ewg d;
    private boolean e;
    private String f;
    private int g;

    public exl()
    {
        b = null;
        d = null;
        f = "";
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i = eud1.a();
            switch (i)
            {
            default:
                if (a(eud1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                ewk ewk1 = new ewk();
                eud1.a(ewk1);
                a(ewk1);
                break;

            case 18: // '\022'
                ewg ewg1 = new ewg();
                eud1.a(ewg1);
                c = true;
                d = ewg1;
                break;

            case 26: // '\032'
                String s = eud1.i();
                e = true;
                f = s;
                break;
            }
        } while (true);
    }

    public final exl a(ewk ewk1)
    {
        if (ewk1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = true;
            b = ewk1;
            return this;
        }
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
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.d(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.d(2, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.b(3, f);
        }
        g = j;
        return j;
    }
}
