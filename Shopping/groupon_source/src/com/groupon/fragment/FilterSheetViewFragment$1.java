// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.events.ToggleFilterSheetEvent;
import com.groupon.models.search.domain.FilterSheetPresenter;
import com.squareup.otto.Bus;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

class this._cls0
    implements android.view.gment._cls1
{

    final FilterSheetViewFragment this$0;

    public void onClick(View view)
    {
        FilterSheetViewFragment.access$000(FilterSheetViewFragment.this).post(new ToggleFilterSheetEvent());
        FilterSheetViewFragment.access$200(FilterSheetViewFragment.this).filterButtonTapped(searchTerm, channel, FilterSheetViewFragment.access$100(FilterSheetViewFragment.this));
    }

    senter()
    {
        this$0 = FilterSheetViewFragment.this;
        super();
    }
}
