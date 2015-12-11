// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class WebFragment extends Fragment
{

    String url;

    public WebFragment()
    {
        url = "";
    }

    public static WebFragment newInstance(String s)
    {
        WebFragment webfragment = new WebFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", s);
        webfragment.setArguments(bundle);
        return webfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        url = getArguments().getString("url");
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup wv, final Bundle btnPrev)
    {
        layoutinflater = layoutinflater.inflate(0x7f030039, wv, false);
        wv = (WebView)layoutinflater.findViewById(0x7f0700af);
        btnPrev = (ImageButton)layoutinflater.findViewById(0x7f0700ab);
        final ImageButton btnNext = (ImageButton)layoutinflater.findViewById(0x7f0700ac);
        ImageButton imagebutton = (ImageButton)layoutinflater.findViewById(0x7f0700ad);
        ImageButton imagebutton1 = (ImageButton)layoutinflater.findViewById(0x7f0700ae);
        WebSettings websettings = wv.getSettings();
        websettings.setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setPadding(0, 0, 0, 0);
        websettings.setLoadWithOverviewMode(true);
        websettings.setUseWideViewPort(true);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setDisplayZoomControls(false);
        wv.setWebViewClient(new _cls1());
        wv.loadUrl(url);
        btnPrev.setOnClickListener(new _cls2());
        btnNext.setOnClickListener(new _cls3());
        imagebutton.setOnClickListener(new _cls4());
        imagebutton1.setOnClickListener(new _cls5());
        return layoutinflater;
    }

    private class _cls1 extends WebViewClient
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
            if (wv.canGoBack())
            {
                btnPrev.setImageResource(0x7f020112);
            } else
            {
                btnPrev.setImageResource(0x7f020113);
            }
            if (wv.canGoForward())
            {
                btnNext.setImageResource(0x7f020110);
                return;
            } else
            {
                btnNext.setImageResource(0x7f020111);
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

        _cls1()
        {
            this$0 = WebFragment.this;
            wv = webview;
            btnPrev = imagebutton;
            btnNext = imagebutton1;
            super();
            loadingFinished = true;
            redirect = false;
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final WebFragment this$0;
        final WebView val$wv;

        public void onClick(View view)
        {
            if (wv.canGoBack())
            {
                wv.goBack();
                if (getActivity() != null)
                {
                    ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(true);
                }
            }
        }

        _cls2()
        {
            this$0 = WebFragment.this;
            wv = webview;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnClickListener
    {

        final WebFragment this$0;
        final WebView val$wv;

        public void onClick(View view)
        {
            if (wv.canGoForward())
            {
                wv.goForward();
                if (getActivity() != null)
                {
                    ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(true);
                }
            }
        }

        _cls3()
        {
            this$0 = WebFragment.this;
            wv = webview;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final WebFragment this$0;
        final WebView val$wv;

        public void onClick(View view)
        {
            wv.reload();
            if (getActivity() != null)
            {
                ((SherlockFragmentActivity)getActivity()).setSupportProgressBarIndeterminateVisibility(true);
            }
        }

        _cls4()
        {
            this$0 = WebFragment.this;
            wv = webview;
            super();
        }
    }


    private class _cls5
        implements android.view.View.OnClickListener
    {

        final WebFragment this$0;

        public void onClick(View view)
        {
            view = new HashMap();
            view.put("url", url);
            FlurryAgent.logEvent("action:share_web", view);
            view = new Intent("android.intent.action.SEND");
            view.setType("text/plain");
            view.putExtra("android.intent.extra.TEXT", url);
            startActivity(Intent.createChooser(view, null));
        }

        _cls5()
        {
            this$0 = WebFragment.this;
            super();
        }
    }

}
