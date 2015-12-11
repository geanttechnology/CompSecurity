// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.cordova;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

// Referenced classes of package org.apache.cordova:
//            ExposedJsApi, CordovaInterface, Config, PluginManager, 
//            LOG, CordovaBridge, NativeToJsMessageQueue, CordovaResourceApi, 
//            Whitelist, CordovaChromeClient, CordovaWebViewClient, IceCreamCordovaWebViewClient, 
//            ScrollEvent, CordovaPreferences, PluginResult

public class CordovaWebView extends WebView
{
    class ActivityResult
    {

        Intent incoming;
        int request;
        int result;
        final CordovaWebView this$0;

        public ActivityResult(int i, int j, Intent intent)
        {
            this$0 = CordovaWebView.this;
            super();
            request = i;
            result = j;
            incoming = intent;
        }
    }

    private static class Level16Apis
    {

        static void enableUniversalAccess(WebSettings websettings)
        {
            websettings.setAllowUniversalAccessFromFileURLs(true);
        }

        private Level16Apis()
        {
        }
    }


    public static final String CORDOVA_VERSION = "3.6.3";
    static final android.widget.FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
    public static final String TAG = "CordovaWebView";
    private HashSet boundKeyCodes;
    CordovaBridge bridge;
    private CordovaChromeClient chromeClient;
    private CordovaInterface cordova;
    private Whitelist externalWhitelist;
    private Whitelist internalWhitelist;
    private long lastMenuEventTime;
    String loadedUrl;
    private View mCustomView;
    private android.webkit.WebChromeClient.CustomViewCallback mCustomViewCallback;
    private boolean paused;
    public PluginManager pluginManager;
    private CordovaPreferences preferences;
    private CordovaResourceApi resourceApi;
    CordovaWebViewClient viewClient;

    public CordovaWebView(Context context)
    {
        this(context, null);
    }

