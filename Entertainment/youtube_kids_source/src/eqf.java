// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eqf extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private List g;
    private boolean h;
    private String i;
    private int j;

    public eqf()
    {
        b = "";
        d = "";
        f = "";
        g = Collections.emptyList();
        i = "";
        j = -1;
    }

    public final int a()
    {
        if (j < 0)
        {
            b();
        }
        return j;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int k = eud1.a();
            switch (k)
            {
            default:
                if (a(eud1, k))
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
                e = true;
                f = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(s2);
                break;

            case 34: // '"'
                String s3 = eud1.i();
                c = true;
                d = s3;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                h = true;
                i = s4;
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
        if (e)
        {
            eue1.a(2, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.a(3, (String)iterator.next())) { }
        if (c)
        {
            eue1.a(4, d);
        }
        if (h)
        {
            eue1.a(5, i);
        }
    }

    public final int b()
    {
        int l = 0;
        int k;
        if (a)
        {
            k = eue.b(1, b) + 0;
        } else
        {
            k = 0;
        }
        if (e)
        {
            k += eue.b(2, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext();)
        {
            l += eue.a((String)iterator.next());
        }

        l = k + l + g.size() * 1;
        k = l;
        if (c)
        {
            k = l + eue.b(4, d);
        }
        l = k;
        if (h)
        {
            l = k + eue.b(5, i);
        }
        j = l;
        return l;
    }
}
