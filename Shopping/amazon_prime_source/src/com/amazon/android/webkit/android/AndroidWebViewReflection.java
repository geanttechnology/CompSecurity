// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.WebBackForwardListClient;
import android.webkit.WebView;
import com.amazon.android.webkit.AmazonFindListener;

// Referenced classes of package com.amazon.android.webkit.android:
//            JellyBeanWebViewReflection, PreJellyBeanWebViewReflection

abstract class AndroidWebViewReflection
{

    private static final int KITKAT_VERSION_NUMBER = 19;
    protected final WebView webView;

    protected AndroidWebViewReflection(WebView webview)
    {
        webView = webview;
    }

    public static AndroidWebViewReflection create(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT > 15)
        {
            return new JellyBeanWebViewReflection(webview);
        } else
        {
            return new PreJellyBeanWebViewReflection(webview);
        }
    }

    public abstract void dumpDisplayTree();

    public abstract void dumpDomTree(boolean flag);

    public abstract void dumpRenderTree(boolean flag);

    public abstract void dumpV8Counters();

    public abstract void findAllAsync(String s);

    public abstract String getTouchIconUrl();

    public abstract int getVerticalScrollOffset();

    public abstract void loadWebArchive(String s);

    public abstract void notifyFindDialogDismissed();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setFindIsUp(boolean flag);

    public abstract void setFindListener(AmazonFindListener amazonfindlistener);

    public abstract void setNetworkType(String s, String s1);

    public abstract void setWebBackForwardListClient(WebBackForwardListClient webbackforwardlistclient);
}
