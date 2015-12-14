// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;

public class PoolParams
{

    public static final int IGNORE_THREADS = -1;
    public final SparseIntArray bucketSizes;
    public final int maxBucketSize;
    public final int maxNumThreads;
    public final int maxSizeHardCap;
    public final int maxSizeSoftCap;
    public final int minBucketSize;

    public PoolParams(int i, int j, SparseIntArray sparseintarray)
    {
        this(i, j, sparseintarray, 0, 0x7fffffff, -1);
    }

    public PoolParams(int i, int j, SparseIntArray sparseintarray, int k, int l, int i1)
    {
        boolean flag;
        if (i >= 0 && j >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        maxSizeSoftCap = i;
        maxSizeHardCap = j;
        bucketSizes = sparseintarray;
        minBucketSize = k;
        maxBucketSize = l;
        maxNumThreads = i1;
    }

    public PoolParams(int i, SparseIntArray sparseintarray)
    {
        this(i, i, sparseintarray, 0, 0x7fffffff, -1);
    }
}
