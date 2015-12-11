// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import com.ebay.common.model.cart.Cart;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowTimeSlotRequest

public static class per
{
    public static class Product
    {

        public final long id = 0L;
        public final String name;
        public final com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper price;
        public final int quantity;
        public final String sku;

        public Product(com.ebay.common.model.cart.Cart.LineItem lineitem)
        {
            name = lineitem.itemTitle;
            sku = lineitem.getSellerProductId();
            price = new com.ebay.common.model.local.BaseEbayNowDelivery.CurrencyAmountWrapper(lineitem.price);
            quantity = lineitem.quantity;
        }
    }


    public final com.ebay.common.model.local.apper discount;
    public final ArrayList products = new ArrayList();
    public final com.ebay.common.model.local.apper tax;
    public final com.ebay.common.model.local.apper total;

    public Product(Cart cart, List list)
    {
        CurrencyAmount currencyamount = CurrencyAmount.ZERO;
        cart = CurrencyAmount.ZERO;
        Iterator iterator = list.iterator();
        list = currencyamount;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (com.ebay.common.model.cart.ls)iterator.next();
            if (((com.ebay.common.model.cart.ls) (obj)).ls())
            {
                list = list.add(((com.ebay.common.model.cart.ls) (obj)).ls.ls);
                cart = cart.add(((com.ebay.common.model.cart.ls) (obj)).ls.multiplyBy(((com.ebay.common.model.cart.ls) (obj)).ls));
                obj = new Product(((com.ebay.common.model.cart.ls.Product) (obj)));
                products.add(obj);
            }
        } while (true);
        tax = new com.ebay.common.model.local.apper(list);
        total = new com.ebay.common.model.local.apper(cart);
        discount = new com.ebay.common.model.local.apper(CurrencyAmount.ZERO);
    }
}
