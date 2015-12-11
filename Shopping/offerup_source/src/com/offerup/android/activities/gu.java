// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.ar;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.x;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity

final class gu
    implements ar
{

    private MenuItem a;
    private MenuItem b;
    private MenuItem c;
    private SearchView d;
    private SearchActivity e;

    gu(SearchActivity searchactivity, MenuItem menuitem, MenuItem menuitem1, MenuItem menuitem2, SearchView searchview)
    {
        e = searchactivity;
        a = menuitem;
        b = menuitem1;
        c = menuitem2;
        d = searchview;
        super();
    }

    public final boolean a(MenuItem menuitem)
    {
        a.setVisible(false);
        b.setVisible(false);
        c.setVisible(false);
        if (StringUtils.isNotEmpty(com.offerup.android.activities.SearchActivity.a(e)))
        {
            d.setQuery(com.offerup.android.activities.SearchActivity.a(e), false);
        }
        com.offerup.android.tracker.a.e(SearchActivity.f(e));
        return true;
    }

    public final boolean b(MenuItem menuitem)
    {
        if (e.i.g())
        {
            e.i.e();
        } else
        if (StringUtils.isNotEmpty(com.offerup.android.activities.SearchActivity.a(e)))
        {
            com.offerup.android.tracker.a.a("ou_search_history_cancel", null);
            com.offerup.android.activities.SearchActivity.a(e, "");
            com.offerup.android.activities.SearchActivity.a(e, true);
        } else
        {
            d.setQuery(com.offerup.android.activities.SearchActivity.a(e), false);
        }
        SearchActivity.b(e, true);
        e.supportInvalidateOptionsMenu();
        return true;
    }
}
