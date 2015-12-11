// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonMediaDevice, AmazonValueCallback, AmazonOnMediaDeviceUpdateListener

public abstract class AmazonMediaDeviceSettings
{
    public static interface Callback
    {

        public abstract void invoke(boolean flag, boolean flag1);
    }


    public AmazonMediaDeviceSettings()
    {
    }

    public abstract void setDefaultMediaDevice(AmazonMediaDevice amazonmediadevice, AmazonValueCallback amazonvaluecallback);

    public abstract void setOnMediaDeviceUpdateListener(AmazonOnMediaDeviceUpdateListener amazononmediadeviceupdatelistener);

    public abstract void startEnumerationOfMediaDevices();
}
