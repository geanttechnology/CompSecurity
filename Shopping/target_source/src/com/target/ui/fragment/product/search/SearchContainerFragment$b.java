// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.view.View;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchContainerFragment

private class <init>
    implements android.view.
{

    final SearchContainerFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        while (getView() == null || flag || SearchContainerFragment.b(SearchContainerFragment.this).length() == 1) 
        {
            return;
        }
        a.a(SearchContainerFragment.this);
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
