// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class TaskManager
{

    protected final AtomicInteger mCompletedCount = new AtomicInteger(0);
    protected final AtomicBoolean mFailed = new AtomicBoolean(false);
    protected final TaskManagerListener mImageTaskManagerListener;
    protected final Map mResults;
    protected final int mSize;

    TaskManager(List list, TaskManagerListener taskmanagerlistener)
    {
        Preconditions.checkNotNull(list, "Urls list cannot be null");
        Preconditions.checkNotNull(taskmanagerlistener, "ImageTaskManagerListener cannot be null");
        boolean flag;
        if (!list.contains(null))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Urls list cannot contain null");
        mSize = list.size();
        mImageTaskManagerListener = taskmanagerlistener;
        mResults = Collections.synchronizedMap(new HashMap(mSize));
    }

    abstract void execute();
}
