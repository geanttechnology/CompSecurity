// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eqp extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private eqc d;
    private List e;
    private boolean f;
    private eqd g;
    private int h;

    public eqp()
    {
        b = "";
        d = null;
        e = Collections.emptyList();
        g = null;
        h = -1;
    }

    public final int a()
    {
        if (h < 0)
        {
            b();
        }
        return h;
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
                eqc eqc1 = new eqc();
                eud1.a(eqc1);
                c = true;
                d = eqc1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(s1);
                break;

            case 34: // '"'
                eqd eqd1 = new eqd();
                eud1.a(eqd1);
                f = true;
                g = eqd1;
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(3, (String)iterator.next())) { }
        if (f)
        {
            eue1.b(4, g);
        }
    }

    public final int b()
    {
        int j = 0;
        int i;
        if (a)
        {
            i = eue.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        if (c)
        {
            i += eue.d(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j += eue.a((String)iterator.next());
        }

        j = i + j + e.size() * 1;
        i = j;
        if (f)
        {
            i = j + eue.d(4, g);
        }
        h = i;
        return i;
    }
}
