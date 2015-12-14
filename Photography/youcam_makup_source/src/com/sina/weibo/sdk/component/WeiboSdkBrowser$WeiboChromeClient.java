// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sina.weibo.sdk.component.view.LoadingBar;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboSdkBrowser

class <init> extends WebChromeClient
{

    final WeiboSdkBrowser this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        WeiboSdkBrowser.access$0(WeiboSdkBrowser.this).drawProgress(i);
        if (i == 100)
        {
            WeiboSdkBrowser.access$1(WeiboSdkBrowser.this, false);
            refreshAllViews();
        } else
        if (!WeiboSdkBrowser.access$2(WeiboSdkBrowser.this))
        {
            WeiboSdkBrowser.access$1(WeiboSdkBrowser.this, true);
            refreshAllViews();
            return;
        }
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        if (!WeiboSdkBrowser.access$4(WeiboSdkBrowser.this, WeiboSdkBrowser.access$3(WeiboSdkBrowser.this)) && !WeiboSdkBrowser.access$5(WeiboSdkBrowser.this).booleanValue())
        {
            WeiboSdkBrowser.access$6(WeiboSdkBrowser.this, s);
            WeiboSdkBrowser.access$7(WeiboSdkBrowser.this);
        }
    }

    private ()
    {
        this$0 = WeiboSdkBrowser.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
