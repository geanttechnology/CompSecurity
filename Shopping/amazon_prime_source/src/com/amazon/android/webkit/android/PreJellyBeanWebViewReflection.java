// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.WebBackForwardListClient;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonFindListener;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewReflection, Reflect

public class PreJellyBeanWebViewReflection extends AndroidWebViewReflection
{

    private static final Method COMPUTE_VERTICAL_SCROLL_OFFSET = Reflect.getRequiredPrivateMethod(android/webkit/WebView, "computeVerticalScrollOffset", new Class[0]);
    private static final Method DUMP_DISPLAY_TREE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "dumpDisplayTree", new Class[0]);
    private static final Method DUMP_DOM_TREE_METHOD;
    private static final Method DUMP_RENDER_TREE_METHOD;
    private static final Method DUMP_V8_COUNTERS_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "dumpV8Counters", new Class[0]);
    private static final Method GET_TOUCH_ICON_URL_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "getTouchIconUrl", new Class[0]);
    private static final Method LOAD_WEB_ARCHIVE_METHOD = Reflect.getOptionalMethod(android/webkit/WebView, "loadWebArchive", new Class[] {
        java/lang/String
    });
    private static final Method NOTIFY_FIND_DIALOG_DISMISSED_METHOD = Reflect.getRequiredPrivateMethod(android/webkit/WebView, "notifyFindDialogDismissed", new Class[0]);
    private static final Method ON_PAUSE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "onPause", new Class[0]);
    private static final Method ON_RESUME_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "onResume", new Class[0]);
    private static final Method SET_FIND_IS_UP_METHOD;
    private static final Method SET_NETWORK_TYPE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "setNetworkType", new Class[] {
        java/lang/String, java/lang/String
    });
    private static final Method SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "setWebBackForwardListClient", new Class[] {
        android/webkit/WebBackForwardListClient
    });
    private AmazonFindListener amazonFindListener;

    public PreJellyBeanWebViewReflection(WebView webview)
    {
        super(webview);
    }

    public void dumpDisplayTree()
    {
        Reflect.invokeMethod(DUMP_DISPLAY_TREE_METHOD, webView, new Object[0]);
    }

    public void dumpDomTree(boolean flag)
    {
        Reflect.invokeMethod(DUMP_DOM_TREE_METHOD, webView, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void dumpRenderTree(boolean flag)
    {
        Reflect.invokeMethod(DUMP_RENDER_TREE_METHOD, webView, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void dumpV8Counters()
    {
        Reflect.invokeMethod(DUMP_V8_COUNTERS_METHOD, webView, new Object[0]);
    }

    public void findAllAsync(String s)
    {
        int i = webView.findAll(s);
        if (amazonFindListener != null)
        {
            amazonFindListener.onFindResultReceived(i, 0, true);
        }
    }

    public String getTouchIconUrl()
    {
        return (String)Reflect.invokeMethod(GET_TOUCH_ICON_URL_METHOD, webView, new Object[0]);
    }

    public int getVerticalScrollOffset()
    {
        return ((Integer)Reflect.invokeMethod(COMPUTE_VERTICAL_SCROLL_OFFSET, webView, new Object[0])).intValue();
    }

    public void loadWebArchive(String s)
    {
        if (LOAD_WEB_ARCHIVE_METHOD != null)
        {
            Reflect.invokeMethod(LOAD_WEB_ARCHIVE_METHOD, webView, new Object[] {
                s
            });
            return;
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public void notifyFindDialogDismissed()
    {
        Reflect.invokeMethod(NOTIFY_FIND_DIALOG_DISMISSED_METHOD, webView, new Object[0]);
    }

    public void onPause()
    {
        Reflect.invokeMethod(ON_PAUSE_METHOD, webView, new Object[0]);
    }

    public void onResume()
    {
        Reflect.invokeMethod(ON_RESUME_METHOD, webView, new Object[0]);
    }

    public void setFindIsUp(boolean flag)
    {
        Reflect.invokeMethod(SET_FIND_IS_UP_METHOD, webView, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void setFindListener(AmazonFindListener amazonfindlistener)
    {
        amazonFindListener = amazonfindlistener;
    }

    public void setNetworkType(String s, String s1)
    {
        Reflect.invokeMethod(SET_NETWORK_TYPE_METHOD, webView, new Object[] {
            s, s1
        });
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webbackforwardlistclient)
    {
        Reflect.invokeMethod(SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD, webView, new Object[] {
            webbackforwardlistclient
        });
    }

    static 
    {
        DUMP_RENDER_TREE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "dumpRenderTree", new Class[] {
            Boolean.TYPE
        });
        DUMP_DOM_TREE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "dumpDomTree", new Class[] {
            Boolean.TYPE
        });
        SET_FIND_IS_UP_METHOD = Reflect.getRequiredPrivateMethod(android/webkit/WebView, "setFindIsUp", new Class[] {
            Boolean.TYPE
        });
    }
}
