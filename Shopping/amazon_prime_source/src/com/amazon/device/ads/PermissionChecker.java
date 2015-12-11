// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

class PermissionChecker
{

    PermissionChecker()
    {
    }

    public boolean hasInternetPermission(Context context)
    {
        return hasPermission(context, "android.permission.INTERNET");
    }

    public boolean hasLocationPermission(Context context)
    {
        return hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public boolean hasPermission(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public boolean hasPhonePermission(Context context)
    {
        return hasPermission(context, "android.permission.CALL_PHONE");
    }

    public boolean hasReadCalendarPermission(Context context)
    {
        return hasPermission(context, "android.permission.READ_CALENDAR");
    }

    public boolean hasSmsPermission(Context context)
    {
        return hasPermission(context, "android.permission.SEND_SMS");
    }

    public boolean hasWriteCalendarPermission(Context context)
    {
        return hasPermission(context, "android.permission.WRITE_CALENDAR");
    }

    public boolean hasWriteExternalStoragePermission(Context context)
    {
        return hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
