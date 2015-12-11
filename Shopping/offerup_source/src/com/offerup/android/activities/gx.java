// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.database.Cursor;
import android.support.v4.widget.k;
import android.support.v7.widget.SearchView;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity, hb

final class gx
    implements android.support.v7.widget.SearchView.OnSuggestionListener
{

    private SearchView a;
    private SearchActivity b;

    gx(SearchActivity searchactivity, SearchView searchview)
    {
        b = searchactivity;
        a = searchview;
        super();
    }

    public final boolean onSuggestionClick(int i)
    {
        Object obj = (Cursor)a.getSuggestionsAdapter().getItem(i);
        obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("suggest_text_1"));
        SearchActivity.b(b, false);
        SearchActivity.b(b, ((String) (obj)));
        com.offerup.android.activities.SearchActivity.a(b, hb.b);
        SearchActivity.h(b);
        com.offerup.android.activities.SearchActivity.a(b, true);
        com.offerup.android.tracker.a.a("ou_search_history_select", com.offerup.android.activities.SearchActivity.a(b));
        return true;
    }

    public final boolean onSuggestionSelect(int i)
    {
        return false;
    }
}
