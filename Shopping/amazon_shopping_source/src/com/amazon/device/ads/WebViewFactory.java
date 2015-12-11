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
//            AndroidTargetUtils, Log, InternalAdRegistration, IInternalAdRegistration, 
//            RegistrationInfo

class WebViewFactory
{

    private static WebViewFactory instance = new WebViewFactory();
    private static boolean isWebViewCheckedAndOk = false;
    private boolean cookieSyncManagerCreated;

    protected WebViewFactory()
    {
        cookieSyncManagerCreated = false;
    }

    protected static boolean doesExceptionContainLockedDatabaseMessage(Exception exception)
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

    protected static boolean isDatabaseLocked(SQLiteException sqliteexception)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return AndroidTargetUtils.isInstanceOfSQLiteDatabaseLockedException(sqliteexception);
        } else
        {
            return doesExceptionContainLockedDatabaseMessage(sqliteexception);
        }
    }

    public static boolean isWebViewOk(Context context)
    {
        boolean flag = false;
        if (android.os.Build.VERSION.SDK_INT > 8 || isWebViewCheckedAndOk) goto _L2; else goto _L1
_L1:
        if (WebViewDatabase.getInstance(context) != null) goto _L4; else goto _L3
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

    protected static void setInstance(WebViewFactory webviewfactory)
    {
        instance = webviewfactory;
    }

    public static final boolean setJavaScriptEnabledForWebView(boolean flag, WebView webview, String s)
    {
        try
        {
            webview.getSettings().setJavaScriptEnabled(flag);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.w(s, "Could not set JavaScriptEnabled because a NullPointerException was encountered.");
            return false;
        }
        return true;
    }

    private void updateAdIdCookie()
    {
        if (cookieSyncManagerCreated)
        {
            String s1 = InternalAdRegistration.getInstance().getRegistrationInfo().getAdId();
            String s = s1;
            if (s1 == null)
            {
                s = "";
            }
            setCookie("http://amazon-adsystem.com", (new StringBuilder()).append("ad-id=").append(s).append("; Domain=.amazon-adsystem.com").toString());
        }
    }

    public WebView createWebView(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        WebView webview;
        webview = new WebView(context);
        if (!cookieSyncManagerCreated)
        {
            CookieSyncManager.createInstance(context);
            cookieSyncManagerCreated = true;
        }
        updateAdIdCookie();
        this;
        JVM INSTR monitorexit ;
        return webview;
        context;
        throw context;
    }

    protected void setCookie(String s, String s1)
    {
        CookieManager.getInstance().setCookie(s, s1);
    }

}
