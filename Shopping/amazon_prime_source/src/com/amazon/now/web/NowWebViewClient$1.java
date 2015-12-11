// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.amazon.now.ChromeStyle;

// Referenced classes of package com.amazon.now.web:
//            NowWebViewClient, WebActivity, NowWebFragment

class val.style
    implements android.view.r
{

    final NowWebViewClient this$0;
    final WebActivity val$activity;
    final ChromeStyle val$style;
    final WebView val$view;

    public void onClick(View view1)
    {
        val$view.reload();
        view1 = (ViewGroup)val$view.getParent();
        if (view1 != null)
        {
            view1.removeView(val$view);
        }
        val$activity.setRootView(val$activity.getWebViewHolder(), val$style);
        val$activity.error(false);
        val$activity.getWebFragment().attach();
    }

    ()
    {
        this$0 = final_nowwebviewclient;
        val$view = webview;
        val$activity = webactivity;
        val$style = ChromeStyle.this;
        super();
    }
}
