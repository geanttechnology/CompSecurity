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
        if (view != SearchActivity.f(a))
        {
            SearchActivity.a(a, view);
            Iterator iterator = SearchActivity.g(a).iterator();
            while (iterator.hasNext()) 
            {
                c c1 = (c)iterator.next();
                boolean flag;
                if (c1 == view)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                c1.setSelected(flag);
            }
        }
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
