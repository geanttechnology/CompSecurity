// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.goods.shoppingcart.CartSummaryActivity;
import com.groupon.goods.shoppingcart.NewPurchaseCart;
import com.groupon.http.Http;
import com.groupon.models.GenericAmount;
import com.groupon.models.shoppingCart.ShoppingCart;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartImage;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.squareup.okhttp.FormEncodingBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase2, ShoppingCartRequest, LoginService, DefaultShoppingCartServiceListenerImpl, 
//            ShoppingCartServiceListener

public class ShoppingCartService extends ApiServiceBase2
{
    private class CallbackWrapper
    {

        public final Function0 cancelCallback;
        public final ReturningFunction1 exceptionCallback;
        public final Function0 finallyCallback;
        public final Function1 successCallback;
        final ShoppingCartService this$0;

        public CallbackWrapper(ShoppingCartServiceListener shoppingcartservicelistener)
        {
            this.this$0 = ShoppingCartService.this;
            super();
            successCallback = shoppingcartservicelistener. new _cls1();
            exceptionCallback = shoppingcartservicelistener. new _cls2();
            cancelCallback = shoppingcartservicelistener. new _cls3();
            finallyCallback = shoppingcartservicelistener. new _cls4();
        }
    }


    private static final String CART_IN_APP_MESSAGE_VIEWED = "cart_in_app_message_viewed";
    private static final String SHOPPING_CART_COUNT = "shoppingCartCount";
    private static final String SHOPPING_CART_HASHCODE = "shoppingCartHashCode";
    private static final String SHOPPING_CART_UUID = "shoppingCartUuid";
    private NewCartAbTestHelper cartAbTestHelper;
    private CurrencyFormatter currencyFormatter;
    private LoginService loginService;
    private SharedPreferences prefs;
    private SharedPreferences sharedPrefs;

    public ShoppingCartService(Context context)
    {
        super(context, com/groupon/models/shoppingCart/ShoppingCartResponse);
    }

    public void addItem(int i, String s, String s1, ShoppingCartServiceListener shoppingcartservicelistener)
    {
        s = (new FormEncodingBuilder()).add("quantity", String.valueOf(1)).add("option_uuid", s).add("deal_uuid", s1).build();
        s1 = new CallbackWrapper(shoppingcartservicelistener);
        ((Http)newRequest().withCallbacks(((CallbackWrapper) (s1)).successCallback, ((CallbackWrapper) (s1)).exceptionCallback, ((CallbackWrapper) (s1)).finallyCallback).withCancelCallback(((CallbackWrapper) (s1)).cancelCallback).uri("https:/shopping_cart/items").method("POST").body(s).progressView(i)).execute();
    }

    public void cacheLastCartInfo(ShoppingCart shoppingcart)
    {
        sharedPrefs.edit().putString("shoppingCartUuid", shoppingcart.uuid).putInt("shoppingCartCount", shoppingcart.numberOfItems).putInt("shoppingCartHashCode", shoppingcart.hashCode()).apply();
    }

