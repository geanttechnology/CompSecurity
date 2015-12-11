// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.MultiItemOrderRequest;
import com.groupon.models.MultiItemOrderResponse;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.order.CartItem;
import com.groupon.models.order.GiftDetail;
import com.groupon.models.order.OrderContainer;
import com.groupon.models.order.PostOrderContainerBodyRequest;
import com.groupon.models.order.UserGift;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.ReturningFunction1;
import com.iovation.mobile.android.DevicePrint;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LoginService, ApiServiceBase2, ShippingService, OrdersServiceMultiItemListener

public class OrdersService
{
    private static class MultiItemOrderCallbackWrapper
    {

        public final ReturningFunction1 exceptionCallback;
        public final Function0 finallyCallback;
        public final Function1 successCallback;

        public MultiItemOrderCallbackWrapper(OrdersServiceMultiItemListener ordersservicemultiitemlistener)
        {
            successCallback = ordersservicemultiitemlistener. new _cls1();
            exceptionCallback = ordersservicemultiitemlistener. new _cls2();
            finallyCallback = ordersservicemultiitemlistener. new _cls3();
        }
    }

    private static class PostOrderContainerHttp extends Http
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
        }

        protected void onFinally()
        {
            super.onFinally();
            if (finallyCallback != null)
            {
                finallyCallback.execute();
            }
        }

        protected void onSuccess(OrderContainer ordercontainer)
            throws Exception
        {
            super.onSuccess(ordercontainer);
            if (successCallback != null)
            {
                successCallback.execute(ordercontainer);
            }
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((OrderContainer)obj);
        }

        public PostOrderContainerHttp(Context context1, String s, Headers headers, RequestBody requestbody, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
        {
            super(context1, com/groupon/models/order/OrderContainer, s, headers, requestbody);
            successCallback = function1;
            exceptionCallback = returningfunction1;
            finallyCallback = function0;
        }
    }


    private Context context;
    private LoginService loginService;
    private ObjectMapperWrapper objectMapper;
    private ShippingService shippingService;

    public OrdersService()
    {
    }

    public void getMultiItemOrder(String s, final Function1 successCallback, ReturningFunction1 returningfunction1, Function0 function0)
    {
        ((MultiItemOrderRequest)RoboGuice.getInjector(context).getInstance(com/groupon/models/MultiItemOrderRequest)).withCallbacks(new Function1() {

            final OrdersService this$0;
            final Function1 val$successCallback;

            public void execute(MultiItemOrderResponse multiitemorderresponse)
            {
                successCallback.execute(multiitemorderresponse.order);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((MultiItemOrderResponse)obj);
            }

            
            {
                this$0 = OrdersService.this;
                successCallback = function1;
                super();
            }
        }, returningfunction1, function0).uri(String.format("https:/users/%s/multi_item_orders/%s", new Object[] {
            loginService.getUserId(), s
        })).method("GET").execute();
    }

    public void getMultiItemOrders(String s, String s1, String s2, boolean flag, boolean flag1, GiftingRecord giftingrecord, List list, 
            Map map, OrdersServiceMultiItemListener ordersservicemultiitemlistener)
    {
        PostOrderContainerBodyRequest postordercontainerbodyrequest = new PostOrderContainerBodyRequest();
        postordercontainerbodyrequest.id = s;
        postordercontainerbodyrequest.billingRecord.id = s1;
        postordercontainerbodyrequest.useCart = flag;
        postordercontainerbodyrequest.iovationBlackbox = DevicePrint.ioBegin(context.getApplicationContext());
        if (Strings.notEmpty(s2))
        {
            postordercontainerbodyrequest.promoCode = s2;
        }
        flag = shippingService.isStored();
        s = new ArrayList(list.size());
        s1 = list.iterator();
_L1:
        if (!s1.hasNext())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        s2 = (ShoppingCartItem)s1.next();
        list = new CartItem();
        list.optionId = ((ShoppingCartItem) (s2)).dealOption.id;
        list.quantity = ((ShoppingCartItem) (s2)).quantity;
        if (((ShoppingCartItem) (s2)).deal.shippingAddressRequired.booleanValue())
        {
            list.delivery = "standard";
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        if (map.size() > 0)
        {
            list.customFieldValue = (String)map.get(((ShoppingCartItem) (s2)).dealOption.id);
        }
        list.giftWrap = flag1;
        if (flag)
        {
            try
            {
                list.destinationAddress = "shippingAddress";
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Ln.e(s);
                return;
            }
        }
        if (giftingrecord == null)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        list.gift = "gift0";
        s.add(list);
          goto _L1
        postordercontainerbodyrequest.items = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        postordercontainerbodyrequest.addressDetails = shippingService.getAddressDetails();
        if (giftingrecord == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        s = new GiftDetail();
        postordercontainerbodyrequest.giftDetails = s;
        s1 = new UserGift();
        s.gift0 = s1;
        s1.fromName = giftingrecord.fromName;
        s1.message = giftingrecord.message;
        s1.toName = giftingrecord.recipientName;
        s1.deliveryMethod = giftingrecord.deliveryMethod;
        s = new MultiItemOrderCallbackWrapper(ordersservicemultiitemlistener);
        s1 = String.format("https:/users/%s/multi_item_orders", new Object[] {
            loginService.getUserId()
        });
        s2 = (new com.squareup.okhttp.Headers.Builder()).add("Content-Type", "application/json").build();
        giftingrecord = MediaType.parse("application/json; charset=utf-8");
        giftingrecord = RequestBody.create(giftingrecord, objectMapper.writeValueAsString(postordercontainerbodyrequest));
        (new PostOrderContainerHttp(context, s1, s2, giftingrecord, ((MultiItemOrderCallbackWrapper) (s)).successCallback, ((MultiItemOrderCallbackWrapper) (s)).exceptionCallback, ((MultiItemOrderCallbackWrapper) (s)).finallyCallback)).method("POST").execute();
        ((MultiItemOrderCallbackWrapper) (s)).finallyCallback.execute();
        return;
        s1;
        ((MultiItemOrderCallbackWrapper) (s)).exceptionCallback.execute(s1);
        ((MultiItemOrderCallbackWrapper) (s)).finallyCallback.execute();
        return;
        s1;
        ((MultiItemOrderCallbackWrapper) (s)).finallyCallback.execute();
        throw s1;
    }

    // Unreferenced inner class com/groupon/service/OrdersService$MultiItemOrderCallbackWrapper$1

/* anonymous class */
    class MultiItemOrderCallbackWrapper._cls1
        implements Function1
    {

        final MultiItemOrderCallbackWrapper this$0;
        final OrdersServiceMultiItemListener val$listener;

        public void execute(OrderContainer ordercontainer)
            throws RuntimeException
        {
            listener.onSuccess(ordercontainer);
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((OrderContainer)obj);
        }

            
            {
                this$0 = final_multiitemordercallbackwrapper;
                listener = OrdersServiceMultiItemListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/OrdersService$MultiItemOrderCallbackWrapper$2

/* anonymous class */
    class MultiItemOrderCallbackWrapper._cls2
        implements ReturningFunction1
    {

        final MultiItemOrderCallbackWrapper this$0;
        final OrdersServiceMultiItemListener val$listener;

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
                this$0 = final_multiitemordercallbackwrapper;
                listener = OrdersServiceMultiItemListener.this;
                super();
            }
    }


    // Unreferenced inner class com/groupon/service/OrdersService$MultiItemOrderCallbackWrapper$3

/* anonymous class */
    class MultiItemOrderCallbackWrapper._cls3
        implements Function0
    {

        final MultiItemOrderCallbackWrapper this$0;
        final OrdersServiceMultiItemListener val$listener;

        public void execute()
            throws RuntimeException
        {
            listener.onComplete();
        }

            
            {
                this$0 = final_multiitemordercallbackwrapper;
                listener = OrdersServiceMultiItemListener.this;
                super();
            }
    }

}
