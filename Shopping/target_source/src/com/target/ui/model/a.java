// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model;

import com.target.mothership.common.product.i;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import java.util.List;

public class a
{

    private i mInventoryStatus;
    private List mProductAvailabilityTypes;
    private int mSaleableQuantity;
    private RelevantStoreSummary mStoreSummary;

    public a(RelevantStoreSummary relevantstoresummary, int i, i j, List list)
    {
        mStoreSummary = relevantstoresummary;
        mSaleableQuantity = i;
        mInventoryStatus = j;
        mProductAvailabilityTypes = list;
    }

    public RelevantStoreSummary a()
    {
        return mStoreSummary;
    }

    public i b()
    {
        return mInventoryStatus;
    }

    public int c()
    {
        return mSaleableQuantity;
    }

    public List d()
    {
        return mProductAvailabilityTypes;
    }
}
