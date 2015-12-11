// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Context;
import android.util.AttributeSet;
import com.emilsjolander.components.StickyListHeaders.StickyListHeadersListView;

public class SearchResultsListView extends StickyListHeadersListView
{

    public SearchResultsListView(Context context)
    {
        super(context);
    }

    public SearchResultsListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SearchResultsListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean hasFocus()
    {
        return true;
    }

    public boolean hasWindowFocus()
    {
        return true;
    }

    public boolean isFocused()
    {
        return true;
    }
}
