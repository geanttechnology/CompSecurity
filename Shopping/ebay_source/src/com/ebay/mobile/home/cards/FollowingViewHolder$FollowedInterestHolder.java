// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;

// Referenced classes of package com.ebay.mobile.home.cards:
//            FollowingViewHolder

public static class blueDot extends ViewHolder
{

    public final View blueDot;
    public final TextView description;
    public final TextView title;

    public (View view)
    {
        super(view);
        title = (TextView)view.findViewById(0x7f1000de);
        description = (TextView)view.findViewById(0x7f1000df);
        blueDot = view.findViewById(0x7f1000dd);
    }
}
