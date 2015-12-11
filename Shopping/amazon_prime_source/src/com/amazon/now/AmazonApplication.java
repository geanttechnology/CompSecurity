// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.identity.auth.device.api.MAPInit;
import com.amazon.mobile.mash.MASHApplicationFactory;
import com.amazon.now.account.SSO;
import com.amazon.now.account.User;
import com.amazon.now.cookie.NowAppContextCookie;
import com.amazon.now.crash.CrashDetailsCollector;
import com.amazon.now.location.LocaleManager;
import com.amazon.now.map.MapController;
import com.amazon.now.mash.NowMASHApplication;
import com.amazon.now.mobileads.AdsHelper;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.voice.VoiceSearchInitializer;
import com.amazon.now.web.WebkitCookieManagerProxy;
import java.net.CookieHandler;
import java.net.CookiePolicy;

// Referenced classes of package com.amazon.now:
//            NowOAuthHelper, DCMInitializer, AppExtensionsInitializer

public class AmazonApplication extends Application
{

    public AmazonApplication()
    {
    }

    private void setupCookieSync()
    {
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            CookieSyncManager.createInstance(this);
        }
        try
        {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        catch (Exception exception)
        {
            Log.e("AmazonApplication", "Android cannot locate the System Webview. This usually occurs after the System WebView is updated for a short time.", exception);
        }
        CookieHandler.setDefault(new WebkitCookieManagerProxy(null, CookiePolicy.ACCEPT_ALL));
    }

    private void setupCrashManager()
    {
        CrashDetectionHelper.setUpCrashDetection("A1MPSLFC7L5AFK", AndroidPlatform.getInstance().getDeviceId(), new NowOAuthHelper(), AndroidMetricsFactoryImpl.getInstance(this), this);
        if (CrashDetectionHelper.getInstance() != null)
        {
            CrashDetectionHelper.getInstance().appendCrashDetailsCollector(new CrashDetailsCollector());
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        LocaleManager.getInstance().enforceCustomLocale();
    }

    public void onCreate()
    {
        super.onCreate();
        AndroidPlatform.setUp(this, "Now");
        setupCookieSync();
        MapController.getInstance().preload();
        DCMInitializer.initialize(this);
        MAPInit.getInstance(this).initialize();
        DCMInitializer.provideOAuthHelper(this);
        setupCrashManager();
        LocaleManager.getInstance().enforceCustomLocale();
        MASHApplicationFactory.setInstance(new NowMASHApplication());
        NowAppContextCookie.init();
        VoiceSearchInitializer.initialize(this);
        AppExtensionsInitializer.initializeSearch(this);
        ImageUtil.setupBitmapCache();
        String s = SSO.getAccount();
        if (s != null && !User.isSignedIn())
        {
            SSO.notifyUserSignedIn(s, null);
        }
        AdsHelper.setup(this);
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        ImageUtil.clearCache();
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        if (i >= 10)
        {
            MapController.trimMemory();
        }
    }
}
