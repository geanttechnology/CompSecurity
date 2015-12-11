// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.ebay.nautilus.domain.content.dm.CollectionDetailsDataManager;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsActivity

class <init> extends android.support.v7.widget.r
{

    final CollectionDetailsActivity this$0;
    public int totalScrolled;

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        totalScrolled = totalScrolled + j;
        recyclerViewChildCount = recyclerview.getChildCount();
        layoutManagerItemCount = CollectionDetailsActivity.access$200(CollectionDetailsActivity.this).getItemCount();
        firstVisibleItemIndex = CollectionDetailsActivity.access$200(CollectionDetailsActivity.this).findFirstVisibleItemPosition();
        if (CollectionDetailsActivity.access$300(CollectionDetailsActivity.this) && layoutManagerItemCount > CollectionDetailsActivity.access$400(CollectionDetailsActivity.this))
        {
            CollectionDetailsActivity.access$302(CollectionDetailsActivity.this, false);
            CollectionDetailsActivity.access$402(CollectionDetailsActivity.this, layoutManagerItemCount);
        }
        if (!CollectionDetailsActivity.access$300(CollectionDetailsActivity.this) && layoutManagerItemCount - recyclerViewChildCount <= firstVisibleItemIndex + CollectionDetailsActivity.access$500(CollectionDetailsActivity.this))
        {
            CollectionDetailsActivity.access$600(CollectionDetailsActivity.this).loadNextPage(false);
            CollectionDetailsActivity.access$302(CollectionDetailsActivity.this, true);
        }
    }

    aManager()
    {
        this$0 = CollectionDetailsActivity.this;
        super();
    }
}
