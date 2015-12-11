// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity

class val.cartItem
    implements android.content.Listener
{

    final ShoppingCartActivity this$0;
    final com.ebay.nautilus.domain.data.al.cartItem val$cartItem;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ShoppingCartActivity.access$100(ShoppingCartActivity.this, "rmvcart", "0", val$cartItem);
        dialoginterface.dismiss();
    }

    _cls9()
    {
        this$0 = final_shoppingcartactivity;
        val$cartItem = com.ebay.nautilus.domain.data.al.cartItem.this;
        super();
    }
}
