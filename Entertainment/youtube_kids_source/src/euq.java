// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class euq extends eug
{

    public String a;
    private boolean b;
    private boolean c;
    private float d;
    private int e;

    public euq()
    {
        a = "";
        d = 0.0F;
        e = -1;
    }

    public final int a()
    {
        if (e < 0)
        {
            b();
        }
        return e;
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
                String s = eud1.i();
                b = true;
                a = s;
                break;

            case 21: // '\025'
                float f = eud1.c();
                c = true;
                d = f;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.a(1, a);
        }
        if (c)
        {
            eue1.a(2, d);
        }
    }

    public final int b()
    {
        int i = 0;
        if (b)
        {
            i = eue.b(1, a) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.b(2, d);
        }
        e = j;
        return j;
    }
}
