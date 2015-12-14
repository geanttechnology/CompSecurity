// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.tencent.open.a.k;
import com.tencent.open.c.b;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.c;
import com.tencent.tauth.d;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            e, i, g

class f extends WebViewClient
{

    final e a;

    private f(e e1)
    {
        a = e1;
        super();
    }

    f(e e1, e._cls1 _pcls1)
    {
        this(e1);
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->onPageFinished, url: ").append(s).toString());
        e.g(a).setVisibility(8);
        if (e.e(a) != null)
        {
            e.e(a).setVisibility(0);
        }
        if (!TextUtils.isEmpty(s))
        {
            e.n(a).removeCallbacks((Runnable)e.p(a).remove(s));
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->onPageStarted, url: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
        e.g(a).setVisibility(0);
        e.a(a, SystemClock.elapsedRealtime());
        if (!TextUtils.isEmpty(e.i(a)))
        {
            e.n(a).removeCallbacks((Runnable)e.p(a).remove(e.i(a)));
        }
        com.tencent.connect.b.e.c(a, s);
        webview = new i(a, e.i(a));
        e.p(a).put(s, webview);
        e.n(a).postDelayed(webview, 0x1d4c0L);
    }

    public void onReceivedError(WebView webview, int j, String s, String s1)
    {
        super.onReceivedError(webview, j, s, s1);
        k.c("openSDK_LOG.authDlg", (new StringBuilder()).append("-->onReceivedError, errorCode: ").append(j).append(" | description: ").append(s).toString());
        if (!m.a(e.a(a)))
        {
            e.f(a).a(new d(9001, "\u5F53\u524D\u7F51\u7EDC\u4E0D\u53EF\u7528\uFF0C\u8BF7\u7A0D\u540E\u91CD\u8BD5\uFF01", s1));
            a.dismiss();
            return;
        }
        if (!e.i(a).startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?"))
        {
            long l = SystemClock.elapsedRealtime();
            long l1 = e.j(a);
            if (com.tencent.connect.b.e.k(a) < 1 && l - l1 < e.l(a))
            {
                com.tencent.connect.b.e.m(a);
                e.n(a).postDelayed(new Runnable() {

                    final f a;

                    public void run()
                    {
                        e.e(a.a).loadUrl(e.i(a.a));
                    }

            
            {
                a = f.this;
                super();
            }
                }, 500L);
                return;
            } else
            {
                e.e(a).loadUrl(e.o(a));
                return;
            }
        } else
        {
            e.f(a).a(new d(j, s, s1));
            a.dismiss();
            return;
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.cancel();
        e.f(a).a(new d(sslerror.getPrimaryError(), "\u8BF7\u6C42\u4E0D\u5408\u6CD5\uFF0C\u8BF7\u68C0\u67E5\u624B\u673A\u5B89\u5168\u8BBE\u7F6E\uFF0C\u5982\u7CFB\u7EDF\u65F6\u95F4\u3001\u4EE3\u7406\u7B49\u3002", "ssl error"));
        a.dismiss();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->Redirect URL: ").append(s).toString());
        if (!s.startsWith("auth://browser")) goto _L2; else goto _L1
_L1:
        webview = m.c(s);
        e.a(a, com.tencent.connect.b.e.b(a));
        if (!com.tencent.connect.b.e.c(a)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        if (webview.optString("fail_cb", null) != null)
        {
            a.a(webview.optString("fail_cb"), "");
        } else
        if (webview.optInt("fall_to_wv") == 1)
        {
            s = a;
            if (com.tencent.connect.b.e.d(a).indexOf("?") > -1)
            {
                webview = "&";
            } else
            {
                webview = "?";
            }
            e.a(s, webview);
            e.a(a, "browser_error=1");
            e.e(a).loadUrl(com.tencent.connect.b.e.d(a));
        } else
        {
            webview = webview.optString("redir", null);
            if (webview != null)
            {
                e.e(a).loadUrl(webview);
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (s.startsWith("auth://tauth.qq.com/"))
        {
            e.f(a).a(m.c(s));
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://cancel"))
        {
            e.f(a).a();
            a.dismiss();
            return true;
        }
        if (s.startsWith("auth://close"))
        {
            a.dismiss();
            return true;
        }
        if (s.startsWith("download://"))
        {
            try
            {
                webview = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(s.substring("download://".length()))));
                webview.addFlags(0x10000000);
                e.a(a).startActivity(webview);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                k.b("openSDK_LOG.authDlg", (new StringBuilder()).append("-->start download activity exception, e: ").append(webview.getMessage()).toString());
            }
            return true;
        }
        if (!s.startsWith("auth://progress"))
        {
            break MISSING_BLOCK_LABEL_471;
        }
        webview = Uri.parse(s).getPathSegments();
        if (webview.isEmpty())
        {
            return true;
        }
        int j;
        try
        {
            j = Integer.valueOf((String)webview.get(0)).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return true;
        }
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        e.g(a).setVisibility(8);
        e.e(a).setVisibility(0);
        break MISSING_BLOCK_LABEL_555;
        if (j != 1)
        {
            break MISSING_BLOCK_LABEL_555;
        }
        e.g(a).setVisibility(0);
        break MISSING_BLOCK_LABEL_555;
        if (s.startsWith("auth://onLoginSubmit"))
        {
            try
            {
                webview = Uri.parse(s).getPathSegments();
                if (!webview.isEmpty())
                {
                    com.tencent.connect.b.e.b(a, (String)webview.get(0));
                }
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview) { }
            return true;
        }
        if (e.h(a).a(e.e(a), s))
        {
            return true;
        } else
        {
            k.c("openSDK_LOG.authDlg", "-->Redirect URL: return false");
            return false;
        }
        return true;
    }
}
