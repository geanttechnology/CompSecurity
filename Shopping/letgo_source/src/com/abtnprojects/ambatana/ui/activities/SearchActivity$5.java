// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.view.View;
import com.abtnprojects.ambatana.ui.widgets.c;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            SearchActivity

class a
    implements android.view.ner
{

    final SearchActivity a;

    public void onClick(View view)
    {
        view = (c)view;
        c c1;
        if (SearchActivity.d(a).contains(view))
        {
            SearchActivity.d(a).remove(view);
        } else
        {
            SearchActivity.d(a).add(view);
        }
        for (view = SearchActivity.e(a).iterator(); view.hasNext(); c1.setSelected(SearchActivity.d(a).contains(c1)))
        {
            c1 = (c)view.next();
        }

    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
