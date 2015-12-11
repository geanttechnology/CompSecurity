// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.view.View;
import android.widget.ExpandableListView;
import com.bestbuy.android.api.lib.models.dnm.DNMFacet;
import com.bestbuy.android.api.lib.models.dnm.DNMFacetFilter;
import fe;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMPLPNarrowFacetFragment

class a
    implements android.widget.ickListener
{

    final DNMPLPNarrowFacetFragment a;

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        expandablelistview = (DNMFacetFilter)DNMPLPNarrowFacetFragment.h(a).getChild(i, j);
        if (view.findViewById(0x7f0c030b).getVisibility() == 8)
        {
            view.findViewById(0x7f0c030b).setVisibility(0);
            DNMPLPNarrowFacetFragment.a(a, i, expandablelistview);
        } else
        {
            view.findViewById(0x7f0c030b).setVisibility(8);
            view = ((DNMFacet)DNMPLPNarrowFacetFragment.i(a).get(i)).getName();
            DNMPLPNarrowFacetFragment.a(a, view, expandablelistview);
        }
        DNMPLPNarrowFacetFragment.j(a);
        return true;
    }

    (DNMPLPNarrowFacetFragment dnmplpnarrowfacetfragment)
    {
        a = dnmplpnarrowfacetfragment;
        super();
    }
}
