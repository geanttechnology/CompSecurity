// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;

public class CompatibilityUtil
{

    public CompatibilityUtil()
    {
    }

    public static int getSdkVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public static void setStatusBar(Activity activity)
    {
        if (activity != null && getSdkVersion() >= 21)
        {
            Window window = activity.getWindow();
            window.addFlags(0x80000000);
            window.clearFlags(0x4000000);
            window.setStatusBarColor(activity.getResources().getColor(0x7f0c0066));
        }
    }
}
