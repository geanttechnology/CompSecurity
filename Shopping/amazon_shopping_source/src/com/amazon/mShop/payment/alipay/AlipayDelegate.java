// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.payment.alipay;

import android.content.Context;
import android.net.Uri;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.web.MShopWebActivity;

// Referenced classes of package com.amazon.mShop.payment.alipay:
//            AlipayAdapterStatus, AlipayAdapter, AlipayCallback

public class AlipayDelegate
{
    public static class Factory
    {

        public static AlipayDelegate getInstance()
        {
            return AlipayDelegate.SINGLETON_INSTANCE;
        }

        public Factory()
        {
        }
    }


    private static final AlipayDelegate SINGLETON_INSTANCE = new AlipayDelegate();

    private AlipayDelegate()
    {
    }

    private void navigateBackFromAlipay(MShopWebActivity mshopwebactivity, String s, AlipayAdapterStatus alipayadapterstatus, String s1)
    {
        Object obj = s;
        if (AlipayAdapterStatus.SERVICE_INVOKE_SUCCESS.equals(alipayadapterstatus) && AlipayAdapter.Factory.getInstance().isPaymentSuccess(s1))
        {
            s1 = AlipayAdapter.Factory.getInstance().getResultAsUriQueryParam(s1);
            if (!Util.isEmpty(s1))
            {
                obj = new StringBuilder(s);
                alipayadapterstatus = null;
                Uri uri = Uri.parse(s);
                s = alipayadapterstatus;
                if (uri != null)
                {
                    s = uri.getQuery();
                }
                if (Util.isEmpty(s))
                {
                    ((StringBuilder) (obj)).append("?");
                } else
                {
                    ((StringBuilder) (obj)).append("&");
                }
                ((StringBuilder) (obj)).append(s1);
                obj = ((StringBuilder) (obj)).toString();
            }
            mshopwebactivity.getWebView().loadUrl(((String) (obj)));
            return;
        } else
        {
            ActivityUtils.startHomeActivity(mshopwebactivity);
            return;
        }
    }

    public void payWithAlipay(final MShopWebActivity activity, String s, final String returnUrl)
    {
        if (activity == null || !Util.isEmpty(s) || !Util.isEmpty(returnUrl))
        {
            activity.setSkipStopBehavior(true);
            AlipayAdapterStatus alipayadapterstatus = AlipayAdapterStatus.UNDEFINED;
            if (!AlipayAdapter.Factory.getInstance().pay(activity, s, new AlipayCallback() {

        final AlipayDelegate this$0;
        final MShopWebActivity val$activity;
        final String val$returnUrl;

        public void onPaymentFinish(AlipayAdapterStatus alipayadapterstatus1, String s1)
        {
            activity.setSkipStopBehavior(false);
            navigateBackFromAlipay(activity, returnUrl, alipayadapterstatus1, s1);
        }

            
            {
                this$0 = AlipayDelegate.this;
                activity = mshopwebactivity;
                returnUrl = s;
                super();
            }
    }).equals(AlipayAdapterStatus.ADAPTER_INVOKE_SUCCESS))
            {
                activity.setSkipStopBehavior(false);
                activity.getWebView().loadUrl(returnUrl);
                return;
            }
        }
    }

    public void setCookie(Context context, String s)
    {
        String s1 = "0";
        if (AlipayAdapter.Factory.getInstance().isAlipayInstalled(context))
        {
            s1 = "1";
        }
        context = (new StringBuilder()).append("amzn-app-alipay=").append(s1).append("; Domain=").append(s).toString();
        CookieManager.getInstance().setCookie((new StringBuilder()).append("www").append(s).toString(), context);
    }



}
