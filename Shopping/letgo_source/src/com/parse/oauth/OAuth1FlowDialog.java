// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.oauth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class OAuth1FlowDialog extends Dialog
{
    public static interface FlowResultHandler
    {

        public abstract void onCancel();

        public abstract void onComplete(String s);

        public abstract void onError(int i, String s, String s1);
    }

    private class OAuth1WebViewClient extends WebViewClient
    {

        final OAuth1FlowDialog this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            try
            {
                progressDialog.dismiss();
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview) { }
            content.setBackgroundColor(0);
            webView.setVisibility(0);
            closeImage.setVisibility(0);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            progressDialog.show();
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            dismiss();
            handler.onError(i, s, s1);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            if (s.startsWith(callbackUrl))
            {
                dismiss();
                handler.onComplete(s);
                return true;
            }
            if (s.contains(serviceUrlIdentifier))
            {
                return false;
            } else
            {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                return true;
            }
        }

        private OAuth1WebViewClient()
        {
            this$0 = OAuth1FlowDialog.this;
            super();
        }

    }


    private static final android.widget.FrameLayout.LayoutParams FILL = new android.widget.FrameLayout.LayoutParams(-1, -1);
    private final String callbackUrl;
    private ImageView closeImage;
    private FrameLayout content;
    private final FlowResultHandler handler;
    private ProgressDialog progressDialog;
    private final String requestUrl;
    private final String serviceUrlIdentifier;
    private WebView webView;

    public OAuth1FlowDialog(Context context, String s, String s1, String s2, FlowResultHandler flowresulthandler)
    {
        super(context, 0x1030010);
        requestUrl = s;
        callbackUrl = s1;
        serviceUrlIdentifier = s2;
        handler = flowresulthandler;
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final OAuth1FlowDialog this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                handler.onCancel();
            }

            
            {
                this$0 = OAuth1FlowDialog.this;
                super();
            }
        });
    }

    private void createCloseImage()
    {
        closeImage = new ImageView(getContext());
        closeImage.setOnClickListener(new android.view.View.OnClickListener() {

            final OAuth1FlowDialog this$0;

            public void onClick(View view)
            {
                cancel();
            }

            
            {
                this$0 = OAuth1FlowDialog.this;
                super();
            }
        });
        Drawable drawable = getContext().getResources().getDrawable(0x1080017);
        closeImage.setImageDrawable(drawable);
        closeImage.setVisibility(4);
    }

    private void setUpWebView(int i)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        webView = new WebView(getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new OAuth1WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(requestUrl);
        webView.setLayoutParams(FILL);
        webView.setVisibility(4);
        linearlayout.setPadding(i, i, i, i);
        linearlayout.addView(webView);
        content.addView(linearlayout);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.requestWindowFeature(1);
        progressDialog.setMessage("Loading...");
        requestWindowFeature(1);
        content = new FrameLayout(getContext());
        createCloseImage();
        setUpWebView(closeImage.getDrawable().getIntrinsicWidth() / 2);
        content.addView(closeImage, new android.view.ViewGroup.LayoutParams(-2, -2));
        addContentView(content, new android.view.ViewGroup.LayoutParams(-1, -1));
    }








}
