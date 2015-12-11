// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class etw extends eug
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
    private etu n;
    private List o;
    private int p;

    public etw()
    {
        b = "";
        d = "";
        f = "";
        h = euc.b;
        j = "";
        l = "";
        n = null;
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
                euc euc1 = eud1.j();
                g = true;
                h = euc1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                k = true;
                l = s3;
                break;

            case 50: // '2'
                etu etu1 = new etu();
                eud1.a(etu1);
                m = true;
                n = etu1;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                c = true;
                d = s4;
                break;

            case 66: // 'B'
                erj erj1 = new erj();
                eud1.a(erj1);
                if (o.isEmpty())
                {
                    o = new ArrayList();
                }
                o.add(erj1);
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
        if (g)
        {
            eue1.a(3, h);
        }
        if (i)
        {
            eue1.a(4, j);
        }
        if (k)
        {
            eue1.a(5, l);
        }
        if (m)
        {
            eue1.b(6, n);
        }
        if (c)
        {
            eue1.a(7, d);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext(); eue1.b(8, (erj)iterator.next())) { }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(2, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(3, h);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(4, j);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(5, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(6, n);
        }
        j1 = i1;
        if (c)
        {
            j1 = i1 + eue.b(7, d);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(8, (erj)iterator.next()) + j1;
        }

        p = j1;
        return j1;
    }
}
