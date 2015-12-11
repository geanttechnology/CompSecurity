// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class efe extends eug
{

    private boolean a;
    private efg b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private List g;
    private List h;
    private List i;
    private List j;
    private int k;

    public efe()
    {
        b = null;
        d = "";
        f = "";
        g = Collections.emptyList();
        h = Collections.emptyList();
        i = Collections.emptyList();
        j = Collections.emptyList();
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
                efg efg1 = new efg();
                eud1.a(efg1);
                a = true;
                b = efg1;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(s2);
                break;

            case 42: // '*'
                eff eff1 = new eff();
                eud1.a(eff1);
                if (h.isEmpty())
                {
                    h = new ArrayList();
                }
                h.add(eff1);
                break;

            case 50: // '2'
                efi efi1 = new efi();
                eud1.a(efi1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(efi1);
                break;

            case 58: // ':'
                efh efh1 = new efh();
                eud1.a(efh1);
                if (j.isEmpty())
                {
                    j = new ArrayList();
                }
                j.add(efh1);
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
        if (e)
        {
            eue1.a(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.a(4, (String)iterator.next())) { }
        for (Iterator iterator1 = h.iterator(); iterator1.hasNext(); eue1.b(5, (eff)iterator1.next())) { }
        for (Iterator iterator2 = i.iterator(); iterator2.hasNext(); eue1.b(6, (efi)iterator2.next())) { }
        for (Iterator iterator3 = j.iterator(); iterator3.hasNext(); eue1.b(7, (efh)iterator3.next())) { }
    }

    public final int b()
    {
        int j1 = 0;
        Iterator iterator;
        int l;
        int i1;
        if (a)
        {
            l = eue.d(1, b) + 0;
        } else
        {
            l = 0;
        }
        i1 = l;
        if (c)
        {
            i1 = l + eue.b(2, d);
        }
        if (e)
        {
            l = i1 + eue.b(3, f);
        } else
        {
            l = i1;
        }
        iterator = g.iterator();
        for (i1 = j1; iterator.hasNext(); i1 += eue.a((String)iterator.next())) { }
        j1 = g.size();
        iterator = h.iterator();
        for (l = l + i1 + j1 * 1; iterator.hasNext(); l = eue.d(5, (eff)iterator.next()) + l) { }
        for (Iterator iterator1 = i.iterator(); iterator1.hasNext();)
        {
            l += eue.d(6, (efi)iterator1.next());
        }

        for (Iterator iterator2 = j.iterator(); iterator2.hasNext();)
        {
            l += eue.d(7, (efh)iterator2.next());
        }

        k = l;
        return l;
    }
}
