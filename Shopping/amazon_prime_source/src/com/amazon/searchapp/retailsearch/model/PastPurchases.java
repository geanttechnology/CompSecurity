// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Widget

public interface PastPurchases
    extends Widget
{

    public abstract List getHeader();

    public abstract List getProducts();

    public abstract List getSeeAllLinks();

    public abstract void setHeader(List list);

    public abstract void setProducts(List list);

    public abstract void setSeeAllLinks(List list);
}
