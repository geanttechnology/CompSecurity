// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.deeplink.DeepLinkData;
import com.groupon.models.nst.PointsExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.HashMap;

public class GrouponPointsUtil
{

    public static final String NOTIFICATION = "notification";
    public static final String PARAM_HIDE_HEADER = "hide_header";
    public static final String PARAM_URL = "url";
    public static final String PARAM_VALUE_TRUE = "true";
    public static final String POINTS_NOTIFICATION_CLICK = "points_notification_click";
    public static final String POINTS_RELATIVE_PATH = "/points";
    private Logger logger;

    public GrouponPointsUtil()
    {
    }

    public void appendQueryParams(DeepLinkData deeplinkdata)
    {
        deeplinkdata.getParams().put("needsAuth", "true");
        deeplinkdata.getParams().put("hide_header", "true");
    }

    public void logPointsDeepLinking(String s, String s1, String s2)
    {
        logger.logDeepLinking("", s, s1, s2, "notification", (new PointsExtraInfo("/points")).toEncodedString());
    }

    public void logPointsNotificationClink(String s)
    {
        logger.logClick("", "points_notification_click", s, Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
    }
}
