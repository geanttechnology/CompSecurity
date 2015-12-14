// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            MemoryCache, CountingLruMap, MemoryCacheParams, ValueDescriptor

public class CountingMemoryCache
    implements MemoryCache, MemoryTrimmable
{
    public static interface CacheTrimStrategy
    {

        public abstract double getTrimRatio(MemoryTrimType memorytrimtype);
    }

    static class Entry
    {

        public int clientCount;
        public boolean isOrphan;
        public final Object key;
        public final CloseableReference valueRef;

        static Entry of(Object obj, CloseableReference closeablereference)
        {
            return new Entry(obj, closeablereference);
        }

        private Entry(Object obj, CloseableReference closeablereference)
        {
            key = Preconditions.checkNotNull(obj);
            valueRef = (CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeablereference));
            clientCount = 0;
            isOrphan = false;
        }
    }


    static final long PARAMS_INTERCHECK_INTERVAL_MS;
    private final CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap mCachedEntries;
    final CountingLruMap mExclusiveEntries;
    private long mLastCacheParamsCheck;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier mMemoryCacheParamsSupplier;
    private final ValueDescriptor mValueDescriptor;

    public CountingMemoryCache(ValueDescriptor valuedescriptor, CacheTrimStrategy cachetrimstrategy, Supplier supplier)
    {
        mValueDescriptor = valuedescriptor;
        mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valuedescriptor));
        mCachedEntries = new CountingLruMap(wrapValueDescriptor(valuedescriptor));
        mCacheTrimStrategy = cachetrimstrategy;
        mMemoryCacheParamsSupplier = supplier;
        mMemoryCacheParams = (MemoryCacheParams)mMemoryCacheParamsSupplier.get();
        mLastCacheParamsCheck = SystemClock.elapsedRealtime();
    }

    private boolean canCacheNewValue(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        int i = mValueDescriptor.getSizeInBytes(obj);
        if (i > mMemoryCacheParams.maxCacheEntrySize || getInUseCount() + 1 > mMemoryCacheParams.maxCacheEntries) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        j = getInUseSizeInBytes();
        k = mMemoryCacheParams.maxCacheSize;
        if (j + i > k) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        throw obj;
    }

    private void decreaseClientCount(Entry entry)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(entry);
        boolean flag;
        if (entry.clientCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        entry.clientCount = entry.clientCount - 1;
        this;
        JVM INSTR monitorexit ;
        return;
        entry;
        throw entry;
    }

    private void increaseClientCount(Entry entry)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(entry);
        boolean flag;
        if (!entry.isOrphan)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        entry.clientCount = entry.clientCount + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        entry;
        throw entry;
    }

    private void makeOrphan(Entry entry)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(entry);
        if (entry.isOrphan)
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        entry.isOrphan = true;
        this;
        JVM INSTR monitorexit ;
        return;
        entry;
        throw entry;
    }

    private void makeOrphans(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); makeOrphan((Entry)arraylist.next())) { }
        break MISSING_BLOCK_LABEL_41;
        arraylist;
        throw arraylist;
        this;
        JVM INSTR monitorexit ;
    }

    private void maybeAddToExclusives(Entry entry)
    {
        this;
        JVM INSTR monitorenter ;
        if (!entry.isOrphan && entry.clientCount == 0)
        {
            mExclusiveEntries.put(entry.key, entry);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        entry;
        throw entry;
    }

    private void maybeClose(ArrayList arraylist)
    {
        if (arraylist != null)
        {
            for (arraylist = arraylist.iterator(); arraylist.hasNext(); CloseableReference.closeSafely(referenceToClose((Entry)arraylist.next()))) { }
        }
    }

    private void maybeEvictEntries()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = trimExclusivelyOwnedEntries(Math.min(mMemoryCacheParams.maxEvictionQueueEntries, mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(mMemoryCacheParams.maxEvictionQueueSize, mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
        makeOrphans(arraylist);
        this;
        JVM INSTR monitorexit ;
        maybeClose(arraylist);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void maybeUpdateCacheParams()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        long l2;
        l = mLastCacheParamsCheck;
        l1 = PARAMS_INTERCHECK_INTERVAL_MS;
        l2 = SystemClock.elapsedRealtime();
        if (l + l1 <= l2) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mLastCacheParamsCheck = SystemClock.elapsedRealtime();
        mMemoryCacheParams = (MemoryCacheParams)mMemoryCacheParamsSupplier.get();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private CloseableReference newClientReference(final Entry entry)
    {
        this;
        JVM INSTR monitorenter ;
        increaseClientCount(entry);
        entry = CloseableReference.of(entry.valueRef.get(), new ResourceReleaser() {

            final CountingMemoryCache this$0;
            final Entry val$entry;

            public void release(Object obj)
            {
                releaseClientReference(entry);
            }

            
            {
                this$0 = CountingMemoryCache.this;
                entry = entry1;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return entry;
        entry;
        throw entry;
    }

    private CloseableReference referenceToClose(Entry entry)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan || entry.clientCount != 0) goto _L2; else goto _L1
_L1:
        entry = entry.valueRef;
_L4:
        this;
        JVM INSTR monitorexit ;
        return entry;
_L2:
        entry = null;
        if (true) goto _L4; else goto _L3
_L3:
        entry;
        throw entry;
    }

    private void releaseClientReference(Entry entry)
    {
        Preconditions.checkNotNull(entry);
        this;
        JVM INSTR monitorenter ;
        decreaseClientCount(entry);
        maybeAddToExclusives(entry);
        entry = referenceToClose(entry);
        this;
        JVM INSTR monitorexit ;
        CloseableReference.closeSafely(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
        entry;
        this;
        JVM INSTR monitorexit ;
        throw entry;
    }


// JavaClassFileOutputException: Prev chain is broken

    private ValueDescriptor wrapValueDescriptor(final ValueDescriptor evictableValueDescriptor)
    {
        return new ValueDescriptor() {

            final CountingMemoryCache this$0;
            final ValueDescriptor val$evictableValueDescriptor;

            public int getSizeInBytes(Entry entry)
            {
                return evictableValueDescriptor.getSizeInBytes(entry.valueRef.get());
            }

            public volatile int getSizeInBytes(Object obj)
            {
                return getSizeInBytes((Entry)obj);
            }

            
            {
                this$0 = CountingMemoryCache.this;
                evictableValueDescriptor = valuedescriptor;
                super();
            }
        };
    }

    public CloseableReference cache(Object obj, CloseableReference closeablereference)
    {
        CloseableReference closeablereference1;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(closeablereference);
        maybeUpdateCacheParams();
        closeablereference1 = null;
        CloseableReference closeablereference2 = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        mExclusiveEntries.remove(obj);
        entry = (Entry)mCachedEntries.remove(obj);
        if (entry == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        makeOrphan(entry);
        closeablereference1 = referenceToClose(entry);
        if (canCacheNewValue(closeablereference.get()))
        {
            closeablereference = Entry.of(obj, closeablereference);
            mCachedEntries.put(obj, closeablereference);
            closeablereference2 = newClientReference(closeablereference);
        }
        this;
        JVM INSTR monitorexit ;
        CloseableReference.closeSafely(closeablereference1);
        maybeEvictEntries();
        return closeablereference2;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        mExclusiveEntries.clear();
        arraylist = mCachedEntries.clear();
        makeOrphans(arraylist);
        this;
        JVM INSTR monitorexit ;
        maybeClose(arraylist);
        maybeUpdateCacheParams();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public CloseableReference get(Object obj)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Entry entry;
        mExclusiveEntries.remove(obj);
        entry = (Entry)mCachedEntries.get(obj);
        obj = obj1;
        if (entry == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        obj = newClientReference(entry);
        this;
        JVM INSTR monitorexit ;
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return ((CloseableReference) (obj));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public int getCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mCachedEntries.getCount();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getEvictionQueueCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mExclusiveEntries.getCount();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getEvictionQueueSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mExclusiveEntries.getSizeInBytes();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getInUseCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = mCachedEntries.getCount();
        j = mExclusiveEntries.getCount();
        this;
        JVM INSTR monitorexit ;
        return i - j;
        Exception exception;
        exception;
        throw exception;
    }

    public int getInUseSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = mCachedEntries.getSizeInBytes();
        j = mExclusiveEntries.getSizeInBytes();
        this;
        JVM INSTR monitorexit ;
        return i - j;
        Exception exception;
        exception;
        throw exception;
    }

    public int getSizeInBytes()
    {
        this;
        JVM INSTR monitorenter ;
        int i = mCachedEntries.getSizeInBytes();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int removeAll(Predicate predicate)
    {
        this;
        JVM INSTR monitorenter ;
        mExclusiveEntries.removeAll(predicate);
        predicate = mCachedEntries.removeAll(predicate);
        makeOrphans(predicate);
        this;
        JVM INSTR monitorexit ;
        maybeClose(predicate);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return predicate.size();
        predicate;
        this;
        JVM INSTR monitorexit ;
        throw predicate;
    }

    public void trim(MemoryTrimType memorytrimtype)
    {
        double d = mCacheTrimStrategy.getTrimRatio(memorytrimtype);
        this;
        JVM INSTR monitorenter ;
        memorytrimtype = trimExclusivelyOwnedEntries(0x7fffffff, Math.max(0, (int)((double)mCachedEntries.getSizeInBytes() * (1.0D - d)) - getInUseSizeInBytes()));
        makeOrphans(memorytrimtype);
        this;
        JVM INSTR monitorexit ;
        maybeClose(memorytrimtype);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return;
        memorytrimtype;
        this;
        JVM INSTR monitorexit ;
        throw memorytrimtype;
    }

    static 
    {
        PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
    }

}
