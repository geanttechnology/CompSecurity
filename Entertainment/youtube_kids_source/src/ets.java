// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ets extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private euc d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private String j;
    private boolean k;
    private euc l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;
    private List q;
    private int r;

    public ets()
    {
        b = "";
        d = euc.b;
        f = 0;
        h = 0;
        j = "";
        l = euc.b;
        n = 0;
        p = 0;
        q = Collections.emptyList();
        r = -1;
    }

    public final int a()
    {
        if (r < 0)
        {
            b();
        }
        return r;
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
                i = true;
                j = s1;
                break;

            case 26: // '\032'
                eqf eqf1 = new eqf();
                eud1.a(eqf1);
                if (q.isEmpty())
                {
                    q = new ArrayList();
                }
                q.add(eqf1);
                break;

            case 32: // ' '
                int j1 = eud1.f();
                e = true;
                f = j1;
                break;

            case 40: // '('
                int k1 = eud1.f();
                g = true;
                h = k1;
                break;

            case 48: // '0'
                int l1 = eud1.f();
                m = true;
                n = l1;
                break;

            case 56: // '8'
                int i2 = eud1.f();
                o = true;
                p = i2;
                break;

            case 66: // 'B'
                euc euc1 = eud1.j();
                c = true;
                d = euc1;
                break;

            case 74: // 'J'
                euc euc2 = eud1.j();
                k = true;
                l = euc2;
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
        if (i)
        {
            eue1.a(2, j);
        }
        for (Iterator iterator = q.iterator(); iterator.hasNext(); eue1.b(3, (eqf)iterator.next())) { }
        if (e)
        {
            eue1.a(4, f);
        }
        if (g)
        {
            eue1.a(5, h);
        }
        if (m)
        {
            eue1.a(6, n);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (c)
        {
            eue1.a(8, d);
        }
        if (k)
        {
            eue1.a(9, l);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        }
        int j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(2, j);
        }
        for (Iterator iterator = q.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(3, (eqf)iterator.next()) + j1;
        }

        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.d(4, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(5, h);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(6, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(7, p);
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(8, d);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(9, l);
        }
        r = j1;
        return j1;
    }
}
