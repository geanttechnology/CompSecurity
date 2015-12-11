// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.view.View;
import android.widget.ExpandableListView;
import com.bestbuy.android.api.lib.models.solr.Facet;
import com.bestbuy.android.api.lib.models.solr.Value;
import eu;
import java.util.HashMap;
import java.util.List;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.plp:
//            PLPNarrowResultsFilterFragment

class a
    implements android.widget.stener
{

    final PLPNarrowResultsFilterFragment a;

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        expandablelistview = ((Value)PLPNarrowResultsFilterFragment.i(a).getChild(i, j)).getValue();
        if (view.findViewById(0x7f0c030b).getVisibility() == 8)
        {
            view.findViewById(0x7f0c030b).setVisibility(0);
            PLPNarrowResultsFilterFragment.a(a, i, expandablelistview);
        } else
        {
            view.findViewById(0x7f0c030b).setVisibility(8);
            view = ((Facet)PLPNarrowResultsFilterFragment.j(a).get(i)).getFacetField();
            PLPNarrowResultsFilterFragment.a(a, view, expandablelistview);
        }
        PLPNarrowResultsFilterFragment.k(a);
        expandablelistview = a.f.P();
        if (expandablelistview != null && !expandablelistview.isEmpty())
        {
            expandablelistview = (String)expandablelistview.get(PLPNarrowResultsFilterFragment.l(a));
        }
        return true;
    }

    (PLPNarrowResultsFilterFragment plpnarrowresultsfilterfragment)
    {
        a = plpnarrowresultsfilterfragment;
        super();
    }
}
