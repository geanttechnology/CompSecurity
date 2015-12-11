// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoh extends eug
{

    private boolean a;
    private epz b;
    private boolean c;
    private epz d;
    private List e;
    private int f;

    public eoh()
    {
        b = null;
        d = null;
        e = Collections.emptyList();
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

            case 10: // '\n'
                epz epz1 = new epz();
                eud1.a(epz1);
                a = true;
                b = epz1;
                break;

            case 18: // '\022'
                epz epz2 = new epz();
                eud1.a(epz2);
                c = true;
                d = epz2;
                break;

            case 26: // '\032'
                eoi eoi1 = new eoi();
                eud1.a(eoi1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(eoi1);
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
            eue1.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (eoi)iterator.next())) { }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.d(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j = eue.d(3, (eoi)iterator.next()) + j;
        }

        f = j;
        return j;
    }
}
