// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchProductEverywhere

private class <init> extends h
{

    final SearchProductEverywhere this$0;

    public String a()
    {
        return "TYPE_AHEAD_TAG";
    }

    public void a(x x1)
    {
        if (x1 != null)
        {
            x1 = x1.getMessage();
        } else
        {
            x1 = "";
        }
        if (o.g(x1))
        {
            q.a(SearchProductEverywhere.TAG, (new StringBuilder()).append("Error loading type ahead suggestions").append(x1).toString());
        }
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
    }

    public void a(List list)
    {
        SearchProductEverywhere.a(SearchProductEverywhere.this, list);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    private ()
    {
        this$0 = SearchProductEverywhere.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
