// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.browser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.openx.common.utils.helpers.Utils;
import com.openx.core.sdk.OXMManagersResolver;
import com.openx.sdk.event.OXMEvent;
import com.openx.sdk.event.OXMEventsHandler;
import com.openx.sdk.event.OXMEventsListener;
import com.openx.view.WebViewBase;

// Referenced classes of package com.openx.sdk.browser:
//            BrowserControls, BrowserControlsEventsListener

public final class AdBrowserActivity extends Activity
{

    private static final int BROWSER_CONTROLS_ID = 0x39917;
    public static final String EXTRA_AD = "EXTRA_AD";
    public static final String EXTRA_AD_EVENTS_LISTENER = "AD_EVENTS_LISTENER";
    public static final String EXTRA_AD_MODEL = "EXTRA_AD_MODEL";
    public static final String EXTRA_ALLOW_ORIENTATION_CHANGES = "EXTRA_ALLOW_ORIENTATION_CHANGES";
    public static final String EXTRA_CONTROLLER_ID = "EXTRA_CONTROLLER_ID";
    public static final String EXTRA_DIM_COLOR = "EXTRA_DIM_COLOR";
    public static final String EXTRA_FORCE_ORIENTATION = "EXTRA_FORCE_ORIENTATION";
    public static final String EXTRA_HAS_CLOSE_BUTTON = "EXTRA_HAS_CLOSE_BUTTON";
    public static final String EXTRA_HEIGHT = "EXTRA_HEIGHT";
    public static final String EXTRA_IS_EXPANDED = "EXTRA_IS_EXPANDED";
    public static final String EXTRA_IS_INTERSTITIAL = "EXTRA_IS_INTERSTITIAL";
    public static final String EXTRA_IS_VIDEO = "EXTRA_IS_VIDEO";
    public static final String EXTRA_LONG_CLOSING_CYCLE = "EXTRA_LONG_CLOSING_CYCLE";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_WIDTH = "EXTRA_WIDTH";
    private static final int WEB_VIEW_ID = 0x3989e;
    private OXMEventsListener eventsManager;
    private BrowserControls mBrowserControls;
    private int mDefinedHeightForExpand;
    private int mDefinedWidthForExpand;
    private boolean mIsExpanded;
    private boolean mIsVideo;
    private OXMEventsHandler mOrientationPropertiesEventListener;
    private VideoView mVideoView;
    private WebView mWebView;
    WebViewBase webViewBase;

    public AdBrowserActivity()
    {
    }

    private boolean getIsExpanded()
    {
        return mIsExpanded;
    }

    private OXMEventsHandler getOrientationPropertiesEventListener()
    {
        return mOrientationPropertiesEventListener;
    }

