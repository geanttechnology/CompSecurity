// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.error.AmazonErrorInfo;
import com.amazon.mShop.net.ErrorExceptionMetricsObserver;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.WebViewErrorException;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ApplicationException;

// Referenced classes of package com.amazon.mShop.util:
//            ConfigUtils, UIUtils, UpgradeUtil, ActivityUtils

public class AmazonErrorUtils
{

    public AmazonErrorUtils()
    {
    }

    public static void postExceptionToServer(Context context, Exception exception)
    {
        if (ConfigUtils.isEnabledForApp(context, com.amazon.mShop.android.lib.R.bool.config_reportErrorExceptionMetricsToPmet))
        {
            ErrorExceptionMetricsObserver.logMetric(exception);
        }
    }

    public static void postWebViewError(int i, String s, String s1)
    {
        ErrorExceptionMetricsObserver.logMetric(new WebViewErrorException(i, s, s1));
    }

    public static void reportError(AmazonActivity amazonactivity, int i, com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, View view)
    {
        reportError(amazonactivity, i, amazonerrorboxactionlistener, view, ((String) (null)), ((String) (null)));
    }

    public static void reportError(AmazonActivity amazonactivity, int i, com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, View view, int j, int k)
    {
        reportError(amazonactivity, i, amazonerrorboxactionlistener, view, amazonactivity.getResources().getString(j), amazonactivity.getResources().getString(k));
    }

    public static void reportError(AmazonActivity amazonactivity, int i, com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, View view, String s, String s1)
    {
        reportError(amazonactivity, new AmazonErrorInfo(i, amazonerrorboxactionlistener, s, s1), view);
    }

    public static void reportError(AmazonActivity amazonactivity, AmazonErrorInfo amazonerrorinfo, View view)
    {
        amazonactivity.reportErrorOnView(amazonerrorinfo, UIUtils.createErrorBox(amazonactivity, amazonerrorinfo), view);
    }

    public static void reportErrorWithGeneralErrorMessageAndGoToAmazonHome(AmazonActivity amazonactivity, int i)
    {
        reportError(amazonactivity, i, new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener(amazonactivity) {

            final AmazonActivity val$amazonActivity;

            public void onActionButtonClick(int j)
            {
                ActivityUtils.startHomeActivity(amazonActivity);
            }

            
            {
                amazonActivity = amazonactivity;
                super();
            }
        }, amazonactivity.getCurrentView(), com.amazon.mShop.android.lib.R.string.error_something_wrong_will_fix_message, com.amazon.mShop.android.lib.R.string.go_to_amazon_home);
    }

    public static void reportMShopServerError(AmazonActivity amazonactivity, com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, View view, Exception exception)
    {
        if (exception instanceof ApplicationException)
        {
            amazonerrorboxactionlistener = (ApplicationException)exception;
            if (ApplicationException.CLIENT_UPGRADE_REQUIRED.equals(amazonerrorboxactionlistener.getErrorCode()))
            {
                UpgradeUtil.showForceUpdateDialog(amazonactivity);
                return;
            } else
            {
                reportMShopServerError(amazonactivity, null, view, exception, amazonactivity.getString(com.amazon.mShop.android.lib.R.string.ok));
                return;
            }
        } else
        {
            reportMShopServerError(amazonactivity, amazonerrorboxactionlistener, view, exception, null);
            return;
        }
    }

    public static void reportMShopServerError(AmazonActivity amazonactivity, com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, View view, Exception exception, String s)
    {
        byte byte0 = 1;
        String s1 = null;
        if (NetInfo.hasNetworkConnection())
        {
            byte0 = 4;
            s1 = UIUtils.getMessageForException(amazonactivity, exception);
        }
        reportError(amazonactivity, byte0, amazonerrorboxactionlistener, view, s1, s);
        postExceptionToServer(amazonactivity, exception);
    }

    public static void reportWebViewClientError(AmazonActivity amazonactivity, WebView webview, View view)
    {
        showWebPageRetryDialog(amazonactivity, webview, view);
    }

    public static void showWebPageRetryDialog(AmazonActivity amazonactivity, WebView webview, View view)
    {
        byte byte0;
        if (NetInfo.hasNetworkConnection())
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable(amazonactivity, byte0, webview, view) {

            final AmazonActivity val$amazonActivity;
            final int val$errorCode;
            final View val$reportOnView;
            final WebView val$view;

            public void run()
            {
                AmazonErrorUtils.reportError(amazonActivity, errorCode, new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

                    final _cls1 this$0;

                    public void onActionButtonClick(int i)
                    {
                        view.clearView();
                        view.reload();
                        view.setVisibility(0);
                    }

            
            {
                this$0 = _cls1.this;
                super();
            }
                }, reportOnView);
            }

            
            {
                amazonActivity = amazonactivity;
                errorCode = i;
                view = webview;
                reportOnView = view1;
                super();
            }
        });
    }
}
