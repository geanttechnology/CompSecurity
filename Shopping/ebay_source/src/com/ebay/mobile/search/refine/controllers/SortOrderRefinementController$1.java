// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.content.Context;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapter;
import com.ebay.mobile.search.refine.types.SortOrder;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            SortOrderRefinementController

class this._cls0 extends RefineSingleOptionAdapter
{

    final SortOrderRefinementController this$0;

    public int getCount()
    {
        int j = super.getCount();
        int i;
        if (refineFragment.sortIndexToSkip != 0x7fffffff)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return j - i;
    }

    public SortOrder getItem(int i)
    {
        if (i >= refineFragment.sortIndexToSkip)
        {
            i++;
        }
        return (SortOrder)super.getItem(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    (Context context, SortOrder asortorder[])
    {
        this$0 = SortOrderRefinementController.this;
        super(context, asortorder);
    }
}
