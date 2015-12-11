// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.support.v7.widget.GridLayoutManager;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            TopLevelCategoriesAdapter

protected static final class spanCount extends android.support.v7.widget.ookup
{

    private final WeakReference layoutManagerReference;
    private final int spanCount;

    public int getSpanSize(int i)
    {
        GridLayoutManager gridlayoutmanager;
        for (gridlayoutmanager = (GridLayoutManager)layoutManagerReference.get(); gridlayoutmanager == null || i != 0;)
        {
            return 1;
        }

        return Math.min(spanCount, gridlayoutmanager.getSpanCount());
    }

    protected (GridLayoutManager gridlayoutmanager, int i)
    {
        layoutManagerReference = new WeakReference(gridlayoutmanager);
        spanCount = i;
    }
}
