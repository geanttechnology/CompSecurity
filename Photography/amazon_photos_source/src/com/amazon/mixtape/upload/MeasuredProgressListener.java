// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.os.SystemClock;
import com.amazon.clouddrive.handlers.ProgressListener;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadTask

class MeasuredProgressListener
    implements ProgressListener
{

    private final long mBeginTimeMillis = SystemClock.elapsedRealtime();
    private double mMeanBytesPerMillis;
    private final UploadTask.Listener mTaskListener;
    private final UploadTask mUploadTask;

    MeasuredProgressListener(UploadTask uploadtask, UploadTask.Listener listener)
    {
        mUploadTask = uploadtask;
        mTaskListener = listener;
    }

    public double getMeanBytesPerMillis()
    {
        return mMeanBytesPerMillis;
    }

    public void onProgress(long l, long l1)
    {
        double d = 0.0D;
        if (mUploadTask.isCancelled())
        {
            Thread.currentThread().interrupt();
        }
        long l2 = SystemClock.elapsedRealtime() - mBeginTimeMillis;
        if ((double)l2 != 0.0D)
        {
            d = (double)l / (double)l2;
        }
        mMeanBytesPerMillis = d;
        mTaskListener.onProgress(mUploadTask, l, l1);
    }
}
