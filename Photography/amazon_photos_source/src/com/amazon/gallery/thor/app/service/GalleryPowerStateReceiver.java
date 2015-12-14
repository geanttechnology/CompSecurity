// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.service.PowerConnectionReceiver;
import com.amazon.gallery.framework.data.messaging.PowerConnectionStateChanged;

public class GalleryPowerStateReceiver extends PowerConnectionReceiver
{

    public GalleryPowerStateReceiver()
    {
    }

    public void onPowerConnected()
    {
        GlobalMessagingBus.post(new PowerConnectionStateChanged(true));
    }

    public void onPowerDisconnected()
    {
        GlobalMessagingBus.post(new PowerConnectionStateChanged(false));
    }
}
