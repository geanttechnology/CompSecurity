// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.cachelib;

import android.support.v4.util.LruCache;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

// Referenced classes of package com.comcast.cim.cmasl.cachelib:
//            Normalizer, NamespacedFileCache

private static class <init>
    implements Normalizer
{

    private final LruCache keyCache;
    private final String namespace;

    public String normalize(String s)
    {
        LruCache lrucache = keyCache;
        lrucache;
        JVM INSTR monitorenter ;
        String s2 = (String)keyCache.get(s);
        String s1;
        s1 = s2;
        if (s2 != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s1 = new String(Hex.encodeHex(DigestUtils.sha(s)));
        keyCache.put(s, s1);
        s = (new StringBuilder()).append(namespace).append(".").append(s1).toString();
        lrucache;
        JVM INSTR monitorexit ;
        return s;
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }

    private (String s)
    {
        keyCache = new LruCache(30);
        namespace = s;
    }

    namespace(String s, namespace namespace1)
    {
        this(s);
    }
}
