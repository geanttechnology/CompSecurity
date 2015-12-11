// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            j, h, ax

class d extends j
{

    ArrayList a;

    d()
    {
        a = new ArrayList();
    }

    d a(j j1)
    {
        a.add(j1);
        return this;
    }

    h a(int i)
    {
        h h1 = a(i, ((h) (null)));
        if (h1 != null)
        {
            return h1;
        } else
        {
            return new h();
        }
    }

    h a(int i, h h1)
    {
        j j1 = (j)a.get(i);
        h h2 = h1;
        if (j1 != null)
        {
            h2 = h1;
            if (j1.l())
            {
                h2 = j1.m();
            }
        }
        return h2;
    }

    String a(int i, String s)
    {
        j j1 = (j)a.get(i);
        String s1 = s;
        if (j1 != null)
        {
            s1 = s;
            if (j1.b_())
            {
                s1 = j1.b();
            }
        }
        return s1;
    }

    void a(ax ax1)
    {
        int k = a.size();
        if (k == 0)
        {
            ax1.a("[]");
            return;
        }
        if (k == 1 && ((j)a.get(0)).g())
        {
            ax1.a("[");
            ((j)a.get(0)).a(ax1);
            ax1.a("]");
            return;
        }
        ax1.b("[");
        ax1.b = ax1.b + 2;
        int i = 0;
        boolean flag = true;
        while (i < k) 
        {
            if (flag)
            {
                flag = false;
            } else
            {
                ax1.c(',');
            }
            ((j)a.get(i)).a(ax1);
            i++;
        }
        ax1.b();
        ax1.b = ax1.b - 2;
        ax1.a("]");
    }

    int a_()
    {
        return a.size();
    }

    String b(int i)
    {
        return a(i, "");
    }

    boolean f()
    {
        return true;
    }

    boolean g()
    {
        return a.size() == 0 || a.size() == 1 && ((j)a.get(0)).g();
    }

    d h()
    {
        return this;
    }

    void j()
    {
        a.clear();
    }
}
