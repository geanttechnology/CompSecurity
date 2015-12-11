// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import fd;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            StickyGroupExpandableListView

class a
    implements Runnable
{

    final StickyGroupExpandableListView a;

    public void run()
    {
        boolean flag;
        if (StickyGroupExpandableListView.d(a) != null)
        {
            if (!StickyGroupExpandableListView.d(a).onGroupClick(a, StickyGroupExpandableListView.e(a), StickyGroupExpandableListView.f(a), StickyGroupExpandableListView.c(a).getGroupId(StickyGroupExpandableListView.f(a))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        if (flag)
        {
            if (StickyGroupExpandableListView.c(a).a(StickyGroupExpandableListView.f(a)))
            {
                a.collapseGroup(StickyGroupExpandableListView.f(a));
            } else
            {
                a.expandGroup(StickyGroupExpandableListView.f(a));
            }
            a.setSelectedGroup(StickyGroupExpandableListView.f(a));
        }
    }

    (StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        a = stickygroupexpandablelistview;
        super();
    }
}
