// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity

class val.slot
    implements Runnable
{

    final BaseMediaDetailsActivity this$0;
    final ISlot val$slot;
    final ViewGroup val$vg;

    public void run()
    {
        try
        {
            ((ViewGroup)val$vg.getParent()).removeView(val$vg);
        }
        catch (Exception exception) { }
        BaseMediaDetailsActivity.access$300(BaseMediaDetailsActivity.this).setVisibility(0);
        BaseMediaDetailsActivity.access$300(BaseMediaDetailsActivity.this).addView(val$vg);
        BaseMediaDetailsActivity.access$300(BaseMediaDetailsActivity.this).requestLayout();
        val$slot.play();
    }

    ()
    {
        this$0 = final_basemediadetailsactivity;
        val$vg = viewgroup;
        val$slot = ISlot.this;
        super();
    }
}
