// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

class a
    implements android.view.eListener
{

    final SearchActivity a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        SearchActivity.j(a).removeOnLayoutChangeListener(this);
        SearchActivity.a(a, SearchActivity.k(a), false);
        view = (String)view.getTag();
        if (view != null)
        {
            a.c(view);
        }
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
