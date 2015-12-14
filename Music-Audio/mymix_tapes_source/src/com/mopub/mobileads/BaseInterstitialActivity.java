// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;

abstract class BaseInterstitialActivity extends Activity
{
    static final class JavaScriptWebViewCallbacks extends Enum
    {

        private static final JavaScriptWebViewCallbacks $VALUES[];
        public static final JavaScriptWebViewCallbacks WEB_VIEW_DID_APPEAR;
        public static final JavaScriptWebViewCallbacks WEB_VIEW_DID_CLOSE;
        private String mJavascript;

        public static JavaScriptWebViewCallbacks valueOf(String s)
        {
            return (JavaScriptWebViewCallbacks)Enum.valueOf(com/mopub/mobileads/BaseInterstitialActivity$JavaScriptWebViewCallbacks, s);
        }

        public static JavaScriptWebViewCallbacks[] values()
        {
            return (JavaScriptWebViewCallbacks[])$VALUES.clone();
        }

        protected String getJavascript()
        {
            return mJavascript;
        }

        protected String getUrl()
        {
            return (new StringBuilder()).append("javascript:").append(mJavascript).toString();
        }

        static 
        {
            WEB_VIEW_DID_APPEAR = new JavaScriptWebViewCallbacks("WEB_VIEW_DID_APPEAR", 0, "webviewDidAppear();");
            WEB_VIEW_DID_CLOSE = new JavaScriptWebViewCallbacks("WEB_VIEW_DID_CLOSE", 1, "webviewDidClose();");
            $VALUES = (new JavaScriptWebViewCallbacks[] {
                WEB_VIEW_DID_APPEAR, WEB_VIEW_DID_CLOSE
            });
        }

        private JavaScriptWebViewCallbacks(String s, int i, String s1)
        {
            super(s, i);
            mJavascript = s1;
        }
    }


    protected AdReport mAdReport;
    private Long mBroadcastIdentifier;
    private CloseableLayout mCloseableLayout;

    BaseInterstitialActivity()
    {
    }

    protected static AdReport getAdReportFromIntent(Intent intent)
    {
        try
        {
            intent = (AdReport)intent.getSerializableExtra("mopub-intent-ad-report");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    protected static Long getBroadcastIdentifierFromIntent(Intent intent)
    {
        if (intent.hasExtra("broadcastIdentifier"))
        {
            return Long.valueOf(intent.getLongExtra("broadcastIdentifier", -1L));
        } else
        {
            return null;
        }
    }

    public abstract View getAdView();

    Long getBroadcastIdentifier()
    {
        return mBroadcastIdentifier;
    }

    protected void hideInterstitialCloseButton()
    {
        mCloseableLayout.setCloseVisible(false);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        mBroadcastIdentifier = getBroadcastIdentifierFromIntent(bundle);
        mAdReport = getAdReportFromIntent(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        bundle = getAdView();
        mCloseableLayout = new CloseableLayout(this);
        mCloseableLayout.setOnCloseListener(new com.mopub.common.CloseableLayout.OnCloseListener() {

            final BaseInterstitialActivity this$0;

            public void onClose()
            {
                finish();
            }

            
            {
                this$0 = BaseInterstitialActivity.this;
                super();
            }
        });
        mCloseableLayout.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setContentView(mCloseableLayout);
    }

    protected void onDestroy()
    {
        mCloseableLayout.removeAllViews();
        super.onDestroy();
    }

    protected void showInterstitialCloseButton()
    {
        mCloseableLayout.setCloseVisible(true);
    }
}
