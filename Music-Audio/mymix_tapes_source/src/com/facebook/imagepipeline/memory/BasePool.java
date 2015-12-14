// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            Pool, PoolParams, PoolStatsTracker, Bucket

public abstract class BasePool
    implements Pool
{
    static class Counter
    {

        private static final String TAG = "com.facebook.imagepipeline.common.BasePool.Counter";
        int mCount;
        int mNumBytes;

        public void decrement(int i)
        {
            if (mNumBytes >= i && mCount > 0)
            {
                mCount = mCount - 1;
                mNumBytes = mNumBytes - i;
                return;
            } else
            {
                FLog.wtf("com.facebook.imagepipeline.common.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(mNumBytes), Integer.valueOf(mCount)
                });
                return;
            }
        }

        public void increment(int i)
        {
            mCount = mCount + 1;
            mNumBytes = mNumBytes + i;
        }

        public void reset()
        {
            mCount = 0;
            mNumBytes = 0;
        }

        Counter()
        {
        }
    }

    public static class InvalidSizeException extends RuntimeException
    {

        public InvalidSizeException(Object obj)
        {
            super((new StringBuilder()).append("Invalid size: ").append(obj.toString()).toString());
        }
    }

    public static class InvalidValueException extends RuntimeException
    {

        public InvalidValueException(Object obj)
        {
            super((new StringBuilder()).append("Invalid value: ").append(obj.toString()).toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException
    {

        public PoolSizeViolationException(int i, int j, int k, int l)
        {
            super((new StringBuilder()).append("Pool hard cap violation? Hard cap = ").append(i).append(" Used size = ").append(j).append(" Free size = ").append(k).append(" Request size = ").append(l).toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException
    {

        public SizeTooLargeException(Object obj)
        {
            super(obj);
        }
    }


    private final Class TAG = getClass();
    private boolean mAllowNewBuckets;
    final SparseArray mBuckets = new SparseArray();
    final Counter mFree = new Counter();
    final Set mInUseValues = Sets.newIdentityHashSet();
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    final Counter mUsed = new Counter();

    public BasePool(MemoryTrimmableRegistry memorytrimmableregistry, PoolParams poolparams, PoolStatsTracker poolstatstracker)
    {
        mMemoryTrimmableRegistry = (MemoryTrimmableRegistry)Preconditions.checkNotNull(memorytrimmableregistry);
        mPoolParams = (PoolParams)Preconditions.checkNotNull(poolparams);
        mPoolStatsTracker = (PoolStatsTracker)Preconditions.checkNotNull(poolstatstracker);
        initBuckets(new SparseIntArray(0));
    }

    private void ensurePoolSizeInvariant()
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (isMaxSizeSoftCapExceeded() && mFree.mNumBytes != 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        Preconditions.checkState(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    private void initBuckets(SparseIntArray sparseintarray)
    {
        this;
        JVM INSTR monitorenter ;
        SparseIntArray sparseintarray1;
        Preconditions.checkNotNull(sparseintarray);
        mBuckets.clear();
        sparseintarray1 = mPoolParams.bucketSizes;
        if (sparseintarray1 == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        if (i >= sparseintarray1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        int j = sparseintarray1.keyAt(i);
        int k = sparseintarray1.valueAt(i);
        int l = sparseintarray.get(j, 0);
        mBuckets.put(j, new Bucket(getSizeInBytes(j), k, l));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        mAllowNewBuckets = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mAllowNewBuckets = true;
        if (true) goto _L6; else goto _L5
_L5:
        sparseintarray;
        throw sparseintarray;
    }

    private void logStats()
    {
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(mUsed.mCount), Integer.valueOf(mUsed.mNumBytes), Integer.valueOf(mFree.mCount), Integer.valueOf(mFree.mNumBytes));
        }
    }

    protected abstract Object alloc(int i);

    boolean canAllocate(int i)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        int j = mPoolParams.maxSizeHardCap;
        if (mUsed.mNumBytes + i <= j) goto _L2; else goto _L1
_L1:
        mPoolStatsTracker.onHardCapReached();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        int k = mPoolParams.maxSizeSoftCap;
        if (mUsed.mNumBytes + mFree.mNumBytes + i > k)
        {
            trimToSize(k - i);
        }
        if (mUsed.mNumBytes + mFree.mNumBytes + i > j)
        {
            mPoolStatsTracker.onHardCapReached();
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_117;
        Exception exception;
        exception;
        throw exception;
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected abstract void free(Object obj);

    public Object get(int i)
    {
        ensurePoolSizeInvariant();
        i = getBucketedSize(i);
        this;
        JVM INSTR monitorenter ;
        Object obj = getBucket(i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        Object obj1 = ((Bucket) (obj)).get();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        Preconditions.checkState(mInUseValues.add(obj1));
        i = getBucketedSizeForValue(obj1);
        int j = getSizeInBytes(i);
        mUsed.increment(j);
        mFree.decrement(j);
        mPoolStatsTracker.onValueReuse(j);
        logStats();
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj1)), Integer.valueOf(i));
        }
        this;
        JVM INSTR monitorexit ;
        return obj1;
        int k;
        k = getSizeInBytes(i);
        if (!canAllocate(k))
        {
            throw new PoolSizeViolationException(mPoolParams.maxSizeHardCap, mUsed.mNumBytes, mFree.mNumBytes, k);
        }
        break MISSING_BLOCK_LABEL_173;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        mUsed.increment(k);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        ((Bucket) (obj)).incrementInUseCount();
        this;
        JVM INSTR monitorexit ;
        obj = null;
        obj1 = alloc(i);
        obj = obj1;
_L2:
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkState(mInUseValues.add(obj));
        trimToSoftCap();
        mPoolStatsTracker.onAlloc(k);
        logStats();
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(i));
        }
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Throwable throwable;
        throwable;
        this;
        JVM INSTR monitorenter ;
        Bucket bucket;
        mUsed.decrement(k);
        bucket = getBucket(i);
        if (bucket == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        bucket.decrementInUseCount();
        this;
        JVM INSTR monitorexit ;
        Throwables.propagateIfPossible(throwable);
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Bucket getBucket(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Bucket bucket = (Bucket)mBuckets.get(i);
        if (bucket != null) goto _L2; else goto _L1
_L1:
        boolean flag = mAllowNewBuckets;
        if (flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return bucket;
_L3:
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "creating new bucket %s", Integer.valueOf(i));
        }
        bucket = newBucket(i);
        mBuckets.put(i, bucket);
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract int getBucketedSize(int i);

    protected abstract int getBucketedSizeForValue(Object obj);

    protected abstract int getSizeInBytes(int i);

    public Map getStats()
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = new HashMap();
        int i = 0;
_L2:
        if (i >= mBuckets.size())
        {
            break; /* Loop/switch isn't completed */
        }
        int j = mBuckets.keyAt(i);
        Bucket bucket = (Bucket)mBuckets.valueAt(i);
        hashmap.put((new StringBuilder()).append("buckets_used_").append(getSizeInBytes(j)).toString(), Integer.valueOf(bucket.getInUseCount()));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap.put("soft_cap", Integer.valueOf(mPoolParams.maxSizeSoftCap));
        hashmap.put("hard_cap", Integer.valueOf(mPoolParams.maxSizeHardCap));
        hashmap.put("used_count", Integer.valueOf(mUsed.mCount));
        hashmap.put("used_bytes", Integer.valueOf(mUsed.mNumBytes));
        hashmap.put("free_count", Integer.valueOf(mFree.mCount));
        hashmap.put("free_bytes", Integer.valueOf(mFree.mNumBytes));
        this;
        JVM INSTR monitorexit ;
        return hashmap;
        Exception exception;
        exception;
        throw exception;
    }

    protected void initialize()
    {
        mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        mPoolStatsTracker.setBasePool(this);
    }

    boolean isMaxSizeSoftCapExceeded()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (mUsed.mNumBytes + mFree.mNumBytes > mPoolParams.maxSizeSoftCap)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        mPoolStatsTracker.onSoftCapReached();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean isReusable(Object obj)
    {
        Preconditions.checkNotNull(obj);
        return true;
    }

    Bucket newBucket(int i)
    {
        return new Bucket(getSizeInBytes(i), 0x7fffffff, 0);
    }

    protected void onParamsChanged()
    {
    }

    public void release(Object obj)
    {
        int i;
        Preconditions.checkNotNull(obj);
        i = getBucketedSizeForValue(obj);
        int j = getSizeInBytes(i);
        this;
        JVM INSTR monitorenter ;
        Bucket bucket = getBucket(i);
        if (mInUseValues.remove(obj)) goto _L2; else goto _L1
_L1:
        FLog.e(TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", new Object[] {
            Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(i)
        });
        free(obj);
        mPoolStatsTracker.onFree(j);
_L3:
        logStats();
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (bucket == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (!bucket.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded() && isReusable(obj))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (bucket == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        bucket.decrementInUseCount();
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(i));
        }
        free(obj);
        mUsed.decrement(j);
        mPoolStatsTracker.onFree(j);
          goto _L3
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        bucket.release(obj);
        mFree.increment(j);
        mUsed.decrement(j);
        mPoolStatsTracker.onValueRelease(j);
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(obj)), Integer.valueOf(i));
        }
          goto _L3
    }

    public void trim(MemoryTrimType memorytrimtype)
    {
        trimToNothing();
    }

    void trimToNothing()
    {
        ArrayList arraylist = new ArrayList(mBuckets.size());
        Object obj = new SparseIntArray();
        this;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if (i >= mBuckets.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Bucket bucket = (Bucket)mBuckets.valueAt(i);
        if (bucket.getFreeListSize() > 0)
        {
            arraylist.add(bucket);
        }
        ((SparseIntArray) (obj)).put(mBuckets.keyAt(i), bucket.getInUseCount());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        initBuckets(((SparseIntArray) (obj)));
        mFree.reset();
        logStats();
        this;
        JVM INSTR monitorexit ;
        onParamsChanged();
        i = 0;
_L7:
        if (i >= arraylist.size()) goto _L4; else goto _L3
_L3:
        obj = (Bucket)arraylist.get(i);
_L5:
        Object obj1;
        obj1 = ((Bucket) (obj)).pop();
        if (obj1 == null)
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_165;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        free(obj1);
        if (true) goto _L5; else goto _L4
_L4:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void trimToSize(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int k = Math.min((mUsed.mNumBytes + mFree.mNumBytes) - i, mFree.mNumBytes);
        if (k > 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(mUsed.mNumBytes + mFree.mNumBytes), Integer.valueOf(k));
        }
        logStats();
        int j = 0;
_L5:
        if (j < mBuckets.size() && k > 0)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        logStats();
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(mUsed.mNumBytes + mFree.mNumBytes));
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        Bucket bucket = (Bucket)mBuckets.valueAt(j);
_L4:
        if (k <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = bucket.pop();
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        free(obj);
        k -= bucket.mItemSize;
        mFree.decrement(bucket.mItemSize);
        if (true) goto _L4; else goto _L3
_L3:
        j++;
          goto _L5
    }

    void trimToSoftCap()
    {
        this;
        JVM INSTR monitorenter ;
        if (isMaxSizeSoftCapExceeded())
        {
            trimToSize(mPoolParams.maxSizeSoftCap);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
