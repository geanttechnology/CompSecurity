// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ezm extends eug
{

    public boolean a;
    public String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private float h;
    private List i;
    private List j;
    private boolean k;
    private String l;
    private List m;
    private boolean n;
    private eut o;
    private int p;

    public ezm()
    {
        d = "";
        b = "";
        f = "";
        h = -1F;
        i = Collections.emptyList();
        j = Collections.emptyList();
        l = "";
        m = Collections.emptyList();
        o = null;
        p = -1;
    }

    public final int a()
    {
        if (p < 0)
        {
            b();
        }
        return p;
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
                c = true;
                d = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 29: // '\035'
                float f1 = eud1.c();
                g = true;
                h = f1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 42: // '*'
                ezm ezm1 = new ezm();
                eud1.a(ezm1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(ezm1);
                break;

            case 58: // ':'
                ezk ezk1 = new ezk();
                eud1.a(ezk1);
                if (j.isEmpty())
                {
                    j = new ArrayList();
                }
                j.add(ezk1);
                break;

            case 66: // 'B'
                String s3 = eud1.i();
                k = true;
                l = s3;
                break;

            case 74: // 'J'
                ezk ezk2 = new ezk();
                eud1.a(ezk2);
                if (m.isEmpty())
                {
                    m = new ArrayList();
                }
                m.add(ezk2);
                break;

            case 146: 
                eut eut1 = new eut();
                eud1.a(eut1);
                n = true;
                o = eut1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, d);
        }
        if (a)
        {
            eue1.a(2, b);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        if (e)
        {
            eue1.a(4, f);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (ezm)iterator.next())) { }
        for (Iterator iterator1 = j.iterator(); iterator1.hasNext(); eue1.b(7, (ezk)iterator1.next())) { }
        if (k)
        {
            eue1.a(8, l);
        }
        for (Iterator iterator2 = m.iterator(); iterator2.hasNext(); eue1.b(9, (ezk)iterator2.next())) { }
        if (n)
        {
            eue1.b(18, o);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (c)
        {
            j1 = eue.b(1, d) + 0;
        }
        int i1 = j1;
        if (a)
        {
            i1 = j1 + eue.b(2, b);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(3, h);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(4, f);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            i1 = eue.d(5, (ezm)iterator.next()) + i1;
        }

        for (Iterator iterator1 = j.iterator(); iterator1.hasNext();)
        {
            i1 += eue.d(7, (ezk)iterator1.next());
        }

        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(8, l);
        }
        for (Iterator iterator2 = m.iterator(); iterator2.hasNext();)
        {
            j1 += eue.d(9, (ezk)iterator2.next());
        }

        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.d(18, o);
        }
        p = i1;
        return i1;
    }
}
