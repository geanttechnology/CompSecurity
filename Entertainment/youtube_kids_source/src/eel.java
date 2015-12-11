// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eel extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private int h;
    private List i;
    private List j;
    private List k;
    private int l;

    public eel()
    {
        b = "";
        d = "";
        f = "";
        h = 0;
        i = Collections.emptyList();
        j = Collections.emptyList();
        k = Collections.emptyList();
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

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 32: // ' '
                int j1 = eud1.f();
                g = true;
                h = j1;
                break;

            case 42: // '*'
                eem eem1 = new eem();
                eud1.a(eem1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(eem1);
                break;

            case 50: // '2'
                String s3 = eud1.i();
                if (s3 == null)
                {
                    throw new NullPointerException();
                }
                if (j.isEmpty())
                {
                    j = new ArrayList();
                }
                j.add(s3);
                break;

            case 58: // ':'
                String s4 = eud1.i();
                if (s4 == null)
                {
                    throw new NullPointerException();
                }
                if (k.isEmpty())
                {
                    k = new ArrayList();
                }
                k.add(s4);
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
        if (g)
        {
            eue1.a(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (eem)iterator.next())) { }
        for (Iterator iterator1 = j.iterator(); iterator1.hasNext(); eue1.a(6, (String)iterator1.next())) { }
        for (Iterator iterator2 = k.iterator(); iterator2.hasNext(); eue1.a(7, (String)iterator2.next())) { }
    }

    public final int b()
    {
        int k1 = 0;
        Iterator iterator1;
        int i1;
        int j1;
        int l1;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            i1 = eue.d(5, (eem)iterator.next()) + i1;
        }

        iterator1 = j.iterator();
        for (j1 = 0; iterator1.hasNext(); j1 = eue.a((String)iterator1.next()) + j1) { }
        l1 = j.size();
        for (Iterator iterator2 = k.iterator(); iterator2.hasNext();)
        {
            k1 += eue.a((String)iterator2.next());
        }

        i1 = l1 * 1 + (i1 + j1) + k1 + k.size() * 1;
        l = i1;
        return i1;
    }
}
