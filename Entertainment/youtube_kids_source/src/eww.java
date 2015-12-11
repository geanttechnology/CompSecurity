// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eww extends eug
{

    private boolean a;
    private String b;
    private List c;
    private List d;
    private int e;

    public eww()
    {
        b = "/search";
        c = Collections.emptyList();
        d = Collections.emptyList();
        e = -1;
    }

    public final int a()
    {
        if (e < 0)
        {
            b();
        }
        return e;
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
                ewt ewt1 = new ewt();
                eud1.a(ewt1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(ewt1);
                break;

            case 18: // '\022'
                ewu ewu1 = new ewu();
                eud1.a(ewu1);
                if (d.isEmpty())
                {
                    d = new ArrayList();
                }
                d.add(ewu1);
                break;

            case 26: // '\032'
                String s = eud1.i();
                a = true;
                b = s;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(1, (ewt)iterator.next())) { }
        for (Iterator iterator1 = d.iterator(); iterator1.hasNext(); eue1.b(2, (ewu)iterator1.next())) { }
        if (a)
        {
            eue1.a(3, b);
        }
    }

    public final int b()
    {
        Iterator iterator = c.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(1, (ewt)iterator.next()) + i) { }
        for (Iterator iterator1 = d.iterator(); iterator1.hasNext();)
        {
            i += eue.d(2, (ewu)iterator1.next());
        }

        int j = i;
        if (a)
        {
            j = i + eue.b(3, b);
        }
        e = j;
        return j;
    }
}
