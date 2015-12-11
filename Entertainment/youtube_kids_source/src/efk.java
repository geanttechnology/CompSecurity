// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class efk extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private een d;
    private List e;
    private int f;

    public efk()
    {
        b = "";
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                een een1 = new een();
                eud1.a(een1);
                c = true;
                d = een1;
                break;

            case 26: // '\032'
                een een2 = new een();
                eud1.a(een2);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(een2);
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (een)iterator.next())) { }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.b(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.d(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j = eue.d(3, (een)iterator.next()) + j;
        }

        f = j;
        return j;
    }
}
