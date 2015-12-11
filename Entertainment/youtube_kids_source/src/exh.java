// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exh extends eug
{

    public List a;
    private boolean b;
    private ewz c;
    private List d;
    private boolean e;
    private ewz f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private boolean p;
    private int q;

    public exh()
    {
        a = Collections.emptyList();
        c = null;
        d = Collections.emptyList();
        f = null;
        h = "";
        j = "";
        l = "";
        n = "";
        p = true;
        q = -1;
    }

    public final int a()
    {
        if (q < 0)
        {
            b();
        }
        return q;
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

            case 18: // '\022'
                ewz ewz1 = new ewz();
                eud1.a(ewz1);
                a(ewz1);
                break;

            case 26: // '\032'
                ewz ewz2 = new ewz();
                eud1.a(ewz2);
                b(ewz2);
                break;

            case 34: // '"'
                ewz ewz3 = new ewz();
                eud1.a(ewz3);
                if (d.isEmpty())
                {
                    d = new ArrayList();
                }
                d.add(ewz3);
                break;

            case 42: // '*'
                a(eud1.i());
                break;

            case 50: // '2'
                String s = eud1.i();
                k = true;
                l = s;
                break;

            case 66: // 'B'
                b(eud1.i());
                break;

            case 74: // 'J'
                ewy ewy1 = new ewy();
                eud1.a(ewy1);
                a(ewy1);
                break;

            case 98: // 'b'
                String s1 = eud1.i();
                i = true;
                j = s1;
                break;

            case 104: // 'h'
                a(eud1.h());
                break;
            }
        } while (true);
    }

    public final exh a(ewy ewy1)
    {
        if (ewy1 == null)
        {
            throw new NullPointerException();
        }
        if (a.isEmpty())
        {
            a = new ArrayList();
        }
        a.add(ewy1);
        return this;
    }

    public final exh a(ewz ewz1)
    {
        if (ewz1 == null)
        {
            throw new NullPointerException();
        } else
        {
            b = true;
            c = ewz1;
            return this;
        }
    }

    public final exh a(String s)
    {
        g = true;
        h = s;
        return this;
    }

    public final exh a(boolean flag)
    {
        o = true;
        p = flag;
        return this;
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.b(2, c);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        for (Iterator iterator = d.iterator(); iterator.hasNext(); eue1.b(4, (ewz)iterator.next())) { }
        if (g)
        {
            eue1.a(5, h);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(8, n);
        }
        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); eue1.b(9, (ewy)iterator1.next())) { }
        if (i)
        {
            eue1.a(12, j);
        }
        if (o)
        {
            eue1.a(13, p);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (b)
        {
            i1 = eue.d(2, c) + 0;
        }
        int j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(4, (ewz)iterator.next()) + j1;
        }

        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(5, h);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(6, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(8, n);
        }
        Iterator iterator1 = a.iterator();
        for (j1 = i1; iterator1.hasNext(); j1 += eue.d(9, (ewy)iterator1.next())) { }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(12, j);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(13, p);
        }
        q = j1;
        return j1;
    }

    public final exh b(ewz ewz1)
    {
        if (ewz1 == null)
        {
            throw new NullPointerException();
        } else
        {
            e = true;
            f = ewz1;
            return this;
        }
    }

    public final exh b(String s)
    {
        m = true;
        n = s;
        return this;
    }
}
