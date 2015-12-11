// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ern extends eug
{

    private boolean a;
    private ero b;
    private boolean c;
    private String d;
    private int e;

    public ern()
    {
        b = null;
        d = "";
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
                ero ero1 = new ero();
                eud1.a(ero1);
                a = true;
                b = ero1;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
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
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
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
