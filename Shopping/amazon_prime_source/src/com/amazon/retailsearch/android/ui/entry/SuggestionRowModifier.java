// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionRow

public class SuggestionRowModifier
{

    private final List rows;

    public SuggestionRowModifier(List list)
    {
        rows = list;
    }

    public List getList()
    {
        return Collections.unmodifiableList(rows);
    }

    public RetailSearchSuggestionRow remove(int i)
    {
        return (RetailSearchSuggestionRow)rows.remove(i);
    }

    public boolean remove(RetailSearchSuggestionRow retailsearchsuggestionrow)
    {
        return rows.remove(retailsearchsuggestionrow);
    }

    public void sort(Comparator comparator)
    {
        Collections.sort(rows, comparator);
    }
}
