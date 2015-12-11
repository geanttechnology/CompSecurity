// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evb extends eug
{

    private List a;
    private int b;

    public evb()
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

            case 13: // '\r'
                float f = eud1.c();
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(Float.valueOf(f));
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, ((Float)iterator.next()).floatValue())) { }
    }

    public final int b()
    {
        int i = a.size() * 4 + 0 + a.size() * 1;
        b = i;
        return i;
    }
}
