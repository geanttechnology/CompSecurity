// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.da;
import com.applovin.nativeAds.AppLovinNativeAd;
import java.io.File;

// Referenced classes of package com.applovin.sdk:
//            AppLovinAdType, AppLovinSdkSettings

public class AppLovinSdkUtils
{

    public AppLovinSdkUtils()
    {
    }

    private static boolean a(Context context)
    {
        boolean flag1 = false;
        context = e(context);
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (context.getBoolean("applovin.sdk.verbose_logging", false))
            {
                flag = true;
            }
        }
        return flag;
    }

    private static long b(Context context)
    {
        context = e(context);
        if (context != null)
        {
            return (long)context.getInt("applovin.sdk.ad_refresh_seconds", -100);
        } else
        {
            return -100L;
        }
    }

    private static String c(Context context)
    {
        context = e(context);
        if (context != null)
        {
            context = context.getString("applovin.sdk.auto_preload_ad_sizes");
            if (context != null)
            {
                return context;
            }
        }
        return "BANNER,INTER";
    }

    private static String d(Context context)
    {
        context = e(context);
        if (context != null)
        {
            context = context.getString("applovin.sdk.auto_preload_ad_types");
            if (context != null)
            {
                return context;
            }
        }
        return (new StringBuilder()).append(AppLovinAdType.REGULAR.getLabel()).append(",").append(AppLovinAdType.INCENTIVIZED.getLabel()).toString();
    }

    public static int dpToPx(Context context, int i)
    {
        return (int)TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    private static Bundle e(Context context)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("AppLovinSdk", "Unable to retrieve application metadata", context);
            return null;
        }
        return context;
    }

    public static boolean isValidString(String s)
    {
        return s != null && s.length() > 1;
    }

    public static void launchNativeAdClickUrl(Context context, AppLovinNativeAd applovinnativead)
    {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(applovinnativead.getClickUrl())));
    }

    public static void recycleImageView(ImageView imageview)
    {
        if (imageview != null)
        {
            imageview = imageview.getDrawable();
            if (imageview != null && (imageview instanceof BitmapDrawable))
            {
                ((BitmapDrawable)imageview).getBitmap().recycle();
            }
        }
    }

    public static String retrieveSdkKey(Context context)
    {
        context = e(context);
        if (context != null)
        {
            context = context.getString("applovin.sdk.key");
            if (context != null)
            {
                return context;
            } else
            {
                return "";
            }
        } else
        {
            return null;
        }
    }

    public static AppLovinSdkSettings retrieveUserSettings(Context context)
    {
        AppLovinSdkSettings applovinsdksettings = new AppLovinSdkSettings();
        applovinsdksettings.setVerboseLogging(a(context));
        applovinsdksettings.setBannerAdRefreshSeconds(b(context));
        applovinsdksettings.setAutoPreloadSizes(c(context));
        applovinsdksettings.setAutoPreloadTypes(d(context));
        return applovinsdksettings;
    }

    public static void safePopulateImageView(Context context, ImageView imageview, int i, int j)
    {
        recycleImageView(imageview);
        context = da.a(context, i, j);
        if (context != null)
        {
            imageview.setImageBitmap(context);
        }
    }

    public static void safePopulateImageView(ImageView imageview, Uri uri, int i)
    {
        recycleImageView(imageview);
        uri = da.a(new File(uri.getPath()), i);
        if (uri != null)
        {
            imageview.setImageBitmap(uri);
        }
    }
}
