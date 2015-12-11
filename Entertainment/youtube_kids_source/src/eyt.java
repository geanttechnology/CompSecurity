// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyt extends eug
{

    public List a;
    private int b;

    public eyt()
    {
        a = Collections.emptyList();
        b = -1;
    }

    public final int a()
    {
        if (b < 0)
        {
            b();
        }
        return b;
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
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, (String)iterator.next())) { }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.a((String)iterator.next()) + i) { }
        i = i + 0 + a.size() * 1;
        b = i;
        return i;
    }
}
