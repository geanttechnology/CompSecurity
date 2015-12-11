// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.app.Activity;
import com.mopub.mobileads.MoPubRewardedVideoListener;
import com.mopub.mobileads.MoPubRewardedVideoManager;

// Referenced classes of package com.mopub.common:
//            MoPubLifecycleManager, MediationSettings

public class MoPub
{
    public static final class LocationAwareness extends Enum
    {

        private static final LocationAwareness $VALUES[];
        public static final LocationAwareness DISABLED;
        public static final LocationAwareness NORMAL;
        public static final LocationAwareness TRUNCATED;

        public static LocationAwareness valueOf(String s)
        {
            return (LocationAwareness)Enum.valueOf(com/mopub/common/MoPub$LocationAwareness, s);
        }

        public static LocationAwareness[] values()
        {
            return (LocationAwareness[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new LocationAwareness("NORMAL", 0);
            TRUNCATED = new LocationAwareness("TRUNCATED", 1);
            DISABLED = new LocationAwareness("DISABLED", 2);
            $VALUES = (new LocationAwareness[] {
                NORMAL, TRUNCATED, DISABLED
            });
        }

        private LocationAwareness(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int DEFAULT_LOCATION_PRECISION = 6;
    public static final String SDK_VERSION = "3.10.0";
    private static volatile LocationAwareness sLocationLocationAwareness;
    private static volatile int sLocationPrecision = 6;

    public MoPub()
    {
    }

    public static LocationAwareness getLocationAwareness()
    {
        return sLocationLocationAwareness;
    }

    public static int getLocationPrecision()
    {
        return sLocationPrecision;
    }

    public static boolean hasRewardedVideo(String s)
    {
        return MoPubRewardedVideoManager.hasVideo(s);
    }

    public static transient void initializeRewardedVideo(Activity activity, MediationSettings amediationsettings[])
    {
        MoPubRewardedVideoManager.init(activity, amediationsettings);
    }

    public static transient void loadRewardedVideo(String s, MediationSettings amediationsettings[])
    {
        MoPubRewardedVideoManager.loadVideo(s, amediationsettings);
    }

    public static void onBackPressed(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    public static void onCreate(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        updateActivity(activity);
    }

    public static void onDestroy(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onPause(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onRestart(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        updateActivity(activity);
    }

    public static void onResume(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        updateActivity(activity);
    }

    public static void onStart(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        updateActivity(activity);
    }

    public static void onStop(Activity activity)
    {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    public static void setLocationAwareness(LocationAwareness locationawareness)
    {
        sLocationLocationAwareness = locationawareness;
    }

    public static void setLocationPrecision(int i)
    {
        sLocationPrecision = Math.min(Math.max(0, i), 6);
    }

    public static void setRewardedVideoListener(MoPubRewardedVideoListener mopubrewardedvideolistener)
    {
        MoPubRewardedVideoManager.setVideoListener(mopubrewardedvideolistener);
    }

    public static void showRewardedVideo(String s)
    {
        MoPubRewardedVideoManager.showVideo(s);
    }

    private static void updateActivity(Activity activity)
    {
        MoPubRewardedVideoManager.updateActivity(activity);
    }

    static 
    {
        sLocationLocationAwareness = LocationAwareness.NORMAL;
    }
}
