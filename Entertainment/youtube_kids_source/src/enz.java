// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class enz extends eug
{

    private List a;
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private int f;

    public enz()
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

    public final enz a(String s)
    {
        b = true;
        c = s;
        return this;
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
                b(eud1.i());
                break;

            case 26: // '\032'
                a(eud1.i());
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, ((Integer)iterator.next()).intValue())) { }
        if (d)
        {
            eue1.a(2, e);
        }
        if (b)
        {
            eue1.a(3, c);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.a(((Integer)iterator.next()).intValue()) + i) { }
        int j = i + 0 + a.size() * 1;
        i = j;
        if (d)
        {
            i = j + eue.b(2, e);
        }
        j = i;
        if (b)
        {
            j = i + eue.b(3, c);
        }
        f = j;
        return j;
    }

    public final enz b(String s)
    {
        d = true;
        e = s;
        return this;
    }
}
