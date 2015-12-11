// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.callbacks;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast.callbacks:
//            IBaseCastConsumer

public class BaseCastConsumerImpl
    implements IBaseCastConsumer
{

    public BaseCastConsumerImpl()
    {
    }

    public void onCastDeviceDetected(android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
    }

    public void onConnected()
    {
    }

    public boolean onConnectionFailed(ConnectionResult connectionresult)
    {
        return true;
    }

    public void onConnectionSuspended(int i)
    {
    }

    public void onConnectivityRecovered()
    {
    }

    public void onDisconnected()
    {
    }

    public void onFailed(int i, int j)
    {
    }
}
