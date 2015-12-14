// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;


// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDayMetricsHelper

private static final class  extends Enum
{

    private static final ThisDayBannerOpen $VALUES[];
    public static final ThisDayBannerOpen AppDownload;
    public static final ThisDayBannerOpen ThisDayBannerDisplay;
    public static final ThisDayBannerOpen ThisDayBannerOpen;
    public static final ThisDayBannerOpen ThisDayNotificationsToggle;
    public static final ThisDayBannerOpen ThisDayOpenNotification;
    public static final ThisDayBannerOpen ThisDayPostNotification;
    public static final ThisDayBannerOpen ThisDayShuffleViewSingle;
    public static final ThisDayBannerOpen ThisDayViewAll;
    public static final ThisDayBannerOpen ThisDayYearViewAll;
    public static final ThisDayBannerOpen ThisDayYearViewSingle;
    public static final ThisDayBannerOpen ThisWeekYearViewAll;
    public static final ThisDayBannerOpen ThisWeekYearViewSingle;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/thisday/ThisDayMetricsHelper$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ThisDayViewAll = new <init>("ThisDayViewAll", 0);
        ThisDayYearViewAll = new <init>("ThisDayYearViewAll", 1);
        ThisWeekYearViewAll = new <init>("ThisWeekYearViewAll", 2);
        ThisDayYearViewSingle = new <init>("ThisDayYearViewSingle", 3);
        ThisWeekYearViewSingle = new <init>("ThisWeekYearViewSingle", 4);
        ThisDayShuffleViewSingle = new <init>("ThisDayShuffleViewSingle", 5);
        ThisDayPostNotification = new <init>("ThisDayPostNotification", 6);
        ThisDayOpenNotification = new <init>("ThisDayOpenNotification", 7);
        AppDownload = new <init>("AppDownload", 8);
        ThisDayNotificationsToggle = new <init>("ThisDayNotificationsToggle", 9);
        ThisDayBannerDisplay = new <init>("ThisDayBannerDisplay", 10);
        ThisDayBannerOpen = new <init>("ThisDayBannerOpen", 11);
        $VALUES = (new .VALUES[] {
            ThisDayViewAll, ThisDayYearViewAll, ThisWeekYearViewAll, ThisDayYearViewSingle, ThisWeekYearViewSingle, ThisDayShuffleViewSingle, ThisDayPostNotification, ThisDayOpenNotification, AppDownload, ThisDayNotificationsToggle, 
            ThisDayBannerDisplay, ThisDayBannerOpen
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
