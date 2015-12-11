// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.FacebookSdk;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.controllers.ShowroomsController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.triggers.PMTriggerManager;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.PoshLearnManager;
import io.branch.referral.Branch;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.application:
//            PMApplicationSession, AppInfo

public class PMApplication extends Application
    implements PMNotificationListener
{

    public static int PARTY_START_NOTIFICATION_ID = 0;
    public static int PM_PUSH_NOTIFICATION_ID = 1;
    private static boolean appRestarting = false;
    private static PMApplication context;
    public static Feature kochavaTracker = null;
    public static MobileAppTracker mobileAppTracker = null;
    public MainActivity motherActivity;
    public PMActivity topActivity;

    public PMApplication()
    {
        context = this;
    }

    public static String getAppKey()
    {
        Signature asignature[];
        asignature = getApplicationObject().getActivity().getPackageManager().getPackageInfo("com.poshmark.app", 64).signatures;
        if (asignature.length >= 0)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        Object obj = asignature[0];
        MessageDigest messagedigest = MessageDigest.getInstance("SHA");
        messagedigest.update(((Signature) (obj)).toByteArray());
        obj = Base64.encodeToString(messagedigest.digest(), 0);
        Log.d("KeyHash:", ((String) (obj)));
        return ((String) (obj));
        Object obj1;
        obj1;
_L2:
        return null;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static PMApplication getApplicationObject()
    {
        return context;
    }

    public static Context getContext()
    {
        return context;
    }

    public static MobileAppTracker getHasOffersObject()
    {
        return mobileAppTracker;
    }

    public static Feature getKochavaTracker()
    {
        return kochavaTracker;
    }

    private void sendAdvertiserIdToTrackers()
    {
        (new Thread(new Runnable() {

            final PMApplication this$0;

            public void run()
            {
                try
                {
                    com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                    PMApplication.mobileAppTracker.setGoogleAdvertisingId(info.getId(), info.isLimitAdTrackingEnabled());
                    return;
                }
                catch (IOException ioexception)
                {
                    PMApplication.mobileAppTracker.setAndroidId(android.provider.Settings.Secure.getString(getContentResolver(), "android_id"));
                    return;
                }
                catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
                {
                    PMApplication.mobileAppTracker.setAndroidId(android.provider.Settings.Secure.getString(getContentResolver(), "android_id"));
                    return;
                }
                catch (GooglePlayServicesRepairableException googleplayservicesrepairableexception)
                {
                    PMApplication.mobileAppTracker.setAndroidId(android.provider.Settings.Secure.getString(getContentResolver(), "android_id"));
                    return;
                }
                catch (NullPointerException nullpointerexception)
                {
                    PMApplication.mobileAppTracker.setAndroidId(android.provider.Settings.Secure.getString(getContentResolver(), "android_id"));
                }
            }

            
            {
                this$0 = PMApplication.this;
                super();
            }
        })).start();
    }

    private void setupDevIP()
    {
        if (EnvConfig.ENV == Env.DEV)
        {
            String s = PMApplicationSession.GetPMSession().getDevIP();
            if (s != null)
            {
                EnvConfig.setupDevIP(s);
            }
        }
    }

    public MainActivity getActivity()
    {
        return motherActivity;
    }

    public PMActivity getTopActivity()
    {
        return topActivity;
    }

    public void handleNotification(Intent intent)
    {
        if (!intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE")) goto _L2; else goto _L1
_L1:
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            setCookieInJar();
            intent = new HashMap();
            intent.put("user_id", PMApplicationSession.GetPMSession().getUserId());
            getKochavaTracker().linkIdentity(intent);
            Branch.getInstance().setIdentity(PMApplicationSession.GetPMSession().getUserId());
        }
_L4:
        return;
_L2:
        if (!intent.getAction().equals("com.poshmark.intents.APP_STARTED"))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!PMApplicationSession.GetPMSession().isLoggedIn()) goto _L4; else goto _L3
_L3:
        setCookieInJar();
        return;
        if (!intent.getAction().equals("com.poshmark.intents.INITIATE_LOGOUT") || !PMApplicationSession.GetPMSession().isLoggedIn()) goto _L4; else goto _L5
_L5:
        PMApplicationSession.GetPMSession().logout();
        Branch.getInstance().logout();
        return;
    }

    public void initGlobalControllers()
    {
        UserStateSummaryController.getGlobalInteractionsController();
        if (PoshLearnManager.getInstance().shouldShowPoshLearnScreen())
        {
            GlobalPartiesController.getGlobalPartiesController().disablePartyAlerts();
        } else
        {
            GlobalPartiesController.getGlobalPartiesController().enablePartyAlerts();
        }
        ShowroomsController.getGlobalShowroomsController();
        GlobalDbController.getGlobalDbController();
        PMTriggerManager.getGlobalTriggerManager();
    }

    public void onCreate()
    {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext(), FbHelper.CALLING_CODE_BASEMENT);
        FbHelper.getInstance();
        setupDevIP();
        initGlobalControllers();
        setupImageDownloader();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.APP_STARTED", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.INITIATE_LOGOUT", this);
        if (EnvConfig.ENV != Env.DEVTEAM && EnvConfig.ENV != Env.DEV)
        {
            MobileAppTracker.init(this, "9056", "026e1400a6bc5a185b79446a9d6620e8");
            mobileAppTracker = MobileAppTracker.getInstance();
            if (mobileAppTracker != null)
            {
                if (EnvConfig.ENV == Env.STAGE)
                {
                    mobileAppTracker.setDebugMode(true);
                }
                sendAdvertiserIdToTrackers();
            }
        }
        kochavaTracker = new Feature(this, "koposhmarkandroid3476533b1c455ecb8");
        if (EnvConfig.ENV == Env.STAGE || EnvConfig.ENV == Env.DEV)
        {
            Feature.enableDebug(true);
        }
        Branch.getAutoInstance(this);
    }

    public void setActivity(MainActivity mainactivity)
    {
        motherActivity = mainactivity;
    }

    public void setCookieInJar()
    {
        String s = Uri.parse("https://www.poshmark.com").getEncodedAuthority();
        CookieSyncManager cookiesyncmanager = CookieSyncManager.createInstance(this);
        CookieManager cookiemanager = CookieManager.getInstance();
        cookiemanager.removeAllCookie();
        String s1 = (new StringBuilder()).append("access_token=").append(PMApplicationSession.GetPMSession().getAccessToken()).toString();
        String s2 = (new StringBuilder()).append("app_version=").append(AppInfo.getInstance().versionName).toString();
        String s3 = (new StringBuilder()).append("display_handle =").append(PMApplicationSession.GetPMSession().getDisplayHandle()).toString();
        String s4 = (new StringBuilder()).append("fb_user_id=").append(PMApplicationSession.GetPMSession().getFacebookUserId()).toString();
        String s5 = (new StringBuilder()).append("pm_user_id=").append(PMApplicationSession.GetPMSession().getUserId()).toString();
        cookiemanager.setCookie(s, s1);
        cookiemanager.setCookie(s, "PM_application=android");
        cookiemanager.setCookie(s, s2);
        cookiemanager.setCookie(s, s3);
        cookiemanager.setCookie(s, s4);
        cookiemanager.setCookie(s, s5);
        cookiesyncmanager.sync();
    }

    public void setTopActivity(PMActivity pmactivity)
    {
        topActivity = pmactivity;
    }

    public void setupImageDownloader()
    {
        Object obj = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheOnDisc().build();
        obj = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(context)).defaultDisplayImageOptions(((com.nostra13.universalimageloader.core.DisplayImageOptions) (obj))).build();
        ImageLoader.getInstance().init(((com.nostra13.universalimageloader.core.ImageLoaderConfiguration) (obj)));
    }

}
