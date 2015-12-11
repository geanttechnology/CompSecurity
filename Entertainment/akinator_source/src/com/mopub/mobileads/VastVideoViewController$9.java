// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoViewController, VastIconConfig

class val.vastIconConfig extends WebViewClient
{

    final VastVideoViewController this$0;
    final VastIconConfig val$vastIconConfig;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        val$vastIconConfig.handleClick(getContext(), s);
        return true;
    }

    ()
    {
        this$0 = final_vastvideoviewcontroller;
        val$vastIconConfig = VastIconConfig.this;
        super();
    }
}
