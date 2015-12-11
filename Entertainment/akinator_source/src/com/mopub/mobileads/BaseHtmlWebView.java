// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;

// Referenced classes of package com.mopub.mobileads:
//            BaseWebView, ViewGestureDetector

public class BaseHtmlWebView extends BaseWebView
    implements ViewGestureDetector.UserClickListener
{

    private boolean mClicked;
    private final ViewGestureDetector mViewGestureDetector;

    public BaseHtmlWebView(Context context, AdReport adreport)
    {
        super(context);
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        mViewGestureDetector = new ViewGestureDetector(context, this, adreport);
        mViewGestureDetector.setUserClickListener(this);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH))
        {
            enablePlugins(true);
        }
        setBackgroundColor(0);
    }

    private void disableScrollingAndZoom()
    {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    public void init(boolean flag)
    {
        initializeOnTouchListener(flag);
    }

    void initializeOnTouchListener(final boolean isScrollable)
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final BaseHtmlWebView this$0;
            final boolean val$isScrollable;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                mViewGestureDetector.sendTouchEvent(motionevent);
                return motionevent.getAction() == 2 && !isScrollable;
            }

            
            {
                this$0 = BaseHtmlWebView.this;
                isScrollable = flag;
                super();
            }
        });
    }

    void loadHtmlResponse(String s)
    {
        loadDataWithBaseURL("http://ads.mopub.com/", s, "text/html", "utf-8", null);
    }

    public void loadUrl(String s)
    {
        if (s != null)
        {
            MoPubLog.d((new StringBuilder()).append("Loading url: ").append(s).toString());
            if (s.startsWith("javascript:"))
            {
                super.loadUrl(s);
                return;
            }
        }
    }

    public void onResetUserClick()
    {
        mClicked = false;
    }

    public void onUserClick()
    {
        mClicked = true;
    }

    public boolean wasClicked()
    {
        return mClicked;
    }

}
