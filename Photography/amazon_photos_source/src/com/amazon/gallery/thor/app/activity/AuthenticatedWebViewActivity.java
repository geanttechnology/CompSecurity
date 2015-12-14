// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.metrics.NavigationMetrics;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.auth.mapr5.AuthenticatedWebViewClient;
import com.amazon.gallery.framework.kindle.ftue.ProtectedDialog;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.net.URI;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidSimpleToolbar, GallerySimpleToolbar, GalleryNavigationSetting

public class AuthenticatedWebViewActivity extends BeanAwareActivity
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent ManageStorageLoadFailed;
        public static final MetricsEvent ManageStorageWebViewLoaded;
        public static final MetricsEvent PromotionLoadFailed;
        public static final MetricsEvent PromotionWebViewLoaded;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            PromotionWebViewLoaded = new MetricsEvent("PromotionWebViewLoaded", 0);
            PromotionLoadFailed = new MetricsEvent("PromotionLoadFailed", 1);
            ManageStorageWebViewLoaded = new MetricsEvent("ManageStorageWebViewLoaded", 2);
            ManageStorageLoadFailed = new MetricsEvent("ManageStorageLoadFailed", 3);
            $VALUES = (new MetricsEvent[] {
                PromotionWebViewLoaded, PromotionLoadFailed, ManageStorageWebViewLoaded, ManageStorageLoadFailed
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PageType extends Enum
    {

        private static final PageType $VALUES[];
        public static final PageType DEFAULT;
        public static final PageType MANAGE_STORAGE;
        public static final PageType PROMOTION;

        public static PageType valueOf(String s)
        {
            return (PageType)Enum.valueOf(com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity$PageType, s);
        }

        public static PageType[] values()
        {
            return (PageType[])$VALUES.clone();
        }

        static 
        {
            MANAGE_STORAGE = new PageType("MANAGE_STORAGE", 0);
            PROMOTION = new PageType("PROMOTION", 1);
            DEFAULT = new PageType("DEFAULT", 2);
            $VALUES = (new PageType[] {
                MANAGE_STORAGE, PROMOTION, DEFAULT
            });
        }

        private PageType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ADD_ACTION_BAR_KEY = "ADD_ACTION_BAR";
    public static final String ADD_LEFT_PANEL_KEY = "ADD_LEFT_PANEL";
    private static final long CAMPAIGN_READY_TIMEOUT;
    public static final String CUSTOM_HEADER_TEXT_KEY = "CUSTOM_HEADER_TEXT_KEY";
    private static final long DEFAULT_TIMEOUT;
    public static final String MAKE_VISIBLE_ON_PAGE_FINISHED_KEY = "MAKE_VISIBLE_ON_PAGE_FINISHED";
    public static final String OVERRIDE_HOST = "WEBVIEW_OVERRIDE_HOST";
    public static final String PAGE_TYPE_KEY = "PAGE_TYPE_KEY";
    private static final String TAG = com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity.getName();
    public static final String TIMEOUT_KEY = "TIMEOUT_KEY";
    public static final String URL_EXTRA_KEY = "URL_EXTRA_KEY";
    private Handler handler;
    protected Dialog mSpinner;
    private WebView mWebView;
    private WebViewClient mWebViewClient;
    private boolean makeVisibleOnPageFinished;
    private NavigationPaneController navController;
    private NetworkConnectivity networkConnectivity;
    private PageType pageType;
    private ComponentProfiler profiler;
    private String url;
    private boolean waitForCampaignReady;
    private final VisibilityAnimator webViewAnimator = new VisibilityAnimator() {

        final AuthenticatedWebViewActivity this$0;

        protected long getDuration()
        {
            return 750L;
        }

        protected ObjectAnimator getHideAnimator()
        {
            return ObjectAnimator.ofFloat(getWebView(), "alpha", new float[] {
                0.0F
            });
        }

        protected volatile ValueAnimator getHideAnimator()
        {
            return getHideAnimator();
        }

        protected ObjectAnimator getShowAnimator()
        {
            return ObjectAnimator.ofFloat(getWebView(), "alpha", new float[] {
                1.0F
            });
        }

        protected volatile ValueAnimator getShowAnimator()
        {
            return getShowAnimator();
        }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super();
            }
    };

    public AuthenticatedWebViewActivity()
    {
        super(new BeanFactory() {

        });
        mWebView = null;
        mWebViewClient = null;
    }

    private String maybeOverrideUrl(String s)
    {
        String s2 = getSharedPreferences("galleryKindleSharedPrefs", 0).getString("WEBVIEW_OVERRIDE_HOST", "");
        String s1 = s;
        if (!"".equals(s2))
        {
            s = URI.create(s);
            s1 = (new android.net.Uri.Builder()).scheme(s.getScheme()).authority(s2).encodedPath(s.getRawPath()).encodedQuery(s.getRawQuery()).toString();
            GLogger.d(TAG, "Override URL from %s to %s", new Object[] {
                s.toASCIIString(), s1
            });
        }
        return s1;
    }

    private void recordPageLoadFailedMetric()
    {
        static class _cls7
        {

            static final int $SwitchMap$com$amazon$gallery$thor$app$activity$AuthenticatedWebViewActivity$PageType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$thor$app$activity$AuthenticatedWebViewActivity$PageType = new int[PageType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$app$activity$AuthenticatedWebViewActivity$PageType[PageType.PROMOTION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$app$activity$AuthenticatedWebViewActivity$PageType[PageType.MANAGE_STORAGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls7..SwitchMap.com.amazon.gallery.thor.app.activity.AuthenticatedWebViewActivity.PageType[pageType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            profiler.trackEvent(MetricsEvent.PromotionLoadFailed);
            return;

        case 2: // '\002'
            profiler.trackEvent(MetricsEvent.ManageStorageLoadFailed);
            break;
        }
    }

    private void recordPageLoadedMetric()
    {
        switch (_cls7..SwitchMap.com.amazon.gallery.thor.app.activity.AuthenticatedWebViewActivity.PageType[pageType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            profiler.trackEvent(MetricsEvent.PromotionWebViewLoaded);
            return;

        case 2: // '\002'
            profiler.trackEvent(MetricsEvent.ManageStorageWebViewLoaded);
            break;
        }
    }

    private void setupWebView(Bundle bundle)
    {
        getWebView().getSettings().setJavaScriptEnabled(true);
        mWebViewClient = new AuthenticatedWebViewClient(this) {

            final AuthenticatedWebViewActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                if (makeVisibleOnPageFinished || !waitForCampaignReady)
                {
                    onPageReady();
                    return;
                } else
                {
                    handler.postDelayed(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            if (mSpinner.isShowing())
                            {
                                recordPageLoadFailedMetric();
                                finish();
                            }
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }, AuthenticatedWebViewActivity.CAMPAIGN_READY_TIMEOUT);
                    return;
                }
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                if (!mSpinner.isShowing())
                {
                    mSpinner.show();
                }
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                super.onReceivedError(webview, i, s, s1);
                mSpinner.dismiss();
                if (makeVisibleOnPageFinished || !waitForCampaignReady)
                {
                    webViewAnimator.show();
                    recordPageLoadFailedMetric();
                }
                GLogger.i(AuthenticatedWebViewActivity.TAG, "Failed to load web view: errorCode: %d, description: %s, url: %s", new Object[] {
                    Integer.valueOf(i), s, s1
                });
            }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super(activity);
            }
        };
        mWebView.getSettings().setSupportMultipleWindows(true);
        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setWebChromeClient(new WebChromeClient() {

            final AuthenticatedWebViewActivity this$0;

            public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
            {
                message = webview.getHitTestResult().getExtra();
                if (message != null)
                {
                    webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(message)));
                }
                return false;
            }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super();
            }
        });
    }

    private void startWebviewLoad()
    {
        GLogger.i(TAG, "Webview loading URL: %s", new Object[] {
            url
        });
        webViewAnimator.hide();
        getWebView().setVisibility(4);
        getWebView().loadUrl(url);
        mSpinner.show();
    }

    public WebView getWebView()
    {
        if (mWebView == null)
        {
            mWebView = (WebView)findViewById(0x7f0c0013);
            webViewAnimator.setView(mWebView);
        }
        return mWebView;
    }

    public void initHeaderBar()
    {
        AndroidSimpleToolbar androidsimpletoolbar = new AndroidSimpleToolbar((Toolbar)findViewById(0x7f0c0085).findViewById(0x7f0c0086));
        String s = getIntent().getStringExtra("CUSTOM_HEADER_TEXT_KEY");
        if (s != null)
        {
            androidsimpletoolbar.setTitle(s);
        } else
        {
            androidsimpletoolbar.setTitle(getResources().getString(0x7f0e011b));
        }
        androidsimpletoolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        androidsimpletoolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final AuthenticatedWebViewActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super();
            }
        });
    }

    protected void initNavBar(TagDao tagdao, MediaItemDao mediaitemdao)
    {
        PhotosNavigationPane photosnavigationpane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navController = new NavigationPaneController(this, photosnavigationpane, tagdao, mediaitemdao, (Executor)getApplicationBean(Keys.UI_READY_EXECUTOR));
        photosnavigationpane.addSidePanelListener(new NoOpSidePanelListener() {

            final AuthenticatedWebViewActivity this$0;

            public void onNavigate(MenuItem menuitem)
            {
                super.onNavigate(menuitem);
                finish();
            }

            
            {
                this$0 = AuthenticatedWebViewActivity.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        profiler = new ComponentProfiler((Profiler)getApplicationBean(Keys.PROFILER), com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity);
        handler = new Handler();
        Intent intent = getIntent();
        url = maybeOverrideUrl(intent.getStringExtra("URL_EXTRA_KEY"));
        String s = intent.getStringExtra("PAGE_TYPE_KEY");
        if (s != null)
        {
            pageType = PageType.valueOf(s);
        }
        if (pageType == null)
        {
            pageType = PageType.DEFAULT;
        }
        makeVisibleOnPageFinished = intent.getBooleanExtra("MAKE_VISIBLE_ON_PAGE_FINISHED", true);
        waitForCampaignReady = true;
        setContentView(0x7f0300aa);
        if (intent.getBooleanExtra("ADD_LEFT_PANEL", false))
        {
            initNavBar((TagDao)getApplicationBean(Keys.TAG_DAO), (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO));
        } else
        {
            ((PhotosNavigationPane)findViewById(0x7f0c014e)).setSideBarEnabled(false);
        }
        networkConnectivity = (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        if (intent.getBooleanExtra("ADD_ACTION_BAR", false))
        {
            initHeaderBar();
        } else
        {
            findViewById(0x7f0c0086).setVisibility(8);
        }
        mSpinner = new ProtectedDialog(this);
        mSpinner.setCanceledOnTouchOutside(false);
        setupWebView(bundle);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (navController != null)
        {
            navController.onDestroy();
        }
        mSpinner.dismiss();
        mWebView.destroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            WebView webview = mWebView;
            if (webview != null && webview.getVisibility() == 0 && webview.canGoBack())
            {
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyevent);
    }

    protected void onPageReady()
    {
        webViewAnimator.show();
        waitForCampaignReady = false;
        recordPageLoadedMetric();
        mSpinner.dismiss();
    }

    protected void onPause()
    {
        super.onPause();
        if (mWebView != null)
        {
            mWebView.setWebViewClient(null);
            mWebView.pauseTimers();
            if (!BuildFlavors.isAosp())
            {
                mWebView.onPause();
            }
        }
        if (navController != null)
        {
            navController.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (((AuthenticationManager)getApplicationBeanFactory().getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId() == null)
        {
            GLogger.i(TAG, "No user signed in, closing activity.", new Object[0]);
            finish();
        }
        if (mWebView != null)
        {
            if (!BuildFlavors.isAosp())
            {
                mWebView.onResume();
            }
            mWebView.resumeTimers();
            mWebView.setWebViewClient(mWebViewClient);
        }
        startWebviewLoad();
        if (navController != null)
        {
            navController.onResume();
        }
    }

    protected void startPhotosIntent(Intent intent)
    {
        ((NavigationMetrics)ThorGalleryApplication.getBean(Keys.NAVIGATION_METRICS)).onNavigateToCollection();
        startActivity(intent);
    }

    static 
    {
        DEFAULT_TIMEOUT = TimeUnit.SECONDS.toMillis(15L);
        CAMPAIGN_READY_TIMEOUT = TimeUnit.SECONDS.toMillis(10L);
    }







}
