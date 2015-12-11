// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.analytics;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class MimsUtil
{

    private static final String LOG_TAG = "MIMSTracking";
    public static String PROVIDER_ID_MARKETPLACE = "MP";
    public static String PROVIDER_ID_PAYPAL = "PP";
    public static String PROVIDER_ID_REDLASER = "RL";
    private static HashMap mimsActiveProviders = null;
    private static LinkedHashMap mimsIdentityCache = null;
    private static String mimsIdentityStringEncoded = null;
    private static AtomicLong providerScopeNextId = new AtomicLong();
    private static HashMap providerScopeRegistry = new HashMap();

    public MimsUtil()
    {
    }

    public static void addIdentity(String s, String s1)
    {
        LinkedHashMap linkedhashmap = getMimsProviderMap();
        if (!linkedhashmap.containsKey(s))
        {
            linkedhashmap.put(s, new LinkedList());
        }
        if (s1 != null && s1.length() > 0)
        {
            s = (List)linkedhashmap.get(s);
            if (!s.contains(s1))
            {
                s.add(s1);
            }
        }
        rebuildIdsString();
    }

    public static String getIdentityStringEncoded()
    {
        if (mimsIdentityStringEncoded == null)
        {
            initializeMimsProviders();
        }
        return mimsIdentityStringEncoded;
    }

    private static LinkedHashMap getMimsProviderMap()
    {
        if (mimsIdentityCache == null)
        {
            initializeMimsProviders();
        }
        return mimsIdentityCache;
    }

    public static void initializeMimsProviders()
    {
        mimsIdentityCache = new LinkedHashMap();
        mimsActiveProviders = new HashMap();
        useProvider(PROVIDER_ID_MARKETPLACE);
    }

    private static void rebuildIdsString()
    {
        StringBuilder stringbuilder;
        Object obj;
        boolean flag;
        stringbuilder = new StringBuilder();
        obj = mimsIdentityCache.keySet();
        flag = true;
        obj = ((Set) (obj)).iterator();
_L2:
        Object obj1;
        boolean flag1;
        boolean flag2;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_182;
            }
            obj1 = (String)((Iterator) (obj)).next();
        } while (!mimsActiveProviders.containsKey(obj1) || ((Integer)mimsActiveProviders.get(obj1)).intValue() == 0);
        if (!flag)
        {
            stringbuilder.append("&");
        }
        stringbuilder.append(((String) (obj1)));
        flag2 = false;
        obj1 = (List)mimsIdentityCache.get(obj1);
        flag1 = true;
        obj1 = ((List) (obj1)).iterator();
_L3:
        flag = flag2;
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        s = (String)((Iterator) (obj1)).next();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        stringbuilder.append("=");
_L4:
        stringbuilder.append(URLEncoder.encode(s, "ISO-8859-1"));
        flag1 = false;
          goto _L3
        stringbuilder.append(";");
          goto _L4
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L3
        mimsIdentityStringEncoded = stringbuilder.toString();
        return;
    }

    public static void releaseProvider(String s)
    {
        if (!mimsActiveProviders.containsKey(s))
        {
            return;
        }
        Integer integer = (Integer)mimsActiveProviders.get(s);
        if (integer.intValue() > 0)
        {
            mimsActiveProviders.put(s, Integer.valueOf(integer.intValue() - 1));
        } else
        {
            removeProvider(s);
        }
        rebuildIdsString();
    }

    public static void releaseScopedProvider(Long long1)
    {
        if (long1 == null || !providerScopeRegistry.containsKey(long1))
        {
            return;
        } else
        {
            releaseProvider((String)providerScopeRegistry.remove(long1));
            return;
        }
    }

    public static void removeIdentity(String s, String s1)
    {
        LinkedHashMap linkedhashmap = getMimsProviderMap();
        if (linkedhashmap.containsKey(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        s = (List)linkedhashmap.get(s);
        if (s1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s.clear();
_L4:
        rebuildIdsString();
        return;
        if (!s.contains(s1)) goto _L1; else goto _L3
_L3:
        s.remove(s1);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private static void removeProvider(String s)
    {
        LinkedHashMap linkedhashmap = getMimsProviderMap();
        if (!linkedhashmap.containsKey(s))
        {
            return;
        } else
        {
            linkedhashmap.remove(s);
            mimsActiveProviders.remove(s);
            rebuildIdsString();
            return;
        }
    }

    public static void useProvider(String s)
    {
        Integer integer = Integer.valueOf(1);
        if (!mimsIdentityCache.containsKey(s))
        {
            addIdentity(s, null);
        }
        if (mimsActiveProviders.containsKey(s))
        {
            integer = Integer.valueOf(((Integer)mimsActiveProviders.get(s)).intValue() + 1);
            mimsActiveProviders.remove(s);
        }
        mimsActiveProviders.put(s, integer);
        rebuildIdsString();
    }

    public static Long useProviderScoped(String s)
    {
        long l = providerScopeNextId.getAndIncrement();
        providerScopeRegistry.put(Long.valueOf(l), s);
        useProvider(s);
        return Long.valueOf(l);
    }

}
