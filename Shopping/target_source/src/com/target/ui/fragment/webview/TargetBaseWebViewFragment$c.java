// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.webview:
//            b, TargetBaseWebViewFragment

protected class mIsError extends b
{

    private boolean mIsError;
    final TargetBaseWebViewFragment this$0;

    private void a(int i)
    {
        mIsError = true;
        if (i == -2)
        {
            c(TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this)).a(com.target.ui.view.common.nt, true);
        } else
        {
            c(TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this)).a("", getString(0x7f0902f9), true);
        }
        s();
    }

    public void a()
    {
        mIsError = false;
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (j())
        {
            TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).progressBar.setProgress(100);
        }
        if (!mIsError)
        {
            TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this, webview);
            l();
        } else
        {
            TargetBaseWebViewFragment.this.s();
        }
        super.onPageFinished(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        a(i);
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        a(sslerror.getPrimaryError());
    }

    public ()
    {
        this$0 = TargetBaseWebViewFragment.this;
        super();
        mIsError = false;
    }
}
