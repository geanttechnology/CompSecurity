// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.captions;

import com.comcast.cim.cmasl.cachelib.NamespacedFileCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistentCaptionsCache
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/captions/PersistentCaptionsCache);
    public static final String NAMESPACE = com/xfinity/playerlib/captions/PersistentCaptionsCache.getSimpleName();
    private final NamespacedFileCache storageCache;

    public PersistentCaptionsCache(NamespacedFileCache namespacedfilecache)
    {
        storageCache = namespacedfilecache;
    }

    public void clear()
    {
        synchronized (storageCache)
        {
            storageCache.removeAll();
        }
        return;
        exception;
        namespacedfilecache;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
