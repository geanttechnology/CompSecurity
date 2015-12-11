// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.view.View;
import android.view.ViewGroup;
import com.groupon.activity.GrouponFragmentActivity;
import com.groupon.activity.Purchase;
import com.groupon.goods.shoppingcart.view.ShoppingCartFlyout;
import com.groupon.util.GrouponNavigationDrawerActivity;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            NewPurchaseCart

public class  extends com.groupon.activity.iewBinder
{

    public volatile void bind(butterknife.seCart..ViewBinder viewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(viewbinder, (NewPurchaseCart)grouponfragmentactivity, obj);
    }

    public volatile void bind(butterknife.seCart..ViewBinder viewbinder, Purchase purchase, Object obj)
    {
        bind(viewbinder, (NewPurchaseCart)purchase, obj);
    }

    public void bind(butterknife.seCart..ViewBinder viewbinder, NewPurchaseCart newpurchasecart, Object obj)
    {
        super.iewBinder(viewbinder, newpurchasecart, obj);
        newpurchasecart.cartItemsContainer = (ViewGroup)viewbinder.cartItemsContainer((View)viewbinder.redView(obj, 0x7f100490, "field 'cartItemsContainer'"), 0x7f100490, "field 'cartItemsContainer'");
        newpurchasecart.shoppingCartFlyout = (ShoppingCartFlyout)viewbinder.pingCartFlyout((View)viewbinder.redView(obj, 0x7f100491, "field 'shoppingCartFlyout'"), 0x7f100491, "field 'shoppingCartFlyout'");
    }

    public volatile void bind(butterknife.seCart..ViewBinder viewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(viewbinder, (NewPurchaseCart)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.seCart..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (NewPurchaseCart)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((NewPurchaseCart)grouponfragmentactivity);
    }

    public volatile void unbind(Purchase purchase)
    {
        unbind((NewPurchaseCart)purchase);
    }

    public void unbind(NewPurchaseCart newpurchasecart)
    {
        super.iewBinder(newpurchasecart);
        newpurchasecart.cartItemsContainer = null;
        newpurchasecart.shoppingCartFlyout = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((NewPurchaseCart)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((NewPurchaseCart)obj);
    }

    public ()
    {
    }
}
