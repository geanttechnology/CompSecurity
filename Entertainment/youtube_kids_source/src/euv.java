// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class euv extends eug
{

    private boolean a;
    private float b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private boolean g;
    private float h;
    private List i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private String q;
    private boolean r;
    private int s;
    private int t;

    public euv()
    {
        b = 0.0F;
        d = 0.0F;
        f = 0.0F;
        h = 0.0F;
        i = Collections.emptyList();
        k = "";
        m = "";
        o = "";
        q = "";
        s = 1;
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

            case 13: // '\r'
                float f1 = eud1.c();
                a = true;
                b = f1;
                break;

            case 21: // '\025'
                float f2 = eud1.c();
                c = true;
                d = f2;
                break;

            case 29: // '\035'
                float f3 = eud1.c();
                e = true;
                f = f3;
                break;

            case 37: // '%'
                float f4 = eud1.c();
                g = true;
                h = f4;
                break;

            case 43: // '+'
                euw euw1 = new euw();
                eud1.a(euw1, 5);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(euw1);
                break;

            case 138: 
                String s1 = eud1.i();
                j = true;
                k = s1;
                break;

            case 146: 
                String s2 = eud1.i();
                l = true;
                m = s2;
                break;

            case 154: 
                String s3 = eud1.i();
                n = true;
                o = s3;
                break;

            case 162: 
                String s4 = eud1.i();
                p = true;
                q = s4;
                break;

            case 168: 
                int j1 = eud1.f();
                r = true;
                s = j1;
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
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.a(5, (euw)iterator.next())) { }
        if (j)
        {
            eue1.a(17, k);
        }
        if (l)
        {
            eue1.a(18, m);
        }
        if (n)
        {
            eue1.a(19, o);
        }
        if (p)
        {
            eue1.a(20, q);
        }
        if (r)
        {
            eue1.a(21, s);
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
        Iterator iterator = i.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.c(5, (euw)iterator.next()) + j1) { }
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.b(17, k);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + eue.b(18, m);
        }
        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.b(19, o);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.b(20, q);
        }
        i1 = j1;
        if (r)
        {
            i1 = j1 + eue.d(21, s);
        }
        t = i1;
        return i1;
    }
}
