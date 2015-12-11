// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface NonPrimeOffer
{

    public abstract String getAsin();

    public abstract List getLabel();

    public abstract Link getLink();

    public abstract void setAsin(String s);

    public abstract void setLabel(List list);

    public abstract void setLink(Link link);
}
