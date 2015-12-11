// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eee extends eug
{

    private List a;
    private boolean b;
    private int c;
    private boolean d;
    private String e;
    private int f;

    public eee()
    {
        a = Collections.emptyList();
        c = 0;
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

            case 10: // '\n'
                eec eec1 = new eec();
                eud1.a(eec1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(eec1);
                break;

            case 16: // '\020'
                int j = eud1.f();
                b = true;
                c = j;
                break;

            case 26: // '\032'
                String s = eud1.i();
                d = true;
                e = s;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (eec)iterator.next())) { }
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
        int j;
        for (j = 0; iterator.hasNext(); j = eue.d(1, (eec)iterator.next()) + j) { }
        int i = j;
        if (b)
        {
            i = j + eue.d(2, c);
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
