// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ene extends eug
{

    private List a;
    private List b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private int g;

    public ene()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        d = "";
        f = "";
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
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

            case 18: // '\022'
                end end1 = new end();
                eud1.a(end1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(end1);
                break;

            case 26: // '\032'
                end end2 = new end();
                eud1.a(end2);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(end2);
                break;

            case 34: // '"'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 42: // '*'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(2, (end)iterator.next())) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); eue1.b(3, (end)iterator1.next())) { }
        if (c)
        {
            eue1.a(4, d);
        }
        if (e)
        {
            eue1.a(5, f);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j;
        for (j = 0; iterator.hasNext(); j = eue.d(2, (end)iterator.next()) + j) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext();)
        {
            j += eue.d(3, (end)iterator1.next());
        }

        int i = j;
        if (c)
        {
            i = j + eue.b(4, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.b(5, f);
        }
        g = j;
        return j;
    }
}
