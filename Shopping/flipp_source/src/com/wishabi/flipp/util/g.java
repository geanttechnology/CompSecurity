// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.a.a.i;
import com.wishabi.flipp.app.FlippApplication;
import java.util.TimeZone;

public final class g
{

    public static final i a = i.a(TimeZone.getTimeZone("America/Toronto"));

    public static String a()
    {
        return a(d());
    }

    private static String a(String s)
    {
        Object obj;
        obj = FlippApplication.b();
        break MISSING_BLOCK_LABEL_4;
        if (obj != null && !TextUtils.isEmpty(s))
        {
            obj = ((Context) (obj)).getPackageManager();
            if (obj != null)
            {
                try
                {
                    s = ((PackageManager) (obj)).getPackageInfo(s, 0).versionName;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    public static void a(Activity activity)
    {
        if (activity != null)
        {
            if ((activity = activity.getCurrentFocus()) != null)
            {
                a(((View) (activity)));
                return;
            }
        }
    }

    public static void a(View view)
    {
        Context context;
        if (view != null)
        {
            if ((context = FlippApplication.b()) != null)
            {
                ((InputMethodManager)context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
        }
    }

    public static int b()
    {
        return b(d());
    }

    private static int b(String s)
    {
        Object obj;
        obj = FlippApplication.b();
        break MISSING_BLOCK_LABEL_4;
        if (obj != null && !TextUtils.isEmpty(s))
        {
            obj = ((Context) (obj)).getPackageManager();
            if (obj != null)
            {
                int j;
                try
                {
                    j = ((PackageManager) (obj)).getPackageInfo(s, 0).versionCode;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return -1;
                }
                return j;
            }
        }
        return -1;
    }

    public static boolean c()
    {
        Object obj = FlippApplication.b();
        if (obj == null)
        {
            return false;
        }
        obj = ((ConnectivityManager)((Context) (obj)).getSystemService("connectivity")).getActiveNetworkInfo();
        return obj != null && ((NetworkInfo) (obj)).isConnected();
    }

    private static String d()
    {
        Context context = FlippApplication.b();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getPackageName();
        }
    }

}
