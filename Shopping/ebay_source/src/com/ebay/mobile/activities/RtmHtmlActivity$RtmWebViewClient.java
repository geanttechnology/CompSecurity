// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.motors.videos.FwContextUtil;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmHtmlActivity, LinkHandlerActivity

private class <init> extends WebViewClient
{

    final RtmHtmlActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (RtmHtmlActivity.access$100().it>)
        {
            RtmHtmlActivity.access$100().it>((new StringBuilder()).append("Page finished: ").append(s).toString());
        }
        RtmHtmlActivity rtmhtmlactivity = RtmHtmlActivity.this;
        boolean flag;
        if (isDoneFlag || isUrlLastPage(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        rtmhtmlactivity.isDoneFlag = flag;
        super.onPageFinished(webview, s);
        if (s.equals(RtmHtmlActivity.access$200(RtmHtmlActivity.this)) && RtmHtmlActivity.access$300(RtmHtmlActivity.this))
        {
            RtmHtmlActivity.access$400(RtmHtmlActivity.this).clearHistory();
            RtmHtmlActivity.access$302(RtmHtmlActivity.this, false);
        }
        setTitle(RtmHtmlActivity.access$500(RtmHtmlActivity.this));
        CookieSyncManager.getInstance().sync();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (RtmHtmlActivity.access$100()._fld0)
        {
            RtmHtmlActivity.access$100()._mth0((new StringBuilder()).append("Page started: ").append(s).toString());
        }
        if (!isFinishing())
        {
            Util.resetAppStatus(RtmHtmlActivity.this);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.e("RtmHtmlActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
        webview = s;
        if (i > 0)
        {
            webview = (new StringBuilder()).append(s).append(" (").append(i).append(")").toString();
        }
        dialogManager.showDynamicAlertDialog(null, webview, true);
        finish();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = Uri.parse(s);
        if (s.startsWith("ebay://link"))
        {
            if (RtmHtmlActivity.access$100()._fld0)
            {
                RtmHtmlActivity.access$100()._mth0("  Handle as ebay link");
            }
            webview = new Intent("android.intent.action.VIEW", webview, RtmHtmlActivity.this, com/ebay/mobile/activities/LinkHandlerActivity);
            startActivity(webview);
            return true;
        }
        if (s.startsWith("http://market.android.com"))
        {
            if (RtmHtmlActivity.access$100()._fld0)
            {
                RtmHtmlActivity.access$100()._mth0("  Handle as market link");
            }
            int i = "http://market.android.com".length();
            if (s.length() > i)
            {
                webview = Uri.parse((new StringBuilder()).append("market://").append(s.substring(i + 1)).toString());
                s = new Intent("android.intent.action.VIEW");
                s.setData(webview);
                startActivity(s);
                return true;
            }
        } else
        {
            if (s.startsWith("market://"))
            {
                if (RtmHtmlActivity.access$100()._fld0)
                {
                    RtmHtmlActivity.access$100()._mth0("  Handle as market link");
                }
                webview = Uri.parse(s);
                s = new Intent("android.intent.action.VIEW");
                s.setData(webview);
                startActivity(s);
                return true;
            }
            if ("tel".equals(webview.getScheme()) || "mailto".equals(webview.getScheme()))
            {
                if (RtmHtmlActivity.access$100()._fld0)
                {
                    RtmHtmlActivity.access$100()._mth0("  Handle as other non-heirarchical link");
                }
                webview = new Intent("android.intent.action.VIEW", webview);
                startActivity(webview);
                return true;
            }
            s = webview.getHost();
            if (!TextUtils.isEmpty(s) && s.toLowerCase(Locale.getDefault()).equals("pages.ebay.com") && webview.getPath().toLowerCase(Locale.getDefault()).startsWith("/link/"))
            {
                webview = new Intent("android.intent.action.VIEW", webview);
                webview = FwContextUtil.getLocalActivity(RtmHtmlActivity.this, webview);
                if (webview.getComponent() != null)
                {
                    startActivity(webview);
                    finish();
                    return true;
                }
            }
        }
        if (RtmHtmlActivity.access$100()._fld0)
        {
            RtmHtmlActivity.access$100()._mth0("  Handle as a regular link");
        }
        return false;
    }

    private A()
    {
        this$0 = RtmHtmlActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
