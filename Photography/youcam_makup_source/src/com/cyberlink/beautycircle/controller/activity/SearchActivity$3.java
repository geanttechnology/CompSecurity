// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

class a
    implements android.view.ner
{

    final SearchActivity a;

    public void onClick(View view)
    {
        if (SearchActivity.a(a) != null)
        {
            int i = SearchActivity.a(a).getFirstVisiblePosition();
            SearchActivity.c(a, true);
            if (i > 4)
            {
                SearchActivity.a(a).setSelection(4);
            }
            SearchActivity.a(a).h(0);
            SearchActivity.a(a).postDelayed(new Runnable() {

                final SearchActivity._cls3 a;

                public void run()
                {
                    SearchActivity.a(a.a).setSelection(0);
                }

            
            {
                a = SearchActivity._cls3.this;
                super();
            }
            }, 300L);
        }
    }

    _cls1.a(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
