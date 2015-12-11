// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import java.util.List;

// Referenced classes of package com.groupon.models.search.domain:
//            FilterSheetPresenter

public interface FilterSheetView
{

    public abstract FilterSheetPresenter getPresenter();

    public abstract void setDealCount(int i);

    public abstract void setFilterCount(int i);

    public abstract void setIsRefreshing(boolean flag);

    public abstract void updateFacets(List list, List list1);

    public abstract void updateResetButtonState(boolean flag);
}
