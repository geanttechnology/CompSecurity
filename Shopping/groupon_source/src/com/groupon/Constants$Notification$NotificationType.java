// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


// Referenced classes of package com.groupon:
//            Constants

public static final class notificationId extends Enum
{

    private static final SOFTWARE_UPDATE_NOTIFICATION $VALUES[];
    public static final SOFTWARE_UPDATE_NOTIFICATION DEAL_NOTIFICATION;
    public static final SOFTWARE_UPDATE_NOTIFICATION LOCALIZED_MOBILE_APP_NOTIFICATION;
    public static final SOFTWARE_UPDATE_NOTIFICATION NON_DEAL_NOTIFICATION;
    public static final SOFTWARE_UPDATE_NOTIFICATION SOFTWARE_UPDATE_NOTIFICATION;
    private final int notificationId;

    public static notificationId valueOf(String s)
    {
        return (notificationId)Enum.valueOf(com/groupon/Constants$Notification$NotificationType, s);
    }

    public static notificationId[] values()
    {
        return (notificationId[])$VALUES.clone();
    }

    public int getId()
    {
        return notificationId;
    }

    static 
    {
        DEAL_NOTIFICATION = new <init>("DEAL_NOTIFICATION", 0, 1);
        NON_DEAL_NOTIFICATION = new <init>("NON_DEAL_NOTIFICATION", 1, 100);
        LOCALIZED_MOBILE_APP_NOTIFICATION = new <init>("LOCALIZED_MOBILE_APP_NOTIFICATION", 2, 3);
        SOFTWARE_UPDATE_NOTIFICATION = new <init>("SOFTWARE_UPDATE_NOTIFICATION", 3, 2);
        $VALUES = (new .VALUES[] {
            DEAL_NOTIFICATION, NON_DEAL_NOTIFICATION, LOCALIZED_MOBILE_APP_NOTIFICATION, SOFTWARE_UPDATE_NOTIFICATION
        });
    }

    private _cls9(String s, int i, int j)
    {
        super(s, i);
        notificationId = j;
    }
}
