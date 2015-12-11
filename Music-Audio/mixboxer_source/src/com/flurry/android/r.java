// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.flurry.android:
//            bv

final class r
{

    private static HashMap Y = new HashMap();

    r()
    {
    }

    public static void a(String s, String s1, Object obj)
    {
        if (Y.containsKey(s))
        {
            ((bv)Y.get(s)).b(s1, obj);
            return;
        } else
        {
            bv bv1 = new bv(s);
            bv1.b(s1, obj);
            Y.put(s, bv1);
            return;
        }
    }

    public static void a(String s, String s1, String s2)
    {
        if (!Y.containsKey(s))
        {
            return;
        } else
        {
            ((bv)Y.get(s)).b(s1, s2);
            return;
        }
    }

    public static void a(String s, String s1, String s2, Object obj)
    {
        if (Y.containsKey(s))
        {
            ((bv)Y.get(s)).b(s2, obj);
            return;
        } else
        {
            s1 = new bv(s, s1);
            s1.b(s2, obj);
            Y.put(s, s1);
            return;
        }
    }

    public static boolean a(String s)
    {
        if (!Y.containsKey(s))
        {
            return false;
        } else
        {
            Y.remove(s);
            return true;
        }
    }

    public static boolean a(String s, Object obj)
    {
        if (!Y.containsKey(s))
        {
            return false;
        }
        bv bv1 = (bv)Y.get(s);
        boolean flag = bv1.a(obj);
        if (bv1.size() == 0)
        {
            Y.remove(s);
        }
        return flag;
    }

    public static boolean a(String s, String s1)
    {
        if (!Y.containsKey(s))
        {
            return false;
        }
        bv bv1 = (bv)Y.get(s);
        boolean flag = bv1.removeObserverForKey(s1);
        if (bv1.size() == 0)
        {
            Y.remove(s);
        }
        return flag;
    }

    public static boolean b(String s)
    {
        if (!Y.containsKey(s))
        {
            bv bv1 = new bv(s);
            Y.put(s, bv1);
        }
        ((bv)Y.get(s)).al();
        return true;
    }

    public static boolean c(String s)
    {
        if (!Y.containsKey(s))
        {
            return false;
        } else
        {
            ((bv)Y.get(s)).am();
            return true;
        }
    }

    public static boolean d(String s)
    {
        return Y.containsKey(s);
    }

    public static boolean e(String s)
    {
        if (!Y.containsKey(s))
        {
            return false;
        } else
        {
            return ((bv)Y.get(s)).isAutoSyncEnabled();
        }
    }

    final void start()
    {
        if (Y.size() > 0)
        {
            for (Iterator iterator = Y.values().iterator(); iterator.hasNext(); ((bv)iterator.next()).start()) { }
        }
    }

    final void stop()
    {
        if (Y.size() > 0)
        {
            for (Iterator iterator = Y.values().iterator(); iterator.hasNext(); ((bv)iterator.next()).stop()) { }
        }
    }

}
