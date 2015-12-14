// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.view.widgetpool.common.CLMultiColumnListView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

class a
    implements Runnable
{

    final tView.setSelection a;

    public void run()
    {
        SearchActivity.a(a.a).setSelection(0);
    }

    tView(tView tview)
    {
        a = tview;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/SearchActivity$3

/* anonymous class */
    class SearchActivity._cls3
        implements android.view.View.OnClickListener
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
                SearchActivity.a(a).postDelayed(new SearchActivity._cls3._cls1(this), 300L);
            }
        }

            
            {
                a = searchactivity;
                super();
            }
    }

}
