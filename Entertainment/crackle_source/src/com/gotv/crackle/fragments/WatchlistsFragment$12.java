// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle.fragments:
//            WatchlistsFragment

class val.slot
    implements Runnable
{

    final WatchlistsFragment this$0;
    final ISlot val$slot;
    final ViewGroup val$vg;

    public void run()
    {
        try
        {
            ((ViewGroup)val$vg.getParent()).removeView(val$vg);
        }
        catch (Exception exception) { }
        WatchlistsFragment.access$500(WatchlistsFragment.this).setVisibility(0);
        WatchlistsFragment.access$500(WatchlistsFragment.this).addView(val$vg);
        WatchlistsFragment.access$500(WatchlistsFragment.this).requestLayout();
        val$slot.play();
    }

    ()
    {
        this$0 = final_watchlistsfragment;
        val$vg = viewgroup;
        val$slot = ISlot.this;
        super();
    }
}
