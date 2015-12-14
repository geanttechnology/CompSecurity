// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.FTUEFragmentActivity;
import com.amazon.gallery.framework.kindle.ftue.FTUEScreen;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

public class WelcomeScreen extends FTUEScreen
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent LearnMoreOpened;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/ftue/WelcomeScreen$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            LearnMoreOpened = new MetricsEvent("LearnMoreOpened", 0);
            $VALUES = (new MetricsEvent[] {
                LearnMoreOpened
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/ftue/WelcomeScreen.getName();
    private AmazonInsightsHelper amazonInsightsHelper;
    private boolean hideWelcomeContent;
    private String pageUrl;
    private ImageView welcomeGraphic;

    public WelcomeScreen()
    {
        welcomeGraphic = null;
        hideWelcomeContent = false;
    }

    private int getWelcomeGraphic(Endpoint endpoint)
    {
        int j = 0x7f020207;
        int i = j;
        if (endpoint != null)
        {
            i = j;
            if (endpoint.getMarketplace() == com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CHINA)
            {
                i = 0x7f020208;
            }
        }
        return i;
    }

    private void launchWebView()
    {
        activity.runOnUiThread(new Runnable() {

            final WelcomeScreen this$0;

            public void run()
            {
                Object obj = new android.support.v7.app.AlertDialog.Builder(
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        });
    }

    private void requestPageVariation()
    {
        String s = AmazonInsightsHelper.getLocalizedLanguageVariant(com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LocaleType.LANGUAGE_ONLY, activity, "FTUE Learn More Page");
        amazonInsightsHelper.loadABText(s, "PageUrl", new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.TextLoadedListener() {

            final WelcomeScreen this$0;

            public void onTextLoaded(String s1)
            {
                pageUrl = s1;
            }

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        });
    }

    private void setupLearnMoreButton(final View ftueWelcomeLayout, final String buttonText)
    {
        requestPageVariation();
        activity.runOnUiThread(new Runnable() {

            final WelcomeScreen this$0;
            final String val$buttonText;
            final View val$ftueWelcomeLayout;

            public void run()
            {
                TextView textview = (TextView)ftueWelcomeLayout.findViewById(0x7f0c016f);
                textview.setText(buttonText);
                textview.setVisibility(0);
                textview.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(View view)
                    {
                        if (pageUrl != null)
                        {
                            GLogger.i(WelcomeScreen.TAG, "Show learn more page test result: %s", new Object[] {
                                pageUrl
                            });
                            amazonInsightsHelper.recordEvent(MetricsEvent.LearnMoreOpened);
                            access$1500.getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.LearnMoreClicked, ClickstreamEventHelper.createClickstreamExtra("FTUE-Event", HitType.PAGE_TOUCH));
                            launchWebView();
                        }
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            
            {
                this$0 = WelcomeScreen.this;
                ftueWelcomeLayout = view;
                buttonText = s;
                super();
            }
        });
    }

    private void setupLearnMoreButtonABTesting(final View ftueWelcomeLayout)
    {
        String s = AmazonInsightsHelper.getLocalizedLanguageVariant(com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LocaleType.LANGUAGE_ONLY, activity, "FTUE Learn More Button");
        amazonInsightsHelper.loadLaunch(s, "ShowButton", "ButtonText", new com.amazon.gallery.foundation.metrics.amazoninsights.AmazonInsightsHelper.LaunchAndTextLoadedListener() {

            final WelcomeScreen this$0;
            final View val$ftueWelcomeLayout;

            public void onLoaded(boolean flag, String s1)
            {
                GLogger.i(WelcomeScreen.TAG, "Show learn more button test result: %b", new Object[] {
                    Boolean.valueOf(flag)
                });
                if (flag && s1 != null)
                {
                    setupLearnMoreButton(ftueWelcomeLayout, s1);
                }
            }

            
            {
                this$0 = WelcomeScreen.this;
                ftueWelcomeLayout = view;
                super();
            }
        });
    }

    protected int getBackgroundResource()
    {
        return 0x7f020206;
    }

    public int getLayout()
    {
        return 0x7f030097;
    }

    public com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent getShowScreenMetric()
    {
        return com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.FTUELaunched;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        GlobalMessagingBus.register(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        if (hideWelcomeContent)
        {
            layoutinflater.findViewById(0x7f0c016e).setVisibility(4);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        GlobalMessagingBus.unregister(this);
    }

    public void onEndpointLoaded(final EndpointLoadedEvent endpointLoaded)
    {
        if (welcomeGraphic != null)
        {
            welcomeGraphic.post(new Runnable() {

                final WelcomeScreen this$0;
                final EndpointLoadedEvent val$endpointLoaded;

                public void run()
                {
                    welcomeGraphic.setImageResource(getWelcomeGraphic(endpointLoaded.endpoint));
                }

            
            {
                this$0 = WelcomeScreen.this;
                endpointLoaded = endpointloadedevent;
                super();
            }
            });
        }
    }

    public void onResume()
    {
        super.onResume();
        amazonInsightsHelper = (AmazonInsightsHelper)activity.getApplicationBean(Keys.AMAZON_INSIGHTS_HELPER);
        welcomeGraphic = (ImageView)layout.findViewById(0x7f0c0170);
        welcomeGraphic.setImageResource(getWelcomeGraphic(activity.getEndpoint()));
        layout.findViewById(0x7f0c0164).setOnClickListener(new android.view.View.OnClickListener() {

            final WelcomeScreen this$0;

            public void onClick(View view)
            {
                
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = WelcomeScreen.this;
                super();
            }
        });
        layout.findViewById(0x7f0c0167).setOnClickListener(new android.view.View.OnClickListener() );
        setupLearnMoreButtonABTesting(layout);
        onShowView(activity);
    }

    public void setHideWelcomeContent(boolean flag)
    {
        hideWelcomeContent = flag;
    }









/*
    static String access$1302(WelcomeScreen welcomescreen, String s)
    {
        welcomescreen.pageUrl = s;
        return s;
    }

*/


















    // Unreferenced inner class com/amazon/gallery/thor/ftue/WelcomeScreen$7$1

/* anonymous class */
}
