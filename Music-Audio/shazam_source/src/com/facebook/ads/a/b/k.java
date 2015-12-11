// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import com.facebook.ads.a.e.a;
import com.facebook.ads.a.f.t;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.facebook.ads.a.b:
//            m, b, d, u, 
//            a, l

public final class k
{

    private static final Set a;
    private static final Map b;

    private static com.facebook.ads.a.b.a a(l l1, a a1)
    {
        Iterator iterator = a.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (m)iterator.next();
        if (((m) (obj)).f != l1 || ((m) (obj)).g != a1) goto _L4; else goto _L3
_L3:
        l1 = ((l) (obj));
_L6:
        if (l1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!a.contains(l1))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((m) (l1)).d;
        a1 = ((a) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        a1 = Class.forName(((m) (l1)).e);
        l1 = (com.facebook.ads.a.b.a)a1.newInstance();
        return l1;
_L2:
        l1 = null;
        if (true) goto _L6; else goto _L5
        l1;
        l1.printStackTrace();
_L5:
        return null;
    }

    public static com.facebook.ads.a.b.a a(String s, a a1)
    {
        return a(com.facebook.ads.a.b.l.a(s), a1);
    }

    public static String a(a a1)
    {
        if (b.containsKey(a1))
        {
            return (String)b.get(a1);
        }
        Object obj = new HashSet();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            m m1 = (m)iterator.next();
            if (m1.g == a1)
            {
                ((Set) (obj)).add(m1.f.toString());
            }
        } while (true);
        obj = t.a(((Set) (obj)), ",");
        b.put(a1, obj);
        return ((String) (obj));
    }

    static 
    {
        m am[];
        int i;
        int j;
        a = new HashSet();
        b = new ConcurrentHashMap();
        am = m.values();
        j = am.length;
        i = 0;
_L5:
        m m1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        m1 = am[i];
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.a.e.a.values().length];
                try
                {
                    a[a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.facebook.ads.a.b._cls1.a[m1.g.ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 143
    //                   2 149
    //                   3 155;
           goto _L1 _L2 _L3 _L4
_L1:
        /*<invalid signature>*/java.lang.Object local = null;
_L6:
        if (local != null)
        {
            Class class2 = m1.d;
            Class class1 = class2;
            if (class2 == null)
            {
                try
                {
                    class1 = Class.forName(m1.e);
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    classnotfoundexception = class2;
                }
            }
            if (class1 != null && local.isAssignableFrom(class1))
            {
                a.add(m1);
            }
        }
        i++;
        if (true) goto _L5; else goto _L2
_L2:
        local = com/facebook/ads/a/b/b;
          goto _L6
_L3:
        local = com/facebook/ads/a/b/d;
          goto _L6
_L4:
        local = com/facebook/ads/a/b/u;
          goto _L6
    }
}
