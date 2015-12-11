// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.details.AmazonAppStoreProxy;
import com.amazon.mShop.platform.AndroidPlatform;

public class ThirdPartyActivityUtils
{

    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    public ThirdPartyActivityUtils()
    {
    }

    static String buildGooglePlayPageUrl()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        return String.format(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_url), new Object[] {
            context.getPackageName()
        });
    }

    static boolean checkAmazonAppstorePackage()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        Intent intent = getAppStoreIntent();
        return context.getPackageManager().resolveActivity(intent, 0x10000) != null;
    }

    static boolean checkGooglePackage()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        Intent intent = getGooglePlayIntent();
        intent.setClassName(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_package), context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_activity));
        return context.getPackageManager().resolveActivity(intent, 0x10000) != null;
    }

    static Intent getAmazonAppHostPageIntent()
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AndroidPlatform.getInstance().getApplicationContext().getString(com.amazon.mShop.android.lib.R.string.upgrade_amazon_app_host_url)));
        intent.setFlags(0x10000000);
        return intent;
    }

    static Intent getAppStoreIntent()
    {
        Object obj = AndroidPlatform.getInstance().getApplicationContext();
        obj = AmazonAppStoreProxy.getInstance().getIntentForStart(((Context) (obj)), null, ((Context) (obj)).getString(com.amazon.mShop.android.lib.R.string.upgrade_amazon_appstore_asin));
        ((Intent) (obj)).setFlags(0x10000000);
        return ((Intent) (obj));
    }

    public static String getFaceBookAttributionId(Context context)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        obj = null;
        context = context.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[] {
            "aid"
        }, null, null, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = context;
        obj1 = context;
        boolean flag = context.moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (context != null)
        {
            context.close();
        }
        return null;
        obj = context;
        obj1 = context;
        String s = context.getString(context.getColumnIndex("aid"));
        obj = s;
        obj1 = obj;
        if (context != null)
        {
            context.close();
            obj1 = obj;
        }
_L2:
        return ((String) (obj1));
        context;
        obj1 = obj;
        Log.i("StartupActivity", "Can not read attribution id from com.facebook.katana.provider.AttributionIdProvider");
        obj1 = obj2;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            obj1 = obj2;
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw context;
    }

    static Intent getGeneralMarketIntent()
    {
        Object obj = AndroidPlatform.getInstance().getApplicationContext();
        obj = new Intent("android.intent.action.VIEW", Uri.parse(String.format(((Context) (obj)).getString(com.amazon.mShop.android.lib.R.string.upgrade_general_market_url), new Object[] {
            ((Context) (obj)).getPackageName()
        })));
        ((Intent) (obj)).setFlags(0x10000000);
        return ((Intent) (obj));
    }

    static Intent getGooglePlayIntent()
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(buildGooglePlayPageUrl()));
        intent.setFlags(0x10000000);
        return intent;
    }

    public static void installAmazonAppStore()
    {
        try
        {
            Context context = AndroidPlatform.getInstance().getApplicationContext();
            Intent intent = AmazonAppStoreProxy.getInstance().getIntentForInstall(context);
            intent.setFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public static boolean isCnPackage()
    {
        return AndroidPlatform.getInstance().getApplicationContext().getPackageName().startsWith("cn");
    }

    static void openAmazonAppHostPage()
    {
        try
        {
            Intent intent = getAmazonAppHostPageIntent();
            AndroidPlatform.getInstance().getApplicationContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    static void openGeneralMarketApp()
    {
        try
        {
            Intent intent = getGeneralMarketIntent();
            AndroidPlatform.getInstance().getApplicationContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            openGooglePlayPage();
        }
    }

    static void openGooglePlayPage()
    {
        try
        {
            Intent intent = getGooglePlayIntent();
            AndroidPlatform.getInstance().getApplicationContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    static void startAmazonAppStore()
    {
        try
        {
            Intent intent = getAppStoreIntent();
            AndroidPlatform.getInstance().getApplicationContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            installAmazonAppStore();
        }
    }

    static void startGooglePlay()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        try
        {
            Intent intent = getGeneralMarketIntent();
            intent.setClassName(context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_package), context.getString(com.amazon.mShop.android.lib.R.string.upgrade_google_play_activity));
            context.startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception) { }
        if (isCnPackage())
        {
            openAmazonAppHostPage();
            return;
        } else
        {
            openGeneralMarketApp();
            return;
        }
    }

}
