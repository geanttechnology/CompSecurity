// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import roboguice.util.Ln;

public class PlayServicesUtils
{

    public static final int PLAY_SERVICE_VERSION_ERROR = -1;

    public PlayServicesUtils()
    {
    }

    public static int getGooglePlayServicesVersion(Context context)
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Ln.d(context);
            return -1;
        }
        return i;
    }
}
