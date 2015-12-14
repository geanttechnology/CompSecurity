// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;

// Referenced classes of package com.mopub.mobileads:
//            BaseInterstitialActivity, HtmlInterstitialWebView, EventForwardingBroadcastReceiver

public class MoPubActivity extends BaseInterstitialActivity
{

    private HtmlInterstitialWebView mHtmlInterstitialWebView;

    public MoPubActivity()
    {
    }

    static Intent createIntent(Context context, String s, AdReport adreport, boolean flag, String s1, String s2, CreativeOrientation creativeorientation, long l)
    {
        context = new Intent(context, com/mopub/mobileads/MoPubActivity);
        context.putExtra("Html-Response-Body", s);
        context.putExtra("Scrollable", flag);
        context.putExtra("Clickthrough-Url", s2);
        context.putExtra("Redirect-Url", s1);
        context.putExtra("broadcastIdentifier", l);
        context.putExtra("mopub-intent-ad-report", adreport);
        context.putExtra("com_mopub_orientation", creativeorientation);
        context.addFlags(0x10000000);
        return context;
    }

    static void preRenderHtml(Context context, AdReport adreport, final CustomEventInterstitial.CustomEventInterstitialListener customEventInterstitialListener, String s)
    {
        context = HtmlInterstitialWebViewFactory.create(context, adreport, customEventInterstitialListener, false, null, null);
        context.enablePlugins(false);
        context.setWebViewClient(new WebViewClient() {

            final CustomEventInterstitial.CustomEventInterstitialListener val$customEventInterstitialListener;

            public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                if (!s1.equals("mopub://finishLoad")) goto _L2; else goto _L1
_L1:
                customEventInterstitialListener.onInterstitialLoaded();
_L4:
                return true;
_L2:
                if (s1.equals("mopub://failLoad"))
                {
                    customEventInterstitialListener.onInterstitialFailed(null);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                customEventInterstitialListener = customeventinterstitiallistener;
                super();
            }
        });
        context.loadHtmlResponse(s);
    }

    public static void start(Context context, String s, AdReport adreport, boolean flag, String s1, String s2, CreativeOrientation creativeorientation, long l)
    {
        s = createIntent(context, s, adreport, flag, s1, s2, creativeorientation, l);
        try
        {
            context.startActivity(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public View getAdView()
    {
        Object obj = getIntent();
        boolean flag = ((Intent) (obj)).getBooleanExtra("Scrollable", false);
        String s = ((Intent) (obj)).getStringExtra("Redirect-Url");
        String s1 = ((Intent) (obj)).getStringExtra("Clickthrough-Url");
        obj = ((Intent) (obj)).getStringExtra("Html-Response-Body");
        mHtmlInterstitialWebView = HtmlInterstitialWebViewFactory.create(getApplicationContext(), mAdReport, new BroadcastingInterstitialListener(), flag, s, s1);
        mHtmlInterstitialWebView.loadHtmlResponse(((String) (obj)));
        return mHtmlInterstitialWebView;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent().getSerializableExtra("com_mopub_orientation");
        if (bundle == null || !(bundle instanceof CreativeOrientation))
        {
            bundle = CreativeOrientation.UNDEFINED;
        } else
        {
            bundle = (CreativeOrientation)bundle;
        }
        DeviceUtils.lockOrientation(this, bundle);
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.show");
    }

    protected void onDestroy()
    {
        mHtmlInterstitialWebView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getUrl());
        mHtmlInterstitialWebView.destroy();
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }


    private class BroadcastingInterstitialListener
        implements CustomEventInterstitial.CustomEventInterstitialListener
    {

        final MoPubActivity this$0;

        public void onInterstitialClicked()
        {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
        }

        public void onInterstitialDismissed()
        {
        }

        public void onInterstitialFailed(MoPubErrorCode mopuberrorcode)
        {
            EventForwardingBroadcastReceiver.broadcastAction(MoPubActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
            finish();
        }

        public void onInterstitialLoaded()
        {
            mHtmlInterstitialWebView.loadUrl(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getUrl());
        }

        public void onInterstitialShown()
        {
        }

        public void onLeaveApplication()
        {
        }

        BroadcastingInterstitialListener()
        {
            this$0 = MoPubActivity.this;
            super();
        }
    }

}
