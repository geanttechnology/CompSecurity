// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.facebook.ads.a.ae;
import com.facebook.ads.a.af;
import com.facebook.ads.a.ai;
import com.facebook.ads.a.al;
import com.facebook.ads.a.am;
import com.facebook.ads.a.b;
import com.facebook.ads.a.c;

// Referenced classes of package com.facebook.ads:
//            c, d

public class InterstitialAdActivity extends Activity
{

    private static final int AD_WEBVIEW_ID = 0x186a1;
    private static final int CLOSE_BUTTON_ID = 0x186a2;
    private static final int CLOSE_BUTTON_SIZE_DP = 60;
    private static final String DATA_MODEL_KEY = "dataModel";
    private static final String LAST_REQUESTED_ORIENTATION_KEY = "lastRequestedOrientation";
    private static final int ORIENTATION_REVERSE_LANDSCAPE = 8;
    private static final int ORIENTATION_REVERSE_PORTRAIT = 9;
    private static final String TAG = com/facebook/ads/InterstitialAdActivity.getSimpleName();
    private long actionTime;
    private com.facebook.ads.a.b.a actionType;
    private am adHandler;
    private WebView adWebView;
    private ai closeButton;
    private long createTime;
    private al dataModel;
    private int displayHeight;
    private int displayWidth;
    private String interstitialID;
    private boolean isRestart;
    private int lastRequestedOrientation;

    public InterstitialAdActivity()
    {
        isRestart = false;
    }

    private void loadAdFromIntentOrSavedState(Intent intent, Bundle bundle)
    {
        if (bundle != null && bundle.containsKey("dataModel"))
        {
            dataModel = al.a(bundle.getBundle("dataModel"));
            if (dataModel != null)
            {
                adWebView.loadDataWithBaseURL(af.a(), dataModel.c(), "text/html", "utf-8", null);
            }
            lastRequestedOrientation = bundle.getInt("lastRequestedOrientation", -1);
            interstitialID = bundle.getString("adInterstitialUniqueId");
            isRestart = true;
        } else
        {
            displayWidth = intent.getIntExtra("displayWidth", 0);
            displayHeight = intent.getIntExtra("displayHeight", 0);
            interstitialID = intent.getStringExtra("adInterstitialUniqueId");
            dataModel = al.b(intent);
            if (dataModel != null)
            {
                adHandler.a(dataModel);
                adWebView.loadDataWithBaseURL(af.a(), dataModel.c(), "text/html", "utf-8", null);
                return;
            }
        }
    }

    private void sendBroadcastForEvent(String s)
    {
        s = new Intent((new StringBuilder()).append(s).append(":").append(interstitialID).toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(s);
    }

    private void setScreenOrientation(int i, int j)
    {
        if (j >= i)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = ((WindowManager)getSystemService("window")).getDefaultDisplay().getRotation();
        if (i != 0)
        {
            switch (j)
            {
            default:
                setRequestedOrientation(1);
                return;

            case 1: // '\001'
            case 2: // '\002'
                setRequestedOrientation(9);
                break;
            }
            return;
        }
        switch (j)
        {
        default:
            setRequestedOrientation(0);
            return;

        case 2: // '\002'
        case 3: // '\003'
            setRequestedOrientation(8);
            break;
        }
    }

    public void finish()
    {
        adHandler.c();
        adWebView.loadUrl("about:blank");
        adWebView.clearCache(true);
        sendBroadcastForEvent("com.facebook.ads.interstitial.dismissed");
        c.a(b.a(createTime, com.facebook.ads.a.b.a.c));
        super.finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        createTime = System.currentTimeMillis();
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        RelativeLayout relativelayout = new RelativeLayout(this);
        adWebView = new WebView(this);
        adWebView.setId(0x186a1);
        adWebView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        af.a(adWebView, new a(null), new ae());
        relativelayout.addView(adWebView);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("useNativeCloseButton", false))
        {
            closeButton = new ai(this);
            closeButton.setId(0x186a2);
            Object obj = getResources().getDisplayMetrics();
            obj = new android.widget.RelativeLayout.LayoutParams((int)(((DisplayMetrics) (obj)).density * 60F), (int)(((DisplayMetrics) (obj)).density * 60F));
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            closeButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            closeButton.setOnClickListener(new com.facebook.ads.c(this));
            relativelayout.addView(closeButton);
        }
        adHandler = new am(adWebView, new d(this), 1000L, this);
        setContentView(relativelayout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        loadAdFromIntentOrSavedState(intent, bundle);
        sendBroadcastForEvent("com.facebook.ads.interstitial.displayed");
        adHandler.h();
    }

    public void onRestart()
    {
        super.onRestart();
        isRestart = true;
    }

    public void onResume()
    {
        super.onResume();
        if (actionTime > 0L && actionType != null)
        {
            c.a(b.a(actionTime, actionType));
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (dataModel != null)
        {
            bundle.putBundle("dataModel", dataModel.i());
        }
        bundle.putInt("lastRequestedOrientation", lastRequestedOrientation);
        bundle.putString("adInterstitialUniqueId", interstitialID);
    }

    public void onStart()
    {
        super.onStart();
        if (isRestart) goto _L2; else goto _L1
_L1:
        setScreenOrientation(displayWidth, displayHeight);
_L4:
        isRestart = false;
        return;
_L2:
        if (lastRequestedOrientation >= 0)
        {
            setRequestedOrientation(lastRequestedOrientation);
            lastRequestedOrientation = -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setRequestedOrientation(int i)
    {
        lastRequestedOrientation = i;
        super.setRequestedOrientation(i);
    }





/*
    static com.facebook.ads.a.b.a access$302(InterstitialAdActivity interstitialadactivity, com.facebook.ads.a.b.a a)
    {
        interstitialadactivity.actionType = a;
        return a;
    }

*/


/*
    static long access$402(InterstitialAdActivity interstitialadactivity, long l)
    {
        interstitialadactivity.actionTime = l;
        return l;
    }

*/


    private class a extends WebViewClient
    {

        final InterstitialAdActivity a;

        public void onLoadResource(WebView webview, String s)
        {
            a.adHandler.f();
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            if (aa.a())
            {
                sslerrorhandler.proceed();
                return;
            } else
            {
                sslerrorhandler.cancel();
                return;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = Uri.parse(s);
            if ("fbad".equals(webview.getScheme()) && "close".equals(webview.getAuthority()))
            {
                a.finish();
            } else
            {
                a.sendBroadcastForEvent("com.facebook.ads.interstitial.clicked");
                webview = com.facebook.ads.a.a.b.a(a, webview);
                if (webview != null)
                {
                    try
                    {
                        a.actionType = webview.a();
                        a.actionTime = System.currentTimeMillis();
                        webview.a(null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        Log.e(InterstitialAdActivity.TAG, "Error executing action", webview);
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }

        private a()
        {
            a = InterstitialAdActivity.this;
            super();
        }

        a(com.facebook.ads.c c1)
        {
            this();
        }
    }

}
