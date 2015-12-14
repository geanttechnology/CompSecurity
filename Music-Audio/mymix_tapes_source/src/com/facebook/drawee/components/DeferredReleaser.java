// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DeferredReleaser
{
    public static interface Releasable
    {

        public abstract void release();
    }


    private static DeferredReleaser sInstance = null;
    private final Set mPendingReleasables = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final Runnable releaseRunnable = new Runnable() {

        final DeferredReleaser this$0;

        public void run()
        {
            for (Iterator iterator = mPendingReleasables.iterator(); iterator.hasNext(); ((Releasable)iterator.next()).release()) { }
            mPendingReleasables.clear();
        }

            
            {
                this$0 = DeferredReleaser.this;
                super();
            }
    };

    public DeferredReleaser()
    {
    }

    public static DeferredReleaser getInstance()
    {
        com/facebook/drawee/components/DeferredReleaser;
        JVM INSTR monitorenter ;
        DeferredReleaser deferredreleaser;
        if (sInstance == null)
        {
            sInstance = new DeferredReleaser();
        }
        deferredreleaser = sInstance;
        com/facebook/drawee/components/DeferredReleaser;
        JVM INSTR monitorexit ;
        return deferredreleaser;
        Exception exception;
        exception;
        throw exception;
    }

    public void cancelDeferredRelease(Releasable releasable)
    {
        mPendingReleasables.remove(releasable);
    }

    public void scheduleDeferredRelease(Releasable releasable)
    {
        while (!mPendingReleasables.add(releasable) || mPendingReleasables.size() != 1) 
        {
            return;
        }
        mUiHandler.post(releaseRunnable);
    }


}
