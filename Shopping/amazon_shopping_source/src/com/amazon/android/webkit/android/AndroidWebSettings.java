// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.WebSettings;
import com.amazon.android.webkit.AmazonWebSettings;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect

public class AndroidWebSettings extends AmazonWebSettings
{

    private static final Method GET_ENABLE_SMOOTH_TRANSITION = Reflect.getOptionalMethod(android/webkit/WebSettings, "getEnableSmoothTransition", new Class[0]);
    private static final Method GET_MEDIA_PLAYBACK = Reflect.getOptionalMethod(android/webkit/WebSettings, "getMediaPlaybackRequiresUserGesture", new Class[0]);
    private static final Method GET_USER_AGENT = Reflect.getOptionalMethod(android/webkit/WebSettings, "getUserAgent", new Class[0]);
    private static final Method SET_DISPLAY_ZOOM_CONTROLS;
    private static final Method SET_ENABLE_SMOOTH_TRANSITION;
    private static final Method SET_MEDIA_PLAYBACK;
    private static final Method SET_NAV_DUMP;
    private static final Method SET_PAGE_CACHE_CAPACITY;
    private static final Method SET_PROPERTY = Reflect.getOptionalMethod(android/webkit/WebSettings, "setProperty", new Class[] {
        java/lang/String, java/lang/String
    });
    private static final Method SET_USER_AGENT;
    private final WebSettings webSettingsDelegate;

    public AndroidWebSettings(WebSettings websettings)
    {
        webSettingsDelegate = websettings;
    }

    public String getUserAgentString()
    {
        return webSettingsDelegate.getUserAgentString();
    }

    public void setBuiltInZoomControls(boolean flag)
    {
        webSettingsDelegate.setBuiltInZoomControls(flag);
    }

    public void setDatabaseEnabled(boolean flag)
    {
        webSettingsDelegate.setDatabaseEnabled(flag);
    }

    public void setDefaultZoom(com.amazon.android.webkit.AmazonWebSettings.ZoomDensity zoomdensity)
    {
        webSettingsDelegate.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomdensity.toString()));
    }

    public void setDomStorageEnabled(boolean flag)
    {
        webSettingsDelegate.setDomStorageEnabled(flag);
    }

    public void setDoubleTapToZoomEnabled(boolean flag)
    {
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag)
    {
        webSettingsDelegate.setJavaScriptCanOpenWindowsAutomatically(flag);
    }

    public void setJavaScriptEnabled(boolean flag)
    {
        webSettingsDelegate.setJavaScriptEnabled(flag);
    }

    public void setRenderPriority(com.amazon.android.webkit.AmazonWebSettings.RenderPriority renderpriority)
    {
        webSettingsDelegate.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderpriority.toString()));
    }

    public void setSaveFormData(boolean flag)
    {
        webSettingsDelegate.setSaveFormData(flag);
    }

    public void setSavePassword(boolean flag)
    {
        webSettingsDelegate.setSavePassword(flag);
    }

    public void setSupportZoom(boolean flag)
    {
        webSettingsDelegate.setSupportZoom(flag);
    }

    public void setTextSize(com.amazon.android.webkit.AmazonWebSettings.TextSize textsize)
    {
        webSettingsDelegate.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textsize.toString()));
    }

    public void setTextZoom(int i)
    {
        webSettingsDelegate.setTextZoom(i);
    }

    public void setUserAgentString(String s)
    {
        webSettingsDelegate.setUserAgentString(s);
    }

    static 
    {
        SET_PAGE_CACHE_CAPACITY = Reflect.getOptionalMethod(android/webkit/WebSettings, "setPageCacheCapacity", new Class[] {
            Integer.TYPE
        });
        SET_DISPLAY_ZOOM_CONTROLS = Reflect.getOptionalMethod(android/webkit/WebSettings, "setDisplayZoomControls", new Class[] {
            Boolean.TYPE
        });
        SET_ENABLE_SMOOTH_TRANSITION = Reflect.getOptionalMethod(android/webkit/WebSettings, "setEnableSmoothTransition", new Class[] {
            Boolean.TYPE
        });
        SET_USER_AGENT = Reflect.getOptionalMethod(android/webkit/WebSettings, "setUserAgent", new Class[] {
            Integer.TYPE
        });
        SET_NAV_DUMP = Reflect.getOptionalMethod(android/webkit/WebSettings, "setNavDump", new Class[] {
            Boolean.TYPE
        });
        SET_MEDIA_PLAYBACK = Reflect.getOptionalMethod(android/webkit/WebSettings, "setMediaPlaybackRequiresUserGesture", new Class[] {
            Boolean.TYPE
        });
    }
}
