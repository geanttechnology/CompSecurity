// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import android.content.Context;
import com.amazon.avod.sdk.internal.AivConnection;
import com.amazon.avod.sdk.internal.CleanupGuard;
import java.util.List;

// Referenced classes of package com.amazon.avod.sdk:
//            VideoPlaybackStarter, PlaybackSupportResponse, ResponseHandler, CacheLevel

public class AmazonInstantVideo
{

    private final AivConnection mAivConnection;
    private final Object mCleanUpLock = new Object();
    private final CleanupGuard mConnectionGuard = new CleanupGuard();
    private final Context mContext;
    private final CleanupGuard mTeardownGuard = new CleanupGuard();

    public AmazonInstantVideo(Context context)
    {
        if (context == null)
        {
            throw new NullPointerException("Context cannot be null");
        } else
        {
            mContext = context;
            mAivConnection = com.amazon.avod.sdk.internal.AivConnection.Factory.newConnection(mContext);
            mConnectionGuard.open("cleanup");
            return;
        }
    }

    public void cleanup()
    {
label0:
        {
            synchronized (mCleanUpLock)
            {
                if (mConnectionGuard.isOpen())
                {
                    break label0;
                }
            }
            return;
        }
        mAivConnection.disconnect();
        mConnectionGuard.close();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void finalize()
        throws Throwable
    {
        if (mTeardownGuard != null)
        {
            mTeardownGuard.warnIfOpen();
            teardownPreparedVideo(null);
        }
        if (mConnectionGuard != null)
        {
            mConnectionGuard.warnIfOpen();
            cleanup();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public VideoPlaybackStarter play(String s, Constants.UrlType urltype)
    {
        return new VideoPlaybackStarter(mAivConnection, s, urltype);
    }

    public void queryPlaybackSupport(PlaybackSupportResponse playbacksupportresponse)
    {
        if (playbacksupportresponse == null)
        {
            throw new NullPointerException("callback cannot be null");
        } else
        {
            mAivConnection.queryPlaybackSupport(playbacksupportresponse);
            return;
        }
    }

    public void teardownPreparedVideo(ResponseHandler responsehandler)
    {
        if (!mTeardownGuard.isOpen())
        {
            return;
        } else
        {
            mAivConnection.teardownPreparedVideo(responsehandler);
            mTeardownGuard.close();
            return;
        }
    }

    public void whisperCacheContent(List list, CacheLevel cachelevel)
    {
        if (list == null)
        {
            throw new NullPointerException("asins cannot be null");
        }
        if (cachelevel == null)
        {
            throw new NullPointerException("bucket cannot be null");
        } else
        {
            mAivConnection.whisperCacheContent(list, cachelevel);
            return;
        }
    }
}
