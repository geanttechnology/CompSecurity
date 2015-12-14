// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

// Referenced classes of package com.applovin.impl.adview:
//            n, p, q, r

class o extends WebView
{

    private final AppLovinLogger a;
    private AppLovinAd b;
    private boolean c;

    o(r r, AppLovinSdk applovinsdk, Context context)
    {
        super(context);
        b = null;
        c = false;
        a = applovinsdk.getLogger();
        setBackgroundColor(0);
        context = getSettings();
        context.setSupportMultipleWindows(false);
        context.setJavaScriptEnabled(true);
        setWebViewClient(r);
        setWebChromeClient(new n(applovinsdk));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(0x2000000);
        setOnTouchListener(new p(this));
        setOnLongClickListener(new q(this));
    }

    AppLovinAd a()
    {
        return b;
    }

    public void a(AppLovinAd applovinad)
    {
        if (!c)
        {
            b = applovinad;
            try
            {
                loadDataWithBaseURL("/", ((AppLovinAdImpl)applovinad).getHtmlSource(), "text/html", null, "");
                a.d("AdWebView", "AppLovinAd rendered");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AppLovinAd applovinad)
            {
                return;
            }
        } else
        {
            a.userError("AdWebView", "Ad can not be loaded in a destroyed web view");
            return;
        }
    }

    public void destroy()
    {
        c = true;
        super.destroy();
        a.d("AdWebView", "Web view destroyed");
_L1:
        return;
        Throwable throwable;
        throwable;
        if (a != null)
        {
            a.e("AdWebView", "destroy() threw exception", throwable);
            return;
        }
          goto _L1
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        try
        {
            super.onFocusChanged(flag, i, rect);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Rect rect)
        {
            a.e("AdWebView", "onFocusChanged() threw exception", rect);
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
    }

    public void onWindowFocusChanged(boolean flag)
    {
        try
        {
            super.onWindowFocusChanged(flag);
            return;
        }
        catch (Exception exception)
        {
            a.e("AdWebView", "onWindowFocusChanged() threw exception", exception);
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        try
        {
            super.onWindowVisibilityChanged(i);
            return;
        }
        catch (Exception exception)
        {
            a.e("AdWebView", "onWindowVisibilityChanged() threw exception", exception);
        }
    }

    public boolean requestFocus(int i, Rect rect)
    {
        boolean flag;
        try
        {
            flag = super.requestFocus(i, rect);
        }
        // Misplaced declaration of an exception variable
        catch (Rect rect)
        {
            a.e("AdWebView", "requestFocus() threw exception", rect);
            return false;
        }
        return flag;
    }
}
