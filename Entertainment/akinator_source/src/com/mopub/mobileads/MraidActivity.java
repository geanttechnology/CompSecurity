// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;

// Referenced classes of package com.mopub.mobileads:
//            BaseInterstitialActivity, BaseWebView, EventForwardingBroadcastReceiver, MoPubErrorCode

public class MraidActivity extends BaseInterstitialActivity
{

    private MraidWebViewDebugListener mDebugListener;
    private MraidController mMraidController;

    public MraidActivity()
    {
    }

    protected static Intent createIntent(Context context, AdReport adreport, String s, long l)
    {
        context = new Intent(context, com/mopub/mobileads/MraidActivity);
        context.putExtra("Html-Response-Body", s);
        context.putExtra("broadcastIdentifier", l);
        context.putExtra("mopub-intent-ad-report", adreport);
        context.addFlags(0x10000000);
        return context;
    }

    public static void preRenderHtml(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, String s)
    {
        context = new BaseWebView(context);
        context.enablePlugins(false);
        context.setWebViewClient(new WebViewClient(customeventinterstitiallistener) {

            final CustomEventInterstitial.CustomEventInterstitialListener val$customEventInterstitialListener;

            public void onPageFinished(WebView webview, String s1)
            {
                customEventInterstitialListener.onInterstitialLoaded();
            }

            public void onReceivedError(WebView webview, int i, String s1, String s2)
            {
                super.onReceivedError(webview, i, s1, s2);
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                return true;
            }

            
            {
                customEventInterstitialListener = customeventinterstitiallistener;
                super();
            }
        });
        context.loadDataWithBaseURL("http://ads.mopub.com/", s, "text/html", "UTF-8", null);
    }

    public static void start(Context context, AdReport adreport, String s, long l)
    {
        adreport = createIntent(context, adreport, s, l);
        try
        {
            context.startActivity(adreport);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    public View getAdView()
    {
        String s = getIntent().getStringExtra("Html-Response-Body");
        if (s == null)
        {
            MoPubLog.w("MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        } else
        {
            mMraidController = new MraidController(this, mAdReport, PlacementType.INTERSTITIAL);
            mMraidController.setDebugListener(mDebugListener);
            mMraidController.setMraidListener(new com.mopub.mraid.MraidController.MraidListener() {

                final MraidActivity this$0;

                public void onClose()
                {
                    mMraidController.loadJavascript(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
                    finish();
                }

                public void onExpand()
                {
                }

                public void onFailedToLoad()
                {
                    MoPubLog.d("MraidActivity failed to load. Finishing the activity");
                    EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
                    finish();
                }

                public void onLoaded(View view)
                {
                    mMraidController.loadJavascript(BaseInterstitialActivity.JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
                }

                public void onOpen()
                {
                    EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
                }

            
            {
                this$0 = MraidActivity.this;
                super();
            }
            });
            mMraidController.setUseCustomCloseListener(new com.mopub.mraid.MraidController.UseCustomCloseListener() {

                final MraidActivity this$0;

                public void useCustomCloseChanged(boolean flag)
                {
                    if (flag)
                    {
                        hideInterstitialCloseButton();
                        return;
                    } else
                    {
                        showInterstitialCloseButton();
                        return;
                    }
                }

            
            {
                this$0 = MraidActivity.this;
                super();
            }
            });
            mMraidController.loadContent(s);
            return mMraidController.getAdContainer();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.show");
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
    }

    protected void onDestroy()
    {
        if (mMraidController != null)
        {
            mMraidController.destroy();
        }
        EventForwardingBroadcastReceiver.broadcastAction(this, getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.dismiss");
        super.onDestroy();
    }

    protected void onPause()
    {
        if (mMraidController != null)
        {
            mMraidController.pause(isFinishing());
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (mMraidController != null)
        {
            mMraidController.resume();
        }
    }

    public void setDebugListener(MraidWebViewDebugListener mraidwebviewdebuglistener)
    {
        mDebugListener = mraidwebviewdebuglistener;
        if (mMraidController != null)
        {
            mMraidController.setDebugListener(mraidwebviewdebuglistener);
        }
    }

}
