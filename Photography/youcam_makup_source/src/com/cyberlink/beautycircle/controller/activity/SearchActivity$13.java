// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.EditText;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, o, q

class a
    implements android.view.er
{

    final SearchActivity a;

    public void onClick(View view)
    {
        SearchActivity.c(a).setVisibility(0);
        SearchActivity.l(a).c(true);
        SearchActivity.m(a).setVisibility(8);
        SearchActivity.d(a).setVisibility(0);
        SearchActivity.d(a).requestFocus();
        a.showSoftInput(SearchActivity.d(a));
        if (SearchActivity.d(a) != null && SearchActivity.n(a) != null && SearchActivity.d(a).getText().toString().length() > 0)
        {
            SearchActivity.n(a).a(true);
        }
        SearchActivity.a(a).a(1);
        SearchActivity.a(a).setAdapter(SearchActivity.b(a));
        SearchActivity.a(a).setOnItemClickListener(SearchActivity.b(a));
        SearchActivity.o(a);
        SearchActivity.b(a).clear();
        SearchActivity.b(a).notifyDataSetChanged();
    }

    stView(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
