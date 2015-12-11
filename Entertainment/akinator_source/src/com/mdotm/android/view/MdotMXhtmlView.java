// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.model.MdotMAdResponse;
import com.mdotm.android.utils.MdotMLogger;

// Referenced classes of package com.mdotm.android.view:
//            MdotMWebView

public class MdotMXhtmlView extends RelativeLayout
{

    private ProgressBar activityIndicator;
    private boolean adSelectionInProgress;
    private int deviceHeight;
    private int deviceWidth;
    Handler handler;
    private MdotMAdActionListener mActionListener;
    private MdotMAdResponse mAdResponse;
    private WebView webView;
    private MdotMWebView webView1;

    public MdotMXhtmlView(Context context, MdotMAdResponse mdotmadresponse, MdotMAdActionListener mdotmadactionlistener)
    {
        super(context);
        webView = null;
        MdotMLogger.i(this, "html resource HtmlView");
        handler = new Handler();
        mActionListener = mdotmadactionlistener;
        mAdResponse = mdotmadresponse;
        getHeightAndWidth();
        mdotmadresponse = new android.widget.RelativeLayout.LayoutParams(getDevWidth(), getDevHeight());
        mdotmadresponse.addRule(2);
        mdotmadresponse.addRule(13);
        setLayoutParams(mdotmadresponse);
        setGravity(17);
        activityIndicator = new ProgressBar(getContext());
        activityIndicator.setIndeterminate(false);
        mdotmadresponse = new android.widget.RelativeLayout.LayoutParams(40, 40);
        activityIndicator.setLayoutParams(mdotmadresponse);
        activityIndicator.setVisibility(4);
        activityIndicator.setMinimumHeight(8);
        activityIndicator.setMinimumWidth(8);
        activityIndicator.setMax(100);
        if (activityIndicator != null)
        {
            activityIndicator.setId(3);
            mdotmadresponse.addRule(13);
        }
        addView(activityIndicator);
        webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new _cls1());
        initView(context);
    }

    private void adNetworkCompleted()
    {
        MdotMLogger.i(this, "On ad network completed");
        setAdSelectionInProgress(false);
        hideActivityIndicator();
    }

    private int getDevHeight()
    {
        return deviceHeight - getInDp(25);
    }

    private int getDevWidth()
    {
        return deviceWidth;
    }

    private void getHeightAndWidth()
    {
        Display display = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            deviceWidth = display.getWidth();
            deviceHeight = display.getHeight();
            return;
        } else
        {
            Point point = new Point();
            display.getSize(point);
            deviceWidth = point.x;
            deviceHeight = point.y;
            return;
        }
    }

    private int getInDp(int i)
    {
        float f = getContext().getResources().getDisplayMetrics().density;
        return (int)((float)i * f + 0.5F);
    }

    private int getReducedHeight()
    {
        return deviceHeight - getInDp(25);
    }

    private void hideActivityIndicator()
    {
        post(new _cls3());
    }

    private void initView(Context context)
    {
        webView1 = new MdotMWebView(context, mAdResponse, mActionListener);
        addView(webView1);
        context = new RelativeLayout(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(mAdResponse.getWidth(), mAdResponse.getHeight());
        layoutparams.addRule(13);
        context.setLayoutParams(layoutparams);
        context.setBackgroundColor(0);
        addView(context);
    }

    private boolean isAdSelectionInProgress()
    {
        return adSelectionInProgress;
    }

    private void setAdSelectionInProgress(boolean flag)
    {
        adSelectionInProgress = flag;
    }

    private void showActivityIndicator()
    {
        post(new _cls2());
    }

    protected void clicked(Context context)
    {
        MdotMLogger.i(this, "  Selected to clicked  ");
        if (mAdResponse.getLandingUrl() != null)
        {
            if (!isAdSelectionInProgress())
            {
                context = mAdResponse.getLandingUrl();
                setAdSelectionInProgress(true);
                showActivityIndicator();
                (new _cls4(context)).start();
                return;
            } else
            {
                MdotMLogger.i(this, "ad selection under progress");
                return;
            }
        } else
        {
            MdotMLogger.i(this, "selected ad is null");
            return;
        }
    }

    public void loadblankview()
    {
        webView1.loadblankview();
    }







    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}

}
