// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionFilter

private class searchTerm
{

    public List rows;
    public final String searchTerm;
    final RetailSearchSuggestionFilter this$0;

    public (List list, String s)
    {
        this$0 = RetailSearchSuggestionFilter.this;
        super();
        rows = list;
        searchTerm = s;
    }
}
