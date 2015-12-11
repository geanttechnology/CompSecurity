// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.ArrayList;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvLauncher, CvOverlayLoader, CvAdColony, 
//            CvViewHelper, CvAdType

public class CvOverlayActivity extends Activity
{

    private static final int MAX_BACK_BUTTON_LOCK_TIME = 5000;
    private boolean disappeared;
    private boolean loaded;
    Context mContext;
    CvLauncher mLauncher;
    private long resumed;
    WebView webView;

    public CvOverlayActivity()
    {
        disappeared = false;
        loaded = false;
        resumed = 0L;
    }

    public void notLoaded()
    {
        finish();
    }

    public void onBackPressed()
    {
        long l = System.currentTimeMillis();
        if (loaded || resumed > 0L && System.currentTimeMillis() - resumed > 5000L)
        {
            super.onBackPressed();
            return;
        }
        Logger.log log = Logger.get("OVERLAY_PAGE");
        String s;
        if (resumed > 0L)
        {
            s = (new StringBuilder()).append(" (time left: ").append(5000L - (l - resumed)).append("ms)").toString();
        } else
        {
            s = "";
        }
        log.e(new Object[] {
            "Back button blocked", s
        });
    }

    public void onCreate(final Bundle layout)
    {
        super.onCreate(layout);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        mLauncher = new CvLauncher(this);
        layout = new RelativeLayout(this);
        layout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        final LinearLayout loader;
        Object obj;
        android.widget.LinearLayout.LayoutParams layoutparams;
        try
        {
            webView = (WebView)CvOverlayLoader.loadedViews.remove(0);
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle layout)
        {
            notLoaded();
            return;
        }
        webView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        webView.getSettings().setJavaScriptEnabled(true);
        loader = new LinearLayout(this);
        loader.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        loader.setGravity(17);
        loader.setBackgroundColor(Color.argb(150, 0, 0, 0));
        loader.setClickable(true);
        obj = new ProgressBar(this, null, 0x1010288);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        ((ProgressBar) (obj)).setLayoutParams(layoutparams);
        loader.addView(((android.view.View) (obj)));
        obj = new WebViewClient() {

            final CvOverlayActivity this$0;
            final RelativeLayout val$layout;
            final LinearLayout val$loader;

            public void onPageFinished(WebView webview, String s)
            {
            /* block-local class not found */
            class _cls1 {}

                CvViewHelper.runOnUIThread(new _cls1());
                Logger.get("OVERLAY_PAGE").e(new Object[] {
                    "Page", s, "loaded successfully"
                });
                loaded = true;
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                Logger.get("OVERLAY_PAGE").e(new Object[] {
                    (new StringBuilder()).append("Hiding overlay after error").append(i).append(":").toString(), s, " (URL:", (new StringBuilder()).append(s1).append(")").toString()
                });
                finish();
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (mLauncher.shouldRunURL(s, CvAdType.IN_PLACE))
                {
                    webview.loadUrl(s);
                }
                return true;
            }

            
            {
                this$0 = CvOverlayActivity.this;
                loader = linearlayout;
                layout = relativelayout;
                super();
            }
        };
        webView.setWebViewClient(((WebViewClient) (obj)));
        obj = webView.getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            ((ViewGroup)obj).removeView(webView);
        }
        layout.addView(webView);
        layout.addView(loader);
        setContentView(layout, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public void onPause()
    {
        super.onPause();
        disappeared = true;
        CvAdColony.onPause();
    }

    public void onResume()
    {
        super.onResume();
        CvAdColony.onResume(this);
        if (disappeared)
        {
            finish();
        } else
        if (resumed == 0L)
        {
            resumed = System.currentTimeMillis();
            return;
        }
    }


/*
    static boolean access$002(CvOverlayActivity cvoverlayactivity, boolean flag)
    {
        cvoverlayactivity.loaded = flag;
        return flag;
    }

*/
}
