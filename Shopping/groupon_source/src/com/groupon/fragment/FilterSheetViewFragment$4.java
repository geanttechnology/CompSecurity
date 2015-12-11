// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.events.ExpandFilterSheetEvent;
import com.groupon.tracking.mobile.sdk.Logger;
import com.squareup.otto.Bus;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

class this._cls0
    implements android.view.gment._cls4
{

    final FilterSheetViewFragment this$0;

    public void onClick(View view)
    {
        FilterSheetViewFragment.access$100(FilterSheetViewFragment.this).logClick("", "filtersheet_close_click", channel.toString(), Logger.NULL_NST_FIELD, Logger.NULL_NST_FIELD);
        FilterSheetViewFragment.access$000(FilterSheetViewFragment.this).post(new ExpandFilterSheetEvent(false));
    }

    ()
    {
        this$0 = FilterSheetViewFragment.this;
        super();
    }
}
