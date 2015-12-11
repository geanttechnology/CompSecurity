// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2 extends PullToRefreshWebView
{

    static final String DEF_JS_READY_PULL_DOWN_CALL = "javascript:isReadyForPullDown();";
    static final String DEF_JS_READY_PULL_UP_CALL = "javascript:isReadyForPullUp();";
    static final String JS_INTERFACE_PKG = "ptr";
    private final AtomicBoolean mIsReadyForPullDown;
    private final AtomicBoolean mIsReadyForPullUp;
    private JsValueCallback mJsCallback;

    public PullToRefreshWebView2(Context context)
    {
        super(context);
        mIsReadyForPullDown = new AtomicBoolean(false);
        mIsReadyForPullUp = new AtomicBoolean(false);
    }

    public PullToRefreshWebView2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsReadyForPullDown = new AtomicBoolean(false);
        mIsReadyForPullUp = new AtomicBoolean(false);
    }

    public PullToRefreshWebView2(Context context, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
    {
        super(context, mode);
        mIsReadyForPullDown = new AtomicBoolean(false);
        mIsReadyForPullUp = new AtomicBoolean(false);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected WebView createRefreshableView(Context context, AttributeSet attributeset)
    {
        context = super.createRefreshableView(context, attributeset);
        mJsCallback = new JsValueCallback();
        context.addJavascriptInterface(mJsCallback, "ptr");
        return context;
    }

    protected boolean isReadyForPullEnd()
    {
        ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
        return mIsReadyForPullUp.get();
    }

    protected boolean isReadyForPullStart()
    {
        ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
        return mIsReadyForPullDown.get();
    }



    private class JsValueCallback
    {

        final PullToRefreshWebView2 this$0;

        public final void isReadyForPullDownResponse(boolean flag)
        {
            mIsReadyForPullDown.set(flag);
        }

        public final void isReadyForPullUpResponse(boolean flag)
        {
            mIsReadyForPullUp.set(flag);
        }

        JsValueCallback()
        {
            this$0 = PullToRefreshWebView2.this;
            super();
        }
    }

}
