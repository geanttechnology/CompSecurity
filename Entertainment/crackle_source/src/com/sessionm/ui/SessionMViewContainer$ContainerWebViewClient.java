// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sessionm.core.StatsCollector;

// Referenced classes of package com.sessionm.ui:
//            SessionMViewContainer, ProgressViewController

private class <init> extends WebViewClient
{

    final SessionMViewContainer this$0;
    private long webViewStartTime;

    public void onPageFinished(WebView webview, String s)
    {
label0:
        {
            long l = System.currentTimeMillis() - webViewStartTime;
            StatsCollector.a(com.sessionm.core.bViewStartTime, l);
            if (Log.isLoggable("SessionM.WebView", 3))
            {
                Log.d("SessionM.WebView", String.format("Finished web view loading duration: %d", new Object[] {
                    Long.valueOf(l)
                }));
            }
            if (SessionMViewContainer.access$200(SessionMViewContainer.this) != null && SessionMViewContainer.access$600(SessionMViewContainer.this) == this._fld0 && SessionMViewContainer.access$700(SessionMViewContainer.this) != null)
            {
                SessionMViewContainer.access$700(SessionMViewContainer.this).dismiss();
                SessionMViewContainer.access$702(SessionMViewContainer.this, null);
                SessionMViewContainer.access$200(SessionMViewContainer.this).setVisibility(0);
            }
            CookieSyncManager.getInstance().sync();
            if (SessionMViewContainer.access$300(SessionMViewContainer.this) != null)
            {
                if (!SessionMViewContainer.access$800().equals(ailureMode.WEB_VIEW_LOAD_FAILURE))
                {
                    break label0;
                }
                SessionMViewContainer.access$300(SessionMViewContainer.this).onFailure(SessionMViewContainer.this, 5, "web view error failure simulation", s);
            }
            return;
        }
        SessionMViewContainer.access$300(SessionMViewContainer.this).onViewLoaded(SessionMViewContainer.this, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        webViewStartTime = System.currentTimeMillis();
        if (Log.isLoggable("SessionM.WebView", 3))
        {
            Log.d("SessionM.WebView", (new StringBuilder()).append("Web view loading started, url: ").append(s).toString());
        }
        if (SessionMViewContainer.access$300(SessionMViewContainer.this) != null)
        {
            SessionMViewContainer.access$300(SessionMViewContainer.this).onViewLoadStarted(SessionMViewContainer.this, s);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (Log.isLoggable("SessionM.WebView", 3))
        {
            Log.d("SessionM.WebView", (new StringBuilder()).append("Failed to load web view, url: ").append(s1).append(", description: ").append(s).append(", code: ").append(i).toString());
        }
        if (SessionMViewContainer.access$300(SessionMViewContainer.this) != null)
        {
            SessionMViewContainer.access$300(SessionMViewContainer.this).onFailure(SessionMViewContainer.this, i, s, s1);
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (Log.isLoggable("SessionM.WebView", 3))
        {
            Log.d("SessionM.WebView", (new StringBuilder()).append("onReceivedSslError() callback while loading web view, error: ").append(sslerror).toString());
        }
        sslerrorhandler.proceed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Log.isLoggable("SessionM.WebView", 3))
        {
            Log.d("SessionM.WebView", (new StringBuilder()).append("Processing URL redirect: ").append(s).toString());
        }
        boolean flag1 = super.shouldOverrideUrlLoading(webview, s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        return flag1;
_L2:
        boolean flag2;
        boolean flag3;
        flag2 = flag1;
        flag3 = flag1;
        webview = Uri.parse(s);
        flag2 = flag1;
        flag3 = flag1;
        Object obj = webview.getScheme();
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("external")) goto _L4; else goto _L3
_L3:
        flag2 = flag1;
        flag3 = flag1;
        if (!((String) (obj)).equalsIgnoreCase("external-secure")) goto _L5; else goto _L4
_L4:
        flag2 = flag1;
        flag3 = flag1;
        if (!((String) (obj)).equalsIgnoreCase("external")) goto _L7; else goto _L6
_L6:
        flag2 = flag1;
        flag3 = flag1;
        webview = String.format("http:%s", new Object[] {
            webview.getEncodedSchemeSpecificPart()
        });
_L14:
        flag2 = flag1;
        flag3 = flag1;
        obj = new Intent("android.intent.action.VIEW");
        flag2 = flag1;
        flag3 = flag1;
        if (((Intent) (obj)).resolveActivity(SessionMViewContainer.access$400(SessionMViewContainer.this).getPackageManager()) != null) goto _L9; else goto _L8
_L8:
        flag2 = flag1;
        flag3 = flag1;
        if (!Log.isLoggable("SessionM.WebView", 6))
        {
            break MISSING_BLOCK_LABEL_229;
        }
        flag2 = flag1;
        flag3 = flag1;
        Log.e("SessionM.WebView", "Unable to resolve activity for external url");
        flag2 = flag1;
        flag3 = flag1;
        if (SessionMViewContainer.access$300(SessionMViewContainer.this) == null) goto _L11; else goto _L10
_L10:
        flag2 = flag1;
        flag3 = flag1;
        SessionMViewContainer.access$300(SessionMViewContainer.this).onFailure(SessionMViewContainer.this, -1, "Unable to resolve activity for external url", webview);
          goto _L11
_L15:
        boolean flag;
        flag1 = flag;
        if (!flag) goto _L1; else goto _L12
_L12:
        flag1 = flag;
        flag2 = flag;
        flag3 = flag;
        if (!Log.isLoggable("SessionM.WebView", 3)) goto _L1; else goto _L13
_L13:
        flag2 = flag;
        flag3 = flag;
        Log.d("SessionM.WebView", (new StringBuilder()).append("Started Android activity for url: ").append(s).toString());
        return flag;
        webview;
_L25:
        executeJavascript("GreyhoundEventDispatcher.dispatch('external.error','Activity Not Found');");
        return flag2;
_L7:
        flag2 = flag1;
        flag3 = flag1;
        webview = String.format("https:%s", new Object[] {
            webview.getEncodedSchemeSpecificPart()
        });
          goto _L14
_L9:
        flag2 = flag1;
        flag3 = flag1;
        ((Intent) (obj)).setData(Uri.parse(webview));
        flag2 = flag1;
        flag3 = flag1;
        SessionMViewContainer.access$400(SessionMViewContainer.this).startActivity(((Intent) (obj)));
        flag = true;
          goto _L15
_L5:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("sip")) goto _L17; else goto _L16
_L16:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("geo")) goto _L17; else goto _L18
_L18:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("content")) goto _L17; else goto _L19
_L19:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("tel")) goto _L17; else goto _L20
_L20:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("sms")) goto _L17; else goto _L21
_L21:
        flag2 = flag1;
        flag3 = flag1;
        if (((String) (obj)).equalsIgnoreCase("market")) goto _L17; else goto _L22
