// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.cart.web.WebCartActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.details.ProductImagesView;
import com.amazon.mShop.mash.OfferListingView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.opl.PurchaseParams;
import com.amazon.mShop.payment.alipay.AlipayDelegate;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.social.FacebookConnectHelper;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.security.WebViewSecurity;
import com.amazon.mShop.wishlist.AddToWishlistAction;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.mobile.mash.util.MASHUtil;
import com.amazon.rio.j2me.client.services.mShop.MultiImage;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebView, MShopWebActivity, MShopWebViewNotification, 
//            NativeAppNotification

class MShopWebViewJavaScriptClient
{
    class _cls1OnButtonClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        private int mButtonIndex;
        final _cls2 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            class _cls2
                implements Runnable
            {

                final MShopWebViewJavaScriptClient this$0;
                final String val$buttonTitles[];
                final String val$callbackId;
                final String val$cancelButtonTitle;
                final String val$message;
                final String val$title;

                public void run()
                {
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
                    if (isDefined(title))
                    {
                        builder.setTitle(title);
                    }
                    if (isDefined(message))
                    {
                        builder.setMessage(message);
                    }
                    if (!Util.isEmpty(buttonTitles) && buttonTitles.length >= 1)
                    {
                        builder.setPositiveButton(buttonTitles[0], new _cls1OnButtonClickListener(0));
                        if (buttonTitles.length >= 2)
                        {
                            builder.setNeutralButton(buttonTitles[1], new _cls1OnButtonClickListener(1));
                        }
                    }
                    if (isDefined(cancelButtonTitle))
                    {
                        int i;
                        if (buttonTitles != null)
                        {
                            i = buttonTitles.length;
                        } else
                        {
                            i = 0;
                        }
                        builder.setNegativeButton(cancelButtonTitle, new _cls1OnButtonClickListener(i));
                    }
                    builder.setIcon(0);
                    builder.create().show();
                }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                title = s;
                message = s1;
                callbackId = s2;
                buttonTitles = as;
                cancelButtonTitle = s3;
                super();
            }
            }

            MASHcallback.execSuccessCallback(mWebView, callbackId, String.valueOf(mButtonIndex), false);
        }

        _cls1OnButtonClickListener(int i)
        {
            this$1 = _cls2.this;
            super();
            mButtonIndex = i;
        }
    }

    public static class MASHcallback
    {

        public static void execFailCallback(WebView webview, String s, int i)
        {
            String s1 = (new StringBuilder()).append("{message:{code:").append(i).append("}, keepCallback:false}").toString();
            webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackError(").append(s).append(",").append(s1).append(");").toString());
        }

        public static void execFailCallback(WebView webview, String s, String s1, boolean flag)
        {
            if (Util.isEmpty(s1))
            {
                s1 = (new StringBuilder()).append("{keepCallback:").append(flag).append("}").toString();
            } else
            {
                s1 = (new StringBuilder()).append("{message:\"").append(s1).append("\",keepCallback:").append(flag).append("}").toString();
            }
            webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackError(").append(s).append(",").append(s1).append(");").toString());
        }

        public static void execSuccessCallback(WebView webview, String s, String s1, boolean flag)
        {
            if (Util.isEmpty(s1))
            {
                s1 = (new StringBuilder()).append("{keepCallback:").append(flag).append("}").toString();
            } else
            {
                s1 = (new StringBuilder()).append("{message:").append(s1).append(",keepCallback:").append(flag).append("}").toString();
            }
            webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackSuccess(").append(s).append(",").append(s1).append(");").toString());
        }

        public MASHcallback()
        {
        }
    }


    public static final String JAVASCRIPT_INTERFACE_NAME = "webclient";
    private final Context mContext;
    private final MASHNavDelegate mNavigationManager;
    private final MShopWebView mWebView;
    private final MShopWebViewContainer mWebViewContainer;

    public MShopWebViewJavaScriptClient(Context context, MShopWebViewContainer mshopwebviewcontainer, MASHNavDelegate mashnavdelegate)
    {
        mContext = context;
        mWebViewContainer = mshopwebviewcontainer;
        mWebView = (MShopWebView)mshopwebviewcontainer.getWebView();
        mNavigationManager = mashnavdelegate;
    }

    private Intent getShareChooserIntent(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        s = new Intent("android.intent.action.SEND");
        s.setType("text/plain");
        if (isDefined(s4))
        {
            s.putExtra("android.intent.extra.SUBJECT", s4);
        }
        if (isDefined(s3))
        {
            s.putExtra("android.intent.extra.TEXT", s3);
        }
        if (isDefined(s5))
        {
            s.putExtra("imgUrl", s5);
        }
        if (isDefined(s6))
        {
            s.putExtra("url", s6);
        }
        return Intent.createChooser(s, mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.sharing_share));
    }

    private boolean isDefined(String s)
    {
        return s != null && s.length() != 0 && !"undefined".equalsIgnoreCase(s);
    }

    public void addToWishList(final String asin)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$asin;

            public void run()
            {
                (new AddToWishlistAction(true)).addItem((AmazonActivity)mContext, asin);
                RefMarkerObserver.logRefMarker("dp_buy_wl");
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                asin = s;
                super();
            }
        });
    }

    public void buyAsin(final String asin, final String offerId, final String listId, final String listItemId, final String dealId, final String clickStream, final String oneClickShippingSpeed)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$asin;
            final String val$clickStream;
            final String val$dealId;
            final String val$listId;
            final String val$listItemId;
            final String val$offerId;
            final String val$oneClickShippingSpeed;

            public void run()
            {
                Object obj;
                String s;
                String s1;
                String s2;
                String s3;
                String s4;
                if (isDefined(clickStream))
                {
                    obj = clickStream;
                } else
                if ((mContext instanceof AmazonActivity) && !Util.isEmpty(((AmazonActivity)mContext).getClickStreamOrigin()))
                {
                    obj = ((AmazonActivity)mContext).getClickStreamOrigin();
                } else
                {
                    obj = ClickStreamTag.ORIGIN_DEFAULT.getTag();
                }
                s1 = dealId;
                s = s1;
                if (!isDefined(s1))
                {
                    s = null;
                }
                s2 = listId;
                s1 = s2;
                if (!isDefined(s2))
                {
                    s1 = null;
                }
                s3 = listItemId;
                s2 = s3;
                if (!isDefined(s3))
                {
                    s2 = null;
                }
                s4 = oneClickShippingSpeed;
                s3 = s4;
                if (!isDefined(s4))
                {
                    s3 = null;
                }
                obj = new PurchaseParams(asin, offerId, s1, s2, s, s3, ((String) (obj)));
                ActivityUtils.startPurchaseActivity(mContext, ((PurchaseParams) (obj)));
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                clickStream = s;
                dealId = s1;
                listId = s2;
                listItemId = s3;
                oneClickShippingSpeed = s4;
                asin = s5;
                offerId = s6;
                super();
            }
        });
    }

    public void connectWithFacebook(String s, String s1, String s2, String s3)
    {
        Bundle bundle = new Bundle();
        bundle.putString("appID", s);
        bundle.putString("permissions", s1);
        bundle.putString("successCallback", s2);
        bundle.putString("failureCallback", s3);
        (new FacebookConnectHelper()).launchFacebookLogin(mWebView, bundle, mContext);
    }

    public void finishSpinnerOnNonWebviewAnimation()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;

            public void run()
            {
                if (mWebViewContainer != null)
                {
                    mWebViewContainer.dismissSpinnerOnNonWebviewAnimation();
                }
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                super();
            }
        });
    }

    public void finishSpinnerWebviewAnimated(final String animationTargetUrl)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$animationTargetUrl;

            public void run()
            {
                WebView webview;
                if (mWebViewContainer != null && mWebViewContainer.getWebView() != null)
                {
                    webview = mWebViewContainer.getWebView();
                } else
                {
                    webview = null;
                }
                if (webview != null && !Util.isEmpty(webview.getUrl()) && Uri.decode(webview.getUrl()).equals(animationTargetUrl))
                {
                    mWebViewContainer.webviewAnimated();
                }
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                animationTargetUrl = s;
                super();
            }
        });
    }

    public long getRealClickTime()
    {
        if (mContext instanceof MShopWebActivity)
        {
            return ((MShopWebActivity)mContext).getRealClickTime();
        } else
        {
            return -1L;
        }
    }

    public void goBack()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;

            public void run()
            {
                if (mWebView.canGoBack())
                {
                    mWebView.goBack();
                    return;
                } else
                {
                    ((AmazonActivity)mContext).popView();
                    return;
                }
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                super();
            }
        });
    }

    public void hideBottomButton(final int id)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final int val$id;

            public void run()
            {
                mWebViewContainer.hideBottomButton(id);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                id = i;
                super();
            }
        });
    }

    public void hideProgressDialog()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;

            public void run()
            {
                mWebViewContainer.hideProgressDialog();
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                super();
            }
        });
    }

    public void navigate(String s)
    {
        navigate(s, null, null);
    }

    public void navigate(final String url, final String transitionEffect, final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;
            final String val$transitionEffect;
            final String val$url;

            public void run()
            {
                boolean flag;
                boolean flag1 = true;
                flag = flag1;
                if (isDefined(transitionEffect))
                {
                    flag = flag1;
                    if ("none".equals(transitionEffect))
                    {
                        flag = false;
                    }
                }
                if (!isDefined(url)) goto _L2; else goto _L1
_L1:
                String s;
                Uri uri;
                s = MASHUtil.canonicalizeIfRelativeUrl(url, mWebView);
                uri = Uri.parse(s);
                if (mNavigationManager.navigate(s, mContext)) goto _L4; else goto _L3
_L3:
                boolean flag2 = WebViewSecurity.shouldBlockWebViewLoading(mWebView, s);
                if (!flag2) goto _L6; else goto _L5
_L5:
                mWebViewContainer.showSslError(5);
                WebViewSecurity.logMetricsForHTTPRequest(mWebView.getUrl(), s, flag2);
_L11:
                return;
_L6:
                if (flag && mWebViewContainer.getTransitionManager() != null)
                {
                    mWebViewContainer.navigateForward(null);
                }
                mWebView.loadUrl(s);
_L9:
                if (isDefined(callbackId))
                {
                    MASHcallback.execSuccessCallback(mWebView, callbackId, null, false);
                    return;
                }
                  goto _L7
_L4:
                WebUtils.logRefMarkerForWebPage(uri);
                return;
_L2:
                if (flag && mWebViewContainer.getTransitionManager() != null)
                {
                    mWebViewContainer.navigateForward(null);
                }
                if (true) goto _L9; else goto _L8
_L8:
_L7:
                if (true) goto _L11; else goto _L10
_L10:
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                transitionEffect = s;
                url = s1;
                callbackId = s2;
                super();
            }
        });
    }

    public void openInExternalBrowser(String s)
    {
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
        mContext.startActivity(s);
    }

    public void payWithAlipay(String s, String s1)
    {
        if (!Util.isEmpty(s) && !Util.isEmpty(s1) && (mContext instanceof MShopWebActivity))
        {
            com.amazon.mShop.payment.alipay.AlipayDelegate.Factory.getInstance().payWithAlipay((MShopWebActivity)mContext, s, s1);
        }
    }

    public void registerForNotifications(final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;

            public void run()
            {
                MASHcallback.execFailCallback(mWebView, callbackId, 1003);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                callbackId = s;
                super();
            }
        });
    }

    public void setBottomButtonEnabled(final int id, final boolean isEnabled)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final int val$id;
            final boolean val$isEnabled;

            public void run()
            {
                mWebViewContainer.setBottomButtonEnabled(id, isEnabled);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                id = i;
                isEnabled = flag;
                super();
            }
        });
    }

    public void setBottomButtonOnTouch(final int id, final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;
            final int val$id;

            public void run()
            {
                mWebViewContainer.setBottomButtonOnTouch(id, callbackId);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                id = i;
                callbackId = s;
                super();
            }
        });
    }

    public void setBottomButtonText(final int id, final String text)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final int val$id;
            final String val$text;

            public void run()
            {
                mWebViewContainer.setBottomButtonText(id, text);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                id = i;
                text = s;
                super();
            }
        });
    }

    public void share(final String subject, final String messagePlain)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$messagePlain;
            final String val$subject;

            public void run()
            {
                mContext.startActivity(getShareChooserIntent(null, null, null, messagePlain, subject, null, null));
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                messagePlain = s;
                subject = s1;
                super();
            }
        });
    }

    public void share_1_3_0(final String messagePlain160, final String messagePlain140, final String messageHTML, final String messagePlain, final String subject, final String imageURL, final String url)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$imageURL;
            final String val$messageHTML;
            final String val$messagePlain;
            final String val$messagePlain140;
            final String val$messagePlain160;
            final String val$subject;
            final String val$url;

            public void run()
            {
                mContext.startActivity(getShareChooserIntent(messagePlain160, messagePlain140, messageHTML, messagePlain, subject, imageURL, url));
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                messagePlain160 = s;
                messagePlain140 = s1;
                messageHTML = s2;
                messagePlain = s3;
                subject = s4;
                imageURL = s5;
                url = s6;
                super();
            }
        });
    }

    public void showAlert(final String title, final String message, final String cancelButtonTitle, final String buttonTitles[], final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new _cls2());
    }

    public void showBottomButton(final int id, final String text, final boolean isEnabled, final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;
            final int val$id;
            final boolean val$isEnabled;
            final String val$text;

            public void run()
            {
                mWebViewContainer.showBottomButton(id, text, isEnabled, callbackId);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                id = i;
                text = s;
                isEnabled = flag;
                callbackId = s1;
                super();
            }
        });
    }

    public void showChooser(final String title, final String buttonTitles[], final String cancelButtonTitle, final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$buttonTitles[];
            final String val$callbackId;
            final String val$cancelButtonTitle;
            final String val$title;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(mContext);
                if (isDefined(title))
                {
                    builder.setTitle(title);
                }
                if (!Util.isEmpty(buttonTitles))
                {
                    String as[] = new String[buttonTitles.length];
                    for (int i = 0; i < buttonTitles.length; i++)
                    {
                        as[i] = Html.fromHtml(buttonTitles[i]).toString();
                    }

                    builder.setItems(as, new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            MASHcallback.execSuccessCallback(mWebView, callbackId, String.valueOf(i), false);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
                if (isDefined(cancelButtonTitle))
                {
                    int j;
                    if (buttonTitles != null)
                    {
                        j = buttonTitles.length;
                    } else
                    {
                        j = 0;
                    }
                    builder.setNegativeButton(cancelButtonTitle, j. new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;
                        final int val$buttonsLength;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            MASHcallback.execSuccessCallback(mWebView, callbackId, String.valueOf(buttonsLength), false);
                        }

            
            {
                this$1 = final__pcls1;
                buttonsLength = I.this;
                super();
            }
                    });
                }
                builder.setIcon(0);
                builder.create().show();
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                title = s;
                buttonTitles = as;
                callbackId = s1;
                cancelButtonTitle = s2;
                super();
            }
        });
    }

    public void showImageGallery(final String title, final int startIndex, final String imageUrls[])
    {
        if (mContext instanceof AmazonActivity)
        {
            RefMarkerObserver.logRefMarker("dp_img");
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final MShopWebViewJavaScriptClient this$0;
                final String val$imageUrls[];
                final int val$startIndex;
                final String val$title;

                public void run()
                {
                    ArrayList arraylist = new ArrayList();
                    String as[] = imageUrls;
                    int j = as.length;
                    for (int i = 0; i < j; i++)
                    {
                        String s = as[i];
                        MultiImage multiimage = new MultiImage();
                        multiimage.setStandardUrl(s);
                        arraylist.add(multiimage);
                    }

                    ProductImagesView productimagesview = (ProductImagesView)View.inflate(mContext, com.amazon.mShop.android.lib.R.layout.product_images, null);
                    productimagesview.setStartIndex(startIndex);
                    productimagesview.setImagesAndTitle(title, arraylist);
                    ((AmazonActivity)mContext).pushView(productimagesview);
                }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                imageUrls = as;
                startIndex = i;
                title = s;
                super();
            }
            });
        }
    }

    public void showLoginDialog(final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;

            public void run()
            {
                ((AmazonActivity)mContext).authenticateUser(new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

                    final _cls21 this$1;

                    public void userCancelledSignIn()
                    {
                        MASHcallback.execFailCallback(mWebView, callbackId, "CANCELED", false);
                    }

                    public void userSuccessfullySignedIn()
                    {
                        MASHcallback.execSuccessCallback(mWebView, callbackId, null, false);
                    }

            
            {
                this$1 = _cls21.this;
                super();
            }
                }, null);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                callbackId = s;
                super();
            }
        });
    }

    public void showNotificationSettings(final String category)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$category;

            public void run()
            {
                String s = "http://page?app-action=push-notification-settings";
                if (isDefined(category))
                {
                    s = (new StringBuilder()).append("http://page?app-action=push-notification-settings").append("&category=").append(category).toString();
                }
                mNavigationManager.navigate(s, mContext);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                category = s;
                super();
            }
        });
    }

    public void showOfferListingPage(final String asin)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$asin;

            public void run()
            {
                OfferListingView.show((AmazonActivity)mContext, asin, null, null);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                asin = s;
                super();
            }
        });
    }

    public void showProgressDialog(final String dialogTitle, final String callbackId)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final String val$callbackId;
            final String val$dialogTitle;

            public void run()
            {
                android.content.DialogInterface.OnCancelListener oncancellistener = new android.content.DialogInterface.OnCancelListener() {

                    final _cls19 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        if (isDefined(callbackId))
                        {
                            MASHcallback.execFailCallback(mWebView, callbackId, null, false);
                        }
                    }

            
            {
                this$1 = _cls19.this;
                super();
            }
                };
                mWebViewContainer.showAmazonProgressDialog(dialogTitle, oncancellistener);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                callbackId = s;
                dialogTitle = s1;
                super();
            }
        });
    }

    public boolean updateCartCount(final int cartCount)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final int val$cartCount;

            public void run()
            {
                MShopWebViewNotification.notifyCartCountChanged(cartCount);
                if (!(mContext instanceof WebCartActivity))
                {
                    NativeAppNotification.notifyNativeCartChanged(cartCount);
                }
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                cartCount = i;
                super();
            }
        });
        return true;
    }

    public void vibrate(final int milliSeconds)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final MShopWebViewJavaScriptClient this$0;
            final int val$milliSeconds;

            public void run()
            {
                UIUtils.vibrate(mContext, milliSeconds);
            }

            
            {
                this$0 = MShopWebViewJavaScriptClient.this;
                milliSeconds = i;
                super();
            }
        });
    }






}
