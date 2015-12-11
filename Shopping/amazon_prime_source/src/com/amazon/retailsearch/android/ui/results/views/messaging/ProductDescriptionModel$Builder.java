// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ProductDescriptionModel

public static class 
{

    public ProductDescriptionModel build(List list)
    {
        if (Utils.isEmpty(list))
        {
            return null;
        } else
        {
            ProductDescriptionModel productdescriptionmodel = new ProductDescriptionModel();
            productdescriptionmodel.setDescription(list);
            return productdescriptionmodel;
        }
    }

    public ()
    {
    }
}
