// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sponsorpay.mediation.SPMediationAdapter;
import com.sponsorpay.utils.SponsorPayLogger;
import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.mbe.mediation:
//            SPTPNVideoEvent, SPMediationValidationEvent, SPMediationVideoEvent, SPTPNVideoValidationResult

public abstract class SPBrandEngageMediationAdapter
{

    public static final int START_TIMEOUT_DELAY = 4500;
    private static final String TAG = "SPBrandEngageMediationAdapter";
    private static final short VALIDATION_RESULT = 1;
    public static final int VALIDATION_TIMEOUT_DELAY = 4500;
    private static final short VIDEO_EVENT = 2;
    protected SPMediationAdapter mAdapter;
    private Handler mHandler;
    private Map mValidationContextData;
    private SPMediationValidationEvent mValidationEvent;
    private Map mVideoContextData;
    private SPMediationVideoEvent mVideoEvent;
    private boolean mVideoPlayed;

    public SPBrandEngageMediationAdapter(SPMediationAdapter spmediationadapter)
    {
        mVideoPlayed = false;
        mAdapter = spmediationadapter;
        mHandler = new Handler(Looper.getMainLooper()) {

            final SPBrandEngageMediationAdapter this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    sendValidationEvent(SPTPNVideoValidationResult.SPTPNValidationTimeout);
                    return;

                case 2: // '\002'
                    sendVideoEvent(SPTPNVideoEvent.SPTPNVideoEventTimeout);
                    break;
                }
            }

            
            {
                this$0 = SPBrandEngageMediationAdapter.this;
                super(looper);
            }
        };
    }

    protected void clearVideoEvent()
    {
        mVideoEvent = null;
        mVideoContextData = null;
    }

    public SPMediationAdapter getMediationAdapter()
    {
        return mAdapter;
    }

    protected String getName()
    {
        return mAdapter.getName();
    }

    protected void notifyCloseEngagement()
    {
        SPTPNVideoEvent sptpnvideoevent;
        if (mVideoPlayed)
        {
            sptpnvideoevent = SPTPNVideoEvent.SPTPNVideoEventClosed;
        } else
        {
            sptpnvideoevent = SPTPNVideoEvent.SPTPNVideoEventAborted;
        }
        sendVideoEvent(sptpnvideoevent);
        clearVideoEvent();
    }

    protected void notifyVideoError()
    {
        sendVideoEvent(SPTPNVideoEvent.SPTPNVideoEventError);
        clearVideoEvent();
    }

    protected void notifyVideoStarted()
    {
        sendVideoEvent(SPTPNVideoEvent.SPTPNVideoEventStarted);
    }

    protected void sendValidationEvent(SPTPNVideoValidationResult sptpnvideovalidationresult)
    {
        if (mValidationEvent != null)
        {
            mHandler.removeMessages(1);
            mValidationEvent.validationEventResult(getName(), sptpnvideovalidationresult, mValidationContextData);
            mValidationEvent = null;
            mValidationContextData = null;
            return;
        } else
        {
            SponsorPayLogger.i("SPBrandEngageMediationAdapter", "No validation event listener");
            return;
        }
    }

    protected void sendVideoEvent(SPTPNVideoEvent sptpnvideoevent)
    {
        if (mVideoEvent != null)
        {
            if (sptpnvideoevent.equals(SPTPNVideoEvent.SPTPNVideoEventStarted))
            {
                mHandler.removeMessages(2);
            }
            mVideoEvent.videoEventOccured(getName(), sptpnvideoevent, mVideoContextData);
            return;
        } else
        {
            SponsorPayLogger.i("SPBrandEngageMediationAdapter", "No video event listener");
            return;
        }
    }

    protected void setVideoPlayed()
    {
        sendVideoEvent(SPTPNVideoEvent.SPTPNVideoEventFinished);
        mVideoPlayed = true;
    }

    public abstract void startVideo(Activity activity);

    public void startVideo(Activity activity, SPMediationVideoEvent spmediationvideoevent, Map map)
    {
        mVideoPlayed = false;
        mVideoEvent = spmediationvideoevent;
        mVideoContextData = map;
        mHandler.sendEmptyMessageDelayed(2, 4500L);
        startVideo(activity);
    }

    public abstract void videosAvailable(Context context);

    public void videosAvailable(Context context, SPMediationValidationEvent spmediationvalidationevent, Map map)
    {
        mValidationEvent = spmediationvalidationevent;
        mValidationContextData = map;
        mHandler.sendEmptyMessageDelayed(1, 4500L);
        videosAvailable(context);
    }
}
