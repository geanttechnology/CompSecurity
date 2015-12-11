// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPNarrowResultsFilterFragment

class a
    implements android.widget.stener
{

    final PLPNarrowResultsFilterFragment a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        ((ImageView)view.findViewById(0x7f0c0307)).setImageResource(0x7f020117);
        return false;
    }

    (PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        a = plpnarrowresultsfilterfragment;
        super();
    }
}
