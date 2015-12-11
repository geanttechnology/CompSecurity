// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdvertisingIdentifier, DebugProperties, Utils

static class canDo
{

    private String advertisingIdentifier;
    private boolean canDo;
    private boolean limitAdTrackingEnabled;
    private String sisDeviceIdentifier;

    private canDo setAdvertisingIdentifier(String s)
    {
        advertisingIdentifier = s;
        return this;
    }

    private advertisingIdentifier setCanDo(boolean flag)
    {
        canDo = flag;
        return this;
    }

    private canDo setLimitAdTrackingEnabled(boolean flag)
    {
        limitAdTrackingEnabled = flag;
        return this;
    }

    private limitAdTrackingEnabled setSISDeviceIdentifier(String s)
    {
        sisDeviceIdentifier = s;
        return this;
    }

    boolean canDo()
    {
        return canDo;
    }

    String getAdvertisingIdentifier()
    {
        return DebugProperties.getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
    }

    String getSISDeviceIdentifier()
    {
        return DebugProperties.getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
    }

    boolean hasAdvertisingIdentifier()
    {
        return !Utils.isNullOrEmpty(getAdvertisingIdentifier());
    }

    boolean hasSISDeviceIdentifier()
    {
        return getSISDeviceIdentifier() != null;
    }

    boolean isLimitAdTrackingEnabled()
    {
        return DebugProperties.getDebugPropertyAsBoolean("debug.optOut", limitAdTrackingEnabled);
    }





    ()
    {
        canDo = true;
    }
}
