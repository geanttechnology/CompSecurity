// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import com.offerup.android.a.ah;
import com.offerup.android.dto.Item;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity

final class gz extends android.support.v7.widget.RecyclerView.OnScrollListener
{

    private int a;
    private int b;
    private int c;
    private SearchActivity d;

    private gz(SearchActivity searchactivity)
    {
        d = searchactivity;
        super();
    }

    gz(SearchActivity searchactivity, byte byte0)
    {
        this(searchactivity);
    }

    public final void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        b = SearchActivity.n(d).getChildCount();
        c = SearchActivity.n(d).getItemCount();
        a = SearchActivity.n(d).findFirstVisibleItemPositions(null)[0];
        if (c > 0 && b < c && b != 0 && a > 0)
        {
            recyclerview = (Item)SearchActivity.o(d).a(a);
            if (recyclerview != null && StringUtils.isNotEmpty(recyclerview.getSortLabel()))
            {
                d.a.setText(recyclerview.getSortLabel());
            }
        }
        if (b + a >= c)
        {
            d.n();
            return;
        } else
        {
            d.o();
            return;
        }
    }
}
