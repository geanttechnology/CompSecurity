// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdvertisingIdentifier, DebugProperties, StringUtils

static class <init>
{

    private String advertisingIdentifier;
    private boolean canDo;
    private final DebugProperties debugProperties;
    private boolean limitAdTrackingEnabled;
    private String sisDeviceIdentifier;

    private <init> setAdvertisingIdentifier(String s)
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

    boolean canDo()
    {
        return canDo;
    }

    String getAdvertisingIdentifier()
    {
        return debugProperties.getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
    }

    String getSISDeviceIdentifier()
    {
        return debugProperties.getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
    }

    boolean hasAdvertisingIdentifier()
    {
        return !StringUtils.isNullOrEmpty(getAdvertisingIdentifier());
    }

    boolean hasSISDeviceIdentifier()
    {
        return getSISDeviceIdentifier() != null;
    }

    boolean isLimitAdTrackingEnabled()
    {
        return debugProperties.getDebugPropertyAsBoolean("debug.optOut", Boolean.valueOf(limitAdTrackingEnabled)).booleanValue();
    }

    limitAdTrackingEnabled setSISDeviceIdentifier(String s)
    {
        sisDeviceIdentifier = s;
        return this;
    }




    private (DebugProperties debugproperties)
    {
        debugProperties = debugproperties;
        canDo = true;
    }

    canDo(DebugProperties debugproperties, canDo cando)
    {
        this(debugproperties);
    }
}
