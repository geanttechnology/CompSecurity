// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.dealbreakdown.DealBreakdownContainer;
import com.groupon.models.dealbreakdown.DealMultiItemBreakdownContainer;
import com.groupon.models.order.CartItem;
import com.groupon.models.order.PostOrderContainerBodyRequest;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.ReturningFunction1;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase, LoginService, ShippingService, DealBreakdownServiceMultiDealListener

public class DealBreakdownService
{
    private static class MultiDealCallbackWrapper
    {

        public final ReturningFunction1 exceptionCallback;
        public final Function0 finallyCallback;
        public final Function1 successCallback;

        public MultiDealCallbackWrapper(DealBreakdownServiceMultiDealListener dealbreakdownservicemultideallistener)
        {
            successCallback = dealbreakdownservicemultideallistener. new _cls1();
            exceptionCallback = dealbreakdownservicemultideallistener. new _cls2();
            finallyCallback = dealbreakdownservicemultideallistener. new _cls3();
        }
    }

    private static class PostDealMultiItemBreakdownContainerHttp extends Http
    {

        private final ReturningFunction1 exceptionCallback;
        private final Function0 finallyCallback;
        private final Function1 successCallback;

        protected void onException(Exception exception)
        {
            if (exceptionCallback != null)
            {
                exceptionCallback.execute(exception);
            }
            super.onException(exception);
        }

        protected void onFinally()
        {
            super.onFinally();
            if (finallyCallback != null)
            {
                finallyCallback.execute();
            }
        }

        protected void onSuccess(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
            throws Exception
        {
            super.onSuccess(dealmultiitembreakdowncontainer);
            if (successCallback != null)
            {
                successCallback.execute(dealmultiitembreakdowncontainer);
            }
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((DealMultiItemBreakdownContainer)obj);
        }

        public PostDealMultiItemBreakdownContainerHttp(Context context1, SyncHttp synchttp, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
        {
            super(context1, synchttp);
            successCallback = function1;
            exceptionCallback = returningfunction1;
            finallyCallback = function0;
        }
    }


    private Context context;
    private ApiServiceBase getDealBreakdownService;
    private LoginService loginService;
    private ObjectMapperWrapper objectMapper;
    private ShippingService shippingService;

    public DealBreakdownService()
    {
    }

    private void init()
    {
        getDealBreakdownService = new ApiServiceBase(context, com/groupon/models/dealbreakdown/DealBreakdownContainer);
    }

    public void getDealBreakdown(String s, String s1, int i, boolean flag, List list, Function1 function1, ReturningFunction1 returningfunction1, 
            Function0 function0)
    {
        Ln.d("BREAKDOWN: DealBreakdownService.execute, s=%s, e=%s, dealId=%s, dealOptionId=%s, quantity=%d", new Object[] {
            function1, returningfunction1, s, s1, Integer.valueOf(i)
        });
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        ((List) (obj)).addAll(Arrays.asList(new Serializable[] {
            "deal_option_id", s1, "user_id", loginService.getUserId(), "quantity", Integer.valueOf(i)
        }));
        boolean flag1 = shippingService.isStored();
        if (flag && flag1)
        {
            shippingService.addParams(((List) (obj)));
        }
        getDealBreakdownService.execute(function1, returningfunction1, function0, String.format("https:/deals/%s/breakdowns", new Object[] {
            s
        }), "GET", ((List) (obj)));
    }

    public void getMultiDealBreakdown(String s, List list, String s1, boolean flag, DealBreakdownServiceMultiDealListener dealbreakdownservicemultideallistener)
    {
        PostOrderContainerBodyRequest postordercontainerbodyrequest;
        boolean flag1 = shippingService.isStored();
        postordercontainerbodyrequest = new PostOrderContainerBodyRequest();
        postordercontainerbodyrequest.userId = loginService.getUserId();
        postordercontainerbodyrequest.id = s;
        if (Strings.notEmpty(s1))
        {
            postordercontainerbodyrequest.promoCode = s1;
        }
        s = new ArrayList(list.size());
        CartItem cartitem;
        for (list = list.iterator(); list.hasNext(); s.add(cartitem))
        {
            s1 = (ShoppingCartItem)list.next();
            cartitem = new CartItem();
            cartitem.optionId = ((ShoppingCartItem) (s1)).dealOption.id;
            cartitem.quantity = ((ShoppingCartItem) (s1)).quantity;
            if (((ShoppingCartItem) (s1)).deal.shippingAddressRequired.booleanValue())
            {
                cartitem.delivery = "standard";
            }
            cartitem.giftWrap = flag;
            if (flag1)
            {
                cartitem.destinationAddress = "shippingAddress";
            }
        }

        postordercontainerbodyrequest.items = s;
        if (flag1)
        {
            postordercontainerbodyrequest.addressDetails = shippingService.getAddressDetails();
        }
        s = new MultiDealCallbackWrapper(dealbreakdownservicemultideallistener);
        list = (new com.squareup.okhttp.Headers.Builder()).add("Content-Type", "application/json").build();
        s1 = MediaType.parse("application/json; charset=utf-8");
        s1 = RequestBody.create(s1, objectMapper.writeValueAsString(postordercontainerbodyrequest));
        list = new SyncHttp(context, com/groupon/models/dealbreakdown/DealMultiItemBreakdownContainer, "https:/multi_item_orders/breakdown", list, s1);
        (new PostDealMultiItemBreakdownContainerHttp(context, list, ((MultiDealCallbackWrapper) (s)).successCallback, ((MultiDealCallbackWrapper) (s)).exceptionCallback, ((MultiDealCallbackWrapper) (s)).finallyCallback)).method("POST").execute();
        ((MultiDealCallbackWrapper) (s)).finallyCallback.execute();
        return;
        list;
        ((MultiDealCallbackWrapper) (s)).exceptionCallback.execute(list);
        ((MultiDealCallbackWrapper) (s)).finallyCallback.execute();
        return;
        list;
        ((MultiDealCallbackWrapper) (s)).finallyCallback.execute();
        throw list;
    }

    // Unreferenced inner class com/groupon/service/DealBreakdownService$MultiDealCallbackWrapper$1

/* anonymous class */
    class MultiDealCallbackWrapper._cls1
        implements Function1
    {

        final MultiDealCallbackWrapper this$0;
        final DealBreakdownServiceMultiDealListener val$listener;

        public void execute(DealMultiItemBreakdownContainer dealmultiitembreakdowncontainer)
            throws RuntimeException
        {
            listener.onSuccess(dealmultiitembreakdowncontainer);
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((DealMultiItemBreakdownContainer)obj);
        }

            
            {
                this$0 = final_multidealcallbackwrapper;
                listener = DealBreakdownServiceMultiDealListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/DealBreakdownService$MultiDealCallbackWrapper$2

/* anonymous class */
    class MultiDealCallbackWrapper._cls2
        implements ReturningFunction1
    {

        final MultiDealCallbackWrapper this$0;
        final DealBreakdownServiceMultiDealListener val$listener;

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
                this$0 = final_multidealcallbackwrapper;
                listener = DealBreakdownServiceMultiDealListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/DealBreakdownService$MultiDealCallbackWrapper$3

/* anonymous class */
    class MultiDealCallbackWrapper._cls3
        implements Function0
    {

        final MultiDealCallbackWrapper this$0;
        final DealBreakdownServiceMultiDealListener val$listener;

        public void execute()
            throws RuntimeException
        {
            listener.onComplete();
        }

            
            {
                this$0 = final_multidealcallbackwrapper;
                listener = DealBreakdownServiceMultiDealListener.this;
                super();
            }
    }

}
