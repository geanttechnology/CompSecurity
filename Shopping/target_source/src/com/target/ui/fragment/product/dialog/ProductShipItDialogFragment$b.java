// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.ui.helper.product.ProductVariationModelHelper;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductShipItDialogFragment

private class <init>
    implements com.target.ui.view.product.Fragment.b
{

    final ProductShipItDialogFragment this$0;

    public void a()
    {
        ProductShipItDialogFragment.a(ProductShipItDialogFragment.this, ProductShipItDialogFragment.c(ProductShipItDialogFragment.this));
        ProductShipItDialogFragment.e(ProductShipItDialogFragment.this);
        ProductShipItDialogFragment.a(ProductShipItDialogFragment.this, false);
        ProductShipItDialogFragment.b(ProductShipItDialogFragment.this, ProductShipItDialogFragment.c(ProductShipItDialogFragment.this));
    }

    public void a(GridItem griditem)
    {
        ProductShipItDialogFragment.this.a(griditem);
    }

    public void a(ListItem listitem, GridItem griditem)
    {
        listitem = ProductVariationModelHelper.a(ProductShipItDialogFragment.c(ProductShipItDialogFragment.this), ProductShipItDialogFragment.d(ProductShipItDialogFragment.this), f(), listitem, griditem);
        ProductShipItDialogFragment.c(ProductShipItDialogFragment.this, listitem);
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
