// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface TradeIn
{

    public abstract Link getLink();

    public abstract List getOffers();

    public abstract String getPrice();

    public abstract Link getResultLink();

    public abstract void setLink(Link link);

    public abstract void setOffers(List list);

    public abstract void setPrice(String s);

    public abstract void setResultLink(Link link);
}
