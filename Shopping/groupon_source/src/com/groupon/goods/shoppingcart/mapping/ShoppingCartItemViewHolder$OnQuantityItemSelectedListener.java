// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import com.groupon.goods.shoppingcart.ShoppingCartItemPresenter;
import com.groupon.models.shoppingCart.ShoppingCartItem;

// Referenced classes of package com.groupon.goods.shoppingcart.mapping:
//            ShoppingCartItemViewHolder

private class itemPosition
    implements android.widget.ityItemSelectedListener
{

    private final ShoppingCartItem item;
    private final int itemPosition;
    final ShoppingCartItemViewHolder this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Integer)adapterview.getAdapter().getItem(i);
        ShoppingCartItemViewHolder.access$000(ShoppingCartItemViewHolder.this).onQuantitySelected(item, adapterview.intValue(), itemPosition);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        ShoppingCartItemViewHolder.access$000(ShoppingCartItemViewHolder.this).onQuantitySelected(item, 0, itemPosition);
    }

    public (ShoppingCartItem shoppingcartitem, int i)
    {
        this$0 = ShoppingCartItemViewHolder.this;
        super();
        item = shoppingcartitem;
        itemPosition = i;
    }
}
