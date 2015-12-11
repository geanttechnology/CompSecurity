// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AnalyticsUtilHelper
{

    private static final String DEFAULT_TRACKING_COMPONENT_NAME = ".analytics.AnalyticsReceiver";

    private AnalyticsUtilHelper()
    {
    }

    public static void sendTrackingEvent(Bundle bundle, Context context)
    {
        if (context != null && bundle != null)
        {
            Intent intent = new Intent("com.ebay.common.analytics.ACTION_SEND_ANALYTICS");
            intent.setComponent(new ComponentName(context, (new StringBuilder()).append(context.getPackageName()).append(".analytics.AnalyticsReceiver").toString()));
            intent.putExtras(bundle);
            context.sendBroadcast(intent, (new StringBuilder()).append(context.getPackageName()).append(".permission.EBAY_USER_CONFIG").toString());
        }
    }
}
