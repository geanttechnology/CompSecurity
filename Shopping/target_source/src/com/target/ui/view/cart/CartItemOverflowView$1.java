// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.view.MenuItem;

// Referenced classes of package com.target.ui.view.cart:
//            CartItemOverflowView

class this._cls0
    implements android.support.v7.widget.is._cls0
{

    final CartItemOverflowView this$0;

    public boolean a(MenuItem menuitem)
    {
        if (CartItemOverflowView.a(CartItemOverflowView.this) == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("must set a listener on ").append(com/target/ui/view/cart/CartItemOverflowView.getSimpleName()).toString());
        }
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756542: 
            CartItemOverflowView.a(CartItemOverflowView.this).a(CartItemOverflowView.this);
            return true;

        case 2131756541: 
            CartItemOverflowView.a(CartItemOverflowView.this).b(CartItemOverflowView.this);
            return true;
        }
    }

    ()
    {
        this$0 = CartItemOverflowView.this;
        super();
    }
}
