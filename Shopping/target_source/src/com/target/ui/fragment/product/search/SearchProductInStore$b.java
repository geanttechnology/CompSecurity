// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchProductInStore

private class <init>
    implements com.target.ui.util.chProductInStore.b
{

    final SearchProductInStore this$0;

    public void a(String s)
    {
        String s1 = SearchProductInStore.TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("Error loading type ahead suggestions");
        if (s == null)
        {
            s = "";
        }
        q.a(s1, stringbuilder.append(s).toString());
    }

    public void a(List list)
    {
        SearchProductInStore.a(SearchProductInStore.this, list);
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
