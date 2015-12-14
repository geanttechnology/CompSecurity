// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.atomic.AtomicInteger;

public class UploadItemStatus
{

    private static final String TAG = com/amazon/gallery/framework/network/multiqueueuploader/UploadItemStatus.getName();
    private final int maxProgress;
    private final AtomicInteger progress;
    private final long size;

    UploadItemStatus(long l)
    {
        this(l, 100);
    }

    UploadItemStatus(long l, int i)
    {
        progress = new AtomicInteger(0);
        size = l;
        maxProgress = i;
    }

    public long failed()
    {
        float f = size - getUploadedBytes();
        progress.set(0);
        return (long)f;
    }

    public long getUploadedBytes()
    {
        return (long)((float)size * ((float)progress.get() / (float)maxProgress));
    }

    public long updateStatus(int i, int j)
    {
        if (maxProgress != j)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected MaxProgress Value. Expected: ").append(maxProgress).append(", Actual: ").append(j).toString());
        }
        int k;
        do
        {
            k = progress.get();
            if (i <= k)
            {
                GLogger.v(TAG, "Stale progress information progress: %d, previous progress: %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(k)
                });
                return 0L;
            }
        } while (!progress.compareAndSet(k, i));
        long l = (long)((double)size * ((double)k / (double)j));
        long l1 = (long)((double)size * ((double)i / (double)j));
        long l2 = l1 - l;
        GLogger.v(TAG, "Uploaded: %d, Total: %d / %d", new Object[] {
            Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l)
        });
        return l2;
    }

}
