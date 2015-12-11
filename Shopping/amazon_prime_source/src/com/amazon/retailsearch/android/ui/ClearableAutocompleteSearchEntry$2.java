// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.metrics.IssLogger;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class this._cls0
    implements android.widget.mpleteSearchEntry._cls2
{

    final ClearableAutocompleteSearchEntry this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = (RetailSearchSuggestionRow)adapterview.getItemAtPosition(i);
        if (ClearableAutocompleteSearchEntry.access$300(ClearableAutocompleteSearchEntry.this) != null)
        {
            String s = view.getSuggestion();
            String s1 = view.getSearchAlias();
            if (view.getQuery() == null)
            {
                adapterview = "";
            } else
            {
                adapterview = view.getQuery();
            }
            ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setText(s);
            view = new RetailSearchQuery(s1, s, adapterview, IssLogger.createLogData(view, ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this).getSearchAlias(), s1, s, adapterview));
            view.setRefTag(IssLogger.computeSelectRefTag(ClearableAutocompleteSearchEntry.access$200(ClearableAutocompleteSearchEntry.this).getSuggestionRows(), i, adapterview));
            for (adapterview = ClearableAutocompleteSearchEntry.access$300(ClearableAutocompleteSearchEntry.this).iterator(); adapterview.hasNext(); ((QuerySubmitListener)adapterview.next()).onQuerySubmit(view)) { }
        }
    }

    tListener()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
