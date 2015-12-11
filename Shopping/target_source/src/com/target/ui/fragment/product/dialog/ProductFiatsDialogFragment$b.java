// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductFiatsDialogFragment

private class <init>
    implements com.target.ui.view.product.Fragment.b
{

    final ProductFiatsDialogFragment this$0;

    public void a()
    {
        ProductFiatsDialogFragment.a(ProductFiatsDialogFragment.this);
    }

    public void a(GridItem griditem)
    {
        ProductFiatsDialogFragment.this.a(griditem);
    }

    public void a(ListItem listitem, GridItem griditem)
    {
        listitem = ProductVariationModelHelper.a(ProductFiatsDialogFragment.b(ProductFiatsDialogFragment.this), ProductFiatsDialogFragment.c(ProductFiatsDialogFragment.this), f(), listitem, griditem);
        if (listitem == null)
        {
            ProductFiatsDialogFragment.d(ProductFiatsDialogFragment.this);
            return;
        } else
        {
            ProductFiatsDialogFragment.a(ProductFiatsDialogFragment.this, listitem);
            return;
        }
    }

    private ()
    {
        this$0 = ProductFiatsDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