    public void getCart(int i, ShoppingCartServiceListener shoppingcartservicelistener)
    {
        ArrayList arraylist = new ArrayList();
        if (loginService.isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "consumer_id", loginService.getConsumerId()
            }));
        }
        shoppingcartservicelistener = new CallbackWrapper(shoppingcartservicelistener);
        ((Http)newRequest().withCallbacks(((CallbackWrapper) (shoppingcartservicelistener)).successCallback, ((CallbackWrapper) (shoppingcartservicelistener)).exceptionCallback, ((CallbackWrapper) (shoppingcartservicelistener)).finallyCallback).withCancelCallback(((CallbackWrapper) (shoppingcartservicelistener)).cancelCallback).uri("https:/shopping_cart/items").method("GET").nvps(arraylist.toArray()).progressView(i)).execute();
    }

    public boolean getCartInAppMessageViewed()
    {
        return prefs.getBoolean("cart_in_app_message_viewed", false);
    }

    public int getCartItemsCount()
    {
        return sharedPrefs.getInt("shoppingCartCount", 0);
    }

    public String getFirstDealImageUrl(List list)
    {
label0:
        {
            Object obj1 = null;
            Object obj = obj1;
            if (list != null)
            {
                obj = obj1;
                if (list.size() > 0)
                {
                    list = (ShoppingCartItem)list.get(0);
                    obj = ((ShoppingCartItem) (list)).dealOption.images;
                    if (obj == null || ((List) (obj)).size() <= 0)
                    {
                        break label0;
                    }
                    obj = (new StringBuilder()).append(((ShoppingCartImage)((List) (obj)).get(0)).url).append("t954x610.jpg").toString();
                }
            }
            return ((String) (obj));
        }
        return ((ShoppingCartItem) (list)).deal.largeImageUrl;
    }

    public String getFormattedMaxDiscount(List list)
    {
        list = getMaxDiscount(list);
        if (list.getAmount() > 0)
        {
            return currencyFormatter.format(list, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        } else
        {
            return null;
        }
    }

    public String getLastCachedCartUuid()
    {
        return sharedPrefs.getString("shoppingCartUuid", "");
    }

    public int getLastCartHashcode()
    {
        return prefs.getInt("shoppingCartHashCode", 0);
    }

    public GenericAmount getMaxDiscount(List list)
    {
        GenericAmount genericamount = new GenericAmount();
        genericamount.setAmount(0);
        Iterator iterator = list.iterator();
        list = genericamount;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            GenericAmount genericamount1 = ((ShoppingCartItem)iterator.next()).dealOption.discount;
            if (genericamount1.getAmount() > list.getAmount())
            {
                list = genericamount1;
            }
        } while (true);
        return list;
    }

    public Intent getOpenCartIntent()
    {
        if (cartAbTestHelper.shouldSkipSummary() && getCartItemsCount() > 0)
        {
            return NewPurchaseCart.openPurchaseCartIntent(getContext());
        } else
        {
            return CartSummaryActivity.openShoppingCartIntent(getContext());
        }
    }

    public ShoppingCartRequest newRequest()
    {
        return (ShoppingCartRequest)RoboGuice.getInjector(context).getInstance(com/groupon/service/ShoppingCartRequest);
    }

    protected void onCartUpdated(ShoppingCart shoppingcart)
    {
        cacheLastCartInfo(shoppingcart);
    }

    public void refreshCachedCart()
    {
        getCart(0, new DefaultShoppingCartServiceListenerImpl());
    }

    public void removeItem(int i, String s, View aview[], ShoppingCartServiceListener shoppingcartservicelistener)
    {
        shoppingcartservicelistener = new CallbackWrapper(shoppingcartservicelistener);
        ((Http)((Http)newRequest().withCallbacks(((CallbackWrapper) (shoppingcartservicelistener)).successCallback, ((CallbackWrapper) (shoppingcartservicelistener)).exceptionCallback, ((CallbackWrapper) (shoppingcartservicelistener)).finallyCallback).withCancelCallback(((CallbackWrapper) (shoppingcartservicelistener)).cancelCallback).uri((new StringBuilder()).append("https:/shopping_cart/items/").append(s).toString()).method("DELETE").progressView(i)).disableViews(aview)).execute();
    }

    public void setCartInAppMessageViewed(boolean flag)
    {
        prefs.edit().putBoolean("cart_in_app_message_viewed", flag).apply();
    }

    public void updateItem(int i, String s, String s1, int j, View aview[], ShoppingCartServiceListener shoppingcartservicelistener)
    {
        s1 = (new FormEncodingBuilder()).add("quantity", String.valueOf(j)).add("deal_uuid", s1).build();
        shoppingcartservicelistener = new CallbackWrapper(shoppingcartservicelistener);
        ((Http)((Http)newRequest().withCallbacks(((CallbackWrapper) (shoppingcartservicelistener)).successCallback, ((CallbackWrapper) (shoppingcartservicelistener)).exceptionCallback, ((CallbackWrapper) (shoppingcartservicelistener)).finallyCallback).withCancelCallback(((CallbackWrapper) (shoppingcartservicelistener)).cancelCallback).uri((new StringBuilder()).append("https:/shopping_cart/items/").append(s).toString()).method("PUT").body(s1).progressView(i)).disableViews(aview)).execute();
    }

    // Unreferenced inner class com/groupon/service/ShoppingCartService$CallbackWrapper$1

/* anonymous class */
    class CallbackWrapper._cls1
        implements Function1
    {

        final CallbackWrapper this$1;
        final ShoppingCartServiceListener val$listener;
        final ShoppingCartService val$this$0;

        public void execute(ShoppingCartResponse shoppingcartresponse)
            throws RuntimeException
        {
            onCartUpdated(shoppingcartresponse.cart);
            listener.onSuccess(shoppingcartresponse);
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((ShoppingCartResponse)obj);
        }

            
            {
                this$1 = final_callbackwrapper;
                this$0 = shoppingcartservice;
                listener = ShoppingCartServiceListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/ShoppingCartService$CallbackWrapper$2

/* anonymous class */
    class CallbackWrapper._cls2
        implements ReturningFunction1
    {

        final CallbackWrapper this$1;
        final ShoppingCartServiceListener val$listener;
        final ShoppingCartService val$this$0;

        public Boolean execute(Exception exception)
            throws RuntimeException
        {
            return Boolean.valueOf(listener.onException(exception));
        }

        public volatile Object execute(Object obj)
            throws Exception
        {
            return execute((Exception)obj);
        }

            
            {
                this$1 = final_callbackwrapper;
                this$0 = shoppingcartservice;
                listener = ShoppingCartServiceListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/ShoppingCartService$CallbackWrapper$3

/* anonymous class */
    class CallbackWrapper._cls3
        implements Function0
    {

        final CallbackWrapper this$1;
        final ShoppingCartServiceListener val$listener;
        final ShoppingCartService val$this$0;

        public void execute()
            throws RuntimeException
        {
            listener.onCancel();
        }

            
            {
                this$1 = final_callbackwrapper;
                this$0 = shoppingcartservice;
                listener = ShoppingCartServiceListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/ShoppingCartService$CallbackWrapper$4

/* anonymous class */
    class CallbackWrapper._cls4
        implements Function0
    {

        final CallbackWrapper this$1;
        final ShoppingCartServiceListener val$listener;
        final ShoppingCartService val$this$0;

        public void execute()
            throws RuntimeException
        {
            listener.onComplete();
        }

            
            {
                this$1 = final_callbackwrapper;
                this$0 = shoppingcartservice;
                listener = ShoppingCartServiceListener.this;
                super();
            }
    }

}
