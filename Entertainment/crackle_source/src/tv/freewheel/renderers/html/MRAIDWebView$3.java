// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDWebView, HTMLRenderer

class val.bridge extends WebViewClient
{

    final MRAIDWebView this$0;
    final HTMLRenderer val$bridge;

    public void onLoadResource(WebView webview, String s)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("onLoadResource, url:").append(s).toString());
        super.onLoadResource(webview, s);
    }

    public void onPageFinished(WebView webview, String s)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("onPageFinished, url=").append(s).append(", withLoadedCallBack=").append(MRAIDWebView.access$500(MRAIDWebView.this)).toString());
        super.onPageFinished(webview, s);
        MRAIDWebView.access$402(MRAIDWebView.this, true);
        MRAIDWebView.access$600(MRAIDWebView.this, s);
        MRAIDWebView.access$700(MRAIDWebView.this);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("onPageStarted, url=").append(s).toString());
        MRAIDWebView.access$402(MRAIDWebView.this, false);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).error((new StringBuilder()).append("onReceivedError, failingUrl:").append(s1).append(", description:").append(s).toString());
        super.onReceivedError(webview, i, s, s1);
        if (!MRAIDWebView.access$400(MRAIDWebView.this))
        {
            val$bridge.mraidLoadFail(i, s);
        }
    }

    public void onScaleChanged(WebView webview, float f, float f1)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("onScaleChanged, oldScale=").append(f).append(", newScale=").append(f1).toString());
        super.onScaleChanged(webview, f, f1);
    }

    public void onTooManyRedirects(WebView webview, Message message, Message message1)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("onTooManyRedirects, cancel message:").append(message).toString());
        super.onTooManyRedirects(webview, message, message1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        MRAIDWebView.access$000(MRAIDWebView.this).debug((new StringBuilder()).append("shouldOverrideUrlLoading, url=").append(s).toString());
        return val$bridge.shouldOverrideUrlLoading(webview, s);
    }

    ()
    {
        this$0 = final_mraidwebview;
        val$bridge = HTMLRenderer.this;
        super();
    }
}
