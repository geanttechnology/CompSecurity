// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.fullscreens;

import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.intentsoftware.addapptr.fullscreens:
//            PromoHouseFullscreenActivity

class this._cls0 extends WebViewClient
{

    final PromoHouseFullscreenActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (s.equals("internal:noad"))
        {
            PromoHouseFullscreenActivity.access$102(PromoHouseFullscreenActivity.this, new Intent());
            PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this).setAction("PROMO_HOUSE_AD_FAILED");
            sendBroadcast(PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this));
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        PromoHouseFullscreenActivity.access$102(PromoHouseFullscreenActivity.this, new Intent());
        PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this).setAction("PROMO_HOUSE_ACTIVITY_FINISH");
        sendBroadcast(PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this));
        finish();
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
    {
        return super.shouldOverrideKeyEvent(webview, keyevent);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = Uri.parse(s).getHost();
        if (s.equals("krassapp://close"))
        {
            PromoHouseFullscreenActivity.access$000(PromoHouseFullscreenActivity.this);
        } else
        {
            if (s.equals("internal:noad"))
            {
                PromoHouseFullscreenActivity.access$102(PromoHouseFullscreenActivity.this, new Intent());
                PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this).setAction("PROMO_HOUSE_AD_FAILED");
                sendBroadcast(PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this));
                PromoHouseFullscreenActivity.access$000(PromoHouseFullscreenActivity.this);
                return false;
            }
            if (webview != null && !webview.contains("krassgames"))
            {
                PromoHouseFullscreenActivity.access$102(PromoHouseFullscreenActivity.this, new Intent());
                PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this).setAction("PROMO_HOUSE_AD_CLICKED");
                sendBroadcast(PromoHouseFullscreenActivity.access$100(PromoHouseFullscreenActivity.this));
                webview = new Intent("android.intent.action.VIEW");
                webview.setData(Uri.parse(s));
                startActivity(webview);
                PromoHouseFullscreenActivity.access$000(PromoHouseFullscreenActivity.this);
                return true;
            }
        }
        return false;
    }

    ()
    {
        this$0 = PromoHouseFullscreenActivity.this;
        super();
    }
}
