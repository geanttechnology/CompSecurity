// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast.callbacks;

import com.google.android.gms.common.ConnectionResult;
import com.google.sample.castcompanionlibrary.cast.exceptions.OnFailedListener;

public interface IBaseCastConsumer
    extends OnFailedListener
{

    public abstract void onCastDeviceDetected(android.support.v7.media.MediaRouter.RouteInfo routeinfo);

    public abstract void onConnected();

    public abstract boolean onConnectionFailed(ConnectionResult connectionresult);

    public abstract void onConnectionSuspended(int i);

    public abstract void onConnectivityRecovered();

    public abstract void onDisconnected();
}
