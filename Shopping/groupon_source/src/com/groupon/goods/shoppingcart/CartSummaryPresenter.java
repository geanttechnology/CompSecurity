// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.os.Bundle;
import com.groupon.goods.shoppingcart.event.ShoppingCartItemQuantitySelectedEvent;
import com.groupon.models.GenericAmount;
import com.groupon.models.shoppingCart.ShoppingCart;
import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.models.shoppingCart.ShoppingCartSubtotal;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;
import com.groupon.service.ShoppingCartService;
import com.squareup.otto.Bus;
import java.util.List;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            CartSummaryView

public class CartSummaryPresenter
{
    private class CartServiceListener extends DefaultShoppingCartServiceListenerImpl
    {

        private final boolean isRecoverable;
        final CartSummaryPresenter this$0;

        public void onCancel()
        {
            onCartCancel(isRecoverable);
        }

        public boolean onException(Exception exception)
        {
            return onCartException(exception);
        }

        public void onSuccess(ShoppingCartResponse shoppingcartresponse)
        {
            onCartResponse(shoppingcartresponse.cart);
        }

        public CartServiceListener(boolean flag)
        {
            this$0 = CartSummaryPresenter.this;
            super();
            isRecoverable = flag;
        }
    }


    private static final String CART_DEAL_IMAGE_URL = "CART_DEAL_IMAGE_URL";
    private static final String FORMATTED_MAX_DISCOUNT = "FORMATTED_MAX_DISCOUNT";
    private static final String ITEM_COUNT = "ITEM_COUNT";
    private final Bus bus;
    private String cartDealImageUrl;
    private String formattedMaxDiscount;
    private int itemCount;
    private final ShoppingCartService shoppingCartService;
    private final CartSummaryView view;

    public CartSummaryPresenter(CartSummaryView cartsummaryview, ShoppingCartService shoppingcartservice, Bus bus1)
    {
        view = cartsummaryview;
        shoppingCartService = shoppingcartservice;
        bus = bus1;
    }

    protected CartSummaryPresenter(CartSummaryView cartsummaryview, ShoppingCartService shoppingcartservice, Bus bus1, Bundle bundle)
    {
        this(cartsummaryview, shoppingcartservice, bus1);
        restoreInstanceState(bundle);
    }

    private void refresh()
    {
        view.enableContinueShoppingButton(false);
        view.enableCheckoutButton(false);
        shoppingCartService.getCart(view.getProgressViewId(), new CartServiceListener(false));
    }

    private void restoreInstanceState(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            itemCount = bundle.getInt("ITEM_COUNT");
            formattedMaxDiscount = bundle.getString("FORMATTED_MAX_DISCOUNT");
            cartDealImageUrl = bundle.getString("CART_DEAL_IMAGE_URL");
            return;
        }
    }

    public void checkout()
    {
        view.startCheckout(itemCount, formattedMaxDiscount, cartDealImageUrl);
    }

    public void continueShopping()
    {
        view.startCarousel();
        view.finishView();
    }

    protected void onCartCancel(boolean flag)
    {
        if (flag)
        {
            refresh();
            return;
        } else
        {
            view.finishView();
            return;
        }
    }

    protected boolean onCartException(Exception exception)
    {
        view.enableContinueShoppingButton(true);
        view.enableCheckoutButton(false);
        return true;
    }

    protected void onCartResponse(ShoppingCart shoppingcart)
    {
        boolean flag1 = true;
        itemCount = shoppingcart.numberOfItems;
        formattedMaxDiscount = shoppingCartService.getFormattedMaxDiscount(shoppingcart.items);
        cartDealImageUrl = shoppingCartService.getFirstDealImageUrl(shoppingcart.items);
        view.setItems(shoppingcart.items);
        CartSummaryView cartsummaryview = view;
        Object obj;
        boolean flag;
        boolean flag2;
        if (shoppingcart.subtotal.price != null)
        {
            obj = shoppingcart.subtotal.price.getFormattedAmount();
        } else
        {
            obj = null;
        }
        cartsummaryview.setSubTotal(((String) (obj)));
        flag = shoppingCartService.getCartInAppMessageViewed();
        obj = view;
        flag2 = shoppingcart.items.isEmpty();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CartSummaryView) (obj)).showEmptyView(flag2, flag);
        view.enableContinueShoppingButton(true);
        obj = view;
        if (!shoppingcart.items.isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((CartSummaryView) (obj)).enableCheckoutButton(flag);
    }

    public void onDeleteItemConfirmation(boolean flag, String s, int i)
    {
        if (flag)
        {
            view.enableContinueShoppingButton(false);
            view.enableCheckoutButton(false);
            shoppingCartService.removeItem(view.getProgressViewId(), s, null, new CartServiceListener(true));
            return;
        } else
        {
            view.notifyItemUpdated(i);
            return;
        }
    }

    public void onItemQuantitySelected(ShoppingCartItemQuantitySelectedEvent shoppingcartitemquantityselectedevent)
    {
        if (shoppingcartitemquantityselectedevent.quantity < 1)
        {
            view.confirmDeleteItem(shoppingcartitemquantityselectedevent.optionUuid, shoppingcartitemquantityselectedevent.position);
            return;
        } else
        {
            view.enableContinueShoppingButton(false);
            view.enableCheckoutButton(false);
            shoppingCartService.updateItem(view.getProgressViewId(), shoppingcartitemquantityselectedevent.optionUuid, shoppingcartitemquantityselectedevent.dealUuid, shoppingcartitemquantityselectedevent.quantity, null, new CartServiceListener(true));
            return;
        }
    }

    public void onPause()
    {
        bus.unregister(this);
    }

    public void onResume()
    {
        bus.register(this);
        refresh();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("ITEM_COUNT", itemCount);
        bundle.putString("FORMATTED_MAX_DISCOUNT", formattedMaxDiscount);
        bundle.putString("CART_DEAL_IMAGE_URL", cartDealImageUrl);
    }
}
