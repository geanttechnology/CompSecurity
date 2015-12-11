// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.goods.shoppingcart;

import android.content.DialogInterface;

// Referenced classes of package com.groupon.goods.shoppingcart:
//            ShoppingCartErrorHelper, ShoppingCartPresenter

private class <init>
    implements android.content.artDialogClick
{

    final ShoppingCartErrorHelper this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (ShoppingCartErrorHelper.access$200(ShoppingCartErrorHelper.this) != null)
        {
            ShoppingCartErrorHelper.access$200(ShoppingCartErrorHelper.this).cacheCart();
        }
    }

    private ()
    {
        this$0 = ShoppingCartErrorHelper.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
