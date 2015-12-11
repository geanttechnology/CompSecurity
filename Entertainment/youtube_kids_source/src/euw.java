// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class euw extends eug
{

    private boolean a;
    private long b;
    private boolean c;
    private long d;
    private boolean e;
    private float f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private long l;
    private boolean m;
    private long n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private List s;
    private boolean t;
    private float u;
    private int v;

    public euw()
    {
        b = 0L;
        d = 0L;
        f = 0.0F;
        h = 0.0F;
        j = 0.0F;
        l = 0L;
        n = 0L;
        p = "";
        r = "";
        s = Collections.emptyList();
        u = 0.0F;
        v = -1;
    }

    public final int a()
    {
        if (v < 0)
        {
            b();
        }
        return v;
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

            case 48: // '0'
                long l1 = eud1.e();
                a = true;
                b = l1;
                break;

            case 56: // '8'
                long l2 = eud1.e();
                c = true;
                d = l2;
                break;

            case 69: // 'E'
                float f1 = eud1.c();
                e = true;
                f = f1;
                break;

            case 77: // 'M'
                float f2 = eud1.c();
                g = true;
                h = f2;
                break;

            case 85: // 'U'
                float f3 = eud1.c();
                i = true;
                j = f3;
                break;

            case 88: // 'X'
                long l3 = eud1.e();
                k = true;
                l = l3;
                break;

            case 96: // '`'
                long l4 = eud1.e();
                m = true;
                n = l4;
                break;

            case 106: // 'j'
                String s1 = eud1.i();
                o = true;
                p = s1;
                break;

            case 114: // 'r'
                String s2 = eud1.i();
                q = true;
                r = s2;
                break;

            case 120: // 'x'
                long l5 = eud1.e();
                if (s.isEmpty())
                {
                    s = new ArrayList();
                }
                s.add(Long.valueOf(l5));
                break;

            case 133: 
                float f4 = eud1.c();
                t = true;
                u = f4;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(6, b);
        }
        if (c)
        {
            eue1.b(7, d);
        }
        if (e)
        {
            eue1.a(8, f);
        }
        if (g)
        {
            eue1.a(9, h);
        }
        if (i)
        {
            eue1.a(10, j);
        }
        if (k)
        {
            eue1.b(11, l);
        }
        if (m)
        {
            eue1.b(12, n);
        }
        if (o)
        {
            eue1.a(13, p);
        }
        if (q)
        {
            eue1.a(14, r);
        }
        for (Iterator iterator = s.iterator(); iterator.hasNext(); eue1.b(15, ((Long)iterator.next()).longValue())) { }
        if (t)
        {
            eue1.a(16, u);
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
            j1 = eue.e(6, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.e(7, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(8, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(9, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(10, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.e(11, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.e(12, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(13, p);
        }
        if (q)
        {
            i1 += eue.b(14, r);
        }
        iterator = s.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a(((Long)iterator.next()).longValue())) { }
        j1 = i1 + j1 + s.size() * 1;
        i1 = j1;
        if (t)
        {
            i1 = j1 + eue.b(16, u);
        }
        v = i1;
        return i1;
    }
}
