// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.search.plp;

import android.view.View;
import android.widget.ExpandableListView;
import com.bestbuy.android.api.lib.models.search.FacetValues;
import com.bestbuy.android.api.lib.models.search.Facets;
import dj;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.search.plp:
//            SearchPLPNarrowResultsFilterFragment

class a
    implements android.widget.
{

    final SearchPLPNarrowResultsFilterFragment a;

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        expandablelistview = ((Facets)SearchPLPNarrowResultsFilterFragment.i(a).get(i)).getFacetField();
        String s = ((FacetValues)SearchPLPNarrowResultsFilterFragment.j(a).getChild(i, j)).getValue();
        if (view.findViewById(0x7f0c030b).getVisibility() == 8)
        {
            view.findViewById(0x7f0c030b).setVisibility(0);
            SearchPLPNarrowResultsFilterFragment.a(a, i, s);
        } else
        {
            view.findViewById(0x7f0c030b).setVisibility(8);
            SearchPLPNarrowResultsFilterFragment.a(a, expandablelistview, s);
        }
        SearchPLPNarrowResultsFilterFragment.k(a);
        return true;
    }

    (SearchPLPNarrowResultsFilterFragment searchplpnarrowresultsfilterfragment)
    {
        a = searchplpnarrowresultsfilterfragment;
        super();
    }
}
