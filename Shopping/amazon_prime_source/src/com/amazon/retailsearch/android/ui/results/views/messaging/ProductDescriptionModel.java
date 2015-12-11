// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import com.amazon.retailsearch.util.Utils;
import java.util.List;

public class ProductDescriptionModel
{
    public static class Builder
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

        public Builder()
        {
        }
    }


    private List description;

    public ProductDescriptionModel()
    {
    }

    public List getDescription()
    {
        return description;
    }

    public void setDescription(List list)
    {
        description = list;
    }
}
