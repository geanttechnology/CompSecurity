// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.amazon.mShop.ActivityTerminationReceiver;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.control.wishlist.WishListManageController;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNOItemAdapter;
import com.amazon.mShop.mobileads.AdsHelper;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.ui.DrawableFactory;
import com.amazon.retailsearch.android.api.init.RetailSearchInitializer;

// Referenced classes of package com.amazon.mShop.util:
//            Util, BadgeUtils, LocaleUtils

public class AppUtils
{

    private static Intent sLaunchIntent = null;

    public AppUtils()
    {
    }

    public static void clearUserCoinBalance()
    {
        GNODrawer.getGNOItemAdapter().setAppstoreCoinsCount("DISABLED");
    }

    public static void exitApp()
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        resetStatus();
        ActivityTerminationReceiver.sendTerminationBroadcast(context);
    }

    public static boolean isAppInstalled(Context context, String s)
    {
        if (Util.isEmpty(s))
        {
            Log.e("Amazon.AppUtils", "package name is empty.");
        } else
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isApplicationForeground()
    {
        return AmazonActivity.getTopMostBaseActivity() != null;
    }

    public static void launchApp(Context context)
    {
        launchApp(context, true);
    }

    public static void launchApp(Context context, boolean flag)
    {
        if (sLaunchIntent != null)
        {
            context.startActivity(sLaunchIntent);
            sLaunchIntent = null;
        } else
        {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent != null)
            {
                intent.setFlags(0x10000000);
                intent.addFlags(0x200000);
                intent.setAction("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(null);
                intent.putExtra("INTENT_EXTRA_STARTED_NO_NEED_COUNT_APPSTART", flag);
                context.startActivity(intent);
                return;
            }
        }
    }

    public static void resetStatus()
    {
        AdsHelper.resetIfNecessary(AndroidPlatform.getInstance().getApplicationContext());
        User.removeUserListener(HomeController.getInstance());
        User.removeUserListener(CartController.getInstance());
        User.clearUser();
        HomeController.setInstance(null);
        CartController.setInstance(null);
        WishListManageController.setInstance(null);
        AndroidPlatform.getInstance().resetApplicationId();
        Features.getInstance().resetStatus();
        BadgeUtils.clearCachedBadge();
        DrawableFactory.getInstance().resetDefaultImage();
        PushNotificationManager.clearInstance();
        CookieSyncManager.getInstance().stopSync();
        CookieSyncManager.getInstance().startSync();
        RetailSearchInitializer.getInstance().reset(AppLocale.getInstance().getCurrentLocale());
        GNODrawer.reset();
    }

    public static void restartApp()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

            public void run()
            {
                AppUtils.restartApp(null);
            }

        });
    }

    public static void restartApp(Intent intent)
    {
        sLaunchIntent = intent;
        intent = AndroidPlatform.getInstance().getApplicationContext();
        resetStatus();
        ActivityTerminationReceiver.sendTerminationBroadcast(intent);
        AmazonActivity.setNeedRestart(true);
    }

    public static void sendRequestCoinBalanceBroadcast(Context context)
    {
        if (User.isLoggedIn())
        {
            context.sendBroadcast(new Intent("com.amazon.mShop.appstore.coin.requestCoin"));
        }
    }

    public static void showSwitchLocaleDialog(AmazonActivity amazonactivity, String s, String s1, Intent intent)
    {
        s = new android.content.DialogInterface.OnClickListener(amazonactivity, s, intent) {

            final AmazonActivity val$activity;
            final Intent val$launchIntent;
            final String val$loacleName;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                switch (i)
                {
                default:
                    return;

                case -1: 
                    activity.finish();
                    return;

                case -2: 
                    LocaleUtils.changeLocale(loacleName, activity, launchIntent);
                    return;
                }
            }

            
            {
                activity = amazonactivity;
                loacleName = s;
                launchIntent = intent;
                super();
            }
        };
        intent = new com.amazon.mShop.AmazonAlertDialog.Builder(amazonactivity);
        intent.setTitle(amazonactivity.getString(com.amazon.mShop.android.lib.R.string.public_url_switch_locale_title));
        intent.setMessage(s1);
        intent.setNegativeButton(com.amazon.mShop.android.lib.R.string.yes, s);
        intent.setPositiveButton(com.amazon.mShop.android.lib.R.string.no, s);
        amazonactivity = intent.create();
        amazonactivity.setCancelable(false);
        amazonactivity.setCanceledOnTouchOutside(false);
        amazonactivity.show();
    }

}
