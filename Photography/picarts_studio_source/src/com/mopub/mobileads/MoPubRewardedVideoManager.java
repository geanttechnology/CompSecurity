// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.AdFormat;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.LocationService;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.Reflection;
import com.mopub.network.AdRequest;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            RewardedVideoData, AdRequestStatusMapping, MoPubRewardedVideoListener, CustomEventRewardedVideo, 
//            WebViewAdUrlGenerator, MoPubErrorCode

public class MoPubRewardedVideoManager
{

    private static final int DEFAULT_LOAD_TIMEOUT = 30000;
    private static MoPubRewardedVideoManager sInstance;
    private final AdRequestStatusMapping mAdRequestStatus = new AdRequestStatusMapping();
    private final Handler mCallbackHandler = new Handler(Looper.getMainLooper());
    private final Context mContext;
    private final Handler mCustomEventTimeoutHandler = new Handler();
    private final Set mGlobalMediationSettings = new HashSet();
    private final Map mInstanceMediationSettings = new HashMap();
    private WeakReference mMainActivity;
    private final RewardedVideoData mRewardedVideoData = new RewardedVideoData();
    private final Map mTimeoutMap = new HashMap();
    private MoPubRewardedVideoListener mVideoListener;

    private transient MoPubRewardedVideoManager(Activity activity, MediationSettings amediationsettings[])
    {
        mMainActivity = new WeakReference(activity);
        mContext = activity.getApplicationContext();
        MoPubCollections.addAllNonNull(mGlobalMediationSettings, amediationsettings);
    }

    private void cancelTimeouts(String s)
    {
        s = (Runnable)mTimeoutMap.remove(s);
        if (s != null)
        {
            mCustomEventTimeoutHandler.removeCallbacks(s);
        }
    }

    private void failover(String s, MoPubErrorCode mopuberrorcode)
    {
        String s1 = mAdRequestStatus.getFailoverUrl(s);
        mAdRequestStatus.markFail(s);
        if (s1 != null)
        {
            loadVideo(s, s1);
        } else
        if (mVideoListener != null)
        {
            mVideoListener.onRewardedVideoLoadFailure(s, mopuberrorcode);
            return;
        }
    }

    public static MediationSettings getGlobalMediationSettings(Class class1)
    {
        if (sInstance == null)
        {
            logErrorNotInitialized();
            return null;
        }
        for (Iterator iterator = sInstance.mGlobalMediationSettings.iterator(); iterator.hasNext();)
        {
            MediationSettings mediationsettings = (MediationSettings)iterator.next();
            if (class1.equals(mediationsettings.getClass()))
            {
                return (MediationSettings)class1.cast(mediationsettings);
            }
        }

        return null;
    }

    public static MediationSettings getInstanceMediationSettings(Class class1, String s)
    {
        if (sInstance == null)
        {
            logErrorNotInitialized();
            return null;
        }
        s = (Set)sInstance.mInstanceMediationSettings.get(s);
        if (s == null)
        {
            return null;
        }
        for (s = s.iterator(); s.hasNext();)
        {
            MediationSettings mediationsettings = (MediationSettings)s.next();
            if (class1.equals(mediationsettings.getClass()))
            {
                return (MediationSettings)class1.cast(mediationsettings);
            }
        }

        return null;
    }

    public static boolean hasVideo(String s)
    {
        if (sInstance != null)
        {
            return isPlayable(s, sInstance.mRewardedVideoData.getCustomEvent(s));
        } else
        {
            logErrorNotInitialized();
            return false;
        }
    }

    public static transient void init(Activity activity, MediationSettings amediationsettings[])
    {
        com/mopub/mobileads/MoPubRewardedVideoManager;
        JVM INSTR monitorenter ;
        if (sInstance != null) goto _L2; else goto _L1
_L1:
        sInstance = new MoPubRewardedVideoManager(activity, amediationsettings);
_L4:
        com/mopub/mobileads/MoPubRewardedVideoManager;
        JVM INSTR monitorexit ;
        return;
_L2:
        MoPubLog.e("Tried to call initializeRewardedVideo more than once. Only the first initialization call has any effect.");
        if (true) goto _L4; else goto _L3
_L3:
        activity;
        throw activity;
    }

