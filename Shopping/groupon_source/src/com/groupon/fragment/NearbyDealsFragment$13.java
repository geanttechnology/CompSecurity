// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.util.LoggingUtils;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class this._cls0
    implements android.view.ment._cls13
{

    final NearbyDealsFragment this$0;

    public void onClick(View view)
    {
        loggingUtils.logClick("", "redo_search_area_click", "nearby_tab", "map");
        reloadButton.startSpinning();
        refresh(oadReason.userInitiated);
    }

    oadReason()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }
}
