// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Category

public class CategoryHistogram
{

    public Category category;
    public List childCategoryHistogram;

    public CategoryHistogram()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("CategoryHistogram(").append(category).append(",").append(childCategoryHistogram).append(")").toString();
    }
}
