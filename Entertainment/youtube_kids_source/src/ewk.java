// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ewk extends eug
{

    public boolean a;
    public int b;
    public int c;
    public boolean d;
    public ewl e;
    public boolean f;
    public ewj g;
    public boolean h;
    public ewl i;
    private boolean j;
    private boolean k;
    private long l;
    private int m;

    public ewk()
    {
        b = 0;
        c = 0;
        e = null;
        g = null;
        i = null;
        l = 0L;
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

            case 16: // '\020'
                int k1 = eud1.f();
                j = true;
                c = k1;
                break;

            case 26: // '\032'
                ewl ewl1 = new ewl();
                eud1.a(ewl1);
                d = true;
                e = ewl1;
                break;

            case 34: // '"'
                ewj ewj1 = new ewj();
                eud1.a(ewj1);
                a(ewj1);
                break;

            case 42: // '*'
                ewl ewl2 = new ewl();
                eud1.a(ewl2);
                a(ewl2);
                break;

            case 48: // '0'
                long l1 = eud1.e();
                k = true;
                l = l1;
                break;
            }
        } while (true);
    }

    public final ewk a(ewj ewj1)
    {
        f = true;
        g = ewj1;
        return this;
    }

    public final ewk a(ewl ewl1)
    {
        if (ewl1 == null)
        {
            throw new NullPointerException();
        } else
        {
            h = true;
            i = ewl1;
            return this;
        }
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (j)
        {
            eue1.a(2, c);
        }
        if (d)
        {
            eue1.b(3, e);
        }
        if (f)
        {
            eue1.b(4, g);
        }
        if (h)
        {
            eue1.b(5, i);
        }
        if (k)
        {
            eue1.b(6, l);
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
        if (j)
        {
            i1 = j1 + eue.d(2, c);
        }
        j1 = i1;
        if (d)
        {
            j1 = i1 + eue.d(3, e);
        }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.d(4, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.d(5, i);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.e(6, l);
        }
        m = i1;
        return i1;
    }
}
