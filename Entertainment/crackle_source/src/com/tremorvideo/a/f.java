// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.a;

import android.content.Context;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.tremorvideo.a:
//            d, a

public class f extends d
{
    private class a extends d.a
    {

        final f b;

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            b.d.a(new com.tremorvideo.a.a("An SSL Error Occured.", -1, ""));
            super.a();
            webview.clearView();
            webview.loadUrl("about:blank");
        }

        private a()
        {
            b = f.this;
            super(f.this);
        }

    }


    protected f(Context context, String s, b.a a1)
    {
        super(context, s, a1);
    }

    protected WebViewClient b()
    {
        return new a();
    }

    public boolean onKeyLongPress(int i, KeyEvent keyevent)
    {
        if (i == 84)
        {
            return true;
        } else
        {
            return super.onKeyLongPress(i, keyevent);
        }
    }
}
