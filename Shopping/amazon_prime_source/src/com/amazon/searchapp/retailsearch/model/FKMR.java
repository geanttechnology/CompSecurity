// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            ProductSection, Link

public interface FKMR
{

    public abstract int getIndex();

    public abstract List getKeywords();

    public abstract List getMessage();

    public abstract ProductSection getResults();

    public abstract Link getSeeAllLink();

    public abstract List getStyledText();

    public abstract long getTotalResults();

    public abstract void setIndex(int i);

    public abstract void setKeywords(List list);

    public abstract void setMessage(List list);

    public abstract void setResults(ProductSection productsection);

    public abstract void setSeeAllLink(Link link);

    public abstract void setStyledText(List list);

    public abstract void setTotalResults(long l);
}
