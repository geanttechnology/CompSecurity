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

class JellyBeanWebViewReflection extends AndroidWebViewReflection
{

    private static final Method COMPUTE_VERTICAL_SCROLL_OFFSET = Reflect.getRequiredPrivateMethod(android/webkit/WebView, "computeVerticalScrollOffset", new Class[0]);
    private static final Method DUMP_DISPLAY_TREE_METHOD;
    private static final Method DUMP_DOM_TREE_METHOD;
    private static final Method DUMP_RENDER_TREE_METHOD;
    private static final Method FROM_WEB_VIEW_METHOD;
    private static final Method GET_TOUCH_ICON_URL_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "getTouchIconUrl", new Class[0]);
    private static final Method LOAD_WEB_ARCHIVE_METHOD = Reflect.getOptionalMethod(android/webkit/WebView, "loadWebArchive", new Class[] {
        java/lang/String
    });
    private static final Method NOTIFY_FIND_DIALOG_DISMISSED_METHOD;
    private static final Method ON_PAUSE_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "onPause", new Class[0]);
    private static final Method ON_RESUME_METHOD = Reflect.getRequiredMethod(android/webkit/WebView, "onResume", new Class[0]);
    private static final Method SET_FIND_IS_UP_METHOD;
    private static final Method SET_NETWORK_TYPE_METHOD;
    private static final Method SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD;
    private static final Class WEB_VIEW_CLASSIC_CLASS;
    private final Object webviewClassicDelegate;

    public JellyBeanWebViewReflection(WebView webview)
    {
        super(webview);
        webviewClassicDelegate = Reflect.invokeMethod(FROM_WEB_VIEW_METHOD, null, new Object[] {
            webview
        });
    }

    public String getTouchIconUrl()
    {
        return (String)Reflect.invokeMethod(GET_TOUCH_ICON_URL_METHOD, webviewClassicDelegate, new Object[0]);
    }

    public int getVerticalScrollOffset()
    {
        return ((Integer)Reflect.invokeMethod(COMPUTE_VERTICAL_SCROLL_OFFSET, webView, new Object[0])).intValue();
    }

    public void setFindIsUp(boolean flag)
    {
        Reflect.invokeMethod(SET_FIND_IS_UP_METHOD, webviewClassicDelegate, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void setFindListener(final AmazonFindListener listener)
    {
        webView.setFindListener(new android.webkit.WebView.FindListener() {

            final JellyBeanWebViewReflection this$0;
            final AmazonFindListener val$listener;

            public void onFindResultReceived(int i, int j, boolean flag)
            {
                listener.onFindResultReceived(i, j, flag);
            }

            
            {
                this$0 = JellyBeanWebViewReflection.this;
                listener = amazonfindlistener;
                super();
            }
        });
    }

    public void setWebBackForwardListClient(WebBackForwardListClient webbackforwardlistclient)
    {
        Reflect.invokeMethod(SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD, webviewClassicDelegate, new Object[] {
            webbackforwardlistclient
        });
    }

    static 
    {
        WEB_VIEW_CLASSIC_CLASS = Reflect.getRequiredClass("android.webkit.WebViewClassic");
        SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "setWebBackForwardListClient", new Class[] {
            android/webkit/WebBackForwardListClient
        });
        FROM_WEB_VIEW_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "fromWebView", new Class[] {
            android/webkit/WebView
        });
        DUMP_RENDER_TREE_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "dumpRenderTree", new Class[] {
            Boolean.TYPE
        });
        DUMP_DOM_TREE_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "dumpDomTree", new Class[] {
            Boolean.TYPE
        });
        DUMP_DISPLAY_TREE_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "dumpDisplayTree", new Class[0]);
        NOTIFY_FIND_DIALOG_DISMISSED_METHOD = Reflect.getRequiredPrivateMethod(WEB_VIEW_CLASSIC_CLASS, "notifyFindDialogDismissed", new Class[0]);
        SET_FIND_IS_UP_METHOD = Reflect.getRequiredPrivateMethod(WEB_VIEW_CLASSIC_CLASS, "setFindIsUp", new Class[] {
            Boolean.TYPE
        });
        SET_NETWORK_TYPE_METHOD = Reflect.getRequiredMethod(WEB_VIEW_CLASSIC_CLASS, "setNetworkType", new Class[] {
            java/lang/String, java/lang/String
        });
    }
}
