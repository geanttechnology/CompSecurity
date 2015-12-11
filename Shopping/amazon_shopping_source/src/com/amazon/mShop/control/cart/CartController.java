// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cart;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AddToCartResponseListener;
import com.amazon.rio.j2me.client.services.mShop.CartAddition;
import com.amazon.rio.j2me.client.services.mShop.CartAdditionRequest;
import com.amazon.rio.j2me.client.services.mShop.CartItem;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.CartResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.ModifyCartResponseListener;
import com.amazon.rio.j2me.client.services.mShop.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.cart:
//            CartSubscriber

public class CartController extends BaseController
    implements UserListener, AddToCartResponseListener, CartResponseListener, ModifyCartResponseListener
{

    private static CartController instance;
    private CartItems cart;
    private boolean isModifyingServiceCall;
    private boolean mCartHasTimedItem;
    private Map mOriginalMsToExpiry;
    private Timer mTimer;
    private long mTimerStartedTime;
    private final List subscribers = new ArrayList(4);

    private CartController()
    {
        User.addUserListener(this);
    }

    private void clearTimer()
    {
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public static CartController getInstance()
    {
        com/amazon/mShop/control/cart/CartController;
        JVM INSTR monitorenter ;
        CartController cartcontroller;
        if (instance == null)
        {
            instance = new CartController();
        }
        cartcontroller = instance;
        com/amazon/mShop/control/cart/CartController;
        JVM INSTR monitorexit ;
        return cartcontroller;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyCartDidUpdateCheckOutTimerForItem(CartItem cartitem)
    {
        for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((CartSubscriber)iterator.next()).onCartDidUpdateCheckOutTimerForItem(cartitem)) { }
    }

    private void notifyCartReceived(CartItems cartitems)
    {
label0:
        {
            cart = cartitems;
            clearTimer();
            mCartHasTimedItem = false;
            if (cartitems == null)
            {
                break label0;
            }
            Iterator iterator = cartitems.getCartItem().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (((CartItem)iterator.next()).getMsToExpiry() == null);
            mCartHasTimedItem = true;
        }
        setupTimer();
        for (Iterator iterator1 = (new ArrayList(subscribers)).iterator(); iterator1.hasNext(); ((CartSubscriber)iterator1.next()).onCartReceived(cartitems)) { }
    }

    private void notifyError(Exception exception, ServiceCall servicecall)
    {
        if (subscribers.size() > 0)
        {
            ((CartSubscriber)subscribers.get(subscribers.size() - 1)).onError(exception, servicecall);
        }
    }

    private void serviceCallStarted(ServiceCall servicecall, boolean flag, TaskCallback taskcallback)
    {
        super.serviceCallStarted(servicecall, taskcallback);
        isModifyingServiceCall = flag;
    }

    public static void setInstance(CartController cartcontroller)
    {
        com/amazon/mShop/control/cart/CartController;
        JVM INSTR monitorenter ;
        if (instance != null)
        {
            instance.notifyCartReceived(null);
        }
        instance = cartcontroller;
        com/amazon/mShop/control/cart/CartController;
        JVM INSTR monitorexit ;
        return;
        cartcontroller;
        throw cartcontroller;
    }

    private void setupTimer()
    {
        if (mCartHasTimedItem)
        {
            mTimer = Util.createTimer(new Runnable() {

                final CartController this$0;

                public void run()
                {
                    updateCheckOutTime();
                }

            
            {
                this$0 = CartController.this;
                super();
            }
            }, 0L, 1000L);
            mTimerStartedTime = System.currentTimeMillis();
            mOriginalMsToExpiry = new HashMap();
        }
    }

    private void updateCheckOutTime()
    {
        if (mTimer == null || cart == null) goto _L2; else goto _L1
_L1:
        Object obj;
        long l;
        obj = cart.getCartItem();
        l = System.currentTimeMillis();
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L3
_L3:
        CartItem cartitem;
        int i;
        cartitem = (CartItem)((Iterator) (obj)).next();
        if (cartitem.getMsToExpiry() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mOriginalMsToExpiry.get(cartitem.getItemId()) == null)
        {
            mOriginalMsToExpiry.put(cartitem.getItemId(), cartitem.getMsToExpiry());
        }
        i = (int)(l - mTimerStartedTime);
        i = ((Integer)mOriginalMsToExpiry.get(cartitem.getItemId())).intValue() - i;
        if (1000 <= i) goto _L5; else goto _L4
_L4:
        clearTimer();
        if (!cartIsLoading())
        {
            loadCart(null);
        }
_L2:
        return;
_L5:
        cartitem.setMsToExpiry(Integer.valueOf(i));
        notifyCartDidUpdateCheckOutTimerForItem(cartitem);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addCartSubscriber(CartSubscriber cartsubscriber)
    {
        subscribers.add(cartsubscriber);
    }

    public void addToCart(String s, String s1, String s2, String s3, String s4, String s5, TaskCallback taskcallback)
    {
        CartAddition cartaddition = new CartAddition();
        cartaddition.setOfferId(s1);
        cartaddition.setAsin(s);
        cartaddition.setListId(s2);
        cartaddition.setListItemId(s3);
        cartaddition.setDealId(s4);
        cartaddition.setQuantity(1);
        s = new ArrayList(1);
        s.add(cartaddition);
        s1 = new CartAdditionRequest();
        s1.setAdditions(new Vector(s));
        s1.setClickStreamOrigin(s5);
        serviceCallStarted(ServiceController.getMShopService().addToCart(s1, this), taskcallback);
    }

    public void cancel()
    {
        if (hasServiceCallRunning() && isModifyingServiceCall)
        {
            cart = null;
            clearTimer();
        }
        super.cancel();
    }

    public boolean cartIsLoading()
    {
        return hasServiceCallRunning() || HomeController.getInstance().isLoadingCart();
    }

    public void completed(final CartItems value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final CartController this$0;
            final ServiceCall val$sc;
            final CartItems val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    notifyCartReceived(value);
                }
            }

            
            {
                this$0 = CartController.this;
                sc = servicecall;
                value = cartitems;
                super();
            }
        });
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final CartController this$0;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    notifyError(e, sc);
                }
            }

            
            {
                this$0 = CartController.this;
                sc = servicecall;
                e = exception;
                super();
            }
        });
    }

    public int getCartTotalQuantity()
    {
        if (cart != null) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        Object obj = cart.getCartItem();
        int i = 0;
        obj = ((List) (obj)).iterator();
        do
        {
            j = i;
            if (!((Iterator) (obj)).hasNext())
            {
                continue;
            }
            CartItem cartitem = (CartItem)((Iterator) (obj)).next();
            if (!cartitem.getIsSavedItem())
            {
                i += cartitem.getQuantity();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected GenericSubscriber getSubscriber()
    {
        return null;
    }

    public boolean hasTimedCartItem()
    {
        return mCartHasTimedItem;
    }

    public void loadCart(TaskCallback taskcallback)
    {
        serviceCallStarted(ServiceController.getMShopService().cart(new Null(), this), false, taskcallback);
    }

    public void onCartReceivedFromHomeCall(CartItems cartitems)
    {
        notifyCartReceived(cartitems);
    }

    public void removeCartSubscriber(CartSubscriber cartsubscriber)
    {
        subscribers.remove(cartsubscriber);
    }

    protected final void serviceCallStarted(ServiceCall servicecall, TaskCallback taskcallback)
    {
        super.serviceCallStarted(servicecall, taskcallback);
        isModifyingServiceCall = true;
    }

    public void userSignedIn(User user)
    {
        if (!cartIsLoading())
        {
            loadCart(null);
        }
    }

    public void userSignedOut()
    {
        notifyCartReceived(null);
        if (!cartIsLoading())
        {
            loadCart(null);
        }
    }

    public void userUpdated(User user)
    {
    }







}
