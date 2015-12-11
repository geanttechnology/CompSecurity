// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exd extends eug
{

    private List a;
    private List b;
    private int c;

    public exd()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        c = -1;
    }

    public final int a()
    {
        if (c < 0)
        {
            b();
        }
        return c;
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

            case 16: // '\020'
                int k = eud1.f();
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(Integer.valueOf(k));
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, ((Integer)iterator.next()).intValue())) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); eue1.a(2, ((Integer)iterator1.next()).intValue())) { }
    }

    public final int b()
    {
        int j = 0;
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.a(((Integer)iterator.next()).intValue()) + i) { }
        int k = a.size();
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext();)
        {
            j += eue.a(((Integer)iterator1.next()).intValue());
        }

        i = k * 1 + (i + 0) + j + b.size() * 1;
        c = i;
        return i;
    }
}
