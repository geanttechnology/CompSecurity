// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;


// Referenced classes of package com.ebay.common.model.mdns:
//            NotificationPreference

public static final class apiValue extends Enum
{

    private static final DEFERRED $VALUES[];
    public static final DEFERRED DEFERRED;
    public static final DEFERRED QUIET_PERIOD;
    public static final DEFERRED REAL_TIME;
    public String apiValue;

    public static apiValue valueOf(String s)
    {
        return (apiValue)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$DeliveryPolicyType, s);
    }

    public static apiValue[] values()
    {
        return (apiValue[])$VALUES.clone();
    }

    static 
    {
        REAL_TIME = new <init>("REAL_TIME", 0, "RealTime");
        QUIET_PERIOD = new <init>("QUIET_PERIOD", 1, "QuietPeriod");
        DEFERRED = new <init>("DEFERRED", 2, "Deferred");
        $VALUES = (new .VALUES[] {
            REAL_TIME, QUIET_PERIOD, DEFERRED
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        apiValue = s1;
    }
}
