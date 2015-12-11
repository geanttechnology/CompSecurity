// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import android.view.View;
import com.target.mothership.model.product.interfaces.ProductDetails;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductShipItDialogFragment

private class <init>
    implements android.view.ctShipItDialogFragment.a
{

    final ProductShipItDialogFragment this$0;

    public void onClick(View view)
    {
        if (ProductShipItDialogFragment.a(ProductShipItDialogFragment.this) == null || ProductShipItDialogFragment.b(ProductShipItDialogFragment.this) == null)
        {
            return;
        }
        if (ProductShipItDialogFragment.c(ProductShipItDialogFragment.this).H())
        {
            view = ProductShipItDialogFragment.c(ProductShipItDialogFragment.this);
        } else
        {
            view = null;
        }
        ProductShipItDialogFragment.a(ProductShipItDialogFragment.this)._mth0(ProductShipItDialogFragment.b(ProductShipItDialogFragment.this), f(), view, ProductShipItDialogFragment.d(ProductShipItDialogFragment.this), null, null);
        getDialog().dismiss();
    }

    private I()
    {
        this$0 = ProductShipItDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
