// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


class AndroidTargetUtils
{

    private static boolean isWebViewCheckedAndOk = false;

    public static void editorApply(android.content.SharedPreferences.Editor editor)
    {
        editor.apply();
    }

    public static boolean isAtLeastAndroidAPI$134632()
    {
        return android.os.Build.VERSION.SDK_INT >= 9;
    }

    public static boolean isAtOrBelowAndroidAPI$134632()
    {
        return android.os.Build.VERSION.SDK_INT <= 7;
    }

}
