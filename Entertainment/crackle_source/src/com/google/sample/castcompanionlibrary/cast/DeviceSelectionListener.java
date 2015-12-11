// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import com.google.android.gms.cast.CastDevice;

public interface DeviceSelectionListener
{

    public abstract void onCastDeviceDetected(android.support.v7.media.MediaRouter.RouteInfo routeinfo);

    public abstract void onDeviceSelected(CastDevice castdevice);
}
