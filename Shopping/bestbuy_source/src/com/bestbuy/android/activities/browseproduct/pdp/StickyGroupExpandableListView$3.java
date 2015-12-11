// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            StickyGroupExpandableListView

class a
    implements Runnable
{

    final StickyGroupExpandableListView a;

    public void run()
    {
        StickyGroupExpandableListView.g(a);
        a.setPressed(true);
        if (StickyGroupExpandableListView.e(a) != null)
        {
            StickyGroupExpandableListView.e(a).setPressed(true);
        }
    }

    (StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        a = stickygroupexpandablelistview;
        super();
    }
}
