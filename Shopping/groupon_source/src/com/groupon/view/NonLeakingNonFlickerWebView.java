// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.groupon.view:
//            NonLeakingWebView

public class NonLeakingNonFlickerWebView extends NonLeakingWebView
{
    protected class NonLeakingNonFlickerWebViewClient extends NonLeakingWebView.MyWebViewClient
    {

        final NonLeakingNonFlickerWebView this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            pageLoaded = true;
            setVisibility(visibility);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            pageLoaded = false;
            super.onPageStarted(webview, s, bitmap);
        }

        public NonLeakingNonFlickerWebViewClient(Activity activity)
        {
            this$0 = NonLeakingNonFlickerWebView.this;
            super(activity);
        }
    }


    private boolean pageLoaded;
    private int visibility;

    public NonLeakingNonFlickerWebView(Context context)
    {
        this(context, null, 0);
    }

    public NonLeakingNonFlickerWebView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NonLeakingNonFlickerWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        pageLoaded = false;
        visibility = getVisibility();
        super.setVisibility(8);
    }

    protected WebViewClient createWebViewClientInstance(Activity activity)
    {
        return new NonLeakingNonFlickerWebViewClient(activity);
    }

    public void setVisibility(int i)
    {
        visibility = i;
        if (pageLoaded)
        {
            super.setVisibility(i);
        }
    }


/*
    static boolean access$002(NonLeakingNonFlickerWebView nonleakingnonflickerwebview, boolean flag)
    {
        nonleakingnonflickerwebview.pageLoaded = flag;
        return flag;
    }

*/


}
