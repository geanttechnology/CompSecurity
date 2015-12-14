// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.livemixtapes.ui.widgets.SearchView;
import com.livemixtapes.utils.Utility;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            SearchFragment, LazyAdapterSearch

class this._cls0
    implements android.widget.mClickListener
{

    final SearchFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        i -= list.getHeaderViewsCount();
        if (adapter.isTopArtistSearch())
        {
            adapterview = ((HashMap)topArtistsResultsList.get(i)).get("artist").toString();
            searchView.setQuery(adapterview);
            return;
        } else
        {
            Utility.hideKeyboard(activity);
            SearchFragment.access$0(SearchFragment.this, activity, adapter.getResult(i));
            return;
        }
    }

    View()
    {
        this$0 = SearchFragment.this;
        super();
    }
}
