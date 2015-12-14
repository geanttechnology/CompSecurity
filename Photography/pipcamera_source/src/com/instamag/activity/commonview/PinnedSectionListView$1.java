// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.widget.AbsListView;

// Referenced classes of package com.instamag.activity.commonview:
//            PinnedSectionListView

class a
    implements android.widget.ener
{

    final PinnedSectionListView a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (PinnedSectionListView.access$000(a) != null)
        {
            PinnedSectionListView.access$000(a).onScrollStateChanged(abslistview, i);
        }
    }

    (PinnedSectionListView pinnedsectionlistview)
    {
        a = pinnedsectionlistview;
        super();
    }
}
