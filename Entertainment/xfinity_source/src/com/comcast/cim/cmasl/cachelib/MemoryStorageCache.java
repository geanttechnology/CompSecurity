// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.cachelib;

import com.comcast.cim.cmasl.utils.StorageCache;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MemoryStorageCache
    implements StorageCache
{

    private final Map inputStreamMap = new HashMap();

    public MemoryStorageCache()
    {
    }

    public void remove(String s)
    {
        inputStreamMap.remove(s);
    }

    public void removeAll()
    {
        inputStreamMap.clear();
    }

    public InputStream retrieve(String s)
    {
        return (InputStream)inputStreamMap.get(s);
    }

    public void store(InputStream inputstream, String s)
    {
        inputStreamMap.put(s, inputstream);
    }
}
