// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            g, BannerAdapter, InterstitialAdapter, n, 
//            AdAdapter, f

public class e
{

    private static final Set a;
    private static final Map b;

    public static AdAdapter a(f f1, AdPlacementType adplacementtype)
    {
        g g1 = b(f1, adplacementtype);
        if (g1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (!a.contains(g1))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        adplacementtype = g1.d;
        f1 = adplacementtype;
        if (adplacementtype != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        f1 = Class.forName(g1.e);
        f1 = (AdAdapter)f1.newInstance();
        return f1;
        f1;
        f1.printStackTrace();
        return null;
    }

    public static AdAdapter a(String s1, AdPlacementType adplacementtype)
    {
        return a(f.a(s1), adplacementtype);
    }

    public static String a(AdPlacementType adplacementtype)
    {
        if (b.containsKey(adplacementtype))
        {
            return (String)b.get(adplacementtype);
        }
        Object obj = new HashSet();
        Iterator iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            g g1 = (g)iterator.next();
            if (g1.g == adplacementtype)
            {
                ((Set) (obj)).add(g1.f.toString());
            }
        } while (true);
        obj = s.a(((Set) (obj)), ",");
        b.put(adplacementtype, obj);
        return ((String) (obj));
    }

    private static g b(f f1, AdPlacementType adplacementtype)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            g g1 = (g)iterator.next();
            if (g1.f == f1 && g1.g == adplacementtype)
            {
                return g1;
            }
        }

        return null;
    }

    static 
    {
        g ag[];
        int i;
        int j;
        a = new HashSet();
        b = new ConcurrentHashMap();
        ag = g.values();
        j = ag.length;
        i = 0;
_L5:
        g g1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        g1 = ag[i];
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[AdPlacementType.values().length];
                try
                {
                    a[AdPlacementType.BANNER.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AdPlacementType.INTERSTITIAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AdPlacementType.NATIVE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[g1.g.ordinal()];
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
            Class class2 = g1.d;
            Class class1 = class2;
            if (class2 == null)
            {
                try
                {
                    class1 = Class.forName(g1.e);
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    classnotfoundexception = class2;
                }
            }
            if (class1 != null && local.isAssignableFrom(class1))
            {
                a.add(g1);
            }
        }
        i++;
        if (true) goto _L5; else goto _L2
_L2:
        local = com/facebook/ads/internal/adapters/BannerAdapter;
          goto _L6
_L3:
        local = com/facebook/ads/internal/adapters/InterstitialAdapter;
          goto _L6
_L4:
        local = com/facebook/ads/internal/adapters/n;
          goto _L6
    }
}
