// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.support.v7.it;
import com.abtnprojects.ambatana.models.ProductInserted;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            ApiProduct, RemoteImage

public class ProductInsertedEntity
{

    private final List prepositions;

    public ProductInsertedEntity(List list)
    {
        prepositions = list;
    }

    public ProductInserted transform(ApiProduct apiproduct, boolean flag)
    {
        Object obj1 = null;
        if (apiproduct != null)
        {
            String s = it.a(prepositions, " ", " ", apiproduct.getName());
            String s1 = it.a(prepositions, "\\.", ".", apiproduct.getDescription());
            Object obj = apiproduct.getImages();
            if (obj == null || ((List) (obj)).size() == 0)
            {
                obj = null;
            } else
            {
                obj = (RemoteImage)((List) (obj)).get(0);
            }
            if (obj == null)
            {
                obj = obj1;
            } else
            {
                obj = ((RemoteImage) (obj)).getUrl();
            }
            return new ProductInserted(s, s1, apiproduct.getCategoryId(), flag, apiproduct.getId(), ((String) (obj)));
        } else
        {
            return null;
        }
    }
}
