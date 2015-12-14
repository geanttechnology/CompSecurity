// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity, s

class a
    implements android.view.ner
{

    final SearchActivity a;

    public void onClick(View view)
    {
        e.b(new Object[] {
            view.getTag()
        });
        SearchActivity.w(a).removeView((View)view.getParent());
        SearchActivity.a(a).requestFocus();
        SearchActivity.p(a).clear();
        for (int i = 0; i < SearchActivity.w(a).getChildCount(); i++)
        {
            view = SearchActivity.w(a).getChildAt(i);
            SearchActivity.p(a).add((String)view.getTag());
        }

        e.b(new Object[] {
            SearchActivity.p(a)
        });
        if (SearchActivity.p(a).isEmpty())
        {
            SearchActivity.l(a).c(true);
            SearchActivity.d(a).setText(null);
            SearchActivity.s(a).a();
            return;
        } else
        {
            SearchActivity.x(a);
            return;
        }
    }

    istView(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
