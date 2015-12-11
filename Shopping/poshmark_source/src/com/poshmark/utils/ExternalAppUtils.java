// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.poshmark.application.AppInfo;
import com.poshmark.application.PMApplicationSession;
import java.util.Iterator;
import java.util.List;

public class ExternalAppUtils
{

    static final String fbMessengerPackageName = "com.facebook.orca";
    static final String instagramPackageName = "com.instagram.android";

    public ExternalAppUtils()
    {
    }

    public static String filterByPackageName(Context context, Intent intent, String s)
    {
        for (context = context.getPackageManager().queryIntentActivities(intent, 0).iterator(); context.hasNext();)
        {
            intent = (ResolveInfo)context.next();
            if (((ResolveInfo) (intent)).activityInfo.packageName.toLowerCase().startsWith(s))
            {
                return ((ResolveInfo) (intent)).activityInfo.packageName;
            }
        }

        return null;
    }

    public static boolean isAppInstalled(String s, Activity activity)
    {
        try
        {
            activity.getPackageManager().getApplicationInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean isFacebookInstalled(Activity activity)
    {
        return isAppInstalled("com.facebook.katana", activity);
    }

    public static boolean isFacebookMessengerInstalled(Activity activity)
    {
        return isAppInstalled("com.facebook.orca", activity);
    }

    public static boolean isPinterestAllInstalled(Activity activity)
    {
        return isAppInstalled("com.pinterest", activity);
    }

    public static boolean isTumblrAppInstalled(Activity activity)
    {
        return isAppInstalled("com.tumblr", activity);
    }

    public static boolean isTwitterAppInstalled(Activity activity)
    {
        return isAppInstalled("com.twitter.android", activity);
    }

    public static void showEmailClientForURL(Context context, String s)
    {
        String s6 = s.replaceFirst("mailto:", "");
        s = "";
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String as[] = s6.split("\\&");
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s5 = as[i];
            if (s5.startsWith("cc="))
            {
                s1 = s5.replace("cc=", "");
            } else
            if (s5.startsWith("bcc="))
            {
                s2 = s5.replace("bcc=", "");
            } else
            if (s5.startsWith("subject="))
            {
                s3 = s5.replace("subject=", "");
            } else
            if (s5.startsWith("body="))
            {
                s4 = s5.replace("body=", "");
            } else
            {
                s = s5;
            }
            i++;
        }
        s4 = (new StringBuilder()).append(s4).append("\nUsername: ").append(PMApplicationSession.GetPMSession().getUserName()).append("\n").append("Android Version: ").append(android.os.Build.VERSION.RELEASE).append("\n").append("SDK Version: ").append(String.format("%d", new Object[] {
            Integer.valueOf(android.os.Build.VERSION.SDK_INT)
        })).append("\n").append("Name/Model: ").append(AppInfo.getInstance().deviceModel).append("\n").append("App version: ").append(AppInfo.getInstance().versionName).append("\n\n").toString();
        s3 = s3.replace("%20", " ");
        s4 = s4.replace("%20", " ").replace("%0A", "\n");
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", s6, null));
        intent.putExtra("android.intent.extra.EMAIL", s);
        if (s1.length() > 0)
        {
            intent.putExtra("android.intent.extra.CC", s1);
        }
        if (s2.length() > 0)
        {
            intent.putExtra("android.intent.extra.BCC", s2);
        }
        if (s3.length() > 0)
        {
            intent.putExtra("android.intent.extra.SUBJECT", s3);
        }
        if (s4.length() > 0)
        {
            intent.putExtra("android.intent.extra.TEXT", s4);
        }
        context.startActivity(Intent.createChooser(intent, "Send email..."));
    }
}
