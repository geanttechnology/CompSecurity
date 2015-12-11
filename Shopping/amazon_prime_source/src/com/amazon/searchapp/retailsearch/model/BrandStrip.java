// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Widget

public interface BrandStrip
    extends Widget
{

    public abstract String getBrand();

    public abstract List getBrandCells();

    public abstract String getOriginalKeywords();

    public abstract String getStoreName();

    public abstract void setBrand(String s);

    public abstract void setBrandCells(List list);

    public abstract void setOriginalKeywords(String s);

    public abstract void setStoreName(String s);
}
