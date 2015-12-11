// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.app.Activity;
import android.net.http.SslError;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.a.d;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpException;

// Referenced classes of package com.a.a:
//            a, b, g, i, 
//            c

public final class h extends a
{

    private boolean f;
    private WebView g;

    public h(Activity activity, c c1, d d1, long l)
    {
        super(activity, c1, d1, b.b, l);
    }

    static WebView a(h h1)
    {
        return h1.g;
    }

    static WebView a(h h1, WebView webview)
    {
        h1.g = webview;
        return webview;
    }

    static void a(h h1, WebView webview, int j, String s, String s1)
    {
        h1.a("onReceivedError(code:%d, desc:%s, url:%s)", new Object[] {
            Integer.valueOf(j), s, s1
        });
        h1.a(com.a.a.g.d, ((Exception) (null)));
    }

    static void a(h h1, WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        h1.a("onReceivedSslError(%s)", new Object[] {
            sslerror
        });
        int j = sslerror.getPrimaryError();
        if (3 == j || 2 == j)
        {
            h1.a("Ignoring trust chain validation error.", new Object[0]);
            sslerrorhandler.proceed();
            return;
        } else
        {
            h1.a("Halting due to SSL error.", new Object[0]);
            h1.a(com.a.a.g.d, ((Exception) (new HttpException((new StringBuilder("SSL ERROR:")).append(sslerror.getPrimaryError()).toString()))));
            sslerrorhandler.cancel();
            return;
        }
    }

    static void a(h h1, WebView webview, String s)
    {
        h1.a("onLoadResource(%s)", new Object[] {
            s
        });
        try
        {
            webview = new URL(s);
            if (webview.getPath().endsWith("logo.htm") || webview.getPath().endsWith("logo.php"))
            {
                h1.f = true;
                h1.b.a((new StringBuilder("https://")).append(webview.getHost()).toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            h1.a("Unexpected URL problem [%s]", new Object[] {
                webview.getMessage()
            });
        }
    }

    static boolean a(h h1, ConsoleMessage consolemessage)
    {
label0:
        {
            h1.a("onConsoleMessage(%s)", new Object[] {
                consolemessage.message()
            });
            if (consolemessage.message().startsWith("\u25CF\uFF5E*"))
            {
                if (!consolemessage.message().substring(3).equals("<head></head><body></body>"))
                {
                    break label0;
                }
                h1.a(com.a.a.g.d, ((Exception) (new IllegalStateException("Error response received from Device Collector."))));
            }
            return true;
        }
        if (!h1.f)
        {
            h1.a(com.a.a.g.d, ((Exception) (new IllegalStateException("Never loaded logo.htm."))));
            return true;
        } else
        {
            h1.a(null, ((Exception) (null)));
            return true;
        }
    }

    static void b(h h1, WebView webview, String s)
    {
        h1.a("onPageFinished(%s)", new Object[] {
            s
        });
        CookieSyncManager.getInstance().sync();
        webview.loadUrl((new StringBuilder("javascript:console.log(")).append("'\u25CF\uFF5E*").append("'+").append("document.getElementsByTagName('html')[0].innerHTML);").toString());
    }

    static boolean c(h h1, WebView webview, String s)
    {
        h1.a("shouldOverrideUrlLoading(%s)", new Object[] {
            s
        });
        return false;
    }

    protected final void a()
    {
        String s = (new StringBuilder()).append(b.d()).append("?m=").append(b.a()).append("&s=").append(b.b()).toString();
        a("Calling URL: %s", new Object[] {
            s
        });
        a.runOnUiThread(new i(this, s));
        this;
        JVM INSTR monitorenter ;
        a("Waiting on Collector for %d ms", new Object[] {
            Long.valueOf(e())
        });
        wait(e());
        a("Wait finished", new Object[0]);
        if (c()) goto _L2; else goto _L1
_L1:
        d();
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a("Current Host: %s", new Object[] {
            b.c()
        });
        a(null, ((Exception) (null)));
          goto _L3
        Object obj;
        obj;
        a(com.a.a.g.d, ((Exception) (obj)));
          goto _L3
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
