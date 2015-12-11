// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.refine;

import com.target.mothership.model.product.interfaces.ProductEntry;

// Referenced classes of package com.target.ui.view.refine:
//            RefineGenericView

private class <init>
    implements 
{

    final RefineGenericView this$0;

    public void a(ProductEntry productentry)
    {
        if (getListener() == null)
        {
            return;
        } else
        {
            getListener().a(productentry);
            return;
        }
    }

    public void b(ProductEntry productentry)
    {
        if (getListener() == null)
        {
            return;
        } else
        {
            getListener().b(productentry);
            return;
        }
    }

    private .ProductEntry()
    {
        this$0 = RefineGenericView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
