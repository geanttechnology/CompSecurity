// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            RepeatingHandlerRunnable, VastVideoViewController, VastVideoConfig, VastTracker, 
//            VastMacroHelper

public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable
{

    private final VastVideoConfig mVastVideoConfig;
    private final VastVideoViewController mVideoViewController;

    public VastVideoViewProgressRunnable(VastVideoViewController vastvideoviewcontroller, VastVideoConfig vastvideoconfig, Handler handler)
    {
        super(handler);
        Preconditions.checkNotNull(vastvideoviewcontroller);
        Preconditions.checkNotNull(vastvideoconfig);
        mVideoViewController = vastvideoviewcontroller;
        mVastVideoConfig = vastvideoconfig;
    }

    public void doWork()
    {
        int i = mVideoViewController.getDuration();
        int j = mVideoViewController.getCurrentPosition();
        mVideoViewController.updateProgressBar();
        if (i > 0)
        {
            Object obj = mVastVideoConfig.getUntriggeredTrackersBefore(j, i);
            if (!((List) (obj)).isEmpty())
            {
                ArrayList arraylist = new ArrayList();
                VastTracker vasttracker;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); vasttracker.setTracked())
                {
                    vasttracker = (VastTracker)((Iterator) (obj)).next();
                    arraylist.add(vasttracker.getTrackingUrl());
                }

                TrackingRequest.makeTrackingHttpRequest((new VastMacroHelper(arraylist)).withAssetUri(mVideoViewController.getNetworkMediaFileUrl()).withContentPlayHead(Integer.valueOf(j)).getUris(), mVideoViewController.getContext());
            }
            mVideoViewController.handleIconDisplay(j);
        }
    }
}
