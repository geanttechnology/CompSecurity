// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            AdvertisingIdentifier, DebugProperties, StringUtils

static class canDo
{

    private String advertisingIdentifier;
    private boolean canDo;
    private boolean limitAdTrackingEnabled;
    private String sisDeviceIdentifier;

    boolean canDo()
    {
        return canDo;
    }

    String getAdvertisingIdentifier()
    {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.idfa", advertisingIdentifier);
    }

    String getSISDeviceIdentifier()
    {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.adid", sisDeviceIdentifier);
    }

    boolean hasAdvertisingIdentifier()
    {
        return !StringUtils.isNullOrEmpty(getAdvertisingIdentifier());
    }

    boolean isLimitAdTrackingEnabled()
    {
        return DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.optOut", limitAdTrackingEnabled);
    }


/*
    static  access$000$12f690c7( )
    {
        .canDo = false;
        return ;
    }

*/


/*
    static canDo access$100(canDo cando, String s)
    {
        cando.advertisingIdentifier = s;
        return cando;
    }

*/


/*
    static advertisingIdentifier access$200(advertisingIdentifier advertisingidentifier, boolean flag)
    {
        advertisingidentifier.limitAdTrackingEnabled = flag;
        return advertisingidentifier;
    }

*/


/*
    static limitAdTrackingEnabled access$300(limitAdTrackingEnabled limitadtrackingenabled, String s)
    {
        limitadtrackingenabled.sisDeviceIdentifier = s;
        return limitadtrackingenabled;
    }

*/

    sisDeviceIdentifier()
    {
        canDo = true;
    }
}
