// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.view.View;
import android.widget.ProgressBar;
import com.target.ui.view.ObservableScrollWebView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.webview:
//            TargetBaseWebViewFragment

private class webView
{

    private TargetErrorView errorContainer;
    protected ProgressBar progressBar;
    private View progressContainer;
    final TargetBaseWebViewFragment this$0;
    protected ObservableScrollWebView webView;
    private View webViewContainer;

    static View a(webView webview)
    {
        return webview.webViewContainer;
    }

    static View b(webViewContainer webviewcontainer)
    {
        return webviewcontainer.progressContainer;
    }

    static TargetErrorView c(progressContainer progresscontainer)
    {
        return progresscontainer.errorContainer;
    }

    public (View view)
    {
        this$0 = TargetBaseWebViewFragment.this;
        super();
        progressContainer = view.findViewById(TargetBaseWebViewFragment.this.c());
        webViewContainer = view.findViewById(TargetBaseWebViewFragment.this.b());
        errorContainer = (TargetErrorView)view.findViewById(TargetBaseWebViewFragment.this.d());
        progressBar = (ProgressBar)view.findViewById(f());
        webView = (ObservableScrollWebView)view.findViewById(e());
    }
}
