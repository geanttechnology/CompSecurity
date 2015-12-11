// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.search;

import android.view.View;

// Referenced classes of package com.target.ui.adapter.search:
//            ProductSearchSuggestionAdapter

public class searchQuery
    implements android.view.estionAdapter.a
{

    private String searchQuery;
    final ProductSearchSuggestionAdapter this$0;

    public void onClick(View view)
    {
        ProductSearchSuggestionAdapter.a(ProductSearchSuggestionAdapter.this).a(searchQuery);
    }

    public (String s)
    {
        this$0 = ProductSearchSuggestionAdapter.this;
        super();
        searchQuery = s;
    }
}
