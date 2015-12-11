// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class erc extends eug
{

    private List a;
    private List b;
    private boolean c;
    private String d;
    private List e;
    private boolean f;
    private ere g;
    private int h;

    public erc()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        d = "";
        e = Collections.emptyList();
        g = null;
        h = -1;
    }

    public final int a()
    {
        if (h < 0)
        {
            b();
        }
        return h;
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
                if (s == null)
                {
                    throw new NullPointerException();
                }
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(s);
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 24: // '\030'
                int j = eud1.f();
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(Integer.valueOf(j));
                break;

            case 34: // '"'
                ere ere1 = new ere();
                eud1.a(ere1);
                f = true;
                g = ere1;
                break;

            case 42: // '*'
                erg erg1 = new erg();
                eud1.a(erg1);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(erg1);
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, (String)iterator.next())) { }
        if (c)
        {
            eue1.a(2, d);
        }
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext(); eue1.a(3, ((Integer)iterator1.next()).intValue())) { }
        if (f)
        {
            eue1.b(4, g);
        }
        for (Iterator iterator2 = b.iterator(); iterator2.hasNext(); eue1.b(5, (erg)iterator2.next())) { }
    }

    public final int b()
    {
        int j = 0;
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.a((String)iterator.next()) + i) { }
        i = i + 0 + a.size() * 1;
        if (c)
        {
            i += eue.b(2, d);
        }
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext();)
        {
            j += eue.a(((Integer)iterator1.next()).intValue());
        }

        j = i + j + e.size() * 1;
        i = j;
        if (f)
        {
            i = j + eue.d(4, g);
        }
        for (Iterator iterator2 = b.iterator(); iterator2.hasNext();)
        {
            i = eue.d(5, (erg)iterator2.next()) + i;
        }

        h = i;
        return i;
    }
}
