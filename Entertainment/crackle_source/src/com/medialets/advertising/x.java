// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.os.Build;

final class x
{

    public static final String ANDROID_DEVICE;
    public static final String ANDROID_VERSION;
    public static final int AdAdTimeout = 5;
    public static final String AdAppForceExpandKey = "MMAdAppForceExpand";
    public static final int AdAppTerminated = 4;
    public static final String AdChildAdID = "MMAdChildAdID";
    public static final String AdClickThru_AppStore = "MMAdClickThru_AppStore";
    public static final String AdClickThru_Browser = "MMAdClickThru_Browser";
    public static final String AdClickThru_CustomApp = "MMAdClickThru_CustomApp";
    public static final String AdClickThru_Email = "MMAdClickThru_Email";
    public static final String AdClickThru_ExternalApp = "MMAdClickThru_ExternalApp";
    public static final String AdClickThru_GoogleMaps = "MMAdClickThru_GoogleMaps";
    public static final String AdClickThru_MusicStore = "MMAdClickThru_MusicStore";
    public static final String AdClickThru_Phone = "MMAdClickThru_Phone";
    public static final String AdClickThru_SMS = "MMAdClickThru_SMS";
    public static final String AdClickThru_Video = "MMAdClickThru_Video";
    public static final String AdClickThru_YouTube = "MMAdClickThru_YouTube";
    public static final int AdClickthrough = 1;
    public static final String AdCollapseKey = "MMAdCollapse";
    public static final int AdCollapsed = 7;
    public static final String AdEventKey = "MMAdEvent";
    public static final String AdExitKey = "MMAdExit";
    public static final int AdExited = 3;
    public static final String AdExpandKey = "MMAdExpand";
    public static final String AdIDKey = "MMAdID";
    public static final String AdParentAdID = "MMAdParentAdID";
    public static final int AdSkipped = 2;
    public static final String AdSlotKey = "MMAdSlot";
    public static final String AdStartTimeKey = "MMAdStartTimeKey";
    public static final String AdUrlStringKey = "MMAdUrlString";
    public static final String AdVersionKey = "MMAdVersion";
    public static final String AdViewDurationKey = "MMAdViewDuration";
    public static final String AdViewedKey = "MMAdViewed";
    public static final int AppCrash = 6;
    public static final String BUILD_VERSION = "2.2.11.0";
    public static final String CACHE_DIR = "medialytics";
    public static final String DEVICE_URL = ".mm/server/control.json";
    public static final int ExitUnkown = 0;
    public static boolean PRE_DONUT = false;
    public static boolean PRE_GINGER = false;
    public static final String PRODUCTION_URL = "http://a.medialytics.com/ad";
    public static final String SDK_CODENAME = "bifur";
    public static final String SDK_VERSION = "2.2.11";
    public static final String TAG = "MedialetsUniversalSDK";
    public static final String TEST_URL = "http://beta.medialytics.com/ad";

    x()
    {
    }

    static 
    {
        boolean flag1 = true;
        ANDROID_DEVICE = Build.MODEL;
        ANDROID_VERSION = android.os.Build.VERSION.RELEASE;
        boolean flag;
        if (Integer.parseInt(android.os.Build.VERSION.SDK) <= 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        PRE_DONUT = flag;
        if (Integer.parseInt(android.os.Build.VERSION.SDK) <= 8)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        PRE_GINGER = flag;
    }
}