    private static boolean isPlayable(String s, CustomEventRewardedVideo customeventrewardedvideo)
    {
        return sInstance != null && sInstance.mAdRequestStatus.canPlay(s) && customeventrewardedvideo != null && customeventrewardedvideo.hasVideoAvailable();
    }

    private static void loadVideo(String s, String s1)
    {
        if (sInstance == null)
        {
            logErrorNotInitialized();
            return;
        }
        if (sInstance.mAdRequestStatus.isLoading(s))
        {
            MoPubLog.d(String.format(Locale.US, "Did not queue rewarded video request for ad unit %s. A request is already pending.", new Object[] {
                s
            }));
            return;
        } else
        {
            s1 = new AdRequest(s1, AdFormat.REWARDED_VIDEO, s, sInstance.mContext, sInstance. new RewardedVideoRequestListener(s));
            Networking.getRequestQueue(sInstance.mContext).add(s1);
            sInstance.mAdRequestStatus.markLoading(s);
            return;
        }
    }

    public static transient void loadVideo(String s, MediationSettings amediationsettings[])
    {
        if (sInstance == null)
        {
            logErrorNotInitialized();
            return;
        } else
        {
            HashSet hashset = new HashSet();
            MoPubCollections.addAllNonNull(hashset, amediationsettings);
            sInstance.mInstanceMediationSettings.put(s, hashset);
            loadVideo(s, (new WebViewAdUrlGenerator(sInstance.mContext, false)).withAdUnitId(s).withLocation(LocationService.getLastKnownLocation(sInstance.mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness())).generateUrlString("ads.mopub.com"));
            return;
        }
    }

    private static void logErrorNotInitialized()
    {
        MoPubLog.e("MoPub rewarded video was not initialized. You must call MoPub.initializeRewardedVideo() before loading or attempting to play video ads.");
    }