    public CordovaWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        boundKeyCodes = new HashSet();
        lastMenuEventTime = 0L;
    }

    public CordovaWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        boundKeyCodes = new HashSet();
        lastMenuEventTime = 0L;
    }

    public CordovaWebView(Context context, AttributeSet attributeset, int i, boolean flag)
    {
        super(context, attributeset, i, flag);
        boundKeyCodes = new HashSet();
        lastMenuEventTime = 0L;
    }

    private void enableRemoteDebugging()
    {
        try
        {
            WebView.setWebContentsDebuggingEnabled(true);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.d("CordovaWebView", "You have one job! To turn on Remote Web Debugging! YOU HAVE FAILED! ");
            illegalargumentexception.printStackTrace();
            return;
        }
    }

    private void exposeJsInterface()
    {
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            Log.i("CordovaWebView", "Disabled addJavascriptInterface() bridge since Android version is old.");
            return;
        } else
        {
            addJavascriptInterface(new ExposedJsApi(bridge), "_cordovaNative");
            return;
        }
    }

    private void initIfNecessary()
    {
        if (pluginManager == null)
        {
            Log.w("CordovaWebView", "CordovaWebView.init() was not called. This will soon be required.");
            CordovaInterface cordovainterface = (CordovaInterface)getContext();
            if (!Config.isInitialized())
            {
                Config.init(cordovainterface.getActivity());
            }
            init(cordovainterface, makeWebViewClient(cordovainterface), makeWebChromeClient(cordovainterface), Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        }
    }

    private void initWebViewSettings()
    {
        setInitialScale(0);
        setVerticalScrollBarEnabled(false);
        if (shouldRequestFocusOnInit())
        {
            requestFocusFromTouch();
        }
        WebSettings websettings = getSettings();
        websettings.setJavaScriptEnabled(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(true);
        websettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        String s;
        try
        {
            Method method = android/webkit/WebSettings.getMethod("setNavDump", new Class[] {
                Boolean.TYPE
            });
            String s1 = Build.MANUFACTURER;
            Log.d("CordovaWebView", (new StringBuilder()).append("CordovaWebView is running on device made by: ").append(s1).toString());
            if (android.os.Build.VERSION.SDK_INT < 11 && Build.MANUFACTURER.contains("HTC"))
            {
                method.invoke(websettings, new Object[] {
                    Boolean.valueOf(true)
                });
            }
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.d("CordovaWebView", "We are on a modern version of Android, we will deprecate HTC 2.3 devices in 2.8");
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.d("CordovaWebView", "Doing the NavDump failed with bad arguments");
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            Log.d("CordovaWebView", "This should never happen: IllegalAccessException means this isn't Android anymore");
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Log.d("CordovaWebView", "This should never happen: InvocationTargetException means this isn't Android anymore.");
        }
        websettings.setSaveFormData(false);
        websettings.setSavePassword(false);
        if (android.os.Build.VERSION.SDK_INT > 15)
        {
            Level16Apis.enableUniversalAccess(websettings);
        }
        s = getContext().getApplicationContext().getDir("database", 0).getPath();
        websettings.setDatabaseEnabled(true);
        websettings.setDatabasePath(s);
        if ((getContext().getApplicationContext().getApplicationInfo().flags & 2) != 0 && android.os.Build.VERSION.SDK_INT >= 19)
        {
            enableRemoteDebugging();
        }
        websettings.setGeolocationDatabasePath(s);
        websettings.setDomStorageEnabled(true);
        websettings.setGeolocationEnabled(true);
        websettings.setAppCacheMaxSize(0x500000L);
        websettings.setAppCachePath(s);
        websettings.setAppCacheEnabled(true);
    }

    public boolean backHistory()
    {
        if (super.canGoBack())
        {
            super.goBack();
            return true;
        } else
        {
            return false;
        }
    }

    public void bindButton(int i, boolean flag, boolean flag1)
    {
        setButtonPlumbedToJs(i, flag1);
    }

    public void bindButton(String s, boolean flag)
    {
        if (s.compareTo("volumeup") == 0)
        {
            setButtonPlumbedToJs(24, flag);
        } else
        if (s.compareTo("volumedown") == 0)
        {
            setButtonPlumbedToJs(25, flag);
            return;
        }
    }

    public void bindButton(boolean flag)
    {
        setButtonPlumbedToJs(4, flag);
    }

    protected PluginManager createPluginManager(List list)
    {
        return new PluginManager(this, cordova, list);
    }

    public Whitelist getExternalWhitelist()
    {
        return externalWhitelist;
    }

    public CordovaPreferences getPreferences()
    {
        return preferences;
    }

    public String getProperty(String s, String s1)
    {
        Bundle bundle = cordova.getActivity().getIntent().getExtras();
        if (bundle != null)
        {
            if ((s = ((String) (bundle.get(s.toLowerCase(Locale.getDefault()))))) != null)
            {
                return s.toString();
            }
        }
        return s1;
    }

    public CordovaResourceApi getResourceApi()
    {
        return resourceApi;
    }

    public CordovaChromeClient getWebChromeClient()
    {
        return chromeClient;
    }

    public Whitelist getWhitelist()
    {
        return internalWhitelist;
    }

    public boolean hadKeyEvent()
    {
        return false;
    }

    public void handleDestroy()
    {
        loadUrl("javascript:try{cordova.require('cordova/channel').onDestroy.fire();}catch(e){};");
        loadUrl("about:blank");
        if (pluginManager != null)
        {
            pluginManager.onDestroy();
        }
    }

    public void handlePause(boolean flag)
    {
        LOG.d("CordovaWebView", "Handle the pause");
        loadUrl("javascript:try{cordova.fireDocumentEvent('pause');}catch(e){console.log('exception firing pause event from native');};");
        if (pluginManager != null)
        {
            pluginManager.onPause(flag);
        }
        if (!flag)
        {
            pauseTimers();
        }
        paused = true;
    }

    public void handleResume(boolean flag, boolean flag1)
    {
        loadUrl("javascript:try{cordova.fireDocumentEvent('resume');}catch(e){console.log('exception firing resume event from native');};");
        if (pluginManager != null)
        {
            pluginManager.onResume(flag);
        }
        if (!flag)
        {
            resumeTimers();
        }
        paused = false;
    }

    public void hideCustomView()
    {
        Log.d("CordovaWebView", "Hiding Custom View");
        if (mCustomView == null)
        {
            return;
        } else
        {
            mCustomView.setVisibility(8);
            ((ViewGroup)getParent()).removeView(mCustomView);
            mCustomView = null;
            mCustomViewCallback.onCustomViewHidden();
            setVisibility(0);
            return;
        }
    }

    public void init(CordovaInterface cordovainterface, CordovaWebViewClient cordovawebviewclient, CordovaChromeClient cordovachromeclient, List list, Whitelist whitelist, Whitelist whitelist1, CordovaPreferences cordovapreferences)
    {
        if (cordova != null)
        {
            throw new IllegalStateException();
        } else
        {
            cordova = cordovainterface;
            viewClient = cordovawebviewclient;
            chromeClient = cordovachromeclient;
            internalWhitelist = whitelist;
            externalWhitelist = whitelist1;
            preferences = cordovapreferences;
            setWebChromeClient(cordovachromeclient);
            setWebViewClient(cordovawebviewclient);
            pluginManager = createPluginManager(list);
            bridge = new CordovaBridge(pluginManager, new NativeToJsMessageQueue(this, cordovainterface));
            resourceApi = new CordovaResourceApi(getContext(), pluginManager);
            pluginManager.addService("App", "org.apache.cordova.App");
            initWebViewSettings();
            exposeJsInterface();
            return;
        }
    }

    public boolean isBackButtonBound()
    {
        return isButtonPlumbedToJs(4);
    }

    public boolean isButtonPlumbedToJs(int i)
    {
        return boundKeyCodes.contains(Integer.valueOf(i));
    }

    public boolean isCustomViewShowing()
    {
        return mCustomView != null;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void loadUrl(String s)
    {
        if (s.equals("about:blank") || s.startsWith("javascript:"))
        {
            loadUrlNow(s);
            return;
        } else
        {
            loadUrlIntoView(s);
            return;
        }
    }

    public void loadUrl(String s, int i)
    {
        if (s == null)
        {
            loadUrlIntoView(Config.getStartUrl());
            return;
        } else
        {
            loadUrlIntoView(s);
            return;
        }
    }

    public void loadUrlIntoView(String s)
    {
        loadUrlIntoView(s, true);
    }

    public void loadUrlIntoView(String s, int i)
    {
        if (!s.startsWith("javascript:") && !canGoBack())
        {
            LOG.d("CordovaWebView", "loadUrlIntoView(%s, %d)", new Object[] {
                s, Integer.valueOf(i)
            });
            postMessage("splashscreen", "show");
        }
        loadUrlIntoView(s);
    }

    public void loadUrlIntoView(String s, boolean flag)
    {
        LOG.d("CordovaWebView", (new StringBuilder()).append(">>> loadUrl(").append(s).append(")").toString());
        initIfNecessary();
        if (flag)
        {
            loadedUrl = s;
            pluginManager.init();
        }
        loadUrlNow(s);
    }

    void loadUrlNow(String s)
    {
        if (LOG.isLoggable(3) && !s.startsWith("javascript:"))
        {
            LOG.d("CordovaWebView", ">>> loadUrlNow()");
        }
        if (s.startsWith("file://") || s.startsWith("javascript:") || internalWhitelist.isUrlWhiteListed(s))
        {
            super.loadUrl(s);
        }
    }

    public CordovaChromeClient makeWebChromeClient(CordovaInterface cordovainterface)
    {
        return new CordovaChromeClient(cordovainterface, this);
    }

    public CordovaWebViewClient makeWebViewClient(CordovaInterface cordovainterface)
    {
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            return new CordovaWebViewClient(cordovainterface, this);
        } else
        {
            return new IceCreamCordovaWebViewClient(cordovainterface, this);
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        getSettings().getUserAgentString();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (boundKeyCodes.contains(Integer.valueOf(i)))
        {
            if (i == 25)
            {
                loadUrl("javascript:try{cordova.fireDocumentEvent('volumedownbutton');}catch(e){}");
                return true;
            }
            if (i == 24)
            {
                loadUrl("javascript:try{cordova.fireDocumentEvent('volumeupbutton');}catch(e){}");
                return true;
            } else
            {
                return super.onKeyDown(i, keyevent);
            }
        }
        if (i == 4)
        {
            if (!startOfHistory() || isButtonPlumbedToJs(4))
            {
                flag = true;
            }
            return flag;
        }
        if (i == 82)
        {
            View view = getFocusedChild();
            if (view != null)
            {
                ((InputMethodManager)cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                cordova.getActivity().openOptionsMenu();
                return true;
            } else
            {
                return super.onKeyDown(i, keyevent);
            }
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i != 4) goto _L2; else goto _L1
_L1:
        if (mCustomView == null) goto _L4; else goto _L3
_L3:
        hideCustomView();
_L6:
        return true;
_L4:
        if (isButtonPlumbedToJs(4))
        {
            loadUrl("javascript:try{cordova.fireDocumentEvent('backbutton');}catch(e){}");
            return true;
        }
        if (backHistory()) goto _L6; else goto _L5
_L5:
        return super.onKeyUp(i, keyevent);
_L2:
        if (i == 82)
        {
            if (lastMenuEventTime < keyevent.getEventTime())
            {
                loadUrl("javascript:try{cordova.fireDocumentEvent('menubutton');}catch(e){}");
            }
            lastMenuEventTime = keyevent.getEventTime();
            return super.onKeyUp(i, keyevent);
        }
        if (i == 84)
        {
            loadUrl("javascript:try{cordova.fireDocumentEvent('searchbutton');}catch(e){}");
            return true;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public void onNewIntent(Intent intent)
    {
        if (pluginManager != null)
        {
            pluginManager.onNewIntent(intent);
        }
    }

    public void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        postMessage("onScrollChanged", new ScrollEvent(i, j, k, l, this));
    }

    public void postMessage(String s, Object obj)
    {
        if (pluginManager != null)
        {
            pluginManager.postMessage(s, obj);
        }
    }

    public void printBackForwardList()
    {
        WebBackForwardList webbackforwardlist = copyBackForwardList();
        int j = webbackforwardlist.getSize();
        for (int i = 0; i < j; i++)
        {
            String s = webbackforwardlist.getItemAtIndex(i).getUrl();
            LOG.d("CordovaWebView", (new StringBuilder()).append("The URL at index: ").append(Integer.toString(i)).append(" is ").append(s).toString());
        }

    }

    public WebBackForwardList restoreState(Bundle bundle)
    {
        bundle = super.restoreState(bundle);
        Log.d("CordovaWebView", "WebView restoration crew now restoring!");
        pluginManager.init();
        return bundle;
    }

    public void sendJavascript(String s)
    {
        bridge.getMessageQueue().addJavaScript(s);
    }

    public void sendPluginResult(PluginResult pluginresult, String s)
    {
        bridge.getMessageQueue().addPluginResult(pluginresult, s);
    }

    public void setButtonPlumbedToJs(int i, boolean flag)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported keycode: ").append(i).toString());

        case 4: // '\004'
        case 24: // '\030'
        case 25: // '\031'
            break;
        }
        if (flag)
        {
            boundKeyCodes.add(Integer.valueOf(i));
            return;
        } else
        {
            boundKeyCodes.remove(Integer.valueOf(i));
            return;
        }
    }

    public void setWebChromeClient(CordovaChromeClient cordovachromeclient)
    {
        chromeClient = cordovachromeclient;
        super.setWebChromeClient(cordovachromeclient);
    }

    public void setWebViewClient(CordovaWebViewClient cordovawebviewclient)
    {
        viewClient = cordovawebviewclient;
        super.setWebViewClient(cordovawebviewclient);
    }

    protected boolean shouldRequestFocusOnInit()
    {
        return true;
    }

    public void showCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        Log.d("CordovaWebView", "showing Custom View");
        if (mCustomView != null)
        {
            customviewcallback.onCustomViewHidden();
            return;
        } else
        {
            mCustomView = view;
            mCustomViewCallback = customviewcallback;
            customviewcallback = (ViewGroup)getParent();
            customviewcallback.addView(view, COVER_SCREEN_GRAVITY_CENTER);
            setVisibility(8);
            customviewcallback.setVisibility(0);
            customviewcallback.bringToFront();
            return;
        }
    }

    public void showWebPage(String s, boolean flag, boolean flag1, HashMap hashmap)
    {
        LOG.d("CordovaWebView", "showWebPage(%s, %b, %b, HashMap", new Object[] {
            s, Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        if (flag1)
        {
            clearHistory();
        }
        if (!flag)
        {
            if (s.startsWith("file://") || internalWhitelist.isUrlWhiteListed(s))
            {
                loadUrl(s);
                return;
            }
            LOG.w("CordovaWebView", (new StringBuilder()).append("showWebPage: Cannot load URL into webview since it is not in white list.  Loading into browser instead. (URL=").append(s).append(")").toString());
        }
        Uri uri;
        hashmap = new Intent("android.intent.action.VIEW");
        uri = Uri.parse(s);
        if (!"file".equals(uri.getScheme()))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        hashmap.setDataAndType(uri, resourceApi.getMimeType(uri));
_L1:
        cordova.getActivity().startActivity(hashmap);
        return;
        try
        {
            hashmap.setData(uri);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            LOG.e("CordovaWebView", (new StringBuilder()).append("Error loading url ").append(s).toString(), hashmap);
            return;
        }
          goto _L1
    }

    public boolean startOfHistory()
    {
        boolean flag = false;
        Object obj = copyBackForwardList().getItemAtIndex(0);
        if (obj != null)
        {
            obj = ((WebHistoryItem) (obj)).getUrl();
            String s = getUrl();
            LOG.d("CordovaWebView", (new StringBuilder()).append("The current URL is: ").append(s).toString());
            LOG.d("CordovaWebView", (new StringBuilder()).append("The URL at item 0 is: ").append(((String) (obj))).toString());
            flag = s.equals(obj);
        }
        return flag;
    }

    public void stopLoading()
    {
        viewClient.isCurrentlyLoading = false;
        super.stopLoading();
    }

    public void storeResult(int i, int j, Intent intent)
    {
    }

}
