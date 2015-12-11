// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import android.content.Context;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            DeviceSelectionListener, BaseCastManager

public class CastMediaRouterCallback extends android.support.v7.media.MediaRouter.Callback
{

    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/CastMediaRouterCallback);
    private final Context mContext;
    private final DeviceSelectionListener selectDeviceInterface;

    public CastMediaRouterCallback(DeviceSelectionListener deviceselectionlistener, Context context)
    {
        selectDeviceInterface = deviceselectionlistener;
        mContext = context;
    }

    public void onRouteAdded(MediaRouter mediarouter, android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
        super.onRouteAdded(mediarouter, routeinfo);
        if (!mediarouter.getDefaultRoute().equals(routeinfo))
        {
            selectDeviceInterface.onCastDeviceDetected(routeinfo);
        }
        if (BaseCastManager.getCastManager().getReconnectionStatus() == BaseCastManager.ReconnectionStatus.STARTED)
        {
            mediarouter = Utils.getStringFromPreference(mContext, "route-id");
            if (routeinfo.getId().equals(mediarouter))
            {
                LogUtils.LOGD(TAG, (new StringBuilder()).append("onRouteAdded: Attempting to recover a session with info=").append(routeinfo).toString());
                BaseCastManager.getCastManager().setReconnectionStatus(BaseCastManager.ReconnectionStatus.IN_PROGRESS);
                mediarouter = CastDevice.getFromBundle(routeinfo.getExtras());
                LogUtils.LOGD(TAG, (new StringBuilder()).append("onRouteAdded: Attempting to recover a session with device: ").append(mediarouter.getFriendlyName()).toString());
                selectDeviceInterface.onDeviceSelected(mediarouter);
            }
        }
    }

    public void onRouteSelected(MediaRouter mediarouter, android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onRouteSelected: info=").append(routeinfo).toString());
        if (BaseCastManager.getCastManager().getReconnectionStatus() == BaseCastManager.ReconnectionStatus.FINALIZE)
        {
            BaseCastManager.getCastManager().setReconnectionStatus(BaseCastManager.ReconnectionStatus.INACTIVE);
            BaseCastManager.getCastManager().cancelReconnectionTask();
            return;
        } else
        {
            Utils.saveStringToPreference(mContext, "route-id", routeinfo.getId());
            mediarouter = CastDevice.getFromBundle(routeinfo.getExtras());
            selectDeviceInterface.onDeviceSelected(mediarouter);
            LogUtils.LOGD(TAG, (new StringBuilder()).append("onResult: mSelectedDevice=").append(mediarouter.getFriendlyName()).toString());
            return;
        }
    }

    public void onRouteUnselected(MediaRouter mediarouter, android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onRouteUnselected: route=").append(routeinfo).toString());
        selectDeviceInterface.onDeviceSelected(null);
    }

}
