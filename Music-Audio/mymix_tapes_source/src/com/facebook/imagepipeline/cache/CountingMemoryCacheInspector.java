// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCache, CountingLruMap, MemoryCacheParams

public class CountingMemoryCacheInspector
{
    public static class DumpInfo
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
            for (Iterator iterator = lruEntries.iterator(); iterator.hasNext(); ((DumpInfoEntry)iterator.next()).release()) { }
            for (Iterator iterator1 = sharedEntries.iterator(); iterator1.hasNext(); ((DumpInfoEntry)iterator1.next()).release()) { }
        }

        public DumpInfo(int i, int j, MemoryCacheParams memorycacheparams)
        {
            maxSize = memorycacheparams.maxCacheSize;
            maxEntriesCount = memorycacheparams.maxCacheEntries;
            maxEntrySize = memorycacheparams.maxCacheEntrySize;
            size = i;
            lruSize = j;
        }
    }

    public static class DumpInfoEntry
    {

        public final Object key;
        public final CloseableReference value;

        public void release()
        {
            CloseableReference.closeSafely(value);
        }

        public DumpInfoEntry(Object obj, CloseableReference closeablereference)
        {
            key = Preconditions.checkNotNull(obj);
            value = CloseableReference.cloneOrNull(closeablereference);
        }
    }


    private final CountingMemoryCache mCountingBitmapCache;

    public CountingMemoryCacheInspector(CountingMemoryCache countingmemorycache)
    {
        mCountingBitmapCache = countingmemorycache;
    }

    public DumpInfo dumpCacheContent()
    {
        CountingMemoryCache countingmemorycache = mCountingBitmapCache;
        countingmemorycache;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new DumpInfo(mCountingBitmapCache.getSizeInBytes(), mCountingBitmapCache.getEvictionQueueSizeInBytes(), mCountingBitmapCache.mMemoryCacheParams);
        iterator = mCountingBitmapCache.mCachedEntries.getMatchingEntries(null).iterator();
_L1:
        DumpInfoEntry dumpinfoentry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_143;
            }
            CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry)((java.util.Map.Entry)iterator.next()).getValue();
            dumpinfoentry = new DumpInfoEntry(entry.key, entry.valueRef);
            if (entry.clientCount <= 0)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            ((DumpInfo) (obj)).sharedEntries.add(dumpinfoentry);
        } while (true);
        obj;
        countingmemorycache;
        JVM INSTR monitorexit ;
        throw obj;
        ((DumpInfo) (obj)).lruEntries.add(dumpinfoentry);
          goto _L1
        countingmemorycache;
        JVM INSTR monitorexit ;
        return ((DumpInfo) (obj));
    }
}
