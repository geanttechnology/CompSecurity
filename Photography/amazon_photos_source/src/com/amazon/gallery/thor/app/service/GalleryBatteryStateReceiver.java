// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.service.BatteryConnectionReceiver;
import com.amazon.gallery.framework.data.messaging.BatteryStateChangedEvent;

public class GalleryBatteryStateReceiver extends BatteryConnectionReceiver
{

    public GalleryBatteryStateReceiver()
    {
    }

    public void onBatteryLow()
    {
        GlobalMessagingBus.post(new BatteryStateChangedEvent(true));
    }

    public void onBatteryOkay()
    {
        GlobalMessagingBus.post(new BatteryStateChangedEvent(false));
    }
}
