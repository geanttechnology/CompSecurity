// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonCacheManager;
import com.amazon.android.webkit.AmazonCookieManager;
import com.amazon.android.webkit.AmazonCookieSyncManager;
import com.amazon.android.webkit.AmazonGeolocationPermissions;
import com.amazon.android.webkit.AmazonHistoryManager;
import com.amazon.android.webkit.AmazonMediaDeviceSettings;
import com.amazon.android.webkit.AmazonPluginManager;
import com.amazon.android.webkit.AmazonUrlRequest;
import com.amazon.android.webkit.AmazonUrlRequestHandler;
import com.amazon.android.webkit.AmazonWebIconDatabase;
import com.amazon.android.webkit.AmazonWebKitCapabilities;
import com.amazon.android.webkit.AmazonWebKitErrorListener;
import com.amazon.android.webkit.AmazonWebKitFactory;
import com.amazon.android.webkit.AmazonWebKitUpdateHandler;
import com.amazon.android.webkit.AmazonWebStorage;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.android.webkit.AmazonWebViewDatabase;
import com.amazon.android.webkit.AmazonWebViewDelegate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidCacheManager, AndroidCookieManager, AndroidCookieSyncManager, AndroidGeolocationPermissions, 
//            AndroidWebIconDatabase, AndroidWebKitCapabilities, AndroidWebStorage, AndroidWebKitUpdateHandler, 
//            ClientApiLevel, AndroidWebViewDelegate, AndroidPluginManager, AndroidWebViewDatabase

public class AndroidWebKitFactory extends AmazonWebKitFactory
{

    private final AmazonCacheManager cacheManager = new AndroidCacheManager();
    private final AmazonCookieManager cookieManager = new AndroidCookieManager();
    private final AmazonCookieSyncManager cookieSyncManager = new AndroidCookieSyncManager();
    private final AmazonGeolocationPermissions geolocationPermission = new AndroidGeolocationPermissions();
    private final AmazonHistoryManager historyManager = new AmazonHistoryManager() {

        final AndroidWebKitFactory this$0;

            
            {
                this$0 = AndroidWebKitFactory.this;
                super();
            }
    };
    private boolean initialized;
    private final AmazonWebKitUpdateHandler updateHandler = new AndroidWebKitUpdateHandler();
    private final AtomicReference urlRequestHandler = new AtomicReference();
    private boolean warmedUp;
    private final AmazonWebIconDatabase webIconDatabase = new AndroidWebIconDatabase();
    private final AmazonWebKitCapabilities webKitCapabilities = new AndroidWebKitCapabilities();
    private final AmazonWebStorage webStorage = new AndroidWebStorage();

    public AndroidWebKitFactory()
    {
        warmedUp = false;
        initialized = false;
        ClientApiLevel.initialize();
    }

    public static int getMaxApiLevelSupportedStatic()
    {
        return 4;
    }

    public void clearAllVisitedLinkHistory()
    {
    }

    public void clearFormData(Context context)
    {
        Object obj = null;
        context = new WebView(context);
        context.clearFormData();
        if (context != null)
        {
            context.destroy();
        }
        return;
        Exception exception;
        exception;
        context = obj;
_L2:
        if (context != null)
        {
            context.destroy();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public AmazonWebViewDelegate createWebViewDelegate(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle)
    {
        if (flag)
        {
            Log.w(com/amazon/android/webkit/android/AndroidWebKitFactory.getName(), "Ignoring unsupported isPrivate=true");
        }
        return new AndroidWebViewDelegate(amazonwebview, i, urlRequestHandler);
    }

    public AmazonWebViewDelegate createWebViewDelegate(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle, int j)
    {
        return createWebViewDelegate(amazonwebview, i, flag, bundle);
    }

    public AmazonPluginManager getAmazonPluginManager(Context context)
    {
        return new AndroidPluginManager(context);
    }

    public int getApiLevel()
    {
        return ClientApiLevel.getInstance().getApiLevel();
    }

    public AmazonCacheManager getCacheManager()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonCacheManager amazoncachemanager = cacheManager;
        this;
        JVM INSTR monitorexit ;
        return amazoncachemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonCookieManager getCookieManager()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonCookieManager amazoncookiemanager = cookieManager;
        this;
        JVM INSTR monitorexit ;
        return amazoncookiemanager;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonCookieSyncManager getCookieSyncManager()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonCookieSyncManager amazoncookiesyncmanager = cookieSyncManager;
        this;
        JVM INSTR monitorexit ;
        return amazoncookiesyncmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonGeolocationPermissions getGeolocationPermissions()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonGeolocationPermissions amazongeolocationpermissions = geolocationPermission;
        this;
        JVM INSTR monitorexit ;
        return amazongeolocationpermissions;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonHistoryManager getHistoryManager()
    {
        return historyManager;
    }

    public int getMaxApiLevelSupported()
    {
        return getMaxApiLevelSupportedStatic();
    }

    public AmazonMediaDeviceSettings getMediaDeviceSettings()
    {
        this;
        JVM INSTR monitorenter ;
        throw new UnsupportedOperationException("Unsupported method");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public AmazonWebKitUpdateHandler getUpdateHandler()
    {
        return updateHandler;
    }

    public AmazonWebIconDatabase getWebIconDatabase()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonWebIconDatabase amazonwebicondatabase = webIconDatabase;
        this;
        JVM INSTR monitorexit ;
        return amazonwebicondatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonWebKitCapabilities getWebKitCapabilities()
    {
        return webKitCapabilities;
    }

    public AmazonWebStorage getWebStorage()
    {
        this;
        JVM INSTR monitorenter ;
        AmazonWebStorage amazonwebstorage = webStorage;
        this;
        JVM INSTR monitorexit ;
        return amazonwebstorage;
        Exception exception;
        exception;
        throw exception;
    }

    public AmazonWebViewDatabase getWebViewDatabase(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        context = new AndroidWebViewDatabase(context);
        this;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public void initialize(Context context)
    {
        initialize(context, null);
    }

    public void initialize(Context context, List list)
    {
        getCookieSyncManager().createInstance(context);
        getCookieManager().removeExpiredCookie();
        initialized = true;
    }

    public boolean isRenderProcess(Context context)
    {
        return false;
    }

    public String javaScriptToUrl(String s)
    {
        return (new StringBuilder()).append("javascript:").append(s).toString();
    }

    public void preconnect(Map map)
    {
        throw new UnsupportedOperationException();
    }

    public void sendOutOfBandRequest(Executor executor, com.amazon.android.webkit.AmazonWebKitFactory.OutOfBandResponseListener outofbandresponselistener, AmazonUrlRequest amazonurlrequest)
    {
        throw new UnsupportedOperationException();
    }

    public void setTargetApiLevel(int i)
    {
        if (warmedUp || initialized)
        {
            throw new IllegalStateException("The Target API Level can only be set before warmUp or initialization.");
        } else
        {
            ClientApiLevel.getInstance().setApiLevel(i);
            return;
        }
    }

    public void setWebKitErrorListener(AmazonWebKitErrorListener amazonwebkiterrorlistener)
    {
    }

    public void setWebKitUrlRequestHandler(AmazonUrlRequestHandler amazonurlrequesthandler)
    {
        urlRequestHandler.set(amazonurlrequesthandler);
    }

    public void warmUp(Context context)
    {
        warmUp(context, null);
    }

    public void warmUp(Context context, List list)
    {
        warmedUp = true;
    }
}
