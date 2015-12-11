// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductAddToCartErrorDialog

private class <init>
    implements android.view.ctAddToCartErrorDialog.a
{

    final ProductAddToCartErrorDialog this$0;

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756335: 
            if (ProductAddToCartErrorDialog.a(ProductAddToCartErrorDialog.this))
            {
                ProductAddToCartErrorDialog.d(ProductAddToCartErrorDialog.this).b(ProductAddToCartErrorDialog.b(ProductAddToCartErrorDialog.this), ProductAddToCartErrorDialog.c(ProductAddToCartErrorDialog.this));
            } else
            {
                ProductAddToCartErrorDialog.d(ProductAddToCartErrorDialog.this).c(ProductAddToCartErrorDialog.b(ProductAddToCartErrorDialog.this), ProductAddToCartErrorDialog.c(ProductAddToCartErrorDialog.this));
            }
            getDialog().dismiss();
            return;

        case 2131756334: 
            getDialog().dismiss();
            return;

        case 2131756336: 
            getDialog().cancel();
            return;
        }
    }

    private I()
    {
        this$0 = ProductAddToCartErrorDialog.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
