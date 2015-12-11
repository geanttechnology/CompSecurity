// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.motors.videos.FwContextUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.NautilusKernel;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewFragment

class this._cls0 extends WebViewClient
{

    final ShowWebViewFragment this$0;

    private String getSslErrorUrl(SslError sslerror)
    {
        return sslerror.getUrl();
    }

    public void onPageFinished(WebView webview, String s)
    {
        boolean flag1 = true;
        if (!isHandlingError)
        {
            url = s;
            hasContentSettled = true;
            ShowWebViewFragment showwebviewfragment = ShowWebViewFragment.this;
            boolean flag = flag1;
            if (!isDoneFlag)
            {
                if (isLoadingLastPage)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
            }
            showwebviewfragment.isDoneFlag = flag;
            if (isDoneFlag && ShowWebViewFragment.access$300(ShowWebViewFragment.this) != null)
            {
                if (ShowWebViewFragment.access$400(ShowWebViewFragment.this) != null)
                {
                    ShowWebViewFragment.access$300(ShowWebViewFragment.this).startAnimation(ShowWebViewFragment.access$400(ShowWebViewFragment.this));
                }
                ShowWebViewFragment.access$300(ShowWebViewFragment.this).setVisibility(0);
            }
            ShowWebViewFragment.this.onPageFinished(webview, s);
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (isHandlingError) goto _L2; else goto _L1
_L1:
        if (ShowWebViewFragment.log.le)
        {
            ShowWebViewFragment.log.le((new StringBuilder()).append("onPageStarted: ").append(s).toString());
        }
        if (!isUrlLastPage(s)) goto _L4; else goto _L3
_L3:
        isLoadingLastPage = true;
_L6:
        if (!isDoneFlag)
        {
            ShowWebViewFragment.this.onPageStarted(webview, s, bitmap);
        }
_L2:
        return;
_L4:
        if (isUrlPastLastPage(s))
        {
            url = s;
            isDoneFlag = true;
            onDone();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed())
        {
            return;
        }
        isLoadingLastPage = false;
        isHandlingError = true;
        showProgress(false);
        ShowWebViewFragment.log.or(String.format("Error from webview %s: [%d] \"%s\" while fetching %s", new Object[] {
            getResources().getResourceName(webview.getId()), Integer.valueOf(i), s, s1
        }));
        if (Util.hasNetwork())
        {
            i = 0x7f07014e;
        } else
        {
            i = 0x7f070151;
        }
        createDialog(i).show();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed())
        {
            isLoadingLastPage = false;
            isHandlingError = true;
            showProgress(false);
            ShowWebViewFragment.log.or(String.format("Error from webview %s: \"%s\" while fetching %s.", new Object[] {
                getResources().getResourceName(webview.getId()), sslerror.toString(), getSslErrorUrl(sslerror)
            }));
            boolean flag1 = NautilusKernel.isQaMode();
            boolean flag = flag1;
            if (ShowWebViewFragment.access$200(ShowWebViewFragment.this))
            {
                flag = flag1;
                if (!flag1)
                {
                    try
                    {
                        webview = MyApp.getPrefs().getCurrentCountry().getSiteDomain();
                        flag = Uri.parse(url).getHost().endsWith(webview);
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        flag = false;
                    }
                }
            }
            if (flag)
            {
                ShowWebViewFragment.log.ning("Ignoring SSL errors.");
                sslerrorhandler.proceed();
                return;
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Activity activity;
        if (ShowWebViewFragment.log.le)
        {
            ShowWebViewFragment.log.le((new StringBuilder()).append("shouldOverrideUrlLoading: ").append(s).toString());
        }
        activity = getActivity();
        break MISSING_BLOCK_LABEL_43;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed())
        {
            if (isUrlPastLastPage(s))
            {
                url = s;
                isDoneFlag = true;
                onDone();
                return false;
            }
            String s1 = s;
            if (!Uri.parse(s).isOpaque())
            {
                s1 = rewriteUri(s);
            }
            if (ShowWebViewFragment.this.shouldOverrideUrlLoading(webview, s1))
            {
                return true;
            }
            Object obj = Uri.parse(s1);
            Intent intent = new Intent("android.intent.action.VIEW", ((Uri) (obj)));
            if (!((Uri) (obj)).isHierarchical())
            {
                startActivity(intent);
                return true;
            }
            obj = FwContextUtil.getLocalActivity(activity, intent);
            if (((Intent) (obj)).getComponent() != null)
            {
                startActivity(((Intent) (obj)));
                if (!hasContentSettled)
                {
                    activity.finish();
                }
                return true;
            }
            if (super.shouldOverrideUrlLoading(webview, s))
            {
                return true;
            }
            if (s1 != s)
            {
                ShowWebViewFragment.this.webview.loadUrl(s1);
                return true;
            }
        }
        return false;
    }

    ()
    {
        this$0 = ShowWebViewFragment.this;
        super();
    }
}
