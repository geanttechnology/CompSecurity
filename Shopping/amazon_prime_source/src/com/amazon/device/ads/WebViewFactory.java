// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsInfoStore, MobileAdsLoggerFactory, DebugProperties, AndroidBuildInfo, 
//            AndroidTargetUtils, RegistrationInfo, DeviceInfo, MobileAdsLogger

class WebViewFactory
{
    static class MobileAdsCookieManager
    {

        private boolean cookieSyncManagerCreated;

        public void createCookieSyncManager(Context context)
        {
            if (!cookieSyncManagerCreated)
            {
                CookieSyncManager.createInstance(context);
                cookieSyncManagerCreated = true;
            }
        }

        public boolean isCookieSyncManagerCreated()
        {
            return cookieSyncManagerCreated;
        }

        public void setCookie(String s, String s1)
        {
            CookieManager.getInstance().setCookie(s, s1);
        }

        public void startSync()
        {
            CookieSyncManager.getInstance().startSync();
        }

        public void stopSync()
        {
            CookieSyncManager.getInstance().stopSync();
        }

        MobileAdsCookieManager()
        {
            cookieSyncManagerCreated = false;
        }
    }

    static class WebViewConstructor
    {

        public WebView createWebView(Context context)
        {
            return new WebView(context);
        }

        WebViewConstructor()
        {
        }
    }

    static class WebViewDatabaseFactory
    {

        public WebViewDatabase getWebViewDatabase(Context context)
        {
            return WebViewDatabase.getInstance(context);
        }

        WebViewDatabaseFactory()
        {
        }
    }


    private static WebViewFactory instance = new WebViewFactory();
    private final AndroidBuildInfo buildInfo;
    private final MobileAdsCookieManager cookieManager;
    private final DebugProperties debugProperties;
    private final MobileAdsInfoStore infoStore;
    private boolean isWebViewCheckedAndOk;
    private final MobileAdsLoggerFactory loggerFactory;
    private final WebViewConstructor webViewConstructor;
    private final WebViewDatabaseFactory webViewDatabaseFactory;

    protected WebViewFactory()
    {
        this(MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), DebugProperties.getInstance(), new MobileAdsCookieManager(), new AndroidBuildInfo(), new WebViewDatabaseFactory(), new WebViewConstructor());
    }

    WebViewFactory(MobileAdsInfoStore mobileadsinfostore, MobileAdsLoggerFactory mobileadsloggerfactory, DebugProperties debugproperties, MobileAdsCookieManager mobileadscookiemanager, AndroidBuildInfo androidbuildinfo, WebViewDatabaseFactory webviewdatabasefactory, WebViewConstructor webviewconstructor)
    {
        isWebViewCheckedAndOk = false;
        infoStore = mobileadsinfostore;
        loggerFactory = mobileadsloggerfactory;
        debugProperties = debugproperties;
        cookieManager = mobileadscookiemanager;
        buildInfo = androidbuildinfo;
        webViewDatabaseFactory = webviewdatabasefactory;
        webViewConstructor = webviewconstructor;
        shouldDebugWebViews();
    }

    private static boolean doesExceptionContainLockedDatabaseMessage(Exception exception)
    {
        if (exception == null || exception.getMessage() == null)
        {
            return false;
        } else
        {
            return exception.getMessage().contains("database is locked");
        }
    }

    public static final WebViewFactory getInstance()
    {
        return instance;
    }

    private boolean isDatabaseLocked(SQLiteException sqliteexception)
    {
        if (AndroidTargetUtils.isAtLeastAndroidAPI(buildInfo, 11))
        {
            return AndroidTargetUtils.isInstanceOfSQLiteDatabaseLockedException(sqliteexception);
        } else
        {
            return doesExceptionContainLockedDatabaseMessage(sqliteexception);
        }
    }

    private void shouldDebugWebViews()
    {
        if (debugProperties.getDebugPropertyAsBoolean("debug.webViews", Boolean.valueOf(false)).booleanValue())
        {
            AndroidTargetUtils.enableWebViewDebugging(true);
        }
    }

    private void updateAdIdCookie()
    {
        if (cookieManager.isCookieSyncManagerCreated())
        {
            String s1 = infoStore.getRegistrationInfo().getAdId();
            String s = s1;
            if (s1 == null)
            {
                s = "";
            }
            cookieManager.setCookie("http://amazon-adsystem.com", (new StringBuilder()).append("ad-id=").append(s).append("; Domain=.amazon-adsystem.com").toString());
        }
    }

    public WebView createWebView(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        WebView webview;
        webview = webViewConstructor.createWebView(context);
        infoStore.getDeviceInfo().setUserAgentString(webview.getSettings().getUserAgentString());
        webview.getSettings().setUserAgentString(infoStore.getDeviceInfo().getUserAgentString());
        cookieManager.createCookieSyncManager(context);
        updateAdIdCookie();
        this;
        JVM INSTR monitorexit ;
        return webview;
        context;
        throw context;
    }

    public boolean isWebViewOk(Context context)
    {
        boolean flag = false;
        if (!AndroidTargetUtils.isAtOrBelowAndroidAPI(buildInfo, 8) || isWebViewCheckedAndOk) goto _L2; else goto _L1
_L1:
        if (webViewDatabaseFactory.getWebViewDatabase(context) != null) goto _L4; else goto _L3
_L3:
        return flag;
_L4:
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context != null)
        {
            context.close();
        }
        isWebViewCheckedAndOk = true;
_L2:
        return true;
        context;
        flag = isDatabaseLocked(context);
        if (true) goto _L3; else goto _L5
_L5:
        throw new NullPointerException();
        context;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw context;
        }
    }

    public boolean setJavaScriptEnabledForWebView(boolean flag, WebView webview, String s)
    {
        try
        {
            webview.getSettings().setJavaScriptEnabled(flag);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            loggerFactory.createMobileAdsLogger(s).w("Could not set JavaScriptEnabled because a NullPointerException was encountered.");
            return false;
        }
        return true;
    }

}
