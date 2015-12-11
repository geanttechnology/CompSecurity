// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.view.View;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.search:
//            NoMatchSearchResultsView

class this._cls0
    implements android.view.ultsView._cls3
{

    final NoMatchSearchResultsView this$0;

    public void onClick(View view)
    {
        ActivityUtils.startDealsActivity(NoMatchSearchResultsView.access$000(NoMatchSearchResultsView.this), null, null);
    }

    ()
    {
        this$0 = NoMatchSearchResultsView.this;
        super();
    }
}
