// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class epg extends eug
{

    private List a;
    private boolean b;
    private erd c;
    private int d;

    public epg()
    {
        a = Collections.emptyList();
        c = null;
        d = -1;
    }

    public final int a()
    {
        if (d < 0)
        {
            b();
        }
        return d;
    }

    public final epg a(enl enl1)
    {
        if (enl1 == null)
        {
            throw new NullPointerException();
        }
        if (a.isEmpty())
        {
            a = new ArrayList();
        }
        a.add(enl1);
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

            case 18: // '\022'
                enl enl1 = new enl();
                eud1.a(enl1);
                a(enl1);
                break;

            case 26: // '\032'
                erd erd1 = new erd();
                eud1.a(erd1);
                b = true;
                c = erd1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(2, (enl)iterator.next())) { }
        if (b)
        {
            eue1.b(3, c);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(2, (enl)iterator.next()) + i) { }
        int j = i;
        if (b)
        {
            j = i + eue.d(3, c);
        }
        d = j;
        return j;
    }
}
