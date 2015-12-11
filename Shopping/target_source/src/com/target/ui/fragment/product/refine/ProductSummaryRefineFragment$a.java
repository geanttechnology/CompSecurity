// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.refine;

import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.refine.ProductSortModel;
import com.target.ui.view.common.TargetBottomButton;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.fragment.product.refine:
//            ProductSummaryRefineFragment

private class <init>
    implements com.target.ui.view.refine.eFragment.a
{

    final ProductSummaryRefineFragment this$0;

    public void a(ProductEntry productentry)
    {
        ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(true);
        ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).add(productentry);
    }

    public void a(com.target.ui.model.refine.Fragment.a a1)
    {
        ProductSummaryRefineFragment.e(ProductSummaryRefineFragment.this).b().a(a1);
        ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(true);
    }

    public void b(ProductEntry productentry)
    {
        ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).remove(productentry);
        if (ProductSummaryRefineFragment.f(ProductSummaryRefineFragment.this).isEmpty())
        {
            ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(false);
        }
    }

    public void b(com.target.ui.model.refine.Fragment.a a1)
    {
        ProductSummaryRefineFragment.e(ProductSummaryRefineFragment.this).b().a(null);
        ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn.setLeftBtnEnable(false);
    }

    private ews()
    {
        this$0 = ProductSummaryRefineFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
