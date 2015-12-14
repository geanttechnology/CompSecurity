// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;

public final class DeviceUtil
{

    private DeviceUtil()
    {
    }

    public static int getAndroidVersion(Context context)
    {
        int i;
        try
        {
            context = Class.forName("android.os.Build$VERSION").getField("SDK_INT");
            i = context.getInt(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            int j;
            try
            {
                context = Class.forName("android.os.Build$VERSION").getField("SDK");
                j = Integer.parseInt((String)context.get(context));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return -1;
            }
            return j;
        }
        return i;
    }

    public static final String getDeviceID(Context context)
    {
        if (context != null)
        {
            if ((context = ((Context) (context.getSystemService("phone")))) != null)
            {
                return ((TelephonyManager)context).getDeviceId();
            }
        }
        return null;
    }

    public static int getScreenHeight(Activity activity)
    {
        if (activity != null)
        {
            if ((activity = activity.getWindowManager()) != null && activity.getDefaultDisplay() != null)
            {
                return activity.getDefaultDisplay().getHeight();
            }
        }
        return -1;
    }

    public static int getScreenWidth(Activity activity)
    {
        if (activity != null)
        {
            if ((activity = activity.getWindowManager()) != null && activity.getDefaultDisplay() != null)
            {
                return activity.getDefaultDisplay().getWidth();
            }
        }
        return -1;
    }

    public static boolean isHDPI(Activity activity)
    {
        if (activity != null)
        {
            int i = getScreenHeight(activity);
            int j = getScreenWidth(activity);
            if (i > 0 && j > 0 && (i > 790 || j > 790))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isLDPI(Activity activity)
    {
        if (activity != null)
        {
            int i = getScreenHeight(activity);
            int j = getScreenWidth(activity);
            if (i > 0 && j > 0 && (i <= 240 || j <= 240))
            {
                return true;
            }
        }
        return false;
    }
}
