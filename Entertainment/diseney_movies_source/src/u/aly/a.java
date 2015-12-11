// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package u.aly:
//            ar, aq, as

public abstract class a
{

    private final int a = 10;
    private final int b = 20;
    private final String c;
    private List d;
    private ar e;

    public a(String s)
    {
        c = s;
    }

    private boolean g()
    {
        boolean flag1 = false;
        Object obj1 = e;
        String s;
        String s1;
        int i;
        boolean flag;
        if (obj1 == null)
        {
            s = null;
        } else
        {
            s = ((ar) (obj1)).c();
        }
        if (obj1 == null)
        {
            i = 0;
        } else
        {
            i = ((ar) (obj1)).j();
        }
        s1 = a(f());
        flag = flag1;
        if (s1 != null)
        {
            flag = flag1;
            if (!s1.equals(s))
            {
                Object obj = obj1;
                if (obj1 == null)
                {
                    obj = new ar();
                }
                ((ar) (obj)).a(s1);
                ((ar) (obj)).a(System.currentTimeMillis());
                ((ar) (obj)).a(i + 1);
                obj1 = new aq();
                ((aq) (obj1)).a(c);
                ((aq) (obj1)).c(s1);
                ((aq) (obj1)).b(s);
                ((aq) (obj1)).a(((ar) (obj)).f());
                if (d == null)
                {
                    d = new ArrayList(2);
                }
                d.add(obj1);
                if (d.size() > 10)
                {
                    d.remove(0);
                }
                e = ((ar) (obj));
                flag = true;
            }
        }
        return flag;
    }

    public String a(String s)
    {
        if (s != null)
        {
            if ((s = s.trim()).length() != 0 && !"0".equals(s) && !"unknown".equals(s.toLowerCase(Locale.US)))
            {
                return s;
            }
        }
        return null;
    }

    public void a(List list)
    {
        d = list;
    }

    public void a(ar ar1)
    {
        e = ar1;
    }

    public void a(as as1)
    {
        e = (ar)as1.d().get("mName");
        as1 = as1.j();
        if (as1 == null || as1.size() <= 0) goto _L2; else goto _L1
_L1:
        if (d == null)
        {
            d = new ArrayList();
        }
        as1 = as1.iterator();
_L5:
        if (as1.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        aq aq1 = (aq)as1.next();
        if (c.equals(aq1.a))
        {
            d.add(aq1);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean a()
    {
        return g();
    }

    public String b()
    {
        return c;
    }

    public boolean c()
    {
        return e == null || e.j() <= 20;
    }

    public ar d()
    {
        return e;
    }

    public List e()
    {
        return d;
    }

    public abstract String f();
}
