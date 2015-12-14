// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

public class ThorDeviceAttributeReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/gallery/thor/device/ThorDeviceAttributeReceiver.getName();

    public ThorDeviceAttributeReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        GLogger.d(TAG, "Account Property Has Changed, clearing cached device name", new Object[0]);
        ((DeviceAttributeStore)ThorGalleryApplication.getBean(Keys.DEVICE_ATTRIBUTE_STORE)).clearCachedDeviceInformation();
    }

}
