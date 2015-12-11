// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.support.v7.widget.SearchView;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.fragment.product.search:
//            SearchContainerFragment

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (SearchContainerFragment.d(_fld0) == null)
        {
            return;
        } else
        {
            a.c(SearchContainerFragment.d(_fld0).findFocus());
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
