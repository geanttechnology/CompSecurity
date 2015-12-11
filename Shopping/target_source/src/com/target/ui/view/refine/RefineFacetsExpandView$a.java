// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import com.target.mothership.model.product.interfaces.ProductEntry;

// Referenced classes of package com.target.ui.view.refine:
//            RefineFacetsExpandView

private class <init>
    implements .a
{

    final RefineFacetsExpandView this$0;

    public void a(ProductEntry productentry)
    {
        RefineFacetsExpandView.this.a(true);
        if (RefineFacetsExpandView.a(RefineFacetsExpandView.this) != null)
        {
            RefineFacetsExpandView.a(RefineFacetsExpandView.this).a(productentry);
        }
    }

    public void b(ProductEntry productentry)
    {
        RefineFacetsExpandView.this.a(false);
        if (RefineFacetsExpandView.a(RefineFacetsExpandView.this) != null)
        {
            RefineFacetsExpandView.a(RefineFacetsExpandView.this).b(productentry);
        }
    }

    private uctEntry()
    {
        this$0 = RefineFacetsExpandView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
