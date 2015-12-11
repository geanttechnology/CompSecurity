// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import com.google.a.a.e;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.view.TargetFloatingActionMenu;

public class ProductFulfillmentFloatingActionMenu extends TargetFloatingActionMenu
{

    private ProductFulfillmentOptions mDisplayOptions;

    public ProductFulfillmentFloatingActionMenu(Context context)
    {
        super(context);
        h();
    }

    public ProductFulfillmentFloatingActionMenu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h();
    }

    public ProductFulfillmentFloatingActionMenu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        h();
    }

    private void h()
    {
    }

    public e getFulfillmentDisplayOptions()
    {
        return e.c(mDisplayOptions);
    }

    public void setFulfillmentDisplayOptions(ProductFulfillmentOptions productfulfillmentoptions)
    {
        mDisplayOptions = productfulfillmentoptions;
    }
}
