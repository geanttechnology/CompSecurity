// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.models.EndlessList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            BaseDealsWithOptionalWidgetsListFragment

protected static class smuggledDeals extends EndlessList
{

    private List smuggledDeals;
    private List widgetsList;



    public (EndlessList endlesslist, List list, List list1)
    {
        super(endlesslist, endlesslist.getTotalSize(), endlesslist.getCurrentOffset(), endlesslist.getAttr());
        widgetsList = list;
        smuggledDeals = list1;
    }
}
