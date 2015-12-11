// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eej extends eug
{

    private boolean a;
    private String b;
    private List c;
    private boolean d;
    private long e;
    private boolean f;
    private String g;
    private int h;

    public eej()
    {
        b = "";
        c = Collections.emptyList();
        e = 0L;
        g = "";
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
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(s1);
                break;

            case 24: // '\030'
                long l = eud1.e();
                d = true;
                e = l;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                f = true;
                g = s2;
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, (String)iterator.next())) { }
        if (d)
        {
            eue1.b(3, e);
        }
        if (f)
        {
            eue1.a(4, g);
        }
    }

    public final int b()
    {
        int j = 0;
        Iterator iterator;
        int i;
        if (a)
        {
            i = eue.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        for (iterator = c.iterator(); iterator.hasNext();)
        {
            j += eue.a((String)iterator.next());
        }

        j = i + j + c.size() * 1;
        i = j;
        if (d)
        {
            i = j + eue.e(3, e);
        }
        j = i;
        if (f)
        {
            j = i + eue.b(4, g);
        }
        h = j;
        return j;
    }
}
