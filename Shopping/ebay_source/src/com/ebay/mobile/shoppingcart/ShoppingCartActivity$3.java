// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.DialogInterface;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity

class val.cartItem
    implements android.content.Listener
{

    final ShoppingCartActivity this$0;
    final com.ebay.nautilus.domain.data.al.cartItem val$cartItem;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ShoppingCartActivity.access$200(ShoppingCartActivity.this, true);
        ShoppingCartActivity.access$300(ShoppingCartActivity.this).removeItemFromCart(val$cartItem.temId.longValue(), null);
        ShoppingCartActivity.access$100(ShoppingCartActivity.this, "rmvcart", "1", val$cartItem);
    }

    ManagerBase()
    {
        this$0 = final_shoppingcartactivity;
        val$cartItem = com.ebay.nautilus.domain.data.al.cartItem.this;
        super();
    }
}
