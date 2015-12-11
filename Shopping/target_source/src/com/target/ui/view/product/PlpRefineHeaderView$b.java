// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            PlpRefineHeaderView

public static class mSelectedFacetsList
{

    private int mResultCount;
    private List mSelectedFacetsList;

    public int a()
    {
        return mResultCount;
    }

    public List b()
    {
        return mSelectedFacetsList;
    }

    public (int i, List list)
    {
        mResultCount = i;
        mSelectedFacetsList = list;
    }
}