    private void init()
    {
        Object obj1 = getIntent().getExtras();
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        if (Utils.atLeastHoneycomb())
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        getWindow().setSoftInputMode(6);
        Object obj;
        boolean flag;
        if (getIntent().hasExtra("EXTRA_URL"))
        {
            obj = ((Bundle) (obj1)).getString("EXTRA_URL");
        } else
        {
            obj = null;
        }
        if (getIntent().hasExtra("EXTRA_IS_VIDEO"))
        {
            flag = ((Bundle) (obj1)).getBoolean("EXTRA_IS_VIDEO");
        } else
        {
            flag = false;
        }
        mIsVideo = flag;
        if (mIsVideo)
        {
            mVideoView = new VideoView(this);
            obj1 = new RelativeLayout(this);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(13);
            ((RelativeLayout) (obj1)).addView(mVideoView, layoutparams);
            setContentView(((View) (obj1)));
            obj1 = new MediaController(this);
            mVideoView.setMediaController(((MediaController) (obj1)));
            mVideoView.setVideoURI(Uri.parse(((String) (obj))));
            mVideoView.start();
            return;
        }
        obj1 = null;
        initBrowserControls();
        RelativeLayout relativelayout = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = null;
        Object obj2 = null;
        android.widget.RelativeLayout.LayoutParams layoutparams2;
        int i;
        int j;
        if (mDefinedWidthForExpand == 0)
        {
            i = -1;
        } else
        {
            i = mDefinedWidthForExpand;
        }
        if (mDefinedHeightForExpand == 0)
        {
            j = -1;
        } else
        {
            j = mDefinedHeightForExpand;
        }
        layoutparams2 = new android.widget.RelativeLayout.LayoutParams(i, j);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            mWebView = new WebView(this);
            setWebViewSettings();
            mWebView.loadUrl(((String) (obj)));
            mWebView.setWebViewClient(new WebViewClient() {

                final AdBrowserActivity this$0;

                public void onPageFinished(WebView webview, String s)
                {
                    if (mBrowserControls != null)
                    {
                        mBrowserControls.updateNavigationButtonsState();
                    }
                    super.onPageFinished(webview, s);
                }

                public boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    if (s.startsWith("http"))
                    {
                        return super.shouldOverrideUrlLoading(webview, s);
                    }
                    if (mBrowserControls != null)
                    {
                        mBrowserControls.openURLInExternalBrowser(s);
                        return true;
                    } else
                    {
                        return super.shouldOverrideUrlLoading(webview, s);
                    }
                }

            
            {
                this$0 = AdBrowserActivity.this;
                super();
            }
            });
            obj = obj2;
            if (!getIsExpanded())
            {
                obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
                if (mBrowserControls != null)
                {
                    mBrowserControls.showNavigationControls();
                }
                layoutparams2.addRule(3, 0x39917);
            }
            obj1 = mWebView;
            layoutparams1 = ((android.widget.RelativeLayout.LayoutParams) (obj));
        }
        if (obj1 != null)
        {
            ((View) (obj1)).setId(0x3989e);
            relativelayout.addView(((View) (obj1)), layoutparams2);
        }
        if (true && mBrowserControls != null)
        {
            relativelayout.addView(mBrowserControls, layoutparams1);
        }
        setContentView(relativelayout);
        eventsManager = OXMManagersResolver.getInstance().getEventsManager();
        eventsManager.registerEventListener(com.openx.sdk.event.OXMEvent.OXMEventType.ORIENTATION_PROPERTIES_CHANGED, getOrientationPropertiesEventListener());
    }

    private void initBrowserControls()
    {
        BrowserControls browsercontrols = new BrowserControls(this, new BrowserControlsEventsListener() {

            final AdBrowserActivity this$0;

            public boolean canGoBack()
            {
                return mWebView.canGoBack();
            }

            public boolean canGoForward()
            {
                return mWebView.canGoForward();
            }

            public void closeBrowser()
            {
                eventsManager.fireEvent(new OXMEvent(com.openx.sdk.event.OXMEvent.OXMEventType.CLOSE_ACTIVE_INTERNAL_WINDOW, this, null));
                finish();
            }

            public String getCurrentURL()
            {
                if (mWebView != null)
                {
                    return mWebView.getUrl();
                } else
                {
                    return null;
                }
            }

            public void onGoBack()
            {
                if (mWebView != null)
                {
                    mWebView.goBack();
                }
            }

            public void onGoForward()
            {
                if (mWebView != null)
                {
                    mWebView.goForward();
                }
            }

            public void onRelaod()
            {
                if (mWebView != null)
                {
                    mWebView.reload();
                }
            }

            public void setCreatorOfView(Object obj)
            {
            }

            
            {
                this$0 = AdBrowserActivity.this;
                super();
            }
        });
        browsercontrols.setId(0x39917);
        mBrowserControls = browsercontrols;
    }

    private void setWebViewSettings()
    {
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        mWebView.getSettings().setPluginState(android.webkit.WebSettings.PluginState.OFF);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.getSettings().setCacheMode(2);
        mWebView.getSettings().setBuiltInZoomControls(true);
        if (Utils.atLeastHoneycomb())
        {
            mWebView.getSettings().setDisplayZoomControls(false);
        }
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
    }

    public void onBackPressed()
    {
        if (mIsVideo)
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle.getBoolean("EXTRA_IS_VIDEO") || bundle.containsKey("EXTRA_URL"))
        {
            init();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mIsVideo)
        {
            if (mVideoView != null)
            {
                mVideoView.stopPlayback();
            }
            return;
        }
        OXMEventsListener oxmeventslistener = OXMManagersResolver.getInstance().getEventsManager();
        if (mBrowserControls != null)
        {
            mBrowserControls.dispose();
        }
        oxmeventslistener.unregisterEventListener(com.openx.sdk.event.OXMEvent.OXMEventType.ORIENTATION_PROPERTIES_CHANGED, getOrientationPropertiesEventListener());
    }

    protected void onPause()
    {
        super.onPause();
        if (mVideoView != null)
        {
            mVideoView.suspend();
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (mVideoView != null)
        {
            mVideoView.resume();
        }
    }



}
