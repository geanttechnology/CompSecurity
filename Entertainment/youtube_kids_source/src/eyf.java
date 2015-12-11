// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyf extends eug
{

    public String a;
    public String b;
    public List c;
    public boolean d;
    public String e;
    public boolean f;
    private boolean g;
    private boolean h;
    private List i;
    private boolean j;
    private int k;

    public eyf()
    {
        a = "";
        b = "";
        c = Collections.emptyList();
        i = Collections.emptyList();
        e = "";
        f = false;
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
                g = true;
                a = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                h = true;
                b = s1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(s2);
                break;

            case 40: // '('
                int i1 = eud1.f();
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(Integer.valueOf(i1));
                break;

            case 50: // '2'
                String s3 = eud1.i();
                d = true;
                e = s3;
                break;

            case 56: // '8'
                boolean flag = eud1.h();
                j = true;
                f = flag;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (g)
        {
            eue1.a(1, a);
        }
        if (h)
        {
            eue1.a(2, b);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(4, (String)iterator.next())) { }
        for (Iterator iterator1 = i.iterator(); iterator1.hasNext(); eue1.a(5, ((Integer)iterator1.next()).intValue())) { }
        if (d)
        {
            eue1.a(6, e);
        }
        if (j)
        {
            eue1.a(7, f);
        }
    }

    public final int b()
    {
        int j1 = 0;
        Iterator iterator;
        int l;
        int i1;
        int k1;
        if (g)
        {
            l = eue.b(1, a) + 0;
        } else
        {
            l = 0;
        }
        if (h)
        {
            l += eue.b(2, b);
        }
        iterator = c.iterator();
        for (i1 = 0; iterator.hasNext(); i1 = eue.a((String)iterator.next()) + i1) { }
        k1 = c.size();
        for (Iterator iterator1 = i.iterator(); iterator1.hasNext();)
        {
            j1 += eue.a(((Integer)iterator1.next()).intValue());
        }

        i1 = k1 * 1 + (l + i1) + j1 + i.size() * 1;
        l = i1;
        if (d)
        {
            l = i1 + eue.b(6, e);
        }
        i1 = l;
        if (j)
        {
            i1 = l + eue.b(7, f);
        }
        k = i1;
        return i1;
    }
}
