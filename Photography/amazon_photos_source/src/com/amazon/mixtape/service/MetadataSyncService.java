// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import android.app.Service;
import android.os.Binder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MetadataSyncService extends Service
{
    public class LocalBinder extends Binder
    {

        private final Set mProgressObservers = new CopyOnWriteArraySet();
        private final Set mStateObservers = new CopyOnWriteArraySet();
        final MetadataSyncService this$0;

        public LocalBinder()
        {
            this$0 = MetadataSyncService.this;
            super();
        }
    }


    private static final String TAG = com/amazon/mixtape/service/MetadataSyncService.getSimpleName();
    private static final HashMap mAccountWorkerThreads = new HashMap();
    private Set mActiveStartIds;
    private final LocalBinder mBinder = new LocalBinder();
    private double mProgress;
    private final AtomicInteger mState = new AtomicInteger(0);

    public MetadataSyncService()
    {
        mProgress = 0.0D;
        mActiveStartIds = new HashSet();
    }

}
