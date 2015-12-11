// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.amazon.now.search:
//            RetailSearchEntryViewListener

class val.whitelist
    implements Comparator
{

    final RetailSearchEntryViewListener this$0;
    final List val$whitelist;

    public int compare(RetailSearchSuggestionRow retailsearchsuggestionrow, RetailSearchSuggestionRow retailsearchsuggestionrow1)
    {
        if (retailsearchsuggestionrow.getSuggestionType() == com.amazon.retailsearch.data.e.PAST_SEARCHES || retailsearchsuggestionrow.getSuggestionType() == com.amazon.retailsearch.data.e.MERGED)
        {
            return -1;
        }
        if (retailsearchsuggestionrow1.getSuggestionType() == com.amazon.retailsearch.data.e.PAST_SEARCHES || retailsearchsuggestionrow1.getSuggestionType() == com.amazon.retailsearch.data.e.MERGED)
        {
            return 1;
        } else
        {
            return val$whitelist.indexOf(retailsearchsuggestionrow.getSearchAlias()) - val$whitelist.indexOf(retailsearchsuggestionrow1.getSearchAlias());
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((RetailSearchSuggestionRow)obj, (RetailSearchSuggestionRow)obj1);
    }

    uggestionRow()
    {
        this$0 = final_retailsearchentryviewlistener;
        val$whitelist = List.this;
        super();
    }
}
