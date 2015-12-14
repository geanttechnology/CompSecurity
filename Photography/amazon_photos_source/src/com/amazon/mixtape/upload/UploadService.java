// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import android.app.Service;
import com.amazon.mixtape.service.StartIds;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class UploadService extends Service
{

    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;
    private static final String TAG = com/amazon/mixtape/upload/UploadService.getSimpleName();
    private final com.amazon.mixtape.metrics.MixtapeMetric.Timer mServiceActiveTimer = new com.amazon.mixtape.metrics.MixtapeMetric.Timer("UploadServiceActive");
    private int mServiceRunningState;
    private final StartIds mStartIds = new StartIds(this);
    private final ConcurrentLinkedQueue mStateObservers = new ConcurrentLinkedQueue();
    private final Lock mUploadTaskStatesLock = new ReentrantLock();
    private final Condition mUploadTaskStatesModified;

    public UploadService()
    {
        mUploadTaskStatesModified = mUploadTaskStatesLock.newCondition();
        mServiceRunningState = 0;
    }

    static 
    {
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    }
}
