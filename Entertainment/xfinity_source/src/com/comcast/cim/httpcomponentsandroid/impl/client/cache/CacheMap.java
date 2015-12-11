// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import java.util.LinkedHashMap;

final class CacheMap extends LinkedHashMap
{

    private final int maxEntries;

    CacheMap(int i)
    {
        super(20, 0.75F, true);
        maxEntries = i;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        return size() > maxEntries;
    }
}
