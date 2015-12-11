// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

public class SearchRefinement
{

    public List verticalCategoryHistogram;
    public List weeklyCategoryHistogram;

    public SearchRefinement()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("SearchRefinement(").append(weeklyCategoryHistogram).append(",").append(verticalCategoryHistogram).append(")").toString();
    }
}
