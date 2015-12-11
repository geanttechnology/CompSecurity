// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.mobile.mash.nav.MASHNavDelegateImpl;
import com.amazon.now.ChromeStyle;
import com.amazon.now.cart.CartActivity;
import com.amazon.now.detail.DetailsActivity;
import com.amazon.now.home.WelcomeScreen;
import com.amazon.now.home.ZipCheckActivity;
import com.amazon.now.location.Store;
import com.amazon.now.location.StorefrontWebActivity;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.orders.YourOrdersActivity;
import com.amazon.now.restaurants.RestaurantsActivity;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.LocationUtil;
import com.amazon.now.web.CheckoutActivity;
import com.amazon.now.web.ShopPastPurchaseActivity;
import com.amazon.now.web.WebActivity;
import com.amazon.now.web.YourAccountActivity;

public class NavManager extends MASHNavDelegateImpl
{

    private static NavManager sInstance;

    private NavManager()
    {
    }

    public static NavManager getInstance()
    {
        com/amazon/now/mash/NavManager;
        JVM INSTR monitorenter ;
        NavManager navmanager;
        if (sInstance == null)
        {
            sInstance = new NavManager();
        }
        navmanager = sInstance;
        com/amazon/now/mash/NavManager;
        JVM INSTR monitorexit ;
        return navmanager;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean handleSearch(String s, Context context)
    {
        SearchIntentBuilder searchintentbuilder;
        Uri uri;
        String s1;
        boolean flag;
        if (s.contains("/s/"))
        {
            s = s.substring(s.indexOf("/s/"));
        } else
        if (s.contains("/s?"))
        {
            s = s.substring(s.indexOf("/s?"));
        } else
        {
            return false;
        }
        searchintentbuilder = new SearchIntentBuilder(context);
        uri = Uri.parse(s);
        s1 = uri.getQueryParameter("p_95");
        if (!TextUtils.isEmpty(s1))
        {
            searchintentbuilder.storeDiscriminator(s1);
        }
        s1 = uri.getQueryParameter("merchantId");
        if (!TextUtils.isEmpty(s1))
        {
            searchintentbuilder.merchantId(s1);
        }
        searchintentbuilder.dataUrl(s);
        flag = "1".equals(uri.getQueryParameter("newStack"));
        s = searchintentbuilder.build();
        if (flag)
        {
            modifyIntentForNewStack(s);
        }
        context.startActivity(s);
        return true;
    }

    private void handleTel(Uri uri, Context context)
    {
        context.startActivity(new Intent("android.intent.action.DIAL", uri));
    }

    public static void modifyIntentForNewStack(Intent intent)
    {
        intent.addFlags(0x14008000);
    }

    protected boolean handleLogin(Uri uri, Context context)
    {
        String s = uri.getQueryParameter("openid.return_to");
        String s1 = uri.getQueryParameter("siteState");
        if (!TextUtils.isEmpty(s) && (context instanceof WebActivity))
        {
            uri = s;
            if (!TextUtils.isEmpty(s1))
            {
                uri = Uri.parse(s).buildUpon();
                uri.appendQueryParameter("siteState", s1);
                uri = uri.build().toString();
            }
            ((WebActivity)context).authenticateUser(uri);
        }
        return true;
    }

    public boolean navigate(String s, Context context)
    {
        Object obj = Uri.parse(s);
        Object obj1 = ((Uri) (obj)).getPath();
        boolean flag = false;
        if (((Uri) (obj)).isHierarchical())
        {
            flag = "1".equals(((Uri) (obj)).getQueryParameter("newStack"));
        }
        if ("/home".equalsIgnoreCase(((String) (obj1))) || "/postSignIn".equalsIgnoreCase(((String) (obj1))) || "/cart/updatePostalCode".equalsIgnoreCase(((String) (obj1))))
        {
            if (!"0".equals(((Uri) (obj)).getQueryParameter("newStack")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            AppUtils.goHome(context, s, flag);
            flag = true;
        } else
        {
            if ("/zipCheck".equalsIgnoreCase(((String) (obj1))))
            {
                obj = new Intent(context, com/amazon/now/home/ZipCheckActivity);
                ((Intent) (obj)).putExtra("intentUrlKey", s);
                ((Intent) (obj)).putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.LOGO_ONLY));
                if (flag)
                {
                    modifyIntentForNewStack(((Intent) (obj)));
                }
                context.startActivity(((Intent) (obj)));
                return true;
            }
            if ("/start".equalsIgnoreCase(((String) (obj1))))
            {
                s = new Intent(context, com/amazon/now/home/WelcomeScreen);
                s.addFlags(0x14008000);
                if (flag)
                {
                    modifyIntentForNewStack(s);
                }
                context.startActivity(s);
                return true;
            }
            if ("/start/onboard".equalsIgnoreCase(((String) (obj1))))
            {
                s = new Intent(context, com/amazon/now/home/WelcomeScreen);
                s.putExtra("intentKeyChangeLocation", true);
                s.putExtra("intentKeyQueryParameters", ((Uri) (obj)).getQuery());
                if (flag)
                {
                    modifyIntentForNewStack(s);
                }
                context.startActivity(s);
                return true;
            }
            if (s.contains("gp/aw/d/"))
            {
                if (context instanceof DetailsActivity)
                {
                    ((DetailsActivity)context).loadUrl(s);
                } else
                {
                    obj = new Intent(context, com/amazon/now/detail/DetailsActivity);
                    ((Intent) (obj)).putExtra("intentUrlKey", s);
                    if (flag)
                    {
                        modifyIntentForNewStack(((Intent) (obj)));
                    }
                    context.startActivity(((Intent) (obj)));
                }
                return true;
            }
            if ("/about".equalsIgnoreCase(((String) (obj1))))
            {
                obj = new Intent(context, com/amazon/now/web/WebActivity);
                ((Intent) (obj)).putExtra("intentUrlKey", s);
                if (flag)
                {
                    modifyIntentForNewStack(((Intent) (obj)));
                }
                context.startActivity(((Intent) (obj)));
                return true;
            }
            if ("/yourAccount".equalsIgnoreCase(((String) (obj1))))
            {
                YourAccountActivity.startActivity(context, flag);
                return true;
            }
            if ("/shop-past-purchases".equalsIgnoreCase(((String) (obj1))))
            {
                ShopPastPurchaseActivity.startActivity(context, flag);
                return true;
            }
            if ("/yourOrders".equalsIgnoreCase(((String) (obj1))))
            {
                YourOrdersActivity.startActivity(context, flag);
                return true;
            }
            if (obj1 != null && ((String) (obj1)).contains("/checkout/"))
            {
                if (!(context instanceof CheckoutActivity))
                {
                    obj = new Intent(context, com/amazon/now/web/CheckoutActivity);
                    ((Intent) (obj)).putExtra("intentUrlKey", s);
                    ((Intent) (obj)).putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.LOGO_ONLY));
                    if (flag)
                    {
                        modifyIntentForNewStack(((Intent) (obj)));
                    }
                    context.startActivity(((Intent) (obj)));
                    return true;
                }
            } else
            if ("/cart".equalsIgnoreCase(((String) (obj1))))
            {
                if (!(context instanceof CartActivity))
                {
                    CartActivity.startActivity(context, flag);
                    if (context instanceof CheckoutActivity)
                    {
                        ((CheckoutActivity)context).finish();
                    }
                    return true;
                }
            } else
            {
                if ("/storefront".equalsIgnoreCase(((String) (obj1))))
                {
                    obj = LocationUtil.getStoreByMerchantId(((Uri) (obj)).getQueryParameter("merchantId"));
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((Store) (obj)).getStoreColor();
                    }
                    obj1 = new Intent(context, com/amazon/now/location/StorefrontWebActivity);
                    ((Intent) (obj1)).putExtra("intentUrlKey", s);
                    ((Intent) (obj1)).putExtra("intentStyleKey", new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL, ((String) (obj)), true));
                    if (flag)
                    {
                        modifyIntentForNewStack(((Intent) (obj1)));
                    }
                    context.startActivity(((Intent) (obj1)));
                    return true;
                }
                if ("/orderStatus".equalsIgnoreCase(((String) (obj1))) || "/restaurants/order-status".equalsIgnoreCase(((String) (obj1))))
                {
                    boolean flag1 = context instanceof CheckoutActivity;
                    MapWebActivity.startActivity(context, s, flag1, false, flag);
                    if (flag1)
                    {
                        ((CheckoutActivity)context).finish();
                    }
                    return true;
                }
                if (obj1 != null && ((String) (obj1)).contains("/restaurants/") && !((String) (obj1)).equalsIgnoreCase("/restaurants/purchases"))
                {
                    RestaurantsActivity.startActivity(context, s, flag);
                    return true;
                }
                if (!((Uri) (obj)).isHierarchical() && s.startsWith("tel:"))
                {
                    handleTel(((Uri) (obj)), context);
                    return true;
                }
                if ("/b".equalsIgnoreCase(((String) (obj1))))
                {
                    Intent intent = new Intent(context, com/amazon/now/web/WebActivity);
                    intent.putExtra("intentUrlKey", s);
                    if (flag)
                    {
                        modifyIntentForNewStack(intent);
                    }
                    context.startActivity(intent);
                    return true;
                }
            }
            if (handleSearch(s, context))
            {
                return true;
            }
            if (flag)
            {
                Intent intent1 = new Intent(context, com/amazon/now/web/WebActivity);
                intent1.putExtra("intentUrlKey", s);
                modifyIntentForNewStack(intent1);
                context.startActivity(intent1);
                return true;
            }
            boolean flag2 = super.navigate(s, context);
            flag = flag2;
            if (context instanceof MapWebActivity)
            {
                flag = flag2;
                if (!"/orderStatus".equalsIgnoreCase(((String) (obj1))))
                {
                    flag = flag2;
                    if (!"/restaurants/order-status".equalsIgnoreCase(((String) (obj1))))
                    {
                        flag = flag2;
                        if (!flag2)
                        {
                            Intent intent2 = new Intent(context, com/amazon/now/web/WebActivity);
                            intent2.putExtra("intentUrlKey", s);
                            context.startActivity(intent2);
                            return true;
                        }
                    }
                }
            }
        }
        return flag;
    }
}
