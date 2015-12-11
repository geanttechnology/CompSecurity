// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebView, AmazonWebViewDelegate, AmazonPluginManager, AmazonCacheManager, 
//            AmazonCookieManager, AmazonCookieSyncManager, AmazonGeolocationPermissions, AmazonHistoryManager, 
//            AmazonMediaDeviceSettings, AmazonWebKitUpdateHandler, AmazonWebIconDatabase, AmazonWebKitCapabilities, 
//            AmazonWebStorage, AmazonWebViewDatabase, AmazonUrlRequest, AmazonWebKitErrorListener, 
//            AmazonUrlRequestHandler

public abstract class AmazonWebKitFactory
{
    public static interface OutOfBandResponseListener
    {
    }

    public static final class SurfaceType extends Enum
    {

        private static final SurfaceType $VALUES[];
        public static final SurfaceType SURFACEVIEW;
        public static final SurfaceType TEXTUREVIEW;
        private final int value;

        public static SurfaceType valueOf(String s)
        {
            return (SurfaceType)Enum.valueOf(com/amazon/android/webkit/AmazonWebKitFactory$SurfaceType, s);
        }

        public static SurfaceType[] values()
        {
            return (SurfaceType[])$VALUES.clone();
        }

        public int getValue()
        {
            return value;
        }

        static 
        {
            SURFACEVIEW = new SurfaceType("SURFACEVIEW", 0, 0);
            TEXTUREVIEW = new SurfaceType("TEXTUREVIEW", 1, 1);
            $VALUES = (new SurfaceType[] {
                SURFACEVIEW, TEXTUREVIEW
            });
        }

        private SurfaceType(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }


    protected AmazonWebKitFactory()
    {
    }

    public abstract void clearAllVisitedLinkHistory();

    public abstract void clearFormData(Context context);

    public AmazonWebView createWebView(Context context, int i, Object obj, boolean flag)
    {
        return createWebView(context, i, obj, flag, new Bundle());
    }

    public AmazonWebView createWebView(Context context, int i, Object obj, boolean flag, Bundle bundle)
    {
        return createWebView(context, i, obj, flag, bundle, SurfaceType.SURFACEVIEW);
    }

    public AmazonWebView createWebView(Context context, int i, Object obj, boolean flag, Bundle bundle, SurfaceType surfacetype)
    {
        context = new AmazonWebView(context, obj);
        initializeWebView(context, i, flag, bundle, surfacetype);
        return context;
    }

    public abstract AmazonWebViewDelegate createWebViewDelegate(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle);

    public abstract AmazonWebViewDelegate createWebViewDelegate(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle, int j);

    public void disableDeveloperTools()
    {
    }

    public void enableDeveloperToolsTcp(int i)
    {
        throw new UnsupportedOperationException("Implementation does not support remote debugging");
    }

    public void enableDeveloperToolsUnix(String s)
    {
        throw new UnsupportedOperationException("Implementation does not support remote debugging");
    }

    public abstract AmazonPluginManager getAmazonPluginManager(Context context)
        throws UnsupportedOperationException;

    public abstract int getApiLevel();

    public abstract AmazonCacheManager getCacheManager();

    public abstract AmazonCookieManager getCookieManager();

    public abstract AmazonCookieSyncManager getCookieSyncManager();

    public abstract AmazonGeolocationPermissions getGeolocationPermissions();

    public abstract AmazonHistoryManager getHistoryManager();

    public abstract int getMaxApiLevelSupported();

    public abstract AmazonMediaDeviceSettings getMediaDeviceSettings();

    public int getOptimalWebViewCount()
    {
        return 10;
    }

    public abstract AmazonWebKitUpdateHandler getUpdateHandler();

    public abstract AmazonWebIconDatabase getWebIconDatabase();

    public abstract AmazonWebKitCapabilities getWebKitCapabilities();

    public abstract AmazonWebStorage getWebStorage();

    public abstract AmazonWebViewDatabase getWebViewDatabase(Context context);

    public abstract void initialize(Context context);

    public abstract void initialize(Context context, List list);

    public void initializeWebView(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle)
    {
        initializeWebView(amazonwebview, i, flag, bundle, SurfaceType.SURFACEVIEW);
    }

    public void initializeWebView(AmazonWebView amazonwebview, int i, boolean flag, Bundle bundle, SurfaceType surfacetype)
    {
        if (amazonwebview != null)
        {
            amazonwebview.setWebViewDelegate(createWebViewDelegate(amazonwebview, i, flag, bundle, surfacetype.getValue()));
            return;
        } else
        {
            throw new IllegalStateException("Attempting to initialize an invalid WebView");
        }
    }

    public abstract boolean isRenderProcess(Context context);

    public String javaScriptToUrl(String s)
    {
        return (new StringBuilder()).append("javascript:").append(Uri.encode(s)).toString();
    }

    public abstract void preconnect(Map map);

    public abstract void sendOutOfBandRequest(Executor executor, OutOfBandResponseListener outofbandresponselistener, AmazonUrlRequest amazonurlrequest)
        throws UnsupportedOperationException;

    public void setEmbeddedVideoEnabled(boolean flag)
    {
        throw new UnsupportedOperationException("Implementation cannot toggle embedded video");
    }

    public void setExtraLibraryPath(String s)
    {
    }

    public void setMaxRenderProcessCount(int i)
    {
    }

    public void setNativeLibraryPackage(String s)
    {
    }

    public void setRenderingStatsEnabled(boolean flag)
    {
    }

    public abstract void setTargetApiLevel(int i);

    public abstract void setWebKitErrorListener(AmazonWebKitErrorListener amazonwebkiterrorlistener);

    public abstract void setWebKitUrlRequestHandler(AmazonUrlRequestHandler amazonurlrequesthandler);

    public void setWebRtcEnabled(boolean flag)
    {
    }

    public abstract void warmUp(Context context);

    public abstract void warmUp(Context context, List list);
}
