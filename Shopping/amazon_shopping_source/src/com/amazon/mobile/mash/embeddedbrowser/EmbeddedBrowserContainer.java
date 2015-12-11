// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.embeddedbrowser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.amazon.mobile.mash.MASHWebChromeClient;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.MASHWebViewClient;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.embeddedbrowser:
//            EmbeddedBrowserActivity, EmbeddedBrowserWebView

public class EmbeddedBrowserContainer extends FrameLayout
{

    protected static final String TAG = com/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer.getSimpleName();
    private EmbeddedBrowserActivity mActivity;
    private boolean mShouldShowOpenExternalButton;
    private boolean mShouldShowRefreshButton;
    private EmbeddedBrowserWebView mWebView;

    public EmbeddedBrowserContainer(EmbeddedBrowserActivity embeddedbrowseractivity)
    {
        Object obj;
        String s;
        byte abyte0[];
        super(embeddedbrowseractivity);
        mActivity = embeddedbrowseractivity;
        initalizeWebView();
        embeddedbrowseractivity = mActivity.getIntent();
        obj = embeddedbrowseractivity.getStringExtra(WebConstants.getWebViewUrlKey());
        s = embeddedbrowseractivity.getStringExtra("method");
        abyte0 = embeddedbrowseractivity.getByteArrayExtra("postParams");
        mShouldShowOpenExternalButton = embeddedbrowseractivity.getBooleanExtra("showActionButton", true);
        mShouldShowRefreshButton = embeddedbrowseractivity.getBooleanExtra("showRefreshButton", true);
        if (!"GET".equals(s)) goto _L2; else goto _L1
_L1:
        mWebView.loadUrl(((String) (obj)));
_L4:
        embeddedbrowseractivity = mActivity.getLayoutInflater().inflate(com.amazon.mobile.mash.R.layout.embedded_browser_container, this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((ViewGroup)embeddedbrowseractivity.findViewById(com.amazon.mobile.mash.R.id.webview_container)).addView(mWebView);
        initializeButtons();
        updateNavigationButtons(mWebView);
        return;
_L2:
        if ("POST".equals(s))
        {
            mWebView.postUrl(((String) (obj)), abyte0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void initalizeWebView()
    {
        mWebView = new EmbeddedBrowserWebView(mActivity);
        mWebView.setWebChromeClient(new MASHWebChromeClient(mActivity, mWebView));
        mWebView.setWebViewClient(new MASHWebViewClient(mActivity, mWebView, null, null) {

            final EmbeddedBrowserContainer this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                updateNavigationButtons(mWebView);
                findViewById(com.amazon.mobile.mash.R.id.embedded_browser_spinner).setVisibility(8);
                if (mShouldShowRefreshButton)
                {
                    findViewById(com.amazon.mobile.mash.R.id.refresh_button).setVisibility(0);
                }
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                updateNavigationButtons(mWebView);
                findViewById(com.amazon.mobile.mash.R.id.refresh_button).setVisibility(8);
                findViewById(com.amazon.mobile.mash.R.id.embedded_browser_spinner).setVisibility(0);
            }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super(cordovainterface, mashwebview, mashnavdelegate, mashurlintercepter);
            }
        });
    }

    private void initializeButtons()
    {
        findViewById(com.amazon.mobile.mash.R.id.back_button).setOnClickListener(new android.view.View.OnClickListener() {

            final EmbeddedBrowserContainer this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoBack())
                {
                    mWebView.goBack();
                }
            }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super();
            }
        });
        findViewById(com.amazon.mobile.mash.R.id.forward_button).setOnClickListener(new android.view.View.OnClickListener() {

            final EmbeddedBrowserContainer this$0;

            public void onClick(View view)
            {
                if (mWebView.canGoForward())
                {
                    mWebView.goForward();
                }
            }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super();
            }
        });
        findViewById(com.amazon.mobile.mash.R.id.done_button).setOnClickListener(new android.view.View.OnClickListener() {

            final EmbeddedBrowserContainer this$0;

            public void onClick(View view)
            {
                ((Activity)getContext()).setResult(10002);
                ((Activity)getContext()).finish();
            }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super();
            }
        });
        ImageButton imagebutton = (ImageButton)findViewById(com.amazon.mobile.mash.R.id.refresh_button);
        if (mShouldShowRefreshButton)
        {
            imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

                final EmbeddedBrowserContainer this$0;

                public void onClick(View view)
                {
                    mWebView.reload();
                }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super();
            }
            });
        } else
        {
            imagebutton.setVisibility(8);
        }
        imagebutton = (ImageButton)findViewById(com.amazon.mobile.mash.R.id.open_in_external_button);
        if (mShouldShowOpenExternalButton)
        {
            findViewById(com.amazon.mobile.mash.R.id.open_in_external_button).setOnClickListener(new android.view.View.OnClickListener() {

                final EmbeddedBrowserContainer this$0;

                public void onClick(View view)
                {
                    mActivity.openOptionsMenu();
                }

            
            {
                this$0 = EmbeddedBrowserContainer.this;
                super();
            }
            });
            return;
        } else
        {
            imagebutton.setVisibility(8);
            return;
        }
    }

    private void updateNavigationButtons(MASHWebView mashwebview)
    {
        ImageButton imagebutton = (ImageButton)findViewById(com.amazon.mobile.mash.R.id.back_button);
        ImageButton imagebutton1 = (ImageButton)findViewById(com.amazon.mobile.mash.R.id.forward_button);
        if (mashwebview.canGoBack())
        {
            imagebutton.setAlpha(255);
        } else
        {
            imagebutton.setAlpha(102);
        }
        if (mashwebview.canGoForward())
        {
            imagebutton1.setAlpha(255);
            return;
        } else
        {
            imagebutton1.setAlpha(102);
            return;
        }
    }

    public void destroy()
    {
        mWebView.destroy();
    }

    public boolean goBack()
    {
        if (mWebView.canGoBack())
        {
            mWebView.goBack();
            return true;
        } else
        {
            return false;
        }
    }

    public void handleOnPause()
    {
        mWebView.pauseTimers();
    }

    public void handleOnResume()
    {
        mWebView.resumeTimers();
    }

    public void openInExternalBrowser()
    {
        String s = mWebView.getUrl();
        Object obj = s;
        if (s == null)
        {
            if (MASHDebug.isEnabled())
            {
                Log.w(TAG, "The current URL is null. Reverting to the original URL for external browser.");
            }
            obj = mWebView.getOriginalUrl();
        }
        s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = "about:blank";
        }
        if (MASHDebug.isEnabled())
        {
            Log.i(TAG, (new StringBuilder()).append("Launching intent for external browser for url: ").append(s).toString());
        }
        obj = new Intent("android.intent.action.VIEW", Uri.parse(s));
        ((Intent) (obj)).setFlags(0x10000000);
        try
        {
            getContext().startActivity(((Intent) (obj)));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.e(TAG, "Could not launch intent for url");
        }
    }





}
