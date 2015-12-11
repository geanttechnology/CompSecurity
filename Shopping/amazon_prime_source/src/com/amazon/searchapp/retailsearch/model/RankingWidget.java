// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;

import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Widget

public interface RankingWidget
    extends Widget
{

    public abstract List getProductGroups();

    public abstract String getTitle();

    public abstract void setProductGroups(List list);

    public abstract void setTitle(String s);
}
