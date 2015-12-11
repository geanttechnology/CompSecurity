// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            a, w

static final class it> extends it>
    implements Serializable
{

    HashMap a;
    ArrayList b;

    final it> a(String s)
    {
        s = (it>)a.get(s);
        if (s != null && s.l())
        {
            s = s.m();
        } else
        {
            s = null;
        }
        if (s != null)
        {
            return s;
        } else
        {
            return new <init>();
        }
    }

    final String a(int i)
    {
        return (String)b.get(i);
    }

    final String a(String s, String s1)
    {
          = ()a.get(s);
        s = s1;
        if ( != null)
        {
            s = s1;
            if (.j())
            {
                s = .b();
            }
        }
        return s;
    }

    final void a(w w1)
    {
        int j = b.size();
        if (j == 0)
        {
            w1.a("{}");
            return;
        }
        if (j == 1 && ((e)a.get(b.get(0))).g())
        {
            w1.a("{");
            String s = (String)b.get(0);
            b b1 = ()a.get(s);
            a(w1, s);
            w1.b(':');
            b1.a(w1);
            w1.a("}");
            return;
        }
        w1.b("{");
        w1.b = w1.b + 2;
        int i = 0;
        boolean flag = true;
        while (i < j) 
        {
            String s1;
            b b2;
            if (flag)
            {
                flag = false;
            } else
            {
                w1.b();
            }
            s1 = (String)b.get(i);
            b2 = ()a.get(s1);
            a(w1, s1);
            w1.b(':');
            if (!b2.g())
            {
                w1.b('\n');
            }
            b2.a(w1);
            i++;
        }
        w1.b('\n');
        w1.b = w1.b - 2;
        w1.a("}");
    }

    final void a(String s, double d1)
    {
        a(s, ((a) (new <init>(d1))));
    }

    final void a(String s, int i)
    {
        a(s, ((a) (new <init>(i))));
    }

    final void a(String s, <init> <init>1)
    {
        if (!a.containsKey(s))
        {
            b.add(s);
        }
        a.put(s, <init>1);
    }

    final boolean a(String s, boolean flag)
    {
        boolean flag1;
label0:
        {
            s = (a)a.get(s);
            flag1 = flag;
            if (s == null)
            {
                break label0;
            }
            if (!s.a())
            {
                flag1 = flag;
                if (!s.j())
                {
                    break label0;
                }
            }
            flag1 = s.k();
        }
        return flag1;
    }

    final k b(String s)
    {
        s = (k)a.get(s);
        if (s != null && s.f())
        {
            s = s.h();
        } else
        {
            s = null;
        }
        if (s != null)
        {
            return s;
        } else
        {
            return new <init>();
        }
    }

    final void b(String s, String s1)
    {
        a(s, new <init>(s1));
    }

    final void b(String s, boolean flag)
    {
        <init> <init>1;
        if (flag)
        {
            <init>1 = a.a;
        } else
        {
            <init>1 = a.b;
        }
        a(s, <init>1);
    }

    final ArrayList c(String s)
    {
        a a1 = b(s);
        Object obj;
        if (a1 == null)
        {
            s = null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            int i = 0;
            while (i < a1.a.size()) 
            {
                s = (e)a1.a.get(i);
                if (s != null && s.j())
                {
                    s = s.b();
                } else
                {
                    s = "";
                }
                if (s != null)
                {
                    arraylist.add(s);
                }
                i++;
            }
            s = arraylist;
        }
        obj = s;
        if (s == null)
        {
            obj = new ArrayList();
        }
        return ((ArrayList) (obj));
    }

    final double d(String s)
    {
        s = (it>)a.get(s);
        if (s != null && s.n())
        {
            return s.d();
        } else
        {
            return 0.0D;
        }
    }

    final int e(String s)
    {
        s = (d)a.get(s);
        if (s != null && s.n())
        {
            return s.e();
        } else
        {
            return 0;
        }
    }

    final boolean g()
    {
        return a.size() < 0 || a.size() == 1 && ((a)a.get(b.get(0))).g();
    }

    final boolean l()
    {
        return true;
    }

    final g m()
    {
        return this;
    }

    ()
    {
        a = new HashMap();
        b = new ArrayList();
    }
}
