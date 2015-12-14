// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.wantu.activity.weibo.QQAuthroizeActivity;

public class bjx extends WebViewClient
{

    final QQAuthroizeActivity a;

    bjx(QQAuthroizeActivity qqauthroizeactivity)
    {
        a = qqauthroizeactivity;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        boolean flag = false;
        if (s.startsWith("http://callback.fotoable.com/callback/qq_callback.html"))
        {
            flag = true;
        }
        Log.d("lb", (new StringBuilder()).append("page finished =").append(s).toString());
        if (!flag)
        {
            if (QQAuthroizeActivity.b(a) != null)
            {
                QQAuthroizeActivity.b(a).dismiss();
            }
            QQAuthroizeActivity.a(a, null);
        }
        if (flag)
        {
            if (QQAuthroizeActivity.b(a) != null)
            {
                QQAuthroizeActivity.b(a).dismiss();
                QQAuthroizeActivity.a(a, null);
            }
            s = Uri.parse(s);
            webview = s.getQueryParameter("oauth_verifier");
            s = s.getQueryParameter("oauth_token");
            a.a(webview, s);
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Log.d("lb", (new StringBuilder()).append("page start =").append(s).toString());
        if (s.compareTo(QQAuthroizeActivity.a(a)) != 0 && QQAuthroizeActivity.b(a) != null && !QQAuthroizeActivity.b(a).isShowing())
        {
            QQAuthroizeActivity.a(a, new ProgressDialog(a));
            QQAuthroizeActivity.b(a).requestWindowFeature(1);
            QQAuthroizeActivity.b(a).setMessage(QQAuthroizeActivity.c(a).getString(0x7f0601d0));
            QQAuthroizeActivity.b(a).show();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview.loadUrl(s);
        return true;
    }
}
