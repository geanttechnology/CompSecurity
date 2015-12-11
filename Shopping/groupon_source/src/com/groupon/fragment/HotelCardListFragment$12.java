// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class val.size extends ViewOutlineProvider
{

    final HotelCardListFragment this$0;
    final int val$size;

    public void getOutline(View view, Outline outline)
    {
        outline.setOval(0, 0, val$size, val$size);
    }

    ()
    {
        this$0 = final_hotelcardlistfragment;
        val$size = I.this;
        super();
    }
}
