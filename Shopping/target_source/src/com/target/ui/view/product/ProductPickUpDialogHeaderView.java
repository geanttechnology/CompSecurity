// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view.product:
//            ProductDialogHeaderView, a

public class ProductPickUpDialogHeaderView extends ProductDialogHeaderView
{

    public ProductPickUpDialogHeaderView(Context context)
    {
        super(context);
    }

    public ProductPickUpDialogHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ProductPickUpDialogHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected boolean a()
    {
        return true;
    }

    protected a getFulfillmentType()
    {
        return a.PICK_UP;
    }
}
