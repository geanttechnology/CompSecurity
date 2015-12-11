// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.web.MShopModalWebActivity;
import com.amazon.mShop.web.MShopWebViewClient;
import com.amazon.mShop.web.MShopWebViewContainer;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellHelper

public class PrimeUpsellActivity extends MShopModalWebActivity
{
    private class PrimeNavManager extends AmazonNavManager
    {

        final PrimeUpsellActivity this$0;

        protected void handleDismissAll(WebView webview, Uri uri)
        {
            String s = uri.getQueryParameter("result");
            if (!"successPrime".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
            mPrimeUpsellResult = PrimeUpsellResult.RESULT_SIGNUP_SUCCESS;
_L4:
            super.handleDismissAll(webview, uri);
            return;
_L2:
            if ("successNoThanks".equalsIgnoreCase(s))
            {
                mPrimeUpsellResult = PrimeUpsellResult.RESULT_USER_CANCELLED;
            } else
            if ("failurePrime".equalsIgnoreCase(s))
            {
                mPrimeUpsellResult = PrimeUpsellResult.RESULT_SIGNUP_FAILURE;
            } else
            if ("failureOfferNotDisplayed".equalsIgnoreCase(s))
            {
                mPrimeUpsellResult = PrimeUpsellResult.RESULT_OFFER_PAGE_NOT_DISPLAYED;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private PrimeNavManager()
        {
            this$0 = PrimeUpsellActivity.this;
            super();
        }

    }

    public static final class PrimeUpsellResult extends Enum
    {

        private static final PrimeUpsellResult $VALUES[];
        public static final PrimeUpsellResult RESULT_LOAD_PAGE_ERROR;
        public static final PrimeUpsellResult RESULT_OFFER_PAGE_NOT_DISPLAYED;
        public static final PrimeUpsellResult RESULT_SIGNUP_FAILURE;
        public static final PrimeUpsellResult RESULT_SIGNUP_SUCCESS;
        public static final PrimeUpsellResult RESULT_USER_CANCELLED;

        public static PrimeUpsellResult valueOf(String s)
        {
            return (PrimeUpsellResult)Enum.valueOf(com/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult, s);
        }

        public static PrimeUpsellResult[] values()
        {
            return (PrimeUpsellResult[])$VALUES.clone();
        }

        static 
        {
            RESULT_USER_CANCELLED = new PrimeUpsellResult("RESULT_USER_CANCELLED", 0);
            RESULT_SIGNUP_SUCCESS = new PrimeUpsellResult("RESULT_SIGNUP_SUCCESS", 1);
            RESULT_SIGNUP_FAILURE = new PrimeUpsellResult("RESULT_SIGNUP_FAILURE", 2);
            RESULT_OFFER_PAGE_NOT_DISPLAYED = new PrimeUpsellResult("RESULT_OFFER_PAGE_NOT_DISPLAYED", 3);
            RESULT_LOAD_PAGE_ERROR = new PrimeUpsellResult("RESULT_LOAD_PAGE_ERROR", 4);
            $VALUES = (new PrimeUpsellResult[] {
                RESULT_USER_CANCELLED, RESULT_SIGNUP_SUCCESS, RESULT_SIGNUP_FAILURE, RESULT_OFFER_PAGE_NOT_DISPLAYED, RESULT_LOAD_PAGE_ERROR
            });
        }

        private PrimeUpsellResult(String s, int i)
        {
            super(s, i);
        }
    }

    private class PrimeWebViewClient extends MShopWebViewClient
    {

        final PrimeUpsellActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            PrimeUpsellHelper.primePageFinishLoading();
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            PrimeUpsellHelper.primePageFinishLoading();
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            PrimeUpsellHelper.primePageFinishLoading();
        }

        public PrimeWebViewClient(CordovaInterface cordovainterface)
        {
            this$0 = PrimeUpsellActivity.this;
            super(cordovainterface, new PrimeNavManager());
        }
    }


    private PrimeUpsellResult mPrimeUpsellResult;

    public PrimeUpsellActivity()
    {
        mPrimeUpsellResult = PrimeUpsellResult.RESULT_USER_CANCELLED;
    }

    protected MShopWebViewClient createWebViewClient()
    {
        return new PrimeWebViewClient(this);
    }

    protected MShopWebViewContainer createWebViewContainer()
    {
        MShopWebViewContainer mshopwebviewcontainer = new MShopWebViewContainer(this, null, createWebViewClient(), this);
        mshopwebviewcontainer.setProgressHideSpinner(90);
        return mshopwebviewcontainer;
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && !getWebView().canGoBack() && (getWebViewContainer().isShowingSpinner() || getWebViewContainer().isWebViewReceivedError()))
        {
            mPrimeUpsellResult = PrimeUpsellResult.RESULT_OFFER_PAGE_NOT_DISPLAYED;
        }
        return super.dispatchKeyEvent(keyevent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStopBehavior(0);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        PrimeUpsellHelper.primeUpsellFinished(mPrimeUpsellResult);
    }

    protected void onNewIntent(Intent intent)
    {
        mPrimeUpsellResult = PrimeUpsellResult.RESULT_USER_CANCELLED;
        super.onNewIntent(intent);
    }

    protected void onResume()
    {
        super.onResume();
        ActionBarHelper.hideActionBar(this);
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public boolean onSearchRequested(String s, boolean flag)
    {
        return false;
    }

    protected void registerPushNotification()
    {
    }

    protected void updateGNOMenuItems()
    {
    }


/*
    static PrimeUpsellResult access$002(PrimeUpsellActivity primeupsellactivity, PrimeUpsellResult primeupsellresult)
    {
        primeupsellactivity.mPrimeUpsellResult = primeupsellresult;
        return primeupsellresult;
    }

*/
}
