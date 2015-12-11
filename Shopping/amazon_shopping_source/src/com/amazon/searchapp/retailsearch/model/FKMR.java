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
}
