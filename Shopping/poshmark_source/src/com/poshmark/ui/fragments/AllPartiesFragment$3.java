// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.AbsListView;

// Referenced classes of package com.poshmark.ui.fragments:
//            AllPartiesFragment

class this._cls0
    implements android.widget.istener
{

    final AllPartiesFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (!AllPartiesFragment.bIsFetchingFeedOnScroll && k > 0 && i + j >= k)
        {
            AllPartiesFragment.bIsFetchingFeedOnScroll = true;
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ()
    {
        this$0 = AllPartiesFragment.this;
        super();
    }
}
