// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.MASHWebViewClient;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.web.error.NowErrorBox;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment

public class NowWebViewClient extends MASHWebViewClient
{

    private final Runnable dismissSpinnerTask = new Runnable() {

        final NowWebViewClient this$0;

        public void run()
        {
            forceDismissSpinner();
        }

            
            {
                this$0 = NowWebViewClient.this;
                super();
            }
    };
    protected Context mContext;
    private boolean mShouldShowSpinner;

    public NowWebViewClient(CordovaInterface cordovainterface, MASHWebView mashwebview, MASHNavDelegate mashnavdelegate, MASHUrlIntercepter mashurlintercepter)
    {
        super(cordovainterface, mashwebview, mashnavdelegate, mashurlintercepter);
        mContext = cordovainterface.getActivity();
        mShouldShowSpinner = true;
    }

    private void forceDismissSpinner()
    {
        if (mContext instanceof AmazonActivity)
        {
            ((AmazonActivity)mContext).hideSpinner();
        }
    }

    private void setSpinnerTimeout(long l)
    {
        AndroidPlatform.getInstance().invokeLater(dismissSpinnerTask, l);
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        AndroidPlatform.getInstance().invokeLater(dismissSpinnerTask);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if ((mContext instanceof AmazonActivity) && mShouldShowSpinner)
        {
            setSpinnerTimeout(8000L);
            ((AmazonActivity)mContext).showSpinner();
        }
    }

    public void onReceivedError(final WebView view, int i, final String activity, final String style)
    {
        view.stopLoading();
        view.loadDataWithBaseURL(style, "<html><head><meta charset=\"utf-8\"><meta content=\"maximum-scale=1, user-scalable=no\" name=\"viewport\"><body><div></div><body></html>", "text/html", "UTF-8", style);
        activity = (WebActivity)mContext;
        style = activity.getChromeStyle();
        NowErrorBox nowerrorbox = new NowErrorBox(mContext);
        view = new android.view.View.OnClickListener() {

            final NowWebViewClient this$0;
            final WebActivity val$activity;
            final ChromeStyle val$style;
            final WebView val$view;

            public void onClick(View view1)
            {
                view.reload();
                view1 = (ViewGroup)view.getParent();
                if (view1 != null)
                {
                    view1.removeView(view);
                }
                activity.setRootView(activity.getWebViewHolder(), style);
                activity.error(false);
                activity.getWebFragment().attach();
            }

            
            {
                this$0 = NowWebViewClient.this;
                view = webview;
                activity = webactivity;
                style = chromestyle;
                super();
            }
        };
        ((Button)nowerrorbox.findViewById(0x7f0e008a)).setOnClickListener(view);
        activity.getWebFragment().detach();
        activity.error(true);
        activity.setRootView(nowerrorbox, style);
    }

    public void shouldShowSpinner(boolean flag)
    {
        mShouldShowSpinner = flag;
    }

}
