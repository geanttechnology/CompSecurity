// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.AbsListView;
import android.widget.ListView;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0
    implements android.widget.ner
{

    final HotelCardListFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (list.isShown() || HotelCardListFragment.access$300(HotelCardListFragment.this))
        {
            if (i >= 1)
            {
                HotelCardListFragment.access$400(HotelCardListFragment.this, true, true);
                return;
            }
            if (i == 0)
            {
                HotelCardListFragment.access$400(HotelCardListFragment.this, false, true);
                return;
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
