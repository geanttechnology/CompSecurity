// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esa extends eug
{

    private List a;
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private int l;

    public esa()
    {
        a = Collections.emptyList();
        c = "";
        e = "";
        g = "";
        i = "";
        k = "";
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
                erz erz1 = new erz();
                eud1.a(erz1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(erz1);
                break;

            case 18: // '\022'
                String s = eud1.i();
                b = true;
                c = s;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                d = true;
                e = s1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                f = true;
                g = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                h = true;
                i = s3;
                break;

            case 50: // '2'
                String s4 = eud1.i();
                j = true;
                k = s4;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (erz)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
        if (d)
        {
            eue1.a(3, e);
        }
        if (f)
        {
            eue1.a(4, g);
        }
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
        Iterator iterator = a.iterator();
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = eue.d(1, (erz)iterator.next()) + j1) { }
        int i1 = j1;
        if (b)
        {
            i1 = j1 + eue.b(2, c);
        }
        j1 = i1;
        if (d)
        {
            j1 = i1 + eue.b(3, e);
        }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(4, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(5, i);
        }
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.b(6, k);
        }
        l = i1;
        return i1;
    }
}
