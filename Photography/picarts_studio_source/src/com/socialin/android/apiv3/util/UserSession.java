// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;

import android.content.Context;
import android.content.Intent;
import com.socialin.android.apiv3.log.EventLoggingService;

public class UserSession
{

    private static UserSession sInstance = null;
    private Context applicationContext;

    private UserSession(Context context)
    {
        if (context == null)
        {
            return;
        } else
        {
            applicationContext = context.getApplicationContext();
            return;
        }
    }

    public static UserSession getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new UserSession(context.getApplicationContext());
        }
        return sInstance;
    }

    public void startSession()
    {
        Intent intent = (new Intent(applicationContext, com/socialin/android/apiv3/log/EventLoggingService)).setAction("picsart.start.session.action");
        applicationContext.startService(intent);
    }

    public void stopSession()
    {
        Intent intent = new Intent("picsart.end.session.action");
        applicationContext.sendBroadcast(intent);
    }

}
