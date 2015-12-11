// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.util.Log;
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
    private static final String TAG = "AndroidWebSettings";
    private final WebSettings webSettingsDelegate;

    public AndroidWebSettings(WebSettings websettings)
    {
        webSettingsDelegate = websettings;
    }

    public boolean enableSmoothTransition()
    {
        if (GET_ENABLE_SMOOTH_TRANSITION != null)
        {
            ((Boolean)Reflect.invokeMethod(GET_ENABLE_SMOOTH_TRANSITION, webSettingsDelegate, new Object[0])).booleanValue();
        }
        return false;
    }

    public boolean getAllowContentAccess()
    {
        return webSettingsDelegate.getAllowContentAccess();
    }

    public boolean getAllowFileAccess()
    {
        return webSettingsDelegate.getAllowFileAccess();
    }

    public boolean getAllowFileAccessFromFileURLs()
    {
        return webSettingsDelegate.getAllowFileAccessFromFileURLs();
    }

    public boolean getAllowRunningInsecureContent()
    {
        return true;
    }

    public boolean getAllowUniversalAccessFromFileURLs()
    {
        return webSettingsDelegate.getAllowUniversalAccessFromFileURLs();
    }

    public boolean getBlockNetworkImage()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = webSettingsDelegate.getBlockNetworkImage();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getBlockNetworkLoads()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = webSettingsDelegate.getBlockNetworkLoads();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getBuiltInZoomControls()
    {
        return webSettingsDelegate.getBuiltInZoomControls();
    }

    public int getCacheMode()
    {
        return webSettingsDelegate.getCacheMode();
    }

    public String getCursiveFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getCursiveFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getDatabaseEnabled()
    {
        return webSettingsDelegate.getDatabaseEnabled();
    }

    public String getDatabasePath()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getDatabasePath();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public int getDefaultFixedFontSize()
    {
        return webSettingsDelegate.getDefaultFixedFontSize();
    }

    public int getDefaultFontSize()
    {
        return webSettingsDelegate.getDefaultFontSize();
    }

    public String getDefaultTextEncodingName()
    {
        return webSettingsDelegate.getDefaultTextEncodingName();
    }

    public com.amazon.android.webkit.AmazonWebSettings.ZoomDensity getDefaultZoom()
    {
        return com.amazon.android.webkit.AmazonWebSettings.ZoomDensity.valueOf(webSettingsDelegate.getDefaultZoom().toString());
    }

    public boolean getDisplayZoomControls()
    {
        return webSettingsDelegate.getDisplayZoomControls();
    }

    public boolean getDomStorageEnabled()
    {
        return webSettingsDelegate.getDomStorageEnabled();
    }

    public String getFantasyFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getFantasyFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getFixedFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getFixedFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getJavaScriptCanOpenWindowsAutomatically()
    {
        return webSettingsDelegate.getJavaScriptCanOpenWindowsAutomatically();
    }

    public boolean getJavaScriptEnabled()
    {
        return webSettingsDelegate.getJavaScriptEnabled();
    }

    public com.amazon.android.webkit.AmazonWebSettings.LayoutAlgorithm getLayoutAlgorithm()
    {
        return com.amazon.android.webkit.AmazonWebSettings.LayoutAlgorithm.valueOf(webSettingsDelegate.getLayoutAlgorithm().toString());
    }

    public boolean getLightTouchEnabled()
    {
        return webSettingsDelegate.getLightTouchEnabled();
    }

    public boolean getLoadWithOverviewMode()
    {
        return webSettingsDelegate.getLoadWithOverviewMode();
    }

    public boolean getLoadsImagesAutomatically()
    {
        return webSettingsDelegate.getLoadsImagesAutomatically();
    }

    public boolean getMediaPlaybackRequiresUserGesture()
    {
        if (GET_MEDIA_PLAYBACK != null)
        {
            return ((Boolean)Reflect.invokeMethod(GET_MEDIA_PLAYBACK, webSettingsDelegate, new Object[0])).booleanValue();
        } else
        {
            Log.w("AndroidWebSettings", "getMediaPlaybackRequiresUserGesture() is not available");
            return false;
        }
    }

    public int getMinimumFontSize()
    {
        return webSettingsDelegate.getMinimumFontSize();
    }

    public int getMinimumLogicalFontSize()
    {
        return webSettingsDelegate.getMinimumLogicalFontSize();
    }

    public com.amazon.android.webkit.AmazonWebSettings.PluginState getPluginState()
    {
        return com.amazon.android.webkit.AmazonWebSettings.PluginState.valueOf(webSettingsDelegate.getPluginState().toString());
    }

    public String getSansSerifFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getSansSerifFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getSaveFormData()
    {
        return webSettingsDelegate.getSaveFormData();
    }

    public boolean getSavePassword()
    {
        return webSettingsDelegate.getSavePassword();
    }

    public String getSerifFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getSerifFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public String getStandardFontFamily()
    {
        this;
        JVM INSTR monitorenter ;
        String s = webSettingsDelegate.getStandardFontFamily();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public com.amazon.android.webkit.AmazonWebSettings.TextSize getTextSize()
    {
        return com.amazon.android.webkit.AmazonWebSettings.TextSize.valueOf(webSettingsDelegate.getTextSize().toString());
    }

    public int getTextZoom()
    {
        return webSettingsDelegate.getTextZoom();
    }

    public boolean getUseWideViewPort()
    {
        return webSettingsDelegate.getUseWideViewPort();
    }

    public int getUserAgent()
    {
        int i = 0;
        if (GET_USER_AGENT != null)
        {
            i = ((Integer)Reflect.invokeMethod(GET_USER_AGENT, webSettingsDelegate, new Object[0])).intValue();
        }
        return i;
    }

    public String getUserAgentString()
    {
        return webSettingsDelegate.getUserAgentString();
    }

    public boolean isDoubleTapToZoomEnabled()
    {
        return true;
    }

    public void setAllowContentAccess(boolean flag)
    {
        webSettingsDelegate.setAllowContentAccess(flag);
    }

    public void setAllowFileAccess(boolean flag)
    {
        webSettingsDelegate.setAllowFileAccess(flag);
    }

    public void setAllowFileAccessFromFileURLs(boolean flag)
    {
        webSettingsDelegate.setAllowFileAccessFromFileURLs(flag);
    }

    public void setAllowRunningInsecureContent(boolean flag)
    {
        if (!flag)
        {
            throw new UnsupportedOperationException("setAllowRunningInsecureContent(false) is unsupported");
        } else
        {
            return;
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean flag)
    {
        webSettingsDelegate.setAllowUniversalAccessFromFileURLs(flag);
    }

    public void setAppCacheEnabled(boolean flag)
    {
        webSettingsDelegate.setAppCacheEnabled(flag);
    }

    public void setAppCacheMaxSize(long l)
    {
        webSettingsDelegate.setAppCacheMaxSize(l);
    }

    public void setAppCachePath(String s)
    {
        webSettingsDelegate.setAppCachePath(s);
    }

    public void setBlockNetworkImage(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setBlockNetworkImage(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setBlockNetworkLoads(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setBlockNetworkLoads(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setBuiltInZoomControls(boolean flag)
    {
        webSettingsDelegate.setBuiltInZoomControls(flag);
    }

    public void setCacheMode(int i)
    {
        webSettingsDelegate.setCacheMode(i);
    }

    public void setCursiveFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setCursiveFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setDatabaseEnabled(boolean flag)
    {
        webSettingsDelegate.setDatabaseEnabled(flag);
    }

    public void setDatabasePath(String s)
    {
        webSettingsDelegate.setDatabasePath(s);
    }

    public void setDefaultFixedFontSize(int i)
    {
        webSettingsDelegate.setDefaultFixedFontSize(i);
    }

    public void setDefaultFontSize(int i)
    {
        webSettingsDelegate.setDefaultFontSize(i);
    }

    public void setDefaultTextEncodingName(String s)
    {
        webSettingsDelegate.setDefaultTextEncodingName(s);
    }

    public void setDefaultZoom(com.amazon.android.webkit.AmazonWebSettings.ZoomDensity zoomdensity)
    {
        webSettingsDelegate.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomdensity.toString()));
    }

    public void setDisplayZoomControls(boolean flag)
    {
        if (SET_DISPLAY_ZOOM_CONTROLS != null)
        {
            Reflect.invokeMethod(SET_DISPLAY_ZOOM_CONTROLS, webSettingsDelegate, new Object[] {
                Boolean.valueOf(flag)
            });
        }
    }

    public void setDomStorageEnabled(boolean flag)
    {
        webSettingsDelegate.setDomStorageEnabled(flag);
    }

    public void setDoubleTapToZoomEnabled(boolean flag)
    {
    }

    public void setEnableSmoothTransition(boolean flag)
    {
        if (SET_ENABLE_SMOOTH_TRANSITION != null)
        {
            Reflect.invokeMethod(SET_ENABLE_SMOOTH_TRANSITION, webSettingsDelegate, new Object[] {
                Boolean.valueOf(flag)
            });
        }
    }

    public void setFantasyFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setFantasyFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setFixedFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setFixedFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setGeolocationDatabasePath(String s)
    {
        webSettingsDelegate.setGeolocationDatabasePath(s);
    }

    public void setGeolocationEnabled(boolean flag)
    {
        webSettingsDelegate.setGeolocationEnabled(flag);
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag)
    {
        webSettingsDelegate.setJavaScriptCanOpenWindowsAutomatically(flag);
    }

    public void setJavaScriptEnabled(boolean flag)
    {
        webSettingsDelegate.setJavaScriptEnabled(flag);
    }

    public void setLayoutAlgorithm(com.amazon.android.webkit.AmazonWebSettings.LayoutAlgorithm layoutalgorithm)
    {
        webSettingsDelegate.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutalgorithm.toString()));
    }

    public void setLightTouchEnabled(boolean flag)
    {
        webSettingsDelegate.setLightTouchEnabled(flag);
    }

    public void setLoadWithOverviewMode(boolean flag)
    {
        webSettingsDelegate.setLoadWithOverviewMode(flag);
    }

    public void setLoadsImagesAutomatically(boolean flag)
    {
        webSettingsDelegate.setLoadsImagesAutomatically(flag);
    }

    public void setMediaPlaybackRequiresUserGesture(boolean flag)
    {
        if (SET_MEDIA_PLAYBACK != null)
        {
            Reflect.invokeMethod(SET_MEDIA_PLAYBACK, webSettingsDelegate, new Object[] {
                Boolean.valueOf(flag)
            });
            return;
        } else
        {
            Log.w("AndroidWebSettings", "setMediaPlaybackRequiresUserGesture() is not available");
            return;
        }
    }

    public void setMinimumFontSize(int i)
    {
        webSettingsDelegate.setMinimumFontSize(i);
    }

    public void setMinimumLogicalFontSize(int i)
    {
        webSettingsDelegate.setMinimumLogicalFontSize(i);
    }

    public void setNavDump(boolean flag)
    {
        if (SET_NAV_DUMP != null)
        {
            Reflect.invokeMethod(SET_NAV_DUMP, webSettingsDelegate, new Object[] {
                Boolean.valueOf(flag)
            });
        }
    }

    public void setNeedInitialFocus(boolean flag)
    {
        webSettingsDelegate.setNeedInitialFocus(flag);
    }

    public void setPageCacheCapacity(int i)
    {
        if (SET_PAGE_CACHE_CAPACITY != null)
        {
            Reflect.invokeMethod(SET_PAGE_CACHE_CAPACITY, webSettingsDelegate, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public void setPluginState(com.amazon.android.webkit.AmazonWebSettings.PluginState pluginstate)
    {
        webSettingsDelegate.setPluginState(android.webkit.WebSettings.PluginState.valueOf(pluginstate.toString()));
    }

    public void setPrerenderTimeout(int i)
    {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String s, String s1)
    {
        if (SET_PROPERTY != null)
        {
            Reflect.invokeMethod(SET_PROPERTY, webSettingsDelegate, new Object[] {
                s, s1
            });
        }
    }

    public void setRenderPriority(com.amazon.android.webkit.AmazonWebSettings.RenderPriority renderpriority)
    {
        webSettingsDelegate.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderpriority.toString()));
    }

    public void setSansSerifFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setSansSerifFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSaveFormData(boolean flag)
    {
        webSettingsDelegate.setSaveFormData(flag);
    }

    public void setSavePassword(boolean flag)
    {
        webSettingsDelegate.setSavePassword(flag);
    }

    public void setSerifFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setSerifFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setStandardFontFamily(String s)
    {
        this;
        JVM INSTR monitorenter ;
        webSettingsDelegate.setStandardFontFamily(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSupportMultipleWindows(boolean flag)
    {
        webSettingsDelegate.setSupportMultipleWindows(flag);
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

    public void setUseWideViewPort(boolean flag)
    {
        webSettingsDelegate.setUseWideViewPort(flag);
    }

    public void setUserAgent(int i)
    {
        if (SET_USER_AGENT != null)
        {
            Reflect.invokeMethod(SET_USER_AGENT, webSettingsDelegate, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public void setUserAgentString(String s)
    {
        webSettingsDelegate.setUserAgentString(s);
    }

    public boolean supportMultipleWindows()
    {
        return webSettingsDelegate.supportMultipleWindows();
    }

    public boolean supportZoom()
    {
        return webSettingsDelegate.supportZoom();
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
