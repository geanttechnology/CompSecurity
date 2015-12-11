// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            WebFragment

class redirect extends WebViewClient
{

    boolean loadingFinished;
    boolean redirect;
    final WebFragment this$0;
    final ImageButton val$btnNext;
    final ImageButton val$btnPrev;
    final WebView val$wv;

    public void onPageFinished(WebView webview, String s)
    {
        if (!redirect)
        {
            loadingFinished = true;
        }
        if (loadingFinished && !redirect && getActivity() != null)
        {
            ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(false);
        } else
        {
            redirect = false;
        }
        if (val$wv.canGoBack())
        {
            val$btnPrev.setImageResource(0x7f020112);
        } else
        {
            val$btnPrev.setImageResource(0x7f020113);
        }
        if (val$wv.canGoForward())
        {
            val$btnNext.setImageResource(0x7f020110);
            return;
        } else
        {
            val$btnNext.setImageResource(0x7f020111);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.contains("fb://") || s.contains("://play.google.com/store/apps/details?id="))
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            return true;
        }
        if (!loadingFinished)
        {
            redirect = true;
        }
        loadingFinished = false;
        webview.loadUrl(s);
        if (getActivity() != null)
        {
            ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(true);
        }
        return false;
    }

    ty()
    {
        this$0 = final_webfragment;
        val$wv = webview;
        val$btnPrev = imagebutton;
        val$btnNext = ImageButton.this;
        super();
        loadingFinished = true;
        redirect = false;
    }
}
