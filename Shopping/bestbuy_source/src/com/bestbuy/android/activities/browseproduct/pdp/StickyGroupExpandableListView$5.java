// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import fd;
import np;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            StickyGroupExpandableListView

class a extends android.view.istener
{

    final StickyGroupExpandableListView a;

    public void onLongPress(MotionEvent motionevent)
    {
        if (StickyGroupExpandableListView.e(a) != null && !StickyGroupExpandableListView.e(a).isLongClickable())
        {
            motionevent = new android.widget.tContextMenuInfo(StickyGroupExpandableListView.e(a), ExpandableListView.getPackedPositionForGroup(StickyGroupExpandableListView.f(a)), StickyGroupExpandableListView.c(a).getGroupId(StickyGroupExpandableListView.f(a)));
            np.a(android/widget/AbsListView, "mContextMenuInfo", a, motionevent);
            a.showContextMenu();
        }
    }

    (StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        a = stickygroupexpandablelistview;
        super();
    }
}
