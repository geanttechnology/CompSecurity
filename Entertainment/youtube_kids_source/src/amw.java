// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class amw extends eug
{

    public boolean a;
    public String b;
    public List c;
    public boolean d;
    public int e;
    private int f;

    public amw()
    {
        b = "";
        c = Collections.emptyList();
        e = 0;
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

    public final amw a(int i)
    {
        if (c.isEmpty())
        {
            c = new ArrayList();
        }
        c.add(Integer.valueOf(i));
        return this;
    }

    public final amw a(String s)
    {
        a = true;
        b = s;
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
                if (eud1.b(i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a(eud1.i());
                break;

            case 16: // '\020'
                a(eud1.m());
                break;

            case 24: // '\030'
                b(eud1.m());
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, ((Integer)iterator.next()).intValue())) { }
        if (d)
        {
            eue1.a(3, e);
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
            j += eue.a(((Integer)iterator.next()).intValue());
        }

        j = i + j + c.size() * 1;
        i = j;
        if (d)
        {
            i = j + eue.d(3, e);
        }
        f = i;
        return i;
    }

    public final amw b(int i)
    {
        d = true;
        e = i;
        return this;
    }
}
