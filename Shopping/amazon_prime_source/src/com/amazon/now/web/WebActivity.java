// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.nav.MASHNavInterface;
import com.amazon.now.AmazonActivity;
import com.amazon.now.ChromeStyle;
import com.amazon.now.DCMCollector;
import com.amazon.now.DCMPageTypeIdentifier;
import com.amazon.now.account.SSO;
import com.amazon.now.util.AppUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

// Referenced classes of package com.amazon.now.web:
//            WebViewSubscriber, NowWebFragment, NowWebView

public class WebActivity extends AmazonActivity
    implements MASHNavInterface, NowWebFragment.OnWebViewReadyListener, WebViewSubscriber, CordovaInterface
{

    public static final String INTENT_DEFER_LOAD_KEY = "intentDeferLoadKey";
    public static final String INTENT_SKIP_KEY = "intentSkipKey";
    public static final String INTENT_URL_KEY = "intentUrlKey";
    private CordovaPlugin mActivityResultCallback;
    private boolean mIsError;
    private ExecutorService mThreadPool;
    protected NowWebFragment mWebFragment;
    private View mWebViewHolder;
    public MetricEvent metricEvent;

    public WebActivity()
    {
        mIsError = false;
    }

    protected void authenticate(final String url)
    {
        if (SSO.shouldReauthenticate())
        {
            SSO.confirmCredentials(this, new Callback() {

                final WebActivity this$0;
                final String val$url;

                public void onError(Bundle bundle)
                {
                    runOnUiThread(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            finish();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

                public void onSuccess(Bundle bundle)
                {
                    runOnUiThread(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            SSO.updateLastAuthenticationTime();
                            if (!TextUtils.isEmpty(url))
                            {
                                mWebFragment.loadUrl(url);
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }

            
            {
                this$0 = WebActivity.this;
                url = s;
                super();
            }
            });
        } else
        if (!TextUtils.isEmpty(url))
        {
            mWebFragment.loadUrl(url);
            return;
        }
    }

    public void authenticateUser(final String returnUrl)
    {
        SSO.authenticateUser(this, new com.amazon.now.account.SSO.SignInCallback() {

            final WebActivity this$0;
            final String val$returnUrl;

            public void failure()
            {
                runOnUiThread(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        NowWebView nowwebview = mWebFragment.getWebView();
                        if (nowwebview != null)
                        {
                            if (nowwebview.canGoBack())
                            {
                                nowwebview.goBack();
                            } else
                            if (TextUtils.isEmpty(nowwebview.getUrl()))
                            {
                                finish();
                                return;
                            }
                        }
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public void success(Activity activity)
            {
                if (!TextUtils.isEmpty(returnUrl) && (activity instanceof WebActivity))
                {
                    runOnUiThread(activity. new Runnable() {

                        final _cls2 this$1;
                        final Activity val$activity;

                        public void run()
                        {
                            ((WebActivity)activity).loadUrl(returnUrl);
                        }

            
            {
                this$1 = final__pcls2;
                activity = Activity.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = WebActivity.this;
                returnUrl = s;
                super();
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            if (closeLeftNav())
            {
                return true;
            }
            NowWebView nowwebview = mWebFragment.getWebView();
            if (nowwebview != null && nowwebview.canGoBack())
            {
                nowwebview.goBack();
                return true;
            }
            finish();
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public void error(boolean flag)
    {
        mIsError = flag;
    }

    public Activity getActivity()
    {
        return this;
    }

    protected String getLaunchUrl()
    {
        return getIntent().getStringExtra("intentUrlKey");
    }

    public Class getModalActivityClass()
    {
        return null;
    }

    public ExecutorService getThreadPool()
    {
        if (mThreadPool == null)
        {
            mThreadPool = Executors.newCachedThreadPool();
        }
        return mThreadPool;
    }

    protected NowWebFragment getWebFragment()
    {
        NowWebFragment nowwebfragment = (NowWebFragment)getFragmentManager().findFragmentById(0x7f0e0087);
        if (nowwebfragment != null)
        {
            return nowwebfragment;
        } else
        {
            return mWebFragment;
        }
    }

    public View getWebViewHolder()
    {
        return mWebViewHolder;
    }

    public void loadUrl(String s)
    {
        mWebFragment.loadUrl(s);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (mActivityResultCallback != null)
        {
            mActivityResultCallback.onActivityResult(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Intent intent = getIntent();
        boolean flag = intent.getBooleanExtra("intentSkipKey", false);
        Config.init(this);
        mWebFragment = NowWebFragment.add(getFragmentManager(), 0x7f0e0087);
        mWebFragment.setOnWebViewReadyListener(this);
        mWebFragment.setSubscriber(this);
        String s = getLaunchUrl();
        boolean flag1 = intent.getBooleanExtra("intentDeferLoadKey", false);
        if (s != null && !flag1)
        {
            Uri uri = Uri.parse(s);
            bundle = s;
            if (uri.getHost() == null)
            {
                bundle = s;
                if (uri.getScheme() == null)
                {
                    bundle = (new StringBuilder()).append(AppUtils.getServiceUrl(this)).append(s).toString();
                }
            }
            mWebFragment.loadUrl(bundle);
        }
        if (!flag)
        {
            mWebViewHolder = LayoutInflater.from(this).inflate(0x7f030074, null);
            ChromeStyle chromestyle = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL);
            bundle = chromestyle;
            if (intent.hasExtra("intentStyleKey"))
            {
                bundle = chromestyle;
                if (intent.getParcelableExtra("intentStyleKey") != null)
                {
                    ChromeStyle chromestyle1 = (ChromeStyle)intent.getParcelableExtra("intentStyleKey");
                    bundle = chromestyle1;
                    if (chromestyle1.shouldSetBackground())
                    {
                        getWindow().getDecorView().setBackgroundColor(chromestyle1.getColor());
                        mWebViewHolder.setBackgroundColor(chromestyle1.getColor());
                        bundle = chromestyle1;
                    }
                }
            }
            setRootView(mWebViewHolder, bundle);
        }
    }

    public Object onMessage(String s, Object obj)
    {
        return null;
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        getWebFragment().resetWebView();
    }

    public void onPageError()
    {
        if (DCMPageTypeIdentifier.pageTypeForUrl(mWebFragment.getWebView().getUrl()) != null)
        {
            DCMCollector.stopAndRecordEvent(this, metricEvent);
        }
    }

    public void onPageFinished()
    {
        if (DCMPageTypeIdentifier.pageTypeForUrl(mWebFragment.getWebView().getUrl()) != null)
        {
            DCMCollector.stopAndRecordEvent(this, metricEvent);
        }
    }

    public void onPageStarted()
    {
        String s = DCMPageTypeIdentifier.pageTypeForUrl(mWebFragment.getWebView().getUrl());
        if (s != null)
        {
            metricEvent = DCMCollector.startPmetEvent(this, s);
        }
    }

    public void onPause()
    {
        super.onPause();
        if (!mIsError)
        {
            getWebFragment().detach();
        }
        getWebViewHolder().setBackgroundColor(getResources().getColor(0x7f0d000d));
    }

    public void onResume()
    {
        super.onResume();
        if (!mIsError)
        {
            getWebFragment().attach();
        }
    }

    public void onWebViewReady(NowWebView nowwebview)
    {
    }

    public void replaceRootWebViewWithNewUrl(MASHWebView mashwebview, com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mashnavrequest)
    {
    }

    public void setActivityResultCallback(CordovaPlugin cordovaplugin)
    {
        mActivityResultCallback = cordovaplugin;
    }

    public void startActivityForResult(CordovaPlugin cordovaplugin, Intent intent, int i)
    {
        mActivityResultCallback = cordovaplugin;
        startActivityForResult(intent, i);
    }
}
