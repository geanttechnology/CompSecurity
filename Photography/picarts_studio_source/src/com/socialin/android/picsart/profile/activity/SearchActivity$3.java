// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.support.v7.widget.SearchView;
import android.view.MenuItem;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SearchActivity

final class a
    implements android.support.v7.widget.yTextListener
{

    private MenuItem a;
    private SearchActivity b;

    public final boolean onQueryTextChange(String s)
    {
        SearchActivity.f(b);
        SearchActivity.a(b, a, s);
        return false;
    }

    public final boolean onQueryTextSubmit(String s)
    {
        SearchActivity.e(b).clearFocus();
        return false;
    }

    (SearchActivity searchactivity, MenuItem menuitem)
    {
        b = searchactivity;
        a = menuitem;
        super();
    }
}
