// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.services;

import android.content.Intent;
import com.abtnprojects.ambatana.models.product.Product;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.services:
//            a

public class ProductCreationService extends a
{

    public ProductCreationService()
    {
        super("ProductCreationService");
        c = 0;
    }

    int a(Product product)
    {
        if (product != null)
        {
            if ((product = product.getImages()) != null)
            {
                return product.size();
            }
        }
        return 0;
    }

    protected void onHandleIntent(Intent intent)
    {
        super.onHandleIntent(intent);
    }
}
