// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.service.NetworkConnectionReceiver;
import com.amazon.gallery.framework.data.messaging.NetworkStateChangedEvent;

public class GalleryNetworkStateReceiver extends NetworkConnectionReceiver
{

    public GalleryNetworkStateReceiver()
    {
    }

    protected void onNetworkConnected(boolean flag)
    {
        GlobalMessagingBus.post(new NetworkStateChangedEvent(true, flag));
    }

    public void onNetworkDisconnected()
    {
        GlobalMessagingBus.post(new NetworkStateChangedEvent(false, false));
    }
}
