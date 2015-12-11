// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.store.StoreHoursView;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreHoursDialogFragment

private static class hoursList
{

    public ListView hoursList;
    public TextView title;
    public StoreHoursView todayHours;
    public LinearLayout todayHoursContainer;

    public (View view)
    {
        title = (TextView)view.findViewById(0x7f100220);
        todayHoursContainer = (LinearLayout)view.findViewById(0x7f100221);
        todayHours = (StoreHoursView)view.findViewById(0x7f100222);
        hoursList = (ListView)view.findViewById(0x7f100223);
    }
}
