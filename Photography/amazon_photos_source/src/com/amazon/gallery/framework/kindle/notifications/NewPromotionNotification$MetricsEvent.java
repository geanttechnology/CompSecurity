// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.notifications;


// Referenced classes of package com.amazon.gallery.framework.kindle.notifications:
//            NewPromotionNotification

public static final class  extends Enum
{

    private static final DismissedNotification $VALUES[];
    public static final DismissedNotification DismissedNotification;
    public static final DismissedNotification NotificationShown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/notifications/NewPromotionNotification$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NotificationShown = new <init>("NotificationShown", 0);
        DismissedNotification = new <init>("DismissedNotification", 1);
        $VALUES = (new .VALUES[] {
            NotificationShown, DismissedNotification
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
