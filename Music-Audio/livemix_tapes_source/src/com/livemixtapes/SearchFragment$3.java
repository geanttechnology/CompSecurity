// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import com.livemixtapes.ui.widgets.SearchView;

// Referenced classes of package com.livemixtapes:
//            SearchFragment

class this._cls0
    implements Runnable
{

    final SearchFragment this$0;

    public void run()
    {
        runTextSearch(searchView.getQuery());
    }

    View()
    {
        this$0 = SearchFragment.this;
        super();
    }
}
