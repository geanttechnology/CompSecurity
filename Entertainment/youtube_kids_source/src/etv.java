// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class etv extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private euc h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private List o;
    private int p;

    public etv()
    {
        b = "";
        d = "";
        f = "";
        h = euc.b;
        j = "";
        l = "";
        n = "";
        o = Collections.emptyList();
        p = -1;
    }

    public final int a()
    {
        if (p < 0)
        {
            b();
        }
        return p;
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
                e = true;
                f = s1;
                break;

            case 26: // '\032'
                eqf eqf1 = new eqf();
                eud1.a(eqf1);
                if (o.isEmpty())
                {
                    o = new ArrayList();
                }
                o.add(eqf1);
                break;

            case 34: // '"'
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 42: // '*'
                euc euc1 = eud1.j();
                g = true;
                h = euc1;
                break;

            case 50: // '2'
                String s3 = eud1.i();
                c = true;
                d = s3;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 66: // 'B'
                String s5 = eud1.i();
                m = true;
                n = s5;
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
        if (e)
        {
            eue1.a(2, f);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext(); eue1.b(3, (eqf)iterator.next())) { }
        if (i)
        {
            eue1.a(4, j);
        }
        if (g)
        {
            eue1.a(5, h);
        }
        if (c)
        {
            eue1.a(6, d);
        }
        if (k)
        {
            eue1.a(7, l);
        }
        if (m)
        {
            eue1.a(8, n);
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
        if (e)
        {
            j1 = i1 + eue.b(2, f);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(3, (eqf)iterator.next()) + j1;
        }

        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(4, j);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(5, h);
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(6, d);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(7, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(8, n);
        }
        p = i1;
        return i1;
    }
}
