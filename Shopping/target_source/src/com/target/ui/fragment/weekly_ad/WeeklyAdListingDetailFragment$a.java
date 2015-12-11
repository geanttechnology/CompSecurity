// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.c.b.e;
import com.target.ui.util.ad;
import com.target.ui.view.common.h;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdListingDetailFragment

protected class this._cls0 extends e
{

    final WeeklyAdListingDetailFragment this$0;

    public void a(String s)
    {
        WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this).c(s);
    }

    public void a(String s, ListSummary listsummary)
    {
        ad.a(getActivity(), s, WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this), listsummary, m());
    }

    protected ()
    {
        this$0 = WeeklyAdListingDetailFragment.this;
        super();
    }
}
