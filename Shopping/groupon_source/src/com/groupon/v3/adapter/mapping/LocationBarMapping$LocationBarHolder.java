// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.LocationBar;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            LocationBarMapping

private class locationBar extends GrouponViewHolder
{

    protected LocationBar locationBar;
    final LocationBarMapping this$0;

    public I(View view)
    {
        this$0 = LocationBarMapping.this;
        super(view);
        locationBar = (LocationBar)view.findViewById(0x7f100289);
    }
}
