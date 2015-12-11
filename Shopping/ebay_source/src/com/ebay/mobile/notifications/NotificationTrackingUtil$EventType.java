// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;


// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationTrackingUtil

public static final class id extends Enum
{

    private static final CLEARED $VALUES[];
    public static final CLEARED CLEARED;
    public static final CLEARED RECEIVED;
    public static final CLEARED SETTING_DISABLED;
    public static final CLEARED SETTING_ENABLED;
    public final int id;

    public static id valueOf(String s)
    {
        return (id)Enum.valueOf(com/ebay/mobile/notifications/NotificationTrackingUtil$EventType, s);
    }

    public static id[] values()
    {
        return (id[])$VALUES.clone();
    }

    static 
    {
        RECEIVED = new <init>("RECEIVED", 0, 0);
        SETTING_ENABLED = new <init>("SETTING_ENABLED", 1, 1);
        SETTING_DISABLED = new <init>("SETTING_DISABLED", 2, 2);
        CLEARED = new <init>("CLEARED", 3, 3);
        $VALUES = (new .VALUES[] {
            RECEIVED, SETTING_ENABLED, SETTING_DISABLED, CLEARED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}
