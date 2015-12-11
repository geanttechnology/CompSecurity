// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import android.view.View;
import com.target.mothership.model.product.interfaces.ProductDetails;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductPickUpDialogFragment

private class <init>
    implements android.view.ctPickUpDialogFragment.a
{

    final ProductPickUpDialogFragment this$0;

    public void onClick(View view)
    {
        if (ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this) == null)
        {
            return;
        }
        .SwitchMap.com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.ViewType[ProductPickUpDialogFragment.c(ProductPickUpDialogFragment.this).ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 126
    //                   2 137;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_137;
_L1:
        view = null;
_L4:
        ProductDetails productdetails;
        if (ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this).H())
        {
            productdetails = ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this);
        } else
        {
            productdetails = null;
        }
        ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this)._mth0(view, f(), productdetails, ProductPickUpDialogFragment.f(ProductPickUpDialogFragment.this), ProductPickUpDialogFragment.g(ProductPickUpDialogFragment.this), ProductPickUpDialogFragment.h(ProductPickUpDialogFragment.this));
        getDialog().dismiss();
        return;
_L2:
        view = ProductPickUpDialogFragment.d(ProductPickUpDialogFragment.this);
          goto _L4
        view = ProductPickUpDialogFragment.e(ProductPickUpDialogFragment.this);
          goto _L4
    }

    private I()
    {
        this$0 = ProductPickUpDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