_L22:
        flag = flag1;
        flag2 = flag1;
        flag3 = flag1;
        if (!((String) (obj)).equalsIgnoreCase("mailto")) goto _L15; else goto _L17
_L17:
        flag2 = flag1;
        flag3 = flag1;
        webview = new Intent("android.intent.action.VIEW");
        flag2 = flag1;
        flag3 = flag1;
        if (webview.resolveActivity(SessionMViewContainer.access$400(SessionMViewContainer.this).getPackageManager()) != null)
        {
            break MISSING_BLOCK_LABEL_685;
        }
        flag2 = flag1;
        flag3 = flag1;
        if (!Log.isLoggable("SessionM.WebView", 6))
        {
            break MISSING_BLOCK_LABEL_635;
        }
        flag2 = flag1;
        flag3 = flag1;
        Log.e("SessionM.WebView", "Unable to resolve activity for url");
        flag2 = flag1;
        flag3 = flag1;
        if (SessionMViewContainer.access$300(SessionMViewContainer.this) == null)
        {
            break MISSING_BLOCK_LABEL_791;
        }
        flag2 = flag1;
        flag3 = flag1;
        SessionMViewContainer.access$300(SessionMViewContainer.this).onFailure(SessionMViewContainer.this, -1, "Unable to resolve activity for url", s);
        break MISSING_BLOCK_LABEL_791;
        flag2 = flag1;
        flag3 = flag1;
        webview.setFlags(0x2000000);
        flag2 = flag1;
        flag3 = flag1;
        webview.setData(Uri.parse(s));
        flag2 = flag1;
        flag3 = flag1;
        SessionMViewContainer.access$400(SessionMViewContainer.this).startActivity(webview);
        flag = true;
          goto _L15
        webview;
        flag3 = false;
_L24:
        executeJavascript(String.format("GreyhoundEventDispatcher.dispatch('external.error',%s);", new Object[] {
            webview.getMessage()
        }));
        return flag3;
        webview;
        if (true) goto _L24; else goto _L23
_L23:
        webview;
        flag2 = false;
          goto _L25
_L11:
        flag = false;
          goto _L15
        flag = false;
          goto _L15
    }

    private stener()
    {
        this$0 = SessionMViewContainer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
