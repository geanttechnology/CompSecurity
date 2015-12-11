// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import com.groupon.goods.shoppingcart.event.ShoppingCartItemEditModeToggledEvent;
import com.groupon.goods.shoppingcart.event.ShoppingCartItemQuantitySelectedEvent;
import com.groupon.models.GenericAmount;
import com.groupon.models.shoppingCart.ShoppingCartDeal;
import com.groupon.models.shoppingCart.ShoppingCartDealOption;
import com.groupon.models.shoppingCart.ShoppingCartImage;
import com.groupon.models.shoppingCart.ShoppingCartItem;
import com.groupon.util.HumanReadableCountdownFormatC;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            ShoppingCartItemView

public class ShoppingCartItemPresenter
{

    private final Bus bus;
    private boolean currentEditMode;
    private final HumanReadableCountdownFormatC timeLeftFormat;
    private final ShoppingCartItemView view;

    public ShoppingCartItemPresenter(ShoppingCartItemView shoppingcartitemview, HumanReadableCountdownFormatC humanreadablecountdownformatc, Bus bus1)
    {
        view = shoppingcartitemview;
        timeLeftFormat = humanreadablecountdownformatc;
        bus = bus1;
    }

    private void setEditMode(boolean flag)
    {
        currentEditMode = flag;
        ShoppingCartItemView shoppingcartitemview = view;
        if (!currentEditMode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shoppingcartitemview.showQuantity(flag);
        view.showRemove(currentEditMode);
    }

    private void setImage(ShoppingCartItem shoppingcartitem)
    {
        List list = shoppingcartitem.dealOption.images;
        if (list == null || list.isEmpty())
        {
            shoppingcartitem = shoppingcartitem.deal.largeImageUrl;
        } else
        {
            shoppingcartitem = (new StringBuilder()).append(((ShoppingCartImage)list.get(0)).url).append("t954x610.jpg").toString();
        }
        view.setImage(shoppingcartitem);
    }

    private void setPrices(ShoppingCartItem shoppingcartitem)
    {
        view.setPrices(shoppingcartitem.dealOption.value.getFormattedAmount(), shoppingcartitem.dealOption.price.getFormattedAmount());
    }

    private void setQuantity(ShoppingCartItem shoppingcartitem)
    {
        int i = shoppingcartitem.dealOption.minimumPurchaseQuantity;
        int j = shoppingcartitem.dealOption.maximumPurchaseQuantity;
        ArrayList arraylist = new ArrayList((j - i) + 2);
        arraylist.add(Integer.valueOf(0));
        for (; i <= j; i++)
        {
            arraylist.add(Integer.valueOf(i));
        }

        view.setQuantity(shoppingcartitem.quantity, arraylist);
    }

    private void setTimeLeft(ShoppingCartItem shoppingcartitem)
    {
        Date date = shoppingcartitem.dealOption.endAt;
        Date date1 = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime();
        if (shoppingcartitem.dealOption.isSoldOut || date != null && date1.after(date))
        {
            view.showSoldOut();
            return;
        }
        if (date != null)
        {
            timeLeftFormat.setRelativeTo(date1);
            shoppingcartitem = timeLeftFormat.format(date);
        } else
        {
            shoppingcartitem = null;
        }
        if (Strings.isEmpty(shoppingcartitem))
        {
            view.showTimeLeft(false);
            return;
        } else
        {
            view.setTimeLeft(shoppingcartitem);
            view.showTimeLeft(true);
            return;
        }
    }

    private void setTitle(ShoppingCartItem shoppingcartitem)
    {
        view.setTitle(shoppingcartitem.dealOption.title);
    }

    public void onQuantitySelected(ShoppingCartItem shoppingcartitem, int i, int j)
    {
        if (shoppingcartitem.quantity == i)
        {
            return;
        } else
        {
            bus.post(new ShoppingCartItemQuantitySelectedEvent(shoppingcartitem.deal.uuid, shoppingcartitem.dealOption.uuid, i, j));
            return;
        }
    }

    public void onToggleEditMode(ShoppingCartItem shoppingcartitem)
    {
        bus.post(new ShoppingCartItemEditModeToggledEvent(shoppingcartitem));
        boolean flag;
        if (!currentEditMode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setEditMode(flag);
    }

    public void setItem(ShoppingCartItem shoppingcartitem, boolean flag)
    {
        setTitle(shoppingcartitem);
        setPrices(shoppingcartitem);
        setImage(shoppingcartitem);
        setQuantity(shoppingcartitem);
        setEditMode(flag);
        setTimeLeft(shoppingcartitem);
    }
}