    private void onAdError(VolleyError volleyerror, String s)
    {
        Object obj = MoPubErrorCode.INTERNAL_ERROR;
        if (!(volleyerror instanceof MoPubNetworkError)) goto _L2; else goto _L1
_L1:
        obj = (MoPubNetworkError)volleyerror;
        class _cls9
        {

            static final int $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[];

            static 
            {
                $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = new int[com.mopub.network.MoPubNetworkError.Reason.values().length];
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.NO_FILL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.WARMING_UP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.BAD_BODY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$network$MoPubNetworkError$Reason[com.mopub.network.MoPubNetworkError.Reason.BAD_HEADER_DATA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls9..SwitchMap.com.mopub.network.MoPubNetworkError.Reason[((MoPubNetworkError) (obj)).getReason().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 70
    //                   2 70;
           goto _L3 _L4 _L4
_L3:
        obj = MoPubErrorCode.INTERNAL_ERROR;
_L2:
        if (volleyerror instanceof NoConnectionError)
        {
            obj = MoPubErrorCode.NO_CONNECTION;
        }
        failover(s, ((MoPubErrorCode) (obj)));
        return;
_L4:
        obj = MoPubErrorCode.NO_FILL;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void onAdSuccess(AdResponse adresponse, String s)
    {
        Object obj;
        String s1;
        mAdRequestStatus.markLoaded(s, adresponse.getFailoverUrl(), adresponse.getImpressionTrackingUrl(), adresponse.getClickTrackingUrl());
        obj = adresponse.getAdTimeoutMillis();
        if (obj == null || ((Integer) (obj)).intValue() <= 0)
        {
            obj = Integer.valueOf(30000);
        }
        s1 = adresponse.getCustomEventClassName();
        if (s1 == null)
        {
            MoPubLog.e("Couldn't create custom event, class name was null.");
            failover(s, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        final CustomEventRewardedVideo customEvent;
        TreeMap treemap;
        Activity activity;
        customEvent = (CustomEventRewardedVideo)Reflection.instantiateClassWithEmptyConstructor(s1, com/mopub/mobileads/CustomEventRewardedVideo);
        treemap = new TreeMap();
        treemap.put("com_mopub_ad_unit_id", s);
        activity = (Activity)mMainActivity.get();
        if (activity == null)
        {
            try
            {
                MoPubLog.d("Could not load custom event because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded videos.");
                mAdRequestStatus.markFail(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AdResponse adresponse)
            {
                MoPubLog.e(String.format(Locale.US, "Couldn't create custom event with class name %s", new Object[] {
                    s1
                }));
            }
            failover(s, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        Runnable runnable = new Runnable() {

            final MoPubRewardedVideoManager this$0;
            final CustomEventRewardedVideo val$customEvent;

            public void run()
            {
                MoPubLog.d("Custom Event failed to load rewarded video in a timely fashion.");
                MoPubRewardedVideoManager.onRewardedVideoLoadFailure(customEvent.getClass(), customEvent.getAdNetworkId(), MoPubErrorCode.NETWORK_TIMEOUT);
                customEvent.onInvalidate();
            }

            
            {
                this$0 = MoPubRewardedVideoManager.this;
                customEvent = customeventrewardedvideo;
                super();
            }
        };
        mCustomEventTimeoutHandler.postDelayed(runnable, ((Integer) (obj)).intValue());
        mTimeoutMap.put(s, runnable);
        customEvent.loadCustomEvent(activity, treemap, adresponse.getServerExtras());
        adresponse = customEvent.getVideoListenerForSdk();
        obj = customEvent.getAdNetworkId();
        mRewardedVideoData.updateAdUnitCustomEventMapping(s, customEvent, adresponse, ((String) (obj)));
        return;
    }

    public static void onRewardedVideoClicked(Class class1, String s)
    {
        postToInstance(new ForEachMoPubIdRunnable(class1, s) {

            protected final void forEach(String s1)
            {
                TrackingRequest.makeTrackingHttpRequest(MoPubRewardedVideoManager.sInstance.mAdRequestStatus.getClickTrackerUrlString(s1), MoPubRewardedVideoManager.sInstance.mContext);
                MoPubRewardedVideoManager.sInstance.mAdRequestStatus.clearClickUrl(s1);
            }

        });
    }

    public static void onRewardedVideoClosed(Class class1, String s)
    {
        postToInstance(new ForEachMoPubIdRunnable(class1, s) {

            protected final void forEach(String s1)
            {
                if (MoPubRewardedVideoManager.sInstance.mVideoListener != null)
                {
                    MoPubRewardedVideoManager.sInstance.mVideoListener.onRewardedVideoClosed(s1);
                }
            }

        });
    }

    public static void onRewardedVideoCompleted(final Class customEventClass, final String thirdPartyId, final MoPubReward moPubReward)
    {
        postToInstance(new Runnable() {

            final Class val$customEventClass;
            final MoPubReward val$moPubReward;
            final String val$thirdPartyId;

            public final void run()
            {
                HashSet hashset = new HashSet(MoPubRewardedVideoManager.sInstance.mRewardedVideoData.getMoPubIdsForAdNetwork(customEventClass, thirdPartyId));
                if (MoPubRewardedVideoManager.sInstance.mVideoListener != null)
                {
                    MoPubRewardedVideoManager.sInstance.mVideoListener.onRewardedVideoCompleted(hashset, moPubReward);
                }
            }

            
            {
                customEventClass = class1;
                thirdPartyId = s;
                moPubReward = mopubreward;
                super();
            }
        });
    }

    public static void onRewardedVideoLoadFailure(final Class final_class1, String s, MoPubErrorCode mopuberrorcode)
    {
        postToInstance(new ForEachMoPubIdRunnable(s, mopuberrorcode) {

            final MoPubErrorCode val$errorCode;

            protected final void forEach(String s1)
            {
                MoPubRewardedVideoManager.sInstance.cancelTimeouts(s1);
                MoPubRewardedVideoManager.sInstance.failover(s1, errorCode);
            }

            
            {
                errorCode = mopuberrorcode;
                super(final_class1, s);
            }
        });
    }

    public static void onRewardedVideoLoadSuccess(Class class1, String s)
    {
        postToInstance(new ForEachMoPubIdRunnable(class1, s) {
            private class ForEachMoPubIdRunnable
                implements Runnable
            {

                private final Class mCustomEventClass;
                private final String mThirdPartyId;

                protected abstract void forEach(String s);

                public void run()
                {
                    for (Iterator iterator = MoPubRewardedVideoManager.sInstance.mRewardedVideoData.getMoPubIdsForAdNetwork(mCustomEventClass, mThirdPartyId).iterator(); iterator.hasNext(); forEach((String)iterator.next())) { }
                }

                ForEachMoPubIdRunnable(Class class1, String s)
                {
                    Preconditions.checkNotNull(class1);
                    Preconditions.checkNotNull(s);
                    mCustomEventClass = class1;
                    mThirdPartyId = s;
                }
            }


            protected final void forEach(String s1)
            {
                MoPubRewardedVideoManager.sInstance.cancelTimeouts(s1);
                if (MoPubRewardedVideoManager.sInstance.mVideoListener != null)
                {
                    MoPubRewardedVideoManager.sInstance.mVideoListener.onRewardedVideoLoadSuccess(s1);
                }
            }

        });
    }

    public static void onRewardedVideoPlaybackError(final Class final_class1, String s, MoPubErrorCode mopuberrorcode)
    {
        postToInstance(new ForEachMoPubIdRunnable(s, mopuberrorcode) {

            final MoPubErrorCode val$errorCode;

            protected final void forEach(String s1)
            {
                if (MoPubRewardedVideoManager.sInstance.mVideoListener != null)
                {
                    MoPubRewardedVideoManager.sInstance.mVideoListener.onRewardedVideoPlaybackError(s1, errorCode);
                }
            }

            
            {
                errorCode = mopuberrorcode;
                super(final_class1, s);
            }
        });
    }

    public static void onRewardedVideoStarted(Class class1, String s)
    {
        postToInstance(new ForEachMoPubIdRunnable(class1, s) {

            protected final void forEach(String s1)
            {
                if (MoPubRewardedVideoManager.sInstance.mVideoListener != null)
                {
                    MoPubRewardedVideoManager.sInstance.mVideoListener.onRewardedVideoStarted(s1);
                }
                TrackingRequest.makeTrackingHttpRequest(MoPubRewardedVideoManager.sInstance.mAdRequestStatus.getImpressionTrackerUrlString(s1), MoPubRewardedVideoManager.sInstance.mContext);
                MoPubRewardedVideoManager.sInstance.mAdRequestStatus.clearImpressionUrl(s1);
            }

        });
    }

    private static void postToInstance(Runnable runnable)
    {
        if (sInstance != null)
        {
            sInstance.mCallbackHandler.post(runnable);
        }
    }

    public static void setVideoListener(MoPubRewardedVideoListener mopubrewardedvideolistener)
    {
        if (sInstance != null)
        {
            sInstance.mVideoListener = mopubrewardedvideolistener;
            return;
        } else
        {
            logErrorNotInitialized();
            return;
        }
    }

    public static void showVideo(String s)
    {
        if (sInstance != null)
        {
            CustomEventRewardedVideo customeventrewardedvideo = sInstance.mRewardedVideoData.getCustomEvent(s);
            if (isPlayable(s, customeventrewardedvideo))
            {
                sInstance.mAdRequestStatus.markPlayed(s);
                customeventrewardedvideo.showVideo();
                return;
            } else
            {
                sInstance.failover(s, MoPubErrorCode.VIDEO_NOT_AVAILABLE);
                return;
            }
        } else
        {
            logErrorNotInitialized();
            return;
        }
    }

    public static void updateActivity(Activity activity)
    {
        if (sInstance != null)
        {
            sInstance.mMainActivity = new WeakReference(activity);
            return;
        } else
        {
            logErrorNotInitialized();
            return;
        }
    }










    private class RewardedVideoRequestListener
        implements com.mopub.network.AdRequest.Listener
    {

        public final String adUnitId;
        private final MoPubRewardedVideoManager mVideoManager;

        public void onErrorResponse(VolleyError volleyerror)
        {
            mVideoManager.onAdError(volleyerror, adUnitId);
        }

        public void onSuccess(AdResponse adresponse)
        {
            mVideoManager.onAdSuccess(adresponse, adUnitId);
        }

        public RewardedVideoRequestListener(String s)
        {
            adUnitId = s;
            mVideoManager = MoPubRewardedVideoManager.this;
        }
    }

}
