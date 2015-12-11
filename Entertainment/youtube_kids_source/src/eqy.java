// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eqy extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private List g;
    private List h;
    private List i;
    private boolean j;
    private boolean k;
    private int l;

    public eqy()
    {
        b = "";
        d = "";
        f = "";
        g = Collections.emptyList();
        h = Collections.emptyList();
        i = Collections.emptyList();
        k = false;
        l = -1;
    }

    public final int a()
    {
        if (l < 0)
        {
            b();
        }
        return l;
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
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 34: // '"'
                erb erb1 = new erb();
                eud1.a(erb1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(erb1);
                break;

            case 42: // '*'
                eqz eqz1 = new eqz();
                eud1.a(eqz1);
                if (h.isEmpty())
                {
                    h = new ArrayList();
                }
                h.add(eqz1);
                break;

            case 50: // '2'
                era era1 = new era();
                eud1.a(era1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(era1);
                break;

            case 56: // '8'
                boolean flag = eud1.h();
                j = true;
                k = flag;
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
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (erb)iterator.next())) { }
        for (Iterator iterator1 = h.iterator(); iterator1.hasNext(); eue1.b(5, (eqz)iterator1.next())) { }
        for (Iterator iterator2 = i.iterator(); iterator2.hasNext(); eue1.b(6, (era)iterator2.next())) { }
        if (j)
        {
            eue1.a(7, k);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        Iterator iterator = g.iterator();
        for (i1 = j1; iterator.hasNext(); i1 = eue.d(4, (erb)iterator.next()) + i1) { }
        for (Iterator iterator1 = h.iterator(); iterator1.hasNext();)
        {
            i1 += eue.d(5, (eqz)iterator1.next());
        }

        for (Iterator iterator2 = i.iterator(); iterator2.hasNext();)
        {
            i1 += eue.d(6, (era)iterator2.next());
        }

        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(7, k);
        }
        l = j1;
        return j1;
    }
}
