// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ca;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.socialin.android.d;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.ca:
//            a, d

final class c extends WebViewClient
{

    private a a;

    private c(a a1)
    {
        a = a1;
        super();
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    public final void onPageFinished(WebView webview, String s)
    {
        myobfuscated.ca.a.i(a).setVisibility(8);
        super.onPageFinished(webview, s);
        d.b(myobfuscated.ca.a.a(), new Object[] {
            (new StringBuilder("onPageFinished : URL: ")).append(s).toString()
        });
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        myobfuscated.ca.a.i(a).setVisibility(0);
        super.onPageStarted(webview, s, bitmap);
        d.b(myobfuscated.ca.a.a(), new Object[] {
            (new StringBuilder("onPageStarted : URL: ")).append(s).toString()
        });
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        myobfuscated.ca.a.i(a).setVisibility(8);
        super.onReceivedError(webview, i, s, s1);
        d.b(myobfuscated.ca.a.a(), new Object[] {
            (new StringBuilder("onReceivedError : failingUrl = ")).append(s1).append("\n error description : ").append(s).toString()
        });
        if (s1.startsWith("https://picsart-oauth2-success"))
        {
            shouldOverrideUrlLoading(webview, s1);
            return;
        } else
        {
            myobfuscated.ca.a.a(a, s);
            return;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        d.b(myobfuscated.ca.a.a(), new Object[] {
            (new StringBuilder("shouldOverrideUrlLoading : Redirect URL: ")).append(s).toString()
        });
        if (s.startsWith(myobfuscated.ca.a.a(a)))
        {
            s = Uri.parse(s).getQueryParameter("code");
            if (s == null)
            {
                myobfuscated.ca.a.a(a, "Authorization code is null.");
                return false;
            }
            myobfuscated.ca.a.b(a, (new StringBuilder()).append(myobfuscated.ca.a.c(a)).append("?client_id=").append(myobfuscated.ca.a.d(a)).append("&client_secret=").append(myobfuscated.ca.a.e(a)).append("&grant_type=").append(myobfuscated.ca.a.f(a)).append("&redirect_uri=").append(myobfuscated.ca.a.a(a)).append("&code=").append(s).toString());
            String s1 = myobfuscated.ca.a.g(a);
            if (myobfuscated.ca.a.h(a))
            {
                webview = "POST";
            } else
            {
                webview = "GET";
            }
            webview = new Request(s1, null, webview);
            webview.b();
            if (myobfuscated.ca.a.h(a))
            {
                webview.b("code", s);
                webview.b("client_id", myobfuscated.ca.a.d(a));
                webview.b("client_secret", myobfuscated.ca.a.e(a));
                webview.b("grant_type", "authorization_code");
                webview.b("redirect_uri", myobfuscated.ca.a.a(a));
            }
            b.a().a(webview, new myobfuscated.ca.d(a, (byte)0));
            return true;
        }
        if (s.contains("https://market.android.com/"))
        {
            String s2;
            if (m.a(myobfuscated.ca.a.b(a), "string", "configVersion"))
            {
                s2 = a.getString(m.e(myobfuscated.ca.a.b(a), "configVersion"));
            } else
            {
                s2 = "2";
            }
            if (!"2".equals(s2))
            {
                s = s.substring(s.lastIndexOf("id=") + 3, s.length());
                webview.loadUrl((new StringBuilder()).append(a.getString(m.e(myobfuscated.ca.a.b(a), (new StringBuilder("market_url_")).append(s2).toString()))).append(s).toString());
                return true;
            }
        }
        return false;
    }
}
