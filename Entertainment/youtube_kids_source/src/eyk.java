// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyk extends eug
{

    public String a;
    public List b;
    public List c;
    public String d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;

    public eyk()
    {
        a = "";
        l = false;
        b = Collections.emptyList();
        c = Collections.emptyList();
        d = "";
        e = 0;
        f = 0;
        h = 0;
        i = false;
        q = -1;
    }

    public final int a()
    {
        if (q < 0)
        {
            b();
        }
        return q;
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
                j = true;
                a = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(s1);
                break;

            case 26: // '\032'
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

            case 34: // '"'
                String s3 = eud1.i();
                m = true;
                d = s3;
                break;

            case 40: // '('
                int j1 = eud1.f();
                n = true;
                e = j1;
                break;

            case 48: // '0'
                int k1 = eud1.f();
                o = true;
                f = k1;
                break;

            case 56: // '8'
                int l1 = eud1.f();
                g = true;
                h = l1;
                break;

            case 64: // '@'
                boolean flag = eud1.h();
                p = true;
                i = flag;
                break;

            case 72: // 'H'
                boolean flag1 = eud1.h();
                k = true;
                l = flag1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (j)
        {
            eue1.a(1, a);
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext(); eue1.a(2, (String)iterator.next())) { }
        for (Iterator iterator1 = c.iterator(); iterator1.hasNext(); eue1.a(3, (String)iterator1.next())) { }
        if (m)
        {
            eue1.a(4, d);
        }
        if (n)
        {
            eue1.a(5, e);
        }
        if (o)
        {
            eue1.a(6, f);
        }
        if (g)
        {
            eue1.a(7, h);
        }
        if (p)
        {
            eue1.a(8, i);
        }
        if (k)
        {
            eue1.a(9, l);
        }
    }

    public final int b()
    {
        int k1 = 0;
        Iterator iterator;
        int i1;
        int j1;
        int l1;
        if (j)
        {
            i1 = eue.b(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        iterator = b.iterator();
        for (j1 = 0; iterator.hasNext(); j1 = eue.a((String)iterator.next()) + j1) { }
        l1 = b.size();
        for (Iterator iterator1 = c.iterator(); iterator1.hasNext();)
        {
            k1 += eue.a((String)iterator1.next());
        }

        j1 = l1 * 1 + (i1 + j1) + k1 + c.size() * 1;
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(4, d);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.d(5, e);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(6, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(7, h);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.b(8, i);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(9, l);
        }
        q = j1;
        return j1;
    }
}
