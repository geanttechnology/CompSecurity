// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationSet;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugView, SearchDebugDataStore

class val.context
    implements android.widget.SelectedListener
{

    final SearchDebugView this$0;
    final Context val$context;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        view = new ArrayAdapter(val$context, com.amazon.retailsearch.spinner_item, ((SearchConfiguration)SearchDebugView.access$500(SearchDebugView.this).getConfigurations().get((String)SearchDebugView.access$400(SearchDebugView.this).getSelectedItem())).getRealms().keySet().toArray(new String[0]));
        SearchDebugView.access$600(SearchDebugView.this).setAdapter(view);
        if (dataStore.getSearchRealm() != null)
        {
            adapterview = dataStore.getSearchRealm().getId();
        } else
        {
            adapterview = null;
        }
        i = view.getPosition(adapterview);
        if (i != -1)
        {
            SearchDebugView.access$600(SearchDebugView.this).setSelection(i);
        }
        SearchDebugView.access$000(SearchDebugView.this);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    re()
    {
        this$0 = final_searchdebugview;
        val$context = Context.this;
        super();
    }
}
