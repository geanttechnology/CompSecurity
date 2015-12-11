// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class erx extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private List k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private ess q;
    private boolean r;
    private ers s;
    private int t;

    public erx()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        k = Collections.emptyList();
        m = "";
        o = "";
        q = null;
        s = null;
        t = -1;
    }

    public final int a()
    {
        if (t < 0)
        {
            b();
        }
        return t;
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
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 18: // '\022'
                String s2 = eud1.i();
                c = true;
                d = s2;
                break;

            case 26: // '\032'
                String s3 = eud1.i();
                e = true;
                f = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                g = true;
                h = s4;
                break;

            case 42: // '*'
                String s5 = eud1.i();
                i = true;
                j = s5;
                break;

            case 50: // '2'
                ery ery1 = new ery();
                eud1.a(ery1);
                if (k.isEmpty())
                {
                    k = new ArrayList();
                }
                k.add(ery1);
                break;

            case 58: // ':'
                String s6 = eud1.i();
                l = true;
                m = s6;
                break;

            case 66: // 'B'
                String s7 = eud1.i();
                n = true;
                o = s7;
                break;

            case 74: // 'J'
                ess ess1 = new ess();
                eud1.a(ess1);
                p = true;
                q = ess1;
                break;

            case 82: // 'R'
                ers ers1 = new ers();
                eud1.a(ers1);
                r = true;
                s = ers1;
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
        if (i)
        {
            eue1.a(5, j);
        }
        for (Iterator iterator = k.iterator(); iterator.hasNext(); eue1.b(6, (ery)iterator.next())) { }
        if (l)
        {
            eue1.a(7, m);
        }
        if (n)
        {
            eue1.a(8, o);
        }
        if (p)
        {
            eue1.b(9, q);
        }
        if (r)
        {
            eue1.b(10, s);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
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
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        for (Iterator iterator = k.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(6, (ery)iterator.next()) + j1;
        }

        i1 = j1;
        if (l)
        {
            i1 = j1 + eue.b(7, m);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.b(8, o);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.d(9, q);
        }
        j1 = i1;
        if (r)
        {
            j1 = i1 + eue.d(10, s);
        }
        t = j1;
        return j1;
    }
}
