// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.map:
//            ZoneSelectionView

private static class otherZonesWrapper
{

    final View arrow;
    final View container;
    final TextView currentZone;
    final View currentZoneWrapper;
    final LinearLayout otherZonesWrapper;

    public (View view)
    {
        container = view.findViewById(0x7f1005f0);
        arrow = view.findViewById(0x7f1005f3);
        currentZone = (TextView)view.findViewById(0x7f1005f2);
        currentZoneWrapper = view.findViewById(0x7f1005f1);
        otherZonesWrapper = (LinearLayout)view.findViewById(0x7f1005f4);
    }
}
