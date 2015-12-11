// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;

// Referenced classes of package com.mopub.mobileads:
//            BaseWebView, VastResource

class VastWebView extends BaseWebView
{
    static interface VastWebViewClickListener
    {

        public abstract void onVastWebViewClick();
    }

    class VastWebViewOnTouchListener
        implements android.view.View.OnTouchListener
    {

        private boolean mClickStarted;
        final VastWebView this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 37;
               goto _L1 _L2 _L3
_L1:
            return false;
_L2:
            mClickStarted = true;
            return false;
_L3:
            if (mClickStarted)
            {
                mClickStarted = false;
                if (mVastWebViewClickListener != null)
                {
                    mVastWebViewClickListener.onVastWebViewClick();
                    return false;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        VastWebViewOnTouchListener()
        {
            this$0 = VastWebView.this;
            super();
        }
    }


    VastWebViewClickListener mVastWebViewClickListener;

    VastWebView(Context context)
    {
        super(context);
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH))
        {
            enablePlugins(true);
        }
        setBackgroundColor(0);
        setOnTouchListener(new VastWebViewOnTouchListener());
        setId((int)Utils.generateUniqueId());
    }

    static VastWebView createView(Context context, VastResource vastresource)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastresource);
        context = new VastWebView(context);
        vastresource.initializeWebView(context);
        return context;
    }

    private void disableScrollingAndZoom()
    {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    VastWebViewClickListener getVastWebViewClickListener()
    {
        return mVastWebViewClickListener;
    }

    void loadData(String s)
    {
        loadDataWithBaseURL("http://ads.mopub.com/", s, "text/html", "utf-8", null);
    }

    void setVastWebViewClickListener(VastWebViewClickListener vastwebviewclicklistener)
    {
        mVastWebViewClickListener = vastwebviewclicklistener;
    }
}
