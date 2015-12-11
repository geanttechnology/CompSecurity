// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubLifecycleManager;
import com.mopub.common.logging.MoPubLog;
import java.util.Map;

public abstract class CustomEventRewardedVideo
{
    protected static interface CustomEventRewardedVideoListener
    {
    }


    public CustomEventRewardedVideo()
    {
    }

    protected abstract boolean checkAndInitializeSdk(Activity activity, Map map, Map map1)
        throws Exception;

    protected abstract String getAdNetworkId();

    protected abstract LifecycleListener getLifecycleListener();

    protected abstract CustomEventRewardedVideoListener getVideoListenerForSdk();

    protected abstract boolean hasVideoAvailable();

    final void loadCustomEvent(Activity activity, Map map, Map map1)
    {
        try
        {
            if (checkAndInitializeSdk(activity, map, map1))
            {
                MoPubLifecycleManager.getInstance(activity).addLifecycleListener(getLifecycleListener());
            }
            loadWithSdkInitialized(activity, map, map1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            MoPubLog.e(activity.getMessage());
        }
    }

    protected abstract void loadWithSdkInitialized(Activity activity, Map map, Map map1)
        throws Exception;

    protected abstract void onInvalidate();

    protected abstract void showVideo();
}
