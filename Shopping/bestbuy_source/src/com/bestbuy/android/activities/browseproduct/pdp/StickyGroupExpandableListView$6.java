// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.database.DataSetObserver;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            StickyGroupExpandableListView

class a extends DataSetObserver
{

    final StickyGroupExpandableListView a;

    public void onChanged()
    {
        StickyGroupExpandableListView.a(a, null);
    }

    public void onInvalidated()
    {
        StickyGroupExpandableListView.a(a, null);
    }

    (StickyGroupExpandableListView stickygroupexpandablelistview)
    {
        a = stickygroupexpandablelistview;
        super();
    }
}
