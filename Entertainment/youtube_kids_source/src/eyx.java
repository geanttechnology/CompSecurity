// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyx extends eug
{

    private boolean a;
    private boolean b;
    private boolean c;
    private float d;
    private boolean e;
    private boolean f;
    private List g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;

    public eyx()
    {
        b = false;
        d = 0.0F;
        f = false;
        g = Collections.emptyList();
        i = false;
        k = false;
        l = -1;
    }

    public final int a()
    {
        if (l < 0)
        {
            b();
        }
        return l;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                boolean flag = eud1.h();
                a = true;
                b = flag;
                break;

            case 21: // '\025'
                float f1 = eud1.c();
                c = true;
                d = f1;
                break;

            case 24: // '\030'
                boolean flag1 = eud1.h();
                e = true;
                f = flag1;
                break;

            case 34: // '"'
                String s = eud1.i();
                if (s == null)
                {
                    throw new NullPointerException();
                }
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(s);
                break;

            case 40: // '('
                boolean flag2 = eud1.h();
                h = true;
                i = flag2;
                break;

            case 48: // '0'
                boolean flag3 = eud1.h();
                j = true;
                k = flag3;
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
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.a(4, (String)iterator.next())) { }
        if (h)
        {
            eue1.a(5, i);
        }
        if (j)
        {
            eue1.a(6, k);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (c)
        {
            j1 = i1 + eue.b(2, d);
        }
        if (e)
        {
            i1 = j1 + eue.b(3, f);
        } else
        {
            i1 = j1;
        }
        iterator = g.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        j1 = i1 + j1 + g.size() * 1;
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.b(5, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(6, k);
        }
        l = j1;
        return j1;
    }
}
