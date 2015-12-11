// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.nav;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.cart.web.WebCartActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.details.FriendAppAction;
import com.amazon.mShop.details.FriendAppProxy;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.opl.PurchaseParams;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mShop.web.MShopWebView;
import com.amazon.mShop.wishlist.web.WebWishListActivity;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.nav.MASHNavDelegateImpl;

public class AmazonNavManager extends MASHNavDelegateImpl
{

    public AmazonNavManager()
    {
    }

    protected boolean handleAmznappScheme(Context context, Uri uri)
    {
        if (!"amznapp".equalsIgnoreCase(uri.getScheme()) || !"page".equalsIgnoreCase(uri.getHost()) || !(context instanceof MShopWebActivity)) goto _L2; else goto _L1
_L1:
        String s;
        context = (MShopWebView)((MShopWebActivity)context).getWebView();
        s = uri.getQueryParameter("app-action");
        if (!"dismiss".equals(s)) goto _L4; else goto _L3
_L3:
        if (!context.canGoBack()) goto _L6; else goto _L5
_L5:
        context.setParamtersToJS(WebUtils.parseQueryToJsObject(uri));
        context.goBack();
_L7:
        return true;
_L6:
        if (context.getContext() instanceof AmazonActivity)
        {
            ((AmazonActivity)context.getContext()).popView();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if ("dismiss-all".equals(s))
        {
            handleDismissAll(context, uri);
        } else
        if ("refresh".equals(s))
        {
            context.reload();
        }
        if (true) goto _L7; else goto _L2
_L2:
        return false;
    }

    protected boolean handleBrowse(Uri uri, Context context)
    {
        ActivityUtils.startCategoryBrowseActivity(context, uri);
        return true;
    }

    protected boolean handleCancelOrder(Uri uri, Context context)
    {
        Object obj = null;
        String s = obj;
        if (uri != null)
        {
            s = obj;
            if (uri.isHierarchical())
            {
                s = uri.getQueryParameter("orderID");
            }
        }
        return ActivityUtils.startYourOrdersActivity(context, s, "order_to_cancel", null, -1);
    }

    protected boolean handleCheckout(Uri uri, Context context)
    {
        Object obj = null;
        PurchaseParams purchaseparams = obj;
        if (context instanceof WebCartActivity)
        {
            purchaseparams = obj;
            if (uri != null)
            {
                purchaseparams = obj;
                if (!Util.isEmpty(uri.toString()))
                {
                    uri = uri.toString();
                    purchaseparams = obj;
                    if (uri.contains("app-action=checkout"))
                    {
                        uri = uri.replace("app-action=checkout", "");
                        purchaseparams = new PurchaseParams();
                        purchaseparams.setCheckoutUrl(uri);
                    }
                }
            }
        }
        uri = purchaseparams;
        if (purchaseparams == null)
        {
            uri = new PurchaseParams();
        }
        uri.setIsCartPurchase(true);
        ActivityUtils.startPurchaseActivity(context, uri);
        return true;
    }

    protected boolean handleDeals(Uri uri, Context context)
    {
        return ActivityUtils.startDealsActivity(context, null, null);
    }

    protected boolean handleDetailPage(Uri uri, Context context)
    {
        String s3 = uri.getQueryParameter("asin");
        String s5 = uri.getQueryParameter("clickstream-tag");
        String s = uri.getQueryParameter("colid");
        String s1 = uri.getQueryParameter("coliid");
        String s2 = uri.getQueryParameter("m");
        String s4 = uri.getQueryParameter("offer-id");
        if (!Util.isEmpty(s5))
        {
            uri = new ClickStreamTag(s5);
        } else
        if (context instanceof WebCartActivity)
        {
            uri = ClickStreamTag.ORIGIN_CART;
        } else
        if (context instanceof WebWishListActivity)
        {
            uri = ClickStreamTag.ORIGIN_WISHLIST;
        } else
        {
            uri = ClickStreamTag.ORIGIN_DEFAULT;
        }
        uri = new ProductController(s3, uri);
        uri.setListId(s);
        uri.setListItemId(s1);
        uri.setMerchantId(s2);
        uri.setOfferId(s4);
        ActivityUtils.launchDetailsPage(context, uri, new int[0]);
        return true;
    }

    protected boolean handleDigitalStore(Uri uri, Context context)
    {
        FriendAppProxy friendappproxy = com.amazon.mShop.details.FriendAppProxy.Factory.getProxy(context, uri.toString());
        if (friendappproxy != null)
        {
            uri = friendappproxy.getIntentForFriendApp(context, uri.toString());
            if (uri != null)
            {
                FriendAppAction.logRefMarker(friendappproxy);
                FriendAppAction.startProxyActivity(context, friendappproxy, uri);
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected void handleDismissAll(WebView webview, Uri uri)
    {
        webview = (AmazonActivity)webview.getContext();
        webview.setResult(-1);
        webview.finish();
    }

    protected boolean handleHome(Uri uri, Context context)
    {
        ActivityUtils.startHomeActivity(context);
        return true;
    }

    protected boolean handleMobileAdsUserPreferences(Uri uri, Context context)
    {
        return ActivityUtils.startAdsWebActivity(context, uri);
    }

    protected boolean handleModal(Uri uri, Context context)
    {
        return ActivityUtils.startMShopModalWebActivity((AmazonActivity)context, uri);
    }

    protected boolean handleOrderHistory(Uri uri, Context context)
    {
        return ActivityUtils.startYourOrdersActivity(context);
    }

    protected boolean handlePushNotificationSettings(Uri uri, Context context)
    {
        Object obj = null;
        String s = obj;
        if (uri != null)
        {
            s = obj;
            if (uri.isHierarchical())
            {
                s = uri.getQueryParameter("category");
            }
        }
        return ActivityUtils.startNotificationSettingActivity(context, s);
    }

    protected boolean handleRecommendations(Uri uri, Context context)
    {
        return ActivityUtils.startRecommendationsActivity(context);
    }

    protected boolean handleSearch(Uri uri, Context context)
    {
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        AmazonActivity amazonactivity = (AmazonActivity)context;
        String s3 = obj2;
        String s2 = obj4;
        String s1 = obj3;
        context = obj1;
        String s = obj;
        if (uri != null)
        {
            s3 = obj2;
            s2 = obj4;
            s1 = obj3;
            context = obj1;
            s = obj;
            if (uri.isHierarchical())
            {
                s = uri.getQueryParameter("keyword");
                s1 = uri.getQueryParameter("filter");
                context = s1;
                if (s1 != null)
                {
                    context = s1.replace('+', '\n');
                }
                s3 = uri.getQueryParameter("category-name");
                s2 = uri.getQueryParameter("clickstream-tag");
                s1 = uri.getQueryParameter("data-url");
            }
        }
        return ActivityUtils.startSearchActivity(amazonactivity, (new SearchIntentBuilder(amazonactivity)).query(s).filter(context).categoryName(s3).dataUrl(s1).clickStreamOrigin(s2).build());
    }

    protected boolean handleViewCart(Uri uri, Context context)
    {
        RefMarkerObserver.logRefMarker("crt_html_nav");
        return ActivityUtils.startCartActivity(context);
    }

    protected boolean handleViewOrder(Uri uri, Context context)
    {
        Object obj = null;
        String s = obj;
        if (uri != null)
        {
            s = obj;
            if (uri.isHierarchical())
            {
                s = uri.getQueryParameter("order-id");
            }
        }
        return ActivityUtils.startYourOrdersActivity(context, s, "order_to_view", null, -1);
    }

    protected boolean handleViewWishlist(Uri uri, Context context)
    {
        RefMarkerObserver.logRefMarker("wl_html_nav");
        return ActivityUtils.startWishListActivity(context);
    }

    protected boolean handleWebView(Uri uri, Context context)
    {
        Intent intent = new Intent(context, com/amazon/mShop/web/MShopWebActivity);
        uri = uri.getQueryParameter("url");
        intent.putExtra(WebConstants.getWebViewUrlKey(), uri);
        context.startActivity(intent);
        return true;
    }

    protected boolean handleYourAccount(Uri uri, Context context)
    {
        return ActivityUtils.startYourAccountActivity(context);
    }
}
