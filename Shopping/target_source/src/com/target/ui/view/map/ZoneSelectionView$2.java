// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;
import com.pointinside.model.Zone;

// Referenced classes of package com.target.ui.view.map:
//            ZoneSelectionView

class val.zoneIdx
    implements android.view.
{

    final ZoneSelectionView this$0;
    final Zone val$zone;
    final int val$zoneIdx;

    public void onClick(View view)
    {
        ZoneSelectionView.a(ZoneSelectionView.this, val$zone, val$zoneIdx);
    }

    ()
    {
        this$0 = final_zoneselectionview;
        val$zone = zone1;
        val$zoneIdx = I.this;
        super();
    }
}
