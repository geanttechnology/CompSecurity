// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.webkit.WebViewClient;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestCallBack

abstract class WeiboWebViewClient extends WebViewClient
{

    protected BrowserRequestCallBack mCallBack;

    WeiboWebViewClient()
    {
    }

    public void setBrowserRequestCallBack(BrowserRequestCallBack browserrequestcallback)
    {
        mCallBack = browserrequestcallback;
    }
}
