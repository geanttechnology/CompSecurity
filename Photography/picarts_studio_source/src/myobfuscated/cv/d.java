// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cv;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class d extends WebViewClient
{

    private static final String a = myobfuscated/cv/d.getSimpleName();

    public d()
    {
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("onPageFinished : URL: ")).append(s).toString()
        });
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("onPageStarted : URL: ")).append(s).toString()
        });
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("onReceivedError : URL: ")).append(s1).toString()
        });
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("shouldOverrideUrlLoading : Redirect URL: ")).append(s).toString()
        });
        return super.shouldOverrideUrlLoading(webview, s);
    }

}
