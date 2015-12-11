// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.al;
import android.view.View;
import com.offerup.android.tracker.a;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity

final class gv
    implements android.view.View.OnFocusChangeListener
{

    private SearchActivity a;

    gv(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    public final void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            if (StringUtils.isEmpty(com.offerup.android.activities.SearchActivity.a(a)))
            {
                al.c(SearchActivity.g(a));
                return;
            } else
            {
                a.supportInvalidateOptionsMenu();
                return;
            }
        } else
        {
            com.offerup.android.tracker.a.a("ou_search_history_seen", null);
            return;
        }
    }
}
