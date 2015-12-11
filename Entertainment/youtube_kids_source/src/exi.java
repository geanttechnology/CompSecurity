// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exi extends eug
{

    private boolean a;
    private boolean b;
    private List c;
    private boolean d;
    private eqs e;
    private boolean f;
    private eqr g;
    private boolean h;
    private eqt i;
    private boolean j;
    private eri k;
    private boolean l;
    private int m;
    private boolean n;
    private long o;
    private boolean p;
    private String q;
    private boolean r;
    private int s;
    private boolean t;
    private String u;
    private boolean v;
    private String w;
    private int x;

    public exi()
    {
        b = false;
        c = Collections.emptyList();
        e = null;
        g = null;
        i = null;
        k = null;
        m = 1;
        o = 0L;
        q = "";
        s = 0;
        u = "";
        w = "";
        x = -1;
    }

    public final int a()
    {
        if (x < 0)
        {
            b();
        }
        return x;
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

            case 16: // '\020'
                int j1 = eud1.f();
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(Integer.valueOf(j1));
                break;

            case 26: // '\032'
                eri eri1 = new eri();
                eud1.a(eri1);
                j = true;
                k = eri1;
                break;

            case 32: // ' '
                int k1 = eud1.f();
                l = true;
                m = k1;
                break;

            case 42: // '*'
                eqs eqs1 = new eqs();
                eud1.a(eqs1);
                d = true;
                e = eqs1;
                break;

            case 50: // '2'
                eqr eqr1 = new eqr();
                eud1.a(eqr1);
                a(eqr1);
                break;

            case 56: // '8'
                long l2 = eud1.e();
                n = true;
                o = l2;
                break;

            case 66: // 'B'
                String s1 = eud1.i();
                p = true;
                q = s1;
                break;

            case 74: // 'J'
                eqt eqt1 = new eqt();
                eud1.a(eqt1);
                h = true;
                i = eqt1;
                break;

            case 80: // 'P'
                int l1 = eud1.f();
                r = true;
                s = l1;
                break;

            case 90: // 'Z'
                String s2 = eud1.i();
                t = true;
                u = s2;
                break;

            case 98: // 'b'
                String s3 = eud1.i();
                v = true;
                w = s3;
                break;
            }
        } while (true);
    }

    public final exi a(eqr eqr1)
    {
        if (eqr1 == null)
        {
            throw new NullPointerException();
        } else
        {
            f = true;
            g = eqr1;
            return this;
        }
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, ((Integer)iterator.next()).intValue())) { }
        if (j)
        {
            eue1.b(3, k);
        }
        if (l)
        {
            eue1.a(4, m);
        }
        if (d)
        {
            eue1.b(5, e);
        }
        if (f)
        {
            eue1.b(6, g);
        }
        if (n)
        {
            eue1.b(7, o);
        }
        if (p)
        {
            eue1.a(8, q);
        }
        if (h)
        {
            eue1.b(9, i);
        }
        if (r)
        {
            eue1.a(10, s);
        }
        if (t)
        {
            eue1.a(11, u);
        }
        if (v)
        {
            eue1.a(12, w);
        }
    }

    public final int b()
    {
        int j1 = 0;
        Iterator iterator;
        int i1;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        } else
        {
            i1 = 0;
        }
        for (iterator = c.iterator(); iterator.hasNext();)
        {
            j1 += eue.a(((Integer)iterator.next()).intValue());
        }

        j1 = i1 + j1 + c.size() * 1;
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.d(3, k);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + eue.d(4, m);
        }
        i1 = j1;
        if (d)
        {
            i1 = j1 + eue.d(5, e);
        }
        j1 = i1;
        if (f)
        {
            j1 = i1 + eue.d(6, g);
        }
        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.e(7, o);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.b(8, q);
        }
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.d(9, i);
        }
        j1 = i1;
        if (r)
        {
            j1 = i1 + eue.d(10, s);
        }
        i1 = j1;
        if (t)
        {
            i1 = j1 + eue.b(11, u);
        }
        j1 = i1;
        if (v)
        {
            j1 = i1 + eue.b(12, w);
        }
        x = j1;
        return j1;
    }
}
