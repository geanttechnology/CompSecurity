// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushMessage;
import com.urbanairship.util.ManifestUtils;
import com.urbanairship.widget.UAWebView;

public class LandingPageActivity extends Activity
{

    public static final String LANDING_PAGE_BACKGROUND_COLOR = "com.urbanairship.LANDING_PAGE_BACKGROUND_COLOR";
    private static final long LANDING_PAGE_RETRY_DELAY_MS = 20000L;
    public static final String LANDING_PAGE_VIEW_KEY = "com.urbanairship.action.LANDING_PAGE_VIEW";
    private Integer error;
    private Handler handler;
    private Uri uri;
    private UAWebView webView;
    private int webViewBackgroundColor;

    public LandingPageActivity()
    {
        error = null;
        webViewBackgroundColor = -1;
    }

    private View createDefaultLandingPageView()
    {
        FrameLayout framelayout = new FrameLayout(this);
        Object obj = new UAWebView(this);
        ((UAWebView) (obj)).setId(0x102000c);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.gravity = 17;
        framelayout.addView(((View) (obj)), layoutparams);
        obj = new ProgressBar(this);
        ((ProgressBar) (obj)).setIndeterminate(true);
        ((ProgressBar) (obj)).setId(0x102000d);
        layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        framelayout.addView(((View) (obj)), layoutparams);
        return framelayout;
    }

    private void crossFade(View view, final View out)
    {
        if (android.os.Build.VERSION.SDK_INT < 12)
        {
            if (view != null)
            {
                view.setVisibility(0);
            }
            if (out != null)
            {
                out.setVisibility(8);
            }
        } else
        {
            if (view != null)
            {
                view.animate().alpha(1.0F).setDuration(200L);
            }
            if (out != null)
            {
                out.animate().alpha(0.0F).setDuration(200L).setListener(new _cls2());
                return;
            }
        }
    }

    private void restartActivity(Uri uri1, Bundle bundle)
    {
        Logger.debug("Relaunching activity");
        finish();
        uri1 = (new Intent()).setClass(this, getClass()).setData(uri1).setFlags(0x10000000);
        if (bundle != null)
        {
            uri1.putExtras(bundle);
        }
        startActivity(uri1);
    }

    protected void loadLandingPage()
    {
        loadLandingPage(0L);
    }

    protected void loadLandingPage(long l)
    {
        if (webView == null)
        {
            return;
        }
        webView.stopLoading();
        if (l > 0L)
        {
            handler.postAtTime(new _cls3(), uri, SystemClock.uptimeMillis() + l);
            return;
        }
        Logger.info((new StringBuilder("Loading landing page: ")).append(uri).toString());
        if (webViewBackgroundColor != -1)
        {
            webView.setBackgroundColor(webViewBackgroundColor);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webView.setLayerType(1, null);
        }
        error = null;
        if (uri.getScheme().equalsIgnoreCase("message"))
        {
            String s = uri.getSchemeSpecificPart();
            RichPushMessage richpushmessage = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(s);
            if (richpushmessage != null)
            {
                webView.loadRichPushMessage(richpushmessage);
                richpushmessage.markRead();
                return;
            } else
            {
                Logger.error((new StringBuilder("Message ")).append(s).append(" not found.").toString());
                finish();
                return;
            }
        } else
        {
            webView.loadUrl(uri.toString());
            return;
        }
    }

    public void onCloseButtonClick(View view)
    {
        finish();
    }

    public final void onCreate(final Bundle progressBar)
    {
        super.onCreate(progressBar);
        Autopilot.automaticTakeOff(getApplication());
        Logger.debug("Creating landing page activity.");
        Intent intent = getIntent();
        if (intent == null)
        {
            Logger.warn("LandingPageActivity - Started activity with null intent");
            finish();
            return;
        }
        progressBar = ManifestUtils.getActivityInfo(getClass());
        if (progressBar == null || ((ActivityInfo) (progressBar)).metaData == null)
        {
            progressBar = new Bundle();
        } else
        {
            progressBar = ((ActivityInfo) (progressBar)).metaData;
        }
        webViewBackgroundColor = progressBar.getInt("com.urbanairship.LANDING_PAGE_BACKGROUND_COLOR", -1);
        handler = new Handler();
        uri = intent.getData();
        if (uri == null)
        {
            Logger.warn("LandingPageActivity - No landing page uri to load.");
            finish();
            return;
        }
        int i = progressBar.getInt("com.urbanairship.action.LANDING_PAGE_VIEW", -1);
        if (i != -1)
        {
            setContentView(i);
        } else
        {
            setContentView(createDefaultLandingPageView());
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            progressBar = getActionBar();
            if (progressBar != null)
            {
                progressBar.setDisplayOptions(4, 4);
            }
        }
        webView = (UAWebView)findViewById(0x102000c);
        progressBar = (ProgressBar)findViewById(0x102000d);
        if (webView != null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                webView.setAlpha(0.0F);
            } else
            {
                webView.setVisibility(4);
            }
            webView.setWebViewClient(new _cls1());
            return;
        } else
        {
            Logger.error("LandingPageActivity - A UAWebView with id android.R.id.primary is not defined in the custom layout.  Unable to show the landing page.");
            finish();
            return;
        }
    }

    public void onNewIntent(Intent intent)
    {
        Logger.debug("LandingPageActivity - New intent received for landing page");
        restartActivity(intent.getData(), intent.getExtras());
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return false;
        }
    }

    public void onPause()
    {
        super.onPause();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webView.onPause();
        }
        webView.stopLoading();
        handler.removeCallbacksAndMessages(uri);
    }

    public void onResume()
    {
        super.onResume();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webView.onResume();
        }
        loadLandingPage();
    }

    protected void onStart()
    {
        super.onStart();
        Analytics.activityStarted(this);
    }

    protected void onStop()
    {
        super.onStop();
        Analytics.activityStopped(this);
    }



/*
    static Integer access$002(LandingPageActivity landingpageactivity, Integer integer)
    {
        landingpageactivity.error = integer;
        return integer;
    }

*/




    private class _cls2 extends AnimatorListenerAdapter
    {

        final LandingPageActivity this$0;
        final View val$out;

        public void onAnimationEnd(Animator animator)
        {
            out.setVisibility(8);
        }

        _cls2()
        {
            this$0 = LandingPageActivity.this;
            out = view;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final LandingPageActivity this$0;

        public void run()
        {
            loadLandingPage(0L);
        }

        _cls3()
        {
            this$0 = LandingPageActivity.this;
            super();
        }
    }


    private class _cls1 extends UAWebViewClient
    {

        final LandingPageActivity this$0;
        final ProgressBar val$progressBar;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (error != null)
            {
                switch (error.intValue())
                {
                default:
                    error = null;
                    webView.loadData("", "text/html", null);
                    return;

                case -8: 
                case -6: 
                case -1: 
                    loadLandingPage(20000L);
                    break;
                }
                return;
            }
            if (webViewBackgroundColor != -1)
            {
                webView.setBackgroundColor(webViewBackgroundColor);
            }
            crossFade(webView, progressBar);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            if (s1 != null && s1.equals(getIntent().getDataString()))
            {
                Logger.error((new StringBuilder("LandingPageActivity - Failed to load page ")).append(s1).append(" with error ").append(i).append(" ").append(s).toString());
                error = Integer.valueOf(i);
            }
        }

        _cls1()
        {
            this$0 = LandingPageActivity.this;
            progressBar = progressbar;
            super();
        }
    }

}
