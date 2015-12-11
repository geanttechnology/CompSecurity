// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            j, d, ax, f, 
//            c, g, a

class h extends j
    implements Serializable
{

    HashMap a;
    ArrayList b;

    h()
    {
        a = new HashMap();
        b = new ArrayList();
    }

    double a(String s, double d1)
    {
        s = (j)a.get(s);
        double d2 = d1;
        if (s != null)
        {
            d2 = d1;
            if (s.o())
            {
                d2 = s.d();
            }
        }
        return d2;
    }

    int a(String s, int i)
    {
        s = (j)a.get(s);
        int k = i;
        if (s != null)
        {
            k = i;
            if (s.o())
            {
                k = s.e();
            }
        }
        return k;
    }

    d a(String s, d d1)
    {
        j j1 = (j)a.get(s);
        s = d1;
        if (j1 != null)
        {
            s = d1;
            if (j1.f())
            {
                s = j1.h();
            }
        }
        return s;
    }

    h a(String s)
    {
        s = a(s, ((h) (null)));
        if (s != null)
        {
            return s;
        } else
        {
            return new h();
        }
    }

    h a(String s, h h1)
    {
        j j1 = (j)a.get(s);
        s = h1;
        if (j1 != null)
        {
            s = h1;
            if (j1.l())
            {
                s = j1.m();
            }
        }
        return s;
    }

    String a(int i)
    {
        return (String)b.get(i);
    }

    String a(String s, String s1)
    {
        j j1 = (j)a.get(s);
        s = s1;
        if (j1 != null)
        {
            s = s1;
            if (j1.b_())
            {
                s = j1.b();
            }
        }
        return s;
    }

    ArrayList a(String s, ArrayList arraylist)
    {
        d d1 = b(s);
        if (d1 != null) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        s = new ArrayList();
        int i = 0;
        do
        {
            arraylist = s;
            if (i >= d1.a_())
            {
                continue;
            }
            arraylist = d1.b(i);
            if (arraylist != null)
            {
                s.add(arraylist);
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    void a(ax ax1)
    {
        int k = b.size();
        if (k == 0)
        {
            ax1.a("{}");
            return;
        }
        if (k == 1 && ((j)a.get(b.get(0))).g())
        {
            ax1.a("{");
            String s = (String)b.get(0);
            j j1 = (j)a.get(s);
            a(ax1, s);
            ax1.b(':');
            j1.a(ax1);
            ax1.a("}");
            return;
        }
        ax1.b("{");
        ax1.b = ax1.b + 2;
        int i = 0;
        boolean flag = true;
        while (i < k) 
        {
            String s1;
            j j2;
            if (flag)
            {
                flag = false;
            } else
            {
                ax1.c(',');
            }
            s1 = (String)b.get(i);
            j2 = (j)a.get(s1);
            a(ax1, s1);
            ax1.b(':');
            if (!j2.g())
            {
                ax1.b();
            }
            j2.a(ax1);
            i++;
        }
        ax1.b();
        ax1.b = ax1.b - 2;
        ax1.a("}");
    }

    void a(String s, j j1)
    {
        if (!a.containsKey(s))
        {
            b.add(s);
        }
        a.put(s, j1);
    }

    boolean a(String s, boolean flag)
    {
        boolean flag1;
label0:
        {
            s = (j)a.get(s);
            flag1 = flag;
            if (s == null)
            {
                break label0;
            }
            if (!s.a())
            {
                flag1 = flag;
                if (!s.b_())
                {
                    break label0;
                }
            }
            flag1 = s.k();
        }
        return flag1;
    }

    d b(String s)
    {
        s = a(s, ((d) (null)));
        if (s != null)
        {
            return s;
        } else
        {
            return new d();
        }
    }

    void b(String s, double d1)
    {
        a(s, new f(d1));
    }

    void b(String s, int i)
    {
        a(s, new c(i));
    }

    void b(String s, String s1)
    {
        a(s, new g(s1));
    }

    void b(String s, boolean flag)
    {
        j j1;
        if (flag)
        {
            j1 = a.a;
        } else
        {
            j1 = a.b;
        }
        a(s, j1);
    }

    ArrayList c(String s)
    {
        ArrayList arraylist = a(s, ((ArrayList) (null)));
        s = arraylist;
        if (arraylist == null)
        {
            s = new ArrayList();
        }
        return s;
    }

    String d(String s)
    {
        return a(s, "");
    }

    double e(String s)
    {
        return a(s, 0.0D);
    }

    int f(String s)
    {
        return a(s, 0);
    }

    boolean g()
    {
        return a.size() < 0 || a.size() == 1 && ((j)a.get(b.get(0))).g();
    }

    boolean g(String s)
    {
        return a(s, false);
    }

    boolean l()
    {
        return true;
    }

    h m()
    {
        return this;
    }

    int n()
    {
        return b.size();
    }
}
