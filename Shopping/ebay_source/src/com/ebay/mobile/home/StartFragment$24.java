// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment, SellFragmentAdapter

class  extends android.support.v7.widget.rollListener
{

    final StartFragment this$0;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        if (getUserVisibleHint() && StartFragment.access$1100(StartFragment.this) != null && StartFragment.access$1200(StartFragment.this) != null && StartFragment.access$1200(StartFragment.this).size() < StartFragment.access$1100(StartFragment.this).variationIdCount)
        {
            StartFragment.access$1300(StartFragment.this);
        }
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
