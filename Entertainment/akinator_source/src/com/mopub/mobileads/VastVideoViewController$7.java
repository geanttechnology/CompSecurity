// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastCompanionAdConfig

class val.context extends WebViewClient
{

    final VastVideoViewController this$0;
    final Context val$context;
    final VastCompanionAdConfig val$vastCompanionAdConfig;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        val$vastCompanionAdConfig.handleClick(val$context, 1, s);
        return true;
    }

    ()
    {
        this$0 = final_vastvideoviewcontroller;
        val$vastCompanionAdConfig = vastcompanionadconfig;
        val$context = Context.this;
        super();
    }
}
