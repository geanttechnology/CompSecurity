// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.graphics.drawable.Drawable;
import com.amazon.retailsearch.android.api.display.input.listeners.ISSListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilterListener;
import com.amazon.retailsearch.android.ui.entry.SuggestionRowModifier;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

public class this._cls0
    implements RetailSearchSuggestionFilterListener
{

    private RetailSearchSuggestionAdapter adapter;
    final ClearableAutocompleteSearchEntry this$0;

    public void afterConstructRows(List list)
    {
        if (ClearableAutocompleteSearchEntry.access$1000(ClearableAutocompleteSearchEntry.this) == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        ClearableAutocompleteSearchEntry.access$1000(ClearableAutocompleteSearchEntry.this).preRenderSuggestions(new SuggestionRowModifier(list));
        return;
        list;
        ClearableAutocompleteSearchEntry.access$1100(ClearableAutocompleteSearchEntry.this).error("An exception occurred while modifying the suggestions.", list);
        return;
    }

    public void afterPublishResults(String s, List list)
    {
        if (adapter != null)
        {
            adapter.updateSuggestionContent(s, list);
            adapter.notifyDataSetChanged();
        }
    }

    public void beforePerformFiltering()
    {
        platform.invokeLater(new Runnable() {

            final ClearableAutocompleteSearchEntry.FilterListener this$1;

            public void run()
            {
                if (ClearableAutocompleteSearchEntry.access$800(this$0) != null)
                {
                    ClearableAutocompleteSearchEntry.access$000(this$0).setCompoundDrawablesWithIntrinsicBounds(ClearableAutocompleteSearchEntry.access$900(this$0), null, ClearableAutocompleteSearchEntry.access$800(this$0), null);
                    ClearableAutocompleteSearchEntry.access$800(this$0).setVisible(true, false);
                }
            }

            
            {
                this$1 = ClearableAutocompleteSearchEntry.FilterListener.this;
                super();
            }
        });
    }

    public void beforePublishResults(List list, boolean flag)
    {
        if ((list == null || flag) && ClearableAutocompleteSearchEntry.access$800(ClearableAutocompleteSearchEntry.this) != null)
        {
            ClearableAutocompleteSearchEntry.access$800(ClearableAutocompleteSearchEntry.this).setVisible(false, false);
            ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setCompoundDrawablesWithIntrinsicBounds(ClearableAutocompleteSearchEntry.access$900(ClearableAutocompleteSearchEntry.this), null, null, null);
        }
    }

    public void setAdapter(RetailSearchSuggestionAdapter retailsearchsuggestionadapter)
    {
        adapter = retailsearchsuggestionadapter;
    }

    public _cls1.this._cls1()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
