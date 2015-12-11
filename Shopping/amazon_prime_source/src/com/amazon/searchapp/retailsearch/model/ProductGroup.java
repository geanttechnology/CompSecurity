// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link

public interface ProductGroup
{

    public abstract boolean getDefaultGroup();

    public abstract Link getDetailLink();

    public abstract String getName();

    public abstract List getProducts();

    public abstract String getType();

    public abstract void setDefaultGroup(boolean flag);

    public abstract void setDetailLink(Link link);

    public abstract void setName(String s);

    public abstract void setProducts(List list);

    public abstract void setType(String s);
}
