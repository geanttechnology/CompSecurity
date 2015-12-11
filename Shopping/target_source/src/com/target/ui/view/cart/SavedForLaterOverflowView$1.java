// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.view.MenuItem;

// Referenced classes of package com.target.ui.view.cart:
//            SavedForLaterOverflowView

class this._cls0
    implements android.support.v7.widget.is._cls0
{

    final SavedForLaterOverflowView this$0;

    public boolean a(MenuItem menuitem)
    {
        if (SavedForLaterOverflowView.a(SavedForLaterOverflowView.this) == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("must set a listener on ").append(com/target/ui/view/cart/SavedForLaterOverflowView.getSimpleName()).toString());
        }
        switch (menuitem.getItemId())
        {
        default:
            return false;

        case 2131756561: 
            SavedForLaterOverflowView.a(SavedForLaterOverflowView.this).a();
            return true;

        case 2131756562: 
            SavedForLaterOverflowView.a(SavedForLaterOverflowView.this).b();
            break;
        }
        return true;
    }

    _cls9()
    {
        this$0 = SavedForLaterOverflowView.this;
        super();
    }
}
