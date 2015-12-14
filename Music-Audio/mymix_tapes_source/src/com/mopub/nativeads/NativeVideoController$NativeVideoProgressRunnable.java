// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.view.TextureView;
import com.google.android.exoplayer.ExoPlayer;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.RepeatingHandlerRunnable;
import com.mopub.mobileads.VastTracker;
import com.mopub.mobileads.VastVideoConfig;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.nativeads:
//            NativeVideoController

static class mDuration extends RepeatingHandlerRunnable
{
    public static interface ProgressListener
    {

        public abstract void updateProgress(int i);
    }


    private final Context mContext;
    private long mCurrentPosition;
    private long mDuration;
    private ExoPlayer mExoPlayer;
    private ProgressListener mProgressListener;
    private TextureView mTextureView;
    private final VastVideoConfig mVastVideoConfig;
    private final ProgressListener mVisibilityChecker;
    private final List mVisibilityTrackingEvents;

    void checkImpressionTrackers(boolean flag)
    {
        Iterator iterator = mVisibilityTrackingEvents.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ProgressListener progresslistener = (mVisibilityTrackingEvents)iterator.next();
            if (!progresslistener.acked && (flag || mVisibilityChecker.mVisibilityChecker(mTextureView, mTextureView, progresslistener.mumPercentageVisible)))
            {
                progresslistener.lQualifiedPlayCounter = (int)((long)progresslistener.lQualifiedPlayCounter + mUpdateIntervalMillis);
                if (flag || progresslistener.lQualifiedPlayCounter >= progresslistener.lRequiredPlayTimeMs)
                {
                    progresslistener.tegy.execute();
                    progresslistener.acked = true;
                }
            }
        } while (true);
    }

    public void doWork()
    {
        if (mExoPlayer != null && mExoPlayer.getPlayWhenReady())
        {
            mCurrentPosition = mExoPlayer.getCurrentPosition();
            mDuration = mExoPlayer.getDuration();
            if (mDuration > 0L)
            {
                checkImpressionTrackers(false);
                if (mProgressListener != null)
                {
                    float f = (float)mCurrentPosition / (float)mDuration;
                    mProgressListener.updateProgress((int)(f * 1000F));
                }
                Object obj = mVastVideoConfig.getUntriggeredTrackersBefore((int)mCurrentPosition, (int)mDuration);
                if (!((List) (obj)).isEmpty())
                {
                    ArrayList arraylist = new ArrayList();
                    obj = ((List) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        VastTracker vasttracker = (VastTracker)((Iterator) (obj)).next();
                        if (!vasttracker.isTracked())
                        {
                            arraylist.add(vasttracker.getTrackingUrl());
                            vasttracker.setTracked();
                        }
                    } while (true);
                    TrackingRequest.makeTrackingHttpRequest(arraylist, mContext);
                    return;
                }
            }
        }
    }

    long getCurrentPosition()
    {
        return mCurrentPosition;
    }

    long getDuration()
    {
        return mDuration;
    }

    void seekTo(long l)
    {
        mCurrentPosition = l;
    }

    void setExoPlayer(ExoPlayer exoplayer)
    {
        mExoPlayer = exoplayer;
    }

    void setProgressListener(ProgressListener progresslistener)
    {
        mProgressListener = progresslistener;
    }

    void setTextureView(TextureView textureview)
    {
        mTextureView = textureview;
    }

    void setUpdateIntervalMillis(long l)
    {
        mUpdateIntervalMillis = l;
    }

    ProgressListener(Context context, Handler handler, List list, VastVideoConfig vastvideoconfig)
    {
        this(context, handler, list, new <init>(), vastvideoconfig);
    }

    <init>(Context context, Handler handler, List list, <init> <init>1, VastVideoConfig vastvideoconfig)
    {
        super(handler);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(vastvideoconfig);
        mContext = context.getApplicationContext();
        mVisibilityTrackingEvents = list;
        mVisibilityChecker = <init>1;
        mVastVideoConfig = vastvideoconfig;
        mDuration = -1L;
    }
}
