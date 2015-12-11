// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.ui.view.product.ProductDialogZipCodeView;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductPickUpDialogFragment

private class <init>
    implements com.target.ui.view.product.Fragment.b
{

    final ProductPickUpDialogFragment this$0;

    public void a()
    {
        ProductPickUpDialogFragment.i(ProductPickUpDialogFragment.this);
    }

    public void a(String s)
    {
        ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this, s);
        ProductPickUpDialogFragment.k(ProductPickUpDialogFragment.this).zipCodeView.setZipCode(ProductPickUpDialogFragment.j(ProductPickUpDialogFragment.this));
        ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, s);
    }

    private ews()
    {
        this$0 = ProductPickUpDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
