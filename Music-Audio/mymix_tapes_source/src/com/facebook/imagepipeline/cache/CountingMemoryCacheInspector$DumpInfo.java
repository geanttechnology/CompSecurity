// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCacheInspector, MemoryCacheParams

public static class lruSize
{

    public final List lruEntries = new ArrayList();
    public final int lruSize;
    public final int maxEntriesCount;
    public final int maxEntrySize;
    public final int maxSize;
    public final List sharedEntries = new ArrayList();
    public final int size;

    public void release()
    {
        for (Iterator iterator = lruEntries.iterator(); iterator.hasNext(); ((ntry)iterator.next()).release()) { }
        for (Iterator iterator1 = sharedEntries.iterator(); iterator1.hasNext(); ((ntry)iterator1.next()).release()) { }
    }

    public ntry(int i, int j, MemoryCacheParams memorycacheparams)
    {
        maxSize = memorycacheparams.maxCacheSize;
        maxEntriesCount = memorycacheparams.maxCacheEntries;
        maxEntrySize = memorycacheparams.maxCacheEntrySize;
        size = i;
        lruSize = j;
    }
}
