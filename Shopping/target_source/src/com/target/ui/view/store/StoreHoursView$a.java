// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.store:
//            StoreHoursView

private class closedLabel
{

    TextView closedAllDay;
    View closedContainer;
    TextView closedHours;
    TextView closedLabel;
    TextView hoursDescription;
    View openContainer;
    TextView openHours;
    final StoreHoursView this$0;
    TextView todayDescription;

    public (View view)
    {
        this$0 = StoreHoursView.this;
        super();
        hoursDescription = (TextView)view.findViewById(0x7f1005c9);
        todayDescription = (TextView)view.findViewById(0x7f1005ca);
        closedAllDay = (TextView)view.findViewById(0x7f1005cb);
        openContainer = view.findViewById(0x7f1005cc);
        closedContainer = view.findViewById(0x7f1005ce);
        openHours = (TextView)view.findViewById(0x7f1005cd);
        closedHours = (TextView)view.findViewById(0x7f1005cf);
        closedLabel = (TextView)view.findViewById(0x7f1005d0);
    }
}
