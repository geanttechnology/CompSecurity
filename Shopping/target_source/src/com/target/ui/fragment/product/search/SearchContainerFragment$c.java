// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import com.target.mothership.util.o;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchContainerFragment

private class <init>
    implements android.support.v7.widget.rFragment.c
{

    final SearchContainerFragment this$0;

    public boolean a(String s)
    {
        SearchContainerFragment.a(SearchContainerFragment.this, s);
        return false;
    }

    public boolean b(String s)
    {
        if (SearchContainerFragment.b(SearchContainerFragment.this).length() == 1 && o.c(s))
        {
            SearchContainerFragment.b(SearchContainerFragment.this, s);
            SearchContainerFragment.c(SearchContainerFragment.this);
        } else
        if (SearchContainerFragment.b(SearchContainerFragment.this).length() <= 1 || !o.c(s))
        {
            SearchContainerFragment.c(SearchContainerFragment.this, s);
            return false;
        }
        return false;
    }

    private ()
    {
        this$0 = SearchContainerFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
