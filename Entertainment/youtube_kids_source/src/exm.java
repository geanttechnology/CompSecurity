// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exm extends eug
{

    private List a;
    private int b;

    public exm()
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
                exx exx1 = new exx();
                eud1.a(exx1);
                a(exx1);
                break;
            }
        } while (true);
    }

    public final exm a(exx exx1)
    {
        if (exx1 == null)
        {
            throw new NullPointerException();
        }
        if (a.isEmpty())
        {
            a = new ArrayList();
        }
        a.add(exx1);
        return this;
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (exx)iterator.next())) { }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(1, (exx)iterator.next()) + i) { }
        b = i;
        return i;
    }
}
