// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class epp extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private enl d;
    private List e;
    private List f;
    private boolean g;
    private String h;
    private List i;
    private int j;

    public epp()
    {
        b = "";
        d = null;
        e = Collections.emptyList();
        f = Collections.emptyList();
        h = "";
        i = Collections.emptyList();
        j = -1;
    }

    public final int a()
    {
        if (j < 0)
        {
            b();
        }
        return j;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int k = eud1.a();
            switch (k)
            {
            default:
                if (a(eud1, k))
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
                enl enl1 = new enl();
                eud1.a(enl1);
                c = true;
                d = enl1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                g = true;
                h = s1;
                break;

            case 34: // '"'
                eub eub1 = new eub();
                eud1.a(eub1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(eub1);
                break;

            case 42: // '*'
                enm enm1 = new enm();
                eud1.a(enm1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(enm1);
                break;

            case 50: // '2'
                erd erd1 = new erd();
                eud1.a(erd1);
                if (f.isEmpty())
                {
                    f = new ArrayList();
                }
                f.add(erd1);
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
            eue1.b(2, d);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(4, (eub)iterator.next())) { }
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext(); eue1.b(5, (enm)iterator1.next())) { }
        for (Iterator iterator2 = f.iterator(); iterator2.hasNext(); eue1.b(6, (erd)iterator2.next())) { }
    }

    public final int b()
    {
        int l = 0;
        if (a)
        {
            l = eue.b(1, b) + 0;
        }
        int k = l;
        if (c)
        {
            k = l + eue.d(2, d);
        }
        l = k;
        if (g)
        {
            l = k + eue.b(3, h);
        }
        Iterator iterator = i.iterator();
        for (k = l; iterator.hasNext(); k = eue.d(4, (eub)iterator.next()) + k) { }
        for (Iterator iterator1 = e.iterator(); iterator1.hasNext();)
        {
            k += eue.d(5, (enm)iterator1.next());
        }

        for (Iterator iterator2 = f.iterator(); iterator2.hasNext();)
        {
            k += eue.d(6, (erd)iterator2.next());
        }

        j = k;
        return k;
    }
}
