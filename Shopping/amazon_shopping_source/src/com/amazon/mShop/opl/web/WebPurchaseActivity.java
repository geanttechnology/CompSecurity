// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.opl.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopModalWebActivity;
import com.amazon.mShop.web.MShopWebFragment;
import com.amazon.mShop.web.MShopWebViewClient;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.mShop.web.MShopWebViewNotification;
import com.amazon.mShop.web.NativeAppNotification;
import org.apache.cordova.CordovaInterface;

public class WebPurchaseActivity extends MShopModalWebActivity
{

    private boolean mIsPlacingOrder;

    public WebPurchaseActivity()
    {
        mIsPlacingOrder = false;
    }

    private void exitModal()
    {
        setStopBehavior(1);
        setSupportMenu(true);
        setSupportGNO(true);
        Intent intent = new Intent();
        intent.setAction("com.amazon.mShop.TopMostViewChangedReceiverIntent");
        sendBroadcast(intent);
    }

    private boolean isThankYouPage(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (Util.isEmpty(s))
            {
                break label0;
            }
            s = Uri.parse(s).getPath();
            if (Util.isEmpty(s) || !s.contains("/gp/buy/spc/handlers/static-submit-decoupled.html") && !s.contains("/gp/buy/thankyou/handlers/display.html"))
            {
                flag = flag1;
                if (!isOneClick())
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public boolean canLaunchHomeFromActionBar()
    {
        return !mIsPlacingOrder && super.canLaunchHomeFromActionBar();
    }

    protected MShopWebViewClient createWebViewClient()
    {
        return new MShopWebViewClient(this) {

            final WebPurchaseActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                mIsPlacingOrder = false;
                if (isThankYouPage(s) && !getWebViewContainer().isWebViewReceivedError())
                {
                    exitModal();
                    if (getIntent().getBooleanExtra("isCartPurchase", false))
                    {
                        MShopWebViewNotification.notifyCartCountChanged(0);
                        NativeAppNotification.notifyNativeCartChanged(0);
                    }
                    webview.clearHistory();
                }
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                if (isThankYouPage(s))
                {
                    mIsPlacingOrder = true;
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            mIsPlacingOrder = false;
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 30000L);
                }
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                super.onReceivedError(webview, i, s, s1);
                mIsPlacingOrder = false;
                if (isOneClick())
                {
                    exitModal();
                }
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                super.onReceivedSslError(webview, sslerrorhandler, sslerror);
                mIsPlacingOrder = false;
                if (isOneClick())
                {
                    exitModal();
                }
            }

            
            {
                this$0 = WebPurchaseActivity.this;
                super(cordovainterface);
            }
        };
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 4 && mIsPlacingOrder)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    protected void initWebView()
    {
        super.initWebView();
        getWebViewContainer().setProgressHideSpinner(80);
    }

    protected boolean isOneClick()
    {
        return getIntent().getBooleanExtra("oneClick", false);
    }

    protected void loadUrl()
    {
        getWebView().postUrl(getUrl(), getPostParameters());
    }

    public boolean onSearchRequested()
    {
        if (isSupportGNO())
        {
            return super.onSearchRequested();
        } else
        {
            return false;
        }
    }

    public boolean onSearchRequested(String s, boolean flag)
    {
        if (isSupportGNO())
        {
            return super.onSearchRequested(s, flag);
        } else
        {
            return false;
        }
    }

    public void onStop()
    {
        String s;
        boolean flag;
        if (getIntent() != null)
        {
            flag = getIntent().getBooleanExtra("isCartPurchase", false);
        } else
        {
            flag = false;
        }
        if (getWebView() != null)
        {
            s = getWebView().getUrl();
        } else
        {
            s = null;
        }
        if (flag && isThankYouPage(s) && !mWebFragment.getContainer().isWebViewReceivedError())
        {
            MShopWebViewNotification.notifyCartCountChanged(0);
        }
        super.onStop();
    }

    public void startActivityForResult(Intent intent, int i)
    {
        super.startActivityForResult(intent, i);
        if (10002 == i)
        {
            skipNextStopBehavior();
        }
    }

    public void userSuccessfullySignedIn()
    {
        super.userSuccessfullySignedIn();
        if (getIntent().getBooleanExtra("isCartPurchase", false))
        {
            finish();
        }
    }



/*
    static boolean access$102(WebPurchaseActivity webpurchaseactivity, boolean flag)
    {
        webpurchaseactivity.mIsPlacingOrder = flag;
        return flag;
    }

*/

}
