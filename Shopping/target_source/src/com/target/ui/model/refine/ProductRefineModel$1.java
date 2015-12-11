// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.refine;

import com.target.mothership.model.product.interfaces.ProductEntry;
import java.util.Comparator;

// Referenced classes of package com.target.ui.model.refine:
//            ProductRefineModel

class this._cls0
    implements Comparator
{

    final ProductRefineModel this$0;

    public int a(ProductEntry productentry, ProductEntry productentry1)
    {
        if (productentry == null && productentry1 == null)
        {
            return 0;
        }
        if (productentry == null)
        {
            return -1;
        }
        if (productentry1 == null)
        {
            return 1;
        } else
        {
            return productentry.d().compareTo(productentry1.d());
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((ProductEntry)obj, (ProductEntry)obj1);
    }

    roductEntry()
    {
        this$0 = ProductRefineModel.this;
        super();
    }
}
