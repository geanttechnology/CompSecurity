// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.DialogInterface;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity

class this._cls0
    implements android.content.Listener
{

    final ShoppingCartActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ShoppingCartActivity.access$300(ShoppingCartActivity.this).getCartAsync(true);
        dialoginterface.cancel();
    }

    ManagerBase()
    {
        this$0 = ShoppingCartActivity.this;
        super();
    }
}
