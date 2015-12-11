// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import com.target.ui.model.search.a;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchProductInStore, a

private class <init>
    implements com.target.ui.view.search.w.b
{

    final SearchProductInStore this$0;

    public void a(a a1)
    {
        com.target.ui.fragment.product.search.SearchProductInStore.a(SearchProductInStore.this, a1);
    }

    public void c_(String s)
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            com.target.ui.fragment.product.search.a.c(getActivity(), s);
            return;
        }
    }

    private ()
    {
        this$0 = SearchProductInStore.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
