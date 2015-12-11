// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Link, Department

public interface Refinements
{

    public abstract Link getClearAllLink();

    public abstract List getCustomFilters();

    public abstract Department getDepartments();

    public abstract List getFilters();

    public abstract List getPrioritizedFilterIds();

    public abstract void setClearAllLink(Link link);

    public abstract void setCustomFilters(List list);

    public abstract void setDepartments(Department department);

    public abstract void setFilters(List list);

    public abstract void setPrioritizedFilterIds(List list);
}
