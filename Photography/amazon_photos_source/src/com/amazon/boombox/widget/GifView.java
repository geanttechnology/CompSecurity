// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GifView extends RelativeLayout
{
    public static interface GifListener
    {

        public abstract void onReady();
    }


    private static final String TAG = com/amazon/boombox/widget/GifView.getName();
    private final List mGifListeners;
    private boolean mReady;
    private WebView mWebView;

    public GifView(Context context)
    {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GifView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mReady = false;
        mGifListeners = new ArrayList();
        if (isInEditMode())
        {
            showEditModeView(context);
        } else
        {
            mWebView = new WebView(context);
            mWebView.setWebViewClient(new WebViewClient() {

                final GifView this$0;

                public void onPageFinished(WebView webview, String s)
                {
                    webview = mGifListeners;
                    webview;
                    JVM INSTR monitorenter ;
                    mReady = true;
                    for (s = mGifListeners.iterator(); s.hasNext(); ((GifListener)s.next()).onReady()) { }
                    break MISSING_BLOCK_LABEL_63;
                    s;
                    webview;
                    JVM INSTR monitorexit ;
                    throw s;
                    webview;
                    JVM INSTR monitorexit ;
                }

            
            {
                this$0 = GifView.this;
                super();
            }
            });
            mWebView.setBackgroundColor(0);
            mWebView.setVerticalScrollBarEnabled(false);
            mWebView.setHorizontalScrollBarEnabled(false);
            mWebView.setVerticalFadingEdgeEnabled(false);
            mWebView.setHorizontalFadingEdgeEnabled(false);
            mWebView.setOverScrollMode(2);
            addView(mWebView, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            if (attributeset != null)
            {
                context = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.amazon.boombox", "uri");
                if (context != null)
                {
                    setImageUri(Uri.parse(context));
                    return;
                }
            }
        }
    }

    private static String encodeSpecicalCharacters(String s)
    {
        return (new String(s)).replaceAll("_", "%5F").replaceAll("!", "%21").replaceAll("~", "%7E").replaceAll("'", "%27").replaceAll("\\(", "%28").replaceAll("\\)", "%29").replaceAll("\\*", "%2A");
    }

    private static String getHtmlString(Uri uri)
    {
        uri = encodeSpecicalCharacters(uri.toString());
        return (new StringBuilder()).append("<html><head><style>html {background: url(").append(uri).append(") no-repeat center center; background-size: contain; } </style></head><body></body></html>").toString();
    }

    private void showEditModeView(Context context)
    {
        context = new TextView(context);
        context.setText(com/amazon/boombox/widget/GifView.getName());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13, -1);
        addView(context, layoutparams);
    }

    public void setImageUri(Uri uri)
    {
        uri = getHtmlString(uri);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadDataWithBaseURL(null, uri, "text/html", "utf-8", null);
    }




/*
    static boolean access$102(GifView gifview, boolean flag)
    {
        gifview.mReady = flag;
        return flag;
    }

*/
}
