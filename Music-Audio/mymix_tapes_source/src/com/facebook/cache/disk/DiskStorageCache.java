// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.facebook.cache.disk:
//            FileCache, DiskStorageSupplier, DiskStorage

public class DiskStorageCache
    implements FileCache, DiskTrimmable
{
    static class CacheStats
    {

        private long mCount;
        private boolean mInitialized;
        private long mSize;

        public long getCount()
        {
            this;
            JVM INSTR monitorenter ;
            long l = mCount;
            this;
            JVM INSTR monitorexit ;
            return l;
            Exception exception;
            exception;
            throw exception;
        }

        public long getSize()
        {
            this;
            JVM INSTR monitorenter ;
            long l = mSize;
            this;
            JVM INSTR monitorexit ;
            return l;
            Exception exception;
            exception;
            throw exception;
        }

        public void increment(long l, long l1)
        {
            this;
            JVM INSTR monitorenter ;
            if (mInitialized)
            {
                mSize = mSize + l;
                mCount = mCount + l1;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public boolean isInitialized()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mInitialized;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        public void reset()
        {
            this;
            JVM INSTR monitorenter ;
            mInitialized = false;
            mCount = -1L;
            mSize = -1L;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void set(long l, long l1)
        {
            this;
            JVM INSTR monitorenter ;
            mCount = l1;
            mSize = l;
            mInitialized = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        CacheStats()
        {
            mInitialized = false;
            mSize = -1L;
            mCount = -1L;
        }
    }

    public static class Params
    {

        public final long mCacheSizeLimitMinimum;
        public final long mDefaultCacheSizeLimit;
        public final long mLowDiskSpaceCacheSizeLimit;

        public Params(long l, long l1, long l2)
        {
            mCacheSizeLimitMinimum = l;
            mLowDiskSpaceCacheSizeLimit = l1;
            mDefaultCacheSizeLimit = l2;
        }
    }

    private static class TimestampComparator
        implements Comparator
    {

        private final long threshold;

        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry1)
        {
            long l;
            long l1;
            if (entry.getTimestamp() <= threshold)
            {
                l = entry.getTimestamp();
            } else
            {
                l = 0L;
            }
            if (entry1.getTimestamp() <= threshold)
            {
                l1 = entry1.getTimestamp();
            } else
            {
                l1 = 0L;
            }
            if (l < l1)
            {
                return -1;
            }
            return l1 <= l ? 0 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((DiskStorage.Entry)obj, (DiskStorage.Entry)obj1);
        }

        public TimestampComparator(long l)
        {
            threshold = l;
        }
    }


    private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS;
    private static final long FUTURE_TIMESTAMP_THRESHOLD_MS;
    public static final int START_OF_VERSIONING = 1;
    private static final Class TAG = com/facebook/cache/disk/DiskStorageCache;
    private static final double TRIMMING_LOWER_BOUND = 0.02D;
    private static final long UNINITIALIZED = -1L;
    private final CacheErrorLogger mCacheErrorLogger;
    private final CacheEventListener mCacheEventListener;
    private long mCacheSizeLastUpdateTime;
    private long mCacheSizeLimit;
    private final long mCacheSizeLimitMinimum;
    private final CacheStats mCacheStats = new CacheStats();
    private final Clock mClock = SystemClock.get();
    private final long mDefaultCacheSizeLimit;
    private final Object mLock = new Object();
    private final long mLowDiskSpaceCacheSizeLimit;
    private final StatFsHelper mStatFsHelper = StatFsHelper.getInstance();
    private final DiskStorageSupplier mStorageSupplier;

    public DiskStorageCache(DiskStorageSupplier diskstoragesupplier, Params params, CacheEventListener cacheeventlistener, CacheErrorLogger cacheerrorlogger, DiskTrimmableRegistry disktrimmableregistry)
    {
        mLowDiskSpaceCacheSizeLimit = params.mLowDiskSpaceCacheSizeLimit;
        mDefaultCacheSizeLimit = params.mDefaultCacheSizeLimit;
        mCacheSizeLimit = params.mDefaultCacheSizeLimit;
        mStorageSupplier = diskstoragesupplier;
        mCacheSizeLastUpdateTime = -1L;
        mCacheEventListener = cacheeventlistener;
        mCacheSizeLimitMinimum = params.mCacheSizeLimitMinimum;
        mCacheErrorLogger = cacheerrorlogger;
        if (disktrimmableregistry != null)
        {
            disktrimmableregistry.registerDiskTrimmable(this);
        }
    }

    private void calcFileCacheSize()
    {
        int i;
        int j;
        int k;
        boolean flag;
        long l1;
        long l2;
        long l4;
        long l5;
        l1 = 0L;
        k = 0;
        flag = false;
        j = 0;
        i = 0;
        l2 = -1L;
        l4 = mClock.now();
        l5 = FUTURE_TIMESTAMP_THRESHOLD_MS;
        Iterator iterator = mStorageSupplier.get().getEntries().iterator();
_L2:
        DiskStorage.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        entry = (DiskStorage.Entry)iterator.next();
        int l = k + 1;
        long l3;
        try
        {
            l3 = l1 + entry.getSize();
        }
        catch (IOException ioexception)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, (new StringBuilder()).append("calcFileCacheSize: ").append(ioexception.getMessage()).toString(), ioexception);
            return;
        }
        k = l;
        l1 = l3;
        if (entry.getTimestamp() <= l4 + l5) goto _L2; else goto _L1
_L1:
        flag = true;
        j++;
        i = (int)((long)i + entry.getSize());
        l2 = Math.max(entry.getTimestamp() - l4, l2);
        k = l;
        l1 = l3;
          goto _L2
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, TAG, (new StringBuilder()).append("Future timestamp found in ").append(j).append(" files , with a total size of ").append(i).append(" bytes, and a maximum time delta of ").append(l2).append("ms").toString(), null);
        mCacheStats.set(l1, k);
        return;
    }

    private BinaryResource commitResource(String s, CacheKey cachekey, BinaryResource binaryresource)
        throws IOException
    {
        synchronized (mLock)
        {
            s = mStorageSupplier.get().commit(s, binaryresource, cachekey);
            mCacheStats.increment(s.size(), 1L);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private BinaryResource createTemporaryResource(String s, CacheKey cachekey)
        throws IOException
    {
        maybeEvictFilesInCacheDir();
        return mStorageSupplier.get().createTemporary(s, cachekey);
    }

    private void deleteTemporaryResource(BinaryResource binaryresource)
    {
        if (binaryresource instanceof FileBinaryResource)
        {
            if ((binaryresource = ((FileBinaryResource)binaryresource).getFile()).exists())
            {
                FLog.e(TAG, "Temp file still on disk: %s ", new Object[] {
                    binaryresource
                });
                if (!binaryresource.delete())
                {
                    FLog.e(TAG, "Failed to delete temp file: %s", new Object[] {
                        binaryresource
                    });
                    return;
                }
            }
        }
    }

    private void evictAboveSize(long l, com.facebook.cache.common.CacheEventListener.EvictionReason evictionreason)
        throws IOException
    {
        DiskStorage diskstorage = mStorageSupplier.get();
        Object obj;
        int i;
        long l1;
        long l2;
        try
        {
            obj = getSortedEntries(diskstorage.getEntries());
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.cache.common.CacheEventListener.EvictionReason evictionreason)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, (new StringBuilder()).append("evictAboveSize: ").append(evictionreason.getMessage()).toString(), evictionreason);
            throw evictionreason;
        }
        l2 = mCacheStats.getSize();
        i = 0;
        l1 = 0L;
        obj = ((Collection) (obj)).iterator();
        do
        {
            DiskStorage.Entry entry;
label0:
            {
                if (((Iterator) (obj)).hasNext())
                {
                    entry = (DiskStorage.Entry)((Iterator) (obj)).next();
                    if (l1 <= l2 - l)
                    {
                        break label0;
                    }
                }
                mCacheStats.increment(-l1, -i);
                diskstorage.purgeUnexpectedResources();
                reportEviction(evictionreason, i, l1);
                return;
            }
            long l3 = diskstorage.remove(entry);
            if (l3 > 0L)
            {
                i++;
                l1 += l3;
            }
        } while (true);
    }

    private Collection getSortedEntries(Collection collection)
    {
        collection = new ArrayList(collection);
        Collections.sort(collection, new TimestampComparator(mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS));
        return collection;
    }

    private void maybeEvictFilesInCacheDir()
        throws IOException
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l;
        boolean flag;
        flag = maybeUpdateFileCacheSize();
        updateFileCacheSizeLimit();
        l = mCacheStats.getSize();
        if (l <= mCacheSizeLimit || flag)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        mCacheStats.reset();
        maybeUpdateFileCacheSize();
        if (l > mCacheSizeLimit)
        {
            evictAboveSize((mCacheSizeLimit * 9L) / 10L, com.facebook.cache.common.CacheEventListener.EvictionReason.CACHE_FULL);
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean maybeUpdateFileCacheSize()
    {
        boolean flag = false;
        long l = android.os.SystemClock.elapsedRealtime();
        if (!mCacheStats.isInitialized() || mCacheSizeLastUpdateTime == -1L || l - mCacheSizeLastUpdateTime > FILECACHE_SIZE_UPDATE_PERIOD_MS)
        {
            calcFileCacheSize();
            mCacheSizeLastUpdateTime = l;
            flag = true;
        }
        return flag;
    }

    private void reportEviction(com.facebook.cache.common.CacheEventListener.EvictionReason evictionreason, int i, long l)
    {
        mCacheEventListener.onEviction(evictionreason, i, l);
    }

    private void trimBy(double d)
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mCacheStats.reset();
        maybeUpdateFileCacheSize();
        long l = mCacheStats.getSize();
        evictAboveSize(l - (long)((double)l * d), com.facebook.cache.common.CacheEventListener.EvictionReason.CACHE_MANAGER_TRIMMED);
_L1:
        return;
        Object obj1;
        obj1;
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, (new StringBuilder()).append("trimBy: ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void updateFileCacheSizeLimit()
    {
        if (mStatFsHelper.testLowDiskSpace(com.facebook.common.statfs.StatFsHelper.StorageType.INTERNAL, mDefaultCacheSizeLimit - mCacheStats.getSize()))
        {
            mCacheSizeLimit = mLowDiskSpaceCacheSizeLimit;
            return;
        } else
        {
            mCacheSizeLimit = mDefaultCacheSizeLimit;
            return;
        }
    }

    public void clearAll()
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mStorageSupplier.get().clearAll();
_L1:
        mCacheStats.reset();
        return;
        Object obj1;
        obj1;
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, (new StringBuilder()).append("clearAll: ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public long clearOldEntries(long l)
    {
        long l1 = 0L;
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l2 = l1;
        long l4 = mClock.now();
        l2 = l1;
        DiskStorage diskstorage = mStorageSupplier.get();
        l2 = l1;
        Object obj2 = diskstorage.getEntries();
        int i;
        long l3;
        i = 0;
        l3 = 0L;
        l2 = l1;
        obj2 = ((Collection) (obj2)).iterator();
_L2:
        l2 = l1;
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        l2 = l1;
        DiskStorage.Entry entry = (DiskStorage.Entry)((Iterator) (obj2)).next();
        l2 = l1;
        long l5 = Math.max(1L, Math.abs(l4 - entry.getTimestamp()));
        if (l5 < l)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        l2 = l1;
        l5 = diskstorage.remove(entry);
        if (l5 > 0L)
        {
            i++;
            l3 += l5;
        }
        continue; /* Loop/switch isn't completed */
        l2 = l1;
        l1 = Math.max(l1, l5);
        if (true) goto _L2; else goto _L1
_L1:
        l2 = l1;
        diskstorage.purgeUnexpectedResources();
        l2 = l1;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        l2 = l1;
        maybeUpdateFileCacheSize();
        l2 = l1;
        mCacheStats.increment(-l3, -i);
        l2 = l1;
        reportEviction(com.facebook.cache.common.CacheEventListener.EvictionReason.CONTENT_STALE, i, l3);
        l2 = l1;
_L4:
        obj;
        JVM INSTR monitorexit ;
        return l2;
        Object obj1;
        obj1;
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, (new StringBuilder()).append("clearOldEntries: ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public DiskStorage.DiskDumpInfo getDumpInfo()
        throws IOException
    {
        return mStorageSupplier.get().getDumpInfo();
    }

    public BinaryResource getResource(CacheKey cachekey)
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        cachekey = mStorageSupplier.get().getResource(getResourceId(cachekey), cachekey);
        if (cachekey != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        mCacheEventListener.onMiss();
_L1:
        obj;
        JVM INSTR monitorexit ;
        return cachekey;
        mCacheEventListener.onHit();
          goto _L1
        cachekey;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw cachekey;
        }
        // Misplaced declaration of an exception variable
        catch (CacheKey cachekey)
        {
            mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.GENERIC_IO, TAG, "getResource", cachekey);
        }
        mCacheEventListener.onReadException();
        return null;
    }

    String getResourceId(CacheKey cachekey)
    {
        try
        {
            cachekey = SecureHashUtil.makeSHA1HashBase64(cachekey.toString().getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (CacheKey cachekey)
        {
            throw new RuntimeException(cachekey);
        }
        return cachekey;
    }

    public long getSize()
    {
        return mCacheStats.getSize();
    }

    public boolean hasKey(CacheKey cachekey)
    {
        boolean flag;
        try
        {
            flag = mStorageSupplier.get().contains(getResourceId(cachekey), cachekey);
        }
        // Misplaced declaration of an exception variable
        catch (CacheKey cachekey)
        {
            return false;
        }
        return flag;
    }

    public BinaryResource insert(CacheKey cachekey, WriterCallback writercallback)
        throws IOException
    {
        String s;
        mCacheEventListener.onWriteAttempt();
        s = getResourceId(cachekey);
        BinaryResource binaryresource = createTemporaryResource(s, cachekey);
        mStorageSupplier.get().updateResource(s, binaryresource, writercallback, cachekey);
        cachekey = commitResource(s, cachekey, binaryresource);
        deleteTemporaryResource(binaryresource);
        return cachekey;
        cachekey;
        try
        {
            deleteTemporaryResource(binaryresource);
            throw cachekey;
        }
        // Misplaced declaration of an exception variable
        catch (CacheKey cachekey)
        {
            mCacheEventListener.onWriteException();
        }
        FLog.d(TAG, "Failed inserting a file into the cache", cachekey);
        throw cachekey;
    }

    public boolean isEnabled()
    {
        boolean flag;
        try
        {
            flag = mStorageSupplier.get().isEnabled();
        }
        catch (IOException ioexception)
        {
            return false;
        }
        return flag;
    }

    public boolean probe(CacheKey cachekey)
    {
        boolean flag;
        synchronized (mLock)
        {
            flag = mStorageSupplier.get().touch(getResourceId(cachekey), cachekey);
        }
        return flag;
        cachekey;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw cachekey;
        }
        // Misplaced declaration of an exception variable
        catch (CacheKey cachekey)
        {
            mCacheEventListener.onReadException();
        }
        return false;
    }

    public void remove(CacheKey cachekey)
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        mStorageSupplier.get().remove(getResourceId(cachekey));
_L1:
        return;
        cachekey;
        mCacheErrorLogger.logError(com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory.DELETE_FILE, TAG, (new StringBuilder()).append("delete: ").append(cachekey.getMessage()).toString(), cachekey);
          goto _L1
        cachekey;
        obj;
        JVM INSTR monitorexit ;
        throw cachekey;
    }

    public void trimToMinimum()
    {
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        long l;
        maybeUpdateFileCacheSize();
        l = mCacheStats.getSize();
        if (mCacheSizeLimitMinimum <= 0L || l <= 0L)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (l >= mCacheSizeLimitMinimum)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        double d = 1.0D - (double)mCacheSizeLimitMinimum / (double)l;
        if (d <= 0.02D)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        trimBy(d);
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void trimToNothing()
    {
        clearAll();
    }

    static 
    {
        FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
        FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
    }
}
