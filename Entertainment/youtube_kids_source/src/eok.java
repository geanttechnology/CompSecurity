// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eok extends eug
{

    private List a;
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private String g;
    private boolean h;
    private euc i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private int o;
    private boolean p;
    private boolean q;
    private List r;
    private int s;

    public eok()
    {
        a = Collections.emptyList();
        c = "";
        e = "";
        g = "";
        i = euc.b;
        k = "";
        m = "";
        o = 1;
        q = false;
        r = Collections.emptyList();
        s = -1;
    }

    public final int a()
    {
        if (s < 0)
        {
            b();
        }
        return s;
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
                ent ent1 = new ent();
                eud1.a(ent1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(ent1);
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                b = true;
                c = s1;
                break;

            case 26: // '\032'
                euc euc1 = eud1.j();
                h = true;
                i = euc1;
                break;

            case 34: // '"'
                eou eou1 = new eou();
                eud1.a(eou1);
                if (r.isEmpty())
                {
                    r = new ArrayList();
                }
                r.add(eou1);
                break;

            case 42: // '*'
                String s2 = eud1.i();
                j = true;
                k = s2;
                break;

            case 50: // '2'
                String s3 = eud1.i();
                d = true;
                e = s3;
                break;

            case 58: // ':'
                String s4 = eud1.i();
                f = true;
                g = s4;
                break;

            case 64: // '@'
                int j1 = eud1.f();
                n = true;
                o = j1;
                break;

            case 72: // 'H'
                boolean flag = eud1.h();
                p = true;
                q = flag;
                break;

            case 82: // 'R'
                String s5 = eud1.i();
                l = true;
                m = s5;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (ent)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
        if (h)
        {
            eue1.a(3, i);
        }
        for (Iterator iterator1 = r.iterator(); iterator1.hasNext(); eue1.b(4, (eou)iterator1.next())) { }
        if (j)
        {
            eue1.a(5, k);
        }
        if (d)
        {
            eue1.a(6, e);
        }
        if (f)
        {
            eue1.a(7, g);
        }
        if (n)
        {
            eue1.a(8, o);
        }
        if (p)
        {
            eue1.a(9, q);
        }
        if (l)
        {
            eue1.a(10, m);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = eue.d(1, (ent)iterator.next()) + j1) { }
        int i1 = j1;
        if (b)
        {
            i1 = j1 + eue.b(2, c);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(3, i);
        }
        for (Iterator iterator1 = r.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(4, (eou)iterator1.next());
        }

        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.b(5, k);
        }
        j1 = i1;
        if (d)
        {
            j1 = i1 + eue.b(6, e);
        }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(7, g);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.d(8, o);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.b(9, q);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + eue.b(10, m);
        }
        s = j1;
        return j1;
    }
}
