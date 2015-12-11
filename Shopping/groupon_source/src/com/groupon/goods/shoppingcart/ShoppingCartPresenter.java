// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.shoppingCart.ShoppingCart;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;
import com.groupon.service.ShoppingCartService;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            ShoppingCartControllerListener, MaxQuantityException

public class ShoppingCartPresenter
{
    private class AddItemToCartServiceListener extends DefaultShoppingCartServiceListenerImpl
    {

        final ShoppingCartPresenter this$0;

        public void onCancel()
        {
            cartCacheCancelled();
        }

        public boolean onException(Exception exception)
        {
            cartCacheFailure(exception, false);
            return false;
        }

        public void onSuccess(ShoppingCartResponse shoppingcartresponse)
        {
            addItemSuccess(shoppingcartresponse.cart);
        }

        private AddItemToCartServiceListener()
        {
            this$0 = ShoppingCartPresenter.this;
            super();
        }

    }

    private class CacheCartServiceListener extends DefaultShoppingCartServiceListenerImpl
    {

        final ShoppingCartPresenter this$0;

        public void onCancel()
        {
            cartCacheCancelled();
        }

        public boolean onException(Exception exception)
        {
            cartCacheFailure(exception, true);
            return false;
        }

        public void onSuccess(ShoppingCartResponse shoppingcartresponse)
        {
            cartCacheSuccess(shoppingcartresponse.cart);
        }

        private CacheCartServiceListener()
        {
            this$0 = ShoppingCartPresenter.this;
            super();
        }

    }


    private final AddItemToCartServiceListener addItemToCartServiceListener = new AddItemToCartServiceListener();
    private final CacheCartServiceListener cacheCartServiceListener = new CacheCartServiceListener();
    private ShoppingCart cart;
    private boolean isRefreshing;
    private ShoppingCartControllerListener shoppingCartControllerListener;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartPresenter()
    {
    }

    private ShoppingCartItem findCartItem(String s, String s1)
    {
label0:
        {
            if (cart == null)
            {
                break label0;
            }
            Iterator iterator = cart.items.iterator();
            ShoppingCartItem shoppingcartitem;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                shoppingcartitem = (ShoppingCartItem)iterator.next();
            } while (!s.equals(shoppingcartitem.deal.uuid) || !s1.equals(shoppingcartitem.dealOption.uuid));
            return shoppingcartitem;
        }
        return null;
    }

    void addItemSuccess(ShoppingCart shoppingcart)
    {
        cart = shoppingcart;
        if (shoppingCartControllerListener != null)
        {
            shoppingCartControllerListener.onItemAdded();
        }
    }

    public boolean addToCartAndOpen(Deal deal, Option option)
    {
        ShoppingCartItem shoppingcartitem = findCartItem(deal.uuid, option.uuid);
        if (shoppingcartitem != null && shoppingcartitem.quantity >= option.maximumPurchaseQuantity)
        {
            cartCacheFailure(new MaxQuantityException(option.maximumPurchaseQuantity), false);
            return false;
        } else
        {
            shoppingCartService.addItem(0, option.uuid, deal.uuid, addItemToCartServiceListener);
            return true;
        }
    }

    public void cacheCart()
    {
        if (isRefreshing)
        {
            return;
        }
        if (cart != null && cart.hashCode() == shoppingCartService.getLastCartHashcode())
        {
            cartCacheSuccess(cart);
            return;
        } else
        {
            isRefreshing = true;
            cart = null;
            shoppingCartService.getCart(0, cacheCartServiceListener);
            return;
        }
    }

    void cartCacheCancelled()
    {
        isRefreshing = false;
        if (shoppingCartControllerListener != null)
        {
            shoppingCartControllerListener.onCartCancel();
        }
    }

    void cartCacheFailure(Exception exception, boolean flag)
    {
        isRefreshing = false;
        if (shoppingCartControllerListener != null)
        {
            shoppingCartControllerListener.onCartException(exception, flag);
        }
    }

    void cartCacheSuccess(ShoppingCart shoppingcart)
    {
        isRefreshing = false;
        cart = shoppingcart;
        if (shoppingCartControllerListener != null)
        {
            shoppingCartControllerListener.onCartReady();
        }
    }

    public boolean isCartReady()
    {
        return cart != null;
    }

    public void setShoppingCartControllerListener(ShoppingCartControllerListener shoppingcartcontrollerlistener)
    {
        shoppingCartControllerListener = shoppingcartcontrollerlistener;
    }
}
