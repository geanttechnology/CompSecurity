// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.internal.Utility;

public class WebDialog extends Dialog
{

    static final String CANCEL_URI = "fbconnect://cancel";
    public static final int DEFAULT_THEME = 0x1030010;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    static final String REDIRECT_URI = "fbconnect://success";
    private static final String USER_AGENT = "user_agent";
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private boolean isDetached;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private String url;
    private WebView webView;

    public WebDialog(Context context, String s)
    {
        this(context, s, 0x1030010);
    }

    public WebDialog(Context context, String s, int i)
    {
        super(context, i);
        listenerCalled = false;
        isDetached = false;
        url = s;
    }

    public WebDialog(Context context, String s, Bundle bundle, int i, OnCompleteListener oncompletelistener)
    {
        super(context, i);
        listenerCalled = false;
        isDetached = false;
        context = bundle;
        if (bundle == null)
        {
            context = new Bundle();
        }
        context.putString("display", "touch");
        context.putString("type", "user_agent");
        url = Utility.buildUri("m.facebook.com", (new StringBuilder()).append("dialog/").append(s).toString(), context).toString();
        onCompleteListener = oncompletelistener;
    }

    private void createCrossImage()
    {
        crossImageView = new ImageView(getContext());
        crossImageView.setOnClickListener(new _cls3());
        Drawable drawable = getContext().getResources().getDrawable(com.facebook.android.R.drawable.com_facebook_close);
        crossImageView.setImageDrawable(drawable);
        crossImageView.setVisibility(4);
    }

    private void sendCancelToListener()
    {
        sendErrorToListener(new FacebookOperationCanceledException());
    }

    private void sendErrorToListener(Throwable throwable)
    {
        if (onCompleteListener != null && !listenerCalled)
        {
            listenerCalled = true;
            if (throwable instanceof FacebookException)
            {
                throwable = (FacebookException)throwable;
            } else
            {
                throwable = new FacebookException(throwable);
            }
            onCompleteListener.onComplete(null, throwable);
        }
    }

    private void sendSuccessToListener(Bundle bundle)
    {
        if (onCompleteListener != null && !listenerCalled)
        {
            listenerCalled = true;
            onCompleteListener.onComplete(bundle, null);
        }
    }

    private void setUpWebView(int i)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        webView = new WebView(getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new DialogWebViewClient(null));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        webView.setVisibility(4);
        webView.getSettings().setSavePassword(false);
        linearlayout.setPadding(i, i, i, i);
        linearlayout.addView(webView);
        contentFrameLayout.addView(linearlayout);
    }

    public void dismiss()
    {
        if (webView != null)
        {
            webView.stopLoading();
        }
        if (!isDetached)
        {
            if (spinner.isShowing())
            {
                spinner.dismiss();
            }
            super.dismiss();
        }
    }

    public OnCompleteListener getOnCompleteListener()
    {
        return onCompleteListener;
    }

    public void onAttachedToWindow()
    {
        isDetached = false;
        super.onAttachedToWindow();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setOnCancelListener(new _cls1());
        spinner = new ProgressDialog(getContext());
        spinner.requestWindowFeature(1);
        spinner.setMessage(getContext().getString(com.facebook.android.R.string.com_facebook_loading));
        spinner.setOnCancelListener(new _cls2());
        requestWindowFeature(1);
        contentFrameLayout = new FrameLayout(getContext());
        createCrossImage();
        setUpWebView(crossImageView.getDrawable().getIntrinsicWidth() / 2);
        contentFrameLayout.addView(crossImageView, new android.view.ViewGroup.LayoutParams(-2, -2));
        addContentView(contentFrameLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public void onDetachedFromWindow()
    {
        isDetached = true;
        super.onDetachedFromWindow();
    }

    public void setOnCompleteListener(OnCompleteListener oncompletelistener)
    {
        onCompleteListener = oncompletelistener;
    }









    private class _cls3
        implements android.view.View.OnClickListener
    {

        final WebDialog this$0;

        public void onClick(View view)
        {
            sendCancelToListener();
            dismiss();
        }

        _cls3()
        {
            this$0 = WebDialog.this;
            super();
        }
    }


    private class OnCompleteListener
    {

        public abstract void onComplete(Bundle bundle, FacebookException facebookexception);
    }


    private class DialogWebViewClient extends WebViewClient
    {

        final WebDialog this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (!isDetached)
            {
                spinner.dismiss();
            }
            contentFrameLayout.setBackgroundColor(0);
            webView.setVisibility(0);
            crossImageView.setVisibility(0);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            Utility.logd("FacebookSDK.WebDialog", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
            super.onPageStarted(webview, s, bitmap);
            if (!isDetached)
            {
                spinner.show();
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            sendErrorToListener(new FacebookDialogException(s, i, s1));
            dismiss();
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            sendErrorToListener(new FacebookDialogException(null, -11, null));
            sslerrorhandler.cancel();
            dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Utility.logd("FacebookSDK.WebDialog", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
            if (s.startsWith("fbconnect://success"))
            {
                Bundle bundle = Util.parseUrl(s);
                s = bundle.getString("error");
                webview = s;
                if (s == null)
                {
                    webview = bundle.getString("error_type");
                }
                String s1 = bundle.getString("error_msg");
                s = s1;
                if (s1 == null)
                {
                    s = bundle.getString("error_description");
                }
                s1 = bundle.getString("error_code");
                int i;
                if (!Utility.isNullOrEmpty(s1))
                {
                    try
                    {
                        i = Integer.parseInt(s1);
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        i = -1;
                    }
                } else
                {
                    i = -1;
                }
                if (Utility.isNullOrEmpty(webview) && Utility.isNullOrEmpty(s) && i == -1)
                {
                    sendSuccessToListener(bundle);
                } else
                if (webview != null && (webview.equals("access_denied") || webview.equals("OAuthAccessDeniedException")))
                {
                    sendCancelToListener();
                } else
                {
                    webview = new FacebookRequestError(i, webview, s);
                    sendErrorToListener(new FacebookServiceException(webview, s));
                }
                dismiss();
                return true;
            }
            if (s.startsWith("fbconnect://cancel"))
            {
                sendCancelToListener();
                dismiss();
                return true;
            }
            if (s.contains("touch"))
            {
                return false;
            } else
            {
                getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                return true;
            }
        }

        private DialogWebViewClient()
        {
            this$0 = WebDialog.this;
            super();
        }

        DialogWebViewClient(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.content.DialogInterface.OnCancelListener
    {

        final WebDialog this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            sendCancelToListener();
        }

        _cls1()
        {
            this$0 = WebDialog.this;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnCancelListener
    {

        final WebDialog this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            sendCancelToListener();
            dismiss();
        }

        _cls2()
        {
            this$0 = WebDialog.this;
            super();
        }
    }

}
