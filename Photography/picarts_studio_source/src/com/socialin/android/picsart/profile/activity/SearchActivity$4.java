// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.support.v4.view.MenuItemCompat;
import android.text.TextUtils;
import android.view.MenuItem;
import com.socialin.android.picsart.profile.adapter.ap;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SearchActivity, l

final class b
    implements Runnable
{

    private String a;
    private MenuItem b;
    private SearchActivity c;

    public final void run()
    {
        SearchActivity.a(c, a);
        for (int i = 0; i < SearchActivity.a(c).getCount(); i++)
        {
            ((l)SearchActivity.a(c).getItem(i)).a(true);
        }

        if (!TextUtils.isEmpty(SearchActivity.c(c)))
        {
            c.a();
        } else
        if (SearchActivity.c(c) != null && "".equals(SearchActivity.c(c)) && MenuItemCompat.isActionViewExpanded(b))
        {
            ((l)SearchActivity.a(c).getItem(SearchActivity.b(c))).k_();
            return;
        }
    }

    (SearchActivity searchactivity, String s, MenuItem menuitem)
    {
        c = searchactivity;
        a = s;
        b = menuitem;
        super();
    }
}
