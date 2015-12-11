// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;


// Referenced classes of package com.ebay.mobile.notifications:
//            EbaySmartNotificationManager

public static final class value extends Enum
{

    private static final GOOGLE_NOW $VALUES[];
    public static final GOOGLE_NOW C2DM;
    public static final GOOGLE_NOW GCM;
    public static final GOOGLE_NOW GOOGLE_NOW;
    public static final GOOGLE_NOW POLL;
    private String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/ebay/mobile/notifications/EbaySmartNotificationManager$NotificationType, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    public String getValue()
    {
        return value;
    }

    static 
    {
        POLL = new <init>("POLL", 0, "POLL");
        C2DM = new <init>("C2DM", 1, "C2DM");
        GCM = new <init>("GCM", 2, "GCM");
        GOOGLE_NOW = new <init>("GOOGLE_NOW", 3, "GOOGLE_NOW");
        $VALUES = (new .VALUES[] {
            POLL, C2DM, GCM, GOOGLE_NOW
        });
    }

    private Q(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
