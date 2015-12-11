// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyv extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private String f;
    private boolean g;
    private int h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private List q;
    private int r;

    public eyv()
    {
        b = "";
        d = 0;
        f = "";
        h = 0;
        j = 0;
        l = 0;
        n = 0;
        p = false;
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

            case 16: // '\020'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 32: // ' '
                int k1 = eud1.f();
                g = true;
                h = k1;
                break;

            case 40: // '('
                int l1 = eud1.f();
                i = true;
                j = l1;
                break;

            case 48: // '0'
                int i2 = eud1.f();
                k = true;
                l = i2;
                break;

            case 56: // '8'
                int j2 = eud1.f();
                m = true;
                n = j2;
                break;

            case 64: // '@'
                boolean flag = eud1.h();
                o = true;
                p = flag;
                break;

            case 72: // 'H'
                int k2 = eud1.f();
                if (q.isEmpty())
                {
                    q = new ArrayList();
                }
                q.add(Integer.valueOf(k2));
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
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
        }
        for (Iterator iterator = q.iterator(); iterator.hasNext(); eue1.a(9, ((Integer)iterator.next()).intValue())) { }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        if (o)
        {
            i1 = j1 + eue.b(8, p);
        } else
        {
            i1 = j1;
        }
        iterator = q.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a(((Integer)iterator.next()).intValue())) { }
        i1 = i1 + j1 + q.size() * 1;
        r = i1;
        return i1;
    }
}
