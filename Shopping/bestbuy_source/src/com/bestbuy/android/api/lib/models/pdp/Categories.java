// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            PDPCategory

public class Categories
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List subCategories;
    private PDPCategory uberCategory;

    public Categories()
    {
    }

    public List getSubCategories()
    {
        return subCategories;
    }

    public PDPCategory getUberCategory()
    {
        return uberCategory;
    }

    public void setSubCategories(List list)
    {
        subCategories = list;
    }

    public void setUberCategory(PDPCategory pdpcategory)
    {
        uberCategory = pdpcategory;
    }
}
