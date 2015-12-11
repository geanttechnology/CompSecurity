// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            Log, Settings, Version, PermissionChecker, 
//            InternalAdRegistration, IInternalAdRegistration, RegistrationInfo

public final class AdRegistration
{

    private static final String LOG_TAG = "AdRegistration";

    protected AdRegistration()
    {
    }

    public static final void enableLogging(boolean flag)
    {
        Log.enableLoggingWithSetterNotification("AdRegistration", flag);
    }

    public static final void enableTesting(boolean flag)
    {
        Settings.getInstance().putTransientBoolean("testingEnabled", flag);
        Log.logSetterNotification("AdRegistration", "Test mode", Boolean.valueOf(flag));
    }

    public static final String getVersion()
    {
        return Version.getSDKVersion();
    }

    public static final void registerApp(Context context)
    {
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(context, "AdRegistration"))
        {
            return;
        } else
        {
            InternalAdRegistration.getInstance().contextReceived(context);
            InternalAdRegistration.getInstance().register();
            return;
        }
    }

    public static final void setAppKey(String s)
        throws IllegalArgumentException
    {
        InternalAdRegistration.getInstance().getRegistrationInfo().putAppKey(s);
    }
}
