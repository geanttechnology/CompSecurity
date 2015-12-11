// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.device.ads:
//            IAdActivityAdapter, ThreadUtils, WebViewFactory, AndroidTargetUtils, 
//            Settings, Log, Assets, Utils, 
//            AdActivity, AdUtils

class MraidBrowser
    implements IAdActivityAdapter
{
    class LoadButtonsTask extends AsyncTask
    {

        private final int buttonHeight;
        private final int buttonWidth;
        private final Intent intent;
        private final ViewGroup layout;
        final MraidBrowser this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mBrowserBackButton = createButton(Assets.getInstance().getFilePath("amazon_ads_leftarrow.png"), 9, -1, buttonWidth, buttonHeight);
            mBrowserBackButton.setId(10537);
            mBrowserForwardButton = createButton(Assets.getInstance().getFilePath("amazon_ads_rightarrow.png"), 1, mBrowserBackButton.getId(), buttonWidth, buttonHeight);
            mBrowserForwardButton.setId(10794);
            mCloseButton = createButton(Assets.getInstance().getFilePath("amazon_ads_close.png"), 11, -1, buttonWidth, buttonHeight);
            if (showOpenExternalBrowserButton)
            {
                mOpenExternalBrowserButton = createButton(Assets.getInstance().getFilePath("amazon_ads_open_external_browser.png"), 1, mBrowserForwardButton.getId(), buttonWidth, buttonHeight);
                mOpenExternalBrowserButton.setId(10795);
                mRefreshButton = createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, mOpenExternalBrowserButton.getId(), buttonWidth, buttonHeight);
            } else
            {
                mRefreshButton = createButton(Assets.getInstance().getFilePath("amazon_ads_refresh.png"), 1, mBrowserForwardButton.getId(), buttonWidth, buttonHeight);
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            layout.addView(mBrowserBackButton);
            layout.addView(mBrowserForwardButton);
            layout.addView(mRefreshButton);
            layout.addView(mCloseButton);
            if (showOpenExternalBrowserButton)
            {
                layout.addView(mOpenExternalBrowserButton);
            }
            initializeButtons(intent);
        }

        public LoadButtonsTask(Intent intent1, ViewGroup viewgroup, int i, int j)
        {
            this$0 = MraidBrowser.this;
            super();
            intent = intent1;
            layout = viewgroup;
            buttonWidth = i;
            buttonHeight = j;
        }
    }

    static class MraidBrowserBuilder
    {

        private static final String LOGTAG = com/amazon/device/ads/MraidBrowser$MraidBrowserBuilder.getSimpleName();
        private Context context;
        private boolean showOpenExternalBrowserButton;
        private String url;

        void show()
        {
            if (context == null)
            {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (Utils.isNullOrWhiteSpace(url))
            {
                throw new IllegalArgumentException("Url must not be null or white space");
            }
            if (!Assets.getInstance().ensureAssetsCreated())
            {
                Log.e(LOGTAG, "Could not load application assets, failed to open URI: %s", new Object[] {
                    url
                });
                return;
            } else
            {
                Intent intent = new Intent(context, com/amazon/device/ads/AdActivity);
                intent.putExtra("adapter", com/amazon/device/ads/MraidBrowser.getName());
                intent.putExtra("extra_url", url);
                intent.putExtra("extra_open_btn", showOpenExternalBrowserButton);
                intent.addFlags(0x10000000);
                context.startActivity(intent);
                return;
            }
        }

        MraidBrowserBuilder withContext(Context context1)
        {
            context = context1;
            return this;
        }

        MraidBrowserBuilder withExternalBrowserButton()
        {
            showOpenExternalBrowserButton = true;
            return this;
        }

        MraidBrowserBuilder withUrl(String s)
        {
            url = s;
            return this;
        }


        MraidBrowserBuilder()
        {
        }
    }


    private static final int BUTTON_SIZE_DP = 50;
    private static final int HORIZONTAL_RULE_SIZE_DP = 3;
    protected static final String LOG_TAG = com/amazon/device/ads/MraidBrowser.getSimpleName();
    protected static final String SHOW_OPEN_EXTERNAL_BROWSER_BTN = "extra_open_btn";
    protected static final String URL_EXTRA = "extra_url";
    private Activity activity;
    private ImageButton mBrowserBackButton;
    private ImageButton mBrowserForwardButton;
    private ImageButton mCloseButton;
    private ImageButton mOpenExternalBrowserButton;
    private ImageButton mRefreshButton;
    private WebView mWebView;
    private boolean showOpenExternalBrowserButton;

    MraidBrowser()
    {
    }

    private ImageButton createButton(String s, int i, int j, int k, int l)
    {
        ImageButton imagebutton = new ImageButton(activity);
        imagebutton.setImageBitmap(BitmapFactory.decodeFile(s));
        s = new android.widget.RelativeLayout.LayoutParams(k, l);
        s.addRule(i, j);
        s.addRule(12);
        imagebutton.setLayoutParams(s);
        imagebutton.setBackgroundColor(0);
        imagebutton.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        return imagebutton;
    }

    private void enableCookies()
    {
        CookieSyncManager.createInstance(activity);
        CookieSyncManager.getInstance().startSync();
    }

    private void initializeButtons(final Intent intent)
    {
        mBrowserBackButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MraidBrowser this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoBack())
                {
                    mWebView.goBack();
                }
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
        mBrowserForwardButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MraidBrowser this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoForward())
                {
                    mWebView.goForward();
                }
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
        mRefreshButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MraidBrowser this$0;

            public void onClick(View view)
            {
                mWebView.reload();
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
        mCloseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MraidBrowser this$0;

            public void onClick(View view)
            {
                activity.finish();
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
        if (showOpenExternalBrowserButton)
        {
            mOpenExternalBrowserButton.setOnClickListener(new android.view.View.OnClickListener() {

                final String originalUrl;
                final MraidBrowser this$0;
                final Intent val$intent;

                public void onClick(View view)
                {
                    String s = mWebView.getUrl();
                    view = s;
                    if (s == null)
                    {
                        Log.w(MraidBrowser.LOG_TAG, "The current URL is null. Reverting to the original URL for external browser.");
                        view = originalUrl;
                    }
                    AdUtils.launchActivityForIntentLink(view, mWebView.getContext());
                }

            
            {
                this$0 = MraidBrowser.this;
                intent = intent1;
                super();
                originalUrl = intent.getStringExtra("extra_url");
            }
            });
        }
    }

    private void initializeEntireView(Intent intent)
    {
        Object obj = new DisplayMetrics();
        ((WindowManager)activity.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        float f = ((DisplayMetrics) (obj)).density;
        int k = (int)(50F * f + 0.5F);
        int l = (int)(3F * f + 0.5F);
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int i;
        int j;
        if (showOpenExternalBrowserButton)
        {
            i = 5;
        } else
        {
            i = 4;
        }
        j = ((DisplayMetrics) (obj)).widthPixels / i;
        i = j;
        if (j > k * 2)
        {
            i = k * 2;
        }
        obj = new RelativeLayout(activity);
        ((RelativeLayout) (obj)).setId(10280);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, k + l);
        layoutparams.addRule(12);
        ((RelativeLayout) (obj)).setLayoutParams(layoutparams);
        ((RelativeLayout) (obj)).setBackgroundColor(0xfff0f0f0);
        ThreadUtils.executeAsyncTask(new LoadButtonsTask(intent, ((ViewGroup) (obj)), i, k), new Void[0]);
        intent = new View(activity);
        intent.setBackgroundColor(0xffcccccc);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, l);
        layoutparams.addRule(10);
        intent.setLayoutParams(layoutparams);
        ((RelativeLayout) (obj)).addView(intent);
        mWebView = WebViewFactory.getInstance().createWebView(activity);
        intent = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        intent.addRule(2, ((RelativeLayout) (obj)).getId());
        mWebView.setLayoutParams(intent);
        intent = new RelativeLayout(activity);
        intent.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        intent.addView(mWebView);
        intent.addView(((View) (obj)));
        obj = new LinearLayout(activity);
        ((LinearLayout) (obj)).setOrientation(1);
        ((LinearLayout) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        ((LinearLayout) (obj)).addView(intent);
        activity.setContentView(((View) (obj)));
    }

    private void initializeWebView(Intent intent)
    {
        WebViewFactory.setJavaScriptEnabledForWebView(true, mWebView, LOG_TAG);
        mWebView.loadUrl(intent.getStringExtra("extra_url"));
        mWebView.setWebViewClient(new WebViewClient() {

            final MraidBrowser this$0;

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                Log.w(MraidBrowser.LOG_TAG, "MRAID error: %s", new Object[] {
                    s
                });
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                while (s == null || !s.startsWith("market:") && !s.startsWith("tel:") && !s.startsWith("voicemail:") && !s.startsWith("sms:") && !s.startsWith("mailto:") && !s.startsWith("geo:") && !s.startsWith("google.streetview:")) 
                {
                    return false;
                }
                try
                {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    Log.w(MraidBrowser.LOG_TAG, "Could not handle intent with URI: %s", new Object[] {
                        s
                    });
                }
                return true;
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {

            final MraidBrowser this$0;

            public void onProgressChanged(WebView webview, int i)
            {
                Activity activity1 = (Activity)webview.getContext();
                activity1.setTitle("Loading...");
                activity1.setProgress(i * 100);
                if (i == 100)
                {
                    activity1.setTitle(webview.getUrl());
                }
                updateNavigationButtons(webview);
            }

            
            {
                this$0 = MraidBrowser.this;
                super();
            }
        });
    }

    private void updateNavigationButtons(WebView webview)
    {
label0:
        {
            if (mBrowserBackButton != null && mBrowserForwardButton != null)
            {
                if (webview.canGoBack())
                {
                    AndroidTargetUtils.setImageButtonAlpha(mBrowserBackButton, 255);
                } else
                {
                    AndroidTargetUtils.setImageButtonAlpha(mBrowserBackButton, 102);
                }
                if (!webview.canGoForward())
                {
                    break label0;
                }
                AndroidTargetUtils.setImageButtonAlpha(mBrowserForwardButton, 255);
            }
            return;
        }
        AndroidTargetUtils.setImageButtonAlpha(mBrowserForwardButton, 102);
    }

    protected boolean canPauseWebViewTimers()
    {
        return getWebView() != null && getShouldPauseWebViewTimers();
    }

    protected boolean canResumeWebViewTimers()
    {
        return getWebView() != null && getShouldPauseWebViewTimers();
    }

    protected boolean getShouldPauseWebViewTimers()
    {
        return Settings.getInstance().getBoolean("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
    }

    protected WebView getWebView()
    {
        return mWebView;
    }

    protected boolean isAtLeastAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public void onCreate()
    {
        activity.getWindow().requestFeature(2);
        activity.getWindow().setFeatureInt(2, -1);
        Intent intent = activity.getIntent();
        showOpenExternalBrowserButton = intent.getBooleanExtra("extra_open_btn", false);
        initializeEntireView(intent);
        initializeWebView(intent);
        enableCookies();
    }

    public void onPause()
    {
        Log.d(LOG_TAG, "onPause");
        WebView webview = getWebView();
        if (isAtLeastAndroidAPI(11))
        {
            webViewOnPause(webview);
        } else
        {
            Log.w(LOG_TAG, "Unable to call WebView.onPause");
        }
        if (canPauseWebViewTimers())
        {
            webview.pauseTimers();
        }
        CookieSyncManager.getInstance().stopSync();
    }

    public void onResume()
    {
        Log.d(LOG_TAG, "onResume");
        WebView webview = getWebView();
        if (isAtLeastAndroidAPI(11))
        {
            webViewOnResume(webview);
        } else
        {
            Log.w(LOG_TAG, "Unable to call WebView.onResume");
        }
        if (canResumeWebViewTimers())
        {
            webview.resumeTimers();
        }
        CookieSyncManager.getInstance().startSync();
    }

    public void onStop()
    {
    }

    public void preOnCreate()
    {
    }

    public void setActivity(Activity activity1)
    {
        activity = activity1;
    }

    protected void webViewOnPause(WebView webview)
    {
        AndroidTargetUtils.webViewOnPause(webview);
    }

    protected void webViewOnResume(WebView webview)
    {
        AndroidTargetUtils.webViewOnResume(webview);
    }








/*
    static ImageButton access$302(MraidBrowser mraidbrowser, ImageButton imagebutton)
    {
        mraidbrowser.mBrowserBackButton = imagebutton;
        return imagebutton;
    }

*/




/*
    static ImageButton access$502(MraidBrowser mraidbrowser, ImageButton imagebutton)
    {
        mraidbrowser.mBrowserForwardButton = imagebutton;
        return imagebutton;
    }

*/



/*
    static ImageButton access$602(MraidBrowser mraidbrowser, ImageButton imagebutton)
    {
        mraidbrowser.mCloseButton = imagebutton;
        return imagebutton;
    }

*/




/*
    static ImageButton access$802(MraidBrowser mraidbrowser, ImageButton imagebutton)
    {
        mraidbrowser.mOpenExternalBrowserButton = imagebutton;
        return imagebutton;
    }

*/



/*
    static ImageButton access$902(MraidBrowser mraidbrowser, ImageButton imagebutton)
    {
        mraidbrowser.mRefreshButton = imagebutton;
        return imagebutton;
    }

*/
}
