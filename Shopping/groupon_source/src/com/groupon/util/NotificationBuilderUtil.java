// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;

public final class NotificationBuilderUtil
{

    public NotificationBuilderUtil()
    {
    }

    public static android.support.v4.app.NotificationCompat.Builder setupNotificationIcon(Context context, android.support.v4.app.NotificationCompat.Builder builder)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            builder.setSmallIcon(0x7f0202a1);
            builder.setColor(context.getResources().getColor(0x7f0e0135));
            return builder;
        } else
        {
            builder.setSmallIcon(0x7f0202a0);
            return builder;
        }
    }
}
