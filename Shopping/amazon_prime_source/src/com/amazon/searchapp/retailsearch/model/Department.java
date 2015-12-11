// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            RefinementLink

public interface Department
{

    public abstract RefinementLink getAllLink();

    public abstract List getAncestry();

    public abstract List getCategories();

    public abstract void setAllLink(RefinementLink refinementlink);

    public abstract void setAncestry(List list);

    public abstract void setCategories(List list);
}
