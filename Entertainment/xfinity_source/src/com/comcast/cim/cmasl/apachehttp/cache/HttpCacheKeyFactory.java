// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import java.util.LinkedHashMap;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            HttpCacheKey

public class HttpCacheKeyFactory
{

    private final LinkedHashMap keyCache = new LruLinkedHashMap(30);

    public HttpCacheKeyFactory()
    {
    }

    public HttpCacheKey create(String s)
    {
        LinkedHashMap linkedhashmap = keyCache;
        linkedhashmap;
        JVM INSTR monitorenter ;
        HttpCacheKey httpcachekey1 = (HttpCacheKey)keyCache.get(s);
        HttpCacheKey httpcachekey;
        httpcachekey = httpcachekey1;
        if (httpcachekey1 != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        httpcachekey = new HttpCacheKey(s);
        keyCache.put(s, httpcachekey);
        linkedhashmap;
        JVM INSTR monitorexit ;
        return httpcachekey;
        s;
        linkedhashmap;
        JVM INSTR monitorexit ;
        throw s;
    }
}
