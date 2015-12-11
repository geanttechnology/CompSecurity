// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.models.EndlessList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

protected static class businessesEndlessList extends EndlessList
{

    EndlessList businessesEndlessList;
    EndlessList otherDealsEndlessList;

    public EndlessList getBusinessesEndlessList()
    {
        return businessesEndlessList;
    }

    public EndlessList getOtherEndlessList()
    {
        return otherDealsEndlessList;
    }

    public (List list, EndlessList endlesslist, EndlessList endlesslist1, int i, int j, Object obj)
    {
        super(list, i, j, obj);
        otherDealsEndlessList = endlesslist;
        businessesEndlessList = endlesslist1;
    }
}
