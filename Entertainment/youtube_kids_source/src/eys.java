// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eys extends eug
{

    private List a;
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private int f;

    public eys()
    {
        a = Collections.emptyList();
        c = "";
        e = "";
        f = -1;
    }

    public final int a()
    {
        if (f < 0)
        {
            b();
        }
        return f;
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

            case 8: // '\b'
                int j = eud1.f();
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(Integer.valueOf(j));
                break;

            case 18: // '\022'
                String s = eud1.i();
                b = true;
                c = s;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                d = true;
                e = s1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, ((Integer)iterator.next()).intValue())) { }
        if (b)
        {
            eue1.a(2, c);
        }
        if (d)
        {
            eue1.a(3, e);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.a(((Integer)iterator.next()).intValue()) + i) { }
        int j = i + 0 + a.size() * 1;
        i = j;
        if (b)
        {
            i = j + eue.b(2, c);
        }
        j = i;
        if (d)
        {
            j = i + eue.b(3, e);
        }
        f = j;
        return j;
    }
}
