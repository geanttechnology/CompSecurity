// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            GooglePlayServices

static class gpsAvailable
{

    private String advertisingIdentifier;
    private boolean gpsAvailable;
    private boolean limitAdTrackingEnabled;

    static gpsAvailable createNotAvailable()
    {
        return (new <init>()).setGPSAvailable(false);
    }

    private setGPSAvailable setGPSAvailable(boolean flag)
    {
        gpsAvailable = flag;
        return this;
    }

    String getAdvertisingIdentifier()
    {
        return advertisingIdentifier;
    }

    boolean hasAdvertisingIdentifier()
    {
        return getAdvertisingIdentifier() != null;
    }

    boolean isGPSAvailable()
    {
        return gpsAvailable;
    }

    boolean isLimitAdTrackingEnabled()
    {
        return limitAdTrackingEnabled;
    }

    limitAdTrackingEnabled setAdvertisingIdentifier(String s)
    {
        advertisingIdentifier = s;
        return this;
    }

    advertisingIdentifier setLimitAdTrackingEnabled(boolean flag)
    {
        limitAdTrackingEnabled = flag;
        return this;
    }

    protected ()
    {
        gpsAvailable = true;
    }
}
