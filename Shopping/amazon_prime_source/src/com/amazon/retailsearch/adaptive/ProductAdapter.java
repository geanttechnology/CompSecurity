// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive;

import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import com.amazon.retailsearch.adaptive.framework.ModelAdapter;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.retailsearch.adaptive:
//            ImageAdapter

public class ProductAdapter
    implements ModelAdapter
{

    private static ProductAdapter instance = null;
    private ImageAdapter imageAdapter;

    private ProductAdapter()
    {
        imageAdapter = null;
        imageAdapter = ImageAdapter.getInstance();
    }

    public static ProductAdapter getInstance()
    {
        if (instance == null)
        {
            instance = new ProductAdapter();
        }
        return instance;
    }

    public Product adapt(Product product, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
        if (product != null)
        {
            imageAdapter.adapt(product.getImage(), adaptivetreatmentenum);
        }
        return product;
    }

    public volatile Object adapt(Object obj, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
        return adapt((Product)obj, adaptivetreatmentenum);
    }

}
