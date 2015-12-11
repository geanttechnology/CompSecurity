// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import com.target.ui.adapter.search.ProductSearchSuggestionAdapter;
import com.target.ui.adapter.search.a;
import com.target.ui.model.search.c;

// Referenced classes of package com.target.ui.view.search:
//            SearchSuggestionCardView

public class ExtendedSearchSuggestionView extends SearchSuggestionCardView
{

    public ExtendedSearchSuggestionView(Context context)
    {
        super(context);
    }

    public ExtendedSearchSuggestionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected ProductSearchSuggestionAdapter a(Context context, c c, com.target.ui.adapter.search.ProductSearchSuggestionAdapter.b b)
    {
        return new a(context, c, b);
    }
}
