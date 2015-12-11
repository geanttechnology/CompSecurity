// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.shoppingCart;

import com.groupon.models.GenericAmount;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.shoppingCart:
//            ShoppingCartItemLogSummary, ShoppingCartDeal, ShoppingCartDealOption

public class ShoppingCartItem
{

    public ShoppingCartDeal deal;
    public ShoppingCartDealOption dealOption;
    public int quantity;
    public boolean updating;

    public ShoppingCartItem()
    {
    }

    public ShoppingCartItemLogSummary getLogSummary()
    {
        ShoppingCartItemLogSummary shoppingcartitemlogsummary = new ShoppingCartItemLogSummary();
        if (deal != null)
        {
            shoppingcartitemlogsummary.dealUuid = deal.uuid;
            shoppingcartitemlogsummary.dealId = deal.id;
        }
        if (dealOption != null)
        {
            shoppingcartitemlogsummary.optionId = dealOption.id;
            GenericAmount genericamount = dealOption.price;
            if (genericamount != null)
            {
                shoppingcartitemlogsummary.price = genericamount.getAmount();
            }
        }
        shoppingcartitemlogsummary.quantity = quantity;
        shoppingcartitemlogsummary.channel = "";
        return shoppingcartitemlogsummary;
    }

    public int hashCode()
    {
        if (deal == null || Strings.isEmpty(deal.uuid) || dealOption == null || Strings.isEmpty(dealOption.uuid))
        {
            return super.hashCode();
        } else
        {
            return deal.uuid.hashCode() * 31 + dealOption.uuid.hashCode();
        }
    }
}
