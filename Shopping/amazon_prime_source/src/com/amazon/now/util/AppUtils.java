// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.amazon.now.home.HomeActivity;
import com.amazon.now.home.WelcomeScreen;
import com.amazon.now.location.Location;
import com.amazon.now.mash.NavManager;
import com.amazon.now.platform.AndroidPlatform;
import com.google.common.net.InternetDomainName;

// Referenced classes of package com.amazon.now.util:
//            DataStore

public class AppUtils
{

    private static final String TAG = com/amazon/now/util/AppUtils.getSimpleName();

    public AppUtils()
    {
    }

    public static boolean getConfigBoolean(int i)
    {
        boolean flag;
        try
        {
            flag = AndroidPlatform.getInstance().getApplicationContext().getResources().getBoolean(i);
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            return false;
        }
        return flag;
    }

    public static DisplayMetrics getDeviceDisplayMetrics(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

    public static float getDeviceLogicalDPI(Context context)
    {
        return getDeviceDisplayMetrics(context).density * 160F;
    }

    public static Point getDisplaySize(Context context)
    {
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        context.getSize(point);
        return point;
    }

    public static NetworkInfo getNetworkInfo(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null)
        {
            return context.getActiveNetworkInfo();
        } else
        {
            return null;
        }
    }

    public static int getPxFromDp(Context context, int i)
    {
        float f = context.getResources().getDisplayMetrics().density;
        return (int)((float)i * f + 0.5F);
    }

    public static String getServiceDomain()
    {
        String s = Uri.parse(getServiceUrl(AndroidPlatform.getInstance().getApplicationContext())).getHost();
        if (s != null)
        {
            return (new StringBuilder()).append(".").append(InternetDomainName.from(s).topPrivateDomain().toString()).toString();
        } else
        {
            return (new StringBuilder()).append(".").append(Location.getDomain()).toString();
        }
    }

    public static String getServiceUrl(Context context)
    {
        String s1 = context.getString(0x7f07008b);
        String s = s1;
        if (isAppDebuggable(context))
        {
            s = s1;
            if (isDevo())
            {
                s = context.getString(0x7f0700c4);
            }
            if ("PROD".equals(DataStore.getString("service_url_state_key")))
            {
                s = context.getString(0x7f07008b);
            } else
            {
                if ("GAMMA".equals(DataStore.getString("service_url_state_key")))
                {
                    return context.getString(0x7f07007e);
                }
                if ("OVERRIDE".equals(DataStore.getString("service_url_state_key")))
                {
                    return DataStore.getString("service_url_key");
                }
            }
        }
        return s;
    }

    public static int getVersionCode(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, "Package name is unknown");
            return -1;
        }
        return i;
    }

    public static String getVersionName(Context context)
    {
        Object obj = context.getPackageManager();
        int i;
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0).versionName;
            i = ((String) (obj)).indexOf('_');
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, "Package name is unknown");
            return null;
        }
        context = ((Context) (obj));
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        context = ((String) (obj)).substring(0, i);
        return context;
    }

    public static void goHome(Context context)
    {
        goHome(context, null);
    }

    public static void goHome(Context context, String s)
    {
        goHome(context, s, true);
    }

    public static void goHome(Context context, String s, boolean flag)
    {
        Intent intent = new Intent(context, com/amazon/now/home/HomeActivity);
        if (!TextUtils.isEmpty(s))
        {
            intent.putExtra("intentUrlKey", s);
        }
        if (flag)
        {
            NavManager.modifyIntentForNewStack(intent);
        }
        context.startActivity(intent);
    }

    public static boolean hasNetworkConnection(Context context)
    {
        boolean flag = false;
        context = getNetworkInfo(context);
        if (context != null)
        {
            flag = context.isConnected();
        }
        return flag;
    }

    public static boolean isAmazonDevice()
    {
        return "Amazon".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isAppDebuggable(Context context)
    {
        if (context != null)
        {
            String s = context.getPackageName();
            context = context.getPackageManager();
            int i;
            try
            {
                i = context.getPackageInfo(s, 0).applicationInfo.flags;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e(TAG, (new StringBuilder()).append(s).append(" is unknown.").toString());
                return false;
            }
            if ((i & 2) != 0)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isDefined(String s)
    {
        return !TextUtils.isEmpty(s) && !"undefined".equalsIgnoreCase(s) && !"null".equalsIgnoreCase(s);
    }

    public static boolean isDevo()
    {
        return AndroidPlatform.getInstance().getApplicationContext().getResources().getBoolean(0x7f090007);
    }

    public static void resetActivityStack(Activity activity)
    {
        resetActivityStack(activity, null);
    }

    public static void resetActivityStack(Activity activity, Uri uri)
    {
        Intent intent = new Intent(activity, com/amazon/now/home/WelcomeScreen);
        intent.addFlags(0x4000000);
        intent.addFlags(0x10000000);
        intent.addFlags(32768);
        if (uri != null)
        {
            intent.setData(uri);
        }
        activity.startActivity(intent);
        activity.finish();
    }

}
