// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.cyberlink.youcammakeup.Globals;

public class bd
{

    public static final String a = "market://details?id=";
    private static String b = "RateUsUtils";
    private static String c;
    private static final String d = "http://play.google.com/store/apps/details?id=";
    private static final Uri e;
    private static final Uri f;

    public static boolean a(Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW", e);
        try
        {
            activity.startActivity(intent);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", f));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Activity activity, String s, String s1, String s2)
    {
        s1 = (new StringBuilder()).append("&referrer=utm_source%3D").append(s1).append("%26utm_medium%3D").append(s2).toString();
        s2 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(a).append(s).append(s1).toString()));
        try
        {
            activity.startActivity(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s2)
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(d).append(s).append(s1).toString())));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    static 
    {
        c = Globals.d().getPackageName();
        e = Uri.parse((new StringBuilder()).append(a).append(c).toString());
        f = Uri.parse((new StringBuilder()).append(d).append(c).toString());
    }
}
