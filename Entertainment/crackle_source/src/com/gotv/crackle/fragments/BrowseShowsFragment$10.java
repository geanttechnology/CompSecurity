// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseShowsFragment

class val.slot
    implements Runnable
{

    final BrowseShowsFragment this$0;
    final ISlot val$slot;
    final ViewGroup val$vg;

    public void run()
    {
        try
        {
            ((ViewGroup)val$vg.getParent()).removeView(val$vg);
        }
        catch (Exception exception) { }
        BrowseShowsFragment.access$700(BrowseShowsFragment.this).setVisibility(0);
        BrowseShowsFragment.access$700(BrowseShowsFragment.this).addView(val$vg);
        BrowseShowsFragment.access$700(BrowseShowsFragment.this).requestLayout();
        val$slot.play();
    }

    ()
    {
        this$0 = final_browseshowsfragment;
        val$vg = viewgroup;
        val$slot = ISlot.this;
        super();
    }
}
