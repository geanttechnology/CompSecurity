// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils.collections;

import java.util.LinkedHashMap;

public class LruLinkedHashMap extends LinkedHashMap
{

    private final int cacheSize;

    public LruLinkedHashMap(int i)
    {
        super(i);
        cacheSize = i;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry entry)
    {
        return size() > cacheSize;
    }
}
