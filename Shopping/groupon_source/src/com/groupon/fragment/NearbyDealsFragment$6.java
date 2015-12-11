// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class this._cls0
    implements android.view.gment._cls6
{

    final NearbyDealsFragment this$0;

    public void onClick(View view)
    {
        nearbyMapRefreshButton.startSpinning();
        refresh(loadReason.userInitiated);
    }

    loadReason()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }
}
