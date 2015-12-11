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

    public abstract Department getDepartments();

    public abstract List getFilters();

    public abstract List getPrioritizedFilterIds();
}
