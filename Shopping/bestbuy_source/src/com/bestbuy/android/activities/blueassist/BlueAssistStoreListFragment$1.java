// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.blueassist;

import android.widget.AbsListView;
import bu;

// Referenced classes of package com.bestbuy.android.activities.blueassist:
//            BlueAssistStoreListFragment

class a
    implements android.widget.eAssistStoreListFragment._cls1
{

    final BlueAssistStoreListFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (BlueAssistStoreListFragment.a(a))
        {
            BlueAssistStoreListFragment.d(a).a(i, j, k, BlueAssistStoreListFragment.b(a), BlueAssistStoreListFragment.c(a));
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        BlueAssistStoreListFragment.a(a, true);
    }

    (BlueAssistStoreListFragment blueassiststorelistfragment)
    {
        a = blueassiststorelistfragment;
        super();
    }
}
