// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            ProductSection, Link

public interface CategoryCorrected
{

    public abstract String getKeywords();

    public abstract ProductSection getResults();

    public abstract Link getSeeMoreLink();

    public abstract List getStyledText();

    public abstract void setKeywords(String s);

    public abstract void setResults(ProductSection productsection);

    public abstract void setSeeMoreLink(Link link);

    public abstract void setStyledText(List list);
}
