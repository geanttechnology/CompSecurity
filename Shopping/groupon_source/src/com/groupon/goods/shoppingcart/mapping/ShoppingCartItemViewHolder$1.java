// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart.mapping;

import android.view.View;
import com.groupon.goods.shoppingcart.ShoppingCartItemPresenter;
import com.groupon.models.shoppingCart.ShoppingCartItem;

// Referenced classes of package com.groupon.goods.shoppingcart.mapping:
//            ShoppingCartItemViewHolder

class val.item
    implements android.view.ppingCartItemViewHolder._cls1
{

    final ShoppingCartItemViewHolder this$0;
    final ShoppingCartItem val$item;

    public boolean onLongClick(View view)
    {
        ShoppingCartItemViewHolder.access$000(ShoppingCartItemViewHolder.this).onToggleEditMode(val$item);
        return true;
    }

    I()
    {
        this$0 = final_shoppingcartitemviewholder;
        val$item = ShoppingCartItem.this;
        super();
    }
}
