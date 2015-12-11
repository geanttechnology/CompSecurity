// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class erd extends eug
{

    private boolean a;
    private String b;
    private List c;
    private boolean d;
    private erc e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private eru o;
    private int p;

    public erd()
    {
        b = "";
        c = Collections.emptyList();
        e = null;
        g = false;
        i = false;
        k = "";
        m = "";
        o = null;
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
                eqy eqy1 = new eqy();
                eud1.a(eqy1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(eqy1);
                break;

            case 26: // '\032'
                erc erc1 = new erc();
                eud1.a(erc1);
                d = true;
                e = erc1;
                break;

            case 32: // ' '
                boolean flag = eud1.h();
                f = true;
                g = flag;
                break;

            case 40: // '('
                boolean flag1 = eud1.h();
                h = true;
                i = flag1;
                break;

            case 50: // '2'
                String s1 = eud1.i();
                j = true;
                k = s1;
                break;

            case 58: // ':'
                String s2 = eud1.i();
                l = true;
                m = s2;
                break;

            case 66: // 'B'
                eru eru1 = new eru();
                eud1.a(eru1);
                n = true;
                o = eru1;
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (eqy)iterator.next())) { }
        if (d)
        {
            eue1.b(3, e);
        }
        if (f)
        {
            eue1.a(4, g);
        }
        if (h)
        {
            eue1.a(5, i);
        }
        if (j)
        {
            eue1.a(6, k);
        }
        if (l)
        {
            eue1.a(7, m);
        }
        if (n)
        {
            eue1.b(8, o);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        }
        Iterator iterator = c.iterator();
        int j1;
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(2, (eqy)iterator.next()) + j1) { }
        i1 = j1;
        if (d)
        {
            i1 = j1 + eue.d(3, e);
        }
        j1 = i1;
        if (f)
        {
            j1 = i1 + eue.b(4, g);
        }
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.b(5, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(6, k);
        }
        i1 = j1;
        if (l)
        {
            i1 = j1 + eue.b(7, m);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.d(8, o);
        }
        p = j1;
        return j1;
    }
}
