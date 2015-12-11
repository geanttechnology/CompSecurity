// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.graphics.drawable.Drawable;
import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilterListener;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

public static class searchMagnifier
    implements RetailSearchSuggestionFilterListener
{

    private RetailSearchSuggestionAdapter adapter;
    private ClearableAutoCompleteTextView autoCompleteTextView;
    RetailSearchAndroidPlatform platform;
    private Drawable searchMagnifier;
    private Drawable workingSpinner;

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

            final RetailSearchQueryEntry.FilterListener this$0;

            public void run()
            {
                if (autoCompleteTextView != null && workingSpinner != null)
                {
                    autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, workingSpinner, null);
                    workingSpinner.setVisible(true, false);
                }
            }

            
            {
                this$0 = RetailSearchQueryEntry.FilterListener.this;
                super();
            }
        });
    }

    public void beforePublishResults(List list, boolean flag)
    {
        if ((list == null || flag) && autoCompleteTextView != null && workingSpinner != null)
        {
            workingSpinner.setVisible(false, false);
            autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, null, null);
        }
    }

    public void setAdapter(RetailSearchSuggestionAdapter retailsearchsuggestionadapter)
    {
        adapter = retailsearchsuggestionadapter;
    }




    public _cls1.this._cls0(ClearableAutoCompleteTextView clearableautocompletetextview, Drawable drawable, Drawable drawable1)
    {
        RetailSearchDaggerGraphController.inject(this);
        autoCompleteTextView = clearableautocompletetextview;
        workingSpinner = drawable;
        searchMagnifier = drawable1;
    }
}
